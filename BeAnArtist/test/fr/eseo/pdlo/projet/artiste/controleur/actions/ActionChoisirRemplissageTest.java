package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirRemplissageTest {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new ActionChoisirRemplissageTest();
			}
		});
	}
	
	public ActionChoisirRemplissageTest() {
		test();
	}
	
	
	private void test() {
		JFrame fenetre = new JFrame("ActionChoisirRemplissageTest");
		
		PanneauDessin panneau = new PanneauDessin();
		OutilLigne outilLigne = new OutilLigne();
		panneau.associerOutil(outilLigne);
		
		PanneauBarreOutils panneauOutils = new PanneauBarreOutils(panneau);
		fenetre.add(panneauOutils, BorderLayout.EAST);
		
		fenetre.add(panneau);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(PanneauDessin.LARGEUR_PAR_DEFAUT, PanneauDessin.HAUTEUR_PAR_DEFAUT);
		fenetre.setResizable(false);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	}
	
	
}
