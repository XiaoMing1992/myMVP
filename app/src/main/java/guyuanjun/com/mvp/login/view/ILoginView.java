package guyuanjun.com.mvp.login.view;

/**
 * Created by HP on 2018-3-9.
 */

public interface ILoginView {
    void onClearText();
    void onLoginResult(Boolean result, int code);
    void onSetProgressBarVisibility(int visibility);
}
