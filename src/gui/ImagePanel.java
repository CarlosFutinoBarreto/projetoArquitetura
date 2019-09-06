package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private Image img;
	
	private void setImage(String path) {
		ImageIcon ic = new ImageIcon(path);
		this.img = ic.getImage();
	}
	
	public ImagePanel(String path) {
		super();
		this.setImage(path);
	}
	
	@Override
	public void paintComponent(Graphics graph) {
		super.paintComponent(graph);
		Graphics2D g2d = (Graphics2D) graph;
		g2d.drawImage(img, 0, 0, null);
	}
	
	public void changeImage(String path) {
		this.setImage(path);
		this.revalidate();
		this.repaint();
	}
	
}
