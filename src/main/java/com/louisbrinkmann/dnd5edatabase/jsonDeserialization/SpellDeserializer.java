package com.louisbrinkmann.dnd5edatabase.jsonDeserialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.louisbrinkmann.dnd5edatabase.models.*;
import com.louisbrinkmann.dnd5edatabase.models.spells.Components;
import com.louisbrinkmann.dnd5edatabase.models.spells.SchoolOfMagic;
import com.louisbrinkmann.dnd5edatabase.models.spells.Spell;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpellDeserializer extends StdDeserializer<Spell> {

    protected SpellDeserializer() {
        this(null);
    }

    private SpellDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Spell deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode rootNode = jsonParser.getCodec().readTree(jsonParser);

        String name = rootNode.get("name").asText();
        Integer level = rootNode.get("level").asInt();

        return Spell.builder()
                .name(name)
                .source(getSource(rootNode))
                .level(level)
                .school(getSchoolOfMagic(rootNode))
                .ritual(getRitual(rootNode))
                .castingTime(getCastingTime(rootNode))
                .castingRange(getCastingRange(rootNode))
                .components(getComponents(rootNode))
                .effectDuration(getEffectDuration(rootNode))
                .concentration(getConcentration(rootNode))
                .entries(getEntries(rootNode))
                .damageTypes(getDamageTypes(rootNode))
                .savingThrow(getSavingThrow(rootNode))
                .build();
    }

    private Source getSource(JsonNode node) {
        if(node.has("page")){
            return new Source(new Book(node.get("source").asText()), node.get("page").asInt());
        }
        return new Source(new Book(node.get("source").asText()), null);
    }

    private SchoolOfMagic getSchoolOfMagic(JsonNode node) {
        return new SchoolOfMagic(node.get("school").asText());
    }

    private boolean getRitual(JsonNode rootNode) {
        return rootNode.has("meta") && rootNode.get("meta").has("ritual") && rootNode.get("meta").get("ritual").asBoolean();
    }

    private Duration getCastingTime(JsonNode node) {
        ArrayNode timeArray = (ArrayNode) node.get("time");
        JsonNode time = timeArray.get(0);
        return new Duration(new DurationType(time.get("unit").asText()), time.get("number").asInt());
    }

    private Range getCastingRange(JsonNode node) {
        JsonNode range = node.get("range");
        if(range.has("distance")){
            JsonNode distance = range.get("distance");
            if(distance.has("amount")){
                return new Range(range.get("type").asText(), new Distance(distance.get("type").asText(), distance.get("amount").asInt()));
            }
            return new Range(range.get("type").asText(), new Distance(distance.get("type").asText(), null));
        }
        return new Range(range.get("type").asText(), null);
    }

    private Components getComponents(JsonNode node) {
        JsonNode components = node.get("components");
        boolean verbal = components.has("v") && components.get("v").asBoolean();
        boolean somatic = components.has("s") && components.get("s").asBoolean();
        if (components.has("m")) {
            return new Components(verbal, somatic, components.get("m").asText());
        }
        return new Components(verbal, somatic, null);
    }

    private Duration getEffectDuration(JsonNode rootNode) {
        ArrayNode durationArray = (ArrayNode) rootNode.get("duration");
        JsonNode duration = durationArray.get(0);
        if (duration.has("duration")) {
            duration = duration.get("duration");
        }
        if (duration.has("amount")) {
            return new Duration(new DurationType(duration.get("type").asText()), duration.get("amount").asInt());
        }
        return new Duration(new DurationType(duration.get("type").asText()), null);
    }

    private boolean getConcentration(JsonNode rootNode) {
        ArrayNode durationArray = (ArrayNode) rootNode.get("duration");
        JsonNode duration = durationArray.get(0);
        return duration.has("concentration") && duration.get("concentration").asBoolean();
    }

    private List<String> getEntries(JsonNode rootNode) {
        List<String> entryList = new ArrayList<>();
        ArrayNode entries = (ArrayNode) rootNode.get("entries");
        Iterator<JsonNode> entryIterator = entries.elements();
        while (entryIterator.hasNext()) {
            JsonNode entry = entryIterator.next();
            if (entry.has("items")) {
                ObjectMapper objectMapper = new ObjectMapper();
                ObjectNode entryWithArray = objectMapper.createObjectNode();
                entryWithArray.set("entries", entry.get("items"));
                entryList.addAll(getEntries(entryWithArray));
            } else {
                entryList.add(entry.asText());
            }
        }
        return entryList;
    }

    private List<DamageType> getDamageTypes(JsonNode rootNode) {
        List<DamageType> damageTypes = new ArrayList<>();
        if (rootNode.has("damageInflict")) {
            ArrayNode damageTypesArray = (ArrayNode) rootNode.get("damageInflict");
            Iterator<JsonNode> damageTypesIterator = damageTypesArray.elements();
            while(damageTypesIterator.hasNext()){
                JsonNode damageType = damageTypesIterator.next();
                damageTypes.add(new DamageType(damageType.asText()));
            }
        }
        return damageTypes;
    }

    private SavingThrow getSavingThrow(JsonNode rootNode) {
        if (rootNode.has("savingThrow")) {
            return new SavingThrow(rootNode.get("savingThrow").asText());
        }
        return null;
    }
}
