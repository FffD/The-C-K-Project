package modele;

import java.util.List;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;



public class CKModel<T,S> {
	private static int _size = 30;
	private Concept<T> _cSpace;
	private KSpace<Knowledge<S>> _kSpace;
	private boolean[][] _ckLinks;
	private int _cSize;
	

	public CKModel(){
		setCSpace(new Concept<T>());
		setKSpace(new KSpace<Knowledge<S>>());
		setCKLinks(new boolean[_size][_size]);
		setCSize(1);
	}

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

	public void setElementKSpace(Knowledge<S> knowledge){
		_kSpace.add(knowledge);
	}
	
	public void removeElementKSpace(Knowledge<S> knowledge){
		_kSpace.remove(knowledge);
		removeLinks(knowledge);
	}

	public void addConcept(Concept<T> concept){
		_cSpace.addChild(concept);
		_cSize++;
	}
	
	public void removeConcept(int i){
		_cSpace.removeChildAt(i);
		_cSize--;
		removeLinks(i);
	}
	
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
	
	public void partition(Concept<T> child, Concept<T> parent){
		if(_cSpace.researchIdConcept(parent.getIndex()).getIndex() != -1){
		parent.addChild(child);
		_cSize++;
		}
	}
	
	public void departition(Concept<T> nouveauC0){
		nouveauC0.addChild(this._cSpace);
		this.setCSpace(nouveauC0);
	}
	
	public String toString(){
		return "C-Space : " + _cSpace.toStringArborescence() +"\nK-Space : " + _kSpace.toString();
	}
	
	public void print(){
		
		
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
	
	public String researchDataConcept(T data){
		return _cSpace.researchDataConcept(data).toString();
	}
	
	public void replace(Concept<T> oldParent, Concept<T> child, Concept<T> newParent){
		
		newParent.addChild(child);
		oldParent.removeChild(child);
		
	}
	
	 public List<Concept<T>> researchData(T data){
		 return _cSpace.researchDataConcept(data);
	 }
	
	 public Concept<T> researchIdConcept(int i){
		 return _cSpace.researchIdConcept(i);
	 }
	 
	 public void save() throws FileNotFoundException{
		 
		 XMLEncoder enc = new XMLEncoder(new FileOutputStream("fichier.xml"));

		enc.writeObject(_cSpace);
			enc.flush();
		enc.writeObject(_kSpace);
			enc.flush();
		enc.writeObject(_ckLinks);
			enc.flush();
			enc.close();
	 }
	 
	 
	 public void load() throws FileNotFoundException{
		 
		XMLDecoder dec = new XMLDecoder(new FileInputStream("fichier.xml"));
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
