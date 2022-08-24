package com.ltk.api.solar.tools.types;


import java.math.BigDecimal;
import java.math.BigInteger;

public class SolarLongitude extends SolarRangeDecimal {
	
	protected static final int DEFAULT_SCALE = 6;
	protected static final int DEFAULT_PRECISION = 8;
	
	protected static final int MIN = -180;
	protected static final int MAX = 180;
	
	public SolarLongitude(String val) {
		super(val, DEFAULT_PRECISION, DEFAULT_SCALE, MIN, MAX);
	}
	
	public SolarLongitude(double val) {
		super(val, DEFAULT_PRECISION, DEFAULT_SCALE, MIN, MAX);
	}
	
	public SolarLongitude(BigInteger val) {
		super(val, DEFAULT_PRECISION, MIN, MAX);
	}
	
	public SolarLongitude(BigDecimal val) {
		super(val, DEFAULT_PRECISION, DEFAULT_SCALE, MIN, MAX);
	}
	
	public SolarLongitude(int val) {
		super(val, DEFAULT_PRECISION, MIN, MAX);
	}
	
	public SolarLongitude(long val) {
		super(val, DEFAULT_PRECISION, MIN, MAX);
	}
	
	/**
	 * Ocidente
	 */
	public boolean isSouth() {
		return ltZero();
	}
	
	/**
	 * Oriente
	 */
	public boolean isNorth() {
		return gtZero();
	}
	
}
