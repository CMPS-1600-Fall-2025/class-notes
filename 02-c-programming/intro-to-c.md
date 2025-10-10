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

