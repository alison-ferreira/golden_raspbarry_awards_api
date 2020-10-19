package com.texoit.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class WorstProducersWinnersEntity {
	@Id
	private String names;
	private Integer first;
	private Integer last;
	private Integer distance;
}
