package modele;

import java.util.List;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import application.Consts;



public class CKModel<T,S> {
	//Nombre maximal de C ou de K dans un modèle:
	private static int _size = 30;
	
	//L'espace C est un concept (qui comporte l'ensemble de l'arborescence.)
	private Concept<T> _cSpace;
	
	//L'espace K: un vecteur
	private KSpace<Knowledge<S>> _kSpace;
	
	// Un tableau a double entrée pour les liens entre C et K
	private boolean[][] _ckLinks;
	
	// Nombre de concepts et de knowledge
	private int _cSize;
	private int _kSize;
	
	//Constructeur
	public CKModel(){
		setCSpace(new Concept<T>());
		setKSpace(new KSpace<Knowledge<S>>());
		setCKLinks(new boolean[_size][_size]);
		setCSize(1);
	}
	
	/*
	 * Getters et Setters
	 */
	
	/**
	 * @param _cSpace the _cSpace to set
	 */
	public void setCSpace(Concept<T> _cSpace) {
		this._cSpace = _cSpace;
	}

	/**
	 * @return the _cSpace
	 */
	public Concept<T> getCSpace() {
		return _cSpace;
	}

	/**
	 * @param _kSpace the _kSpace to set
	 */
	public void setKSpace(KSpace<Knowledge<S>> _kSpace) {
		this._kSpace = _kSpace;
	}

	/**
	 * @return the _kSpace
	 */
	public KSpace<Knowledge<S>> getKSpace() {
		return _kSpace;
	}

	/**
	 * @param _ckLinks the _ckLinks to set
	 */
	public void setCKLinks(boolean[][] _ckLinks) {
		this._ckLinks = _ckLinks;
	}

	/**
	 * @return the _ckLinks
	 */
	public boolean[][] getCKLinks() {
		return _ckLinks;
	}
	
	/**
	 * @param _cSize the _cSize to set
	 */
	public void setCSize(int _cSize) {
		this._cSize = _cSize;
	}

	/**
	 * @return the _cSize
	 */
	public int getCSize() {
		return _cSize;
	}

	/**
	 * @param _kSize the _kSize to set
	 */
	public void setKSize(int _kSize) {
		this._kSize = _kSize;
	}

	/**
	 * @return the _kSize
	 */
	public int getKSize() {
		return _kSize;
	}

	/*
	 * Les opérateurs
	 */
	// K->K
	public void addKnowledge(Knowledge<S> knowledge){
		_kSpace.add(knowledge);
		_kSize++;
	}
	
	public void removeKnowledge(Knowledge<S> knowledge){
		_kSpace.remove(knowledge);
		removeLinks(knowledge);
		_kSize--;
	}
	
	
	public void removeConcept(int i){
		_cSpace.removeChildAt(i);
		_cSize--;
		removeLinks(i);
	}
	
	//C->C
	public void partition(Concept<T> child, Concept<T> parent){
		if(_cSpace.researchIdConcept(parent.getIndex()).getIndex() != -1){
		parent.addChild(child);
		_cSize++;
		}
	}
	
	public void departition(Concept<T> nouveauC0){
		nouveauC0.addChild(this._cSpace);
		this.setCSpace(nouveauC0);
		_cSize++;
	}
	
	//C->K et K->C
	public void addLink(Concept<T> concept, Knowledge<S> knowledge){
		if(_cSpace.researchIdConcept(concept.getIndex()).getIndex() != -1){
			_ckLinks[knowledge.getIndex()][concept.getIndex()] =  true;
		}
	}
	
	public void removeLink(Concept<T> concept, Knowledge<S> knowledge){
		_ckLinks[knowledge.getIndex()][concept.getIndex()] =  false;
	}
	
	public void removeLinks(int indice){
		for(int i=0; i<_kSpace.size(); i++){
			_ckLinks[i][indice] = false;
		}
	}
	
	public void removeLinks(Knowledge<S> knowledge){
		for(int i=0; i<_size; i++){
			_ckLinks[knowledge.getIndex()][i] = false;
		}
	}
	
	/*
	 * Méthodes de visualisation
	 */
	
	public String toString(){
		return "C-Space : " + _cSpace.toStringArborescence() +"\nK-Space : " + _kSpace.toString();
	}
	
	// Méthode pour afficher le modèle sous forme texte.
	public void print(){
		
		// Afficher l'espace C avec les K associés entre parenthèse
		for (int i=0; i<_cSize; i++){
			System.out.print(_cSpace.researchIdConcept(i).toString() + "( ");
			for (int j=0; j<_kSpace.size(); j++){
				if(_ckLinks[j][_cSpace.researchIdConcept(i).getIndex()]){
					System.out.print(_kSpace.elementAt(j).toString() + ", ");
				}
			}
			System.out.println(" )");
		}
		
		System.out.println("\n");
		
		//Afficher l'espace K avec les C associés entre parenthèse
		for(int i=0; i<_kSpace.size(); i++){
			System.out.print(_kSpace.elementAt(i).toString() + "( ");
			for(int j=0; j<_cSize; j++){
				if(_ckLinks[_kSpace.elementAt(i).getIndex()][j]){
					System.out.print(_cSpace.researchIdConcept(j).toString() + ", ");
				}
			}
			System.out.println(" )");
		}
		
	}
	
	// TODO: a quoi sert cette fonction?
	public String researchDataConcept(T data){
		return _cSpace.researchDataConcept(data).toString();
	}
	
	// permet de déplacer un sous-arbre vers un autre endroit
	public void moveSubTree(Concept<T> oldParent, Concept<T> child, Concept<T> newParent){
		newParent.addChild(child);
		oldParent.removeChild(child);
	}
	
	 public List<Concept<T>> researchData(T data){
		 return _cSpace.researchDataConcept(data);
	 }
	
	 public Concept<T> findConceptFromId(int i){
		 return _cSpace.researchIdConcept(i);
	 }
	 
	 public void save() {
		save(Consts.DEFAULT_FILENAME);
	 }
	 
	 /*
	  * Méthodes pour enregistrer et charger le modèle dans un fichier XML
	  */
	public void save(String filename) {
		 
		 XMLEncoder enc;
		 
		try {
			enc = new XMLEncoder(new FileOutputStream(filename));
			enc.writeObject(_cSpace);
			enc.flush();
		enc.writeObject(_kSpace);
			enc.flush();
		enc.writeObject(_ckLinks);
			enc.flush();
			enc.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void load(String filename) throws FileNotFoundException{
		 
		XMLDecoder dec = new XMLDecoder(new FileInputStream(filename));
		for (int i=0; i<3; i++){
			
			 Object o = dec.readObject();
			 
			if (o instanceof Concept<?>){
				
				 _cSpace = (Concept<T>) o;
			   
			} else if (o instanceof KSpace<?>){
				
				_kSpace = (KSpace<Knowledge<S>>) o;
				
			} else if (o instanceof boolean[][]){
				
				_ckLinks = (boolean[][]) o;
			}
		}
		dec.close();
		
	 }
	 
}
