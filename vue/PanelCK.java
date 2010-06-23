package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import modele.CKModel;
import modele.Concept;




public class PanelCK extends JPanel {

	static final long serialVersionUID = 12345;
	private CKModel<String,String> _modele;
	private final int LARGEURELLIPSE = 50;
	private final int LONGUEURELLIPSE = 30;
	
	public PanelCK(CKModel<String, String> modele){
		this._modele = modele;
	}
		
	public void paint (Graphics g){
		g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
		g.drawString("Concept",this.getWidth()/5, 20);
		g.drawString("Knowledge",(int) (this.getWidth()/1.40), 20);
		
		int espaceRectangle = 0;
		
		for (int i=0; i<_modele.getKSpace().size(); i++){
			
			if (_modele.getKSpace().elementAt(i).getDimension() != null){
				
				espaceRectangle = espaceRectangle + _modele.getKSpace().elementAt(i).getDimension().height;
				
			} else {
				
				espaceRectangle = espaceRectangle + 20;
			}
		}
		
		
		int espaceLibre = ((this.getHeight()) - espaceRectangle)/(_modele.getKSpace().size() + 1);
		int pointY = espaceLibre + 20;
		
		for (int i=0; i<_modele.getKSpace().size(); i++){
			
			if (_modele.getKSpace().elementAt(i).getDimension() != null){
				
				g.drawRect((this.getWidth()/2) + 20, pointY, this.getWidth() - ((this.getWidth()/2) + 40), _modele.getKSpace().elementAt(i).getDimension().height);
				g.drawString(_modele.getKSpace().elementAt(i).getData(),(this.getWidth()/2) + 30 , pointY + 15);
				pointY+= espaceLibre+_modele.getKSpace().elementAt(i).getDimension().height;
				
			} else {
				
				g.drawRect((this.getWidth()/2) + 20, pointY, this.getWidth() - ((this.getWidth()/2) + 40), 20);
				g.drawString(_modele.getKSpace().elementAt(i).getData(),(this.getWidth()/2) + 30 , pointY + 15);
				pointY+=espaceLibre+20;
			}
			Point p = new Point((this.getWidth()/2) + 20, pointY);
			_modele.getKSpace().elementAt(i).setPosition(p);
		}
		int center =  center(_modele.getCSpace());
		
		for (int i=0; i<_modele.getCSize(); i++){
			g.drawOval(_modele.researchIdConcept(i).getPositionX() + center,_modele.researchIdConcept(i).getPositionY() , LARGEURELLIPSE, LONGUEURELLIPSE);
			g.drawString(_modele.researchIdConcept(i).getData(), _modele.researchIdConcept(i).getPositionX() + center + (LARGEURELLIPSE/5), _modele.researchIdConcept(i).getPositionY() +(2* (LONGUEURELLIPSE/3)));
		}	
		drawEdge(g, _modele.getCSpace(), center);
		
		
		for (int i=0; i<_modele.getCSize(); i++){
			for (int j=0; j<_modele.getKSpace().size(); j++){
				if(_modele.getCKLinks()[i][j]){
					g.drawLine(_modele.researchIdConcept(i).getPositionX() + center + LARGEURELLIPSE, _modele.researchIdConcept(i).getPositionY() + (LONGUEURELLIPSE/2), (this.getWidth()/2) + 20,  _modele.getKSpace().elementAt(j).getPosition().y );
				}
			}
		}
		g.dispose();
	}
	
	public int center(Concept<String> c){
		return (this.getWidth()/4) - (c.getPositionX() + (LARGEURELLIPSE/2));
	}
	
	public void drawEdge(Graphics g, Concept<String> concept, int center ){
		for (Concept<String> element : concept.getChildren()){
			g.drawLine(concept.getPositionX() + center + (LARGEURELLIPSE/2), concept.getPositionY() + LONGUEURELLIPSE, element.getPositionX() + center + (LARGEURELLIPSE/2), element.getPositionY());
			drawEdge(g,element, center);
		}
	}
	
	
}
