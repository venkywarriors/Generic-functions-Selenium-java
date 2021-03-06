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
### :dart: Static variables are shared among all the instances of class
In this example, String variable is non-static and integer variable is Static. As you can see in the output that the non-static variable is different for both the objects but the static variable is shared among them, thats the reason the changes made to the static variable by object ob2 reflects in both the objects.
<br><a href="https://www.javatpoint.com/static-keyword-in-java">Static in Java</a>
```
class JavaExample{
   //Static integer variable
   static int var1=77; 
   //non-static string variable
   String var2;

   public static void main(String args[])
   {
	JavaExample ob1 = new JavaExample();
	JavaExample ob2 = new JavaExample();
	/* static variables can be accessed directly without
	 * any instances. Just to demonstrate that static variables
	 * are shared, I am accessing them using objects so that 
	 * we can check that the changes made to static variables
	 * by one object, reflects when we access them using other
	 * objects
	 */
        //Assigning the value to static variable using object ob1
	ob1.var1=88;
	ob1.var2="I'm Object1";
        /* This will overwrite the value of var1 because var1 has a single 
         * copy shared among both the objects.
         */
        ob2.var1=99;
	ob2.var2="I'm Object2";
	System.out.println("ob1 integer:"+ob1.var1);
	System.out.println("ob1 String:"+ob1.var2);
	System.out.println("ob2 integer:"+ob2.var1);
	System.out.println("ob2 STring:"+ob2.var2);
   }
}
```
Output:
```
ob1 integer:99
ob1 String:I'm Object1
ob2 integer:99
ob2 STring:I'm Object2
```
<br><a href="https://www.javatpoint.com/final-keyword">Final keyword in java</a>
<br><a href="https://beginnersbook.com/2013/05/abstract-class-vs-interface-in-java/">Difference Between Abstract Class and Interface in Java</a>
<br><a href="https://howtodoinjava.com/java9/java9-private-interface-methods/">Private Methods in Interface – Java 9</a>
<br><a href="https://www.tutorialspoint.com/why-an-interface-doesn-t-have-a-constructor-whereas-an-abstract-class-have-a-constructor-in-java">Why an interface doesn't have a constructor whereas an abstract class have a constructor in Java?</a>
<br><a href="https://way2java.com/oops-concepts/java-made-simple-java-private-abstract-method-with-example/">why abstract class private Method</a>
<br><a href="https://www.tutorialspoint.com/Can-we-overload-or-override-a-static-method-in-Java">Can we overload or override a static method in Java?</a>
<br><a href="https://www.java67.com/2015/06/can-you-overload-or-override-main-in-java.html?m=1">Can you Overload or Override main method in Java?</a>
<br><a href="https://cs-fundamentals.com/tech-interview/java/why-does-main-method-have-to-be-static">Why is main method public static and void in Java</a>
<br><a href="https://www.geeksforgeeks.org/understanding-public-static-void-mainstring-args-in-java/amp/">Understanding public static void main(String[] args) in Java</a>
<br><a href="https://www.tutorialspoint.com/java/java_encapsulation.htm">Java - Encapsulation</a>
### :dart:<a href="https://beginnersbook.com/2013/05/java-multiple-inheritance/">Does Java support Multiple inheritance?</a>
```
// A simple Java program to demonstrate multiple 
// inheritance through default methods. 
interface PI1 
{ 
    // default method 
    default void show() 
    { 
        System.out.println("Default PI1"); 
    } 
} 

interface PI2 
{ 
    // Default method 
    default void show() 
    { 
        System.out.println("Default PI2"); 
    } 
} 
 
// Implementation class code 
class TestClass implements PI1, PI2 
{ 
    // Overriding default show method 
    public void show() 
    { 
        // use super keyword to call the show 
        // method of PI1 interface 
        PI1.super.show();   

        // use super keyword to call the show 
        // method of PI2 interface 

        PI2.super.show(); 
    } 

    public static void main(String args[]) 
    { 
        TestClass d = new TestClass(); 
        d.show(); 
    } 
} 
```
Output 
```
Default PI1
Default PI2
```
