package com.huashu.huashuManager.auth.ticket.model;

import com.huashu.huashuManager.model.User;

import java.io.Serializable;

public class SessionTicket implements Ticket, Serializable {

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
