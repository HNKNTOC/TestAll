package my.test.CollectionsTest;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Ревлизация кеша RUL черз LinkedHashMap.
 */
public class MyRULCache<K, V> extends LinkedHashMap<K, V> {

    private double initialCapacity;

    public MyRULCache(int initialCapacity) {
        super(initialCapacity + 1, 1.1f , true);
        this.initialCapacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size()> initialCapacity;
    }
}
