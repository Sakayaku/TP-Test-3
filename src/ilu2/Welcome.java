package ilu2;

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
				resultat.append(plusieursNoms(input));
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
	
	private static String plusieursNoms(String input) {
		StringBuilder resultatMin = new StringBuilder();
		StringBuilder resultatMaj= new StringBuilder(". AND HELLO");
		String[] chaineCoupee = input.split(",");
		int nbNomMaj=0,nbNomMin=0;
		for (int i=0;i<chaineCoupee.length;i++) {
			if (chaineCoupee[i].equals(chaineCoupee[i].toUpperCase())) {
				resultatMaj.append(", ");
				resultatMaj.append(nomPropre(chaineCoupee[i]));
				nbNomMaj+=1;
			}else {
				resultatMin.append(nomPropre(chaineCoupee[i]));
				resultatMin.append(", ");
				nbNomMin+=1;
			}
		}
		resultatMin=ajouterAnd(resultatMin, nbNomMin, "Minuscule");
		if (nbNomMaj>=1) {
			resultatMaj=ajouterAnd(resultatMaj, nbNomMaj, "Majuscule");
			resultatMin.append(resultatMaj);
		}
		return resultatMin.toString();
	}
	
	private static StringBuilder enleverVirguleFinChaine(StringBuilder input) {
		return input.delete(input.length()-2, input.length());
	}
	
	private static StringBuilder ajouterAnd(StringBuilder input, int nbNom, String format) {
		switch (format) {
			case "Majuscule": {
					if (nbNom>=2) {
						input.deleteCharAt(11);
						input.replace(input.lastIndexOf(", "), input.lastIndexOf(", ")+2, " AND ");
					}
				return input.append(" !");
			}
			case "Minuscule":{
				input=enleverVirguleFinChaine(input);
				if (nbNom>1) {
					input.replace(input.lastIndexOf(", "), input.lastIndexOf(", ")+2, " and ");
				}
				return input;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + format);
		}
	}
}
