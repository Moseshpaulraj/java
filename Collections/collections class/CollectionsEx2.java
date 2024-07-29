import java.util.*;

public class CollectionsEx2 {
    public static void main(String[] args) {
        List<String> mutableList = new ArrayList<>();
        mutableList.add("Moses");
        mutableList.add("Sakthi");
        
        List<String> immutableList = Collections.unmodifiableList(mutableList);
        
        immutableList.add("RAJ");
	// immutableList.set(0,"vel");
        
        System.out.println("Immutable List: " + immutableList);
    }
}