# Decision Center query extension
 
This sample makes it possible to write a query to find the locked rule artifacts (rules, Decision Tables,...), ruleflows or variable sets.

## How to write such queries
```java
Find all rule artifacts
    such that each rule artifact is locked
```
```java
Find all ruleflows
    such that each ruleflow is locked
```
```java
Find all rule variable sets
    such that each variable set is locked
```
## How does it work

New sentences `'element' is locked` (applying to rule artifacts, ruleflows and variable sets) are declared in the files:
- [ext.bom](find-locked-ruleartifacts-query-extension/ilog/rules/teamserver/ext.bom) 
- [ext_en_US.voc](find-locked-ruleartifacts-query-extension/ilog/rules/teamserver/ext_en_US.voc) 

The implementation classes are:
- [RuleArtifactQueryExtension](find-locked-ruleartifacts-query-extension/src/ilog/rules/teamserver/RuleArtifactQueryExtension.java) 
- [RuleflowQueryExtension](find-locked-ruleartifacts-query-extension/src/ilog/rules/teamserver/RuleflowQueryExtension.java) 
- [VariableSetQueryExtension](find-locked-ruleartifacts-query-extension/src/ilog/rules/teamserver/VariableSetQueryExtension.java) 

The mapping between the declarations and the implementation classes is in
- [ext.properties](find-locked-ruleartifacts-query-extension/ilog/rules/teamserver/ext.properties) 

The integration of the query extension is done thanks to the file:
- [teamserver/bql/preferences.properties](find-locked-ruleartifacts-query-extension/teamserver/bql/preferences.properties) 


You can read about creating and integrating a query extension in the documentation set: 
- [Creating query extensions](https://www.ibm.com/docs/en/odm/8.10?topic=queries-creating-query-extensions)
- [Integrating query extensions](https://www.ibm.com/docs/en/odm/8.10?topic=extensions-integrating-query)

## Building the query extension
Either use [build-JAR.jardesc](find-locked-ruleartifacts-query-extension/build-JAR.jardesc) or Maven (see [pom.xml](find-locked-ruleartifacts-query-extension/pom.xml)) to build the JAR.
Then add it to both decisioncenter.war and teamserver.war into WEB-INF/lib.

The content of the JAR should be:
```
ilog/rules/teamserver/*.class
ilog/rules/teamserver/ext.bom
ilog/rules/teamserver/ext_en_US.voc
ilog/rules/teamserver/ext.properties
META-INF
teamserver/bql/preferences.properties
```
