package com.cache;

import com.hello.Finder;
import com.hello.Values;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Component
public class Cache {

    private HashMap<Values, Finder> map;

    public Cache() { map = new HashMap<>(); }

    public void put(Values key, Finder finder) { map.put(key, finder); }

    public Finder get(Values key) { return map.get(key); }

    public boolean containKey(Values key) {
        if (map.size() == 0)
            return false;

        Set<Values> keys = map.keySet();
        return keys.contains(key);
    }
}
