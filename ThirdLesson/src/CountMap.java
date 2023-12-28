import java.util.Comparator;
import java.util.List;
import java.util.Map;
@SuppressWarnings("ALL")
public interface CountMap<T> {
    void add(T key);

    int getCount(T key);

    //current count
    int remove(T key);

    int size();

    void addAll(CountMap<T> source);

    Map<T, Integer> toMap();

    void toMap(Map<T, Integer> destination);


    public static void main(String[] args) {
        CountMap<Integer> map= new CountMapImpl<>();
        CountMap<Integer> map2 = new CountMapImpl<>();


        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        map2.add(10);
        map2.add(10);
        map2.add(5);
        map2.add(6);
        map2.add(5);
        map2.add(10);

        map.addAll(map2);

        int count = map.getCount(5); // 2
//        int count = map.getCount(6); // 1
//        int count = map.getCount(10); //

        System.out.println(count);


//        Вторая часть
        CollectionUtils<Integer> coll = new CollectionUtils<>();
        List<Integer> list = coll.newArrayList();
        List<Integer> list2 = coll.newArrayList();

        coll.add(list, 25);
        coll.add(list, 26);
        coll.add(list, 4);
        coll.add(list, 8);

        coll.addAll(list, list2);

        coll.add(list, 4);
        coll.add(list, 15);

        coll.add(list2, 2);
        coll.add(list2, 1);

        System.out.println(list);
        System.out.println(list2);

//        coll.removeAll(list2,list);

        System.out.println(list);
        System.out.println(list2);

//        System.out.println(coll.containsAll(list, list2));
//        System.out.println(coll.containsAny(list, list2));


        Comparator comp = Comparator.naturalOrder();
        System.out.println(coll.range(list2,1, 15, comp));
        System.out.println(coll.range(list2,1, 15));



    }
}