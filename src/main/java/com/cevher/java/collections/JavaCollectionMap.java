package com.cevher.java.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JavaCollectionMap {


/*
 * abstract int size()             // Returns the number of key-value pairs
 * abstract boolean isEmpty()      // Returns true if this map contain no key-value pair
 * abstract V get(Object key)      // Returns the value of the specified key
 * abstract V put(K key, V value)  // Associates the specified value with the specified key
 * abstract boolean containsKey(Object key)     // Returns true if this map has specified key
 * abstract boolean containsValue(Object value) // Returns true if this map has specified value
 * abstract void clear()              // Removes all key-value pairs
 * abstract void V remove(object key) // Removes the specified key
 * ********************************************************************************
 * // java.util.Map(K,V)
 * abstract Set<K> keySet()         // Returns a set view of the keys
 * abstract Collection<V> values()  // Returns a collection view of the values
 * abstract Set<Map.Entry<K,V>> entrySet()  // Returns a set view of the key-value
 * ********************************************************************************
 * // Nested Class Map.Entry<K,V>
 * K getKey()     // Returns the key of this map entry
 * V getValue()   // Returns the value of this map entry
 * V setValue()   // Replaces the value of this map entry
 * ********************************************************
 */


    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("espresso", 1.1);
        map.put("latte", 2.2);
        map.put("cappuccino", 3.3);
        System.out.println(map);  //{espresso=1.1, cappuccino=3.3, latte=2.2}

        // Using .entrySet() which returns a Set<Map.Entry> to iterate through the map
        for (Map.Entry<String, Double> e : map.entrySet()) {
            e.setValue(e.getValue() + 10.0);  // modify value
            System.out.println(e.getKey() + ":" + e.getValue());
        }
        //espresso:11.1
        //cappuccino:13.3
        //latte:12.2

        // Using for-each loop on .keySet() which returns a Set to iterate through the map
        // .keySet() returns a Set of keys
        System.out.println(map.keySet());  //[espresso, cappuccino, latte]
        for (String key : map.keySet()) {
            System.out.println(key + "=" + map.get(key));
        }
        //espresso=11.1
        //cappuccino=13.3
        //latte=12.2

        // Using Iterator on .keySet() to iterate through the map
        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key + ":" + map.get(key));
        }
        //espresso:11.1
        //cappuccino:13.3
        //latte:12.2

        // .values() returns a Collection of values
        System.out.println(map.values());  //[21.1, 23.3, 22.2]
    }

}
