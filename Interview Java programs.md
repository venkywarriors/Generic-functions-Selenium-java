<a href="https://www.browserstack.com/guide/how-to-find-broken-links-in-selenium">Finding Broken Links in Selenium</a><br>
<a href="https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/amp/">Read input Java</a><br>
<a href="https://www.javatpoint.com/access-modifiers">Access Modifiers in Java</a><br>
<a href="https://www.toolsqa.com/selenium-webdriver/webdrivermanager/">WebDriver Manager</a><br>
<a href="https://beginnersbook.com/2014/08/java-regex-tutorial/">Java Regular Expressions</a><br>
### :dart:Read text file in java
```
// Java Program to illustrate reading from FileReader 
// using BufferedReader 
import java.io.*; 
public class ReadFromFile2 
{ 
  public static void main(String[] args)throws Exception 
  { 
  File file = new File("C:\\Users\\pankaj\\Desktop\\test.txt"); 
  
  BufferedReader br = new BufferedReader(new FileReader(file)); 
  
  String st; 
  while ((st = br.readLine()) != null) 
    System.out.println(st); 
  } 
} 
```
```
// Java Program to illustrate reading from 
// FileReader using FileReader 
import java.io.*; 
public class ReadingFromFile 
{ 
  public static void main(String[] args) throws Exception 
  { 
    // pass the path to the file as a parameter 
    FileReader fr = 
      new FileReader("C:\\Users\\pankaj\\Desktop\\test.txt"); 
  
    int i; 
    while ((i=fr.read()) != -1) 
      System.out.print((char) i); 
  } 
} 
```
### :dart:Java Program to Write Text File
```
public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("Hello World");
            writer.write("\r\n");   // write new line
            writer.write("Good Bye!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
```
```
public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 
            bufferedWriter.write("Hello World");
            bufferedWriter.newLine();
            bufferedWriter.write("See You Again!");
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
```
### :dart:Java Program to Print a1b9
```
String name="a1b5";
        char[] arr=name.toCharArray();
        int iter=0;
        String temp="";
        for(int i=0;i<arr.length;i++) {
        	try {
        		String value=String.valueOf(arr[i]);
        		//print();
        		iter=Integer.parseInt(value);
        		for(int j=0;j<iter;j++) {
        			System.out.print(temp);
        		}
        		temp="";
        	}catch(Exception e) {
        		temp=temp+arr[i];
        	}
// abbbbb
```
### :dart:Java Program to add two matrices
<a href="https://www.javatpoint.com/java-program-to-add-two-matrices">Matrix addition in Java</a><br>
<a href="https://www.programmingsimplified.com/java/source-code/java-program-multiply-two-matrices">Java matrix multiplication</a><br>
<a href="https://www.programmingsimplified.com/java/source-code/java-program-transpose-matrix">Matrix transpose in Java</a><br>
```
import java.util.Scanner;
class AddTwoMatrix
{
  public static void main(String args[])
  {
    int m, n, c, d;
    Scanner in = new Scanner(System.in);

    System.out.println("Enter the number of rows and columns of matrix");
    m = in.nextInt();
    n = in.nextInt();

    int first[][] = new int[m][n];
    int second[][] = new int[m][n];
    int sum[][] = new int[m][n];

    System.out.println("Enter the elements of first matrix");

    for (c = 0; c < m; c++)
      for (d = 0; d < n; d++)
        first[c][d] = in.nextInt();

    System.out.println("Enter the elements of second matrix");

    for (c = 0 ; c < m; c++)
      for (d = 0 ; d < n; d++)
        second[c][d] = in.nextInt();

    for (c = 0; c < m; c++)
      for (d = 0; d < n; d++)
        sum[c][d] = first[c][d] + second[c][d];  //replace '+' with '-' to subtract matrices

    System.out.println("Sum of the matrices:");

    for (c = 0; c < m; c++)
    {
      for (d = 0; d < n; d++)
        System.out.print(sum[c][d] + "\t");

      System.out.println();
    }
  }
}
```
### :dart:Display Fibonacci series up to a given number
```
int n = 100, t1 = 0, t2 = 1;
        
        System.out.print("Upto " + n + ": ");
        while (t1 <= n)
        {
            System.out.print(t1 + " ");

            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
```
Output:
```
0 1 1 2 3 5 8 13 21 34
```
### :dart:Prime Number using a for loop
```
int num = 29;
        boolean flag = false;
        for(int i = 2; i <= num/2; ++i)
        {
            // condition for nonprime number
            if(num % i == 0)
            {
                flag = true;
                break;
            }
        }

        if (!flag)
            System.out.println(num + " is a prime number.");
        else
            System.out.println(num + " is not a prime number.");
```
### :dart:Java Program to Check Armstrong Number
```
//1*1*1+5*5*5+3*3*3=153
int c=0,a,temp;  
    int n=153;//It is the number to check armstrong  
    temp=n;  
    while(n>0)  
    {  
    a=n%10;  
    n=n/10;  
    c=c+(a*a*a);  
    }  
    if(temp==c)  
    System.out.println("armstrong number");   
    else  
        System.out.println("Not armstrong number");   
   }  
```
### :dart:Longest Prefix in string array
```
String[] strArr={"java2blog","javaworld","javabean","javatemp"};

String longestPrefix=getLongestCommonPrefix(strArr);

System.out.println("Longest Prefix : "+longestPrefix);
}

public static String getLongestCommonPrefix(String[] strArr) {
if(strArr.length==0) return "";

// Find minimum length String
String minStr=getMinString(strArr);

int minPrefixStrLength=minStr.length();

for(int i=0;i<strArr.length;i++){

for( int j=0;j<minPrefixStrLength;j++){

if(minStr.charAt(j)!=strArr[i].charAt(j))
break;
}

if(j<minPrefixStrLength)
minPrefixStrLength=j;
}
return minStr.substring(0,minPrefixStrLength);
}

public static String getMinString(String[] strArr)
{
String minStr=strArr[0];
for(int i=1;i<strArr.length;i++){
if(strArr[i].length()<minStr.length())
minStr=strArr[i];
}
return minStr;
}

//output java
```
### :dart:Java program to replace ab with bba recursively
```
static String replace(String string, String pattern, String replacement) {
  int index = string.indexOf(pattern);
  if(index < 0) return string;
  int endIndex = index+pattern.length();
  return string.substring(0, index) + replacement +
      replace(string.substring(endIndex), pattern, replacement);
}
```
### :dart:Java balanced expressions check {[()]}
```
import java.util.Stack;

public class BalancedParenthensies {

    public static void main(String args[]) {

        System.out.println(balancedParenthensies("{(a,b)}"));
        System.out.println(balancedParenthensies("{(a},b)"));
        System.out.println(balancedParenthensies("{)(a,b}"));
    }

    public static boolean balancedParenthensies(String s) {
        Stack<Character> stack  = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {     
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }           
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
```
```
import java.util.Stack;

public class Balanced {
    public static void main (String [] args)
    {
        String test_good = "()(){}{}{()}";
        String test_bad = "((({}{}))()";

        System.out.println(checkBalanced(test_good));
        System.out.println(checkBalanced(test_bad));
    }

    public static boolean checkBalanced(String check)
    {
        Stack<Character> S = new Stack<Character>();
        for(int a = 0; a < check.length(); a++)
        {
            char let = check.charAt(a);
            if(let == '[' || let == '{' || let == '(')
                S.push(let);
            else if(let == ']' || let == '}' || let == ')')
            {
                if(S.empty())
                    return false;
                switch(let)
                {
                    // Opening square brace
                    case ']':
                        if (S.pop() != '[')
                            return false;
                        break;
                    // Opening curly brace
                    case '}':
                        if (S.pop() != '{')
                            return false;
                        break;
                    // Opening paren brace
                    case ')':
                        if (S.pop() != '(')
                            return false;
                        break;
                    default:
                        break;
                }
            }
        }
        if(S.empty())
            return true;
        return false;
    }
}
```
### :dart:How to count occurrences of a substring in string in Java?
```       
        String str = "JavaExamplesJavaCodeJavaProgram";
        
        String strFind = "Java";
        int count = 0, fromIndex = 0;
        
        while ((fromIndex = str.indexOf(strFind, fromIndex)) != -1 ){
            count++;
            fromIndex++;            
        }
        
        System.out.println("Total occurrences: " + count);
```
```
String str = "JavaExamplesJavaCodeJavaProgram";
 
int count = ( str.split(Pattern.quote("Java"), -1)).length ) - 1;
System.out.println("Total occurrences: " + count);
```
Using the Apache Commons library
```
String str = "JavaExamplesJavaCodeJavaProgram";
 
int count = StringUtils.countMatches(str, "Java"); 
System.out.println("Total occurrences: " + count);
```
Using regular expression
```
String str = "JavaExamplesJavaCodeJavaProgram";
 
int count = 0, startIndex = 0;
 
Pattern p = Pattern.compile("Java", Pattern.LITERAL);
Matcher m = p.matcher(str);
 
while(m.find(startIndex)){
    count++;
    startIndex = m.start() + 1;
}
 
System.out.println("Total occurrences: " + count);
```
### :dart:How to replace second occurence of char in a String? 
The indexOf() method returns the position of the first occurrence of specified character(s) in a string.
<br>
Tip: Use the lastIndexOf method to return the position of the last occurrence of specified character(s) in a string.
```
String string1= "Helllo";
int first=string1.indexOf('l',string1.indexOf('l')+1);
StringBuilder SB = new StringBuilder(string1); 
SB.setCharAt(first, 'k'); 
System.out.println(SB);
```
public int indexOf(String str, int fromIndex, char)
```
String string1= "Helllo";
 int first=string1.indexOf('l');
 String newstr= string1.substring(0, first+1);
 String newstr2= string1.substring(first+1, string1.length()).replaceFirst("l", "k");
 System.out.println(newstr+newstr2);
 ```
