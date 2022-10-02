package Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Game.Map.Map01;

public class Panel extends JPanel{
	
	public BufferedImage image;
	Map01 map = new Map01();
	Camera came = new Camera();
	
	public Panel() {
		super();
		this.image = new BufferedImage(map.getMap01()[0].length*30,600,BufferedImage.TYPE_INT_RGB);
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image,came.Coordinate(),0,this);
		
	}
	
	public void draw() {
		this.repaint();
	}
}
