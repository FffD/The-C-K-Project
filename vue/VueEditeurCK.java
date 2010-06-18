package vue;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;






public class VueEditeurCK {
	
	
	private JFrame editorFrame;
	private PanelCK pnlCK;
	private JTextField TextFieldProposition;
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
	
	
	
		public VueEditeurCK(){

			
		

			editorFrame = new JFrame();
			editorFrame.setTitle("Simple C-K Editor 1.0 (alpha) Ecole des Mines ParisTech");
			editorFrame.setSize(new Dimension(800, 600));
			editorFrame.setLocation(300,100);
			editorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set to
																		// exit when
																		// we close
																		// the frame
			

			

	

	
			// Set up a GridBag Layout
			editorFrame.getContentPane().setLayout(new GridBagLayout());
			constraints = new GridBagConstraints();
	
			// Initialize and Add the TextField to the top of the window
			TextFieldProposition = new JTextField("Tapez votre texte ici"); // initialize
			
			// Les deux méthodes setSelectionStart & setSelectionEnd permettent 
			// de mettre le texte en surbrillance pour qu'il puisse être éffacé au clique
			TextFieldProposition.setSelectionStart(0);
			TextFieldProposition.setSelectionEnd(TextFieldProposition.getText().length());
			constraints.gridy = 0; // set to the top (line 0)
			constraints.gridwidth = GridBagConstraints.REMAINDER; // one column only
			constraints.fill = GridBagConstraints.HORIZONTAL; // fill the whole
																// column width
			editorFrame.add(TextFieldProposition, constraints); // add
	
			//TextFieldProposition.addFocusListener(this);
			//TextFieldProposition.addMouseListener(this);
	
			// Add the Panel under the TextField
			constraints.fill = GridBagConstraints.BOTH; // fill all the space left
			constraints.gridy = 1; // set under textField (line 1)
			constraints.weightx = 1;
			constraints.weighty = 1;
			
			pnlCK = new PanelCK();
			
			editorFrame.add(pnlCK,constraints);

			
			
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
			editorFrame.setJMenuBar(barreMenu);
			
		
	}
	
			
	/**
	* @return the editorFrame
	*/
	public JFrame getEditorFrame(){
		return editorFrame;
	}
	
	
	/**
	* @return the width editorFrame 
	*/
	public int getFrameWidth(){
		return editorFrame.getWidth();
	}
	
	
	/**
	* @return the height editorFrame 
	*/
	public int getFrameHeight(){
		return editorFrame.getHeight();
	}
	
	
	public void dessiner(){
		editorFrame.setVisible(true);
	}

	
	/**
	 * @return the JTextField
	 */
	public JTextField getTextField(){
		return TextFieldProposition;
	}

	/**
	 * @return the text
	 */
	public String getPropositionTextField(){
		return TextFieldProposition.getText();
	}
	
	
	public void setPropositionTextField(String mot){
		TextFieldProposition.setText(mot);
	}

}
