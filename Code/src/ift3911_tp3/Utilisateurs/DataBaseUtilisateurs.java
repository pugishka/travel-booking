package ift3911_tp3.Utilisateurs;

import java.util.ArrayList;
import java.util.List;

public class DataBaseUtilisateurs {

	private static List<Utilisateur> clients;
	private static List<Utilisateur> admins;
	private static DataBaseUtilisateurs instance;
	
	private DataBaseUtilisateurs() {
		clients = new ArrayList<Utilisateur>();
		admins = new ArrayList<Utilisateur>();
	};
	
	public static DataBaseUtilisateurs getInstance() {
		if (instance == null) {
			instance = new DataBaseUtilisateurs();
		}
		return instance;
	}

	public boolean newClient(String username, String password, String email) {
		for(Utilisateur u : clients) {
			if(u.getUsername() == username) {
				return false;
			}
		}
		UtilisateurCreator c = ClientCreator.getInstance();
		Utilisateur u = c.render(username, password, email);
		clients.add(u);
		return true;
	}

	public boolean newAdmin(String username, String password, String email) {
		for(Utilisateur u : admins) {
			if(u.getUsername() == username) {
				return false;
			}
		}
		UtilisateurCreator c = AdminCreator.getInstance();
		Utilisateur u = c.render(username, password, email);
		admins.add(u);
		return true;
	}
	
	public String checkPasswordClient(String username, String password) {
		for(Utilisateur u : clients) {
			if(u.getUsername() == username) {
				if (u.getPassword() == password) {
					return "";
				} else {
					return "wrong password";
				}
			}
		}
		return "utilisateur inexistant";
	}
	
	public String checkPasswordAdmin(String username, String password) {
		for(Utilisateur u : admins) {
			if(u.getUsername() == username) {
				if (u.getPassword() == password) {
					return "";
				} else {
					return "wrong password";
				}
			}
		}
		return "utilisateur inexistant";
	}

}
