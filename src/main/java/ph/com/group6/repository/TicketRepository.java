package ph.com.group6.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import ph.com.group6.entity.Ticket;

public class TicketRepository implements ITicketRepository{
	
	@Autowired
	private JdbcTemplate template;
	
	public int save(Ticket ticket) {
		final String sql = "INSERT INTO tickets (ticketID, assignee, status, subject, description, tracker) VALUES (?,?,?,?,?,?)";
		final int result = template.update(sql, ticket.getTicketID(), ticket.getAssignee(), ticket.getSubject(), ticket.getDescription(), ticket.getTracker());
		return result;
	}

	public int updateByID(Ticket ticket) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByID(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
