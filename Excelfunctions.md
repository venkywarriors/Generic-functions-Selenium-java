## Let’s see how to perform excel operations using Apache POI <br> 
### :dart:Write data to excel sheet using column number: <br> 
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
