import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myClass {

	Connection con = null;
	Statement stm = null;

	ResultSet rs;

	@BeforeTest
	public void setup() throws SQLException {

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "abed");
	}

	@Test(enabled = false)

	public void AddTest() throws SQLException {
		stm = con.createStatement();

		String InsertQuery = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city,country )"
				+ "VALUES (1117, 'abC COMPANY.', 'AHMAD', 'ALI', '23993837837', 'CAIROT', 'CAIRO' ,'EGYPT');";

		int rowEffected = stm.executeUpdate(InsertQuery);

		if (rowEffected > 0) {
			System.out.println("data has been added");

		} else {
			System.out.println("sorry there is a mistake");
		}

	}

	@Test(enabled = false)
	public void deleteTest() throws SQLException {
		stm = con.createStatement();

		String DeleteQuery = "DELETE FROM CUSTOMERS WHERE customerNumber = 1117";
		int rowEffected = stm.executeUpdate(DeleteQuery);

		Assert.assertEquals(rowEffected > 0, true, " sorry there is a mistake");
	}

	@Test(enabled = false)
	public void updateTest() throws SQLException {
		stm = con.createStatement();

		String updateQuery = "UPDATE customers SET city = 'London' WHERE customerNumber = 1115";
		int rowEffected = stm.executeUpdate(updateQuery);

		Assert.assertEquals(rowEffected > 0, true, " sorry there is a mistake");

	}

	@Test()
	public void selectTest() throws SQLException {
		stm = con.createStatement();

		rs = stm.executeQuery("SELECT * FROM customers where customerNumber=103");

		while (rs.next()) {
			String thecustomerName = rs.getString("customerName");
			String thecustomerNumber = rs.getString("customerNumber");
			String customerFirstName = rs.getString("contactFirstName");
			String customerLastName = rs.getString("contactLastName");
			String customerCITY = rs.getString("city");

			System.out.println(thecustomerName);
			System.out.println(thecustomerNumber);
			System.out.println(customerFirstName);

			System.out.println(customerLastName);

			System.out.println(customerCITY);

			Assert.assertEquals(customerLastName, "Schmitt2", "sorry the customer lastname is not matching");

		}
	}

//

}
