package gui;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gameElements.ScoreBoard;
import observer.Observer;

public class ScoreBoardPanel extends JPanel implements Observer{
	
	private JTextField txScore;
	
	public ScoreBoardPanel(ScoreBoard score) {
		super();
		
		score.attach(this);
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setSize(100,10);
		
		JLabel lScore = new JLabel("Pontuação: ");
		this.add(lScore);
		
		this.txScore = new JTextField();
		this.txScore.setEditable(false);
		this.txScore.setText("0");
		
		this.add(this.txScore);
	}

	@Override
	public void update(Object mensagem) {
		ScoreBoard score = (ScoreBoard) mensagem;
		this.txScore.setText(Integer.toString(score.getScore()));
	}

	
	
}
