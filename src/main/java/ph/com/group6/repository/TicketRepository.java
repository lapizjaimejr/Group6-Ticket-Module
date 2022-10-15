package ph.com.group6.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ph.com.group6.entity.Ticket;

public class TicketRepository implements ITicketRepository{
	
	@Autowired
	private JdbcTemplate template;
	
	public List<Ticket> getAll() {
		final String sql = "SELECT * FROM tickets";
		final List<Ticket> result = template.query(sql, BeanPropertyRowMapper.newInstance(Ticket.class));
		return result;
	}
	
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
