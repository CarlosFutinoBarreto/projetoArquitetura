package gameElements;

import observer.Observer;
import observer.Subject;

/*
 * Classe da pontuação
 * Implementa um Observer pois foi especificado
 * Implementa também um Subject para poder ser observado pelo 
 * elemento gráfico que atualiza a pontuação na tela
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
