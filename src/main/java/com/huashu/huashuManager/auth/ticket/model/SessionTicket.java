package com.huashu.huashuManager.auth.ticket.model;

import com.huashu.huashuManager.model.User;

import java.io.Serializable;

public class SessionTicket implements Ticket, Serializable {

    private static final long serialVersionUID = 6395160158283625058L;
    private String ticketId;

    private User user;

    public SessionTicket(String ticketId, User user) {
        this.ticketId = ticketId;
        this.user = user;
    }

    @Override
    public String id() {
        return ticketId;
    }

    @Override
    public User getUser() {
        return user;
    }

}
