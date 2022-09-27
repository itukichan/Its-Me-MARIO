package Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
public class Panel extends JPanel{
	
	public BufferedImage image;
	//Image img = Toolkit.getDefaultToolkit().getImage("Sample.png");
	
	public Panel() {
		super();
		this.image = new BufferedImage(1000,600,BufferedImage.TYPE_INT_RGB);
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image,0,0,this);
		
	}
	
	public void draw() {
		this.repaint();
	}
}
