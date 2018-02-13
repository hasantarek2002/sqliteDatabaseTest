package database_test;

public class MainClass {

	public static void main(String[] args) {
		DatabaseTest dt=new DatabaseTest();
//		dt.createNewDatabase();
//		dt.createNewTable();
//		dt.insert("hhhh", 50);
		
		//dt.selectAll();
//		dt.checkNameFromDatabase("Tarek");;
//		dt.getpointsGreaterThan(60);
		dt.update(2, "h", 49);
		dt.selectAll();
	}

}
