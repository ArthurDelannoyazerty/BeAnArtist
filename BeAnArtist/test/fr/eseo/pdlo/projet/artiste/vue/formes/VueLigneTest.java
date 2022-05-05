package fr.eseo.pdlo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueLigneTest {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueLigneTest();
			}
		});
	}
	
	public VueLigneTest() {
		test();
	}
	
	private void test() {
		Ligne ligne1 = new Ligne(new Coordonnees(10, 15),100,150);
		Ligne ligne2 = new Ligne();

		VueLigne vue1 = new VueLigne(ligne1);
		VueLigne vue2 = new VueLigne(ligne2);
		
		PanneauDessin panel = new PanneauDessin();

		panel.ajouterVueForme(vue1);
		panel.ajouterVueForme(vue2);
		
		JFrame frame = new JFrame("testLigneVue");
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
