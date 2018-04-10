package com.huashu.huashuManager.auth.service;

import com.huashu.huashuManager.auth.ticket.model.SessionTicket;
import com.huashu.huashuManager.auth.ticket.model.Ticket;
import com.huashu.huashuManager.auth.ticket.repository.TicketRepository;
import com.huashu.huashuManager.common.utils.UUIDUtils;
import com.huashu.huashuManager.mapper.UserMapper;
import com.huashu.huashuManager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public User getUser(User user) {
        return userMapper.select(user);
    }

    @Override
    public Ticket validate(User user) {

        User query = getUser(user);
        if (query != null) {
            String generateId = "ticket-" + UUIDUtils.getUUID();
            Ticket ticket = new SessionTicket(generateId, query);
            ticketRepository.saveTicket(ticket);
            return ticket;
        }

        return null;
    }

    @Override
    public boolean logout(String ticketId) {
        return ticketRepository.deleteTicket(ticketId);
    }
}
