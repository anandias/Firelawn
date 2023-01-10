package com.Ecommerce.Firelawn.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.github.dockerjava.api.model.Driver;

/**
 * Read the data from external resources such as property file, excel sheet, Data Base
 * @author Anand
 *
 */

public class FileUtilities {
	public static Connection con;
	/**
	 * It is used to read the data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String getPropertyData(String key) throws IOException {
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(Autoconatant.propertyFilePath);
		p.load(fis);
		return p.getProperty(key);
	}
	
	/**
	 * It used to read the data from excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(Autoconatant.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String getdata = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return getdata;
	}
	/**
	 * It is used to read the data from data base.
	 * @return
	 * @throws SQLException
	 */
	
	public Connection getDataDB() throws SQLException {
		com.mysql.jdbc.Driver dref = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(dref);
		return con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sonno","root","root");
	}
	
	/**
	 * It is used to execute the query
	 * @param query
	 * @param columnname
	 * @param expectedresults
	 * @return
	 * @throws SQLException
	 */
	public String queryExecution(String query, String columnname, String expectedresults) throws SQLException {
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		while(result.next()) {
			if(result.getString(columnname).equals(expectedresults)) {
				break;
			}else {
				System.out.println("Data not found");
			}
		
		}
		return expectedresults;
	}
	
	/**
	 * It is used to close the database connection.
	 * @throws SQLException
	 */
	public static void closeDB() throws SQLException {
		con.close();
	}

}
