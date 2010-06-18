package vue;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelCK extends JPanel {
	
	public void paintComponent(Graphics g){
        
		g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
} 

}
