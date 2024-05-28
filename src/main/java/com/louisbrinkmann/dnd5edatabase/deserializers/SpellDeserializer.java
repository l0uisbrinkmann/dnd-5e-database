package com.louisbrinkmann.dnd5edatabase.deserializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.louisbrinkmann.dnd5edatabase.models.*;

import java.io.IOException;

public class SpellDeserializer extends StdDeserializer<Spell> {

    public SpellDeserializer() {
        this(null);
    }

    protected SpellDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Spell deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Spell.SpellBuilder spellBuilder = Spell.builder();

        spellBuilder
                .name(node.get("name").asText())
                .level(node.get("level").asInt())
                .schoolOfMagic(SchoolOfMagic.fromAbbreviation(node.get("school").asText().charAt(0)))
                .castingTime(node.get("time").get(0).get("number").asText() + " " + node.get("time").get(0).get("unit").asText())
                .range(determineRange(node.get("range")))
                .duration(determineDuration(node.get("duration").get(0)))
                .description(determineDescription(node.get("entries")))
                .source(new Source(node.get("source").asText(), node.get("page").asInt()));

        if (node.has("components")) {
            JsonNode components = node.get("components");
            if (components.has("v")) {
                spellBuilder.verbal(components.get("v").asBoolean());
            }
            if (components.has("s")) {
                spellBuilder.somatic(components.get("s").asBoolean());
            }
            if (components.has("m")) {
                spellBuilder.material(components.get("m").asText());
            }
        }

        if(node.get("duration").get(0).has("concentration")){
            spellBuilder.concentration(node.get("duration").get(0).get("concentration").asBoolean());
        }

        return spellBuilder.build();
    }

    String determineRange(JsonNode node) {
        String range = "";
        RangeType rangeType = RangeType.valueOf(node.get("type").asText().toUpperCase());
        if (rangeType.name().equalsIgnoreCase("special")) return "special";
        DistanceType distanceType = DistanceType.valueOf(node.get("distance").get("type").asText().toUpperCase());
        Integer amount = null;
        if (node.get("distance").has("amount")) {
            amount = node.get("distance").get("amount").asInt();
        }
        if (!rangeType.name().equalsIgnoreCase("point")) {
            if (amount != null) {
                range = "Self (" + amount + " " + distanceType.getSingular() + " " + rangeType + ")";
            }
        } else {
            if (amount != null) {
                if(amount == 1) {
                    range = amount + " " + distanceType.getSingular();
                } else {
                    range = amount + " " + distanceType.name().toLowerCase();
                }
            } else {
                range = distanceType.name().toLowerCase();
            }
        }
        return range;
    }

    String determineDuration(JsonNode node) {
        String duration = "";
        FirstLevelDurationType firstLevelDurationType = FirstLevelDurationType.valueOf(node.get("type").asText().toUpperCase());
        if (!firstLevelDurationType.name().equalsIgnoreCase("timed")) {
            switch (firstLevelDurationType.name().toLowerCase()) {
                case "instant":
                    return "instantaneous";
                case "special":
                    return "special";
                case "permanent":
                    StringBuilder endConditions = new StringBuilder("Until " + node.get("ends").get(0));
                    for (int i = 1; i < node.get("ends").size(); i++) {
                        EndCondition condition = EndCondition.valueOf(node.get("ends").get(i).asText().toUpperCase());
                        if (i == node.get("ends").size() - 1) {
                            endConditions.append(" or ").append(node.get("ends").get(i));
                        } else {
                            endConditions.append(", ").append(node.get("ends").get(i));
                        }
                    }
                    duration = endConditions.toString();
                    break;
            }
        } else {
            SecondLevelDurationType secondLevelDurationType = SecondLevelDurationType.valueOf(node.get("duration").get("type").asText().toUpperCase());
            duration += node.get("duration").get("amount").asText();
            if (node.get("duration").get("amount").asInt() == 1) {
                duration += secondLevelDurationType.name().toLowerCase();
            } else {
                duration += secondLevelDurationType.getPlural();
            }
        }
        return duration;
    }

    String determineDescription(JsonNode node) {
        StringBuilder description = new StringBuilder();
        for (int i = 0; i < node.size(); i++) {
            description.append(node.get(i).asText());
            if (i < node.size() - 1) {
                description.append(System.lineSeparator());
                description.append(System.lineSeparator());
            }
        }
        return description.toString();
    }

    String determineHigherLevelDescription(JsonNode node) {
        StringBuilder higherLevelDescription = new StringBuilder();
        JsonNode entries = node.get("entries");
        for (int i = 0; i < entries.size(); i++) {
            higherLevelDescription.append(entries.get(i));
            if (i < entries.size() - 1) {
                higherLevelDescription.append(System.lineSeparator());
                higherLevelDescription.append(System.lineSeparator());
            }
        }
        return higherLevelDescription.toString();
    }
}
