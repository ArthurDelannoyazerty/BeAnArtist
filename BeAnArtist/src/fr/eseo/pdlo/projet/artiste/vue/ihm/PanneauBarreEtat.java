package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class PanneauBarreEtat extends JPanel implements MouseMotionListener{

	private final PanneauDessin panneauDessin;
	private JLabel valeurX;
	private JLabel valeurY;
	
	public PanneauBarreEtat(PanneauDessin panneausDessin){
		this.panneauDessin = panneausDessin;
		this.valeurX = new JLabel("x: 0");
		this.valeurY = new JLabel("y: 0");

		this.add(this.valeurX, BorderLayout.EAST);
		this.add(this.valeurY, BorderLayout.EAST);
		
		this.panneauDessin.addMouseMotionListener(this);
		this.panneauDessin.setLayout(new FlowLayout());
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Coordonnees coord = new Coordonnees(e.getX(),e.getY());
		mettreAJourAffichage(coord);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Coordonnees coord = new Coordonnees(e.getX(),e.getY());
		mettreAJourAffichage(coord);
	}
	
	private void mettreAJourAffichage(Coordonnees coords) {
		this.valeurX.setText("x: "+coords.getAbscisse());
		this.valeurY.setText("y: "+coords.getOrdonnee());
	}

}
