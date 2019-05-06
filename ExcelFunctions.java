package Raga;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.Removal;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.Color;
import java.awt.image.IndexColorModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Spring;
 


/* 
 * Author @Ragavaendra Doijode
 * */

public class ExcelFunctions
{
    public FileInputStream fis = null;
    public FileOutputStream fos = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
    String xlFilePath;
    static DataFormatter formatter = new DataFormatter();
    
 
    public ExcelFunctions(String xlFilePath) throws Exception
    {
        this.xlFilePath = xlFilePath;
        fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        fis.close();
    }
    
    public ExcelFunctions()
    {
        
    }
    
    
   /* 
    * Functions Illustration
    * 
    * ExcelFunctions xlObj = new ExcelFunctions(System.getProperty("user.dir")+"/Excel.xlsx");
    
    xlObj.writeData("sheet1",3,1,"PASS", null, null);
    xlObj.readExcelData("sheet1",1,0);
    xlObj.writeDataWithBackgroundcolor("sheet1",3,1,"PASS", "Bold", null);
    xlObj.writeData("sheet1",3,1,"PASS");
    xlObj.getColumnCount("sheet1");
    xlObj.getRowCount("sheet1");
    *
    */
 
    /* “writeData()” and it will accept 3 parameters called sheetName, columnNumber, rowNumber, value.*/ 
    public boolean writeData(String sheetName, int rowNum, int colNumber,  String value)
    {
    	
        try
        {
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNum-1);
            if(row==null)
                row = sheet.createRow(rowNum-1);
            cell = row.getCell(colNumber-1);
            if(cell == null)
                cell = row.createCell(colNumber-1);                      
            cell.setCellValue(value);       
            fos = new FileOutputStream(xlFilePath);
            workbook.write(fos);
            fos.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return  false;
        }
        return true;
    }
    
    /* “writeDataWithBackgroundcolor()” and it will accept 4 parameters called sheetName, columnNumber, rowNumber, value, fontcolor, Backgroundcolor, borders, borderColor .*/ 
    public boolean writeDataWithBackgroundcolor(String sheetName, int rowNum, int colNumber,  String value, String fontcolor, String Backgroundcolor, String borders, String borderColor)
    {
    	
        try
        {
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNum-1);
            if(row==null)
                row = sheet.createRow(rowNum-1);
            cell = row.getCell(colNumber-1);
            if(cell == null)
                cell = row.createCell(colNumber-1);
            CellStyle style = workbook.createCellStyle();  
            Font font = workbook.createFont();
                     
              try {
				if (Backgroundcolor.equalsIgnoreCase("red"))
				  {
					  style.setFillForegroundColor(IndexedColors.RED.getIndex());  
				      style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				      //cell.setCellStyle(style); 
				  }
				  else if (Backgroundcolor.equalsIgnoreCase("green"))
				  {
					  style.setFillForegroundColor(IndexedColors.GREEN.getIndex());  
				      style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				      //cell.setCellStyle(style); 
				   }
				  else if (Backgroundcolor.equalsIgnoreCase("yellow"))
				  {
					  style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());  
				      style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				      //cell.setCellStyle(style); 
				   }
				  else 
				  {
					  style.setFillForegroundColor(IndexedColors.WHITE.getIndex());  
				      style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				      //cell.setCellStyle(style); 
				  }
			} catch (Exception e) {
				
			}
              
              try {
  				if (borderColor.equalsIgnoreCase("red"))
  				  {
  					style.setBottomBorderColor(IndexedColors.RED.getIndex());
 					 style.setLeftBorderColor(IndexedColors.RED.getIndex());
 					 style.setRightBorderColor(IndexedColors.RED.getIndex());
 					 style.setTopBorderColor(IndexedColors.RED.getIndex()); 
  				      //cell.setCellStyle(style); 
  				  }
  				  else if (borderColor.equalsIgnoreCase("green"))
  				  {
  					style.setBottomBorderColor(IndexedColors.GREEN.getIndex());
					 style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
					 style.setRightBorderColor(IndexedColors.GREEN.getIndex());
					 style.setTopBorderColor(IndexedColors.GREEN.getIndex());  
  				      //cell.setCellStyle(style); 
  				   }
  				  else if (borderColor.equalsIgnoreCase("blue"))
  				  {
  					style.setBottomBorderColor(IndexedColors.DARK_BLUE.getIndex());
					 style.setLeftBorderColor(IndexedColors.DARK_BLUE.getIndex());
					 style.setRightBorderColor(IndexedColors.DARK_BLUE.getIndex());
					 style.setTopBorderColor(IndexedColors.DARK_BLUE.getIndex()); 
  				      //cell.setCellStyle(style); 
  				   }
  				  else 
  				  {
  					 style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
  					 style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
  					 style.setRightBorderColor(IndexedColors.BLACK.getIndex());
  					 style.setTopBorderColor(IndexedColors.BLACK.getIndex());
  				      //cell.setCellStyle(style); 
  				  }
  			} catch (Exception e) {
  	
  			}
              
              try {
  				if (borders.equalsIgnoreCase("DASHED)") || borders.equalsIgnoreCase("DASH"))
  				  {
  					style.setBorderBottom(BorderStyle.MEDIUM_DASHED);
  					style.setBorderTop(BorderStyle.MEDIUM_DASHED);
  					style.setBorderRight(BorderStyle.MEDIUM_DASHED);
  					style.setBorderLeft(BorderStyle.MEDIUM_DASHED);
  				   
  				      //cell.setCellStyle(style); 
  				  }
  				  else if (borders.equalsIgnoreCase("THIN") || borders.equalsIgnoreCase("light"))
  				  {
  					style.setBorderLeft(BorderStyle.THIN);
  					style.setBorderBottom(BorderStyle.THIN);
  					style.setBorderTop(BorderStyle.THIN);
  					style.setBorderRight(BorderStyle.THIN);
  					
  				      //cell.setCellStyle(style); 
  				   }
  				  else if (borders.equalsIgnoreCase("DOT") || borders.equalsIgnoreCase("DOTTED"))
  				  {
  					style.setBorderLeft(BorderStyle.DOTTED);
  					style.setBorderBottom(BorderStyle.DOTTED);
  					style.setBorderTop(BorderStyle.DOTTED);
  					style.setBorderRight(BorderStyle.DOTTED);
  				      //cell.setCellStyle(style); 
  				   }
  				else if (borders.equalsIgnoreCase("THICK") || borders.equalsIgnoreCase("Dark"))
				  {
					style.setBorderLeft(BorderStyle.THICK);
					style.setBorderBottom(BorderStyle.THICK);
					style.setBorderTop(BorderStyle.THICK);
					style.setBorderRight(BorderStyle.THICK);
				      //cell.setCellStyle(style); 
				   }
  				  else 
  				  {
  					style.setBorderLeft(BorderStyle.HAIR);
					style.setBorderBottom(BorderStyle.HAIR);
					style.setBorderTop(BorderStyle.HAIR);
					style.setBorderRight(BorderStyle.HAIR); 
  				      //cell.setCellStyle(style); 
  				  }
  			} catch (Exception e) {
  				
  			}
              
              try {
				if (fontcolor.equalsIgnoreCase("red"))
				  {	
					  font.setBold(true);
					  font.setColor(IndexedColors.RED.getIndex());
				  }
				  else if (fontcolor.equalsIgnoreCase("green"))
				  {
				  	  font.setBold(true);
					  font.setColor(IndexedColors.GREEN.getIndex());
				   }
				  else if (fontcolor.equalsIgnoreCase("white"))
				  {
					  font.setBold(true);
					  font.setColor(IndexedColors.WHITE.getIndex());
				   }
				  else if (fontcolor.equalsIgnoreCase("yellow"))
				  {
					  font.setBold(true);
					  font.setColor(IndexedColors.YELLOW.getIndex());
				   }
				  else if (fontcolor.contains("Bold"))
				  {
					  font.setBold(true);
					  font.setColor(IndexedColors.BLACK.getIndex());
				  }
			} catch (Exception e) {
				
				font.setColor(IndexedColors.BLACK.getIndex());
			}
              
              cell.setCellStyle(style); 
              style.setFont(font);
              cell.setCellValue(value);
            
            fos = new FileOutputStream(xlFilePath);
            workbook.write(fos);
            fos.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return  false;
        }
        return true;
    }
    
    /* “readExcelData()” and it will accept 3 parameters called sheetName, columnNumber, rowNumber .*/ 
    public String readExcelData(String sheetName,int rowNum, int colNum)
    {
        try
        {
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNum-1);
            cell = row.getCell(colNum-1);
     
            return (formatter.formatCellValue(cell).trim());
        }
        catch(Exception e)
        {
        	if (row==null)
        	{
        		return "";
        	}
        	else 
        	{
        		e.printStackTrace();
                return "row "+rowNum+" or column "+colNum +" does not exist  in Excel";	
        	}
            
        }
    }
       
    /* “getRowCount()” and it will accept 1 parameters called sheetName.*/   
    public int getRowCount(String sheetName)
    {
            sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum()+1;     
            return rowCount;
    }
    
    /* “getColumnCount()” and it will accept 1 parameters called sheetName.*/ 
    public int getColumnCount(String sheetName)
    {
            sheet = workbook.getSheet(sheetName);
            int ColumnCount = sheet.getRow(0).getLastCellNum();    
            return ColumnCount;
    }
    
    
    /*“setCellData()” and it will accept 4 parameters called sheetName, columnName, rowNumber and value which is written to the excel.*/
    
    public boolean setCellData(String sheetName, int rowNum, String colName, String value)
    {
        try
        {
            int col_Num = -1;
            sheet = workbook.getSheet(sheetName);
 
            row = sheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(colName))
                {
                    col_Num = i;
                }
            }
 
            sheet.autoSizeColumn(col_Num);
            row = sheet.getRow(rowNum - 1);
            if(row==null)
                row = sheet.createRow(rowNum - 1);
 
            cell = row.getCell(col_Num);
            if(cell == null)
                cell = row.createCell(col_Num);
 
            cell.setCellValue(value);
 
            fos = new FileOutputStream(xlFilePath);
            workbook.write(fos);
            fos.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return  false;
        }
        return true;
    }
    
   /* “getCellData()” and it will accept 3 parameters called sheetName, columnName and rowNumber.*/  
   public String getCellData(String sheetName, int rowNum,String colName)
    {
        try
        {
            int col_Num = -1;
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(0);
            for(int i = 0; i < row.getLastCellNum(); i++)
            {
                if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    col_Num = i;
            }
 
            row = sheet.getRow(rowNum - 1);
            cell = row.getCell(col_Num);
 
            if(cell.getCellTypeEnum() == CellType.STRING)
                return cell.getStringCellValue();
            else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA)
            {
                String cellValue = String.valueOf(cell.getNumericCellValue());
                if(HSSFDateUtil.isCellDateFormatted(cell))
                {
                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    Date date = cell.getDateCellValue();
                    cellValue = df.format(date);
                }
                return cellValue;
            }else if(cell.getCellTypeEnum() == CellType.BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "row "+rowNum+" or column "+colName +" does not exist  in Excel";
        }

    }
   
   
   public String createExcelfile(String filename,String location) {

	      XSSFWorkbook workbook = new XSSFWorkbook();
	      FileOutputStream out = null;
	      File f = new File(location);
	      String filepath = null;
	      
	      	if (f.isDirectory())
	      	{
	      		filepath = location+"\\"+filename+".xlsx"; 
	      		try {
	      				out = new FileOutputStream(filepath);
	      				workbook.write(out);		
	      				out.close();	
	      				
	      		} catch (Exception e) {				
				e.printStackTrace();
	      		}
	      	}
	      	else
	      	{
	      		System.out.println("In correct path specified");
	      	}		
		 return filepath;
		
	   }
   
   
   public boolean addSheet(String filename) {

	   
	   sheet= workbook.createSheet(filename);
	   try {
		fos = new FileOutputStream(xlFilePath);
		workbook.write(fos);
	       fos.close();
	} catch (Exception e) {
	
		e.printStackTrace();
	}
       
	   return true;
		
	   }
   
 public boolean clearContent(String sheetName) {

	   
	  sheet =workbook.getSheet(sheetName); 
	   try {
		   
		   for (int i = sheet.getLastRowNum(); i >= 0; i--) {
			   sheet.removeRow(sheet.getRow(i));
			 }

		   fos = new FileOutputStream(xlFilePath);
           workbook.write(fos);
           fos.close();
	} catch (Exception e) {
	
		e.printStackTrace();
	}
       
	   return true;
		
	   }
   
   public int countNumOfSheets() {

	   int NumberOfSheets = workbook.getNumberOfSheets();      
	   return NumberOfSheets;
	   
	   }
   
   
   public boolean fileExists(String path) {

	   File file = new File(path);    
	   return file.exists();
	   
	   }
   
   public boolean sheetExists(String sheetName) {
  
	   try {
		   sheet =workbook.getSheet(sheetName); 
		} catch (Exception e) {
			return false;
		}
	   
	   return true;
	   
	   }
   
   public boolean deletesheet(String sheetName) {
	   
	   try {
		   sheet =workbook.getSheet(sheetName); 
		   int index = workbook.getSheetIndex(sheet);
		    workbook.removeSheetAt(index);
		} catch (Exception e) {
			return false;
		}
	   
	   return true;
	   
	   }
   
   public boolean clearsheet(String sheetName) {
	   
	   try {
		   sheet =workbook.getSheet(sheetName); 
		   int index = workbook.getSheetIndex(sheet);
		    workbook.removeSheetAt(index);
		} catch (Exception e) {
			return false;
		}
	   
	   return true;
	   
	   }
   
   public boolean deleteExcel(String filepath) {
	   
	   try {
		   File file = new File(filepath); 
		   if(file.delete()) 
	       { 
	    	   return true;
	       } 
	       else
	       { 
	    	   return false;
	       }
		} catch (Exception e) {
			System.out.println("file not found");
			return false; 
		}
	   
	   
	   }
   
   public boolean addTabColor(String sheetName, String tabColor) {

   	
	   sheet = workbook.getSheet(sheetName);
	   
	   if (tabColor.equalsIgnoreCase("red"))
		  {	
		   	sheet.setTabColor(new XSSFColor(Color.RED));
		  }
		  else if (tabColor.equalsIgnoreCase("green"))
		  {
			 sheet.setTabColor(new XSSFColor(Color.GREEN));
		   }
		  else if (tabColor.equalsIgnoreCase("blue"))
		  {
			  sheet.setTabColor(new XSSFColor(Color.BLUE));
		   }
		  else if (tabColor.equalsIgnoreCase("yellow"))
		  {
			  sheet.setTabColor(new XSSFColor(Color.YELLOW));
		   }
		  else if (tabColor.contains("ORANGE"))
		  {
			  sheet.setTabColor(new XSSFColor(Color.ORANGE));
		  }
		  else if (tabColor.contains("PINK"))
		  {
			  sheet.setTabColor(new XSSFColor(Color.PINK));
		  }

	   try {
		fos = new FileOutputStream(xlFilePath);
		workbook.write(fos);
	    fos.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
       
	   return true;
		
	   }
}
