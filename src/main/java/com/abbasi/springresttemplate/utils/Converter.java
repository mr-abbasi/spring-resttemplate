package com.abbasi.springresttemplate.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Converter {
    public static <T> List<T> arrayToList(T[] array){
            return Arrays.asList(Objects.requireNonNull(array));
    }
}
