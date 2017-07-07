package exercise4;

import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * Exercise 3. Implement a HashMap from scratch. In order to pass all the tests
 * you need to implement all the methods defined below. The key-value pair will
 * be encapsulated in the MyHashMap.MyEntry object defined below.
 *
 * The buckets list in which each MyEntry object will be stored is stored in "buckets" object.
 * The hash function that you will use in order to store a pair in a specific bucket will be
 * the one presented earlier: (hashcode value) modulo (bucket array size)
 */
public class MyHashMap {

    private ArrayList<LinkedList<MyEntry>> buckets;

    private final int BUCKET_ARRAY_SIZE = 16;

    private int size;

    public MyHashMap() {

        // TODO Initialize buckets list
        buckets = new ArrayList<LinkedList<MyEntry>>(BUCKET_ARRAY_SIZE);
        for (int i = 0; i < BUCKET_ARRAY_SIZE; i++) buckets.add(i, new LinkedList<MyEntry>());
        size = 0;
    }

    public String get(String key) {
        // TODO
        if (key == null) return null;
        LinkedList<MyEntry> theBucket = buckets.get(Math.abs(key.hashCode()%BUCKET_ARRAY_SIZE));
        for (MyEntry entry : theBucket)
            if (entry.getKey().equals(key)) return entry.getValue();
        return null;
    }

    public void put(String key, String value) {
        // TODO
        if(key != null) {
            int location = Math.abs(key.hashCode() % BUCKET_ARRAY_SIZE);
            LinkedList<MyEntry> theList = buckets.get(location);
            for (int i = 0; i < theList.size(); i++)
                if (value.equals(theList.get(i).getValue())) return;
            theList.add(new MyEntry(key, value));
            size++;
        }
        else {
            LinkedList<MyEntry> theList = buckets.get(0);
            for (int i = 0; i < theList.size(); i++)
                if (theList.get(i).getKey() == null) return;
            theList.add(new MyEntry(null, value));
            size++;
        }
    }

    public Set<String> keySet() {
        Set<String> theKeySet = new HashSet<String>();
        for(int i = 0; i < BUCKET_ARRAY_SIZE; i++)
            for (MyEntry j : buckets.get(i)) theKeySet.add(j.getKey());
        return theKeySet;
    }

    public Collection<String> values() {
        // TODO
        Set<String> theValueSet = new HashSet<String>();
        for(int i = 0; i < BUCKET_ARRAY_SIZE; i++)
            for (MyEntry j : buckets.get(i)) theValueSet.add(j.getValue());
        return theValueSet;
    }

    public String remove(String key) {
        // TODO Returns the value associated with the key removed from the map or null if the key wasn't found
        LinkedList<MyEntry> theBucket = buckets.get(Math.abs(key.hashCode()%BUCKET_ARRAY_SIZE));
        for (MyEntry entry : theBucket)
            if (entry.getKey().equals(key)){
                String toReturn = entry.getValue();
                theBucket.remove(entry);
                size--;
                return toReturn;
            }
        return null;
    }

    public boolean containsKey(String key) {
        LinkedList<MyEntry> theBucket = buckets.get(Math.abs(key.hashCode()%BUCKET_ARRAY_SIZE));
        for (MyEntry entry : theBucket)
            if (entry.getKey().equals(key)) return true;
        return false;
    }

    public boolean containsValue(String value) {
        for (LinkedList<MyEntry> theBucket : buckets)
            for (MyEntry entry : theBucket)
                if (entry.getValue().equals(value)) return true;
        return false;
    }

    public int size() {
        // Return the number of the Entry objects stored in all the buckets
        return size;
    }

    public void clear() {
        //  Remove all the Entry objects from the bucket list
        for (String key : this.keySet()) remove(key);
    }

    public Set<MyEntry> entrySet() {
        // TODO Return a Set containing all the Entry objects
        Set<MyEntry> theReturnedSet = new HashSet<MyEntry>();
        Set<String> theKeySet = this.keySet();

        if (theKeySet.size() == 0) return null;

        for(String key : theKeySet) theReturnedSet.add(new MyEntry(key, this.get(key)));
        return theReturnedSet;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static class MyEntry {
        private String key;
        private String value;

        public MyEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
