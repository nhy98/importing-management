package edu.fa;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import edu.fa.frame.HomeFrame;
import edu.fa.frame.LoginFrame;

public class Management {
	
	public static void main(String[] args) {
		  SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				   JFrame frame = new JFrame();
	                frame.setSize(1200, 900);
	                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                frame.setVisible(true);
	                LoginFrame loginFrame = new LoginFrame();
	                loginFrame.createLoginFrame(frame);
//	                HomeFrame homeFrame = new HomeFrame();
//	                homeFrame.createHomeFrame(frame);
			}
		});
	}

}

