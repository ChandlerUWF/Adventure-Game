package launcher;

import javax.swing.JFrame;

public class Launcher {

	public static void main(String[] args) {
		
		JFrame gameWindow = new JFrame();
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setResizable(false);
		gameWindow.setTitle("Adventure Game");
		
		GamePanel adventurePanel = new GamePanel();
		gameWindow.add(adventurePanel);
		gameWindow.pack();
		
		gameWindow.setLocationRelativeTo(null);
		gameWindow.setVisible(true);

		adventurePanel.startThread();
	}

}