package com.texoit.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		Integer minInterval = null;
		Integer maxInterval = null;
		
		List<WorstProducersWinnersVO> minWorstProducersWinnersList = new ArrayList<WorstProducersWinnersVO>();
		List<WorstProducersWinnersVO> maxWorstProducersWinnersList = new ArrayList<WorstProducersWinnersVO>();
		
		for (WorstProducersWinnersVO worstProducersWinners : worstProducersWinnersList) {
			int interval = worstProducersWinners.getInterval();
			
			if (interval > 0) {
				// minInterval operations
				if (minInterval == null) {
					minInterval = interval;
				}
				
				if (interval < minInterval ) {
					minInterval = interval;
					minWorstProducersWinnersList = new ArrayList<WorstProducersWinnersVO>();
				}
				
				if (interval <= minInterval ) {
					minWorstProducersWinnersList.add(worstProducersWinners);
				}
				
				// maxInterval operations
				if (maxInterval == null) {
					maxInterval = interval;
				}
				
				if (interval > maxInterval) {
					maxInterval = interval;
					maxWorstProducersWinnersList = new ArrayList<WorstProducersWinnersVO>();
				}
				
				if (interval >= maxInterval ) {
					maxWorstProducersWinnersList.add(worstProducersWinners);
				}
			}
			
		}
		
		Map<String, List<WorstProducersWinnersVO>> result = new HashMap<String, List<WorstProducersWinnersVO>>();
		result.put("min", minWorstProducersWinnersList);
		result.put("max", maxWorstProducersWinnersList);
		
		return result;
	}
	
}
