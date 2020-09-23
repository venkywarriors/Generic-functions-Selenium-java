### :dart: How to identify object types in java:
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
#### Difference between instanceof and getClass() method
instanceof operator returns true, even if compared with subclass, for example, Subclass instanceof Superclass is true, but with getClass() its false. By using getClass() you ensure that your equals() implementation doesn't return true if compared with subclass object.
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
LinkedHashMap<Character, Integer> charOccurs=new LinkedHashMap<>();

for(char c : str) {
  Integer occ=charOccurs.get(c);
  if(null==occ) {
    occ=0;
  }
  else {
    occ=new Integer(occ.intValue()+1);
  }
  // "Note that insertion order is not affected 
  // if a key is re-inserted into the map."
  // Niiice!
  charOccurs.put(c, occ);
}

int order=1;
for(Map.Entry<Character, Integer> entry : charOccurs.entrySet()) {
  // this works because ...
  // "This linked list defines the iteration ordering,
  // which is normally the order in which keys were inserted"
  // Doubly-nice!!!
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
### :dart:By StringBuilder / StringBuffer:<br> 
```

```
