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
### :dart:By Reverse Iteration :<br> 
```
public class StringFormatter {  
public static String reverseString(String str){  
    char ch[]=str.toCharArray();  
    String rev="";  
    for(int i=ch.length-1;i>=0;i--){  
        rev+=ch[i];  
    }  
    return rev;  
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
### :dart:By StringBuilder / StringBuffer:<br> 
```

```
## HashMap – Single Key and Multiple Values Example <br> 
### Scenario <br> 
HashMap can be used to store key-value pairs. But sometimes you may want to store multiple values for the same key.

For example:

For Key A, you want to store - Apple, Aeroplane

For Key B, you want to store - Bat, Banana

For Key C, you want to store – Cat, Car

The following code snippets will show you three different ways of storing key-value pairs with a distinction of Single Key and Multiple Values
 ### :dart:HashMap – Single Key and Multiple Values Using List: <br> 
```
package com.skilledmonster.examples.util.map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * HashMap - Single Key and Multiple Values using List
 *
 * @author Ragavendra 
 *
 */
public class SingleKeyMultipleValueUsingList {
    public static void main(String[] args) {
        // create map to store
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        // create list one and store values
        List<String> valSetOne = new ArrayList<String>();
        valSetOne.add("Apple");
        valSetOne.add("Aeroplane");
        // create list two and store values
        List<String> valSetTwo = new ArrayList<String>();
        valSetTwo.add("Bat");
        valSetTwo.add("Banana");
        // create list three and store values
        List<String> valSetThree = new ArrayList<String>();
        valSetThree.add("Cat");
        valSetThree.add("Car");
        // put values into map
        map.put("A", valSetOne);
        map.put("B", valSetTwo);
        map.put("C", valSetThree);
        // iterate and display values
        System.out.println("Fetching Keys and corresponding [Multiple] Values n");
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();
            System.out.println("Key = " + key);
            System.out.println("Values = " + values + "n");
        }
    }
}
```
 ### :dart:HashMap – Single Key and Multiple Values Using Google Guava Collections: <br> 
```

package com.skilledmonster.examples.util.map;
import java.util.Set;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
/**
 * HashMap - Single Key and Multiple Values using Google Guava Collections
 *
 * @author Ragavendra
 * @version 1.0
 */
public class SingleKeyMultipleValueUsingGuava {
    public static void main(String[] args) {
        // create multimap to store key and values
        Multimap<String, String> multiMap = ArrayListMultimap.create();
        // put values into map for A
        multiMap.put("A", "Apple");
        multiMap.put("A", "Aeroplane");
        // put values into map for B
        multiMap.put("B", "Bat");
        multiMap.put("B", "Banana");
        // put values into map for C
        multiMap.put("C", "Cat");
        multiMap.put("C", "Car");
        // retrieve and display values
        System.out.println("Fetching Keys and corresponding [Multiple] Values n");
        // get all the set of keys
        Set<String> keys = multiMap.keySet();
        // iterate through the key set and display key and values
        for (String key : keys) {
            System.out.println("Key = " + key);
            System.out.println("Values = " + multiMap.get(key) + "n");
        }
    }
}
```
 ### :dart:HashMap – Single Key and Multiple Values Using Apache Commons Collection: <br> 
```
package com.skilledmonster.examples.util.map;
import java.util.Set;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;
/**
 * HashMap - Single Key and Multiple Values using Apache Commons Collections
 *
 * @author Ragavendra
 * @version 1.0
 */
