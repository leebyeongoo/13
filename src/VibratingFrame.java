import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class VibratingFrame extends JFrame{
	private JLabel la = new JLabel("���� ���̺�"); //���̺� ����
	
	public VibratingFrame() {
		setTitle("�����ϴ� ������ �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		la.setSize(90, 90);
		la.setVisible(true);
		add(la);
		
		setSize(300,300);
		setLocation(100,100);
		setVisible(true);		
		VibratingThread thread = new VibratingThread(this);
		thread.start(); //������ ����
	}
	class VibratingThread extends Thread {
		Component comp;
		public VibratingThread(Component comp) {
			this.comp = comp;
		}
		
		public void run() {
			Random r = new Random();
			int y = la.getY(); //���̺��� ��ġ
			int x = la.getX(); //���̺��� ��ġ
			
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
				
				la.setLocation(tmpX, tmpY); //���̺��� ��ġ
			}
		}
	}
	public static void main(String [] args) {
		new VibratingFrame();
	}
} 