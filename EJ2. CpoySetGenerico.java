import java.util.HashSet;
import java.util.Set;

public class SetUtils {
    public static <T> Set<T> copySet(Set<T> originalSet) {
        Set<T> copiedSet = new HashSet<>(originalSet);
        return copiedSet;
    }

    public static void main(String[] args) {
        Set<String> originalSet = new HashSet<>();
        originalSet.add("apple");
        originalSet.add("banana");
        originalSet.add("orange");

        Set<String> copiedSet = copySet(originalSet);

        System.out.println("Original Set: " + originalSet);
        System.out.println("Copied Set: " + copiedSet);
    }
}
