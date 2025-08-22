# Variable tpyes and size

In java (and other languages), variables have specific types. This is different
than python where we can just declare a variable and assign anything into it.

Java has **primitive types** which hold a single value and **reference types**
which refer to objects.

Some common primitives are `int`, `long`, `float`, `double`, `char`.

`int` and `long` both store whole numbers. The difference between them is
the range of numbers they could store.

For an `int`, this is roughly -2 Billion to +2 Billion. For a `long`, it is
much larger. 

The range that a type can store is determined by its size. Every variable is
stored in memory as bits, and the number of bits used determines the number of
possible values that can be represented by that type.

For example, a `byte` is 8 bits and can store a max of 256 different values.

Why? With one bit, we can represent 2 values since a bit is either 0 or 1.

With four bits, we can represent four different values:

00 - 0
01 - 1
10 - 2
11 - 3

And with 3 bits, 8 values, and so on.