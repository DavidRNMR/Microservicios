package com.optimissa.BookShelfApi.data.providers.impl.dto.error;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.optimissa.BookShelfApi.data.providers.impl.dto.DTO;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

/**
 * Custom serializer for Jackson. When an object is going to be serialized
 * into json, modifySerialize is called. If the object has the DTO annotation
 * and has been etiquette with an error, then the field error with the respective
 * etiquette is added to the json.
 */

@Service
public class DTOSerializerModifier extends BeanSerializerModifier {

    static final CustomDTOSerializer SERIALIZER_INSTANCE = new CustomDTOSerializer();

    @Override
    public JsonSerializer<?> modifySerializer(SerializationConfig config,
                                              BeanDescription beanDesc,
                                              JsonSerializer<?> serializer
    ) {
        return meetsConditions(beanDesc.getBeanClass())
                ? SERIALIZER_INSTANCE
                : serializer;
    }

    private boolean meetsConditions(Class<?> tClass) {
        return tClass.isAnnotationPresent(DTO.class);
    }

    static final class CustomDTOSerializer extends JsonSerializer<Object> {

        final WeakHashMap<Object, String> errorCache = new WeakHashMap<>();

        @SneakyThrows
        @Override
        public void serialize(Object value,
                              JsonGenerator gen,
                              SerializerProvider serializers
        ) throws IOException {

            gen.writeStartObject();
            for (Field field : value.getClass().getDeclaredFields()) {
                gen.writeObjectField(field.getName(), field.get(value));
            }

            String error;
            if ((error = errorCache.get(value)) != null)
                gen.writeStringField("error", error);

            gen.writeEndObject();
        }

    }

}