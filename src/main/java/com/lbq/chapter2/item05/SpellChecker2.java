package com.lbq.chapter2.item05;

import java.util.List;

public class SpellChecker2 {
	private final Lexicon dictionary = new Lexicon() {};
	
	private SpellChecker2() {
		throw new AssertionError();
	}
	
	public static SpellChecker2 INSTANCE = new SpellChecker2();
	public boolean isValid(String word) {
		return false;
	}
	
	public List<String> suggestions(String typo){
		return null;
	}
}
