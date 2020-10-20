package com.texoit.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texoit.model.WorstProducersWinnersModel;
import com.texoit.vo.WorstProducersWinnersVO;

@RestController
@RequestMapping("/worst-movies")
public class WorstMoviesController {
	
	@Autowired
	WorstProducersWinnersModel worstProducersWinnersModel;
	
	@GetMapping(path = "/min-and-max-awards-intervals", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, List<WorstProducersWinnersVO>> getWorstMoviesByMinAndMaxIntervals() {
		List<WorstProducersWinnersVO> worstProducersWinnersList = worstProducersWinnersModel.getWorstProducersWinnersList();
		
		// minInterval operations
		Integer minInterval = worstProducersWinnersList.stream()
				.filter(p -> p.getInterval() > 0)
				.mapToInt(p -> p.getInterval())
				.min().orElse(Integer.MIN_VALUE);
		
		List<WorstProducersWinnersVO> minWorstProducersWinnersList = worstProducersWinnersList.stream()
				.filter(p -> p.getInterval().equals(minInterval)).collect(Collectors.toList());
		
		// maxInterval operations
		Integer maxInterval = worstProducersWinnersList.stream()
				.filter(p -> p.getInterval() > 0)
				.mapToInt(p -> p.getInterval())
				.max().orElse(Integer.MAX_VALUE);
		
		List<WorstProducersWinnersVO> maxWorstProducersWinnersList = worstProducersWinnersList.stream()
				.filter(p -> p.getInterval().equals(maxInterval)).collect(Collectors.toList());
		
		// final result mount
		Map<String, List<WorstProducersWinnersVO>> result = new HashMap<String, List<WorstProducersWinnersVO>>();
		result.put("min", minWorstProducersWinnersList);
		result.put("max", maxWorstProducersWinnersList);
		
		return result;
	}
	
}
