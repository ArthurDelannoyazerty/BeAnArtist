package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilCarre;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilRectangle;
import fr.eseo.pdlo.projet.artiste.utils.StoreNames;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirForme extends AbstractAction{

	public static final String NOM_ACTION_LIGNE   = StoreNames.TEXTE_BOUTON_LIGNE;
	public static final String NOM_ACTION_ELLIPSE = StoreNames.TEXTE_BOUTON_ELLIPSE;
	public static final String NOM_ACTION_CERCLE  = StoreNames.TEXTE_BOUTON_CERCLE;
	public static final String NOM_ACTION_RECTANGLE=StoreNames.TEXTE_BOUTON_RECTANGLE;
	public static final String NOM_ACTION_CARRE   = StoreNames.TEXTE_BOUTON_CARRE;
	private PanneauDessin panneauDessin;
	@SuppressWarnings("unused")
	private PanneauBarreOutils panneauOutils;
	private String name;
	
	
	public ActionChoisirForme(PanneauDessin panneauDessin, PanneauBarreOutils panneauOutils, String nom) {
		super(nom);
		this.panneauDessin = panneauDessin;
		this.panneauOutils = panneauOutils;
		this.name = nom;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (this.name) {
			case NOM_ACTION_LIGNE:
				this.panneauDessin.associerOutil(new OutilLigne());
				break;
			case NOM_ACTION_ELLIPSE:
				this.panneauDessin.associerOutil(new OutilEllipse());
				break;
			case NOM_ACTION_CERCLE:
				this.panneauDessin.associerOutil(new OutilCercle());
				break;
			case NOM_ACTION_CARRE:
				this.panneauDessin.associerOutil(new OutilCarre());
				break;
			case NOM_ACTION_RECTANGLE:
				this.panneauDessin.associerOutil(new OutilRectangle());
				break;
			default:
				break;
		}
		
	}
	
	
	
}
