package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirModeRemplissage;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.utils.StoreNames;

public class PanneauBarreOutils extends JPanel{
	
	private PanneauDessin panneauDessin;
	
	public PanneauBarreOutils(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.initComponents();
	}
	
	private void initComponents() {
		
		Dimension dimension = new Dimension(200,30);
		ButtonGroup btnGroupForme = new ButtonGroup();
		
		//Formes
		JLabel txtForme = new JLabel(StoreNames.TEXTE_LABEL_FORME);
		txtForme.setMaximumSize(dimension);
		this.add(txtForme);
		
		JToggleButton btnLigne = new JToggleButton(new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_LIGNE));
		btnLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
		btnLigne.setMaximumSize(dimension);
		btnGroupForme.add(btnLigne);
		this.add(btnLigne);
		btnLigne.setSelected(true);
		
		
		JToggleButton btnEllipse = new JToggleButton(new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_ELLIPSE));
		btnEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		btnEllipse.setMaximumSize(dimension);
		btnGroupForme.add(btnEllipse);
		this.add(btnEllipse);
		
		
		JToggleButton btnCercle = new JToggleButton(new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_CERCLE));
		btnCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
		btnCercle.setMaximumSize(dimension);
		btnGroupForme.add(btnCercle);
		this.add(btnCercle);
		
		
		JToggleButton btnRectangle = new JToggleButton(new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_RECTANGLE));
		btnRectangle.setName(ActionChoisirForme.NOM_ACTION_RECTANGLE);
		btnRectangle.setMaximumSize(dimension);
		btnGroupForme.add(btnRectangle);
		this.add(btnRectangle);
		
		
		JToggleButton btnCarre = new JToggleButton(new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_CARRE));
		btnCarre.setName(ActionChoisirForme.NOM_ACTION_CARRE);
		btnCarre.setMaximumSize(dimension);
		btnGroupForme.add(btnCarre);
		this.add(btnCarre);
		
		//Actions
		JLabel txtAction = new JLabel(StoreNames.TEXTE_LABEL_ACTION);
		txtAction.setMaximumSize(dimension);
		this.add(txtAction);
		
		JToggleButton btnSelectionner = new JToggleButton(new ActionSelectionner(this.panneauDessin));
		btnSelectionner.setName(ActionSelectionner.NOM_ACTION);
		btnGroupForme.add(btnSelectionner);
		btnSelectionner.setMaximumSize(dimension);
		this.add(btnSelectionner);
		
		
		JButton btnEffacer = new JButton(new ActionEffacer(this.panneauDessin));
		btnEffacer.setName(ActionEffacer.NOM_ACTION);
		btnEffacer.setMaximumSize(dimension);
		this.add(btnEffacer);
		
		//Couleur
		JLabel txtCouleur = new JLabel(StoreNames.TEXTE_LABEL_COULEUR);
		txtAction.setMaximumSize(dimension);
		txtCouleur.setMaximumSize(dimension);
		this.add(txtAction);
		
		JButton btnCouleur = new JButton(new ActionChoisirCouleur(this.panneauDessin));
		btnCouleur.setName(ActionChoisirCouleur.NOM_ACTION);
		btnCouleur.setMaximumSize(dimension);
		this.add(btnCouleur);
		
		//Remplissage
		JLabel txtRemplissage = new JLabel(StoreNames.TEXTE_LABEL_REMPLISSAGE);
		txtRemplissage.setMaximumSize(dimension);
		txtRemplissage.setMaximumSize(dimension);
		this.add(txtRemplissage);
		
		ButtonGroup btnGroupRemplissage = new ButtonGroup();

		JToggleButton btnRemplissageNul = new JToggleButton(new ActionChoisirModeRemplissage(panneauDessin, Remplissage.AUCUNE));
		btnRemplissageNul.doClick();
		btnGroupRemplissage.add(btnRemplissageNul);
		btnRemplissageNul.setMaximumSize(dimension);
		this.add(btnRemplissageNul);
		
		JToggleButton btnRemplissageRempli = new JToggleButton(new ActionChoisirModeRemplissage(panneauDessin, Remplissage.UNIFORME));
		btnGroupRemplissage.add(btnRemplissageRempli);
		btnRemplissageRempli.setMaximumSize(dimension);
		this.add(btnRemplissageRempli);
	}
	
}
