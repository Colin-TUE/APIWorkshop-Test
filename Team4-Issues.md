# Backwards Incompatibility Team 4

## Issue 1
Test case: testPublicv1Version()

In the newer version the function evaluate is protected, while in the old version it was public. This means that the old code cannot compile against the new API. 

This holds for all Gates and the function evaluate().

Source Compatibility: Yes
Binary Compatibility: Yes
Functional Compatibility: Yes

## Issue 2
Test case: 