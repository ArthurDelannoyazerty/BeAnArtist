package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;

public class PanneauBarreEtatTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PanneauBarreEtatTest();
			}
		});

	}
	
	public PanneauBarreEtatTest() {
		test();
	}
	
	private void test() {
		PanneauDessin panneauDessin = new PanneauDessin();
		PanneauBarreEtat panneauBarreEtat = new PanneauBarreEtat(panneauDessin);
		JFrame fenetre = new JFrame("PanneauBarreEtatTest");
		
		OutilLigne outilLigne = new OutilLigne();
		panneauDessin.associerOutil(outilLigne);
		
		panneauDessin.add(panneauBarreEtat, BorderLayout.EAST);
		
		fenetre.add(panneauDessin);
		fenetre.setPreferredSize(new Dimension(PanneauDessin.LARGEUR_PAR_DEFAUT,PanneauDessin.HAUTEUR_PAR_DEFAUT));
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}
