package com.louisbrinkmann.dnd5edatabase.jsonDeserialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.louisbrinkmann.dnd5edatabase.models.spells.Spell;
import com.louisbrinkmann.dnd5edatabase.models.spells.Spells;

import java.io.IOException;
import java.util.List;

public class SpellsDeserializer  extends StdDeserializer<Spells> {
    public SpellsDeserializer(){
        this(null);
    }

    public SpellsDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Spells deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode rootNode = jsonParser.getCodec().readTree(jsonParser);
        ArrayNode spells = (ArrayNode) rootNode.get("spell");
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Spell.class, new SpellDeserializer());
        mapper.registerModule(module);

        List<Spell> spellList = mapper.readValue(spells.toString(), new TypeReference<>() {});
        return new Spells(spellList);
    }
}