Returns: An int value, representing the index of the first occurrence of the character in the string, or -1 if it never occurs
```
  String word, letter;
        word = "test";
        letter = "t";
        int i = 0;

        i = word.indexOf(letter);

        while (i > -1) {
            // store i in arrayList
            i = word.indexOf(letter, i + 1);
             System.out.println(i);
            }
```
### :dart:Merge two arrays and remove duplicates in Java
public static void arraycopy(Object source, int source_position, Object destination, int destination_position, int length)
```
public int[] mergeArrays2(int[] arr1, int[] arr2){
    int[] merged = new int[arr1.length + arr2.length];
    System.arraycopy(arr1, 0, merged, 0, arr1.length);
    System.arraycopy(arr2, 0, merged, arr1.length, arr2.length);

    Set<Integer> nodupes = new HashSet<Integer>();

    for(int i=0;i<merged.length;i++){
        nodupes.add(merged[i]);
    }
System.out.println(nodupes);
```
### :dart:How to Find Common Elements Between Two Arrays
```
int[] numArray1 = {1, 4, 5};
  int[] numArray2 = {6, 1, 8, 34, 5};
  // Outer loop
  for(int i = 0; i < numArray1.length; i++){
   for(int j = 0; j < numArray2.length; j++){// inner loop
    if(numArray1[i] == numArray2[j]){
     System.out.println(numArray1[i]);
     break;
    }
   }
```
```
List<Integer> l1 = new ArrayList<Integer>();

l1.add(1);
l1.add(2);
l1.add(3);

List<Integer> l2= new ArrayList<Integer>();
l2.add(4);
l2.add(2);
l2.add(3);

System.out.println("l1 == "+l1);
System.out.println("l2 == "+l2);

List<Integer> l3 = new ArrayList<Integer>(l2);
l3.retainAll(l1);

System.out.println("l3 == "+l3);
Now, l3 should have only common elements between l1 and l2.

CONSOLE OUTPUT
l1 == [1, 2, 3]
l2 == [4, 2, 3]
l3 == [2, 3]
```
### :dart:How to Print Pyramid Pattern in Java? 
<a href="https://www.programiz.com/java-programming/examples/pyramid-pattern">Pyramid Pattern</a><br>
<a href="https://www.edureka.co/blog/30-pattern-programs-in-java/amp/">Pyramid Patterns</a><br>
```
public static void printTriagle(int n) 
{ 
        // outer loop to handle number of rows 
        //  n in this case 
        for (int i=0; i<n; i++) 
        { 
            // inner loop to handle number spaces 
            // values changing acc. to requirement 
            for (int j=n-i; j>1; j--) 
            { 
                // printing spaces 
                System.out.print(" "); 
            }    
            //  inner loop to handle number of columns 
            //  values changing acc. to outer loop 
            for (int j=0; j<=i; j++ ) 
            { 
                // printing stars 
                System.out.print("* "); 
            }   
            // ending line after each row 
            System.out.println(); 
        } 
    } 
     
    // Driver Function 
    public static void main(String args[]) 
    { 
        int n = 5; 
        printTriagle(n); 
    } 
} 
```
Output:
```

    * 
   * * 
  * * * 
 * * * * 
* * * * * 
```
### :dart:Java code to find length of the String without using length method
```
   public static void main(String args[]) throws Exception {
      String str = "sampleString";
      int i = 0;
      for(char c: str.toCharArray()) {
         i++;
      }
      System.out.println("Length of the given string ::"+i);
   }
```
### :dart:Split in Java
In case you want to have the split character to end up in left hand side, use positive lookbehind by prefixing ?<= group on the pattern.
```
String string = "004-034556";
String[] parts = string.split("(?<=-)");
String part1 = parts[0]; // 004-
String part2 = parts[1]; // 034556
```
In case you want to have the split character to end up in right hand side, use positive lookahead by prefixing ?= group on the pattern.
```
String string = "004-034556";
String[] parts = string.split("(?=-)");
String part1 = parts[0]; // 004
String part2 = parts[1]; // -034556
```
If you'd like to limit the number of resulting parts, then you can supply the desired number as 2nd argument of split() method.
```
String string = "004-034556-42";
String[] parts = string.split("-", 2); // string.split("[.-]") multiple delimited 
String part1 = parts[0]; // 004
String part2 = parts[1]; // 034556-42
```
### :dart:Java program to delete vowels in a given string
```
public class RemoveVowelsInString
{
   public static void main(String[] args)
   {
      String str = "Deekshit Prasad";
      System.out.println("Given string: " + str);
      str = str.replaceAll("[AaEeIiOoUu]", "");
      System.out.println("After deleting vowels in given a string: " + str);
   }
}
```
Remove consonants from a string using regular expressions
```
public class RemovingConstants {
   public static void main( String args[] ) {
      String input = "Hi welc#ome to t$utori$alspoint";
      String regex = "([^aeiouAEIOU0-9\\W]+)";
      String result = input.replaceAll(regex, "");
      System.out.println("Result: "+result);
   }
}
```
###  :dart:How to create a class which is not inheritable and static in java?
```
public final class Trial // it is the FINAL
{
    private static final int CONSTANT_VALUE = 666;

    private Trial() // it is PRIVATE instead of PUBLIC
    {
    }

    public static int getConstantValue()
    {
       return CONSTANT_VALUE;
    }
}
```
### :dart:Are static variables inherited
```
public class Parent {
    static String str = "Parent";
}

public class Child extends Parent {
    static String str = "Child";

    public static void main(String [] args)
    {
        System.out.println(Child.str);
    }
}
Now the output is "Child".
```
### :dart:Program for Display Alphabets in Java
```
public static void main(String[] args) {
        char c;
        for(c = 'a'; c <= 'z'; ++c)
            System.out.print(c + " ");
    }
```
```
char ch;
//ASCII value for 'a-z' is 97-122 and 'A-Z' is 65-90
for(ch=97; ch<=122; ch++)
{
System.out.print(ch+" ");
}
System.out.print("\n");
```
### :dart:Java program to revere string and maintain same case
```
import java.util.*;
public class Simple{
public static void main(String args[]){
String name="I Have TesteD tHis";
String[] splited=name.split(" ");
String val="";
for(String split:splited) {
int i=0;
char[] arr=split.toCharArray() ;
int[] type=new int[arr.length];
for(int k=0;k<arr.length;k++) {
type[k]=Character.getType(arr[k]);
}
for(int j=arr.length-1;j>=0;j--) {
if(type[i]==1) {
char ch=arr[j];
ch=Character.toUpperCase(ch);
val=val+ch;
}else if(type[i]==2) {
char ch=arr[j];
ch=Character.toLowerCase(ch);
val=val+ch;
}
i=i+1;
}
val=val+" ";
}
System.out.println(val) ;
}
}
// Input I Have TesteD tHis
//Output I Evah DetseT sIht
```
### :dart:Java program to separate alphabets and numbers from string
```
public static void separate(String string) {
        StringBuilder alphabetsBuilder = new StringBuilder();
        StringBuilder numbersBuilder = new StringBuilder();
        StringBuilder symbolsBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (Character.isAlphabetic(ch)) {
                alphabetsBuilder.append(ch);
            } else if (Character.isDigit(ch)) {
                numbersBuilder.append(ch);
            } else {
                symbolsBuilder.append(ch);
            }
        }
        System.out.println("Alphabets in string: " + alphabetsBuilder.toString());
        System.out.println("Numbers in String: " + numbersBuilder.toString());
        System.out.println("Sysmbols in String: " + symbolsBuilder.toString()); 
    }
```
```
public static void Separate(String str) 
{
    String number = "";
    String letter = "";
    String symbol = "";

    for (int i = 0; i < str.length(); i++) 
    {
        char a = str.charAt(i);
        if (Character.isDigit(a)) 
        {
            number = number + a;
            continue;
        } 
        if(Character.isLetter(a))
        {
            letter = letter + a;
        }
        else
        {
            symbol = symbol + a;
        }
    }
    System.out.println("Alphabets in string:"+letter);
    System.out.println("Numbers in String:"+number);   
}
```
### :dart:Remove duplicates from a given string? :
```
StringBuilder sb = new StringBuilder();
int idx;
for (int i = 0; i < str.length(); i++) {
    char c = str.charAt(i);
    idx = str.indexOf(c, i + 1);
    if (idx == -1) {
        sb.append(c);
    }
}
```
```
char[] chars = str.toCharArray();
StringBuilder sb = new StringBuilder();
boolean repeatedChar;
for (int i = 0; i < chars.length; i++) {
    repeatedChar = false;
    for (int j = i + 1; j < chars.length; j++) {
        if (chars[i] == chars[j]) {
            repeatedChar = true;
            break;
        }
    }
    if (!repeatedChar) {
        sb.append(chars[i]);
    }
}
```
```
StringBuilder sb = new StringBuilder();
if(!str.isEmpty()) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
 
    sb.append(chars[0]);
    for (int i = 1; i < chars.length; i++) {
        if (chars[i] != chars[i - 1]) {
            sb.append(chars[i]);
        }
    }
}
```
### :dart:How to find the JVM version from a program? :
```
System.getProperty("java.version")
System.getProperty("os.name")
System.getProperty("user.name")
InetAddress.getLocalHost().getHostName()
InetAddress.getLocalHost().getHostAddress()

//make sure have correct import statements - I had to add these
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

WebDriver driver = new FirefoxDriver();

Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
String browserName = caps.getBrowserName();
String browserVersion = caps.getVersion();
System.out.println(browserName+" "+browserVersion);
```
### :dart:VBS file from Java:
```
public static void main(String[] args) {
   try {
      Runtime.getRuntime().exec( "wscript D:/Send_Mail_updated.vbs" );
   }
   catch( IOException e ) {
      System.out.println(e);
      System.exit(0);
   }
}
```
### :dart:How to identify object types in java:
```
public void test(Object value) {

        if (value.getClass() == Integer) {
            System.out.println("This is an Integer");
        }else if(value.getClass() == String){
            System.out.println("This is a String");
        }else if(value.getClass() == Float){
            System.out.println("This is a Float");
        }

}
```
```
if (value instanceof Integer) {
        System.out.println("This is an Integer");
    } else if(value instanceof String) {
        System.out.println("This is a String");
    } else if(value instanceof Float) {
        System.out.println("This is a Float");
    }
```
<a href="https://www.javamadesoeasy.com/2015/04/hashmap-vs-hashtable-vs-linkedhashmap.html?m=1">Differences between HashMap, Hashtable, LinkedHashMap and TreeMap in java</a>
#### Difference between instanceof and getClass() method
instanceof operator returns true, even if compared with subclass, for example, Subclass instanceof Superclass is true, but with getClass() its false. By using getClass() you ensure that your equals() implementation doesn't return true if compared with subclass object.
### :dart: Difference between StringBuffer and StringBuilder
* StringBuffer is synchronized i.e. thread safe. It means two threads can't call the methods of StringBuffer simultaneously
* StringBuilder is non-synchronized i.e. not thread safe. It means two threads can call the methods of StringBuilder simultaneously
* StringBuffer is less efficient than StringBuilder
* StringBuilder is more efficient than StringBuffer
### :dart: How to identify object types in C#:<br>
<strong>typeof </strong>takes a type name (which you specify at compile time).<br>
<strong>GetType </strong>gets the runtime type of an instance.<br>
<strong>is </strong>returns true if an instance is in the inheritance tree.<br>
```
1.

Type t = typeof(obj1);
if (t == typeof(int))
This is illegal, because typeof only works on types, not on variables. I assume obj1 is a variable. So, in this way typeof is static, and does its work at compile time instead of runtime.

2.

if (obj1.GetType() == typeof(int))
This is true if obj1 is exactly of type int. If obj1 derives from int, the if condition will be false.

3.

if (obj1 is int)
This is true if obj1 is an int, or if it derives from a class called int, or if it implements an interface called int.
```
### :dart:Java program to Type casting<br> 
Java – Convert String to int using Integer.parseInt(String)<br>
```
String str = "1234";
int inum = Integer.parseInt(str);
```
Java – Convert String to int using Integer.valueOf(String)
```
String str="1122ab";
int num = Integer.valueOf(str);
```
<strong>Differences between Integer.parseInt() and Integer.valueOf()</strong>
* Integer.valueOf() returns an Integer object while Integer.parseInt() returns a primitive int.
* Both String and integer can be passed a parameter to Integer.valueOf() whereas only a String can be passed as parameter to Integer.parseInt().
* Integer.valueOf() can take a character as parameter and will return its corresponding unicode value whereas Integer.parseInt() will produce an error on passing a character as parameter.
### :dart:C# program to Type casting<br> 
Parse Method
```
Int16.Parse("100"); // returns 100
Int16.Parse("(100)", NumberStyles.AllowParentheses); // returns -100
int.Parse("30,000", NumberStyles.AllowThousands, new CultureInfo("en-au"));//
```
Convert Class
```
Convert.ToInt16("100"); // returns short
Convert.ToInt16(null);//returns 0
```
Both int.Parse and Convert.ToInt32 are used to convert string into the integer but Only difference between them is to Convert.ToInt32 handle null and returns '0' as output and int.parse is not going to handle NULL and will give a Argument Null Exception.
### :dart:Replacing a character every occurrence in a string in java
```
public static void main(String| args) {
//input:"HELLO WORLD"
//OUTPUT:" HExxx0 WORxxxD
String s="HELLO WORLD";
String z="";
int count=1;
for(int i=0;i<s.length():i++) {
if(s.charAt(i)=="'L) {
for(int j=0;j<count;j++) {
Z=Z+'X'; 
}
count++
else{
Z=Z+s.charAt(i);
}}
System.out.printin(z);
}
```
```
//input:"HELLO WORLD"
//OUTPUT:" HExxx0 WORxxxD
String s="HELLO WORLD";
String z="";
Stringbuilder array=new Stringbuilder(s);
for(int I=O; I<array.length; I++)
{
If (array[I]=='L')
{
z+='X'; 
array.remove(I,1);
array.insert(I,z);
}
}
s=array.Tostring();
Console.writeline
```
### :dart:Replace all occurrences of a character with just a character
```
string strTest = "%%%A%%B%%C%%";
        string strPattern = "%+";
        RegexOptions opt = RegexOptions.IgnoreCase;
        var reg = new Regex(strPattern, opt);
        var strReplaceResult = reg.Replace(strTest, "%");
result will be "%A%B%C%"

private static string TruncatePercents(string input)
{
    return Regex.Replace(input, @"%+", "%");
}
```
### :dart:Java program to check whether two strings are anagram or not? <br> 
```
import java.util.Arrays;  
   
public class AnagramString {  
    static void isAnagram(String str1, String str2) {  
        String s1 = str1.replaceAll("\\s", "");  
        String s2 = str2.replaceAll("\\s", "");  
        boolean status = true;  
        if (s1.length() != s2.length()) {  
            status = false;  
        } else {  
            char[] ArrayS1 = s1.toLowerCase().toCharArray();  
            char[] ArrayS2 = s2.toLowerCase().toCharArray();  
            Arrays.sort(ArrayS1);  
            Arrays.sort(ArrayS2);  
            status = Arrays.equals(ArrayS1, ArrayS2);  
        }  
        if (status) {  
            System.out.println(s1 + " and " + s2 + " are anagrams");  
        } else {  
            System.out.println(s1 + " and " + s2 + " are not anagrams");  
        }  
    }  
   
    public static void main(String[] args) {  
        isAnagram("Keep", "Peek");  
        isAnagram("Mother In Law", "Hitler Woman");  
    }  
}  
```
### :dart:How To Non repeating character in a string?
```
String intitialString = "statistic non";
        int count = 0;
        char[] ch = intitialString.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    count++;
                }
            }
            if (count > 1) {
                count = 0;
            } else
                System.out.println(ch[i]);
        }
output

a
c
o
```
```
// We keep only a map of between tha char and the number of
// occurrences. We don't store the positions for the next (after first)
// occurrences, but the LinkedHashMap guarantees that
// the iteration order is the same as  insertion order
// (so first inserted letters will appear first when iterating)
LinkedHashMap<Character, Integer> charCountMap=new LinkedHashMap<>();
char[] str = inputString.toCharArray();
for(char c : str) {
  if (charCountMap.containsKey(c)) { 
                // If char is present in charCountMap, 
                // incrementing it's count by 1 
                charCountMap.put(c, charCountMap.get(c) + 1); 
            } 
            else { 
                // If char is not present in charCountMap, 
                // putting this char to charCountMap with 1 as it's value 
                charCountMap.put(c, 1); 
            } 
}

int order=1;
for(Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
  // this works because ...
  // "This linked list defines the iteration ordering,
  // which is normally the order in which keys were inserted"
  
  if(1==entry.getValue()) { // single occurrence
    System.out.println("Char: "+entry.getKey()+" order: "+order);
    order++; 
  }
}
```
## How to reverse String in Java

