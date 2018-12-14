package testfly;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/** 地面 */
public class Ground{
	BufferedImage image;
	int x, y;
	int width;
	int height;
	public Ground() throws Exception {
		image = ImageIO.read(
		  new File("D:\\1 study\\作业\\java\\flappy_birds\\src\\testfly\\ground.png"));
		width = image.getWidth();
		height = image.getHeight();
		x = 0;
		y = 500;
	}//地面的构造器结束
	//地面的类体中,添加方法，地面移动一步
	public void step(){
		x--;
		if(x==-109){
			x = 0;
		}
	}
}//地面类的结束