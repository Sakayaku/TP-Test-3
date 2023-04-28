package ilu2;

import java.util.ArrayList;

public class Welcome {
		
	public static String Welcome(String input) {
		StringBuilder resultat = new StringBuilder("Hello, ");
		if (input==null || input.isEmpty() || input.trim().isEmpty()) {
			resultat.append("my friend");
		}else {
			if (input.equals(input.toUpperCase())) {
				return cris(input);
			}
			if (input.contains(",")) {
				resultat.append(constructionChainePlusieursNoms(input));
			}else {
				resultat.append(nomPropre(input));
			}
		}
		return resultat.toString();
	}
	
	private static String nomPropre(String input) { 
		input=input.trim();
		StringBuilder resultat=new StringBuilder();
		if (Character.isUpperCase(input.charAt(0))) {
			resultat.append(input);
		}else {
			resultat.append(Character.toUpperCase(input.charAt(0)));
			resultat.append(input.substring(1));;
		}
		return resultat.toString();
	}
	
	
	private static String cris(String input) {
		StringBuilder resultat = new StringBuilder("HELLO, ");
		return resultat.append(nomPropre(input)).append(" !").toString();
	}
	
	private static int[] remplirTableauDeUn (int taille) {
		int[] tableau = new int[taille];
		for (int i=0;i<taille;i++) {
			tableau[i]=1;
		}
		return tableau;
	}
	
	private static StringBuilder enleverVirguleFinChaine(StringBuilder input) {
		return input.delete(input.length()-2, input.length());
	}
	
	private static StringBuilder ajouterAnd(StringBuilder input, int nbNom, String format) {
		input=enleverVirguleFinChaine(input);
		switch (format) {
			case "Majuscule": {
					if (nbNom>=2) {
						input.replace(input.lastIndexOf(", "), input.lastIndexOf(", ")+2, " AND ");
					}
				return input.append(" !");
			}
			case "Minuscule":{
				if (nbNom>1) {
					input.replace(input.lastIndexOf(", "), input.lastIndexOf(", ")+2, " and ");
				}
				return input;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + format);
		}
	}
	
	private static StringBuilder ajouterFrequenceNoms(ArrayList nomsDistincts, int[] frequenceNom, StringBuilder chaineFinale) {
		int position=0;
		for (int i=0;i<nomsDistincts.size();i++) {
			if (frequenceNom[i]>=2) {
				position=chaineFinale.lastIndexOf(nomsDistincts.get(i).toString())+nomsDistincts.get(i).toString().length();
				chaineFinale.replace(position, position, " (x"+frequenceNom[i]+")");	
			}
		}
		return chaineFinale;
	}
	
	private static String constructionChainePlusieursNoms(String input) {
		StringBuilder resultatMin = new StringBuilder();
		StringBuilder resultatMaj= new StringBuilder(". AND HELLO, ");
		String[] chaineCoupee = input.split(",");
		int nbNomMaj=0,nbNomMin=0;
		ArrayList nomDistincts = new ArrayList();
		int[] frequenceNom= remplirTableauDeUn(chaineCoupee.length);
		for (int i=0;i<chaineCoupee.length;i++) {
			String nomActuel=nomPropre(chaineCoupee[i]);
				if (nomDistincts.contains(nomActuel)) {
					frequenceNom[nomDistincts.indexOf(nomActuel)]+=1;
				}else {
					if (nomActuel.equals(nomActuel.toUpperCase())) {
						resultatMaj.append(nomActuel).append(", ");
						nbNomMaj+=1;	
					}else {
						resultatMin.append(nomPropre(nomActuel)).append(", ");
						nbNomMin+=1;
					}
					nomDistincts.add(nomActuel);
				}
		}
		resultatMin=ajouterAnd(resultatMin, nbNomMin, "Minuscule");
		if (nbNomMaj>=1) {
			resultatMin.append(ajouterAnd(resultatMaj, nbNomMaj, "Majuscule"));
		}
		return ajouterFrequenceNoms(nomDistincts, frequenceNom, resultatMin).toString();
	}
	
}
