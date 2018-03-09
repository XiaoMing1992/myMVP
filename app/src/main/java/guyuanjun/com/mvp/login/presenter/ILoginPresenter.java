package guyuanjun.com.mvp.login.presenter;

/**
 * Created by HP on 2018-3-9.
 */

public interface ILoginPresenter {
    void clear();
    void doLogin(String name, String password);
    void setProgressBarVisiblity(int visiblity);
}
