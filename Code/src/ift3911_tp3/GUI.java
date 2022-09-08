package ift3911_tp3;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {
	
	public static void main(String[] args) {
		display();
	}
	
	public static void display() {
		JFrame frame = new JFrame("Réservation de voyage");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(250, 250);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		JButton btnAdmin = new JButton("Administrateur");
		JButton btnClient = new JButton("Client");
		panel.add(btnAdmin);
		panel.add(btnClient);
		
		btnAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Volet volet = new Volet(true);
				volet.displayUser();
			}
		});
		
		btnClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Volet volet = new Volet(false);
				volet.displayUser();
			}
		});
		
		frame.setVisible(true);	
	}
}
