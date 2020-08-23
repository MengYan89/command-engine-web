package net.irregularhaguruma.engine.http.impl.st;

import java.util.HashMap;
import java.util.Iterator;

public class StRequestMap<K,V> extends HashMap<K,V> {

    public String toString() {
        Iterator<Entry<K,V>> i = entrySet().iterator();
        if (! i.hasNext())
            return "";
        StringBuilder sb = new StringBuilder();
        for (;;) {
            Entry<K,V> e = i.next();
            K key = e.getKey();
            V value = e.getValue();
            sb.append(key   == this ? "(this Map)" : key);
            sb.append('=');
            sb.append(value == this ? "(this Map)" : value);
            if (! i.hasNext())
                return sb.toString();
            sb.append("&");
        }
    }
}
