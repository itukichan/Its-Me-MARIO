package Game;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Frame extends JFrame {
	public Panel panel;
	
	public Frame() {
		
		panel = new Panel();
		
		this.add(panel);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
				Mario.loop = false;
			}
		});
		
		//key設定
		this.addKeyListener(new Keyboard());
		
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Mario");
		this.pack();
		this.setSize( 1000,600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
}
