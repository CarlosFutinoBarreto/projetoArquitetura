package gameElements;

import java.util.ArrayList;
import java.util.List;

import observer.Observer;
import observer.Subject;

/*Classe que guarda as flechas (Arrow)
 * 
 * Implementa o Object Pool
 * */
public class Quiver extends Subject{

	private final int ARROW_QT = 6;
	
	private List<Arrow> arrows;
	
	private int createdArrows;

	public Quiver() {
		super();
		this.createdArrows = 0;
		this.arrows = new ArrayList<Arrow>();
	}
	
	public Arrow getArrow(int x,int y,int limits) {
		Arrow arrow = null;
		if (this.arrows.size()>0) {
			arrow = this.arrows.get(0);
			this.arrows.remove(arrow);
			
		}else {
			if (this.createdArrows<ARROW_QT) {
				arrow = new Arrow(limits);
				this.createdArrows++;
			}
		}
		if (arrow!=null) {
			arrow.pickup(x, y);
		}
		return arrow;
	}

	
	public void aquireArrow(Arrow arrow) {
		this.arrows.add(arrow);
		this.report();
	}

	
}
