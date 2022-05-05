package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCercleTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueCercleTest();
			}
		});
	}
	
	public VueCercleTest() {
		test();
	}
	
	private void test() {
		Cercle cercle1 = new Cercle(new Coordonnees(50,50), 100);
		Cercle cercle2 = new Cercle();
		
		cercle2.setCouleur(new Color(255, 0, 0));
		
		VueEllipse vue1 = new VueEllipse(cercle1);
		VueEllipse vue2 = new VueEllipse(cercle2);
		
		PanneauDessin panel = new PanneauDessin();

		panel.ajouterVueForme(vue1);
		panel.ajouterVueForme(vue2);
		
		JFrame frame = new JFrame("testCercleVue");
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
