# Backwards Incompatibility Team 4

- Source Incompatibility is in the workspace "workspace" (V1) and workspace "workspace1" (V2). Marked with //SRC
- Binary Incompatibility is in the workspace "workspace3" (Contains suite and change jars). Run TestSuite Jar from Compiled. 
    * So first export to JAR using circeval.jar in seperate folder. 
    * Then change the lib jar with corresponding version
    * Run from command line using "java -jar testSuite.jar"
- Functional Incompatibility can be in all workspaces. Marked with //FUN


## Issue 1
Test Case: testPublicv1Version()

In the newer version the function evaluate is protected, while in the old version it was public. This means that the old code cannot compile against the new API. 

This holds for all Gates and the function evaluate().

Source Incompatibility: Yes
Binary Incompatibility: Yes
Functional Incompatibility: 

## Issue 2
Test Case: testAddedBoolOperator()
In the new version the function evaluate returns double, while in the old version it returns boolean. 

This holds for all Gates and the function evaluate().

Source Incompatibility: Yes
Binary Incompatibility: Yes
Functional Incompatibility: Yes, by using object and print it and check the assert()

## Issue 3
test Case: testCircuitResult()
The circuit return type is changed from boolean to Object. This leads to a compile error and a function result difference. 

This holds for the class Circuit

Source Incompatibility: Yes
Binary Incompatibility: Yes
Functional Incompatibility: Yes


## Issue 4
Test case: testInputDoubles

We can maybe create an input that allows for doubles and only converts them to booleans when the super method is not present. Thereby it will generate an IllegalArgumentException in the new API, but not in the old API. 

Source Incompatibility: No
Binary Incompatibility: No
Functional Incompatibility: Yes


## Bugs
The commented out code at test testX1andX2orNotX1 does not work and throws an IllegalArgumentException, because of the fact that you first use true and false as inputs (which make the gate.isBool true) and then use doubles, which makes the gate do not properly accept inputs (although they should be). More concrete this happens, when for the NotGate.isBool is false and AndGate.isBool is true. 