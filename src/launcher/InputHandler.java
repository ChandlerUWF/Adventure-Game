package launcher;

import java.awt.event.*;

public class InputHandler implements KeyListener{
	
	public boolean upKey, leftKey, downKey, rightKey;
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		//Recognizes when a particular key is pressed and updates variable accordingly
		
		int pressedKey = e.getKeyCode();
		
		if(pressedKey == KeyEvent.VK_W) {
			upKey = true;
		}
		if(pressedKey == KeyEvent.VK_A) {
			leftKey = true;
		}
		if(pressedKey == KeyEvent.VK_S) {
			downKey = true;
		}
		if(pressedKey == KeyEvent.VK_D) {
			rightKey = true;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		//Recognizes when a particular key is released and updates variable accordingly
		
		int releasedKey = e.getKeyCode();
		
		if(releasedKey == KeyEvent.VK_W) {
			upKey = false;
		}
		if(releasedKey == KeyEvent.VK_A) {
			leftKey = false;
		}
		if(releasedKey == KeyEvent.VK_S) {
			downKey = false;
		}
		if(releasedKey == KeyEvent.VK_D) {
			rightKey = false;
		}
	}
}