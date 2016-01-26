# Backwards Incompatibility Team 4

## Issue 1
Test case: testPublicv1Version()

In the newer version the function evaluate is protected, while in the old version it was public. This means that the old code cannot compile against the new API. 

This holds for all Gates and the function evaluate().

Source Incompatibility: Yes
Binary Incompatibility: Yes => To run this actually

## Issue 2
Test case: testAddedBoolOperator

In the new version the function evaluate returns double, while in the old version it returns boolean. 

This holds for all Gates and the function evaluate().

Source Incompatibility: Yes => TBD if it really is source incomb => testCircuirResult similar
Binary Incompatibility: Yes => show test case for that => testCircuirResult similar
Functional Incompatibility: Yes => show test case for this by using object

## Issue 3 => To be tested and checked if it is an issue
Test case: testAddedBoolOperator

In the new version there is an attribute isBool and this was not present in the old version. Hence we can create an extension with this attribute of a different type or scope and it will not compile in the new one. 

This holds for all Gates and the attribute isBool.

Source Incompatibility: TBD
Binary Incompatibility: TBD
Functional Incompatibility: TBD

## Issue 4
Test case: testCircuitResult

The circuit return type is changed from boolean to Object. This leads to a compile error and a function result difference. 

This holds for the class Circuit

Source Incompatibility: Yes
Binary Incompatibility: TBD
Functional Incompatibility: Yes


## Issue 5
Test case: testInputDoubles

We can maybe create an input that allows for doubles and only converts them to booleans when the super method is not present. Thereby it will generate an IllegalArgumentException in the new API, but not in the old API. 

Source Incompatibility: TBD
Binary Incompatibility: TBD
Functional Incompatibility: TBD


## Bugs
The commented out code at test testX1andX2orNotX1 does not work and throws an IllegalArgumentException, because of the fact that you first use true and false as inputs (which make the gate.isBool true) and then use doubles, which makes the gate do not properly accept inputs (although they should be). More concrete this happens, when for the NotGate.isBool is false and AndGate.isBool is true. 