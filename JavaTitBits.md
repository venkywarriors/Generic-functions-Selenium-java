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
 * @author Jagadeesh Motamarri
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


