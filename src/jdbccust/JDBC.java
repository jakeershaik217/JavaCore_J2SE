package jdbccust;

import java.io.IOException;
import java.sql.SQLException;

import JDBCMavenMain.JDBCMavenTest.JDBCJarCreate;

public class JDBC {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

		String Sd[]=JDBCJarCreate.loadXML("C:\\Users\\Jakeer\\workspace\\JDBCMavenTest\\USerIDPassword.xml", "userid", "password");
		JDBCJarCreate.CreateConnection("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@localhost:1521:orcl", Sd[0], Sd[1]);
		String S1[]={"No","Name"};
		String S2[]={"number","varchar(20)"};
		JDBCJarCreate.createTable("Temp", S1, S2);
		
		
	}

}
