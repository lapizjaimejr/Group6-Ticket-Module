package ph.com.group6.ticketModule.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ph.com.group6.ticketModule.entity.Ticket;
import ph.com.group6.ticketModule.service.ITicketService;

@RestController
public class TicketController {
	private ITicketService service;
	
	@Autowired
	public TicketController(final ITicketService service) {
		this.service = service;
	}
	
	@PostMapping("/tickets/save")
    public int save(@RequestParam("ticketID") final int ticketID, @RequestParam("assignee") final String assignee, @RequestParam("status") final String status, @RequestParam("subject") final String subject, @RequestParam("description") final String description, @RequestParam("tracker") final String tracker) throws IOException
    {
//        final BufferedReader body = request.getReader();
        return service.save(new Ticket(ticketID, assignee, status, subject, description, tracker));
    }
	
	@RequestMapping("/tickets/{id}")
    public String getTicket(@PathVariable final int id)
    {
        return service.findByID(id);
    }
	
	@RequestMapping("/tickets")
	public String getAll() {
		return service.getAll();
	}
	
	@DeleteMapping("/tickets/delete/{id}")
	public int delete(@PathVariable final int id) throws IOException
	{		
		return service.deleteByID(id);
	}
	
	@PostMapping("/tickets/update/{id}")
	public int updateTicket(@PathVariable final int id, @RequestParam("assignee") final String assignee, @RequestParam("status") final String status, @RequestParam("subject") final String subject, @RequestParam("description") final String description, @RequestParam("tracker") final String tracker) throws IOException {
		return service.update(new Ticket(id, assignee, status, subject, description, tracker));
	}
	
	@PostMapping("/tickets/updateAss/{id}")
	public int updateAss(@PathVariable final int id, @RequestParam("assignee") final String assignee) throws IOException {
		return service.updateAss(id, assignee);
	}
	
	
	@PostMapping("/tickets/updateStat/{id}")
	public int updateStat(@PathVariable final int id, @RequestParam("status") final String status) throws IOException {
		return service.updateStat(id, status);
	}
	
	
}

