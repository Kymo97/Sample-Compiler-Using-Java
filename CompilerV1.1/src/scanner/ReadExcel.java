package scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {
	  private String inputFile;
	  HashMap<String, String> parseTable = new HashMap<>();
	  ArrayList<String> Non_Ter= new ArrayList<>();
	  HashMap<String, String> Error_Handling = new HashMap<>();

	    public ReadExcel(String inputFile) {
	    	this.inputFile = inputFile;
	    }

	    public HashMap<String, String> getParseTable() {
	    	return parseTable;
	    }
	    public HashMap<String, String> getErrorMap() {
	    	return Error_Handling;
	    }
	    public ArrayList<String> getTerm(){
	    	return Non_Ter;
	    }

		public void read() throws IOException  {
	        File inputWorkbook = new File(inputFile);
	     
	        Workbook w;
	        try {
	            w = Workbook.getWorkbook(inputWorkbook);
	            // Get the first sheet
	            Sheet sheet = w.getSheet(0);
	            // Loop over first 10 column and lines
	            for (int i = 0; i < sheet.getRows(); i++) {//sheet.getColumns()// sheet.getRows()
	            	 Cell Cell2 =sheet.getCell(0,i);
	            	 String Fix="";
	                for (int j = 0; j <sheet.getColumns(); j++) {
	                    Cell cell = sheet.getCell(j, i);
	                    //Cell Cell2 =sheet.getCell(0,j);
	                    Cell cell3=sheet.getCell(j,0);
	                   if(cell.getContents()!=""&&(i!=0&&j!=0)&&(Cell2.getContents()!=""))
	                   {
	                	   String x = Cell2.getContents()+cell3.getContents();
	                	   String []y =cell.getContents().split("->");
	                	   String k=y[1].substring(1, y[1].length());
	                	   parseTable.put(x,k);
	                	   Non_Ter.add(Cell2.getContents());
	                	   Fix=Fix+" "+cell3.getContents();
	                	  //System.out.println(Cell2.getContents()+cell3.getContents()+"------>"+cell.getContents());
	                	   //System.out.println(x+"  ---------->"+k);//
	                   }
	                }
	                //Fix=Cell2.getContents()+"--->"+Fix;
	                //System.out.println(Fix);
	                Error_Handling.put(Cell2.getContents(),Fix);
	              
	               
	            }
	        } catch (BiffException e) {
	            e.printStackTrace();
	        }
	    }
}
