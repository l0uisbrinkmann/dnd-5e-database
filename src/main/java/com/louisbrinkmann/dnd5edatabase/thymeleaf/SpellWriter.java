package com.louisbrinkmann.dnd5edatabase.thymeleaf;

import com.louisbrinkmann.dnd5edatabase.models.spells.Spell;
import com.louisbrinkmann.dnd5edatabase.models.spells.SpellCollection;
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Slf4j
public class SpellWriter {

    public static void writeSpellCollectionToDirectory(File targetDirectory, SpellCollection spellCollection){
        List<Spell> spells = spellCollection.getSpells();
        for(Spell s : spells) {
            try {
                writeSpellToDirectory(targetDirectory, s);
            } catch (IOException e) {
                log.warn("Could not write SpellCollection to directory {}.", targetDirectory.getAbsolutePath());
            }
        }
    }

    public static void writeSpellToDirectory(File targetDirectory, Spell spell) throws IOException {
        Context context = new Context();
        context.setVariable("spell", spell);
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.TEXT);
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".md");
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        File outputDirectory = new File(System.getProperty("user.home") + "/repos/dnd-5e-obsidian-wiki/wiki");
        String fileName = spell.getName();
        if(fileName.contains("/")){
            fileName = fileName.replace("/", " - ");
        }
        File outputFile = new File(outputDirectory, fileName + ".md");
        outputFile.createNewFile();
        Writer writer = new FileWriter(outputFile);
        templateEngine.process("spell", context, writer);
    }
}
