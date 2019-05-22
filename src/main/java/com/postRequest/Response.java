package com.postRequest;

import com.hello.Finder;

import java.util.List;

public class Response {
    public List<Finder> responds;
    public Statistic stats;

    public Response(List<Finder> responds, Statistic stats) {
        this.responds = responds;
        this.stats = stats;
    }
}
