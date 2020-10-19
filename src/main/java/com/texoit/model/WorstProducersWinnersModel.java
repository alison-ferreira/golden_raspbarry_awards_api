package com.texoit.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.texoit.data.entity.WorstProducersWinnersEntity;
import com.texoit.util.ObjectsUtils;
import com.texoit.vo.WorstProducersWinnersVO;

@Service
public class WorstProducersWinnersModel {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<WorstProducersWinnersVO> getWorstProducersWinnersList() {
		TypedQuery<WorstProducersWinnersEntity> typedQuery = entityManager
				.createNamedQuery("MovieNomination.getWorstProducersWinners", WorstProducersWinnersEntity.class);
		
		List<WorstProducersWinnersEntity> worstProducersWinnersEntityList = typedQuery.getResultList();
		
		return ObjectsUtils.parseWorstProducersWinnersEntityToVO(worstProducersWinnersEntityList);
	}

}
