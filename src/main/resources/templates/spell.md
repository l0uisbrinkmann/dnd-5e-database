---
tags:
  - spell
level: [(${spell.level})]
school of magic: [# th:if="${spell.school.name!=null}"][[[(${spell.school.name})]]][/][# th:unless="${spell.school.name!=null}"][(${spell.school.abbreviation})][/]
ritual: [(${spell.ritual})]
time: [# th:if="${spell.castingTime.amount!=null}"][(${spell.castingTime.amount})] [/][(${spell.castingTime.type.type})]
range: [# th:if="${spell.castingRange.distance!=null}"][(${spell.castingRange.distance.amount})] [(${spell.castingRange.distance.type})][/][# th:unless="${spell.castingRange.distance!=null}"][(${spell.castingRange.type})][/]
verbal: [(${spell.components.verbal})]
somatic: [(${spell.components.somatic})]
material: [(${spell.components.material})]
concentration: [(${spell.concentration})]
duration: [(${spell.effectDuration.amount})] [(${spell.effectDuration.type.type})]
source: [# th:if="${spell.source.book.name != null}"][(${spell.source.book.name})] [/][# th:unless="${spell.source.book.name != null}"][(${spell.source.book.abbreviation})] [/]page [(${spell.source.page})]
---
# [(${spell.name})][# th:each="entry: ${spell.entries}"]
[(${entry})]

[/][# th:if="${spell.higherLevelDescription != null}"]**At higher levels:** 
[(${spell.higherLevelDescription})][/]