package com.ltk.api.solar.tools.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CollectionUtil extends CollectionUtils {
	
	public static int size(Collection<?> collection) {
		return collection != null ? collection.size() : 0;
	}
	
	public static <ITEM> boolean hasOne(Collection<ITEM> collection) {
		return has(collection, 1);
	}
	
	public static <ITEM> boolean hasGt(Collection<ITEM> collection, int qtd) {
		return size(collection) > qtd;
	}
	
	public static <ITEM> boolean hasGtOne(Collection<ITEM> collection) {
		return hasGt(collection, 1);
	}
	
	public static <ITEM> boolean hasGe(Collection<ITEM> collection, int qtd) {
		return size(collection) >= qtd;
	}
	
	public static <ITEM> boolean hasGeOne(Collection<ITEM> collection) {
		return hasGe(collection, 1);
	}
	
	public static <ITEM> boolean hasLt(Collection<ITEM> collection, int qtd) {
		return size(collection) < qtd;
	}
	
	public static <ITEM> boolean hasLtOne(Collection<ITEM> collection) {
		return hasLt(collection, 1);
	}
	
	public static <ITEM> boolean hasLe(Collection<ITEM> collection, int qtd) {
		return size(collection) <= qtd;
	}
	
	public static <ITEM> boolean hasLeOne(Collection<ITEM> collection) {
		return hasLe(collection, 1);
	}
	
	public static <ITEM> boolean has(Collection<ITEM> collection, int qtd) {
		return size(collection) == qtd;
	}
	
}
