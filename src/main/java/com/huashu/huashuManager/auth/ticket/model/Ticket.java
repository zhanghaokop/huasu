package com.huashu.huashuManager.auth.ticket.model;

import com.huashu.huashuManager.model.User;

public interface Ticket {

    String id();

    User getUser();
}
