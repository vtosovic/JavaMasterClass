package dev.lpa.util;

import dev.lpa.model.Student;

import java.util.ArrayList;
import java.util.List;

// MULTIPLE UPPER BOUNDS
public class QueryList <T extends Student & QueryItem> {
    private List<T> items;

    public QueryList(List<T> items) {
        this.items = items;
    }

    // classes type parameter cannot be used in a static class
    // so we make a generic, with upper bound
    // T becomes totally different parameter from the T in the class itself
    // we will change it in S
    public static <S extends QueryItem> List<S> getMatches(List<S> items,
                                                           String field, String value) {
        List<S> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }

    public List<T> getMatches(String field, String value) {
        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}
