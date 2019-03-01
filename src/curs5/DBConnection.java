package curs5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3306/";
		String user ="root";
		String password = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement stt = con.createStatement();
			
			// create and select db
			stt.execute("CREATE DATABASE IF NOT EXISTS curs_5");
			stt.execute("USE curs_5");
			
			//create out table
			stt.execute("DROP TABLE IF EXISTS contact");
			stt.execute("CREATE TABLE contact ("
					+ "id BIGINT NOT NULL AUTO_INCREMENT,"
					+"nume VARCHAR(25),"
					+"prenume VARCHAR(25),"
					+"PRIMARY KEY(id)"
					+ ")");
			//add values
			stt.execute("INSERT INTO contact (nume, prenume) VALUES"+
			"('Dan', 'Negru'), ('Marina', 'Vaselina'),('Valera','Fornatiuc')");
			//get ppl from contact 
			ResultSet res = stt.executeQuery("SELECT * FROM CONTACT WHERE nume='Vaselina'");
			
			while (res.next()) {
				System.out.println(res.getString("nume")+" "+ res.getString("prenume"));
			}
			System.out.println("");
			
			PreparedStatement prep = con.prepareStatement("SELECT * FROM contact WHERE nume = ?");
            prep.setString(1, "Marina");

            res = prep.executeQuery();
            while (res.next())
            {
                System.out.println(res.getString("nume") + " " + res.getString("prenume"));
            }

            /**
             * Free all opened resources
             */
            res.close();
            stt.close();
            prep.close();
            con.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
