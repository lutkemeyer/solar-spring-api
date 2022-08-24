package com.ltk.api.solar.tools.types;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class SolarDecimal extends BigDecimal {
	
	protected static final int DEFAULT_DECIMAL_MAX_SCALE = 10;
	
	protected static final int DEFAULT_DECIMAL_MAX_PRECISION = 30;
	
	protected static final int DEFAULT_INTEGER_MAX_SCALE = 0;
	protected static final int DEFAULT_INTEGER_MAX_PRECISION = 15;
	
	protected int maxScale = DEFAULT_DECIMAL_MAX_SCALE;
	
	protected int maxPrecision = DEFAULT_DECIMAL_MAX_PRECISION;
	
	public SolarDecimal(String val, int maxPrecision, int maxScale) {
		super(format(val, maxPrecision, maxScale));
		this.maxScale = maxScale;
		this.maxPrecision = maxPrecision;
	}
	
	public SolarDecimal(double val, int maxPrecision, int maxScale) {
		super(format(val, maxPrecision,  maxScale));
		this.maxScale = maxScale;
		this.maxPrecision = maxPrecision;
	}
	
	public SolarDecimal(BigInteger val, int maxPrecision) {
		super(format(val, maxPrecision));
		this.maxScale = DEFAULT_INTEGER_MAX_SCALE;
		this.maxPrecision = maxPrecision;
	}
	
	public SolarDecimal(BigDecimal val, int maxPrecision, int maxScale) {
		super(format(val, maxPrecision,  maxScale).toString());
		this.maxScale = maxScale;
		this.maxPrecision = maxPrecision;
	}
	
	public SolarDecimal(int val, int maxPrecision) {
		super(format(val, maxPrecision));
		this.maxScale = DEFAULT_INTEGER_MAX_SCALE;
		this.maxPrecision = maxPrecision;
	}
	
	public SolarDecimal(long val, int maxPrecision) {
		super(format(val, maxPrecision));
		this.maxScale = DEFAULT_INTEGER_MAX_SCALE;
		this.maxPrecision = maxPrecision;
	}
	
	@Deprecated
	public SolarDecimal(String val) {
		super(format(val, DEFAULT_DECIMAL_MAX_PRECISION, DEFAULT_DECIMAL_MAX_SCALE));
	}
	
	@Deprecated
	public SolarDecimal(double val) {
		super(format(val, DEFAULT_DECIMAL_MAX_PRECISION, DEFAULT_DECIMAL_MAX_SCALE));
	}
	
	@Deprecated
	public SolarDecimal(BigDecimal val) {
		super(format(val, DEFAULT_DECIMAL_MAX_PRECISION, DEFAULT_DECIMAL_MAX_SCALE).toString());
	}
	
	@Deprecated
	public SolarDecimal(BigInteger val) {
		super(format(val, DEFAULT_INTEGER_MAX_PRECISION));
	}
	
	@Deprecated
	public SolarDecimal(int val) {
		super(format(val, DEFAULT_INTEGER_MAX_PRECISION));
	}
	
	@Deprecated
	public SolarDecimal(long val) {
		super(format(val, DEFAULT_INTEGER_MAX_PRECISION));
	}
	
	protected static long format(long v, int maxPrecision) {
		return format(new BigDecimal(v), maxPrecision, DEFAULT_INTEGER_MAX_SCALE).longValue();
	}
	
	protected static double format(double v, int maxPrecision, int maxScale) {
		return format(new BigDecimal(v), maxPrecision,  maxScale).doubleValue();
	}
	
	protected static int format(int v, int maxPrecision) {
		return format(new BigDecimal(v), maxPrecision, DEFAULT_INTEGER_MAX_SCALE).intValue();
	}
	
	protected static BigDecimal format(BigDecimal v, int maxPrecision, int maxScale) {
		BigDecimal value = v;
		if(value.scale() > maxScale) {
			value = value.setScale(maxScale, RoundingMode.HALF_DOWN);
		}
		return value;
	}
	
	protected static String format(String v, int maxPrecision, int maxScale) {
		return format(new BigDecimal(v), maxPrecision,  maxScale).toString();
	}
	
	protected static BigInteger format(BigInteger v, int maxPrecision) {
		return format(new BigDecimal(v), maxPrecision, DEFAULT_INTEGER_MAX_SCALE).toBigInteger();
	}
	
	public SolarDecimal maxScale(int maxScale) {
		return new SolarDecimal(this, maxPrecision,  maxScale);
	}
	
	public SolarDecimal maxPrecision(int maxPrecision) {
		return new SolarDecimal(this, maxPrecision,  maxScale);
	}
	
	@Deprecated
	@Override
	public BigDecimal add(BigDecimal augend) {
		BigDecimal result = super.add(augend != null ? augend : ZERO);
		return format(result, maxPrecision,  maxScale);
	}
	
	public SolarDecimal sum(Number number) {
		return new SolarDecimal(add(valueOfOrZero(number)));
	}
	
	@Deprecated
	@Override
	public BigDecimal subtract(BigDecimal subtrahend) {
		BigDecimal result = super.subtract(subtrahend != null ? subtrahend : ZERO);
		return format(result, maxPrecision,  maxScale);
	}
	
	public SolarDecimal sub(Number number) {
		return new SolarDecimal(subtract(valueOfOrZero(number)));
	}
	
	@Deprecated
	@Override
	public BigDecimal multiply(BigDecimal multiplicand) {
		BigDecimal result = super.multiply(multiplicand != null ? multiplicand : ZERO);
		return format(result, maxPrecision,  maxScale);
	}
	
	public SolarDecimal mult(Number number) {
		return new SolarDecimal(multiply(valueOfOrZero(number)));
	}
	
	@Deprecated
	@Override
	public BigDecimal divide(BigDecimal divisor) {
		BigDecimal result;
		if(divisor == null || divisor.compareTo(ZERO) == 0) {
			result = ZERO;
		} else {
			result = super.divide(divisor, RoundingMode.HALF_DOWN);
		}
		return format(result, maxPrecision,  maxScale);
	}
	
	public SolarDecimal div(Number number) {
		return new SolarDecimal(divide(valueOfOrZero(number)));
	}
	
	@Nullable
	public static BigDecimal valueOfOrNull(Number number) {
		try {
			return new BigDecimal(number.toString());
		} catch(Exception e) {
			return null;
		}
	}
	
	@Nullable
	public static SolarDecimal valueOfOrNull(Number number, int maxPrecision, int maxScale) {
		try {
			return new SolarDecimal(valueOfOrNull(number), maxPrecision,  maxScale);
		} catch(Exception e) {
			return null;
		}
	}
	
	@Nullable
	public static BigDecimal valueOfOrNull(String str) {
		try {
			return new BigDecimal(str);
		} catch(Exception e) {
			return null;
		}
	}
	
	@Nullable
	public static SolarDecimal valueOfOrNull(String str, int maxPrecision, int maxScale) {
		try {
			return new SolarDecimal(str, maxPrecision,  maxScale);
		} catch(Exception e) {
			return null;
		}
	}
	
	@NonNull
	public static BigDecimal valueOfOrZero(Number number) {
		BigDecimal result = valueOfOrNull(number);
		return result != null ? result : new SolarDecimal(ZERO);
	}
	
	@NonNull
	public static SolarDecimal valueOfOrZero(Number number, int maxPrecision, int maxScale) {
		SolarDecimal result = valueOfOrNull(number, maxPrecision,  maxScale);
		return result != null ? result : new SolarDecimal(ZERO);
	}
	
	@NonNull
	public static BigDecimal valueOfOrZero(String str) {
		BigDecimal result = valueOfOrNull(str);
		return result != null ? result : new SolarDecimal(ZERO);
	}
	
	@NonNull
	public static SolarDecimal valueOfOrZero(String str, int maxPrecision, int maxScale) {
		SolarDecimal result = valueOfOrNull(str, maxPrecision,  maxScale);
		return result != null ? result : new SolarDecimal(ZERO);
	}
	
	public boolean isZero() {
		return this.compareTo(BigDecimal.ZERO) == 0;
	}
	
	public boolean geZero() {
		return this.compareTo(BigDecimal.ZERO) >= 0;
	}
	
	public boolean gtZero() {
		return this.compareTo(BigDecimal.ZERO) > 0;
	}
	
	public boolean leZero() {
		return this.compareTo(BigDecimal.ZERO) <= 0;
	}
	
	public boolean ltZero() {
		return this.compareTo(BigDecimal.ZERO) < 0;
	}
	
	public boolean isOne() {
		return this.compareTo(BigDecimal.ONE) == 0;
	}
	
	public boolean geOne() {
		return this.compareTo(BigDecimal.ONE) >= 0;
	}
	
	public boolean gtOne() {
		return this.compareTo(BigDecimal.ONE) > 0;
	}
	
	public boolean leOne() {
		return this.compareTo(BigDecimal.ONE) <= 0;
	}
	
	public boolean ltOne() {
		return this.compareTo(BigDecimal.ONE) < 0;
	}
	
}
