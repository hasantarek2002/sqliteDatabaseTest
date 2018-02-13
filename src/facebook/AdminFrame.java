package facebook;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminFrame {
	public String[][] information;
	String columName[] = { "email", "firstName", "lastname", "Age" };

	public AdminFrame(String s) {
		JFrame f = new JFrame("Facebook");
		f.setSize(800, 500);
		f.getContentPane().setBackground(Color.white);
		f.setLayout(new FlowLayout(FlowLayout.LEFT));

		String arr[] = s.split(",");
		String s1 = "Email : " + arr[0] + ", password : " + arr[1] + ", first name " + arr[2] + ", last name " + arr[3]
				+ ", birthday " + arr[4] + ", age " + arr[5] + ", type  is Admin ";
		JLabel l = new JLabel(s1);
		JButton button1, button2;

		button1 = new JButton("log out");
		button2 = new JButton("Show all");

		f.add(l);
		f.add(button1);
		f.add(button2);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new FirstFrame();

			}
		});

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.setVisible(false);
				JFrame f1 = new JFrame("Facebook");
				f1.setSize(800, 500);
				f1.getContentPane().setBackground(Color.white);
				f1.setLayout(new FlowLayout(FlowLayout.LEFT));
				JButton button=new JButton("Logout");

				ArrayList<String[]> arr = new ArrayList<String[]>();
				FacebookDatabase fd = new FacebookDatabase();				
				// fd.showAllInformationInDatabase();
				arr = fd.createTableFromDatabase();
				information = new String[arr.size()][4];

				for (int i = 0; i < arr.size(); i++) {
					String s[] = arr.get(i);
					//System.out.println(s[0]+" "+s[1]+" "+s[2]+" "+s[3]);
					information[i][0] = s[0];
					information[i][1] = s[1];
					information[i][2] = s[2];
					information[i][3] = s[3];
				}
				
				JTable jt=new JTable(information,columName);    
				jt.setBounds(30,40,200,300);          
				JScrollPane sp=new JScrollPane(jt); 
				
				f1.add(sp);
				
				f1.add(button);
				f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f1.setVisible(true);
				
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						f1.setVisible(false);
						new FirstFrame();
						
					}
				});

			}
		});

	}

}
