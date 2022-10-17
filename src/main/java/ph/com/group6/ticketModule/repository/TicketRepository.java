package ph.com.group6.ticketModule.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ph.com.group6.ticketModule.entity.Ticket;

@Repository
public class TicketRepository implements ITicketRepository{
	
	@Autowired
	private JdbcTemplate template;
	
	public List<Ticket> getAll() {
		final String sql = "SELECT * FROM test.tickets";
		final List<Ticket> result = template.query(sql, BeanPropertyRowMapper.newInstance(Ticket.class));
		return result;
	}
	
	public Ticket findByID(final int id) {
		final String query = "SELECT * FROM test.tickets where ticketID=?";
        final Ticket result = template.queryForObject(query, BeanPropertyRowMapper.newInstance(Ticket.class), id);

        return result;
	}
	
	public int save(Ticket ticket) {
		final String sql = "INSERT INTO test.tickets (ticketID, assignee, status, subject, description, tracker) VALUES (?,?,?,?,?,?)";
		final int result = template.update(sql, ticket.getTicketID(), ticket.getAssignee(), ticket.getSubject(), ticket.getDescription(), ticket.getTracker());
		return result;
	}

	public int updateByID(Ticket ticket) {
		final String sql = "UPDATE test.tickets SET assignee=?, status=?, subject=?, description=?, tracker=? WHERE ticketID=?";
		final int result = template.update(sql, ticket.getAssignee(), ticket.getStatus(), ticket.getSubject(), ticket.getDescription(), ticket.getTracker(), ticket.getTicketID());
		return result;
	}


	public int updateAss(final int id, final String assignee) {
		final String sql = "UPDATE test.tickets SET assignee=? WHERE ticketID=?";
		final int result = template.update(sql, assignee, id);
		return result;
	}


	public int updateStat(final int id, final String status) {
		final String sql = "UPDATE test.tickets SET status=? WHERE ticketID=?";
		final int result = template.update(sql, status, id);
		return result;
	}
	
	public int deleteByID(int id) {
		final String sql = "DELETE FROM test.tickets WHERE ticketID=?";
		final int result = template.update(sql, id);
		
		return result;
	}
}
