package com.louisbrinkmann.dnd5edatabase.jsonImport;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class SpellImporter implements JsonImporter {

    @Override
    public void importFile(File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<?,?> map = objectMapper.readValue(file, Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
