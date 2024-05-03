package com.louisbrinkmann.dnd5edatabase.jsonImport;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.louisbrinkmann.dnd5edatabase.models.Spell;

import java.io.File;
import java.io.IOException;

public class SpellImporter {

    public Spell[] importFile(File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(file, Spell[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }}
