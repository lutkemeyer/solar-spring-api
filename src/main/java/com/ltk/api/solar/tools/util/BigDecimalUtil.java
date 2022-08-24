package com.ltk.api.solar.tools.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class BigDecimalUtil {
	
	public static final BigDecimal ZERO = new BigDecimal("0");
	public static final BigDecimal ONE = new BigDecimal("1");
	public static final BigDecimal TWO = new BigDecimal("2");
	public static final BigDecimal THREE = new BigDecimal("3");
	public static final BigDecimal FOUR = new BigDecimal("4");
	public static final BigDecimal FIVE = new BigDecimal("5");
	public static final BigDecimal SIX = new BigDecimal("6");
	public static final BigDecimal SEVEN = new BigDecimal("7");
	public static final BigDecimal EIGHT = new BigDecimal("8");
	public static final BigDecimal NINE = new BigDecimal("9");
	public static final BigDecimal TEN = new BigDecimal("10");
	public static final BigDecimal TWENTY = new BigDecimal("20");
	public static final BigDecimal THIRTY = new BigDecimal("30");
	public static final BigDecimal FORTY = new BigDecimal("40");
	public static final BigDecimal FIFTY = new BigDecimal("50");
	public static final BigDecimal SIXTY = new BigDecimal("60");
	public static final BigDecimal SEVENTY = new BigDecimal("70");
	public static final BigDecimal EIGHTY = new BigDecimal("80");
	public static final BigDecimal NINETY = new BigDecimal("90");
	public static final BigDecimal ONE_HUNDRED = new BigDecimal("100");
	public static final BigDecimal ONE_THOUSAND = new BigDecimal("1000");
	public static final BigDecimal TEN_THOUSAND = new BigDecimal("10000");
	;
	
	public static final int maxScale = 7;
	
//	/**
//	 * Arredonda para cima
//	 * <p>
//	 * nullsafe retornando 0
//	 *
//	 * @param value
//	 * @param precision
//	 *
//	 * @return
//	 */
//	public static BigDecimal round(BigDecimal value, int precision) {
//		if(value == null) {
//			return BigDecimal.ZERO;
//		}
//		if(precision >= 0) {
//			return value.setScale(precision, RoundingMode.HALF_UP);
//		} else {
//			return value;
//		}
//	}
//
//	/**
//	 * Nulo se for passado nulo ou nenhum valor
//	 */
//	@Nullable
//	public static BigDecimal meanOrNull(Number... values) {
//		if(values == null || values.length == 0) {
//			return null;
//		}
//		return meanOrNull(Arrays.asList(values));
//	}
//
//	/**
//	 * Média dos valores
//	 */
//	@Nullable
//	public static BigDecimal meanOrNull(Collection<Number> collection) {
//		if(CollectionUtil.isEmpty(collection)) {
//			return null;
//		}
//		if(CollectionUtil.hasOne(collection)) {
//			return to;
//		}
//
//		BigDecimal sum = BigDecimal.ZERO;
//		for(BigDecimal value : collection) {
//			sum = sum.add(value);
//		}
//		return sum.divide(BigDecimal.valueOf(CollectionUtil.size(collection)), 5, RoundingMode.HALF_UP);
//	}

	@Nullable
	public static BigDecimal parseOrNull(Object obj) {
		if(obj instanceof Number) {
			return new BigDecimal(obj.toString());
		}
		if(obj instanceof String) {
			String str = (String) obj;
			try {
				return new BigDecimal(str);
			} catch(Exception e) {
				return null;
			}
		}
		return null;
	}
	
	@NotNull
	public static BigDecimal parseOrZero(Supplier<?> supplier) {
		return parseOrZero(Util.nullable(supplier));
	}
	
	@NotNull
	public static BigDecimal parseOrZero(Object obj) {
		BigDecimal bd = parseOrNull(obj);
		return bd != null ? bd : BigDecimal.ZERO;
	}
	
	/* SUM */
	
	public static BigDecimal sumOrDefault(Number defaultIfNull, Number... values) {
		BigDecimal result = sumOrNull(values);
		return Util.firstNonNull(result, parseOrZero(defaultIfNull));
	}
	
	@NotNull
	public static BigDecimal sumOrZero(Number... values) {
		BigDecimal result = sumOrNull(values);
		return Util.firstNonNull(result, BigDecimal.ZERO);
	}
	
	@Nullable
	public static BigDecimal sumOrNull(Number... values) {
		if(values == null || values.length == 0) {
			return null;
		}
		return sumOrNull(Arrays.asList(values));
	}
	
	@Nullable
	public static BigDecimal sumOrNull(List<Number> values) {
		return StreamUtil.ofNotNulls(values)
				.map(BigDecimalUtil::parseOrZero)
				.map(v -> v.setScale(10, RoundingMode.HALF_DOWN))
				.reduce(BigDecimal::add)
				.map(BigDecimal::stripTrailingZeros)
				.orElse(null);
	}
	
	/* SUBTRACT */
	
	public static BigDecimal subOrDefault(Number defaultIfNull, Number... values) {
		BigDecimal result = subOrNull(values);
		return Util.firstNonNull(result, parseOrZero(defaultIfNull));
	}
	
	@NotNull
	public static BigDecimal subOrZero(Number... values) {
		BigDecimal result = subOrNull(values);
		return Util.firstNonNull(result, BigDecimal.ZERO);
	}
	
	@Nullable
	public static BigDecimal subOrNull(Number... values) {
		if(values == null || values.length == 0) {
			return null;
		}
		return subOrNull(Arrays.asList(values));
	}
	
	@Nullable
	public static BigDecimal subOrNull(List<Number> values) {
		return StreamUtil.ofNotNulls(values)
				.map(BigDecimalUtil::parseOrZero)
				.map(v -> v.setScale(10, RoundingMode.HALF_DOWN))
				.reduce(BigDecimal::subtract)
				.map(BigDecimal::stripTrailingZeros)
				.orElse(null);
	}
	
	/* MULTIPLY */
	
	public static BigDecimal multOrDefault(Number defaultIfNull, Number... values) {
		BigDecimal result = multOrNull(values);
		return Util.firstNonNull(result, parseOrZero(defaultIfNull));
	}
	
	@NotNull
	public static BigDecimal multOrZero(Number... values) {
		BigDecimal result = multOrNull(values);
		return Util.firstNonNull(result, BigDecimal.ZERO);
	}
	
	@Nullable
	public static BigDecimal multOrNull(Number... values) {
		if(values == null || values.length == 0) {
			return null;
		}
		return multOrNull(Arrays.asList(values));
	}
	
	@Nullable
	public static BigDecimal multOrNull(List<Number> values) {
		return StreamUtil.ofNotNulls(values)
				.map(BigDecimalUtil::parseOrZero)
				.map(v -> v.setScale(10, RoundingMode.HALF_DOWN))
				.reduce(BigDecimal::multiply)
				.map(BigDecimal::stripTrailingZeros)
				.orElse(null);
	}
	
	/* DIVIDE */
	
	public static BigDecimal divOrDefault(Number defaultIfNull, Number... values) {
		BigDecimal result = divOrNull(values);
		return Util.firstNonNull(result, parseOrZero(defaultIfNull));
	}
	
	@NotNull
	public static BigDecimal divOrZero(Number... values) {
		BigDecimal result = divOrNull(values);
		return Util.firstNonNull(result, BigDecimal.ZERO);
	}
	
	@Nullable
	public static BigDecimal divOrNull(Number... values) {
		if(values == null || values.length == 0) {
			return null;
		}
		return divOrNull(Arrays.asList(values));
	}
	
	@Nullable
	public static BigDecimal divOrNull(List<Number> values) {
		return StreamUtil.ofNotNulls(values)
				.map(BigDecimalUtil::parseOrZero)
				.map(v -> v.setScale(10, RoundingMode.HALF_DOWN))
				.reduce((v1, v2) -> {
					if(eqZero(v2)) {
						return BigDecimal.ZERO;
					}
					return v1.divide(v2, 10, RoundingMode.HALF_DOWN);
				})
				.map(BigDecimal::stripTrailingZeros)
				.orElse(null);
	}
	
	/* MAX */
	
	@Nullable
	public static BigDecimal max(BigDecimal... values) {
		return max(Arrays.asList(values));
	}
	
	@Nullable
	public static BigDecimal max(Collection<BigDecimal> collection) {
		if(CollectionUtil.isEmpty(collection)) {
			return null;
		}
		return StreamUtil.ofNotNulls(collection)
				.max(BigDecimal::compareTo)
				.orElse(null);
	}
	
	@Nullable
	public static BigDecimal min(BigDecimal... values) {
		return min(Arrays.asList(values));
	}
	
	@Nullable
	public static BigDecimal min(Collection<BigDecimal> collection) {
		if(CollectionUtil.isEmpty(collection)) {
			return null;
		}
		return StreamUtil.ofNotNulls(collection)
				.min(BigDecimal::compareTo)
				.orElse(null);
	}
	
	public static boolean betweenExcl(BigDecimal val, Number minIncl, Number maxIncl) {
		if(val == null || minIncl == null || maxIncl == null) {
			return false;
		}
		return gt(val, parseOrZero(minIncl)) && lt(val, parseOrZero(maxIncl));
	}
	
	public static boolean betweenIncl(BigDecimal val, Number minIncl, Number maxIncl) {
		if(val == null || minIncl == null || maxIncl == null) {
			return false;
		}
		return ge(val, parseOrZero(minIncl)) && le(val, parseOrZero(maxIncl));
	}
	
	/**
	 * igual a zero
	 */
	public static boolean eqZero(BigDecimal v) {
		return eq(v, ZERO);
	}
	
	/**
	 * igual a 1
	 */
	public static boolean eqOne(BigDecimal v) {
		return eq(v, ONE);
	}
	
	/**
	 * ambos iguais
	 */
	public static boolean eq(BigDecimal v1, BigDecimal v2) {
		if(v1 == null && v2 == null) {
			return true;
		}
		if(v1 == null || v2 == null) {
			return false;
		}
		int maxScale = Math.max(v1.scale(), v2.scale());
		v1 = v1.setScale(maxScale, RoundingMode.DOWN);
		v2 = v2.setScale(maxScale, RoundingMode.DOWN);
		return v1.equals(v2);
	}
	
	/**
	 * diferentes
	 */
	public static boolean ne(BigDecimal v1, BigDecimal v2) {
		return !eq(v1, v2);
	}
	
	/**
	 * diferente de zero
	 */
	public static boolean neZero(BigDecimal v) {
		return ne(v, ZERO);
	}
	
	/**
	 * diferente de 1
	 */
	public static boolean neOne(BigDecimal v) {
		return ne(v, ONE);
	}
	
	/**
	 * primeiro maior que o segundo
	 */
	public static boolean gt(BigDecimal v1, BigDecimal v2) {
		if(v1 == null && v2 == null) {
			return false;
		}
		if(v2 == null) {
			return true;
		}
		if(v1 == null) {
			return false;
		}
		return v1.compareTo(v2) > 0;
	}
	
	/**
	 * maior que zero
	 */
	public static boolean gtZero(BigDecimal v) {
		return gt(v, ZERO);
	}
	
	/**
	 * maior que 1
	 */
	public static boolean gtOne(BigDecimal v) {
		return gt(v, ONE);
	}
	
	/**
	 * primeiro maior ou igual ao segundo
	 */
	public static boolean ge(BigDecimal v1, BigDecimal v2) {
		if(v1 == null && v2 == null) {
			return false;
		}
		if(v2 == null) {
			return true;
		}
		if(v1 == null) {
			return false;
		}
		return v1.compareTo(v2) >= 0;
	}
	
	/**
	 * maior ou igual a zero
	 */
	public static boolean geZero(BigDecimal v) {
		return ge(v, ZERO);
	}
	
	/**
	 * maior ou igual a 1
	 */
	public static boolean geOne(BigDecimal v) {
		return ge(v, ONE);
	}
	
	/**
	 * primeiro menor que o segundo
	 */
	public static boolean lt(BigDecimal v1, BigDecimal v2) {
		if(v1 == null && v2 == null) {
			return false;
		}
		if(v2 == null) {
			return true;
		}
		if(v1 == null) {
			return false;
		}
		return v1.compareTo(v2) < 0;
	}
	
	/**
	 * menor que zero
	 */
	public static boolean ltZero(BigDecimal v) {
		return lt(v, ZERO);
	}
	
	/**
	 * menor que 1
	 */
	public static boolean ltOne(BigDecimal v) {
		return lt(v, ONE);
	}
	
	/**
	 * primeiro menor ou igual ao segundo
	 */
	public static boolean le(BigDecimal v1, BigDecimal v2) {
		if(v1 == null && v2 == null) {
			return false;
		}
		if(v2 == null) {
			return true;
		}
		if(v1 == null) {
			return false;
		}
		return v1.compareTo(v2) <= 0;
	}
	
	/**
	 * menor ou igual a zero
	 */
	public static boolean leZero(BigDecimal v) {
		return le(v, ZERO);
	}
	
	/**
	 * menor ou igual a 1
	 */
	public static boolean leOne(BigDecimal v) {
		return le(v, ONE);
	}
	
	/**
	 * divide o primeiro pelo segundo, retornando zero se o divisor for zero
	 * <p>
	 * nullsafe
	 */
	@NotNull
	public static BigDecimal divide(@Nullable Number v1, @Nullable Number v2) {
		BigDecimal bdV1 = parseOrZero(v1).setScale(5, RoundingMode.HALF_DOWN);
		BigDecimal bdv2 = parseOrZero(v2).setScale(5, RoundingMode.HALF_DOWN);
		if(eqZero(bdv2)) {
			return BigDecimal.ZERO;
		}
		return bdV1.divide(bdv2, 5, RoundingMode.HALF_DOWN);
	}
	
	/**
	 * multiplica o primeiro pelo segundo
	 * <p>
	 * nullsafe
	 */
	@NotNull
	public static BigDecimal multiply(@Nullable Number v1, @Nullable Number v2) {
		BigDecimal bdV1 = parseOrZero(v1).setScale(5, RoundingMode.HALF_DOWN);
		BigDecimal bdv2 = parseOrZero(v2).setScale(5, RoundingMode.HALF_DOWN);
		return bdV1.multiply(bdv2);
	}
	
	public static class BigDecimalAverageCollector implements Collector<BigDecimal, BigDecimalAccumulator, BigDecimal> {
		
		@Override
		public Supplier<BigDecimalAccumulator> supplier() {
			return BigDecimalAccumulator::new;
		}
		
		@Override
		public BiConsumer<BigDecimalAccumulator, BigDecimal> accumulator() {
			return BigDecimalAccumulator::add;
		}
		
		@Override
		public BinaryOperator<BigDecimalAccumulator> combiner() {
			return BigDecimalAccumulator::combine;
		}
		
		@Override
		public Function<BigDecimalAccumulator, BigDecimal> finisher() {
			return BigDecimalAccumulator::getAverage;
		}
		
		@Override
		public Set<Characteristics> characteristics() {
			return Collections.emptySet();
		}
		
	}
	
	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class BigDecimalAccumulator {
		
		private BigDecimal sum = BigDecimal.ZERO;
		
		private BigDecimal count = BigDecimal.ZERO;
		
		BigDecimal getAverage() {
			return BigDecimal.ZERO.compareTo(count) == 0 ? BigDecimal.ZERO : sum.divide(count, 2, RoundingMode.HALF_UP);
		}
		
		BigDecimalAccumulator combine(BigDecimalAccumulator another) {
			return new BigDecimalAccumulator(sum.add(another.getSum()), count.add(another.getCount()));
		}
		
		void add(BigDecimal successRate) {
			count = count.add(BigDecimal.ONE);
			sum = sum.add(successRate);
		}
		
	}
	
}
