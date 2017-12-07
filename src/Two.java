import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class Two extends JFrame{
	private MyPanel p = new MyPanel();
	public Two() {
		setTitle("���� 0.5�� �������� �̵�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(p); //Mypanel ����Ʈ������ ����
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
		}); //Ŭ���ϸ� MyThread����ǵ��� ����
	
		setSize(300,300); //������ ����
		setVisible(true); //���������
	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawOval(50, 50, 50, 50);
		}
	} //(50,50)��ġ�� ���� 50�� ������ ��
	class MyThread extends Thread{
		public void run() {
			while(true) {
				int a = (int)(Math.random()*200); //�߽��� 0~200
				int b = (int)(Math.random()*200); //�߽��� 0~200
				p.setLocation(a,b); //�г���ġ����
				try {
					sleep(400); //400ms ����
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					break;
				}
			}
		}
	} //400ms���� ��ġ�� �ű�� MyPanel ������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Two();
	}

}