package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PanneauDessinTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PanneauDessinTest();
			}
		});

	}
	
	public PanneauDessinTest() {
		testConstructeurParDefaut();
		testConstructeur();
	}
	
	private void testConstructeurParDefaut() {
		PanneauDessin fenetre = new PanneauDessin();
		JFrame frame = new JFrame("Etre un Artiste");
		frame.add(fenetre);
		frame.setPreferredSize(new Dimension(PanneauDessin.LARGEUR_PAR_DEFAUT,PanneauDessin.HAUTEUR_PAR_DEFAUT));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void testConstructeur() {
		PanneauDessin fenetre2 = new PanneauDessin(500,500,java.awt.Color.WHITE);
		JFrame frame = new JFrame("Blues du Businessman");
		frame.add(fenetre2);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
