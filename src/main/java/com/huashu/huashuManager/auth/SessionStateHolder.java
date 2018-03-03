package com.huashu.huashuManager.auth;

import com.huashu.huashuManager.model.User;

public class SessionStateHolder {

    private static ThreadLocal<SessionState> holder = new ThreadLocal<>();

    public static void set(SessionState state){
        holder.set(state);
    }

    public static SessionState get(){
        return holder.get();
    }

    public static User getUser(){
        SessionState state = get();
        return state == null ? null : state.getUser();
    }
}
