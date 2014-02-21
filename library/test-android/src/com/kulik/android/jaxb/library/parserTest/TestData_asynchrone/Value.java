package com.kulik.android.jaxb.library.parserTest.TestData_asynchrone;

import java.util.List;

public interface Value<T> {
    public T getValue();

    public String getName();

    public interface Finder<T> {
        public int find(List<? extends Value<T>> list, Value<T> value);
    }

    public static Finder DEFAULT_FINDER = new Finder() {
        @Override
        public int find(List list, Value value) {
            return list.lastIndexOf(value);
        }
    };
}