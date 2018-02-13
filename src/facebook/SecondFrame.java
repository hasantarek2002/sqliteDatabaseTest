package facebook;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.sun.media.jfxmedia.events.NewFrameEvent;

public class SecondFrame {

	public static HashMap<String, Information> map = new HashMap<String, Information>();

	public static String[][] information;
	String columName[] = { "firstName", "surname", "email", "reEnteredEmail", "newPassword", "Birthady", "Age","isAdmin" };
	ArrayList<String[]> arr = new ArrayList<String[]>();

	public SecondFrame(String[] str) {
		// System.out.println("second frame "+str.length);
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(500, 500);
		mainFrame.setLayout(new FlowLayout());
		JLabel firstName, surname, email, reEnteredEmail, newPassword, gender, birthday, age,isAdmin;
		firstName = new JLabel(str[0]);
		surname = new JLabel(str[1]);
		email = new JLabel(str[2]);
		reEnteredEmail = new JLabel(str[3]);
		newPassword = new JLabel(str[4]);
		birthday = new JLabel(str[5] + "/" + str[6] + "/" + str[7]);
		age = new JLabel(str[8]);
		isAdmin=new JLabel(str[9]);

		JButton clickButton = new JButton("Create a new account");
		JButton showButton = new JButton("show all");
		mainFrame.add(clickButton);
		mainFrame.add(showButton);

		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clickButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.setVisible(false);
				Information info = new Information(str[0], str[1], str[2], str[3], str[4],
						str[5] + "/" + str[6] + "/" + str[7], str[8],str[9]);
				String nameValidation = "[A-Za-z]+";
				String emailValidation = "[a-z0-9_]+@[a-z]+.com";
				String passwordValidation = "[A-Za-z0-9]{8,}";

				Pattern p1 = Pattern.compile(nameValidation);
				Pattern p2 = Pattern.compile(emailValidation);
				Pattern p3 = Pattern.compile(passwordValidation);

				Matcher m1 = p1.matcher(str[0]); // first name validation
				Matcher m2 = p1.matcher(str[1]); // surname name validation
				Matcher m3 = p2.matcher(str[2]); // email name validation
				Matcher m4 = p2.matcher(str[3]); // re-entered email name
													// validation
				Matcher m5 = p3.matcher(str[4]); // password validation

				if (m1.matches() && m2.matches() && m3.matches() && m4.matches() && m5.matches()) {
					map.put(info.getEmail(), info);
					String text = info.getFirstName() + "," + info.getSurName() + "," + info.getEmail() + ","
							+ info.getReEnteredEmail() + "," + info.getNewPassword() + "," + info.getBirthday() + ","
							+ info.getAge()+","+info.getIsAdmin();

					FacebookFile file = new FacebookFile();
					file.writeToFile_BufferWriter(text);

					FacebookDatabase fd = new FacebookDatabase();
					fd.insert(info.getEmail(), info.getNewPassword(), info.getFirstName(), info.getSurName(),
							info.getBirthday(), info.getAge(),info.getIsAdmin());
					
//					System.out.println("data inserted successfully in the database.");
				} else {
					JOptionPane.showMessageDialog(null,
							"There is problem with input name or email or password. please try again.");
				}

				new FirstFrame();

			}
		});

		showButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mainFrame.setVisible(false);
				JFrame frame = new JFrame();
				frame.setSize(500, 500);
				frame.setLayout(new FlowLayout());
				
//				FacebookFile f = new FacebookFile();
//				f.ShowAllFromFile_BufferReader();

				FacebookDatabase fd = new FacebookDatabase();
				fd.showAllInformationInDatabase();
				// for (String key : map.keySet()) {
				// Information value = map.get(key);
				// String a = map.get(key).getFirstName();
				// String[] s = new String[7];
				// s[0] = value.getFirstName();
				// s[1] = value.getSurName();
				// s[2] = value.getEmail();
				// s[3] = value.getReEnteredEmail();
				// s[4] = value.getNewPassword();
				// s[5] = value.getBirthday();
				// s[6] = value.getAge();
				// arr.add(s);
				// // System.out.println(key + " -> " + value);
				// }
				// information = new String[arr.size()][7];
				// for (int i = 0; i < arr.size(); i++) {
				// String s[] = arr.get(i);
				// information[i][0] = s[0];
				// information[i][1] = s[1];
				// information[i][2] = s[2];
				// information[i][3] = s[3];
				// information[i][4] = s[4];
				// information[i][5] = s[5];
				// information[i][6] = s[6];
				// }
				//
				// for (int i = 0; i < arr.size(); i++) {
				//
				// System.out.println("First name is " + information[i][0] + ",
				// " + "surname is " + information[i][1]
				// + ", " + "new email is " + information[i][2] + ", " +
				// "re-entered email is "
				// + information[i][3] + ", " + "password is " +
				// information[i][4] + ", " + "Birthday is "
				// + information[i][5] + ", " + "Age is : " +
				// information[i][6]);
				//
				// }
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// frame.setVisible(true);

			}
		});
	}

}
