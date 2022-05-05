package fr.eseo.pdlo.projet.artiste.controleur.outils;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilCercleTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new OutilCercleTest();
			}
		});
	}

	public OutilCercleTest() {
		test();
	}
	
	private void test() {
		PanneauDessin panel = new PanneauDessin();
		panel.associerOutil(new OutilCercle());
		
		JFrame frame = new JFrame("testOutilCercle");
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}
