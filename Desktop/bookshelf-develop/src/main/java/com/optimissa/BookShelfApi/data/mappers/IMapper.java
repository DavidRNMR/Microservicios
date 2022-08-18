package com.optimissa.BookShelfApi.data.mappers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Convenient class holding all the operations
 * to map an entity to its respective dto.
 *
 * @param <T> Represents the entity
 * @param <R> Represents the dto of this entity
 */
public interface IMapper<T, R> {

    R mapToDto(T t);

    T mapToEntity(R r);

    default List<R> mapListToDtoList(Collection<T> list) {
        return list.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    default List<T> mapListToEntityList(Collection<R> list) {
        return list.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }

}
