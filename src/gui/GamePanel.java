package gui;

import java.awt.GridLayout;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

import gameElements.Arrow;
import gameElements.GameCharacter;
import gameElements.ScoreBoard;
import observer.Observer;

public class GamePanel extends JPanel{

	public static final int IMAGE_SIZE=38;
	
	private int qtColsLines;
	private ImagePanel[][] panels;
	private GameCharacter gameCharacter;
	private ScoreBoard scoreBoard;
	
	public GamePanel(int qtLinhas) {
		super();
		this.gameCharacter = new GameCharacter(qtLinhas);
		this.qtColsLines = qtLinhas;
		this.setSize(IMAGE_SIZE*this.qtColsLines,IMAGE_SIZE*this.qtColsLines);
		this.setLayout(new GridLayout(this.qtColsLines,this.qtColsLines));
		this.panels = new ImagePanel[this.qtColsLines][this.qtColsLines];
		for (int linha=0;linha<this.qtColsLines;linha++) {
			for (int coluna=0;coluna<this.qtColsLines;coluna++) {
				String path="Fundo.png";
				if (linha==this.gameCharacter.getyCoordinate())
					if (coluna==this.gameCharacter.getxCoordinate())
						path="Personagem.png";
				ImagePanel ip = new ImagePanel(path);
				this.panels[linha][coluna]=ip;
				this.add(ip);
			}
		}
		
	}
	
	public void attach(Observer o) {
		gameCharacter.attach(o);
	}

	public void walk(int direction) {
		int oldLinha = this.gameCharacter.getyCoordinate();
		int oldColuna = this.gameCharacter.getxCoordinate();
		
		this.gameCharacter.walk(direction);
		
		this.setPanelImage(oldColuna,oldLinha, "Fundo.png");
		
		this.setPanelImage(this.gameCharacter.getxCoordinate(), this.gameCharacter.getyCoordinate(), "Personagem.png");
	}
	
	public void shoot() {
		new Thread() {
			
			public void run() {
				Arrow arrow = gameCharacter.shoot();
				
				if (arrow!=null) {
					int oldX=arrow.getxCoordinate();
					int oldY=arrow.getyCoordinate();
					while (arrow.fly()) {
						if ((oldX!=gameCharacter.getxCoordinate())
								|| (oldY!=gameCharacter.getyCoordinate())) {
							setPanelImage(oldX, oldY, "Fundo.png");
						}
						setPanelImage(arrow.getxCoordinate(), arrow.getyCoordinate(), "Flecha.png");
						oldX=arrow.getxCoordinate();
						oldY=arrow.getyCoordinate();
						try {
							TimeUnit.MILLISECONDS.sleep(200);
						} catch (InterruptedException e) {
						}
					}
					setPanelImage(oldX, oldY, "Fundo.png");
					gameCharacter.aquireArrow(arrow);
				}
			}
			
		}.start();
	}
	
	private void setPanelImage(int x,int y,String path) {
		ImagePanel imagePanel = this.panels[y][x];
		imagePanel.changeImage(path);
	}
	
}
