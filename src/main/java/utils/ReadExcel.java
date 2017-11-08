package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class ReadExcel {
	FileInputStream fileInput;
	Workbook wb;
	public String [][] arr = null;
	
public String[][] readFile(){
	File file = new File(System.getProperty("user.dir")+"\\test-input\\learn.xlsx");
	try {
		
		
		int col;
		 fileInput = new FileInputStream(file);
		 wb = new HSSFWorkbook(fileInput);
		 Sheet s = wb.getSheet("test");
		 
		 System.out.println(s.getSheetName());
		 
		 int row = s.getLastRowNum();
		 System.out.println(row);
		 Row r = s.getRow(0);
		 col = r.getLastCellNum();
		 System.out.println(col);
		 
		 arr=new String[row][col];
		 int startRow = 1;
		 int ci=0;
		 for(int i=startRow;i<=row;i++,ci++){
			  r = s.getRow(i);

			 for(int j=0;j<col;j++){
				 arr[ci][j]=r.getCell(j).toString();
			
			 }
		 }
		 
//		 for(int i=0;i<row;i++){
//		for(int j=0;j<col;j++){
//			 System.out.println(arr[i][j]);
//			 }
//		 }
		 
		 return arr;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return null;
}	
	/*public static void main(]) {
	
		ReadExcel obj = new ReadExcel();
		String[][]arr = obj.readFile() ;
		
		 for(int i=0;i<arr.length;i++){
		for(int j=0;j<arr.length;j++){
			 System.out.println(arr[i][j]);
		 }*/
	 }
		
	
