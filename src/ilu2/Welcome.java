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
		StringBuilder resultat = new StringBuilder();
		StringBuilder resultatMaj= new StringBuilder(". AND HELLO, ");
		String[] chaineCoupee = input.split(",");
		for (int i=0;i<chaineCoupee.length;i++) {
			if (chaineCoupee[i].equals(chaineCoupee[i].toUpperCase())) {
				resultatMaj.append(nomPropre(chaineCoupee[i]));
				resultatMaj.append(", ");
			}else {
				resultat.append(nomPropre(chaineCoupee[i]));
				resultat.append(", ");
			}
		}
		resultat.delete(resultat.length()-2, resultat.length());
		resultatMaj.delete(resultatMaj.length()-2, resultatMaj.length());
		if (resultatMaj.length()>13) {
			resultat.append(resultatMaj).append(" !");
		}
		return resultat.toString();
	}

}
