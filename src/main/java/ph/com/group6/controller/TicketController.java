package ph.com.group6.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ph.com.group6.service.ITicketService;

public class TicketController {
	private ITicketService service;
	
	@Autowired
	public TicketController(final ITicketService service) {
		this.service = service;
	}
	
	@PostMapping("/tickets")
	@ResponseBody
    public int save(final HttpServletRequest request) throws IOException
    {
        final BufferedReader body = request.getReader();
        return service.save(body);
    }
	
	@RequestMapping("/tickets/{id}")
	@ResponseBody
    public String execute(@PathVariable final int id)
    {
        return service.findByID(id);
    }
	
	@RequestMapping("/tickets")
	@ResponseBody
	public String getAll() {
		return service.getAll();
	}
	
	@DeleteMapping("/tickets/delete/{id}")
	@ResponseBody
	public int delete(@PathVariable final int id) throws IOException
	{		
		return service.deleteByID(id);
	}
	
}
