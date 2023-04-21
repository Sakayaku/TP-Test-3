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
				resultat.append(deuxNoms(input));
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
		return resultat.append(input).append(" !").toString();
	}
	
	private static String justePrenom(String input) {
		return input.trim();
	}
	
	private static String deuxNoms(String input) {
		StringBuilder resultat = new StringBuilder();
		String[] intermediaire = input.split(",");
		resultat.append(premiereLettreMajuscule(justePrenom(intermediaire[0])));
		resultat.append(", ");
		resultat.append(premiereLettreMajuscule(justePrenom(intermediaire[1])));
		return resultat.toString();
	}

}
