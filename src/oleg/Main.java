package oleg;


import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;


    public class Main {
        public static void main(String[] args) {
            Comparator<String>
                    comparator = (first, second) -> { return first.compareTo(second);  };

            Map<String, String>
                    treeMap = new TreeMap<String, String>(comparator);
            treeMap.put("COM1", "\\Device\\Serial0");
            treeMap.put("COM2", "\\Device\\Serial1");
            treeMap.put("COM8", "\\Device\\Nmserial0");
            treeMap.put("COM9", "\\Device\\Nmserial1");
            treeMap.put("COM10", "\\Device\\Nmserial2");
            treeMap.put("COM11", "\\Device\\Nmserial3");
        }
    }

