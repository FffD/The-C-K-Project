package modele;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TreeLayout {
	
	protected transient Set<Concept<String>> alreadyDone = new HashSet<Concept<String>>();
	protected int _distX = 70;
	protected int _distY = 50;
	protected transient Point m_currentPoint = new Point();
	protected Map<Concept<String>, Integer> basePositions = new HashMap<Concept<String>, Integer>();
	protected CKModel<String, String> _modele;
	
	public TreeLayout(CKModel<String, String> modele){
		this._modele = modele;
	}
	
	public TreeLayout(CKModel<String, String> modele, int distX, int distY){
		this._modele = modele;
		this._distX = distX;
		this._distY = distY;
	}
	
	
	public void buildTree(){
		this.m_currentPoint = new Point(0,20);
		calculateDimensionX(_modele.getCSpace());
		m_currentPoint.x += this.basePositions.get(_modele.getCSpace())/2 + this._distX;
		buildTree(_modele.getCSpace(), m_currentPoint.x);
		
		int width = 0;
		width += basePositions.get(_modele.getCSpace());
	}
	
	protected void buildTree(Concept<String> concept, int x){
		if (!alreadyDone.contains(concept)){
			alreadyDone.add(concept);
		
			this.m_currentPoint.y += this._distY;
			this.m_currentPoint.x = x;

			concept.setPosition(m_currentPoint.getLocation());
						
			int sizeXofCurrent = basePositions.get(concept);
			
			int lastX = x - sizeXofCurrent / 2;
			
			int sizeXofChild;
			int startXofChild;
			
			for (Concept<String> element : concept.getChildren()){
				sizeXofChild = this.basePositions.get(element);
				startXofChild = lastX + sizeXofChild / 2;
				buildTree(element, startXofChild);
				lastX = lastX + sizeXofChild + _distX;
			}
			this.m_currentPoint.y  -= this._distY;
		}
	}
	
	
	private int calculateDimensionX(Concept<String> concept){
		int size = 0;
		int childrenNum = concept.getNumberOfChildren();
		
		if(childrenNum != 0){
			for (Concept<String> element : concept.getChildren()){
				size += calculateDimensionX(element) + _distX;
			}
		}
		size = Math.max(0, size - _distX);
		basePositions.put(concept, size);
		
		return size;
	}
	
	
}

