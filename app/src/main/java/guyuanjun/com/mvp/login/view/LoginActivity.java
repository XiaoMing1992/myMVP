package guyuanjun.com.mvp.login.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import guyuanjun.com.mvp.R;
import guyuanjun.com.mvp.login.presenter.ILoginPresenter;
import guyuanjun.com.mvp.login.presenter.LoginPresenterCompl;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener{
    private EditText editUser;
    private EditText editPass;
	private Button   btnLogin;
	private Button btnClear;

    private ProgressBar progressBar;

    ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
        init();
    }

    private void initView(){
        editUser = (EditText)findViewById(R.id.editUser);
        editPass = (EditText)findViewById(R.id.editPass);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnClear = (Button)findViewById(R.id.btnClear);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
    }

    private void initListener(){
        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    private void init(){
        loginPresenter = new LoginPresenterCompl(this);
        loginPresenter.setProgressBarVisiblity(View.GONE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnClear:
                loginPresenter.clear();
                break;
            case R.id.btnLogin:
                loginPresenter.setProgressBarVisiblity(View.VISIBLE);
                btnLogin.setEnabled(false);
                btnClear.setEnabled(false);
                loginPresenter.doLogin(editUser.getText().toString(), editPass.getText().toString());
                break;
        }
    }

    @Override
    public void onClearText() {
        editUser.setText("");
        editPass.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        loginPresenter.setProgressBarVisiblity(View.GONE);
        btnLogin.setEnabled(true);
        btnClear.setEnabled(true);
        if (result){
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Login Fail, code = "+code, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }
}
