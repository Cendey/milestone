package com.mit.lab.norm;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {
    private static final String EMPTY = "";
	private static Set<String> NON_WORDS = new HashSet<String>() {
		private static final long serialVersionUID = -8523340994399415120L;

		{
			add("the");
			add("and");
			add("of");
			add("to");
			add("a");
			add("i");
			add("it");
			add("in");
			add("or");
			add("is");
			add("d");
			add("s");
			add("as");
			add("so");
			add("but");
			add("be");
		}
	};

	private static List<String> regexToList(String words) {
		List<String> wordList = new ArrayList<>();
		Matcher m = Pattern.compile("\\w+").matcher(words);
		while (m.find())
			wordList.add(m.group());
		return wordList;
	}

	public static Map<String, Integer> wordFreq(String words) {
		Map<String, Integer> wordMap = new TreeMap<>();
		regexToList(words).stream().map(String::toLowerCase).filter(word -> !NON_WORDS.contains(words))
				.forEach(word -> wordMap.put(String.valueOf(word), wordMap.getOrDefault(word, 0) + 1));
		return wordMap;
	}

	/**
	 * <em>Summary:</em><p>Cut off source contents by limitation byte size which given for <code>threshold</code></p>
	 *
	 * @param source    <p>Original contents</p>
	 * @param threshold <p>Target contents' byte size</p>
	 * @return <p>The final contents generated from original content with given threshold size</p>
	 */
	public static String cutOffContents(String source, int threshold) {
		SortedMap<String, Charset> mCharset = Charset.availableCharsets();
		if (source!=null && source.trim().length()>0) {
			for (Map.Entry<String, Charset> entry : mCharset.entrySet()) {
				if (source.equals(new String(source.getBytes(), entry.getValue()))) {
					byte[] contents = source.getBytes(entry.getValue());
					int capacity = contents.length;
					byte[] remark;
					if (capacity <= threshold) {
						return source;
					} else {
						remark = new byte[threshold];
						System.arraycopy(contents, 0, remark, 0, threshold);
					}
					return new String(remark, entry.getValue());
				}
			}
		}
		return EMPTY;
	}
}
