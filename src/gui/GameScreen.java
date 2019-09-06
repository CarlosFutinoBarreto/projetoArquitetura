package gui;


import javax.swing.BoxLayout;
import javax.swing.JDialog;

import gameElements.ScoreBoard;
import gui.misc.KeyboarManager;

public class GameScreen extends JDialog {

	private final int QT_LINHAS = 20;
	
	public GameScreen() {
		super();
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		GamePanel gp = new GamePanel(QT_LINHAS);
		this.add(gp);
		
		ScoreBoard score= new ScoreBoard();
		gp.attach(score);
		
		ScoreBoardPanel sp = new ScoreBoardPanel(score);
		this.add(sp);
		
		this.pack();
		
		KeyboarManager.setKeys(gp);
	}
	
	public void run() {
		this.setSize(GamePanel.IMAGE_SIZE*QT_LINHAS, GamePanel.IMAGE_SIZE*QT_LINHAS+10);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
	}
}
