package com.thoughtworks.collection;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if (right > left) {
            return IntStream.range(left, right + 1).boxed().collect(Collectors.toList());
        } else {
            return IntStream.range(right, left + 1).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        }
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if (right > left) {
            return IntStream.range(left, right + 1).boxed().collect(Collectors.toList()).stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        } else {
            return IntStream.range(right, left + 1).boxed().filter(x -> x % 2 == 0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        }
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).boxed().filter(x -> x % 2 == 0).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> secondList = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        return Arrays.stream(firstArray).boxed().filter(secondList::contains).collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList = Arrays.stream(firstArray).collect(Collectors.toList());
        List<Integer> list = Arrays.stream(secondArray).filter(x -> !firstList.contains(x)).collect(Collectors.toList());
        firstList.addAll(list);
        return firstList;
    }
}
