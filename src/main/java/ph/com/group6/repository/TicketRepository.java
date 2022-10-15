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
	
	public Ticket findByID(final int id) {
		final String query = "SELECT * FROM tickets where ticketID=?";
        final Ticket result = template.queryForObject(query, BeanPropertyRowMapper.newInstance(Ticket.class), id);

        return result;
	}
	
	public int save(Ticket ticket) {
		final String sql = "INSERT INTO tickets (ticketID, assignee, status, subject, description, tracker) VALUES (?,?,?,?,?,?)";
		final int result = template.update(sql, ticket.getTicketID(), ticket.getAssignee(), ticket.getSubject(), ticket.getDescription(), ticket.getTracker());
		return result;
	}

	public int updateByID(Ticket ticket) {
		return 0;
	}

	public int deleteByID(int id) {
		final String sql = "DELETE FROM tickets WHERE ticketID=?";
		final int result = template.update(sql, id);
		
		return result;
	}
	
}
