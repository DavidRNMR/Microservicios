package com.optimissa.BookShelfApi.core.controller.util;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HateoasUtils {

    private HateoasUtils() {
        throw new IllegalStateException("Cannot instantiate this class");
    }

    public static <T> CollectionModel<EntityModel<T>> wrapList(List<T> list, Function<T, EntityModel<T>> mapper) {
        List<EntityModel<T>> mappedList = list.stream()
                .map(mapper)
                .collect(Collectors.toList());

        return CollectionModel.of(mappedList);
    }

}
