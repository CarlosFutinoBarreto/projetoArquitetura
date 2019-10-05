package gui.misc;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import gui.GamePanel;

public class KeyboarManager {

	public static void setKeys(GamePanel gp) {

		KeyboardFocusManager.getCurrentKeyboardFocusManager()
				.addKeyEventDispatcher(new KeyEventDispatcher() {
					@Override
					public boolean dispatchKeyEvent(KeyEvent e) {
						if (e.getID()==KeyEvent.KEY_PRESSED) {
							if (e.getKeyCode() == gp.getUp().getKey()) {
								gp.getUp().execute(gp);
							}else if (e.getKeyCode() == gp.getDown().getKey()) {
								gp.getDown().execute(gp);
							}else if (e.getKeyCode() == gp.getRight().getKey()) {
								gp.getRight().execute(gp);
							}else if (e.getKeyCode() == gp.getLeft().getKey()) {
								gp.getLeft().execute(gp);
							}
						}else if (e.getKeyCode() == gp.getShoot().getKey()) {
							gp.getShoot().execute(gp);
						}
						return false;
					}
				});
	}

}
