package ph.com.group6.ticketModule.service;

import java.io.BufferedReader;

import ph.com.group6.ticketModule.entity.Ticket;

public interface ITicketService {
	public String getAll();
	public int save(final Ticket ticket);
	public String findByID(final int id);
	public int update(final Ticket ticket);
	public int deleteByID(final int id);
	public int updateAss(final int id, final String assignee);
	public int updateStat(final int id, final String status);
}

