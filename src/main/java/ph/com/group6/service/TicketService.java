package ph.com.group6.service;

import java.io.BufferedReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import ph.com.group6.entity.Ticket;
import ph.com.group6.repository.ITicketRepository;

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
	
}
