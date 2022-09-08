package ift3911_tp3;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

import ift3911_tp3.Compagnies.DataBaseCompagnies;
import ift3911_tp3.Destinations.AeroportCreator;
import ift3911_tp3.Destinations.DataBaseDestinations;
import ift3911_tp3.Methodes.DataBaseMethodes;
import ift3911_tp3.Methodes.ItineraireCreator;
import ift3911_tp3.Methodes.TrajetCreator;
import ift3911_tp3.Methodes.VolCreator;
import ift3911_tp3.Utilisateurs.DataBaseUtilisateurs;

public class Volet{
	
	// main
	private JFrame frame;
	private Box container;
	private JPanel panelFields;
	private JPanel panelMain;
	private JTable list;
	private JTextField tusername;
	private JTextField tpassword;
	private JTextField temail;
	private JLabel email;
	private boolean isAdmin;
    
    public Volet(boolean isAdmin) {
    	this.isAdmin = isAdmin;
    }
	
	public void displayUser() {
		
		// fenetre
		frame = new JFrame("Réservation de voyage");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setVisible(true);
		container = new Box(BoxLayout.Y_AXIS);
		frame.add(container);
		
		// connecter / inscrire
		JPanel panelBoutonsUtilisateur;
		
		JLabel username = new JLabel("Username");
		tusername = new JTextField();
	    
		JLabel password = new JLabel("Mot de passe");
	    tpassword = new JTextField();
	    
	    email = new JLabel("Courriel");
	    temail = new JTextField();
		
		// boutons inscrire connecter
		panelBoutonsUtilisateur = new JPanel();
		panelBoutonsUtilisateur.setMaximumSize(new Dimension(500, 50));
		
		JButton connecter = new JButton("Se connecter");
		JButton inscrire = new JButton("S'inscrire");
		JButton guest = new JButton("Continuer sans compte");
		panelBoutonsUtilisateur.add(connecter);
		panelBoutonsUtilisateur.add(inscrire);
		panelBoutonsUtilisateur.add(guest);
		
		container.add(panelBoutonsUtilisateur);
		
		// text fields pour username, password, email
		panelFields = new JPanel();
		panelFields.setMaximumSize(new Dimension(400,100));
		GridLayout l = new GridLayout(3,2);
		l.setVgap(10);
		panelFields.setLayout(l);
		
		email.setVisible(true);
		temail.setVisible(true);
		panelFields.add(username);
		panelFields.add(tusername);
		panelFields.add(password);
		panelFields.add(tpassword);
		panelFields.add(email);
		panelFields.add(temail);
		
		container.add(panelFields);

		// bouton envoyer
		JButton envoyer = new JButton("OK");
		container.add(envoyer);
		
		// action listeners
		connecter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connecter();
			}
		});
		
		inscrire.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inscrire();
			}
		});
		
		guest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainMenu();
			}
		});
		
		envoyer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = envoyer();
				if(s == "") {
					mainMenu();
				} else {
					JOptionPane.showMessageDialog(frame, s);
				}
			}
		});
		
	}
    
	public void connecter() {
		email.setVisible(false);
		temail.setVisible(false);
	}

	public void inscrire() {
		email.setVisible(true);
		temail.setVisible(true);
	}
	
	public String envoyer() {
		if (temail.isVisible()) {
			if (tusername.getText().equals("") || tpassword.getText().equals("") || temail.getText().equals("")) {
				return "Remplir tous les champs";
			} else {
				boolean b = false;
				if (isAdmin) {
					b = DataBaseUtilisateurs.getInstance().newAdmin(tusername.getText(), tpassword.getText(), temail.getText());
				} else {
					b = DataBaseUtilisateurs.getInstance().newClient(tusername.getText(), tpassword.getText(), temail.getText());
				}
				if (!b) {return "Username déjà existant";} else {return "";}
			}
		} else {
			if (tusername.getText().equals("") || tpassword.getText().equals("")) {
				return "Remplir tous les champs";
			} else {
				String s = "";
				if (isAdmin) {
					s = DataBaseUtilisateurs.getInstance().checkPasswordAdmin(tusername.getText(), tpassword.getText());
				} else {
					s = DataBaseUtilisateurs.getInstance().checkPasswordClient(tusername.getText(), tpassword.getText());
				}
				return s;
			}
		}
	}
	
	public void mainMenu() {
		
		container.removeAll();
		panelMain = new JPanel();
		
		if(isAdmin) {
			JButton vAerien = new JButton("Voyages Aériens");
			JButton vFerroviaire = new JButton("Voyages Ferroviaires");
			JButton vNaval = new JButton("Voyages Navals");
			panelMain.add(vAerien);
			panelMain.add(vFerroviaire);
			panelMain.add(vNaval);
			
			container.add(panelMain);
			container.revalidate();
			container.repaint();
	
			// action listeners
			vAerien.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menuVoyage(1);
				}
			});
			
			vFerroviaire.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menuVoyage(2);
				}
			});
			
			vNaval.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menuVoyage(3);
				}
			});
		} else {
			// TODO
		}
	}
		
	public void menuVoyage(int type) {
		
		panelMain.removeAll();

		if(isAdmin) {
			String a = "";
			String b = "";
			
			switch (type) {
				case 1:
					a = "Gérer les vols";
					b = "Gérer les aéroports";
					break;
				case 2:
					a = "Gérer les trajets";
					b = "Gérer les gares";
					break;
				case 3:
					a = "Gérer les itinéraires";
					b = "Gérer les ports";
					break;
			} 
			
			JButton methode = new JButton(a);
			JButton destination = new JButton(b);
			JButton compagnie = new JButton("Gérer les compagnies");
			panelMain.add(methode);
			panelMain.add(destination);
			panelMain.add(compagnie);
			
			JButton retour = new JButton("Retour");
			panelMain.add(retour);
			
			panelMain.revalidate();
			panelMain.repaint();
	
			// action listeners
			methode.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menuMethode(type);
				}
			});
			
			destination.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menuDestination(type);
				}
			});
			
			compagnie.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menuCompagnie(type);
				}
			});
			
			retour.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					mainMenu();
				}
			});
		} else {
			//TODO
		}
	}
	
	public void menuMethode(int type) {
		
		panelMain.removeAll();
		
		JButton creer = new JButton("Créer");
		JButton modifier = new JButton("Modifier");
		JButton supprimer = new JButton("Supprimer");
		panelMain.add(creer);
		panelMain.add(modifier);
		panelMain.add(supprimer);
		
		JButton retour = new JButton("Retour");
		panelMain.add(retour);
		
		panelMain.revalidate();
		panelMain.repaint();

		// action listeners
		creer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (type) {
				case 1:
					creerVol();
					break;
				case 2:
					creerTrajet();
					break;
				case 3:
					creerItineraire();
					break;
				} 
				
			}
		});
		
		modifier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (type) {
				case 1:
					editVol();
					break;
				case 2:
					editTrajet();
					break;
				case 3:
					editItineraire();
					break;
				} 
			}
		});
		
		supprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (type) {
				case 1:
					deleteVol();
					break;
				case 2:
					deleteTrajet();
					break;
				case 3:
					deleteItineraire();
					break;
				} 
			}
		});
		
		retour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuVoyage(1);
			}
		});
	}
	
	public void creerVol() {
		
		panelMain.removeAll();
		panelMain.add(panelFields);
		
		panelFields.removeAll();
		GridLayout l = new GridLayout(5,2);
		l.setVgap(10);
		l.setHgap(20);
		panelFields.setLayout(l);
		
		panelFields.add(new JLabel("Date de départ (MM/dd/yyyy hh:mm)"));
		JFormattedTextField dateDepart = new JFormattedTextField(new SimpleDateFormat("MM/dd/yyyy hh:mm"));
		panelFields.add(dateDepart);

		panelFields.add(new JLabel("Date d'arrivée (MM/dd/yyyy hh:mm)"));
		JFormattedTextField dateArrivee = new JFormattedTextField(new SimpleDateFormat("MM/dd/yyyy hh:mm"));
		panelFields.add(dateArrivee);

		panelFields.add(new JLabel("Destination (séparés par ,)"));
		JTextField destination = new JTextField();
		panelFields.add(destination);

		panelFields.add(new JLabel("Compagnie"));
		JTextField compagnie = new JTextField();
		panelFields.add(compagnie);
		
		JButton ok = new JButton("OK");
		panelFields.add(ok);
		
		JButton retour = new JButton("Retour");
		panelFields.add(retour);
		
		panelMain.revalidate();
		panelMain.repaint();
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (dateDepart.getText().equals("") || dateArrivee.getText().equals("") || destination.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Remplir tous les champs");
				} else {
					DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
					LocalDateTime dd = LocalDateTime.parse(dateDepart.getText(), formatter);
					LocalDateTime da = LocalDateTime.parse(dateArrivee.getText(), formatter);
					if(dd.isAfter(da)) {
						JOptionPane.showMessageDialog(frame, "Dates invalides");
					} else {
						String[] destinations = (destination.getText().replace(" ", "")).split(","); 
						if(destinations.length != 2 || destinations[0] == destinations[1]) {
							JOptionPane.showMessageDialog(frame, "Destinations invalides");
						} else {
							if(DataBaseDestinations.getInstance().checkAeroport(destinations[0]) && DataBaseDestinations.getInstance().checkAeroport(destinations[1])) {
								if (DataBaseCompagnies.getInstance().checkCompagnieAerienne(compagnie.getText())) {
									Boolean b = DataBaseMethodes.getInstance().newVol(dd, da, destinations, compagnie.getText());
									if (b) {
										JOptionPane.showMessageDialog(frame, "Vol créé");
									} else {
										JOptionPane.showMessageDialog(frame, "Vol non créé");
									}
								} else {
									JOptionPane.showMessageDialog(frame, "Compagnie inexistante");
								}
							} else {
								JOptionPane.showMessageDialog(frame, "Destinations inexistantes");
							}
						}
					}
				}
			}
		});
		
		retour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuMethode(1);
			}
		});
	}
	
	public void creerTrajet() {
		
		panelMain.removeAll();
		panelMain.add(panelFields);
		
		panelFields.removeAll();
		GridLayout l = new GridLayout(5,2);
		l.setVgap(10);
		l.setHgap(20);
		panelFields.setLayout(l);
		
		panelFields.add(new JLabel("Date de départ"));
		JFormattedTextField dateDepart = new JFormattedTextField(new SimpleDateFormat("MM/dd/yyyy hh:mm"));
		panelFields.add(dateDepart);

		panelFields.add(new JLabel("Date d'arrivée"));
		JFormattedTextField dateArrivee = new JFormattedTextField(new SimpleDateFormat("MM/dd/yyyy hh:mm"));
		panelFields.add(dateArrivee);

		panelFields.add(new JLabel("Destinations"));
		JTextField destination = new JTextField();
		panelFields.add(destination);

		panelFields.add(new JLabel("Compagnie"));
		JTextField compagnie = new JTextField();
		panelFields.add(compagnie);
		
		JButton ok = new JButton("OK");
		panelFields.add(ok);
		
		JButton retour = new JButton("Retour");
		panelFields.add(retour);
		
		panelMain.revalidate();
		panelMain.repaint();
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (dateDepart.getText().equals("") || dateArrivee.getText().equals("") || destination.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Remplir tous les champs");
				} else {
					LocalDateTime dd = LocalDateTime.parse(dateDepart.getText());
					LocalDateTime da = LocalDateTime.parse(dateArrivee.getText());
					if(dd.isAfter(da)) {
						JOptionPane.showMessageDialog(frame, "Dates invalides");
					} else {
						String[] destinations = (destination.getText().replace(" ", "")).split(","); 
						int i = 0;
						for(String s : destinations) {
							if (DataBaseDestinations.getInstance().checkGare(s)) {
								i++;
							}
						}
						if(i == destinations.length) {
							if (DataBaseCompagnies.getInstance().checkCompagnieFerroviaire(compagnie.getText())) {
								Boolean b = DataBaseMethodes.getInstance().newTrajet(dd, da, destinations, compagnie.getText());
								if (b) {
									JOptionPane.showMessageDialog(frame, "Trajet créé");
								} else {
									JOptionPane.showMessageDialog(frame, "Trajet non créé");
								}
							} else {
								JOptionPane.showMessageDialog(frame, "Compagnie inexistante");
							}
						} else {
							JOptionPane.showMessageDialog(frame, "Destinations inexistantes");
						}
					}
				}
			}
		});
		
		retour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuMethode(2);
			}
		});
	}
	
	public void creerItineraire() {
		
		panelMain.removeAll();
		panelMain.add(panelFields);
		
		panelFields.removeAll();
		GridLayout l = new GridLayout(5,2);
		l.setVgap(10);
		l.setHgap(20);
		panelFields.setLayout(l);
		
		panelFields.add(new JLabel("Date de départ"));
		JFormattedTextField dateDepart = new JFormattedTextField(new SimpleDateFormat("MM/dd/yyyy hh:mm"));
		panelFields.add(dateDepart);

		panelFields.add(new JLabel("Date d'arrivée"));
		JFormattedTextField dateArrivee = new JFormattedTextField(new SimpleDateFormat("MM/dd/yyyy hh:mm"));
		panelFields.add(dateArrivee);

		panelFields.add(new JLabel("Destinations"));
		JTextField destination = new JTextField();
		panelFields.add(destination);

		panelFields.add(new JLabel("Compagnie"));
		JTextField compagnie = new JTextField();
		panelFields.add(compagnie);
		
		JButton ok = new JButton("OK");
		panelFields.add(ok);
		
		JButton retour = new JButton("Retour");
		panelFields.add(retour);
		
		panelMain.revalidate();
		panelMain.repaint();
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (dateDepart.getText().equals("") || dateArrivee.getText().equals("") || destination.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Remplir tous les champs");
				} else {
					LocalDateTime dd = LocalDateTime.parse(dateDepart.getText());
					LocalDateTime da = LocalDateTime.parse(dateArrivee.getText());
					if(dd.isAfter(da) || Duration.between(dd, da).toDays() > 21) {
						JOptionPane.showMessageDialog(frame, "Dates invalides");
					} else {
						String[] destinations = (destination.getText().replace(" ", "")).split(","); 
						if(destinations[0] == destinations[destinations.length-1]) {
							JOptionPane.showMessageDialog(frame, "Destination de départ et arrivée differentes");
						} else {int i = 0;
							for(String s : destinations) {
								if (DataBaseDestinations.getInstance().checkGare(s)) {
									i++;
								}
							}
							if(i == destinations.length) {
								if (DataBaseCompagnies.getInstance().checkCompagnieCroisiere(compagnie.getText())) {
									Boolean b = DataBaseMethodes.getInstance().newItineraire(dd, da, destinations, compagnie.getText());
									if (b) {
										JOptionPane.showMessageDialog(frame, "Itineraire créé");
									} else {
										JOptionPane.showMessageDialog(frame, "Itineraire non créé");
									}
								} else {
									JOptionPane.showMessageDialog(frame, "Compagnie inexistante");
								}
							} else {
								JOptionPane.showMessageDialog(frame, "Destinations inexistantes");
							}
						}
					}
				}
			}
		});
		
		retour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuMethode(3);
			}
		});
	}
	
	public void editVol() {
		panelMain.removeAll();
		panelMain.add(panelFields);
		panelFields.removeAll();
		
		GridLayout l = new GridLayout(1,2);
		l.setVgap(10);
		l.setHgap(20);
		panelFields.setLayout(l);
		
		String [][] data = DataBaseMethodes.getInstance().getVols();
		String [] names = {"Id", "Compagnie", "Date de départ", "Date d'arrivée", "Aéroport de départ", "Aéroport d'arrivée", "Sections"};
		list = new JTable(data, names);
		panelMain.add(list);
		
		panelFields.add(new JLabel("Recherche vol :"));
		JFormattedTextField dateArrivee = new JFormattedTextField(new SimpleDateFormat("MM/dd/yyyy hh:mm"));
		panelFields.add(dateArrivee);
		
		JButton ok = new JButton("OK");
		panelFields.add(ok);
		
		JButton retour = new JButton("Retour");
		panelFields.add(retour);
		
		panelMain.revalidate();
		panelMain.repaint();
	}
	
	
	public void editTrajet() {}
	public void editItineraire() {}
	
	public void deleteVol() {}
	public void deleteTrajet() {}
	public void deleteItineraire() {}
	
	public void menuDestination(int type) {
		
		panelMain.removeAll();
		
		JButton creer = new JButton("Créer");
		JButton modifier = new JButton("Modifier");
		JButton supprimer = new JButton("Supprimer");
		panelMain.add(creer);
		panelMain.add(modifier);
		panelMain.add(supprimer);
		
		JButton retour = new JButton("Retour");
		panelMain.add(retour);
		
		panelMain.revalidate();
		panelMain.repaint();

		// action listeners
		creer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (type) {
				case 1:
					creerAeroport();
					break;
				case 2:
					creerGare();
					break;
				case 3:
					creerPort();
					break;
				} 
				
			}
		});
		
		modifier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (type) {
				case 1:
					editAeroport();
					break;
				case 2:
					editGare();
					break;
				case 3:
					editPort();
					break;
				} 
			}
		});
		
		supprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (type) {
				case 1:
					deleteAeroport();
					break;
				case 2:
					deleteGare();
					break;
				case 3:
					deletePort();
					break;
				} 
			}
		});
		
		retour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuVoyage(2);
			}
		});
	}
	
	protected void deletePort() {
		// TODO Auto-generated method stub
		
	}

	protected void deleteGare() {
		// TODO Auto-generated method stub
		
	}

	protected void deleteAeroport() {
		// TODO Auto-generated method stub
		
	}

	protected void editPort() {
		// TODO Auto-generated method stub
		
	}

	protected void editGare() {
		// TODO Auto-generated method stub
		
	}

	protected void editAeroport() {
		// TODO Auto-generated method stub
		
	}

	protected void creerPort() {
		// TODO Auto-generated method stub
		
	}

	protected void creerGare() {
		// TODO Auto-generated method stub
		
	}

	protected void creerAeroport() {
		
		panelMain.removeAll();
		panelMain.add(panelFields);
		
		panelFields.removeAll();
		GridLayout l = new GridLayout(5,2);
		l.setVgap(10);
		l.setHgap(20);
		panelFields.setLayout(l);
		
		panelFields.add(new JLabel("ID"));
		JTextField id = new JTextField();
		panelFields.add(id);

		panelFields.add(new JLabel("Ville"));
		JTextField ville = new JTextField();
		panelFields.add(ville);
		
		JButton ok = new JButton("OK");
		panelFields.add(ok);
		
		JButton retour = new JButton("Retour");
		panelFields.add(retour);
		
		panelMain.revalidate();
		panelMain.repaint();
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ville.getText().equals("") || id.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Remplir tous les champs");
				} else {
					if (!DataBaseDestinations.getInstance().checkAeroport(id.getText())) {
						Boolean b = DataBaseDestinations.getInstance().newAeroport(id.getText(), ville.getText());
						if (b) {
							JOptionPane.showMessageDialog(frame, "Aeroport créé");
						} else {
							JOptionPane.showMessageDialog(frame, "Aeroport non créé");
						}
					} else {
						JOptionPane.showMessageDialog(frame, "Aeroport existant");
					}
				}
			}
		});
		
		retour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuMethode(1);
			}
		});
		
	}

	public void menuCompagnie(int type) {
		
		panelMain.removeAll();
		
		JButton creer = new JButton("Créer");
		JButton modifier = new JButton("Modifier");
		JButton supprimer = new JButton("Supprimer");
		panelMain.add(creer);
		panelMain.add(modifier);
		panelMain.add(supprimer);
		
		JButton retour = new JButton("Retour");
		panelMain.add(retour);
		
		panelMain.revalidate();
		panelMain.repaint();

		// action listeners
		creer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (type) {
				case 1:
					creerCAerienne();
					break;
				case 2:
					creerCFerroviaire();
					break;
				case 3:
					creerCCroisiere();
					break;
				} 
				
			}
		});
		
		modifier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (type) {
				case 1:
					editCAerienne();
					break;
				case 2:
					editCFerroviaire();
					break;
				case 3:
					editCCroisiere();
					break;
				} 
			}
		});
		
		supprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (type) {
				case 1:
					deleteCAerienne();
					break;
				case 2:
					deleteCFerroviaire();
					break;
				case 3:
					deleteCCroisiere();
					break;
				} 
			}
		});
		
		retour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuVoyage(3);
			}
		});
	}

	protected void deleteCCroisiere() {
		// TODO Auto-generated method stub
		
	}

	protected void deleteCFerroviaire() {
		// TODO Auto-generated method stub
		
	}

	protected void deleteCAerienne() {
		// TODO Auto-generated method stub
		
	}

	protected void editCCroisiere() {
		// TODO Auto-generated method stub
		
	}

	protected void editCFerroviaire() {
		// TODO Auto-generated method stub
		
	}

	protected void editCAerienne() {
		// TODO Auto-generated method stub
		
	}

	protected void creerCCroisiere() {
		// TODO Auto-generated method stub
		
	}

	protected void creerCFerroviaire() {
		// TODO Auto-generated method stub
		
	}

	protected void creerCAerienne() {
		
		panelMain.removeAll();
		panelMain.add(panelFields);
		
		panelFields.removeAll();
		GridLayout l = new GridLayout(5,2);
		l.setVgap(10);
		l.setHgap(20);
		panelFields.setLayout(l);
		
		panelFields.add(new JLabel("Nom"));
		JTextField nom = new JTextField();
		panelFields.add(nom);

		panelFields.add(new JLabel("ID"));
		JTextField id = new JTextField();
		panelFields.add(id);

		panelFields.add(new JLabel("Prix"));
		JTextField prix = new JTextField();
		panelFields.add(prix);
		
		JButton ok = new JButton("OK");
		panelFields.add(ok);
		
		JButton retour = new JButton("Retour");
		panelFields.add(retour);
		
		panelMain.revalidate();
		panelMain.repaint();
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (nom.getText().equals("") || id.getText().equals("") || prix.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Remplir tous les champs");
				} else {
					if (!DataBaseCompagnies.getInstance().checkCompagnieAerienne(id.getText())) {
						Boolean b = DataBaseCompagnies.getInstance().newCompagnieAerienne(nom.getText(), id.getText(), Float.valueOf(prix.getText()));
						if (b) {
							JOptionPane.showMessageDialog(frame, "Compagnie créé");
						} else {
							JOptionPane.showMessageDialog(frame, "Compagnie non créé");
						}
					} else {
						JOptionPane.showMessageDialog(frame, "Compagnie existante");
					}
				}
			}
		});
		
		retour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuMethode(1);
			}
		});
	}
		
}
