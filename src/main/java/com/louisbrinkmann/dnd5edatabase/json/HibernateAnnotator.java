package com.louisbrinkmann.dnd5edatabase.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.*;
import com.sun.tools.javac.Main;
import lombok.extern.slf4j.Slf4j;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Slf4j
public class HibernateAnnotator extends AbstractAnnotator {
    public HibernateAnnotator(GenerationConfig generationConfig) {
        super(generationConfig);
    }

    @Override
    public void propertyInclusion(JDefinedClass clazz, JsonNode schema) {
        super.propertyInclusion(clazz, schema);
        // Add @Entity annotation
        clazz.annotate(jakarta.persistence.Entity.class);
        // Add id field
        JFieldVar idField = clazz.field(JMod.PRIVATE, Long.class, "id");
        JAnnotationUse idAnnotation = idField.annotate(jakarta.persistence.Id.class);
        JAnnotationUse generatedValueAnnotation = idField.annotate(jakarta.persistence.GeneratedValue.class);
        generatedValueAnnotation.param("strategy", jakarta.persistence.GenerationType.IDENTITY);
    }

    @Override
    public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
        super.propertyField(field, clazz, propertyName, propertyNode);
        // Add cascade annotation for OneToOne relationships
        if(propertyNode.has("type")){
            if (propertyNode.get("type").asText().equals("object")) {
                JAnnotationUse oneToOneAnnotation = field.annotate(jakarta.persistence.OneToOne.class);
                oneToOneAnnotation.param("cascade", jakarta.persistence.CascadeType.PERSIST);
            } else if (propertyNode.get("type").asText().equals("array")) {
                if((propertyNode.get("items").has("type") && propertyNode.get("items").get("type").asText().equals("object"))){
                    JAnnotationUse oneToManyAnnotation = field.annotate(jakarta.persistence.OneToMany.class);
                    oneToManyAnnotation.param("cascade", jakarta.persistence.CascadeType.PERSIST);
                }
            }
        }
        // Add unique constraint on name fields
        if (field.name().equals("name")){
            JAnnotationUse uniqueColumnAnnotation = field.annotate(jakarta.persistence.Column.class);
            uniqueColumnAnnotation.param("unique", true);
        }
    }
}
