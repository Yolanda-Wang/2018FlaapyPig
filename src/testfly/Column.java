package testfly;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

/** 柱子类型，x,y是柱子的中心点的位置 */
class Column{
	BufferedImage image;
	int x,y;
	int width, height;
	/** 柱子中间的缝隙 */
	int gap;
	int distance;//距离，两个柱子之间的距离
	Random random = new Random();
	/** 构造器：初始化数据，n代表第几个柱子 */
	public Column(int n) throws Exception {
		image=ImageIO.read(
		  new File("I:\\eclipse-workplace\\FF\\Image\\birdcolumn.png"));
		width = image.getWidth();
		height = image.getHeight();
		gap=144;
		distance = 245;
		x = 550+(n-1)*distance;
		y = random.nextInt(218)+132;
	}
	//在Column中添加方法 step，在action调用此方法
	public void step(){
		x--;
		if(x==-width/2){
			x = distance * 2 - width/2;
			y = random.nextInt(218)+132;
		}
	}
}//Column类的结束