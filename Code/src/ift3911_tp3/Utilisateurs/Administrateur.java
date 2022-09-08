package ift3911_tp3.Utilisateurs;

import ift3911_tp3.Methodes.Methode;
import ift3911_tp3.Methodes.State;

import java.util.ArrayList;
import java.util.List;

public class Administrateur implements Utilisateur{

	private String username;
	private String password;
	private String email;
	private List<Methode> voyages = new ArrayList<>();
	
	public Administrateur(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public Administrateur render(String username, String password, String email) {
		return new Administrateur(username, password, email);
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void update() {
		for(Methode voyage : voyages){
			State temp = voyage.getState();
		}
	}


}
