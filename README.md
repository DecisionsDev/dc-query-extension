![GitHub last commit](https://img.shields.io/github/last-commit/ODMDev/dc-query-extension)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

# Decision Center query extension
 
This sample makes it possible to write a query to find the locked rule artifacts (rules, Decision Tables,...), ruleflows or variable sets.

## How to write such queries
```
Find all rule artifacts
    such that each rule artifact is locked
```
```
Find all ruleflows
    such that each ruleflow is locked
```
```
Find all rule variable sets
    such that each variable set is locked
```
## How does it work

New sentences `'element' is locked` (applying to rule artifacts, ruleflows and variable sets) are declared in the files:
- [ext.bom](find-locked-ruleartifacts-query-extension/src/main/resources/ilog/rules/teamserver/ext.bom) 
- [ext_en_US.voc](find-locked-ruleartifacts-query-extension/src/main/resources/ilog/rules/teamserver/ext_en_US.voc) 

The implementation classes are:
- [RuleArtifactQueryExtension](find-locked-ruleartifacts-query-extension/src/main/java/ilog/rules/teamserver/RuleArtifactQueryExtension.java) 
- [RuleflowQueryExtension](find-locked-ruleartifacts-query-extension/src/main/java/ilog/rules/teamserver/RuleflowQueryExtension.java) 
- [VariableSetQueryExtension](find-locked-ruleartifacts-query-extension/src/main/java/ilog/rules/teamserver/VariableSetQueryExtension.java) 

The mapping between the declarations and the implementation classes is in
- [ext.properties](find-locked-ruleartifacts-query-extension/src/main/resources/ilog/rules/teamserver/ext.properties) 

The integration of the query extension is done thanks to the file:
- [teamserver/bql/preferences.properties](find-locked-ruleartifacts-query-extension/src/main/resources/teamserver/bql/preferences.properties) 


You can read about creating and integrating a query extension in the documentation set: 
- [Creating query extensions](https://www.ibm.com/docs/en/odm/8.10?topic=queries-creating-query-extensions)
- [Integrating query extensions](https://www.ibm.com/docs/en/odm/8.10?topic=extensions-integrating-query)

## Pre-requisites
The sample can be built and run with IBM Operational Decision Manager, versions 8.9.x, 8.10.x or 8.11.

## Building
### using Maven
* Edit the [pom.xml](find-locked-ruleartifacts-query-extension/pom.xml) file to define the dependency to Decision Center Jars and the URL of your remote repository
* Run the maven command:
```
mvn clean install
```
### using Ant
* Edit the [build.properties](find-locked-ruleartifacts-query-extension/build.properties) file to set the `odm.dir` property to your ODM install directory.
* Run the default Ant target to build `query-extension.jar`
```
ant -f build.xml
```
## Running
To run the sample, add the JAR generated in the `target` directory to decisioncenter.war (in WEB-INF/lib).

# Issues and contributions
For issues relating specifically to the Dockerfiles and scripts, please use the [GitHub issue tracker](../../issues).
We welcome contributions following [our guidelines](CONTRIBUTING.md).

# License
The Dockerfiles and associated scripts found in this project are licensed under the [Apache License 2.0](LICENSE).

# Notice
© Copyright IBM Corporation 2022.