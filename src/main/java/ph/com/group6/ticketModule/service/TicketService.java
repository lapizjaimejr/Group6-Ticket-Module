package ph.com.group6.ticketModule.service;

import java.io.BufferedReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import ph.com.group6.ticketModule.entity.Ticket;
import ph.com.group6.ticketModule.repository.ITicketRepository;

@Service
public class TicketService implements ITicketService{
	
	private ITicketRepository repository;
	private Gson gson;
	
	@Autowired
	public TicketService(final ITicketRepository repository) {
		this.repository = repository;
		this.gson = new Gson();
	}
	
	public String getAll() {
		return gson.toJson(repository.getAll());
	}
	
	public int save(BufferedReader body) {
		final Ticket ticket = gson.fromJson(body, Ticket.class);
		
		return repository.save(ticket);
	}

	public int update(Ticket ticket) {
		return repository.updateByID(ticket);
	}

	public int deleteByID(int id) {
		return repository.deleteByID(id);
	}

	public String findByID(final int id) {
		return gson.toJson(repository.findByID(id));
	}

	
	public int updateAss(final int id, final String assignee) {
		return repository.updateAss(id, assignee);
	}

	
	public int updateStat(final int id, final String status) {
		return repository.updateStat(id, status);
	}
	
}
