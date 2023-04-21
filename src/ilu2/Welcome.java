package ilu2;

public class Welcome {

	public static String Welcome(String input) {
		StringBuilder resultat = new StringBuilder("Hello, ");
		System.out.println(input);
		if (input==null || input.isEmpty() || input.trim().isEmpty()) {
			resultat.append("my friend");
		}else {
			if (Character.isUpperCase(input.charAt(0))) {
				resultat.append(input);
			}else {
				resultat.append(Character.toUpperCase(input.charAt(0))).append(input.substring(1));
			}
		}
		return resultat.toString();
	}

}
