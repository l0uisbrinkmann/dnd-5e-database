package com.louisbrinkmann.dnd5edatabase.deserializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.louisbrinkmann.dnd5edatabase.models.spells.Spell;
import com.louisbrinkmann.dnd5edatabase.models.spells.SpellCollection;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SpellCollectionDeserializer extends StdDeserializer<SpellCollection> {
    public SpellCollectionDeserializer() {
        this(null);
    }

    protected SpellCollectionDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public SpellCollection deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        List<Spell> spells = new ArrayList<>();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        JsonNode spellArray = node.get("spell");

        SpellDeserializer spellDeserializer = new SpellDeserializer();
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(Spell.class, spellDeserializer);
        objectMapper.registerModule(simpleModule);
        for(int i = 0; i < spellArray.size(); i++){
            try {
                Spell spell = objectMapper.readValue(spellArray.get(i).toString(), Spell.class);
                spells.add(spell);
            } catch (JacksonException e){
                throw new RuntimeException("Could not deserialize spell at index " + i, e);
            }
        }
        return new SpellCollection(spells);
    }
}
