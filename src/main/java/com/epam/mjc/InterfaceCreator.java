package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String s : x) {
                if (!Character.isUpperCase(s.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> list = new ArrayList<>();
            for (int i : x) {
                if (i % 2 == 0) {
                    list.add(i);
                }
            }
            x.addAll(list);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> filtered = new ArrayList<>();
            for (String s : values) {
                String[] words = s.split(" ");
                int len = words.length;
                if (Character.isUpperCase(s.charAt(0)) && s.charAt(s.length()-1) == '.' && len > 3) {
                    filtered.add(s);
                }
            }
            return filtered;
        };

    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            int len;
            Map<String, Integer> map = new HashMap<>();
            for (String s : x) {
                len = s.length();
                map.put(s, len);
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> list = new ArrayList<>();
            list.addAll(list1);
            list.addAll(list2);
            return list;
        };
    }
}
