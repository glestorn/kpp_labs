package com.services.finder_service;

import com.hello.Finder;
import com.services.counter_service.Counter;
import com.cache.Cache;
import com.hello.Values;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinderServiceReal implements FinderService {

    private static final Logger logger = Logger.getLogger(FinderServiceReal.class);
    private Counter counter;
    private Cache cache;

    @Autowired
    public FinderServiceReal(Cache cache, Counter counter) {

        this.cache = cache;
        this.counter = counter;
    }

    @Override
    public boolean validate(char symbol, String row)  {

        if (row.trim().length() == 0)
            return false;
        if ((int)symbol < 32)
            return false;

        return true;
    }

    @Override
    public synchronized Finder process(char symbol, String row) {

        counter.increment();
        logger.debug("This service was used " + counter.getCounter());
        System.out.println(counter.getCounter());
        Values values = new Values(row, symbol);

        if (cache.containKey(values))
            return cache.get(values);

        int count = 0;
        for (int i = 0; i < row.length(); i++) {
            if (symbol == row.charAt(i))
                count++;
        }

        Finder finder = new Finder(String.valueOf(count), symbol);

        cache.put(values, finder);

        return finder;
    }
}
