package com.texoit.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieNominationVO {
	private Integer year;
	private String title;
	private String studios;
	private String producers;
	private Boolean winner;
}
