package xb.annotation_demo.anno;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class PasswordUtils {
    @UserCases.UserCase(id = "47",description = "password must contain at least one numberic")
    public boolean validatePassword(String password){
        return (password.matches("\\w*\\d\\w*"));
    }

    @UserCases.UserCase(id ="48")
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }


}
