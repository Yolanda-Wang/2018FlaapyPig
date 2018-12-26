package testfly;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gameover extends JFrame{
	BufferedImage gameoverImg;
	BufferedImage background;

	public int score;
	gameover(int s) throws IOException{
		score = s;
		background = ImageIO.read(
				new File("I:\\eclipse-workplace\\FF\\Image\\birdbg.png")); 
		gameoverImg= ImageIO.read(
				new File("I:\\eclipse-workplace\\FF\\Image\\birdgameover.png"));
	}
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
		g.drawImage(gameoverImg, 0, 0,null);
		Font f = new Font(Font.SANS_SERIF,Font.BOLD,40);
		g.setFont(f);
		g.drawString(" "+score, 190, 285);
		g.setColor(Color.red);
		g.drawString(" "+score, 190-3, 285-3);
	}
}
