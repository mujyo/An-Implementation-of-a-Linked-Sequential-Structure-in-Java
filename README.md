# An-Implementation-of-a-Linked-Sequential-Structure-in-Java

When we represent a number on a computer we must allocate a fixed number of bits to it. The number of bits dictates the range of numbers that can be stored. This data limitation applies to all data types, and prevents us from storing large numbers.

Design and implement an interface BigNumber that defines the above operations, specifically with the following method signatures:

A method length that returns the number of digits in this number.

A method shiftLeft that takes the number of shifts as an argument and shifts this number to the left by that number. A negative number of left-shifts will correspond to those many right shifts.

A method shiftRight that takes the number of shifts as an argument and shifts this number to the right by that number. The number 0 can be right-shifted any positive number of times, yielding the same number 0. A negative number of right-shifts will correspond to those many left shifts.

A method addDigit that takes a single digit as an argument and adds.

A method getDigitAt that takes a position as an argument and returns the digit at that position. Positions start at 0 (rightmost digit). This method throws an IllegalArgumentException if an invalid position is passed.

A method copy that returns an identical and independent copy of this number.

A method add that takes another BigNumber and returns the sum of these two numbers. This operation does not change either number.

A method to compare two BigNumber objects for ordering. (Comment from Tom: implement the compareTo() method)


