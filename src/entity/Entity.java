package entity;

import java.awt.image.BufferedImage;

public class Entity {
	
	public int worldX, worldY;
	public int speed;
	
	public BufferedImage knightUp1, knightUp2, knightUp3, knightUp4, knightUp5, knightUp6, knightUp7, knightUp8,
							knightDown1, knightDown2, knightDown3, knightDown4, knightDown5, knightDown6, knightDown7, knightDown8,
							knightLeft1, knightLeft2, knightLeft3, knightLeft4, knightLeft5, knightLeft6, knightLeft7, knightLeft8, 
							knightRight1, knightRight2, knightRight3, knightRight4, knightRight5, knightRight6, knightRight7, knightRight8;
	public String direction;
	
	public int imageCount = 0;
	public int imageNum = 1;
}
