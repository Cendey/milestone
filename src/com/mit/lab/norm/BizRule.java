package com.mit.lab.norm;

import java.util.HashMap;
import java.util.Map;

public class BizRule {

	public static Map<String, String> checkInsistence(Map<String, String> bizRuleConfig) {
		Map<String, String> result = null;
		if (bizRuleConfig != null) {
			String firstPart;
			String lastPart;
			result = new HashMap<>();
			System.err.append("Sub controller configuration incorrect:\n");
			for (Map.Entry<String, String> item : bizRuleConfig.entrySet()) {
				firstPart = item.getKey();
				lastPart = item.getValue();
				try{
					Class.forName(firstPart);
					result.put(firstPart, lastPart);
				} catch (ClassNotFoundException e) {
					try {
						Class.forName(lastPart);
						result.put(lastPart, firstPart);
					} catch (ClassNotFoundException e1) {
						System.err.append(String.format("controller full name:%s; description:%s\n", firstPart,
								lastPart));
					}
				}
			}
		}
		return result;
	}
}
