package com.texoit.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class MovieNominationEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int Year;
	private String title;
	private String studios;
	private String producers;
	private boolean winner;
}
