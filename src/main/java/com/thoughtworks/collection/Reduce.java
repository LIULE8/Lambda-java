package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return (collect.size() % 2 == 0) ? (collect.get((collect.size()) / 2 - 1) + collect.get((collect.size()) / 2)) * 1.0 / 2 : collect.get((collect.size()) / 2) * 1.0;
    }

    public int getFirstEven() {
        return arrayList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()).get(0);
    }

    public int getIndexOfFirstEven() {
        Integer integer = arrayList.stream().filter(x -> x % 2 == 0).findFirst().get();
        return arrayList.indexOf(integer);
    }

    public boolean isEqual(List<Integer> arrayList) {
        Boolean isEqual = false;
        if (arrayList.size() == this.arrayList.size()) {
            isEqual = IntStream.range(0, arrayList.size())
                    .allMatch(index -> this.arrayList.get(index).equals(arrayList.get(index)));
        }
        return isEqual;
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        int index = arrayList.size() / 2;
        if (arrayList.size() % 2 == 0) {
            return ((Integer) singleLink.getNode(index) + (Integer) singleLink.getNode(index + 1)) / 2.0;
        } else {
            return (Integer) singleLink.getNode(index + 1) * 1.0;
        }
    }

    public int getLastOdd() {
//        arrayList = arrayList.stream().filter(x -> x % 2 == 1).collect(Collectors.toList());
//        return arrayList.get(arrayList.size() - 1);
        return arrayList.stream().filter(x -> x % 2 == 1).reduce((first, second) -> second).get();
    }

    public int getIndexOfLastOdd() {
        Integer integer = arrayList.stream().filter(x -> x % 2 == 1).reduce((first, second) -> second).get();
        return arrayList.indexOf(integer);
    }
}
