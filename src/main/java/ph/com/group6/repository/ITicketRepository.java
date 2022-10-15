package ph.com.group6.repository;

import ph.com.group6.entity.Ticket;

public interface ITicketRepository {
	public int save(final Ticket ticket);
	public int updateByID(final Ticket ticket);
	public int deleteByID(final int id);
}
