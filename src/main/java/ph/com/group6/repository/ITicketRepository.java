package ph.com.group6.repository;

import java.util.List;

import ph.com.group6.entity.Ticket;

public interface ITicketRepository {
	public List<Ticket> getAll(); 
	public int save(final Ticket ticket);
	public int updateByID(final Ticket ticket);
	public int deleteByID(final int id);
}
