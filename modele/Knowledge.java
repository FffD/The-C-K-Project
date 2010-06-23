package modele;

import java.awt.Dimension;
import java.awt.Point;

public class Knowledge<T> {
	
	private Integer _index;
	private T _data;
	private Point _position;
	private Dimension _dimension;

	
	public Knowledge(){
		this.setIndex(null);
		this.setData(null);
		this.setPosition(null);
		this.setDimension(null);
	}
	
	public Knowledge(Integer index){
		this.setIndex(index);
		this.setData(null);
		this.setPosition(null);
		this.setDimension(null);
	}
	
	public Knowledge(Integer index, T data){
		this.setIndex(index);
		this.setData(data);
		this.setPosition(null);
		this.setDimension(null);
	}
	
	public Knowledge(Integer index, T data, Point position){
		this.setIndex(index);
		this.setData(data);
		this.setPosition(position);
		this.setDimension(null);
	}
	
	public Knowledge(Integer index, T data, Point position, Dimension dimension){
		this.setIndex(index);
		this.setData(data);
		this.setPosition(position);
		this.setDimension(dimension);
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
	 * @param _dimension the _dimension to set
	 */
	public void setDimension(Dimension _dimension) {
		this._dimension = _dimension;
	}

	/**
	 * @return the _dimension
	 */
	public Dimension getDimension() {
		return _dimension;
	}

	public String toString(){
		return "K" + this._index + " : " + this._data;
	}

}
