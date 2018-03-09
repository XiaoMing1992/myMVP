package guyuanjun.com.mvp.login.model;

/**
 * Created by HP on 2018-3-9.
 */

public class UserModel implements IUser{
    String name;
    String password;

    public UserModel(String name, String password){
        this.name = name;
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int checkUserValidity(String name, String password) {
        if (name == null || password==null || !name.equals(getName()) || !password.equals(getPassword())){
            return -1;
        }
        return 0;
    }
}
