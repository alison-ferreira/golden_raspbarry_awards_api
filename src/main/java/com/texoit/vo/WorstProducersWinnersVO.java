package com.texoit.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorstProducersWinnersVO {
	private String producer;
	private Integer previousWin;
	private Integer followingWin;
	private Integer interval;
}
