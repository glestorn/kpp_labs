package com.services.finder_service;

import com.hello.Finder;
import com.postRequest.Statistic;
import com.postRequest.ValuesList;
import com.services.counter_service.Counter;
import com.cache.Cache;
import com.hello.Values;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


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

    @Override
    public List<Finder> processList(ValuesList valuesList) {
        List<Finder> list = valuesList.getValues()
                .stream()
                .filter(element ->
                    element.getSymbol() != '\0' && element.getRow() != null
                )
                .map(element -> {
                    int content = element.getRow().length() - element.getRow().replace("" + element.getSymbol(), "").length();
                    return new Finder(String.valueOf(content), element.getSymbol());
                })
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public Statistic collectStatistic(ValuesList values) {
        List<Values> requests = values.getValues();
        Statistic stats = new Statistic();
        stats.setRequestAmount(requests.size());

        requests = requests.stream().filter(element -> element.getSymbol() != '\0' && element.getRow() != null).collect(Collectors.toList());
        stats.setInvalidInputs(stats.getRequestAmount() - requests.size());
        stats.setLongestRequest(requests.stream().max(Comparator.comparing(Values::getRow)).get().getRow());
        stats.setShortestRequest(requests.stream().min(Comparator.comparing(Values::getRow)).get().getRow());
        stats.setMostPopularRequest(findPopularRequest(requests));

        return stats;
    }

    public String findPopularRequest(List<Values> requests) {

        if (requests.isEmpty()) return null;

        HashMap<String, Integer> popularityMap = new HashMap<>();
        requests.forEach( a -> {
            if (popularityMap.containsKey(a.getRow())) {
                popularityMap.put(a.getRow(), popularityMap.get(a.getRow()) + 1);
            } else popularityMap.put(a.getRow(), 1);
        });

        String popularString = popularityMap.entrySet()
                .stream()
                .max(Comparator.comparingInt(value ->
                        value.getValue()
                )).get().getKey();

        return popularString;
    }
}
