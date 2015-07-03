package com.hannahworld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "words")
public class Word {

	@Id
	@GeneratedValue
	private Integer id;

	private String aword;

	@Column(name = "week_number")
	private Integer weekNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAword() {
		return aword;
	}

	public void setAword(String aword) {
		this.aword = aword;
	}

	public Integer getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(Integer weekNumber) {
		this.weekNumber = weekNumber;
	}
}
