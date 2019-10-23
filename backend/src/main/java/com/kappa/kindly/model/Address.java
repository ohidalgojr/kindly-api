package com.kappa.kindly.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(updatable = false, nullable = false)
	private long id;

	@NotBlank(message = "Street's name cannot be blank or null.")
	private String streetName;
	
	@NotBlank(message = "Number cannot be blank or null.")
	private String number;
	
	@NotBlank(message = "City's name cannot be blank or null.")
	private String cityName;
	
	@NotBlank(message = "State's name cannot be blank or null.")
	private String stateName;

	@NotBlank(message = "State's UF cannot be blank or null.")
	private String UF;
	
	@Nullable
	private String neighborhoodName, postalCode, countryName;

	@OneToOne(mappedBy = "address")
	private User user;

	public Address() {

	}

	public Address(String streetName, String number, String cityName, String stateName) {
		this.streetName = streetName;
		this.number = number;
		this.cityName = cityName;
		this.stateName = stateName;
	}

	public Address(String streetName, String number, String neighborhoodName, String cityName, String stateName, String countryName, String postalCode) {
		this(
			streetName,
			number,
			cityName,
			stateName
		);

		this.neighborhoodName = neighborhoodName;
		this.countryName = countryName;
		this.postalCode = postalCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNeighborhoodName() {
		return neighborhoodName;
	}

	public void setNeighborhoodName(String neighborhoodName) {
		this.neighborhoodName = neighborhoodName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [cityName=" + cityName + ", countryName=" + countryName + ", id=" + id + ", neighborhoodName="
				+ neighborhoodName + ", number=" + number + ", postalCode=" + postalCode + ", stateName=" + stateName
				+ ", streetName=" + streetName + ", user=" + user + "]";
	}
}