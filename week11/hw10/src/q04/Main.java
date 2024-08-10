package q04;


import java.util.ArrayList;
import java.util.List;

class MyHashMap<K, V> {
    private class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 16;
    private List<Entry<K, V>> table;

    public MyHashMap() {
        table = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            table.add(null);
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> newEntry = new Entry<>(key, value);
        Entry<K, V> existingEntry = table.get(index);

        if (existingEntry == null) {
            table.set(index, newEntry);
        } else {
            Entry<K, V> prev = null;
            while (existingEntry != null) {
                if (existingEntry.key.equals(key)) {
                    if (prev == null) {
                        newEntry.next = existingEntry.next;
                        table.set(index, newEntry);
                    } else {
                        newEntry.next = existingEntry.next;
                        prev.next = newEntry;
                    }
                    return;
                }
                prev = existingEntry;
                existingEntry = existingEntry.next;
            }
            prev.next = newEntry;
        }
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        Entry<K, V> entry = table.get(index);

        while (entry != null) {
            if (entry.key.equals(key)) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    public boolean isEmpty() {
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                return false;
            }
        }
        return true;
    }

    public List<V> values() {
        List<V> valuesList = new ArrayList<>();
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                valuesList.add(entry.value);
                entry = entry.next;
            }
        }
        return valuesList;
    }

    public void replace(K key, V value) {
        int index = hash(key);
        Entry<K, V> entry = table.get(index);

        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();

        // Test put method
        myHashMap.put("One", 1);
        myHashMap.put("Two", 2);
        myHashMap.put("Three", 3);

        // Test containsKey method
        System.out.println("Contains 'One': " + myHashMap.containsKey("One"));
        System.out.println("Contains 'Four': " + myHashMap.containsKey("Four"));

        // Test isEmpty method
        System.out.println("Is empty: " + myHashMap.isEmpty());

        // Test values method
        System.out.println("Values: " + myHashMap.values());

        // Test replace method
        myHashMap.replace("Two", 22);
        System.out.println("Values after replace: " + myHashMap.values());
    }
}


