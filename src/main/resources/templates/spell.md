---
tags:
  - spell
level: [(${spell.level})]
school of magic: [(${spell.schoolOfMagic.name})]
ritual: [(${spell.ritual})]
time: [(${spell.castingTime})]
range: [(${spell.range})]
verbal: [(${spell.verbal})]
somatic: [(${spell.somatic})]
material: [(${spell.material})]
concentration: [(${spell.concentration})]
duration: [(${spell.duration})]
source: [(${spell.source.book})] [# th:if="${spell.source.page != null}"][(${spell.source.page})][/] 
srd: [(${spell.srd})]
---
# [(${spell.name})]
[(${spell.description})]

[# th:if="${spell.higherLevelDescription != null}"]**At higher levels:** 
[(${spell.higherLevelDescription})][/]