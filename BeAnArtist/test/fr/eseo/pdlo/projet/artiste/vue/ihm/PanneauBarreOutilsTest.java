package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;

public class PanneauBarreOutilsTest {
	public void test() {
		JFrame fenetre = new JFrame("PanneauBarreOutilsTest");
		
		PanneauDessin panneau = new PanneauDessin();
		OutilLigne outilLigne = new OutilLigne();
		panneau.associerOutil(outilLigne);
		
		PanneauBarreOutils panneauOutils = new PanneauBarreOutils(panneau);
		fenetre.add(panneauOutils, BorderLayout.EAST);
		
		fenetre.add(panneau);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(PanneauDessin.LARGEUR_PAR_DEFAUT, PanneauDessin.HAUTEUR_PAR_DEFAUT);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	}
	
	
	// CONSTRUCTEUR //
	public PanneauBarreOutilsTest() {
		test();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@SuppressWarnings("unused")
			@Override
			public void run() {
				PanneauBarreOutilsTest test = new PanneauBarreOutilsTest();
			}
		});
	}
}
