package testfly;

import javax.swing.JButton;

@SuppressWarnings("serial")
final class Bomb extends JButton {
	int bx,by;//方块所在位置  
    int BombRoundCount;//周围雷数  
    int Bombflag;//探雷标记  
    boolean isBomb;//是否是雷  
    boolean isClicked;//是否点击左键  
    boolean isRight;//是否点击右键  
    public static int blockopennum = 0;//打开方格数  
      
    public Bomb(int x,int y)//构造方法  
    {  
        bx = x;  
        by = y;  
        BombRoundCount = 9;  
        Bombflag = 0;  
        isBomb = false;  
        isClicked = false;  
        isRight = false;  
    }  
}

