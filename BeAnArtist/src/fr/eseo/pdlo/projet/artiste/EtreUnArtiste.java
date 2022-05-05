package fr.eseo.pdlo.projet.artiste;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.pdlo.projet.artiste.utils.StoreNames;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class EtreUnArtiste {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				EtreUnArtiste main = new EtreUnArtiste();
				if (args.length != 3) {
					main.defaultLaunch();
				}
				else {
					main.customLaunch(args[0], args[1], args[2]);
				}
			}
		});
	}

	protected void defaultLaunch() {
		JFrame fenetre = new JFrame(StoreNames.NOM_FENETRE);
		
		PanneauDessin panneau = new PanneauDessin();
		OutilLigne outilLigne = new OutilLigne();
		panneau.associerOutil(outilLigne);
		
		PanneauBarreOutils panneauOutils = new PanneauBarreOutils(panneau);
		fenetre.add(panneauOutils, BorderLayout.EAST);
		
		PanneauBarreEtat panneauEtat = new PanneauBarreEtat(panneau);
		fenetre.add(panneauEtat, BorderLayout.SOUTH);
		
		fenetre.add(panneau);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(PanneauDessin.LARGEUR_PAR_DEFAUT, PanneauDessin.HAUTEUR_PAR_DEFAUT);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	}

	protected void customLaunch(String string, String string2, String string3) {
		JFrame fenetre = new JFrame(string);
		
		PanneauDessin panneau = new PanneauDessin();
		OutilLigne outilLigne = new OutilLigne();
		panneau.associerOutil(outilLigne);
		
		PanneauBarreOutils panneauOutils = new PanneauBarreOutils(panneau);
		fenetre.add(panneauOutils, BorderLayout.EAST);
		
		PanneauBarreEtat panneauEtat = new PanneauBarreEtat(panneau);
		fenetre.add(panneauEtat, BorderLayout.SOUTH);
		
		fenetre.add(panneau);
		
		int largeur = PanneauDessin.LARGEUR_PAR_DEFAUT;
		if (isValidNumber(string2)) {
			largeur = Integer.parseInt(string2);
		}
		
		int hauteur = PanneauDessin.HAUTEUR_PAR_DEFAUT;
		if (isValidNumber(string3)) {
			hauteur = Integer.parseInt(string3);
		}

		fenetre.setSize(largeur, hauteur);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setResizable(false);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	}
	
	private boolean isValidNumber(String str) {
		try{              
            Integer.parseInt(str);
            return true;
        }
		catch(NumberFormatException nfe){
			return false;
      }
	}


	
	

}
