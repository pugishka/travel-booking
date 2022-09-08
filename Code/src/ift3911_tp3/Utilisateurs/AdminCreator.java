package ift3911_tp3.Utilisateurs;

public class AdminCreator extends UtilisateurCreator {

	private static AdminCreator instance;
	
	private AdminCreator() {}
	
	public static AdminCreator getInstance() {
		if (instance == null) {
			instance = new AdminCreator();
		}
		return instance;
	}

	protected Utilisateur createUtilisateur(String username, String password, String email) {
		return new Administrateur(username, password, email);
	}
}
