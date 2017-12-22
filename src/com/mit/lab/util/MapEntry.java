package com.mit.lab.util;

import com.mit.lab.coms.Result;

/**
 * <p>Title: Blueprint</p>
 * <p>Description: com.mit.lab.util.MapEntry</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: Kewill Co., Ltd</p>
 *
 * @author <chao.deng@kewill.com>
 * @version 1.0
 * @date 12/16/2017
 */
public class MapEntry<K, V> implements Comparable<MapEntry<K, V>> {

    public final K key;
    public final Result<V> value;

    private MapEntry(K key, Result<V> value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("MapEntry(%s, %s)", key, value);
    }

    @Override
    public int compareTo(MapEntry<K, V> that) {
        int thisHashCode = this.hashCode();
        int thatHashCode = that.hashCode();
        return Integer.compare(thisHashCode, thatHashCode);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof MapEntry && this.key.equals(((MapEntry) o).key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    public static <K, V> MapEntry<K, V> mapEntry(K key, V value) {
        return new MapEntry<>(key, Result.success(value));
    }

    public static <K, V> MapEntry<K, V> mapEntry(K key) {
        return new MapEntry<>(key, Result.empty());
    }
}
