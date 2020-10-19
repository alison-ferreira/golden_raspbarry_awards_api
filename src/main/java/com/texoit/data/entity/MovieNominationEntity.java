package com.texoit.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "movie_nomination")
@NamedNativeQuery(name = "MovieNomination.getWorstProducersWinners", resultClass = WorstProducersWinnersEntity.class, 
	query = "SELECT producer.names, first.year first, last.year last, last.year - first.year distance "
			+ "FROM (SELECT DISTINCT producers names FROM movie_nomination WHERE winner = true) producer "
			+ "JOIN (SELECT producers names, MIN(year) year FROM movie_nomination WHERE winner = true GROUP BY producers) first ON first.names = producer.names "
			+ "JOIN (SELECT producers names, MAX(year) year FROM movie_nomination WHERE winner = true GROUP BY producers) last ON last.names = producer.names")
public class MovieNominationEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private Integer year;
	private String title;
	private String studios;
	private String producers;
	private Boolean winner;
}
