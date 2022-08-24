package com.ltk.api.solar.tools.types;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SolarRangeDecimal extends SolarDecimal {
	
	protected BigDecimal max;
	
	protected BigDecimal min;
	
	@Deprecated
	public SolarRangeDecimal(String val) {
		super(val);
	}
	
	@Deprecated
	public SolarRangeDecimal(double val) {
		super(val);
	}
	
	@Deprecated
	public SolarRangeDecimal(BigInteger val) {
		super(val);
	}
	
	@Deprecated
	public SolarRangeDecimal(BigDecimal val) {
		super(val);
	}
	
	@Deprecated
	public SolarRangeDecimal(int val) {
		super(val);
	}
	
	@Deprecated
	public SolarRangeDecimal(long val) {
		super(val);
	}
	
	public SolarRangeDecimal(String val, int maxPrecision, int maxScale, Number min, Number max) {
		super(formatRange(val, maxPrecision, maxScale, min, max), maxPrecision, maxScale);
		setRange(min, max);
	}
	
	public SolarRangeDecimal(double val, int maxPrecision, int maxScale, Number min, Number max) {
		super(formatRange(val, maxPrecision, maxScale, min, max), maxPrecision, maxScale);
		setRange(min, max);
	}
	
	public SolarRangeDecimal(BigInteger val, int maxPrecision, Number min, Number max) {
		super(formatRange(val, maxPrecision, min, max), maxPrecision);
		setRange(min, max);
	}
	
	public SolarRangeDecimal(BigDecimal val, int maxPrecision, int maxScale, Number min, Number max) {
		super(formatRange(val, maxPrecision, maxScale, min, max), maxPrecision, maxScale);
		setRange(min, max);
	}
	
	public SolarRangeDecimal(int val, int maxPrecision, Number min, Number max) {
		super(formatRange(val, maxPrecision, min, max), maxPrecision);
		setRange(min, max);
	}
	
	public SolarRangeDecimal(long val, int maxPrecision, Number min, Number max) {
		super(formatRange(val, maxPrecision, min, max), maxPrecision);
		setRange(min, max);
	}
	
	protected static String formatRange(String val, int maxPrecision, int maxScale, Number min, Number max) {
		BigDecimal formatted = formatRange(valueOfOrZero(val), maxPrecision, maxScale, min, max);
		return formatted.toString();
	}
	
	protected static int formatRange(int val, int maxPrecision, Number min, Number max) {
		int formatted = format(val, maxPrecision);
		if(min != null) {
			int formattedMin = format(min.intValue(), maxPrecision);
			if(formatted < formattedMin) {
				formatted = formattedMin;
			}
		}
		if(max != null) {
			int formattedMax = format(max.intValue(), maxPrecision);
			if(formatted > formattedMax) {
				formatted = formattedMax;
			}
		}
		return formatted;
	}
	
	protected static long formatRange(long val, int maxPrecision, Number min, Number max) {
		long formatted = format(val, maxPrecision);
		if(min != null) {
			long formattedMin = format(min.longValue(), maxPrecision);
			if(formatted < formattedMin) {
				formatted = formattedMin;
			}
		}
		if(max != null) {
			long formattedMax = format(max.longValue(), maxPrecision);
			if(formatted > formattedMax) {
				formatted = formattedMax;
			}
		}
		return formatted;
	}
	
	protected static double formatRange(double val, int maxPrecision, int maxScale, Number min, Number max) {
		double formatted = format(val, maxPrecision, maxScale);
		if(min != null) {
			double formattedMin = format(min.doubleValue(), maxPrecision, maxScale);
			if(formatted < formattedMin) {
				formatted = formattedMin;
			}
		}
		if(max != null) {
			double formattedMax = format(max.doubleValue(), maxPrecision, maxScale);
			if(formatted > formattedMax) {
				formatted = formattedMax;
			}
		}
		return formatted;
	}
	
	protected static BigDecimal formatRange(BigDecimal val, int maxPrecision, int maxScale, Number min, Number max) {
		BigDecimal formatted = format(val, maxPrecision, maxScale);
		if(min != null) {
			BigDecimal formattedMin = format(valueOfOrZero(min), maxPrecision, maxScale);
			if(formatted.compareTo(formattedMin) < 0) {
				formatted = formattedMin;
			}
		}
		if(max != null) {
			BigDecimal formattedMax = format(valueOfOrZero(max), maxPrecision, maxScale);
			if(formatted.compareTo(formattedMax) > 0) {
				formatted = formattedMax;
			}
		}
		return formatted;
	}
	
	protected static BigInteger formatRange(BigInteger val, int maxPrecision, Number min, Number max) {
		BigInteger formatted = format(val, maxPrecision);
		if(min != null) {
			BigInteger formattedMin = format(new BigInteger(min.toString()), maxPrecision);
			if(formatted.compareTo(formattedMin) < 0) {
				formatted = formattedMin;
			}
		}
		if(max != null) {
			BigInteger formattedMax = format(new BigInteger(max.toString()), maxPrecision);
			if(formatted.compareTo(formattedMax) > 0) {
				formatted = formattedMax;
			}
		}
		return formatted;
	}
	
	private void setRange(Number min, Number max) {
		this.max = valueOfOrNull(min);
		this.min = valueOfOrNull(max);
	}
	
}
