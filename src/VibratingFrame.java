import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class VibratingFrame extends JFrame{
	private JLabel la = new JLabel("진동 레이블"); //레이블 생성
	
	public VibratingFrame() {
		setTitle("진동하는 프레임 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		la.setSize(90, 90);
		la.setVisible(true);
		add(la);
		
		setSize(300,300);
		setLocation(100,100);
		setVisible(true);		
		VibratingThread thread = new VibratingThread(this);
		thread.start(); //스레드 실행
	}
	class VibratingThread extends Thread {
		Component comp;
		public VibratingThread(Component comp) {
			this.comp = comp;
		}
		
		public void run() {
			Random r = new Random();
			int y = la.getY(); //레이블의 위치
			int x = la.getX(); //레이블의 위치
			
			while(true) {
				try {
					Thread.sleep(10);
				}
				catch(InterruptedException e){return;}
				int sign = 1;
				if(r.nextBoolean()) sign = 1;
				else sign = -1;
				int tmpX = x + r.nextInt(5)*sign;

				if(r.nextBoolean()) sign = 1;
				else sign = -1;
				int tmpY = y + r.nextInt(5)*sign;
				
				la.setLocation(tmpX, tmpY); //레이블의 위치
			}
		}
	}
	public static void main(String [] args) {
		new VibratingFrame();
	}
} 