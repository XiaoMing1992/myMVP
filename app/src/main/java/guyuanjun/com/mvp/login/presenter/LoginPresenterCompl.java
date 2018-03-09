package guyuanjun.com.mvp.login.presenter;

import android.os.Handler;
import android.os.Looper;

import guyuanjun.com.mvp.login.model.IUser;
import guyuanjun.com.mvp.login.model.UserModel;
import guyuanjun.com.mvp.login.view.ILoginView;

/**
 * Created by HP on 2018-3-9.
 */

public class LoginPresenterCompl implements ILoginPresenter{
    ILoginView iLoginView;
    IUser iUser;
    Handler handler;
    public LoginPresenterCompl(ILoginView iLoginView){
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String password) {
        Boolean isLoginSuccess = true;
        final int code = iUser.checkUserValidity(name, password);
        if (code!=0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        }, 3000);
    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {
        iLoginView.onSetProgressBarVisibility(visiblity);
    }

    private void initUser(){
        iUser = new UserModel("mvp", "mvp");
    }
}
