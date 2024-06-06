---
tags:
  - spell
level: [(${spell.level})]
school of magic: [(${spell.schoolOfMagic.name})]
ritual: [(${spell.ritual})]
time: [(${spell.castingTime})]
range: [# th:if="${spell.castingRange.distance!=null}"][(${spell.castingRange.distance.amount})] [(${spell.castingRange.distance.type})][/][# th:unless="${spell.castingRange.distance!=null}"][(${spell.castingRange.type})][/]
verbal: [(${spell.verbal})]
somatic: [(${spell.somatic})]
material: [(${spell.material})]
concentration: [(${spell.concentration})]
duration: [(${spell.duration})]
source: [# th:if="${spell.source.book.name != null}"][(${spell.source.book.name})] [/][# th:unless="${spell.source.book.name != null}"][(${spell.source.book.abbreviation})] [/]page [(${spell.source.page})]
srd: [(${spell.srd})]
---
# [(${spell.name})]
[(${spell.description})]

[/][# th:if="${spell.higherLevelDescription != null}"]**At higher levels:** 
[(${spell.higherLevelDescription})][/]