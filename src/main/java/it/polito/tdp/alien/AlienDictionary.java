package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<WordEnhanced> dizionario;

	public AlienDictionary() {
		dizionario = new ArrayList<WordEnhanced>();
	}
	
	public void doReset() {
		dizionario.clear();
	}
	
	public void addWord(String alienWord, String translation) {
		
		WordEnhanced w = new WordEnhanced(alienWord);
		
		if(dizionario.contains(w)) {
			dizionario.get(dizionario.indexOf(w)).setTranslation(translation);
			return;
		}
		
		w.setTranslation(translation);
		dizionario.add(w);
	}
	
	public String translateWord(String alienWord) {
		
		WordEnhanced w = new WordEnhanced(alienWord);
		
		if(dizionario.contains(w)) {
			return dizionario.get(dizionario.indexOf(w)).getTranslation();
		}
		
		return null;
	}

	public String translateWordWildCard(String alienWord) {
		
		alienWord = alienWord.replaceAll("\\?", ".");
		
		int matchCounter = 0;
		
		StringBuilder sb = new StringBuilder();
		
		
		for(WordEnhanced w: dizionario) {
			
			if (w.copareWild(alienWord)) {
				
				matchCounter++;
				sb.append(w.getTranslation()+ "\n");
			}
		}
		
		if(matchCounter !=0) {
			return sb.toString();
		} else {
			return null;
		}
	}

}
