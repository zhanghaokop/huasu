package com.huashu.huashuManager.auth;

import com.huashu.huashuManager.model.User;

public class SessionStateHolder {

    private static ThreadLocal<User> holder = new ThreadLocal<>();

    public static void set(User user){
        holder.set(user);
    }

    public static User get(){
        return holder.get();
    }
}