public class SingleKeyMultipleValueUsingApacheCollections {
    public static void main(String[] args) {
        // create multimap to store key and values
        MultiMap multiMap = new MultiValueMap();
        // put values into map for A
        multiMap.put("A", "Apple");
        multiMap.put("A", "Aeroplane");
        // put values into map for B
        multiMap.put("B", "Bat");
        multiMap.put("B", "Banana");
        // put values into map for C
        multiMap.put("C", "Cat");
        multiMap.put("C", "Car");
        // retrieve and display values
        System.out.println("Fetching Keys and corresponding [Multiple] Values n");
        // get all the set of keys
        Set<String> keys = multiMap.keySet();
        // iterate through the key set and display key and values
        for (String key : keys) {
            System.out.println("Key = " + key);
            System.out.println("Values = " + multiMap.get(key) + "n");
        }
    }
}
```
# How to Store Duplicate Keys in a Map in Java? <br> 
### Scenario <br> 

Hashmap type Overwrite that key if hashmap key is same key <br> 
map.put("1","1111"); <br> 
map.put("1","2222"); <br> 

##### Output <br> 
key:value
1:2222

The following code snippets will show you three different ways of storing duplicate key-value pairs 
 ### :dart:Collection as Value: <br> 
```
public static void main(String[] args) {
 	Map<String, List<String>> map = new HashMap<>();
	 List<String> list = new ArrayList<>();
	 map.put("key1", list);
	 map.get("key1").add("value1");
	 map.get("key1").add("value2");
	
	 System.out.println("Print map -> "+map);
	 System.out.println("value of key1 -> "+map.get("key1")); 
}
```
##### Output<br> 
```
Print map ->{key1=[value1, value2]}
value of key1 ->[value1, value2]
```
 ### :dart:Apache Commons Collections: <br> 
 #### MultiHashMap <br>
It's implemented by the org.apache.commons.collections.MultiHashMap; class, defines a Map that holds a collection of values against each key.
```
public static void main(String[] args) {
 MultiHashMap mp=new MultiHashMap();
	      mp.put("a", 10);
	      mp.put("a", 10);
	      mp.put("a", 11);
	      mp.put("a", 12);
	      mp.put("b", 13);
	      mp.put("c", 14);
	      mp.put("c", 14);
	      mp.put("e", 15);
	
	      List list = null;

	      Set set = mp.entrySet();
	      Iterator i = set.iterator();
	      while(i.hasNext()) {
	         Map.Entry me = (Map.Entry)i.next();
	         list=(List)mp.get(me.getKey());

	         for(int j=0;j<list.size();j++)
	         {
	          System.out.println(me.getKey()+": value :"+list.get(j));
	         }
	      } 
}
```
##### Output<br> 
```
a: value :10
a: value :10
a: value :11
a: value :12
b: value :13
c: value :14
c: value :14
e: value :15
```
#### MultiMap<br>
The org.apache.commons.collections4.MultiMap interface defines a Map that holds a collection of values against each key.

It's implemented by the org.apache.commons.collections4.map.MultiValueMap class, which automatically handles most of the boilerplate under the hood:
```
	MultiMap<String, String> map = new MultiValueMap<>();
	map.put("key1", "value1");
	map.put("key1", "value2");
	map.put("key1", "value1");
	map.put("key2", "value1");
	
	System.out.println("Print map -> "+map);
	System.out.println("value of key1 -> "+map.get("key1"));
```
##### Output<br> 
```
Print map -> {key1=[value1, value2, value1], key2=[value1]}
value of key1 -> [value1, value2, value1]
```

#### MultiValuedMap <br>
The successor of MultiMap is the org.apache.commons.collections4.MultiValuedMap interface. It has multiple implementations ready to be used.
```
	MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
	map.put("key1", "value1");
	map.put("key1", "value2");
	map.put("key1", "value1");
	map.put("key2", "value1");
	
	System.out.println("Print map -> "+map);
	System.out.println("value of key1 -> "+map.get("key1"));
```
##### Output<br> 
```
Print map -> {key1=[value1, value2, value1], key2=[value1]}
value of key1 -> [value1, value2, value1]
```
Alternatively, we could use a HashSet, which drops duplicates:
```
	MultiValuedMap<String, String> map = new HashSetValuedHashMap<>();
	map.put("key1", "value1");
	map.put("key1", "value2");
	map.put("key1", "value1");
	map.put("key2", "value1");
	
	System.out.println("Print map -> "+map);
	System.out.println("value of key1 -> "+map.get("key1"));
