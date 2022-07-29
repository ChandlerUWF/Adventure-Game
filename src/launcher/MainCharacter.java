package launcher;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MainCharacter {
	public int charPosX, charPosY;
	public int charVelocity;
	
	GamePanel panel;
	InputHandler userInput;
	
	public BufferedImage knightUp1, knightUp2, knightUp3, knightUp4, knightUp5, knightUp6, knightUp7, knightUp8,
						knightDown1, knightDown2, knightDown3, knightDown4, knightDown5, knightDown6, knightDown7, knightDown8,
						knightLeft1, knightLeft2, knightLeft3, knightLeft4, knightLeft5, knightLeft6, knightLeft7, knightLeft8, 
						knightRight1, knightRight2, knightRight3, knightRight4, knightRight5, knightRight6, knightRight7, knightRight8;
						
	public String direction;
	public int imageCount;
	public int imageNum;
	
	public MainCharacter(GamePanel panel, InputHandler userInput) {
		this.panel = panel;
		this.userInput = userInput;
		charPosX = 250;
		charPosY = 250;
		charVelocity = 4;
		direction = "down";
		imageCount = 0;
		imageNum = 1;
		getCharacterPics();
	}
	/*
	public void setDefaultValues() {
		x = 100;
		y = 100;
		velocity = 4;
	}
	*/
	
	public void getCharacterPics() {
		try {
			knightUp1 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_up_1.png"));
			knightUp2 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_up_2.png"));
			knightUp3 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_up_3.png"));
			knightUp4 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_up_4.png"));
			knightUp5 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_up_5.png"));
			knightUp6 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_up_6.png"));
			knightUp7 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_up_7.png"));
			knightUp8 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_up_8.png"));
			
			knightDown1 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_down_1.png"));
			knightDown2 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_down_2.png"));
			knightDown3 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_down_3.png"));
			knightDown4 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_down_4.png"));
			knightDown5 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_down_5.png"));
			knightDown6 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_down_6.png"));
			knightDown7 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_down_7.png"));
			knightDown8 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_down_8.png"));
			
			knightLeft1 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_left_1.png"));
			knightLeft2 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_left_2.png"));
			knightLeft3 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_left_3.png"));
			knightLeft4 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_left_4.png"));
			knightLeft5 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_left_5.png"));
			knightLeft6 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_left_6.png"));
			knightLeft7 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_left_7.png"));
			knightLeft8 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_left_8.png"));
			
			knightRight1 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_right_1.png"));
			knightRight2 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_right_2.png"));
			knightRight3 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_right_3.png"));
			knightRight4 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_right_4.png"));
			knightRight5 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_right_5.png"));
			knightRight6 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_right_6.png"));
			knightRight7 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_right_7.png"));
			knightRight8 = ImageIO.read(getClass().getResourceAsStream("/maincharacter/Knight_right_8.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePlayerPos() {
		//Updates player's position based on key pressed
		//Called 60 times per second
		if(userInput.upKey == true || userInput.downKey == true || userInput.leftKey == true || userInput.rightKey == true) {
			if(userInput.upKey == true) {
				direction = "up";
				charPosY -= charVelocity; 
			}
			else if(userInput.downKey == true) {
				direction = "down";
				charPosY += charVelocity;
			}
			else if(userInput.leftKey == true) {
				direction = "left";
				charPosX -= charVelocity;
			}
			else if(userInput.rightKey == true) {
				direction = "right";
				charPosX += charVelocity;
			}
			
			imageCount++;
			if(imageCount > 4) {
				if(imageNum == 1) {
					imageNum = 2;
				}
				else if(imageNum == 2) {
					imageNum = 3;
				}
				else if(imageNum == 3) {
					imageNum = 4;
				}
				else if(imageNum == 4) {
					imageNum = 5;
				}
				else if(imageNum == 5) {
					imageNum = 6;
				}
				else if(imageNum == 6) {
					imageNum = 7;
				}
				else if(imageNum == 7) {
					imageNum = 8;
				}
				else if(imageNum == 8) {
					imageNum = 1;
				}
				imageCount = 0;
			}
		}
	}
	
	public void renderPlayer(Graphics2D g2) {
		BufferedImage image = null;
		
		if(direction == "up") {
			if(imageNum == 1) {
				image = knightUp1;
			}
			if(imageNum == 2) {
				image = knightUp2;
			}
			if(imageNum == 3) {
				image = knightUp3;
			}
			if(imageNum == 4) {
				image = knightUp4;
			}
			if(imageNum == 5) {
				image = knightUp5;
			}
			if(imageNum == 6) {
				image = knightUp6;
			}
			if(imageNum == 7) {
				image = knightUp7;
			}
			if(imageNum == 8) {
				image = knightUp8;
			}
		}
		else if(direction == "down") {
			if(imageNum == 1) {
				image = knightDown1;
			}
			if(imageNum == 2) {
				image = knightDown2;
			}
			if(imageNum == 3) {
				image = knightDown3;
			}
			if(imageNum == 4) {
				image = knightDown4;
			}
			if(imageNum == 5) {
				image = knightDown5;
			}
			if(imageNum == 6) {
				image = knightDown6;
			}
			if(imageNum == 7) {
				image = knightDown7;
			}
			if(imageNum == 8) {
				image = knightDown8;
			}
		}
		else if(direction == "left") {
			if(imageNum == 1) {
				image = knightLeft1;
			}
			if(imageNum == 2) {
				image = knightLeft2;
			}
			if(imageNum == 3) {
				image = knightLeft3;
			}
			if(imageNum == 4) {
				image = knightLeft4;
			}
			if(imageNum == 5) {
				image = knightLeft5;
			}
			if(imageNum == 6) {
				image = knightLeft6;
			}
			if(imageNum == 7) {
				image = knightLeft7;
			}
			if(imageNum == 8) {
				image = knightLeft8;
			}
		}
		else if(direction == "right") {
			if(imageNum == 1) {
				image = knightRight1;
			}
			if(imageNum == 2) {
				image = knightRight2;
			}
			if(imageNum == 3) {
				image = knightRight3;
			}
			if(imageNum == 4) {
				image = knightRight4;
			}
			if(imageNum == 5) {
				image = knightRight5;
			}
			if(imageNum == 6) {
				image = knightRight6;
			}
			if(imageNum == 7) {
				image = knightRight7;
			}
			if(imageNum == 8) {
				image = knightRight8;
			}
		}
		
		g2.drawImage(image, charPosX, charPosY, panel.tileSize, panel.tileSize, null);
		
		/*
		g2.setColor(Color.blue);
		g2.fillRect(charPosX, charPosY, panel.tileSize, panel.tileSize);
		*/
	}
}
