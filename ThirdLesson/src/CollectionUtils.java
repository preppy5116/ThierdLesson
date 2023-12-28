import java.util.*;

@SuppressWarnings("ALL")
public class CollectionUtils<T extends Comparable<T>>  {

     private T min = null;
     private T max = null ;
     private T value = null ;
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List<T> newArrayList() {
        return new ArrayList<T>();

    }
    public static<T> void add(List<? super T> source, T value) {
        source.add(value);
    }

    public static<T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static<T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
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


