package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.eseo.pdlo.projet.artiste.controleur.outils.Outil;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.utils.StoreNames;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class PanneauDessin extends JPanel {
	
	//private Color couleurCourante;

	public static final int LARGEUR_PAR_DEFAUT = StoreNames.LARGEUR_PANNEAU_DESSIN;
	public static final int HAUTEUR_PAR_DEFAUT = StoreNames.HAUTEUR_PANNEAU_DESSIN;
	public static final Color COULEUR_FOND_PAR_DEFAUT = Color.WHITE;

	private final List<VueForme> vueFormes;
	
	private Outil outilCourant;
	private Color couleurCourante;
	private Remplissage remplissageCourant;

	public PanneauDessin() {
		this(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT, COULEUR_FOND_PAR_DEFAUT);
	}

	public PanneauDessin(int largeur, int hauteur, Color fond) {
		this.setPreferredSize(new Dimension(largeur, hauteur));
		this.setBackground(fond);
		this.setVisible(true);
		this.vueFormes = new ArrayList<>();
		this.outilCourant = null;
		this.couleurCourante = Forme.COULEUR_PAR_DEFAUT;
		this.setModeRemplissageCourant(Remplissage.AUCUNE);
	}

	public List<VueForme> getVueFormes() {
		return this.vueFormes;
	}
	
	public Color getCouleurCourante() {
		return this.couleurCourante;
	}
	
	public void setCouleurCourante(Color couleur) {
		this.couleurCourante = couleur;
	}

	public void ajouterVueForme(VueForme vueForme) {
		this.vueFormes.add(vueForme);
	}
	
	public void retirerVueForme(VueForme vueForme) {
		if(vueForme != null) {
			this.vueFormes.remove(vueForme);
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g.create();
		boolean antialiasing = false;
		if(antialiasing) {
			g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		}
		
		
		for (VueForme vf : getVueFormes()) {
			vf.affiche(g2D);
		}
		g2D.dispose();
	}
	
	public void associerOutil(Outil outil) {
		if(outil!=null) {
			if(this.getOutilCourant() != null) {
				this.dissocierOutil();
			}
			this.setOutilCourant(outil);
			this.getOutilCourant().setPanneauDessin(this);
			this.addMouseListener(this.getOutilCourant());
			this.addMouseMotionListener(this.getOutilCourant());
		}
	}
	
	public void dissocierOutil() {
		this.getOutilCourant().setPanneauDessin(null);
		this.removeMouseListener(this.getOutilCourant());
		this.removeMouseListener(this.getOutilCourant());
		this.setOutilCourant(null);
	}
	
	public Outil getOutilCourant() {
		return this.outilCourant;
	}
	
	private void setOutilCourant(Outil outil) {
		this.outilCourant = outil;
	}

	public Remplissage getModeRemplissageCourant() {
		return remplissageCourant;
	}

	public void setModeRemplissageCourant(Remplissage remplissage) {
		this.remplissageCourant = remplissage;
	}
	
}
