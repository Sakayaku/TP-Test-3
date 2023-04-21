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
			if (Character.isUpperCase(input.charAt(0))) {
				resultat.append(input);
			}else {
				resultat.append(Character.toUpperCase(input.charAt(0))).append(input.substring(1));
			}
		}
		return resultat.toString();
	}
	
	private static String cris (String input) {
		StringBuilder resultat = new StringBuilder("HELLO, ");
		return resultat.append(input).append(" !").toString();
	}

}
