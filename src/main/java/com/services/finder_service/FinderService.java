package com.services.finder_service;

import com.hello.Finder;
import com.hello.Values;
import com.postRequest.Statistic;
import com.postRequest.ValuesList;

import java.util.List;

public interface FinderService {
    boolean validate(char symbol, String row);
    Finder process(char symbol, String row);
    List<Finder> processList(ValuesList list);
    Statistic collectStatistic(ValuesList list);
    String findPopularRequest(List<Values> requests);
}
