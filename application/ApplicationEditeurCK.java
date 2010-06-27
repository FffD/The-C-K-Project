package application;

import java.io.FileNotFoundException;

import vue.VueEditeurCK;

import modele.CKModel;
import modele.Concept;
import modele.Knowledge;
import modele.TreeLayout;
import application.Consts;

public class ApplicationEditeurCK {

	public static void main(String[] args) {

		CKModel<String, String> modele = new CKModel<String, String>();

		// Initialize CK with C0 and K0
		init(modele);

		// Construct Graph through dialog with user
		constructCKDialogLoop(modele);

	}

	/**
	 * Permet d'initialiser le CK en demandant un C0 et un K0 à l'utilisateur et
	 * en creant le lien entre les deux
	 * 
	 * @param modele
	 */
	private static void init(CKModel<String, String> modele) {
		// Demander C0 à l'utilisateur
		System.out.println(Consts.initialC);
		// Creation du concept CO
		Concept<String> C0 = new Concept<String>(0, Saisie.saisieChaine());

		modele.setCSpace(C0);

		// Demander K0 à l'utilisateur
		System.out.println(Consts.initialK);
		Knowledge<String> K0 = new Knowledge<String>(0, Saisie.saisieChaine());
		
		modele.addKnowledge(K0);

		// Lien CO-KO
		modele.addLink(C0, K0);
	}

	/**
	 * Permet de construire le CK en dialoguant avec l'utilisateur
	 * 
	 * @param modele
	 */
	private static void constructCKDialogLoop(CKModel<String, String> modele) {

		String choix;

		// Boucle (Loop)
		do {

			// Proposer une liste d'actions
			System.out.println(Consts.inputAction);
			choix = Saisie.saisieChaine();
			
			//TODO faire quelque chose de plus élégant peut être avec un switch/case
			
			if (choix.compareTo("k") == 0) { // ajouter une connaissance
				addKnowledge(modele);
			}
			if (choix.compareTo("c") == 0) { // partitionner un concept
				partitionConcept(modele);
			}
			if (choix.compareTo("s") == 0) { // enregistrer
				save(modele);
			}
			if (choix.compareTo("l") == 0) { // charger
				try {
					loadTo(modele);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (choix.compareTo("v") == 0) { // lancer la visualization
				visualize(modele);
			} else {
				System.out.println(Consts.errorInput);
				modele.print();
			}

		} while (true); // boucler à l'infini

	}

	/**
	 * Dialoguer avec l'utilisateur pour ajouter de la connaissance
	 * 
	 * @param _modele
	 */
	private static void addKnowledge(CKModel<String, String> _modele) {

		System.out.println(Consts.inputK);
		String kChaine = Saisie.saisieChaine();
		Knowledge<String> K = new Knowledge<String>(_modele.getKSize(), kChaine);
		_modele.addKnowledge(K);
		System.out.println(Consts.inputLinkCtoK);
		for (int i = 0; i < _modele.getCSize(); i++) {
			System.out.println(_modele.findConceptFromId(i).toString());
		}
		int numlien = Saisie.saisieValeur();
		while (numlien < -1 || numlien > _modele.getCSize()) {
			System.out.println(Consts.errorInput);
			System.out.println(Consts.inputLinkCtoK);
			for (int i = 0; i < _modele.getCSize(); i++) {
				System.out.println(_modele.findConceptFromId(i).toString());
			}
			numlien = Saisie.saisieValeur();
		}
		if (numlien != -1) {
			_modele.addLink(_modele.findConceptFromId(numlien), K);
		}

	}

	/**
	 * Dialoguer avec l'utilisateur pour partitionner un concept
	 * 
	 * @param _modele
	 * @param _idK
	 * @param _idC
	 */
	private static void partitionConcept(CKModel<String, String> _modele) {

		System.out.println(Consts.inputCtoPartition);
		for (int i = 0; i < _modele.getCSize(); i++) {
			System.out.println(_modele.findConceptFromId(i).toString());
		}
		int fatherId = Saisie.saisieValeur();
		while (fatherId < 0 || fatherId > _modele.getCSize()) {
			System.out.println(Consts.errorInput);
			System.out.println(Consts.inputCtoPartition);
			for (int i = 0; i < _modele.getCSize(); i++) {
				System.out.println(_modele.findConceptFromId(i).toString());
			}
			fatherId = Saisie.saisieValeur();
		}

		System.out.println(Consts.inputKtoPartitionC);
		for (int i = 0; i < _modele.getKSize(); i++) {
			_modele.getKSpace().get(i).toString();
		}
		int part = Saisie.saisieValeur();
		if (part == -1) {
			System.out.println(Consts.inputK);
			String kChaine = Saisie.saisieChaine();
			Knowledge<String> K = new Knowledge<String>(_modele.getKSize(), kChaine);
			_modele.addKnowledge(K);
			part = _modele.getKSize();
		} else {
			while (part < -1 || part > _modele.getKSize()) {
				System.out.println(Consts.errorInput);
				System.out.println(Consts.inputKtoPartitionC);
				for (int i = 0; i < _modele.getKSpace().size(); i++) {
					_modele.getKSpace().get(i).toString();
				}
				part = Saisie.saisieValeur();
			}
		}
		System.out.println(Consts.inputC);
		String chaine = Saisie.saisieChaine();
		Concept<String> child = new Concept<String>(_modele.getCSize(), chaine);
		
		// Get father concept
		Concept<String> father = _modele.findConceptFromId(fatherId);
		
		_modele.partition(child, father);
		_modele.addLink(child, _modele.getKSpace().elementAt(part));

	}

	/**
	 * Enregistrer le CK dans un fichier XML
	 * 
	 * @param model
	 */
	private static void save(CKModel model) {
		// TODO verifier l'extention xml et l'ajouter si elle n'y est pas
		System.out.println(Consts.inputFilename);
		model.save(Saisie.saisieChaine());

	}

	/**
	 * Charger un fichier XML dans le model CK
	 * 
	 * @param model
	 * @throws FileNotFoundException
	 */
	private static void loadTo(CKModel<String, String> model)
			throws FileNotFoundException {
		// TODO verifier l'extenstion xml et l'ajouter si elle n'y est pas
		System.out.println(Consts.inputFilename);
		model.load(Saisie.saisieChaine());

	}

	private static void visualize(CKModel<String, String> modele) {

		TreeLayout tl = new TreeLayout(modele);
		tl.buildTree();
		System.out.println(modele.toString());
		modele.print();

		VueEditeurCK vue = new VueEditeurCK(modele);
		vue.dessiner();
		vue.getPanel().paint(vue.getPanel().getGraphics());
	}

}
