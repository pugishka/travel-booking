package ift3911_tp3.Destinations;

public class Aeroport implements Destination{
	private String id;
	private String ville;
	
	public Aeroport(String id, String ville) {
		this.id = id;
		this.ville = ville;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
}