```
##### Output<br> 
```
Print map -> {key1=[value2, value1], key2=[value1]}
value of key1 -> [value2, value1]
```
Note: All the above implementations are not thread-safe.
### :dart:Guava Multimap: <br> 
Guava is the Google Core Libraries for Java API.
The most common one is the com.google.common.collect.ArrayListMultimap, which uses a HashMap backed by an ArrayList for every value:
```
	Multimap<String, String> map = ArrayListMultimap.create();
	map.put("key1", "value1");
	map.put("key1", "value2");
	map.put("key1", "value1");
	map.put("key2", "value1");
	
	System.out.println("Print map -> "+map);
	System.out.println("value of key1 -> "+map.get("key1"));
```
##### Output<br> 
```
Print map -> {key1=[value1, value2, value1], key2=[value1]}
value of key1 -> [value1, value2, value1]
```
### :dart:Common Map Implementations: <br> 
When we need a specific Map implementation, the first thing to do is check if it exists, because probably Guava has already implemented it.

For example, we can use the com.google.common.collect.LinkedHashMultimap, which preserves the insertion order of keys and values:
```
	Multimap<String, String> map = LinkedHashMultimap.create();
	map.put("key1", "value1");
	map.put("key1", "value2");
	map.put("key1", "value1");
	map.put("key2", "value1");
	
	System.out.println("Print map -> "+map);
	System.out.println("value of key1 -> "+map.get("key1"));
```
##### Output<br> 
```
Print map -> {key1=[value1, value2], key2=[value1]}
value of key1 -> [value1, value2]
```
Alternatively, we can use a com.google.common.collect.TreeMultimap, which iterates keys and values in their natural order:
```
	Multimap<String, String> map = TreeMultimap.create();
	map.put("key1", "value1");
	map.put("key1", "value2");
	map.put("key1", "value1");
	map.put("key2", "value1");
	
	System.out.println("Print map -> "+map);
	System.out.println("value of key1 -> "+map.get("key1"));
```
##### Output<br> 
```
Print map -> {key1=[value1, value2], key2=[value1]}
value of key1 -> [value1, value2]
```
# How to maintain insertion order of the elements in Java HashMap? <br> 
### Scenario <br> 
We cannot. As HashMap does not maintain the order of the elements. This means that It might not return the elements in the same order they were inserted into it. If application needs the elements to be returned in the same order they were inserted, LinkedHashMap should be used.

LinkedHashMap implements doubly linked list so that it can traverse through all the elements.This linked list defines the iteration ordering, which is normally the order in which keys were inserted into the map (insertion-order).
 ### :dart:LinkedHashMap -return the elements in the order they were inserted into the map : <br> 
```
Map<String, String> map = new LinkedHashMap<String, String>();
 
map.put("id", "3");
map.put("name", "shyam");
map.put("age", "26");
 
for (Map.Entry<String, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}
```
##### Output<br> 
This will print the elements in the order they were put into the map: 
```
id = 3 
name = shyam 
age = 26 
```
 ### :dart:LinkedHashSet -return the elements in the order they were inserted into the map: <br> 
```
LinkedHashSet<String> lhs = new LinkedHashSet<String>(); 
  
        // insert element in LinkedHashMap 
        lhs.add("Amit"); 
  
        // insert first null key 
        lhs.add(null); 
        lhs.add("Vijay"); 
        lhs.add("Rahul"); 
  
        // insert second null key 
        // which replace first null key value 
        lhs.add(null); 
        // insert duplicate 
        lhs.add("Vijay"); 
  
        Iterator<String> itr = lhs.iterator(); 
        while (itr.hasNext()) { 
            System.out.println(itr.next()); 
        } 
```
##### Output<br> 
```
Amit
null
Vijay
Rahul
```
* Order: Both LinkedHashMap and LinkedHashSet maintain the insertion order. Elements get sorted in the same sequence in which they have been added.
* Synchronized: Both are not synchronized and must be synchronized externally.
* Duplicates: LinkedHashMap does a mapping of keys to values so not have duplicates and LinkedHashSet simply stores a collection of things with no duplicates.
* Memory: Keeping the insertion order in both LinkedHashmap and LinkedHashset have additional associated costs, both in terms of spending additional CPU cycles and needing more memory.
* Replacement: LinkedHashMap replace value with duplicate key while LinkedHashSet not change original value.
Operation: LinkedHashMap does a mapping of keys to values while LinkedHashSet simply stores a collection of things.

