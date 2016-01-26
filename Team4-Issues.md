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

Source Incompatibility: Yes
Binary Incompatibility: Yes => show test case for that
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