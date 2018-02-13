package facebook;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NonAdminFrame {
	
	public NonAdminFrame(String s){
		JFrame f = new JFrame("Facebook");
		f.setSize(800, 500);
		f.getContentPane().setBackground(Color.white);
		f.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		String arr[] = s.split(",");
		String s1 = "Email : " + arr[0] + ", password : " + arr[1] + ", first name " + arr[2] + ", last name " + arr[3]
				+ ", birthday " + arr[4] + ", age " + arr[5] + ", type  is Public ";
		
		JLabel l=new JLabel(s1);
		JButton button1;
		
		
		
		button1=new JButton("log out");
		
		
		f.add(l);
		f.add(button1);
				
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.setVisible(false);
				new FirstFrame();
				
			}
		});
		
	}

}
