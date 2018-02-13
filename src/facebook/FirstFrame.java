package facebook;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FirstFrame {

	public FirstFrame() {
		// TODO Auto-generated constructor stub {
		String[] str = new String[10];
		JFrame f = new JFrame("Facebook");
		f.setSize(700, 500);
		f.getContentPane().setBackground(Color.white);
		f.setLayout(new FlowLayout(FlowLayout.LEFT));
		// new FlowLayout(FlowLayout.LEFT)

		JLabel l1, l2, l3, l4, l5, l6;
		JTextField t1, t2, t3, t4, t5, t6, t7;
		JComboBox cmb1, cmb2, cmb3;
		JPasswordField pass1, pass2;
		JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13,p14;

		String[] month = { "Month", "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		String[] day = { "Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		String[] year = { "Year", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005",
				"2006", "2007", "2008", "2009", "2010" };

		p1 = new JPanel();

		p2 = new JPanel();
		p2.setBackground(Color.blue);
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p8 = new JPanel();
		p9 = new JPanel();
		p10 = new JPanel();
		p11 = new JPanel();
		p12 = new JPanel();
		p13 = new JPanel();
		p14 = new JPanel();
		p13.setBackground(Color.blue);

		l1 = new JLabel("Email or Phone");
		t1 = new JTextField(15);
		l2 = new JLabel("Password");
		pass1 = new JPasswordField(15);
		JButton loginButton = new JButton("Log in");
		loginButton.setBackground(Color.green);

		l3 = new JLabel("Create a New Account");
		l3.setFont(new Font("Serif", Font.BOLD, 30));
		l3.setForeground(Color.BLACK);
		l6 = new JLabel("It's free and always will be.");

		t2 = new JTextField("FirstName", 15);
		t3 = new JTextField("Surname", 15);

		t4 = new JTextField("Enter Email Address or Phone Number", 25);

		t5 = new JTextField("Re enter Email Address or Phone Number", 25);

		pass2 = new JPasswordField("Password", 20);

		l4 = new JLabel("Birthday");
		l4.setFont(new Font("Serif", Font.BOLD, 30));
		l4.setForeground(Color.BLACK);

		cmb1 = new JComboBox(day);
		cmb2 = new JComboBox(month);
		cmb3 = new JComboBox(year);

		JRadioButton r1 = new JRadioButton("Male");
		JRadioButton r2 = new JRadioButton("Female");
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		JRadioButton r3=new JRadioButton("Admin");
		JRadioButton r4=new JRadioButton("Public");
		
		ButtonGroup bg2=new ButtonGroup();
		bg2.add(r3);
		bg2.add(r4);

		JButton button2 = new JButton("Create Account");
		button2.setFont(new Font("Serif", Font.BOLD, 12));
		button2.setBackground(Color.green);

		JButton clickButton = new JButton("Sign up");

		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(pass1);
		p1.add(loginButton);

		p2.add(l3);
		p13.add(l6);

		p3.add(t2);
		p3.add(t3);

		p4.add(t4);

		p5.add(t5);

		p6.add(pass2);

		p7.add(l4);

		p8.add(cmb1);
		p8.add(cmb2);
		p8.add(cmb3);

		p9.add(r1);
		p9.add(r2);

		p14.add(r3);
		p14.add(r4);
		p10.add(button2);

		// p11.add(l5);
		p12.add(clickButton);

		f.add(p11);
		f.add(p1);
		f.add(p2);
		// f.add(p13);
		f.add(p3);
		f.add(p4);
		f.add(p5);
		f.add(p6);
		f.add(p7);
		f.add(p8);
		f.add(p9);
		f.add(p14);
		f.add(p10);
		f.add(p12);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		clickButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				str[0] = t2.getText(); // firstName
				str[1] = t3.getText(); // Surname
				str[2] = t4.getText(); // new email or phone
				str[3] = t5.getText(); // re entersd email;
				str[4] = pass2.getText(); // new password
				str[5] = cmb1.getSelectedItem().toString(); // day
				str[6] = cmb2.getSelectedItem().toString(); // month
				str[7] = cmb3.getSelectedItem().toString(); // year
				int day = Integer.parseInt(str[5]);
				int year = Integer.parseInt(str[7]);
				int a;
				if(r4.isSelected()){
					a=0;			//for public
				}else{
					a=1;			//for admin
				}
				str[9]=Integer.toString(a);
				//System.out.println(a);
				int m = 0;
				if (str[6] == "January")
					m = 1;
				else if (str[6] == "February")
					m = 2;
				else if (str[6] == "March")
					m = 3;
				else if (str[6] == "April")
					m = 4;
				else if (str[6] == "May")
					m = 5;
				else if (str[6] == "June")
					m = 6;
				else if (str[6] == "July")
					m = 7;
				else if (str[6] == "August")
					m = 8;
				else if (str[6] == "September")
					m = 9;
				else if (str[6] == "October")
					m = 10;
				else if (str[6] == "November")
					m = 11;
				else if (str[6] == "December")
					m = 12;
				try {
					str[8] = getAge(day, m, year); // age
				} catch (Exception e) {
					System.out.println("Month must be selected.");
				}

				JOptionPane.showMessageDialog(null,
						"First name is  " + str[0] + "\n" + "surname is  " + str[1] + "\n" + "new email is  " + str[2]
								+ "\n" + "re-entered email is  " + str[3] + "\n" + "password is " + str[4] + "\n"
								+ "Birthday is  " + str[5] + "/" + str[6] + "/" + str[7] + "Age is : " + str[8] +" "+str[9]);
				
				f.setVisible(false);
				SecondFrame f2 = new SecondFrame(str);
			}
		});

		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				FacebookFile fi = new FacebookFile();
				FacebookDatabase fd=new FacebookDatabase();
				int b;
				
//				if(r4.isSelected()){
//					b=0;			//for public
//				}else{
//					b=1;			//for admin
//				}
//				
//				String s=Integer.toString(b);
				String emailID=t1.getText();
				String loginPassword=pass1.getText();
				
				//String email=t4.getText();
				
				
				if(fd.checkLoginForCustomer(emailID, loginPassword)){
					String temp=fd.getIndividualInformation(emailID);
					JOptionPane.showMessageDialog(null, "Login successfull.");
					
					if(fd.checkIsAdmin(emailID)){
						f.setVisible(false);
						new AdminFrame(temp);
					}else{
						f.setVisible(false);
						new NonAdminFrame(temp);
					}
					
					
				}else{
					JOptionPane.showMessageDialog(null, "Invalid E-mail address or password.");
				}
				
//				if(fi.readFromFile_BufferReader(emailID, loginPassword)){
//					JOptionPane.showMessageDialog(null, "Login successfull.");
//				}else{
//					JOptionPane.showMessageDialog(null, "Invalid E-mail address or password.");
//				}

			}
		});
	}

	public String getAge(int day, int month, int year) {

		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(year, month, day);
		Period p = Period.between(birthday, today);
		int d = p.getDays();
		int m = p.getMonths();
		int y = p.getYears();
		String dayString = Integer.toString(d);
		String monthString = Integer.toString(m);
		String yearString = Integer.toString(y);
		String res = yearString + "/" + monthString + "/" + dayString;
		return res;

	}
}
