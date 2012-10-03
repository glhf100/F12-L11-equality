package beforeclass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class BreakingTheRep {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        System.out.println("list = " + list);
        
        Set<List<String>> set = new HashSet<List<String>>();
        set.add(list);
        System.out.println("set = " + set);
        
        System.out.println("set.contains(list) -> " + set.contains(list));
        System.out.println();
        
        list.add("goodbye");
        System.out.println("list = " + list);
        System.out.println("set = " + set);

        System.out.println("set.contains(list) -> " + set.contains(list));
        for (List<String> l : set) { 
            System.out.println("for l in set, set.contains(l) -> " + set.contains(l)); 
        }
    }
}
