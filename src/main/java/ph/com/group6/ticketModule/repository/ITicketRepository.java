package ph.com.group6.ticketModule.repository;

import java.util.List;

import ph.com.group6.ticketModule.entity.Ticket;

public interface ITicketRepository {
	public List<Ticket> getAll(); 
	public Ticket findByID(final int id);
	public int save(final Ticket ticket);
	public int updateByID(final Ticket ticket);
	public int updateAss(final int id, final String assignee);
	public int updateStat(final int id, final String status);
	public int deleteByID(final int id);
}
