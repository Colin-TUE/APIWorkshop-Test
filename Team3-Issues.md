# Backwards Incompatibility Team 4

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
