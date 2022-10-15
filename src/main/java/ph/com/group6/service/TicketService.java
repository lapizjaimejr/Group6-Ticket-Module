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
	
	public int save(BufferedReader body) {
		final Ticket ticket = gson.fromJson(body, Ticket.class);
		
		return repository.save(ticket);
	}

	public int update(Ticket ticket) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByID(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
