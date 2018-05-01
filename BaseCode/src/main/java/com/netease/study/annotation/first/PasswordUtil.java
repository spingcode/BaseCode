package com.netease.study.annotation.first;

import java.util.List;

public class PasswordUtil {
    @SelfAnno(id=47,description="Password must contain at least one numeric")
    public boolean validatePassword(String password)
    {
        return password.matches("\\w*\\d\\w*");
    }

    @SelfAnno(id=48)
    public String encryptPassword(String password)
    {
        return new StringBuffer(password).reverse().toString();
    }
    @SelfAnno(id=49,description="New passwords can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String password)
    {
        return !prevPasswords.contains(password);
    }
}