package ift3911_tp3.Utilisateurs;

import java.util.ArrayList;
import java.util.List;

public abstract class UtilisateurCreator {
	
	protected abstract Utilisateur createUtilisateur(String username, String password, String email);
	
	public Utilisateur render(String username, String password, String email) {
		return createUtilisateur(username, password, email);
	}
	
}
