package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEllipseTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueEllipseTest();
			}
		});
	}
	
	public VueEllipseTest() {
		test();
	}
	
	private void test() {
		Ellipse ellipse1 = new Ellipse(new Coordonnees(50,50),25,100);
		Ellipse ellipse2 = new Ellipse();
		
		ellipse1.setCouleur(new Color(200,0,0));
		
		ellipse2.setRemplissage(Remplissage.UNIFORME);
		
		VueEllipse vue1 = new VueEllipse(ellipse1);
		VueEllipse vue2 = new VueEllipse(ellipse2);
		
		PanneauDessin panel = new PanneauDessin();

		panel.ajouterVueForme(vue1);
		panel.ajouterVueForme(vue2);
		
		JFrame frame = new JFrame("testEllipseVue");
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
