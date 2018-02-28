package com.huashu.huashuManager.auth.ticket.repository;

import com.huashu.huashuManager.auth.ticket.model.Ticket;

public interface TicketRepository {

    String saveTicket(Ticket ticket);

    boolean deleteTicket(String ticketId);

    Ticket getTicket(String ticketId);

    boolean refresh(String ticketId);
}
