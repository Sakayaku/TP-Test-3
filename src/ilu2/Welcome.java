package ilu2;

public class Welcome {

	public static String Welcome(String input) {
		StringBuilder resultat = new StringBuilder("Hello, ");
		if (Character.isUpperCase(input.charAt(0))) {
			return resultat.append(input).toString();
		}else {
			resultat.append(Character.toUpperCase(input.charAt(0))).append(input.substring(1));
		}
		return resultat.toString();
	}

}
