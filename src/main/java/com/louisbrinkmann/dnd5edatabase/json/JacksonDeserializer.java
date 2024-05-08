package com.louisbrinkmann.dnd5edatabase.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonDeserializer<T> {
    public T deserialize(File jsonFile, Class<T> clazz) throws IOException {
        return new ObjectMapper().readValue(jsonFile, clazz);
    }
}