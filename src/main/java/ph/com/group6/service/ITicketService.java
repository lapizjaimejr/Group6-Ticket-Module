package ph.com.group6.service;

import java.io.BufferedReader;

import ph.com.group6.entity.Ticket;

public interface ITicketService {
	public int save(final BufferedReader body);
	public int update(final Ticket ticket);
	public int deleteByID(final int id);
}
