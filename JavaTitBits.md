# HashMap – Single Key and Multiple Values Example <br> 
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



