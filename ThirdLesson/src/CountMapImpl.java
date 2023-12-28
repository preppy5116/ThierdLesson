import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T>{
    private final Map<T, Integer> map = new HashMap<>();
    @Override
    public void add(T key) {
        map.put(key,map.getOrDefault(key, 0)+1);
    }

    @Override
    public int getCount(T key) {
        return map.get(key);
    }

    @Override
    public int remove(T key) {
        int count = this.getCount(key);
        map.remove(key);
        return count;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        Map <T, Integer> sourceMap = source.toMap();
        for(Map.Entry<T, Integer> entry:sourceMap.entrySet()) {
            T key  = entry.getKey();
            int count = entry.getValue();
            int current = map.getOrDefault(key, 0);
            map.put(key, current + count);
        }
        System.out.println(map);

    }

    @Override
    public Map<T, Integer> toMap() {
        return new HashMap<>(map);
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.clear();
        destination.putAll(map);

    }
}
