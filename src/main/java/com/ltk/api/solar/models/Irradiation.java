package com.ltk.api.solar.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "IRRADIATION")
public class Irradiation extends BaseEntity {
	
	@Column(name = "LAT",
	        precision = 8,
	        scale = 6,
	        nullable = false)
	private BigDecimal lat;
	
	@Column(name = "LNG",
	        precision = 8,
	        scale = 6,
	        nullable = false)
	private BigDecimal lng;
	
	@Column(name = "JAN",
	        scale = 6,
	        precision = 4,
	        nullable = false)
	private BigDecimal jan;
	
	@Column(name = "FEB",
	        scale = 6,
	        precision = 4,
	        nullable = false)
	private BigDecimal feb;
	
	@Column(name = "MAR",
	        scale = 6,
	        precision = 4,
	        nullable = false)
	private BigDecimal mar;
	
	@Column(name = "APR",
	        scale = 6,
	        precision = 4,
	        nullable = false)
	private BigDecimal apr;
	
	@Column(name = "MAY",
	        scale = 6,
	        precision = 4,
	        nullable = false)
	private BigDecimal may;
	
	@Column(name = "JUN",
	        scale = 6,
	        precision = 4,
	        nullable = false)
	private BigDecimal jun;
	
	@Column(name = "JUL",
	        scale = 6,
	        precision = 4,
	        nullable = false)
	private BigDecimal jul;
	
	@Column(name = "AUG",
	        scale = 6,
	        precision = 4,
	        nullable = false)
	private BigDecimal aug;
	
	@Column(name = "SEP",
	        scale = 6,
	        precision = 4,
	        nullable = false)
	private BigDecimal sep;
	
	@Column(name = "OCT",
	        scale = 6,
	        precision = 4,
	        nullable = false)
	private BigDecimal oct;
	
	@Column(name = "NOV",
	        scale = 6,
	        precision = 4,
	        nullable = false)
	private BigDecimal nov;
	
	@Column(name = "DEC",
	        scale = 6,
	        precision = 4,
	        nullable = false)
	private BigDecimal dec;
	
}
