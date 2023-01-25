# An-Implementation-of-a-Linked-Sequential-Structure-in-Java

When we represent a number on a computer we must allocate a fixed number of bits to it. The number of bits dictates the range of numbers that can be stored. This data limitation applies to all data types, and prevents us from storing large numbers.

One way to represent a number is in terms of its digits, similar to how int is stored in terms of bits, or how a String represents a sequence of characters. In this assignment you will represent large integral numbers in a linked list representation. Instead of storing bits, we store individual digits (0-9) in a single node of such a list. We can store them in any order (corresponding to big-endian and little-endian in bit representation). For example, the number 32411 can be stored as 3 -> 2 -> 4 -> 1 -> 1 or 1 -> 1-> 4 -> 2 -> 3.

Given an integral number, we can shift its digits to the left or right. For example 32411 can be left-shifted to get the number 324110. Thus left-shifting by one position is equivalent to multiplying the number by 10 (similar to how left-shifting by one bit in a binary representation multiplies the number by 2). Similarly, 32411 can be right-shifted to get the number 3241, which is the integer-division by 10.

We can support basic addition of a single digit to a number. For example 324115 + 7 = 324122. Shifting and adding single digits can allow us to create arbitrarily large numbers, one digit at a time. For example 32411 can be created by:

Start with 0.
Left-shift by 1 position, and add 3
Left-shift by 1 position (to get 30) and add 2
Left-shift by 1 position (to get 320) and add 4
Left-shift by 1 position (to get 3240) and add 1
Left-shift by 1 position (to get 32410) and add 1
Numbers can also be added by using simple arithmetic: start from the right-most digits and add them. Record the sum and carry, and add the carry to the next pair of digits, and so on. Note that the numbers may be of different lengths.

Design and implement an interface BigNumber that defines the above operations, specifically with the following method signatures:

A method length that returns the number of digits in this number.

A method shiftLeft that takes the number of shifts as an argument and shifts this number to the left by that number. A negative number of left-shifts will correspond to those many right shifts.

A method shiftRight that takes the number of shifts as an argument and shifts this number to the right by that number. The number 0 can be right-shifted any positive number of times, yielding the same number 0. A negative number of right-shifts will correspond to those many left shifts.

A method addDigit that takes a single digit as an argument and adds (Tom's note: like addition in math, not like append in String!!!) it to this number. This method throws an IllegalArgumentException if the digit passed to it is not a single non-negative digit.

A method getDigitAt that takes a position as an argument and returns the digit at that position. Positions start at 0 (rightmost digit). This method throws an IllegalArgumentException if an invalid position is passed.

A method copy that returns an identical and independent copy of this number.

A method add that takes another BigNumber and returns the sum of these two numbers. This operation does not change either number.

A method to compare two BigNumber objects for ordering. (Comment from Tom: implement the compareTo() method)


