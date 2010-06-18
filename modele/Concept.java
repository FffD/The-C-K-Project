package modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Concept<T> {
	

	private Integer _index;
	private T _data;
	private Point _position;
	private List<Concept<T>> _children;
	
	
	public Concept(){
		
	}
	
	
	public Concept(Integer index ){
		this.setIndex(index);
		this.setData(null);
	}
	
	
	public Concept(Integer index, T data){
		this.setIndex(index);
		this.setData(data);
	}
	
	
	public Concept(Integer index, T data, Point position){
		this.setIndex(index);
		this.setData(data);
		this.setPosition(position);
	}


	/**
	 * @param _index the _index to set
	 */
	public void setIndex(Integer _index) {
		this._index = _index;
	}


	/**
	 * @return the _index
	 */
	public Integer getIndex() {
		return _index;
	}


	/**
	 * @param _data the _data to set
	 */
	public void setData(T _data) {
		this._data = _data;
	}


	/**
	 * @return the _data
	 */
	public T getData() {
		return _data;
	}


	/**
	 * @param _position the _position to set
	 */
	public void setPosition(Point _position) {
		this._position = _position;
	}


	/**
	 * @return the _position
	 */
	public Point getPosition() {
		return _position;
	}
	
	
	/**
	 * @return the _position X
	 */
	public int getPositionX(){
		return (int) _position.getX();
	}
	
	
	/**
	 * @return the _position Y
	 */
	public int getPositionY(){
		return (int) _position.getY();
	}
	
	public String toString(){
		return "C" + this._index + " : " + this._data;
	}
	
	
    /**
     * Return the children of Node<T>. The Tree<T> is represented by a single
     * root Node<T> whose children are represented by a List<Node<T>>. Each of
     * these Node<T> elements in the List can have children. The getChildren()
     * method will return the children of a Node<T>.
     * @return the children of Node<T>
     */
    public List<Concept<T>> getChildren() {
        if (this._children == null) {
            return new ArrayList<Concept<T>>();
        }
        return this._children;
    }
 
    /**
     * Sets the children of a Node<T> object. See docs for getChildren() for
     * more information.
     * @param children the List<Node<T>> to set.
     */
    public void setChildren(List<Concept<T>> children) {
        this._children = children;
    }
 
    /**
     * Returns the number of immediate children of this Node<T>.
     * @return the number of immediate children.
     */
    public int getNumberOfChildren() {
        if (_children == null) {
            return 0;
        }
        return _children.size();
    }
     
    /**
     * Adds a child to the list of children for this Node<T>. The addition of
     * the first child will create a new List<Node<T>>.
     * @param child a Node<T> object to set.
     */
    public void addChild(Concept<T> child) {
        if (_children == null) {
            _children = new ArrayList<Concept<T>>();
        }
        _children.add(child);
    }
     
    /**
     * Inserts a Node<T> at the specified position in the child list. Will     * throw an ArrayIndexOutOfBoundsException if the index does not exist.
     * @param index the position to insert at.
     * @param child the Node<T> object to insert.
     * @throws IndexOutOfBoundsException if thrown.
     */
    public void insertChildAt(int index, Concept<T> child) throws IndexOutOfBoundsException {
        if (index == getNumberOfChildren()) {
            // this is really an append
            addChild(child);
            return;
        } else {
            _children.get(index); //just to throw the exception, and stop here
            _children.add(index, child);
        }
    }
     
    /**
     * Remove the Node<T> element at index index of the List<Node<T>>.
     * @param index the index of the element to delete.
     * @throws IndexOutOfBoundsException if thrown.
     */
    public void removeChildAt(int index) throws IndexOutOfBoundsException {
        _children.remove(index);
    }
    
    public void removeChild(Concept<T> child) throws NullPointerException{
    	_children.remove(child);
    }
    
    public String afficher(){

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i=0;
        for (Concept<T> e : getChildren()) {
            if (i > 0) {
            sb.append(",");
            }
            sb.append(e.getData().toString());
            sb.append(e.afficher());
            i++;
        }
        sb.append("]");
        return sb.toString();
    }
 

     
    public String toStringArborescence() {
        StringBuilder sb = new StringBuilder();
    sb.append("{").append(getData().toString()).append(",[");
        int i = 0;
        for (Concept<T> e : getChildren()) {
            if (i > 0) {
            	sb.append(",");
            }
       sb.append(e.getData().toString());
       sb.append(e.afficher());
            i++;
        }
        sb.append("]").append("}");
        return sb.toString();
    }
    
    public Concept<T> researchIdConcept(int i){
    	Concept<T> c =  new Concept<T>(-1);
    	if(getIndex() == i){
    		return this;
    	} else {
    		for (Concept<T> e : getChildren()){
    			
    			if(e.researchIdConcept(i).getIndex() == i){
    				c = e.researchIdConcept(i);
    			}
    		}
    	}
    	return c;
    }
    
    public List<Concept<T>> researchDataConcept(T data){
    	
    	List<Concept<T>> liste = new ArrayList<Concept<T>>();
    	
    	if(getData().equals(data)){
    		liste.add(this);
    	}
    		for (Concept<T> e : getChildren()){
    			e.dataEqual(liste, data);
    	}
    	
    	return liste;
    }
    
    public void dataEqual(List<Concept<T>> liste, T data){
    	if(getData().equals(data)){
    		liste.add(this);
    	}
    		for (Concept<T> e : getChildren()){
    			e.dataEqual(liste, data);
    	}
    }
    

}
