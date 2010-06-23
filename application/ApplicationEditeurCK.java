package application;

import java.awt.Dimension;
import java.awt.Point;
import java.io.FileNotFoundException;

import vue.VueEditeurCK;

import modele.CKModel;
import modele.Concept;
import modele.Knowledge;
import modele.TreeLayout;
import application.Constante;


public class ApplicationEditeurCK {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	
	public static void CreateK(CKModel<String,String> _modele, int _idK, int _idC){

		System.out.println(Constante.taperK);
		String kChaine = Saisie.saisieChaine();
		Knowledge<String> K = new Knowledge<String>(_idK,kChaine);
		_modele.setElementKSpace(K);
		_idK++;
		System.out.println(Constante.lienC);
		for(int i=0; i<_idC; i++){
			System.out.println(_modele.researchIdConcept(i).toString());
		}
		int numlien = Saisie.saisieValeur();
		while(numlien < -1 || numlien > _idC){
			System.out.println(Constante.erreur);
			System.out.println(Constante.lienC);
			for(int i=0; i<_idC; i++){
				System.out.println(_modele.researchIdConcept(i).toString());
			}
			numlien = Saisie.saisieValeur();
		}
		if(numlien != -1){
		_modele.addLink(_modele.researchIdConcept(numlien), K);
		}
		
	}
	
	
	public static void CreateC(CKModel<String,String> _modele, int _idK, int _idC){

		System.out.println(Constante.partC);
		for(int i=0; i<_idC; i++){
			System.out.println(_modele.researchIdConcept(i).toString());
		}
		int numPere = Saisie.saisieValeur();
		while(numPere < 0 || numPere > _idC){
			System.out.println(Constante.erreur);
			System.out.println(Constante.partC);
			for(int i=0; i<_idC; i++){
				System.out.println(_modele.researchIdConcept(i).toString());
			}
			numPere = Saisie.saisieValeur();
		}
		
		System.out.println(Constante.partK + Constante.partK2);
		for (int i = 0; i<_modele.getKSpace().size(); i++){
			_modele.getKSpace().get(i).toString();
		}
		int part = Saisie.saisieValeur();
		if(part ==  -1){
			System.out.println(Constante.taperK);
			String kChaine = Saisie.saisieChaine();
			Knowledge<String> K = new Knowledge<String>(_idK,kChaine);
			_modele.setElementKSpace(K);
			part = _idK;
			_idK++;
		} else{
			while (part < -1 || part > _idK){
				System.out.println(Constante.erreur);
				System.out.println(Constante.partK);
				for (int i = 0; i<_modele.getKSpace().size(); i++){
					_modele.getKSpace().get(i).toString();
				}
				part = Saisie.saisieValeur();
			}
		}
		System.out.println(Constante.taperC);
		String chaine = Saisie.saisieChaine();
		Concept<String> C = new Concept<String>(_idC,chaine);
		_idC++;
		_modele.setCSpace(C);
		_modele.addLink(C, _modele.getKSpace().elementAt(part));
	
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
/*		int idC = 0, idK = 0;
		
		CKModel<String, String> modele = new CKModel<String, String>();
		System.out.println(Constante.demandeC0);
		String chaineC = Saisie.saisieChaine();
		Concept<String> C0 = new Concept<String>(idC,chaineC);
		idC++;
		modele.setCSpace(C0);
		
		System.out.println(Constante.demandeK0);
		String chaineK = Saisie.saisieChaine();
		Knowledge<String> K0 = new Knowledge<String>(idK,chaineK);
		modele.setElementKSpace(K0);
		idK++;
		modele.addLink(C0, K0);
		
		String recommence, choix;
		
		do{
			System.out.println(Constante.demandeCorK);
			choix = Saisie.saisieChaine();
			while(choix.compareTo("c") != 0 && choix.compareTo("k") != 0){
				System.out.println(Constante.erreur);
				System.out.println(Constante.demandeCorK);
				choix = Saisie.saisieChaine();
			}
			if (choix.compareTo("k") == 0){
				CreateK(modele, idK, idC);
			}
			if (choix.compareTo("c") == 0){
				CreateC(modele, idK, idC);
			}
			
			
			
		System.out.println(Constante.continuer);
		recommence = Saisie.saisieChaine();
		} while(recommence.compareTo("oui") == 0);
		
		modele.print(); */
		
		CKModel<String, String> modele = new CKModel<String, String>();
		System.out.println("Entrez un C0, tapez Entrée pour valider");
		String chaineC = Saisie.saisieChaine();
		Point p = new Point(32,34);
		Point p2 =  new Point (67, 56);
		Dimension d = new Dimension (50,50);
		Concept<String> C0 = new Concept<String>(0,chaineC,p);
		modele.setCSpace(C0);
		Concept<String> C1 = new Concept<String>(1, "fils1", p);
		modele.addConcept(C1);
		Concept<String> C2 = new Concept<String>(2, "fils2", p2);
		modele.addConcept(C2);
		Concept<String> C3 = new Concept<String>(3, "fils11", p);
		modele.partition(C3, C1);
		
		Knowledge<String> K0 = new Knowledge<String>(0,"know0", p);
		Knowledge<String> K1 = new Knowledge<String>(1,"know1", p);
		Knowledge<String> K2 = new Knowledge<String>(2,"know2", p, d);
		Knowledge<String> K3 = new Knowledge<String>(3,"know3", p);
		Knowledge<String> K4 = new Knowledge<String>(4,"know4", p);

		Knowledge<String> K5 = new Knowledge<String>(5,"know5", p);

		Knowledge<String> K6 = new Knowledge<String>(6,"know6", p);

		Knowledge<String> K7 = new Knowledge<String>(7,"know7", p, d);

		Knowledge<String> K8 = new Knowledge<String>(8,"know8", p);

		Knowledge<String> K9 = new Knowledge<String>(9,"know9", p);

		Knowledge<String> K10 = new Knowledge<String>(10,"know10", p);

		Knowledge<String> K11 = new Knowledge<String>(11,"know11", p);
		Knowledge<String> K12 = new Knowledge<String>(12,"know12", p);
		Knowledge<String> K13 = new Knowledge<String>(13,"know13", p);

		
		modele.setElementKSpace(K0);
		modele.setElementKSpace(K1);
		modele.setElementKSpace(K2);
		modele.setElementKSpace(K3);
		modele.setElementKSpace(K4);
		modele.setElementKSpace(K5);
		modele.setElementKSpace(K6);
		modele.setElementKSpace(K7);
		modele.setElementKSpace(K8);
	/*	modele.setElementKSpace(K9);
		modele.setElementKSpace(K10);
		modele.setElementKSpace(K11);
		modele.setElementKSpace(K12);
		modele.setElementKSpace(K13);*/

		
		modele.addLink(C0, K0);
		modele.addLink(C3, K2);
		modele.addLink(C2, K1);
		TreeLayout tl  = new TreeLayout(modele);
		tl.buildTree();
		System.out.println(modele.toString());
		modele.print();
		
		modele.save();
		modele.load();
		
		System.out.println(modele.toString());
		modele.print();
		
		
		VueEditeurCK vue = new VueEditeurCK(modele);
		vue.dessiner();
		vue.getPanel().paint(vue.getPanel().getGraphics());
		
	} 
		

}
