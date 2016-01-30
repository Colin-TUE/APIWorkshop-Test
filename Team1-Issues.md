# Backwards Incompatibility Team 1

- Source Incompatibility is in workspace "workspace5" (V1) and "workspace6" (V2)
- Binary Incompatibility is in the workspace "workspace7" (Contains suite and change jars). Run TestSuite Jar from Compiled. 
    * So first export to JAR using circeval.jar in seperate folder. 
    * Then change the lib jar with corresponding version
    * Run from command line using "java -jar testSuite.jar"

## Issue 1
Test Case: TestAnd_OR1() and your own test methods

assertFalse is no longer accepted, as eval() returns an Object and no longer a boolean.  

Applicable to Gate and all inherited classes. 

Source Incompatibility: Yes
Binary Incompatibility: Yes
Functional Incompatibility: No

## Issue 2
Test Case: TestGateInterface() => TestAnd_OR1()

In the new version gate is an abstract class and not an interface anymore

Applicable to Gate

Source Incompatibility: Yes
Binary Incompatibility: Yes
Functional Incompatibility: No

## Issue 3
Test Case: testNot()

In the new version all operations are made generic. This means that if we extend a gate in the old API and make that generic, it will collide with the new version of a gate. 

Applicable to all Gates

Source Incompatibility: Yes
Binary Incompatibility: Yes
Functional Incompatibility: No

## Bugs
GTE should be in the domain of the user and not in your package.

Cannot create the circuit first and later change the inputs and only call evaluation once. You need to change all the inputs of all gates to be able to recompute the outcome.

Apparently assertFalse is not recognized the new version of the client. 