# Unit Testing

Up until now, we test our programs simply by running them as we write them.

We provide some input and if our program produces the correct output,
we assume that it is good to go. That it works!

An improved way to test is to put specific thought into our tests and test over
various inputs in an attempt to rigorously test.

We don't want to manually do this in the middle of our programming workflow.

It's much better to think through your tests before hand, code them up, and
then be able to run them at will as you program.

This is know as **Test-Driven Development** and we do it with **Unit Tests**.

A couple of benefits of Test-Driven Development:

- It allows you to be bold in updating your programs because you can easily
and rigorously verify that you haven't broken anything
- It serves as a checklist for your implementation. When you pass all tests,
that feature is complete
- It forces you to deeply think though your implemenation before you even
start programming
- It results in more rigorous tests because you are not already biased by
your implementation.

# JUnit

Unit test: A unit test is a test for a particular "unit" of code, usually
an individual method.

We typically add a unit test for every non-trivial method in our software.

The idea behind unit testing is that if all of our methods are correct, 
our software is probably correct. In any case, it allows us to quickly and
precisely identify and fix issues.