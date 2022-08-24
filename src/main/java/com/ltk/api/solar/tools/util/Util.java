package com.ltk.api.solar.tools.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Util extends ObjectUtils {
	
	@Nullable
	public static <VALOR> VALOR nullable(Supplier<VALOR> supplier) {
		try {
			return supplier.get();
		} catch(Exception ignored) {
			return null;
		}
	}
	
	@NotNull
	public static <VALOR> VALOR nullable(Supplier<VALOR> supplier, @NotNull VALOR defaultValue) {
		try {
			VALOR valor = supplier.get();
			return ObjectUtils.firstNonNull(valor, defaultValue);
		} catch(Exception ignored) {
			return defaultValue;
		}
	}
	
}
