package ift3911_tp3.Utilisateurs;

public class ClientCreator extends UtilisateurCreator {

	private static ClientCreator instance;
	
	private ClientCreator() {}
	
	public static ClientCreator getInstance() {
		if (instance == null) {
			instance = new ClientCreator();
		}
		return instance;
	}

	protected Utilisateur createUtilisateur(String username, String password, String email) {
		return new Client(username, password, email);
	}
}
