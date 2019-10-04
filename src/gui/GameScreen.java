package gui;


import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import gameElements.ScoreBoard;
import gui.misc.KeyboarManager;

public class GameScreen extends JFrame {

	private final int QT_LINHAS = 20;
	
	public GameScreen() {
		super();
		setTitle("Arrows Game");
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		GamePanel gp = new GamePanel(QT_LINHAS);
		this.add(gp);
		
		ScoreBoard score= new ScoreBoard();
		gp.attach(score);
		
		ScoreBoardPanel sp = new ScoreBoardPanel(score);
		this.add(sp);
		
		this.pack();
		
		KeyboarManager.setKeys(gp);
		
		 MenuBar menuBar = new MenuBar();
		 setMenuBar(menuBar);
		 
		 Menu menu = new Menu("Controller Settings");
		 MenuItem item = new MenuItem("Configure");
		 menu.add(item);
		 
		 item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new ConfigCommand(gp);	
				
			}
		});
		 menuBar.add(menu);
		 
	}
	
	
	public void run() {
		this.setSize(GamePanel.IMAGE_SIZE*QT_LINHAS, GamePanel.IMAGE_SIZE*QT_LINHAS+10);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		setLocationRelativeTo(null);		
	}
}
