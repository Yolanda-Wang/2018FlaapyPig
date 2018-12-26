package testfly;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/** 鸟类型, x,y是鸟类型中心的位置 */
public class Bird{
	BufferedImage image;
	int x,y;
	int width, height;
	int size;//鸟的大小，用于碰撞检测
	
	//在Bird类中增加属性，用于计算鸟的位置
    double g;//  重力加速度
    double t;//  两次位置的间隔时间
    double v0;// 初始上抛速度
    double speed;// 是当前的上抛速度
    double s;//     是经过时间t以后的位移
    double alpha;// 是鸟的倾角 弧度单位
    //在Bird类中定义
    //定义一组（数组）图片，是鸟的动画帧
    //BufferedImage[] images;
    BufferedImage image1;
    //是动画帧数组元素的下标位置
    int index;
    
	public Bird() throws Exception {
		image=ImageIO.read(
			new File("I:\\eclipse-workplace\\FF\\Image\\bird0.png"));
		width = image.getWidth();
		height = image.getHeight();
		x = 132;
		y = 280;
		size = 10;
		g = 1;
		v0 = 10;
		t = 0.4;
		speed = v0;
		s = 0;
		alpha=0;
		image1 = ImageIO.read(
			  new File("I:\\eclipse-workplace\\FF\\Image\\bird0.png"));
	}
	//在Bird中添加飞翔(fly)的代码
	public void fly(){
		index++;
		image=image1;
	}
	//在Bird中添加鸟的移动方法
	public void step(){
		double v0 = speed;
		s = v0*t + g*t*t/2;//计算上抛运动位移
		y = y-(int)s;//计算鸟的坐标位置
		double v = v0 - g*t;//计算下次的速度
		speed = v;
		//调用Java API提供的反正切函数，计算倾角
		alpha = Math.atan(s/8);
	}
	//在Bird中添加方法
	public void flappy(){
		//重新设置初始速度，重新向上飞
		speed = v0;
	}
//在鸟中添加方法hit
	// 检测当前鸟是否碰到地面ground
	//如果返回true表示发生碰撞
	//否则返回false表示没有碰撞

	
public boolean hit (Ground ground){
	boolean hit =y+size/2>ground.y;
	if(hit){
		y=ground.y-size/2;
		
	}
	return hit;
}
//检测当前鸟是否撞倒柱子
public boolean hit(Column column){
	//先检查是否在柱子的范围以内
   if  (x>column.x-column.width/2-size/2&&x<column.x+column.width/2+size/2){
	   if(y<column.y+column.gap/2-size/2){
	   return false;
	   		}
	   return true;
   		}
   return false;
	}
}