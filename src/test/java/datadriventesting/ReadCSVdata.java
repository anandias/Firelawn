package datadriventesting;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCSVdata {
	
	
	public static void main(String[] args) throws IOException, CsvException {
	 //store the address of the file In the string
	 String filePath = "./src/test/resources/qspiders.csv";
	 //create the object for fileReader class of java 
	 FileReader csvToRead=new FileReader(filePath);
	 // create the object  from csvReader class of OpenCsv library
	 CSVReader consideredCsvFile = new CSVReader(csvToRead);
	 List<String[]> dataToRead = consideredCsvFile.readAll();
	 long totalLinesToRead = consideredCsvFile.getLinesRead();
	 System.out.println("totalLinesToRead = " + totalLinesToRead);
	 for (String[] stringArray : dataToRead) {
	  for (String data : stringArray) {
	   System.out.println(data);
	  }
	 }
	}
	}


