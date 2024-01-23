package com.hibernatedemo;

import jakarta.persistence.*;


@Entity
@Table(name="city")

public class City {
	@Id
	@Column(name="ID")
	 private int id;
	
	@Column(name="CountryCode")
	private String countrycode;
	
	
	@Column(name="District")
    private String district;
	
	@Column(name="Population")
    private int population;
    
	@Column(name="Name")
    private String name;

    
    
	
	 public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	
}
