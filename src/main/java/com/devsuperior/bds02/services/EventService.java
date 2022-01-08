package com.devsuperior.bds02.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository repository;

	@Transactional(readOnly = true)
	public List<EventDTO> findAll() {
		List<Event> list = repository.findAll();
		
		return list.stream().map(x -> new EventDTO(x)).collect(Collectors.toList());
	}
}
