package gui;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JDialog;
import javax.swing.JTextField;

public class ConfigCommand extends JDialog implements KeyListener{

	private JTextField txtInputCommand;
	private GamePanel gp;
	private int countCommands = 0;
	
	
	public ConfigCommand(GamePanel gp) {
		this.gp = gp;
        this.setTitle("Setting keys");
        this.setResizable(false);
        this.setSize(150, 150);
        this.setMinimumSize(new Dimension(200, 100));
		
        this.txtInputCommand = new JTextField();
        this.txtInputCommand.setEditable(false);
        this.txtInputCommand.setText("  INPUT KEY FOR UP...");
        this.txtInputCommand.setHorizontalAlignment(JTextField.CENTER);
        this.txtInputCommand.addKeyListener(this);
        this.add(this.txtInputCommand);
		
        this.pack();        
        
        this.setVisible(true);
        this.setLocationRelativeTo(null);	 		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (countCommands) {
		case 0:
			gp.getUp().setKey(e.getKeyCode());
			this.txtInputCommand.setText("  INPUT KEY FOR DOWN...");
			countCommands++;
			break;
		case 1:
			gp.getDown().setKey(e.getKeyCode());
			this.txtInputCommand.setText("  INPUT KEY FOR LEFT...");
			countCommands++;
			break;
		case 2:
			gp.getLeft().setKey(e.getKeyCode());
			this.txtInputCommand.setText("  INPUT KEY FOR RIGHT...");
			countCommands++;
			break;
		case 3:
			gp.getRight().setKey(e.getKeyCode());
			this.txtInputCommand.setText("  INPUT KEY FOR SHOOT...");
			countCommands++;
			break;			
		case 4:
			gp.getShoot().setKey(e.getKeyCode());
			setVisible(false);
			dispose();				
			break;				
		default:		
			break;
		}	
		
	}

	@Override
	public void keyReleased(KeyEvent e) {		
		// TODO Auto-generated method stub
	}

}
