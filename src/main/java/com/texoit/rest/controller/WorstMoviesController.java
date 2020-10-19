package com.texoit.rest.controller;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texoit.data.entity.WorstProducersWinnersEntity;
import com.texoit.data.repository.MovieNominationRepository;

@RestController
@RequestMapping("/worst-movies")
public class WorstMoviesController {
	
	@Autowired
	MovieNominationRepository movieNominationRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@GetMapping(path = "/min-and-max-awards-intervals", produces = MediaType.APPLICATION_JSON_VALUE)
	public WorstProducersWinnersEntity getWorstMoviesByMinAndMaxIntervals() {
		Query query = entityManager.createNamedQuery("MovieNomination.listWorstProducersWinners");
		List<WorstProducersWinnersEntity> worstProducersWinnersList = query.getResultList();
		
		// TODO criar uma lista com todos os registros em que a distancia seja a maior distancia da lista
		// TODO criar uma lista com todos os registros em que a distancia seja a menor distancia da lista porém maior que zero
		// TODO exibir as duas listas como min e max no retorno
		
		return worstProducersWinnersList.stream().max(Comparator.comparing(WorstProducersWinnersEntity::getDistance)).orElseThrow(NoSuchElementException::new);
	}
	
}
