package it.polito.tdp.alien;

public class TestClass {
	
	public void run() {
		AlienDictionary ad = new AlienDictionary();
		
		ad.addWord("prv", "prova");
		
		System.out.println("In lingua aliena prv significa : " + ad.translateWord("prv"));
	}
	
	public static void main(String[] args) {
		TestClass tst = new TestClass();
		tst.run();
	}

}
