import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class Two extends JFrame{
	private MyPanel p = new MyPanel();
	public Two() {
		setTitle("원을 0.5초 간격으로 이동");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(p); //Mypanel 컨텐트팬으로 설정
		p.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Thread th = new Thread(new MyThread());
				th.start();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		}); //클릭하면 MyThread실행되도록 설정
	
		setSize(300,300); //사이즈 설정
		setVisible(true); //프레임출력
	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawOval(50, 50, 50, 50);
		}
	} //(50,50)위치에 지름 50인 빨간색 원
	class MyThread extends Thread{
		public void run() {
			while(true) {
				int a = (int)(Math.random()*200); //중심이 0~200
				int b = (int)(Math.random()*200); //중심이 0~200
				p.setLocation(a,b); //패널위치설정
				try {
					sleep(400); //400ms 슬립
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					break;
				}
			}
		}
	} //400ms마다 위치를 옮기는 MyPanel 스레드
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Two();
	}

}