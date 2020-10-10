<a href="https://www.browserstack.com/guide/how-to-find-broken-links-in-selenium">Finding Broken Links in Selenium</a><br>
<a href="https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/amp/">Read input Java</a><br>
<a href="https://www.javatpoint.com/access-modifiers">Access Modifiers in Java</a><br>
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
```
// Java program to ReverseString using StringBuilder 
class ReverseString { 

    public static void main(String[] args) 
    { 
        String input = "Geeks for Geeks"; 
        StringBuilder input1 = new StringBuilder(); 
        // append a string into StringBuilder input1 

        input1.append(input); 
 
        // reverse StringBuilder input1 
        input1 = input1.reverse(); 
        // print reversed String 
        System.out.println(input1); 
    } 
} 
Output:

skeeG rof skeeG
```
### :dart:By Reverse Iteration :<br> 
```
class ReverseString
{
  public static void main(String args[])
  {
    String original, reverse = "";
    Scanner in = new Scanner(System.in);

    System.out.println("Enter a string to reverse");
    original = in.nextLine();

    int length = original.length();

    for (int i = length - 1 ; i >= 0 ; i--)
      reverse = reverse + original.charAt(i);

    System.out.println("Reverse of the string: " + reverse);
  }
}
Input:
"my name is khan"
"I am sonoo jaiswal"    
   
Output:

nahk si eman ym
lawsiaj oonos ma I
```
### :dart:Write a program to reverse an array or string:<br> 
```
int []arr = {1, 2, 3, 4, 5, 6};
  end = arr.length()- 1;
  start = 0;

        int temp;
        while (start < end)
        {
           temp = arr[start]; 
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        } 
  //Output contents of now-reversed array.
  for(i = 0; i < len-1; i++)
    printf("%d ", a[i])
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
