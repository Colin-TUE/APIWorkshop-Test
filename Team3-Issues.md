# Backwards Incompatibility Team 3

- Source Incompatibility is in Idea projects
- Binary Incompatibility is in the workspace "workspace4" (Contains suite and change jars). Run TestSuite Jar from Compiled. 
    * So first export to JAR using circeval.jar in seperate folder. 
    * Then change the lib jar with corresponding version
    * Run from command line using "java -jar testSuite.jar"

## Issue 1
Test Case: EvaluateAnd() and BinaryLogicExpressionTest()

In the new version Element has gained a method and therefore needs to be implemented. 

Applicable to all elements (and derived classes from that)

Source Incompatibility: Yes
Binary Incompatibility: Yes
Functional Incompatibility: No

## Issue 2
Test Case: EvaluateAnd()

In the new version And is final and therefore cannot be inherited from. 

Applicable to Constant, And, Or and Not

Source Incompatibility: Yes
Binary Incompatibility: Yes
Functional Incompatibility: No

## Issue 3
Test Case: BinExprTest2()

In the new version BinaryLogicalExpression gains a constructor. This means that extending this can no longer call super().

Applicable to BinaryLogicalExpression and UnaryLogicalExpression. 

Source Incompatibility: Yes
Binary Incompatibility: Yes
Functional Incompatibility: No

## Bugs
It is not mentioned that operations in the factory throw UnsupportedOperationsException. (Bad interface description)
