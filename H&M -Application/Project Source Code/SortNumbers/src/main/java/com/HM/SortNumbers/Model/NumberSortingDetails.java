package com.HM.SortNumbers.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class NumberSortingDetails {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private long countOfNumbers;

	@Column
	private String inputNumbers;

	@Column
	private String sortedNumbers;

	@Column
	private String sortingTime;

	@Column
	private String countOfChangeValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCountOfNumbers() {
		return countOfNumbers;
	}

	public void setCountOfNumbers(long countOfNumbers) {
		this.countOfNumbers = countOfNumbers;
	}

	public String getInputNumbers() {
		return inputNumbers;
	}

	public void setInputNumbers(String inputNumbers) {
		this.inputNumbers = inputNumbers;
	}

	public String getSortedNumbers() {
		return sortedNumbers;
	}

	public void setSortedNumbers(String sortedNumbers) {
		this.sortedNumbers = sortedNumbers;
	}

	public String getSortingTime() {
		return sortingTime;
	}

	public void setSortingTime(String sortingTime) {
		this.sortingTime = sortingTime;
	}

	public String getCountOfChangeValue() {
		return countOfChangeValue;
	}

	public void setCountOfChangeValue(String countOfChangeValue) {
		this.countOfChangeValue = countOfChangeValue;
	}

}
