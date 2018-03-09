package guyuanjun.com.mvp.login.model;

/**
 * Created by HP on 2018-3-9.
 */

public interface IUser {
    String getName();
    String getPassword();
    int checkUserValidity(String name, String password);
}
