
package com.louisbrinkmann.dnd5edatabase.models.spells;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


/**
 * Spell
 * <p>
 * 
 * 
 */
@Entity
@Generated("jsonschema2pojo")
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 
     * (Required)
     * 
     */
    @Column(unique = true)
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    private Integer level;
    /**
     * A: Abjuration
     *  C: Conjuration
     *  D: Divination
     *  E: Enchantment
     *  V: Evocation
     *  I: Illusion
     *  N: Necromancy
     *  T: Transmutation
     *  P: Psychic
     * (Required)
     * 
     */
    private Spell.SpellSchool school;
    private Set<Subschool> subschools = new LinkedHashSet<Subschool>();
    @OneToOne(cascade = CascadeType.PERSIST)
    private Meta meta;
    /**
     * 
     * (Required)
     * 
     */
    private List<Time> time = new ArrayList<Time>();
    /**
     * 
     * (Required)
     * 
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    private Range range;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Components components;
    /**
     * 
     * (Required)
     * 
     */
    private List<Duration> duration = new ArrayList<Duration>();
    /**
     * 
     * (Required)
     * 
     */
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Object> entries = new ArrayList<Object>();
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Object> entriesHigherLevel = new ArrayList<Object>();
    /**
     * An identifying string, as seen in the JSON in "source" fields.
     * (Required)
     * 
     */
    private String source;
    private Object page;
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<AdditionalSource> additionalSources = new LinkedHashSet<AdditionalSource>();
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<OtherSource> otherSources = new LinkedHashSet<OtherSource>();
    private Set<DataDamageType> damageInflict = new LinkedHashSet<DataDamageType>();
    private Set<DataDamageType> damageResist = new LinkedHashSet<DataDamageType>();
    private Set<DataDamageType> damageImmune = new LinkedHashSet<DataDamageType>();
    private Set<DataDamageType> damageVulnerable = new LinkedHashSet<DataDamageType>();
    private Set<TagsCondition> conditionInflict = new LinkedHashSet<TagsCondition>();
    private Set<TagsCondition> conditionImmune = new LinkedHashSet<TagsCondition>();
    private Set<TagsSavingThrow> savingThrow = new LinkedHashSet<TagsSavingThrow>();
    private Set<AbilityCheck> abilityCheck = new LinkedHashSet<AbilityCheck>();
    private Set<SpellAttack> spellAttack = new LinkedHashSet<SpellAttack>();
    /**
     * By convention, only the effects of the spell cast at its base level are considered when populating these.
     *  C: Cube
     *  H: Hemisphere
     *  L: Line
     *  MT: Multiple Targets
     *  N: Cone
     *  Q: Square
     *  R: Circle
     *  ST: Single Target
     *  S: Sphere
     *  W: Wall
     *  Y: Cylinder
     * 
     */
    private Set<AreaTag> areaTags = new LinkedHashSet<AreaTag>();
    /**
     * AAD: Additional Attack Damage
     *  ADV: Grants Advantage
     *  DFT: Difficult Terrain
     *  FMV: Forced Movement
     *  HL: Healing
     *  LGT: Creates Light
     *  LGTS: Creates Sunlight
     *  MAC: Modifies AC
     *  OBJ: Affects Objects
     *  OBS: Obscures Vision
     *  PIR: Permanent If Repeated
     *  PRM: Permanent Effects
     *  PS: Plane Shifting
     * RO: Rollable Effects
     *  SCL: Scaling Effects
     *   SMN: Summons Creature
     *  SGT: Requires Sight
     *  THP: Grants Temporary Hit Points
     *  TP: Teleportation
     *  UBA: Uses Bonus Action
     * 
     */
    private Set<MiscTag> miscTags = new LinkedHashSet<MiscTag>();
    private Set<CreatureType> affectsCreatureType = new LinkedHashSet<CreatureType>();
    private Object srd;
    private Object basicRules;
    private Object legacy;
    private Object scalingLevelDice;
    private Boolean hasFluff;
    private Boolean hasFluffImages;

    /**
     * 
     * (Required)
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    public Spell withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    public Spell withLevel(Integer level) {
        this.level = level;
        return this;
    }

    /**
     * A: Abjuration
     *  C: Conjuration
     *  D: Divination
     *  E: Enchantment
     *  V: Evocation
     *  I: Illusion
     *  N: Necromancy
     *  T: Transmutation
     *  P: Psychic
     * (Required)
     * 
     */
    public Spell.SpellSchool getSchool() {
        return school;
    }

    /**
     * A: Abjuration
     *  C: Conjuration
     *  D: Divination
     *  E: Enchantment
     *  V: Evocation
     *  I: Illusion
     *  N: Necromancy
     *  T: Transmutation
     *  P: Psychic
     * (Required)
     * 
     */
    public void setSchool(Spell.SpellSchool school) {
        this.school = school;
    }

    public Spell withSchool(Spell.SpellSchool school) {
        this.school = school;
        return this;
    }

    public Set<Subschool> getSubschools() {
        return subschools;
    }

    public void setSubschools(Set<Subschool> subschools) {
        this.subschools = subschools;
    }

    public Spell withSubschools(Set<Subschool> subschools) {
        this.subschools = subschools;
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Spell withMeta(Meta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    public List<Time> getTime() {
        return time;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setTime(List<Time> time) {
        this.time = time;
    }

    public Spell withTime(List<Time> time) {
        this.time = time;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Range getRange() {
        return range;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setRange(Range range) {
        this.range = range;
    }

    public Spell withRange(Range range) {
        this.range = range;
        return this;
    }

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }

    public Spell withComponents(Components components) {
        this.components = components;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    public List<Duration> getDuration() {
        return duration;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setDuration(List<Duration> duration) {
        this.duration = duration;
    }

    public Spell withDuration(List<Duration> duration) {
        this.duration = duration;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    public List<Object> getEntries() {
        return entries;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setEntries(List<Object> entries) {
        this.entries = entries;
    }

    public Spell withEntries(List<Object> entries) {
        this.entries = entries;
        return this;
    }

    public List<Object> getEntriesHigherLevel() {
        return entriesHigherLevel;
    }

    public void setEntriesHigherLevel(List<Object> entriesHigherLevel) {
        this.entriesHigherLevel = entriesHigherLevel;
    }

    public Spell withEntriesHigherLevel(List<Object> entriesHigherLevel) {
        this.entriesHigherLevel = entriesHigherLevel;
        return this;
    }

    /**
     * An identifying string, as seen in the JSON in "source" fields.
     * (Required)
     * 
     */
    public String getSource() {
        return source;
    }

    /**
     * An identifying string, as seen in the JSON in "source" fields.
     * (Required)
     * 
     */
    public void setSource(String source) {
        this.source = source;
    }

    public Spell withSource(String source) {
        this.source = source;
        return this;
    }

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }

    public Spell withPage(Object page) {
        this.page = page;
        return this;
    }

    public Set<AdditionalSource> getAdditionalSources() {
        return additionalSources;
    }

    public void setAdditionalSources(Set<AdditionalSource> additionalSources) {
        this.additionalSources = additionalSources;
    }

    public Spell withAdditionalSources(Set<AdditionalSource> additionalSources) {
        this.additionalSources = additionalSources;
        return this;
    }

    public Set<OtherSource> getOtherSources() {
        return otherSources;
    }

    public void setOtherSources(Set<OtherSource> otherSources) {
        this.otherSources = otherSources;
    }

    public Spell withOtherSources(Set<OtherSource> otherSources) {
        this.otherSources = otherSources;
        return this;
    }

    public Set<DataDamageType> getDamageInflict() {
        return damageInflict;
    }

    public void setDamageInflict(Set<DataDamageType> damageInflict) {
        this.damageInflict = damageInflict;
    }

    public Spell withDamageInflict(Set<DataDamageType> damageInflict) {
        this.damageInflict = damageInflict;
        return this;
    }

    public Set<DataDamageType> getDamageResist() {
        return damageResist;
    }

    public void setDamageResist(Set<DataDamageType> damageResist) {
        this.damageResist = damageResist;
    }

    public Spell withDamageResist(Set<DataDamageType> damageResist) {
        this.damageResist = damageResist;
        return this;
    }

    public Set<DataDamageType> getDamageImmune() {
        return damageImmune;
    }

    public void setDamageImmune(Set<DataDamageType> damageImmune) {
        this.damageImmune = damageImmune;
    }

    public Spell withDamageImmune(Set<DataDamageType> damageImmune) {
        this.damageImmune = damageImmune;
        return this;
    }

    public Set<DataDamageType> getDamageVulnerable() {
        return damageVulnerable;
    }

    public void setDamageVulnerable(Set<DataDamageType> damageVulnerable) {
        this.damageVulnerable = damageVulnerable;
    }

    public Spell withDamageVulnerable(Set<DataDamageType> damageVulnerable) {
        this.damageVulnerable = damageVulnerable;
        return this;
    }

    public Set<TagsCondition> getConditionInflict() {
        return conditionInflict;
    }

    public void setConditionInflict(Set<TagsCondition> conditionInflict) {
        this.conditionInflict = conditionInflict;
    }

    public Spell withConditionInflict(Set<TagsCondition> conditionInflict) {
        this.conditionInflict = conditionInflict;
        return this;
    }

    public Set<TagsCondition> getConditionImmune() {
        return conditionImmune;
    }

    public void setConditionImmune(Set<TagsCondition> conditionImmune) {
        this.conditionImmune = conditionImmune;
    }

    public Spell withConditionImmune(Set<TagsCondition> conditionImmune) {
        this.conditionImmune = conditionImmune;
        return this;
    }

    public Set<TagsSavingThrow> getSavingThrow() {
        return savingThrow;
    }

    public void setSavingThrow(Set<TagsSavingThrow> savingThrow) {
        this.savingThrow = savingThrow;
    }

    public Spell withSavingThrow(Set<TagsSavingThrow> savingThrow) {
        this.savingThrow = savingThrow;
        return this;
    }

    public Set<AbilityCheck> getAbilityCheck() {
        return abilityCheck;
    }

    public void setAbilityCheck(Set<AbilityCheck> abilityCheck) {
        this.abilityCheck = abilityCheck;
    }

    public Spell withAbilityCheck(Set<AbilityCheck> abilityCheck) {
        this.abilityCheck = abilityCheck;
        return this;
    }

    public Set<SpellAttack> getSpellAttack() {
        return spellAttack;
    }

    public void setSpellAttack(Set<SpellAttack> spellAttack) {
        this.spellAttack = spellAttack;
    }

    public Spell withSpellAttack(Set<SpellAttack> spellAttack) {
        this.spellAttack = spellAttack;
        return this;
    }

    /**
     * By convention, only the effects of the spell cast at its base level are considered when populating these.
     *  C: Cube
     *  H: Hemisphere
     *  L: Line
     *  MT: Multiple Targets
     *  N: Cone
     *  Q: Square
     *  R: Circle
     *  ST: Single Target
     *  S: Sphere
     *  W: Wall
     *  Y: Cylinder
     * 
     */
    public Set<AreaTag> getAreaTags() {
        return areaTags;
    }

    /**
     * By convention, only the effects of the spell cast at its base level are considered when populating these.
     *  C: Cube
     *  H: Hemisphere
     *  L: Line
     *  MT: Multiple Targets
     *  N: Cone
     *  Q: Square
     *  R: Circle
     *  ST: Single Target
     *  S: Sphere
     *  W: Wall
     *  Y: Cylinder
     * 
     */
    public void setAreaTags(Set<AreaTag> areaTags) {
        this.areaTags = areaTags;
    }

    public Spell withAreaTags(Set<AreaTag> areaTags) {
        this.areaTags = areaTags;
        return this;
    }

    /**
     * AAD: Additional Attack Damage
     *  ADV: Grants Advantage
     *  DFT: Difficult Terrain
     *  FMV: Forced Movement
     *  HL: Healing
     *  LGT: Creates Light
     *  LGTS: Creates Sunlight
     *  MAC: Modifies AC
     *  OBJ: Affects Objects
     *  OBS: Obscures Vision
     *  PIR: Permanent If Repeated
     *  PRM: Permanent Effects
     *  PS: Plane Shifting
     * RO: Rollable Effects
     *  SCL: Scaling Effects
     *   SMN: Summons Creature
     *  SGT: Requires Sight
     *  THP: Grants Temporary Hit Points
     *  TP: Teleportation
     *  UBA: Uses Bonus Action
     * 
     */
    public Set<MiscTag> getMiscTags() {
        return miscTags;
    }

    /**
     * AAD: Additional Attack Damage
     *  ADV: Grants Advantage
     *  DFT: Difficult Terrain
     *  FMV: Forced Movement
     *  HL: Healing
     *  LGT: Creates Light
     *  LGTS: Creates Sunlight
     *  MAC: Modifies AC
     *  OBJ: Affects Objects
     *  OBS: Obscures Vision
     *  PIR: Permanent If Repeated
     *  PRM: Permanent Effects
     *  PS: Plane Shifting
     * RO: Rollable Effects
     *  SCL: Scaling Effects
     *   SMN: Summons Creature
     *  SGT: Requires Sight
     *  THP: Grants Temporary Hit Points
     *  TP: Teleportation
     *  UBA: Uses Bonus Action
     * 
     */
    public void setMiscTags(Set<MiscTag> miscTags) {
        this.miscTags = miscTags;
    }

    public Spell withMiscTags(Set<MiscTag> miscTags) {
        this.miscTags = miscTags;
        return this;
    }

    public Set<CreatureType> getAffectsCreatureType() {
        return affectsCreatureType;
    }

    public void setAffectsCreatureType(Set<CreatureType> affectsCreatureType) {
        this.affectsCreatureType = affectsCreatureType;
    }

    public Spell withAffectsCreatureType(Set<CreatureType> affectsCreatureType) {
        this.affectsCreatureType = affectsCreatureType;
        return this;
    }

    public Object getSrd() {
        return srd;
    }

    public void setSrd(Object srd) {
        this.srd = srd;
    }

    public Spell withSrd(Object srd) {
        this.srd = srd;
        return this;
    }

    public Object getBasicRules() {
        return basicRules;
    }

    public void setBasicRules(Object basicRules) {
        this.basicRules = basicRules;
    }

    public Spell withBasicRules(Object basicRules) {
        this.basicRules = basicRules;
        return this;
    }

    public Object getLegacy() {
        return legacy;
    }

    public void setLegacy(Object legacy) {
        this.legacy = legacy;
    }

    public Spell withLegacy(Object legacy) {
        this.legacy = legacy;
        return this;
    }

    public Object getScalingLevelDice() {
        return scalingLevelDice;
    }

    public void setScalingLevelDice(Object scalingLevelDice) {
        this.scalingLevelDice = scalingLevelDice;
    }

    public Spell withScalingLevelDice(Object scalingLevelDice) {
        this.scalingLevelDice = scalingLevelDice;
        return this;
    }

    public Boolean getHasFluff() {
        return hasFluff;
    }

    public void setHasFluff(Boolean hasFluff) {
        this.hasFluff = hasFluff;
    }

    public Spell withHasFluff(Boolean hasFluff) {
        this.hasFluff = hasFluff;
        return this;
    }

    public Boolean getHasFluffImages() {
        return hasFluffImages;
    }

    public void setHasFluffImages(Boolean hasFluffImages) {
        this.hasFluffImages = hasFluffImages;
    }

    public Spell withHasFluffImages(Boolean hasFluffImages) {
        this.hasFluffImages = hasFluffImages;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Spell.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("level");
        sb.append('=');
        sb.append(((this.level == null)?"<null>":this.level));
        sb.append(',');
        sb.append("school");
        sb.append('=');
        sb.append(((this.school == null)?"<null>":this.school));
        sb.append(',');
        sb.append("subschools");
        sb.append('=');
        sb.append(((this.subschools == null)?"<null>":this.subschools));
        sb.append(',');
        sb.append("meta");
        sb.append('=');
        sb.append(((this.meta == null)?"<null>":this.meta));
        sb.append(',');
        sb.append("time");
        sb.append('=');
        sb.append(((this.time == null)?"<null>":this.time));
        sb.append(',');
        sb.append("range");
        sb.append('=');
        sb.append(((this.range == null)?"<null>":this.range));
        sb.append(',');
        sb.append("components");
        sb.append('=');
        sb.append(((this.components == null)?"<null>":this.components));
        sb.append(',');
        sb.append("duration");
        sb.append('=');
        sb.append(((this.duration == null)?"<null>":this.duration));
        sb.append(',');
        sb.append("entries");
        sb.append('=');
        sb.append(((this.entries == null)?"<null>":this.entries));
        sb.append(',');
        sb.append("entriesHigherLevel");
        sb.append('=');
        sb.append(((this.entriesHigherLevel == null)?"<null>":this.entriesHigherLevel));
        sb.append(',');
        sb.append("source");
        sb.append('=');
        sb.append(((this.source == null)?"<null>":this.source));
        sb.append(',');
        sb.append("page");
        sb.append('=');
        sb.append(((this.page == null)?"<null>":this.page));
        sb.append(',');
        sb.append("additionalSources");
        sb.append('=');
        sb.append(((this.additionalSources == null)?"<null>":this.additionalSources));
        sb.append(',');
        sb.append("otherSources");
        sb.append('=');
        sb.append(((this.otherSources == null)?"<null>":this.otherSources));
        sb.append(',');
        sb.append("damageInflict");
        sb.append('=');
        sb.append(((this.damageInflict == null)?"<null>":this.damageInflict));
        sb.append(',');
        sb.append("damageResist");
        sb.append('=');
        sb.append(((this.damageResist == null)?"<null>":this.damageResist));
        sb.append(',');
        sb.append("damageImmune");
        sb.append('=');
        sb.append(((this.damageImmune == null)?"<null>":this.damageImmune));
        sb.append(',');
        sb.append("damageVulnerable");
        sb.append('=');
        sb.append(((this.damageVulnerable == null)?"<null>":this.damageVulnerable));
        sb.append(',');
        sb.append("conditionInflict");
        sb.append('=');
        sb.append(((this.conditionInflict == null)?"<null>":this.conditionInflict));
        sb.append(',');
        sb.append("conditionImmune");
        sb.append('=');
        sb.append(((this.conditionImmune == null)?"<null>":this.conditionImmune));
        sb.append(',');
        sb.append("savingThrow");
        sb.append('=');
        sb.append(((this.savingThrow == null)?"<null>":this.savingThrow));
        sb.append(',');
        sb.append("abilityCheck");
        sb.append('=');
        sb.append(((this.abilityCheck == null)?"<null>":this.abilityCheck));
        sb.append(',');
        sb.append("spellAttack");
        sb.append('=');
        sb.append(((this.spellAttack == null)?"<null>":this.spellAttack));
        sb.append(',');
        sb.append("areaTags");
        sb.append('=');
        sb.append(((this.areaTags == null)?"<null>":this.areaTags));
        sb.append(',');
        sb.append("miscTags");
        sb.append('=');
        sb.append(((this.miscTags == null)?"<null>":this.miscTags));
        sb.append(',');
        sb.append("affectsCreatureType");
        sb.append('=');
        sb.append(((this.affectsCreatureType == null)?"<null>":this.affectsCreatureType));
        sb.append(',');
        sb.append("srd");
        sb.append('=');
        sb.append(((this.srd == null)?"<null>":this.srd));
        sb.append(',');
        sb.append("basicRules");
        sb.append('=');
        sb.append(((this.basicRules == null)?"<null>":this.basicRules));
        sb.append(',');
        sb.append("legacy");
        sb.append('=');
        sb.append(((this.legacy == null)?"<null>":this.legacy));
        sb.append(',');
        sb.append("scalingLevelDice");
        sb.append('=');
        sb.append(((this.scalingLevelDice == null)?"<null>":this.scalingLevelDice));
        sb.append(',');
        sb.append("hasFluff");
        sb.append('=');
        sb.append(((this.hasFluff == null)?"<null>":this.hasFluff));
        sb.append(',');
        sb.append("hasFluffImages");
        sb.append('=');
        sb.append(((this.hasFluffImages == null)?"<null>":this.hasFluffImages));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.components == null)? 0 :this.components.hashCode()));
        result = ((result* 31)+((this.miscTags == null)? 0 :this.miscTags.hashCode()));
        result = ((result* 31)+((this.legacy == null)? 0 :this.legacy.hashCode()));
        result = ((result* 31)+((this.entriesHigherLevel == null)? 0 :this.entriesHigherLevel.hashCode()));
        result = ((result* 31)+((this.damageVulnerable == null)? 0 :this.damageVulnerable.hashCode()));
        result = ((result* 31)+((this.hasFluffImages == null)? 0 :this.hasFluffImages.hashCode()));
        result = ((result* 31)+((this.range == null)? 0 :this.range.hashCode()));
        result = ((result* 31)+((this.conditionInflict == null)? 0 :this.conditionInflict.hashCode()));
        result = ((result* 31)+((this.additionalSources == null)? 0 :this.additionalSources.hashCode()));
        result = ((result* 31)+((this.source == null)? 0 :this.source.hashCode()));
        result = ((result* 31)+((this.conditionImmune == null)? 0 :this.conditionImmune.hashCode()));
        result = ((result* 31)+((this.duration == null)? 0 :this.duration.hashCode()));
        result = ((result* 31)+((this.spellAttack == null)? 0 :this.spellAttack.hashCode()));
        result = ((result* 31)+((this.school == null)? 0 :this.school.hashCode()));
        result = ((result* 31)+((this.scalingLevelDice == null)? 0 :this.scalingLevelDice.hashCode()));
        result = ((result* 31)+((this.damageResist == null)? 0 :this.damageResist.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.damageInflict == null)? 0 :this.damageInflict.hashCode()));
        result = ((result* 31)+((this.abilityCheck == null)? 0 :this.abilityCheck.hashCode()));
        result = ((result* 31)+((this.damageImmune == null)? 0 :this.damageImmune.hashCode()));
        result = ((result* 31)+((this.basicRules == null)? 0 :this.basicRules.hashCode()));
        result = ((result* 31)+((this.srd == null)? 0 :this.srd.hashCode()));
        result = ((result* 31)+((this.level == null)? 0 :this.level.hashCode()));
        result = ((result* 31)+((this.affectsCreatureType == null)? 0 :this.affectsCreatureType.hashCode()));
        result = ((result* 31)+((this.otherSources == null)? 0 :this.otherSources.hashCode()));
        result = ((result* 31)+((this.entries == null)? 0 :this.entries.hashCode()));
        result = ((result* 31)+((this.savingThrow == null)? 0 :this.savingThrow.hashCode()));
        result = ((result* 31)+((this.hasFluff == null)? 0 :this.hasFluff.hashCode()));
        result = ((result* 31)+((this.meta == null)? 0 :this.meta.hashCode()));
        result = ((result* 31)+((this.areaTags == null)? 0 :this.areaTags.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.time == null)? 0 :this.time.hashCode()));
        result = ((result* 31)+((this.page == null)? 0 :this.page.hashCode()));
        result = ((result* 31)+((this.subschools == null)? 0 :this.subschools.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Spell) == false) {
            return false;
        }
        Spell rhs = ((Spell) other);
        return (((((((((((((((((((((((((((((((((((this.components == rhs.components)||((this.components!= null)&&this.components.equals(rhs.components)))&&((this.miscTags == rhs.miscTags)||((this.miscTags!= null)&&this.miscTags.equals(rhs.miscTags))))&&((this.legacy == rhs.legacy)||((this.legacy!= null)&&this.legacy.equals(rhs.legacy))))&&((this.entriesHigherLevel == rhs.entriesHigherLevel)||((this.entriesHigherLevel!= null)&&this.entriesHigherLevel.equals(rhs.entriesHigherLevel))))&&((this.damageVulnerable == rhs.damageVulnerable)||((this.damageVulnerable!= null)&&this.damageVulnerable.equals(rhs.damageVulnerable))))&&((this.hasFluffImages == rhs.hasFluffImages)||((this.hasFluffImages!= null)&&this.hasFluffImages.equals(rhs.hasFluffImages))))&&((this.range == rhs.range)||((this.range!= null)&&this.range.equals(rhs.range))))&&((this.conditionInflict == rhs.conditionInflict)||((this.conditionInflict!= null)&&this.conditionInflict.equals(rhs.conditionInflict))))&&((this.additionalSources == rhs.additionalSources)||((this.additionalSources!= null)&&this.additionalSources.equals(rhs.additionalSources))))&&((this.source == rhs.source)||((this.source!= null)&&this.source.equals(rhs.source))))&&((this.conditionImmune == rhs.conditionImmune)||((this.conditionImmune!= null)&&this.conditionImmune.equals(rhs.conditionImmune))))&&((this.duration == rhs.duration)||((this.duration!= null)&&this.duration.equals(rhs.duration))))&&((this.spellAttack == rhs.spellAttack)||((this.spellAttack!= null)&&this.spellAttack.equals(rhs.spellAttack))))&&((this.school == rhs.school)||((this.school!= null)&&this.school.equals(rhs.school))))&&((this.scalingLevelDice == rhs.scalingLevelDice)||((this.scalingLevelDice!= null)&&this.scalingLevelDice.equals(rhs.scalingLevelDice))))&&((this.damageResist == rhs.damageResist)||((this.damageResist!= null)&&this.damageResist.equals(rhs.damageResist))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.damageInflict == rhs.damageInflict)||((this.damageInflict!= null)&&this.damageInflict.equals(rhs.damageInflict))))&&((this.abilityCheck == rhs.abilityCheck)||((this.abilityCheck!= null)&&this.abilityCheck.equals(rhs.abilityCheck))))&&((this.damageImmune == rhs.damageImmune)||((this.damageImmune!= null)&&this.damageImmune.equals(rhs.damageImmune))))&&((this.basicRules == rhs.basicRules)||((this.basicRules!= null)&&this.basicRules.equals(rhs.basicRules))))&&((this.srd == rhs.srd)||((this.srd!= null)&&this.srd.equals(rhs.srd))))&&((this.level == rhs.level)||((this.level!= null)&&this.level.equals(rhs.level))))&&((this.affectsCreatureType == rhs.affectsCreatureType)||((this.affectsCreatureType!= null)&&this.affectsCreatureType.equals(rhs.affectsCreatureType))))&&((this.otherSources == rhs.otherSources)||((this.otherSources!= null)&&this.otherSources.equals(rhs.otherSources))))&&((this.entries == rhs.entries)||((this.entries!= null)&&this.entries.equals(rhs.entries))))&&((this.savingThrow == rhs.savingThrow)||((this.savingThrow!= null)&&this.savingThrow.equals(rhs.savingThrow))))&&((this.hasFluff == rhs.hasFluff)||((this.hasFluff!= null)&&this.hasFluff.equals(rhs.hasFluff))))&&((this.meta == rhs.meta)||((this.meta!= null)&&this.meta.equals(rhs.meta))))&&((this.areaTags == rhs.areaTags)||((this.areaTags!= null)&&this.areaTags.equals(rhs.areaTags))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.time == rhs.time)||((this.time!= null)&&this.time.equals(rhs.time))))&&((this.page == rhs.page)||((this.page!= null)&&this.page.equals(rhs.page))))&&((this.subschools == rhs.subschools)||((this.subschools!= null)&&this.subschools.equals(rhs.subschools))));
    }


    /**
     * A: Abjuration
     *  C: Conjuration
     *  D: Divination
     *  E: Enchantment
     *  V: Evocation
     *  I: Illusion
     *  N: Necromancy
     *  T: Transmutation
     *  P: Psychic
     * 
     */
    @Generated("jsonschema2pojo")
    public enum SpellSchool {

        A("A"),
        C("C"),
        D("D"),
        E("E"),
        V("V"),
        I("I"),
        N("N"),
        T("T"),
        P("P");
        private final String value;
        private final static Map<String, Spell.SpellSchool> CONSTANTS = new HashMap<String, Spell.SpellSchool>();

        static {
            for (Spell.SpellSchool c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        SpellSchool(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static Spell.SpellSchool fromValue(String value) {
            Spell.SpellSchool constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
