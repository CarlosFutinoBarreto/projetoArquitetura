package gameElements;

import observer.Observer;
import observer.Subject;

/*
 * Classe da pontua��o
 * Implementa um Observer pois foi especificado
 * Implementa tamb�m um Subject para poder ser observado pelo 
 * elemento gr�fico que atualiza a pontua��o na tela
 */
public class ScoreBoard extends Subject implements Observer {

	private int score;
	
	public ScoreBoard() {
		super();
		this.score=0;
	}
	
	@Override
	public void update(Object mensagem) {
		this.score++;
		report();
	}
	
	public int getScore() {
		return this.score;
	}

}
