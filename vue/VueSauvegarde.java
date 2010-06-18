package vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VueSauvegarde {
	
	
	private JFrame frameSauvegarde;
	private JPanel panelSaveB;
	private JPanel panelSaveH;
	private JLabel lblDemande;
	private JButton btnSaveGraphItem;
	private JButton btnNoSaveGraphItem;
	private JButton cancel;
	
	
	public VueSauvegarde(){
		
		frameSauvegarde = new JFrame();
		panelSaveB = new JPanel();
		panelSaveH = new JPanel();
		lblDemande = new JLabel("Voulez-vous enregistrer les modifications faites à votre graphe ?");
		btnSaveGraphItem = new JButton("Enregistrer");
		btnNoSaveGraphItem = new JButton("Ne pas enregistrer");
		cancel = new JButton("Annuler");
		
		panelSaveB.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelSaveB.add(btnSaveGraphItem);
		panelSaveB.add(btnNoSaveGraphItem);
		panelSaveB.add(cancel);
		panelSaveH.add(lblDemande);
		frameSauvegarde.setTitle("Simple C-K Editor 1.0 (alpha) Ecole des Mines ParisTech");
		frameSauvegarde.setSize(500, 100);
		frameSauvegarde.add(panelSaveH, BorderLayout.NORTH);
		frameSauvegarde.add(panelSaveB, BorderLayout.SOUTH);
		frameSauvegarde.setLocation(400, 300);
		frameSauvegarde.setResizable(false);
		frameSauvegarde.setVisible(true);
		
	}
	
	
	public void dessiner(){
		frameSauvegarde.setVisible(true);
	}

}
