package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JApplet;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import modele.CKModel;

public class AppletEditeur {
	private CKModel<String, String> _modele;
	
	private JApplet app;
	
	private PanelCK pnlCK;
	private GridBagConstraints constraints;
	
	
	private JMenuBar barreMenu;
	private JMenu actionMenu;
	private JMenu help;
	private JMenuItem savePNGItem;
	private JMenuItem saveGraphItem;
	private JMenuItem loadGraphItem;
	private JMenuItem close;
	private JMenuItem createGraphCK;
	private JMenuItem actionHelp;
	
	
	public AppletEditeur(CKModel<String, String> modele){
		this._modele = modele;
		
	}

	public void init(){
		
		app.setName("Simple C-K Editor 1.0 (alpha) Ecole des Mines ParisTech");
		app.setSize(new Dimension(800, 600));
		app.setLocation(300,100);


		// Set up a GridBag Layout
		app.getContentPane().setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();


		// Add the Panel under the TextField
		constraints.fill = GridBagConstraints.BOTH; // fill all the space left
		constraints.gridy = 0; // set under textField (line 1)
		constraints.weightx = 1;
		constraints.weighty = 1;
		
		pnlCK = new PanelCK(_modele);
		pnlCK.setBackground(Color.white);
		app.add(pnlCK,constraints);

		
		
		actionMenu = new JMenu("Actions");
		help = new JMenu("Aide");

		/*
		 * Save to file
		 */
		saveGraphItem = new JMenuItem("Enregistrer le graphe");
		actionMenu.add(saveGraphItem);
		
		/*
		 * Load a file
		 */
		loadGraphItem = new JMenuItem("Charger un graphe");
		actionMenu.add(loadGraphItem);
		
		actionMenu.addSeparator();
		
		/*
		 * Save to PNG Item
		 */
		savePNGItem = new JMenuItem("Exporter en image");
		actionMenu.add(savePNGItem);
		
		actionMenu.addSeparator();
		
		close = new JMenuItem("Quitter");
		actionMenu.add(close);
		
		
		/*
		 * Explication sur la création d'un arbre C-K
		 */
		createGraphCK = new JMenuItem("Comment créer un arbre C-K");
		help.add(createGraphCK);
		
		/*
		 * Explication sur les différente action du menu action
		 */
		actionHelp = new JMenuItem("Aide Actions");
		help.add(actionHelp);
		
		barreMenu = new JMenuBar();
		barreMenu.add(actionMenu);
		barreMenu.add(help);

		// Add the menu to the container
		app.setJMenuBar(barreMenu);
		
	}
	
	public void dessiner(){
		this.app.setVisible(true);
	}
 
	
	
	
}
