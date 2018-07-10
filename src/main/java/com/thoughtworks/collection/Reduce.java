package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().max((x, y) -> (x - y)).get();
    }

    public double getMinimum() {
        return arrayList.stream().min((x, y) -> (x - y)).get();
    }

    public double getAverage() {
        return arrayList.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    public double getOrderedMedian() {
        List<Integer> collect = arrayList.stream().sorted().collect(Collectors.toList());
        return (collect.size() % 2 == 0) ? (collect.get((collect.size()) / 2 - 1) + collect.get((collect.size()) / 2)) * 1.0 / 2 : collect.get((collect.size()) / 2);
    }

    public int getFirstEven() {
        return arrayList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()).get(0);
    }

    public int getIndexOfFirstEven() {
        AtomicInteger index = new AtomicInteger();
        AtomicBoolean first = new AtomicBoolean(true);
        arrayList.forEach(x -> {
            if (x % 2 == 0 && first.get()) {
                index.set(x);
                first.set(false);
            }
        });
        return arrayList.indexOf(index.get());
    }

    public boolean isEqual(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        throw new NotImplementedException();
    }

    public int getIndexOfLastOdd() {
        throw new NotImplementedException();
    }
}
