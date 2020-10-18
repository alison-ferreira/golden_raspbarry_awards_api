package com.texoit.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texoit.data.entity.MovieNominationEntity;
import com.texoit.data.repository.MovieNominationRepository;

@RestController
@RequestMapping("/worst-movies")
public class WorstMoviesController {
	
	@Autowired
	MovieNominationRepository repo;

	@GetMapping(path = "/min-and-max-awards-intervals", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<MovieNominationEntity> getWorstMoviesByMinAndMaxIntervals() {
		return repo.findAll();
	}
	
}
