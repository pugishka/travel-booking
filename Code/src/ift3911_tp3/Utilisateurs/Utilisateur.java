package ift3911_tp3.Utilisateurs;

import ift3911_tp3.Methodes.Methode;

import java.util.ArrayList;

public interface Utilisateur {

	public Utilisateur render(String username, String password, String email);
	public String getUsername();
	public void setUsername(String username);
	public String getPassword();
	public void setPassword(String password);
	public String getEmail();
	public void setEmail(String email);

	public void update();

}
