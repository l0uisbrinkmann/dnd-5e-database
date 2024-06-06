package com.louisbrinkmann.dnd5edatabase.jsonReaders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.louisbrinkmann.dnd5edatabase.jsonDeserializers.SpellCollectionDeserializer;
import com.louisbrinkmann.dnd5edatabase.models.spells.SpellCollection;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
public class SpellCollectionReader {

    public static List<SpellCollection> readSpellDirectory(File targetDirectory){
        List<SpellCollection> spellCollections = new ArrayList<>();
        List<File> files = Arrays.stream(Objects.requireNonNull(targetDirectory.listFiles()))
                .filter(file -> !file.isDirectory())
                .filter(file -> file.getName().endsWith(".json"))
                .toList();
        for(File f : files){
            try {
                SpellCollection spellCollection = readSpellFile(f);
                spellCollections.add(spellCollection);
            } catch (IOException e) {
                log.warn("Could not read file {}", f.getAbsolutePath());
            }
        }
        return spellCollections;
    }

    public static SpellCollection readSpellFile(File targetFile) throws IOException {
        ObjectMapper objectMapper = prepareObjectMapper();
        if(!targetFile.getName().endsWith(".json")){
            throw new IOException("Could not read file " + targetFile.getAbsolutePath() + " because it is not a json file.");
        }
        return objectMapper.readValue(targetFile, SpellCollection.class);
    }

    private static ObjectMapper prepareObjectMapper() {
        SpellCollectionDeserializer spellCollectionDeserializer = new SpellCollectionDeserializer();
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(SpellCollection.class, spellCollectionDeserializer);
        objectMapper.registerModule(simpleModule);
        return objectMapper;
    }
}
