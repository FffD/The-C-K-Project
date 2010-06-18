package vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class VueHelp {
	
	private JFrame frameCreateGraphCK;
	private JPanel pnlCreateGraphCK;
	private JPanel pnlActionHelp;
	private JTextArea textCreateGraphCK;
	private JTextArea textActionHelp;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane2;
	
	
	public VueHelp(){
		
		frameCreateGraphCK = new JFrame();
		pnlCreateGraphCK = new JPanel();
		pnlActionHelp = new JPanel();
		
		frameCreateGraphCK.setTitle("Aide");
		frameCreateGraphCK.setLocation(300,300);
		frameCreateGraphCK.setSize(800, 130);
		
		textCreateGraphCK = new JTextArea("- Créer un noeud : Pour créér un noeud, " +
													"tapez une proposition puis double-cliquez " +
													"dans la partie ou vous souhaitez le voir apparaitre " + System.getProperty("line.separator") +
													"- Créer un lien : Pour créer un lien, " +
													"double-cliquez sur le noeud de départ, " +
													"puis cliquez sur le noeud d'arrivé " + System.getProperty("line.separator") +
													"- Modifier un noeud/lien : Pour modifier un noeud/lien, " +
													"il faut effectuer un clique droit dessus " + System.getProperty("line.separator") +
													"- Déplacer un noeud : Pour déplacer un noeud, " +
													"il faut cliquez dans la zone  ou l'on veut déplacer le noeud, " +
													"puis appuyer sur la touche 'p'",5,10);
		textCreateGraphCK.setLineWrap(true);
		textCreateGraphCK.setEditable(false);
		scrollPane = new JScrollPane(textCreateGraphCK, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pnlCreateGraphCK.setLayout(new BorderLayout());
		pnlCreateGraphCK.add(scrollPane, BorderLayout.CENTER);
		
		
		textActionHelp = new JTextArea("Exporter en image : Permet d'effectuer une sauvegarde en image " +
													"de l'arbre C-K " + System.getProperty("line.separator") +
													"Enregistrer le graphe : Permet d'enregistrer le travail effectuer, " +
													"sous forme de fichier de sauvegarde " + System.getProperty("line.separator") +
													"Charger un graphe : Permet de charger un fichier de sauvegarde, " +
													"pour continuer son travail",5,10);
		textActionHelp.setLineWrap(true);
		textActionHelp.setEditable(false);
		scrollPane2 = new JScrollPane(textActionHelp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pnlActionHelp.setLayout(new BorderLayout());
		pnlActionHelp.add(scrollPane2, BorderLayout.CENTER);
		
		
	}
	
	
	public JFrame getFrameCreateGraphCK(){
		return frameCreateGraphCK;
	}
	
	public JPanel getPnlCreateGraphCK(){
		return pnlCreateGraphCK;
	}
	
	public JPanel getPnlActionHelp(){
		return pnlActionHelp;
	}
	
	public void dessiner(){
		frameCreateGraphCK.setVisible(true);
	}
	
	
	

}
