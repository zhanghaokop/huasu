package com.huashu.huashuManager.auth.ticket.repository;

import com.huashu.huashuManager.auth.ticket.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisTicketRepository implements TicketRepository {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public String saveTicket(Ticket ticket) {
        redisTemplate.opsForValue().set(ticket.id(), ticket);
        return ticket.id();
    }

    @Override
    public boolean deleteTicket(String ticketId) {
        redisTemplate.delete(ticketId);
        return false;
    }

    @Override
    public Ticket getTicket(String ticketId) {
        return (Ticket) redisTemplate.opsForValue().get(ticketId);
    }

    @Override
    public boolean refresh(String ticketId) {
        return false;
    }
}
