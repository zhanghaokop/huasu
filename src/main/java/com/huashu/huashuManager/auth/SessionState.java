package com.huashu.huashuManager.auth;

import com.huashu.huashuManager.model.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录状态Holder
 */
public class SessionState implements Serializable {

    private static final long serialVersionUID = 2601432654175467971L;
    private User user;

    private Map<String, Object> attr = new HashMap<>();

    public User getUser() {
        return user;
    }

    public SessionState setUser(User user) {
        this.user = user;
        return this;
    }

    public Object getAttr(String key){
        return attr.get(key);
    }

    public void addAttr(String key, Object value){
        attr.put(key, value);
    }
}
