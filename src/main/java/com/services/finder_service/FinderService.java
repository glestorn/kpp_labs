package com.services.finder_service;

import com.hello.Finder;

public interface FinderService {
    boolean validate(char symbol, String row);
    Finder process(char symbol, String row);
}
