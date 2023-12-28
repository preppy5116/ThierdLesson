import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
public class CollectionUtils<T extends Comparable<T>>  {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static<T> int indexOf(List<T> source, T value) {
        return source.indexOf(value);
    }
    public static<T> List<T> limit(List<T> source, int size) {
        return source.stream().limit(size).collect(Collectors.toList());
    }
    public static<T> void add(List<? super T> source, T value) {
        source.add(value);
    }

    public static<T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static<T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return new HashSet<>(c1).containsAll(c2);
    }

    public static<T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        boolean isContain = false;
        for(T value: c1){
            if (c2.contains(value)) {
                isContain = true;
                break;
            }
        }
        return isContain;
    }

    public   static<T extends Comparable<T>> List<T> range(List<? extends T> list, T min, T max) {
        List <T> newList = newArrayList();
        for(T value:list) {
         if(min.compareTo(value) - value.compareTo(max) >= 0)
            newList.add(value);
                 }
        newList.sort(Comparator.naturalOrder());
        return newList;
    }

    public  static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator ) {
        List <T> newList = newArrayList();
        for (T value: list) {
                    if(comparator.compare(value, min) >= 0 && (comparator.compare(value, max) <= 0))
            {
                newList.add(value);
            }
        }
        newList.sort(comparator);
        return newList;
    }
}


