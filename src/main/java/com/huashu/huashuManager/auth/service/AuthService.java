package com.huashu.huashuManager.auth.service;

import com.huashu.huashuManager.auth.ticket.model.Ticket;
import com.huashu.huashuManager.model.User;

public interface AuthService {

    User getUser(User user);

    Ticket validate(User user);
}
