package com.louisbrinkmann.dnd5edatabase.json;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JS2JPGenerator {
    public static void generatePojosForSchema(URL jsonSchema, File targetClassDirectory, String targetPackageName, String javaClassName) throws IOException {
        JCodeModel codeModel = new JCodeModel();
        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() {
                return true;
            }

            @Override
            public boolean isIncludeAdditionalProperties(){
                return false;
            }

            @Override
            public SourceType getSourceType() {
                return SourceType.JSONSCHEMA;
            }
        };
        SchemaMapper schemaMapper = new SchemaMapper(new RuleFactory(config, new HibernateAnnotator(config), new SchemaStore()), new SchemaGenerator());
        schemaMapper.generate(codeModel, javaClassName, targetPackageName, jsonSchema);
        codeModel.build(targetClassDirectory);
    }
}
