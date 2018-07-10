package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if (right > left) {
            return IntStream.range(left, right + 1).boxed().collect(Collectors.toList());
        } else {
            List<Integer> collect = IntStream.range(right, left + 1).boxed().collect(Collectors.toList());
            Collections.reverse(collect);
            return collect;
        }
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if (right > left) {
            return IntStream.range(left, right + 1).boxed().collect(Collectors.toList()).stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        } else {
            List<Integer> collect = IntStream.range(right, left + 1).boxed().collect(Collectors.toList()).stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
            Collections.reverse(collect);
            return collect;
        }
    }

    public List<Integer> popEvenElments(int[] array) {
        String str = Arrays.toString(array);
        String[] s = str.substring(1, str.lastIndexOf("]")).split(",");
        List<String> strings = Arrays.asList(s);
        return strings.stream().map(x -> Integer.parseInt(x.trim())).filter(x -> x % 2 == 0).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        throw new NotImplementedException();
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        throw new NotImplementedException();
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        throw new NotImplementedException();
    }
}
