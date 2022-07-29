package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import launcher.GamePanel;

public class TileHandler {
	GamePanel gp;
	BackgroundTile[] tile;
	int mapTileNum[][];
	
	public TileHandler(GamePanel gp) {
		this.gp = gp;
		tile = new BackgroundTile[10];
		mapTileNum = new int[gp.tilesPerCol][gp.tilesPerRow];
		getTileImage();
		loadMap("/maps/mapSample.txt");
	}
	
	public void getTileImage() {
		try {
			
			tile[0] = new BackgroundTile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/GroundTile.png"));
			
			tile[1] = new BackgroundTile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/BlankSpace.png"));
			
			tile[2] = new BackgroundTile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/LeftWall.png"));

			tile[3] = new BackgroundTile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/RightWall.png"));

			tile[4] = new BackgroundTile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/UpWall.png"));
			
			tile[5] = new BackgroundTile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/LowerBackWall.png"));
			
			tile[6] = new BackgroundTile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/UpperBackWall.png"));
			
			tile[7] = new BackgroundTile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/UpperLeftCorner.png"));
			
			tile[8] = new BackgroundTile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/UpperRightCorner.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String mapFile) {
		try {
			InputStream is = getClass().getResourceAsStream(mapFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.tilesPerCol && row < gp.tilesPerRow) {
				String line = br.readLine();
				
				while(col < gp.tilesPerCol) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.tilesPerCol) {
					col = 0;
					row++;
				}
			}
			br.close();
			
		}catch(Exception e) {
			
		}
	}
	
	public void draw(Graphics2D g2) {
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < gp.tilesPerCol && row < gp.tilesPerRow) {
			int tileNum = mapTileNum[col][row];
			g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
			col++;
			x += gp.tileSize;
			
			if(col == gp.tilesPerCol) {
				col = 0;
				x = 0;
				row++;
				y += gp.tileSize;
			}
		}
	}
}
