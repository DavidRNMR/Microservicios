package com.optimissa.BookShelfApi.data.providers.impl.dto.error;

import com.optimissa.BookShelfApi.data.providers.impl.dto.DTO;


/**
 * Util class to instantiate a DTO class and mark it with and error message
 * to later inject the error field when that dto is serialized.
 */

public class ErrorFactoryDTO<T> {

    private static final String NO_DTO_ANNOTATION_FOUND = "the class %s must implement DTO annotation";

    public static <T> ErrorFactoryDTO<T> of (Class<T> clazz) {
        if (!clazz.isAnnotationPresent(DTO.class))
            throw new NoDtoAnnonationFound(String.format(NO_DTO_ANNOTATION_FOUND, clazz.getSimpleName()));

        return new ErrorFactoryDTO<>(clazz);
    }

    private final Class<T> clazz;

    private ErrorFactoryDTO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T error(Exception e) {
        return error(e.getMessage());
    }

    public T error(String err) {
        try {
            T instance = clazz.newInstance();
            DTOSerializerModifier.SERIALIZER_INSTANCE.errorCache.put(instance, err);
            return instance;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


}
