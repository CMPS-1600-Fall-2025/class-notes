# History

The C Programming Language is rely tied up with the origins of
computing as we know it today.

Its history is strongly intertwined with the orgins of the grandparent
of most modern operating systems: UNIX

In the late 1960's, Bell Labs (from A T&T) had free reign to do whatever
they wanted and as money as they needed.

They originated our modern operating systems.

At the time, computers were mainframes. They all had their own custom
operating system. They were operated using what is called batch processing.

Programs were run one at a time by feeding punch cards into these machines.

Colossaly inefficient. Most of the computer time was idle, waiting 
for the next punch card to be fed in.

To address this, "time-sharing" was developed. This is the idea of
allowing multiple users to connect to the computer at the same time, load
in their programs, then have the computer manage the order of executing.
It would look like multiple programs are running concurrently.

The development of an OS finally implementing this idea was spearheaded by
three institutions: MIT, GE, and AT&T.

They wanted to create a nation-wide computing utility. Everyone could pay
to have a terminal to connect to their mainframe and use it to run 
programs.

They called the project Multics and it was a failure. 

When Bell Labs pulled out the project in 1969, the CS department lost
access to the mainframe, but wanted to continue to work on this.

Four researchers in particular (Ken Thompson, Dennis Ritchie, 
Doug Mcllroy, and Joe Ossanna) believed in this project.

They worked on a PDP-7 from the finance department at nights to
continue development.

One of the reasons that it failed was that there was no programming
language that supported the features they needed to support
developing an OS.

First Pass, Thompson wrote a language called B, based off another
language BCPL.

**First Hello World Program**
``` B
main( ) {
    extern a, b, c;
    putchar(a); putchar(b); putchar(c); putchar('!*n');
}

a 'hell';
b 'o, w';
c 'orld';
```

Presented by Kernighan in *"A tutorial Introduction to the language B"*.

Major Con's of B:
- It has no data types, no int, char, long, etc...
- Designed explicitly for the hardware of previous machines,
all variables were 36 bit words.
- compiler produced inefficient assembly (machine readable)
code.

To address these issues, Dennis Ritchie wrote the C Programming language.

# So what is C?

C is a system's language, designed with OS development in mind.

## Familar Features

- variables and variable types
- arrays
- control structures
    - if-else
    - switch statements
    - while, do-while, for loops
    - break, continue
- functions
    - recursive functions

## Unfamiliar Features
- pointers
- structs and unions

## Not in C

- No objects or classes
- No access modifiers
- boolean
- string
- print statement

The actual core of C was intentionally kept very small.

Functionality like booleans and strings must be imported.

# C Programming

## Arrays

An array is a fixed chunk of consecutive memory we can store
data.

Each array is set in size. That is, it can not be expanded.

If we want it to grow, we have to create a larger copy.

The c compiler does not protext us from accessing outside
the bounds of an array. It is our job to safely use arrays.

``` c
int nums[10];
```

`nums` is a "pointer" that points to the beginning of the array. The
`nums` variable actually stores the memory address of the beginning of
the array.

Using index notation, we can access the values actually stored at
those locations.

## Pointers

We can request the memory address of a variable using the `&` operator.

If we have memory address and want to retrieve the thing stored there,
we use the `*` operator, aka the "dereference" operator.

We also use the `*` to declare a pointer.

```c
int *ptr; // this is a variable that points to an int in memory
```

`ptr` itself stores a memory address.

## Multidimensional Arrays

In C, we can create multidimensional arrays.

If we think about an array as a consecutive set of values,
a 2d array is like a table of values.

``` c
int arr[10]; // 10 values in memory
int arr2[4][5]; // a table with 4 rows and 5 columns
arr2[2][3] = 31; 
```

Another way of thinking about it is that a 2D array is an
array of arrays. Every row is an array with 5 elements.

Every row in our example above has the same number of columns.

Also, since the total size is known, memory for the entire array
is allocated whenever it is declared (more accurately, at compile time).

A very common use of 2D arrays is to store an array of strings.

Since a string is an array of characters, an array of strings is
an array of character arrays.

```c
char arr1[10][20]; // 10 strings of 20 characters.
```

To accommodate different length strings, we use pointers.

```c
char* arr2[10]; // an array of 10 strings.
```

To accommodate a list of strings where we don't know how many
there are (or how large they are) at compile time, we use
`char**`.

```c
char** argv; // an array of strings
```

`argv` points to the beginning of an array of strings. During
runtime, we can allocate enough pointers for the amount of strings
we'll have an enough memory for each string.

This could be useful for reading in a file of unknown length.

It is also used for reading in command line arguments for a program.

# Memory Allocation

At compile time, we don't always know how memory we will need.

It we need to create arrays or other structures in c and we don't
know how much memory will be needed, we can dynamically allocate that
memory. This is just requesting from the OS as much memory as we need.

We dynamically allocate memory using ther `malloc` function.

`malloc` takes in the number of bytes to allocate and it returns a
pointer to the beginning of the allocated memory, specifically a
void pointer: `void *`.

```c
int size = 15;
int* arr = malloc(size * sizeof(int));
```

Other than dynamically allocating memory, a second benefit is that 
the memory allocated by malloc will continue to exist even after
the function in which it was allocated returns.

We are responsible to releasing it when we are done with it. If we don't,
we'll have a **memory leak**.

To release memory allocated by `malloc`, we use `free()`;

After calling `free`, best practice is to set the pointer to `NULL` to
avoid a *dangling pointer*, a pointer into memory that we not longer own.

# Structs

A struct is a collection of related variables.

```c
typedef struct point3D {
    int x;
    int y;
    int z;
} point3d;
```