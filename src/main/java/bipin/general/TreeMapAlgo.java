package bipin.general;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapAlgo {

    public static void main(String[] args) {
        Map<Float, String> descSortedMAP = new TreeMap<Float, String>(new Comparator<Float>() {
            @Override
            public int compare(Float o1, Float o2) {
                return o2.compareTo(o1);
            }
        });

        descSortedMAP.put(8f, "name8");
        descSortedMAP.put(5f, "name5");
        descSortedMAP.put(15f, "name15");
        descSortedMAP.put(35f, "name35");
        descSortedMAP.put(44f, "name44");
        descSortedMAP.put(7f, "name7");
        descSortedMAP.put(6f, "name6");

        for (Map.Entry<Float, String> mapData : descSortedMAP.entrySet()) {
            System.out.println("Key : " + mapData.getKey() + "\tValue : " + mapData.getValue());
        }

    }
}
