package com.huashu.huashuManager.auth;

import com.huashu.huashuManager.model.User;

/**
 * 用户登录状态保持
 */
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

    public static void clear(){
        SessionState older = get();
        if (older != null) {
            older.clearAttr();
        }
        holder.remove();
    }
}
