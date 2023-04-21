package ilu2;

public class Welcome {
		
	public static String Welcome(String input) {
		StringBuilder resultat = new StringBuilder("Hello, ");
		if (input==null || input.isEmpty() || justePrenom(input).isEmpty()) {
			resultat.append("my friend");
		}else {
			if (input.equals(input.toUpperCase())) {
				return cris(input);
			}
			if (input.contains(",")) {
				resultat.append(plusieursNoms(input));
			}else {
				resultat.append(premiereLettreMajuscule(input));
			}
		}
		return resultat.toString();
	}
	
	private static String premiereLettreMajuscule(String input) {
		StringBuilder resultat=new StringBuilder();
		if (Character.isUpperCase(input.charAt(0))) {
			return input;
		}else {
			return resultat.append(Character.toUpperCase(input.charAt(0))).append(input.substring(1)).toString();
		}
	}
	
	private static String cris(String input) {
		StringBuilder resultat = new StringBuilder("HELLO, ");
		return resultat.append(justePrenom(input)).append(" !").toString();
	}
	
	private static String justePrenom(String input) {
		return input.trim();
	}
	
	private static String plusieursNoms(String input) {
		StringBuilder resultat = new StringBuilder();
		String[] intermediaire = input.split(",");
		for (int i=0;i<intermediaire.length;i++) {
			resultat.append(premiereLettreMajuscule(justePrenom(intermediaire[i])));
			resultat.append(", ");
		}
		resultat.delete(resultat.length()-2, resultat.length());
		return resultat.toString();
	}

}
