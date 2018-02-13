package facebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FacebookFile {

	private String FILENAME = "textFolder\\file2.txt";

	public void writeToFile_BufferWriter(String text) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content = text;

			// //open filewriter as write mode
			// fw = new FileWriter(FILENAME);

			// open filewriter as append mode
			fw = new FileWriter(FILENAME, true);

			bw = new BufferedWriter(fw);
			bw.write(content + "\n");

			// System.out.println("Write Done : " + content);

			if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean readFromFile_BufferReader(String email, String password) {

		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));
			boolean isFound=false;

			while ((sCurrentLine = br.readLine()) != null) {

				String[] line = sCurrentLine.split(",");
				// System.out.println(line[2]+" "+line[3]+" "+line[4]);
				if (line[2].equals(email) && line[4].equals(password)) {
					//System.out.println(line[2]+" "+line[4]);
					return true;
				}

			}

			if (br != null)
				br.close();

			if (fr != null)
				fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void ShowAllFromFile_BufferReader() {
		  
		BufferedReader br = null;
		FileReader fr = null;
		
		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				String[] line = sCurrentLine.split(",");
				for (String w : line) {
				System.out.print(w + " ");
				}
				System.out.println();
			}
			
			if (br != null)
				br.close();

			if (fr != null)
				fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
