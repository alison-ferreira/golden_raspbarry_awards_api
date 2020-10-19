package com.texoit.util;

import java.util.ArrayList;
import java.util.List;

import com.texoit.data.entity.WorstProducersWinnersEntity;
import com.texoit.vo.WorstProducersWinnersVO;

public class ObjectsUtils {

	public static List<WorstProducersWinnersVO> parseWorstProducersWinnersEntityToVO (List<WorstProducersWinnersEntity> worstProducersWinnersEntityList) {
		List<WorstProducersWinnersVO> worstProducersWinnersVOList = new ArrayList<WorstProducersWinnersVO>();
		
		for (WorstProducersWinnersEntity worstProducersWinnersEntity : worstProducersWinnersEntityList) {
			WorstProducersWinnersVO worstProducersWinnersVO = new WorstProducersWinnersVO();
			
			worstProducersWinnersVO.setProducer(worstProducersWinnersEntity.getNames());
			worstProducersWinnersVO.setPreviousWin(worstProducersWinnersEntity.getFirst());
			worstProducersWinnersVO.setFollowingWin(worstProducersWinnersEntity.getLast());
			worstProducersWinnersVO.setInterval(worstProducersWinnersEntity.getDistance());
			
			worstProducersWinnersVOList.add(worstProducersWinnersVO);
		}
		
		return worstProducersWinnersVOList;
	}
	
}
