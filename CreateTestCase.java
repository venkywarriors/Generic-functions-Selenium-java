import java.io.File;  
import java.io.PrintWriter; 
import java.io.FileWriter;  

public class PrintWriterExample {  
    public static void main(String[] args) throws Exception {  

String className ="test123.java";

String src = System.getProperty("user.dir")+\\src\\testng"+packageName;
File f = new File(src,className);
f.createNewFile();

String fileName =src +"\\"+className ;
FileWriter fileWriter= new FileWriter(fileName);
PrintWriter printwriter = new PrintWriter(fileWriter);    
printwriter.println("a");
printwriter.println("b");
printwriter.println("c");
printwriter.close();
}
}
