package com.ltk.api.solar.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StreamUtil {
	
	@SafeVarargs
	@NotNull
	public static <OBJETO> Stream<OBJETO> ofNotNulls(OBJETO objeto, OBJETO... objetos) {
		return Stream.concat(Stream.of(objeto), Stream.of(objetos))
				.filter(Objects::nonNull);
	}
	
	@NotNull
	public static <OBJETO> Stream<OBJETO> ofNotNulls(Collection<OBJETO> objetos) {
		if(objetos == null || objetos.isEmpty()) {
			return Stream.empty();
		}
		return objetos.stream()
				.filter(Objects::nonNull);
	}
	
	@NotNull
	public static <OBJETO> Stream<OBJETO> ofNullable(Collection<OBJETO> objetos) {
		if(objetos == null || objetos.isEmpty()) {
			return Stream.empty();
		}
		return objetos.stream();
	}
	
}
