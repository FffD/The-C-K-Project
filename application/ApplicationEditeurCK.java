package application;

import java.awt.Point;
import java.io.FileNotFoundException;

import vue.VueEditeurCK;

import modele.CKModel;
import modele.Concept;
import modele.Knowledge;
import application.Constante;


public class ApplicationEditeurCK {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
	/*	int idC = 0, idK = 0;
		
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
				System.out.println(Constante.taperK);
				String kChaine = Saisie.saisieChaine();
				Knowledge<String> K = new Knowledge<String>(idK,kChaine);
				modele.setElementKSpace(K);
				idK++;
				System.out.println(Constante.lienC);
				for(int i=0; i<idC; i++){
					System.out.println(modele.researchIdConcept(i).toString());
				}
				int numlien = Saisie.saisieValeur();
				while(numlien < -1 || numlien > idC){
					System.out.println(Constante.erreur);
					System.out.println(Constante.lienC);
					for(int i=0; i<idC; i++){
						System.out.println(modele.researchIdConcept(i).toString());
					}
					numlien = Saisie.saisieValeur();
				}
				if(numlien != -1){
				modele.addLink(modele.researchIdConcept(numlien), K);
				}
			}
			if (choix.compareTo("c") == 0){
				System.out.println(Constante.partC);
				for(int i=0; i<idC; i++){
					System.out.println(modele.researchIdConcept(i).toString());
				}
				int numPere = Saisie.saisieValeur();
				while(numPere < 0 || numPere > idC){
					System.out.println(Constante.erreur);
					System.out.println(Constante.partC);
					for(int i=0; i<idC; i++){
						System.out.println(modele.researchIdConcept(i).toString());
					}
					numPere = Saisie.saisieValeur();
				}
				
				System.out.println(Constante.partK + Constante.partK2);
				for (int i = 0; i<modele.getKSpace().size(); i++){
					modele.getKSpace().get(i).toString();
				}
				int part = Saisie.saisieValeur();
				if(part ==  -1){
					System.out.println(Constante.taperK);
					String kChaine = Saisie.saisieChaine();
					Knowledge<String> K = new Knowledge<String>(idK,kChaine);
					modele.setElementKSpace(K);
					part = idK;
					idK++;
				} else{
					while (part < -1 || part > idK){
						System.out.println(Constante.erreur);
						System.out.println(Constante.partK);
						for (int i = 0; i<modele.getKSpace().size(); i++){
							modele.getKSpace().get(i).toString();
						}
						part = Saisie.saisieValeur();
					}
				}
				System.out.println(Constante.taperC);
				String chaine = Saisie.saisieChaine();
				Concept<String> C = new Concept<String>(idC,chaine);
				idC++;
				modele.setCSpace(C);
				modele.addLink(C, modele.getKSpace().elementAt(part));
			}
			
			
			
		System.out.println(Constante.continuer);
		recommence = Saisie.saisieChaine();
		} while(recommence.compareTo("oui") == 0);
		
		modele.print(); */
		
		CKModel<String, String> modele = new CKModel<String, String>();
		System.out.println("Entrez un C0, tapez Entrée pour valider");
		String chaineC = Saisie.saisieChaine();
		Point p = new Point(32,34);
		Concept<String> C0 = new Concept<String>(0,chaineC,p);
		modele.setCSpace(C0);
		Concept<String> C1 = new Concept<String>(1, "fils1", p);
		modele.addConcept(C1);
		Concept<String> C2 = new Concept<String>(2, "fils2", p);
		modele.addConcept(C2);
		Concept<String> C3 = new Concept<String>(3, "fils13", p);
		modele.partition(C3, C1);
		
		Knowledge<String> K0 = new Knowledge<String>(0,"know0", p);
		Knowledge<String> K1 = new Knowledge<String>(1,"know1", p);
		Knowledge<String> K2 = new Knowledge<String>(2,"know2", p);
		Knowledge<String> K3 = new Knowledge<String>(3,"know3", p);
		Knowledge<String> K4 = new Knowledge<String>(4,"know4", p);
		
		modele.setElementKSpace(K0);
		modele.setElementKSpace(K1);
		modele.setElementKSpace(K2);
		modele.setElementKSpace(K3);
		modele.setElementKSpace(K4);
		
		modele.addLink(C0, K0);
		modele.addLink(C3, K2);
		modele.addLink(C2, K1);
		
		System.out.println(modele.toString());
		modele.print();
		
		modele.save();
		modele.load();
		
		System.out.println(modele.toString());
		modele.print();
		/*
		 * tracer un trait avec java 2D ou graphics 2D
		 */
		
		VueEditeurCK vue = new VueEditeurCK();
		vue.dessiner();
	} 
		

}
