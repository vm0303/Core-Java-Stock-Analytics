import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExamples {
    public static void main(String[] args) {
        Map<Integer, String> sectorLookUpMap =new HashMap<>();
        sectorLookUpMap.put(10, "Healthcare");
        sectorLookUpMap.put(11, "Communication services");
        sectorLookUpMap.put(12, "Technology");
        sectorLookUpMap.put(13, "Real Estate");

        System.out.println("The map contains " + sectorLookUpMap);

        System.out.println("The size of the map is " + sectorLookUpMap.size());

        //Retrieve values from a map using the key
        System.out.println("The value for the key 13 is " + sectorLookUpMap.get(13));

        //Duplicate keys are not allowed! But duplicate values are!
        sectorLookUpMap.put(20,"Technology");

        sectorLookUpMap.put(11, "Basic Materials");

        //Null key and values are allowed
        sectorLookUpMap.put(25, null);
        sectorLookUpMap.put(null, "Hello World");

        sectorLookUpMap.remove(null);
        sectorLookUpMap.remove(25);
        System.out.println("Does the Map contain a key 20? " + sectorLookUpMap.containsKey(20));
        System.out.println("Does the Map contain a value Technology? " + sectorLookUpMap.containsValue("Technology"));

        //Iteration of a map using for each and lambda function.
        sectorLookUpMap.forEach((key, value )-> {
            System.out.println("For the key " + key + " in the map, the value present is " + value);
        });

        //Iterate a map using keySet and lambda expression
        Set<Integer> sectorKeySet = sectorLookUpMap.keySet();
        sectorKeySet.forEach(key -> {
            System.out.println("Using the KeySet iteration, for the key " + key + " the value present is " +sectorLookUpMap.get(key) );
        });

    }
}
