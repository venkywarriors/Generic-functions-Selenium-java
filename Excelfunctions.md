## Let’s see how to perform excel operations using Apache POI <br> 
### :dart:Write data to excel sheet using row number & column number: <br> 
```
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
```
### :dart:Read data from excel sheet using row number & column number:
```
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
```
### :dart:Count number of rows in an excel sheet:
``` 
 public int getRowCount(String sheetName)
    {
            sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum()+1;     
            return rowCount;
    }    
```
### :dart:Count number of rows in an excel sheet:
```
 public int getColumnCount(String sheetName)
    {
            sheet = workbook.getSheet(sheetName);
            int ColumnCount = sheet.getRow(0).getLastCellNum();    
            return ColumnCount;
    }
```
### :dart:Write data from excel sheet using row number & column name:
```
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
```
### :dart:Read data from excel sheet using row number & column name:
```
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
```
### :dart:Create Empty excel workbook in particular directory:
```
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
```
### :dart:Add sheet to excel workbook:
```
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
```
### :dart:Clear contents in excel sheet:
```
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
```
### :dart:Count of sheets in excel workbook:
```
public int countNumOfSheets() {

	   int NumberOfSheets = workbook.getNumberOfSheets();      
	   return NumberOfSheets;
	   
	   }
```
### :dart:Check whether excel workbook exists in particular directory:
```
 public boolean fileExists(String path) {

	   File file = new File(path);    
	   return file.exists();
	   
	   }
```
### :dart:Check whether excel sheet exists in workbook:
```
 public boolean sheetExists(String sheetName) {
  
	   try {
		   sheet =workbook.getSheet(sheetName); 
		} catch (Exception e) {
			return false;
		}
	   
	   return true;
	   
	   }
```
### :dart:Delete sheet from excel workbook:
```
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
```
### :dart:Delete excel workbook from particular directory:
```
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
```

 
