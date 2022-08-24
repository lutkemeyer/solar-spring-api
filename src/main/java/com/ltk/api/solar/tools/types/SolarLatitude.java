package com.ltk.api.solar.tools.types;


import java.math.BigDecimal;
import java.math.BigInteger;

public class SolarLatitude extends SolarRangeDecimal {
	
	protected static final int DEFAULT_SCALE = 6;
	protected static final int DEFAULT_PRECISION = 8;
	
	protected static final int MIN = -90;
	protected static final int MAX = 90;
	
	public SolarLatitude(String val) {
		super(val, DEFAULT_PRECISION, DEFAULT_SCALE, MIN, MAX);
	}
	
	public SolarLatitude(double val) {
		super(val, DEFAULT_PRECISION, DEFAULT_SCALE, MIN, MAX);
	}
	
	public SolarLatitude(BigInteger val) {
		super(val, DEFAULT_PRECISION, MIN, MAX);
	}
	
	public SolarLatitude(BigDecimal val) {
		super(val, DEFAULT_PRECISION, DEFAULT_SCALE, MIN, MAX);
	}
	
	public SolarLatitude(int val) {
		super(val, DEFAULT_PRECISION, MIN, MAX);
	}
	
	public SolarLatitude(long val) {
		super(val, DEFAULT_PRECISION, MIN, MAX);
	}
	
	/**
	 * Ocidente
	 */
	public boolean isWestern() {
		return ltZero();
	}
	
	/**
	 * Oriente
	 */
	public boolean isEast() {
		return gtZero();
	}
	
}
