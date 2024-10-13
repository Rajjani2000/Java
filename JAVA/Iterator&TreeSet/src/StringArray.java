import java.util.Iterator;

public class StringArray implements Iterable<String> {
    private String[] values;

    public StringArray(String[] values) {
        this.values = values;
    }

    public Iterator<String> iterator() {
        return new ArrayIterator();
    }

    // Regular iterator
    private class ArrayIterator implements Iterator<String> {
        private int current = 0;

       
        public boolean hasNext() {
            return current < values.length;
        }


        public String next() {
            return values[current++];
        }
    }

    // LongStringIterator to filter strings with length >= 4
    public Iterator<String> longStringIterator() {
        return new LongStringIterator();
    }

    private class LongStringIterator implements Iterator<String> {
        private int current = 0;

        
        public boolean hasNext() {
            while (current < values.length && values[current].length() < 4) 
            {
                current++;
            }
            return current < values.length;
        }

       
        public String next() {
            return values[current++];
        }
    }

    public static void main(String[] args) {
        String[] data = {"one", "two", "three", "four", "five"};
        StringArray stringArray = new StringArray(data);

        // Traverse and print all strings
        for (String value : stringArray) {
            System.out.println(value);
        }

        // Traverse using LongStringIterator
        Iterator<String> longStringIt = stringArray.longStringIterator();
        while (longStringIt.hasNext()) {
            System.out.println("long string iterartors are = "+longStringIt.next());
        }
    }
}