### :dart:By StringBuilder / StringBuffer:<br> 
```
public class StringFormatter {  
public static String reverseString(String str){  
    StringBuilder sb=new StringBuilder(str);  
    sb.reverse();  
    return sb.toString();  
}  
}  

public class TestStringFormatter {  
public static void main(String[] args) {  
    System.out.println(StringFormatter.reverseString("my name is khan"));  
    System.out.println(StringFormatter.reverseString("I am sonoo jaiswal"));      
    }  
}  
Output:

nahk si eman ym
lawsiaj oonos ma I
```
```
// Java program to Reverse a String  by 
// converting string to characters  one 
// by one 
class ReverseString { 

    public static void main(String[] args) 
    { 
        String input = "GeeksForGeeks"; 
        // convert String to character array 
        // by using toCharArray 

        char[] try1 = input.toCharArray();  

        for (int i = try1.length - 1; i >= 0; i--) 
           System.out.print(try1[i]); 
    } 
} 
Output:

skeeGrofskeeG
```
### :dart: Java Program to Reverse a String using Recursion
```
import java.util.Scanner;
public class JavaExample {

    public static void main(String[] args) {
        String str;
        System.out.println("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        scanner.close();
        String reversed = reverseString(str);
        System.out.println("The reversed string is: " + reversed);
    }

    public static String reverseString(String str)
    {
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
Output:
Enter your username: 
How are you doing?
The reversed string is: ?gniod uoy era woH
```
```
// Java program to Reverse a String using swapping 
// of variables 
class ReverseString { 

    public static void main(String[] args) 
    { 
        String input = "Geeks For Geeks"; 
        char[] temparray = input.toCharArray(); 
        int left, right = 0; 
        right = temparray.length - 1; 

        for (left = 0; left < right; left++, right--) { 
            // Swap values of left and right 
            char temp = temparray[left]; 
            temparray[left] = temparray[right]; 
            temparray[right] = temp; 
        } 

        for (char c : temparray) 
            System.out.print(c); 
        System.out.println(); 
    } 
} 
Output:

skeeG roF skeeG
```
### :dart:Find Second Largest Number in an Array:<br> 
```
public class SecondLargestInArrayExample{  
public static int getSecondLargest(int[] a, int total){  
int temp;  
for (int i = 0; i < total; i++)   
        {  
            for (int j = i + 1; j < total; j++)   
            {  
                if (a[i] > a[j])   
                {  
                    temp = a[i];  
                    a[i] = a[j];  
                    a[j] = temp;  
                }  
            }  
        }  
       return a[total-2];  
}  
public static void main(String args[]){  
int a[]={1,2,5,6,3,2};  
int b[]={44,66,99,77,33,22,55};  
System.out.println("Second Largest: "+getSecondLargest(a,6));  
System.out.println("Second Largest: "+getSecondLargest(b,7));  
}}  

Output:

Second Largest: 5
Second Largest: 77
```
Find 2nd Largest Number in Array using Arrays
Let's see another example to get second largest element or number in java array using collections.
```
import java.util.Arrays;  
public class SecondLargestInArrayExample1{  
public static int getSecondLargest(int[] a, int total){  
Arrays.sort(a);  
return a[total-2];  
}  
public static void main(String args[]){  
int a[]={1,2,5,6,3,2};  
int b[]={44,66,99,77,33,22,55};  
System.out.println("Second Largest: "+getSecondLargest(a,6));  
System.out.println("Second Largest: "+getSecondLargest(b,7));  
}}  

Output:

Second Largest: 5
Second Largest: 77
```
Find 2nd Largest Number in Array using Collections
Let's see another example to get second largest number in java array using collections.
```
import java.util.*;  
public class SecondLargestInArrayExample2{  
public static int getSecondLargest(Integer[] a, int total){  
List<Integer> list=Arrays.asList(a);  
Collections.sort(list);  
int element=list.get(total-2);  
return element;  
}  
public static void main(String args[]){  
Integer a[]={1,2,5,6,3,2};  
Integer b[]={44,66,99,77,33,22,55};  
System.out.println("Second Largest: "+getSecondLargest(a,6));  
System.out.println("Second Largest: "+getSecondLargest(b,7));  
}}  

Output:

Second Largest: 5
Second Largest: 77
```
### :dart:Sort the array in a given index range:<br> 
Input: arr[] = {7, 8, 4, 5, 2}, a = 1, b = 4
Output: 7 2 4 5 8
For the index range [1, 4] we get the elements 8, 4, 5 and 2
On sorting these elements we get 2, 4, 5 and 8.
So the array is modified as {7, 2, 4, 5, 8}
```
import java.io.*; 
import java.util.*; 
import java.lang.*; 
 
class GFG { 
    // Function to sort the elements of the array 
    // from index a to index b 

    static void partSort(int[] arr, int N, int a, int b) 
    { 
        // Variables to store start and end of the index range 

        int l = Math.min(a, b); 
        int r = Math.max(a, b); 

        // Sort the subarray from arr[l] to arr[r]  

        Arrays.sort(arr, l, r+1); 

        // Print the modified array 

        for (int i = 0; i < N; i++)  
            System.out.print(arr[i] + " "); 
    }
    public static void main(String args[]) 
    { 
        int[] arr = { 7, 8, 4, 5, 2 }; 
        int a = 1, b = 4; 
        int N = arr.length; 
        partSort(arr, N, a, b); 
    } 
} 
```
