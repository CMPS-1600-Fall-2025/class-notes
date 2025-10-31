# History

C++ was first implemented in 1979 as "C with classes" by
Bjarne Stroustrup at Bell Labs.

It was designed to keep the efficiency and low-level power of C, but to add on 
Object-Oriented Programming.

In comparison with other languages like java, C++ gives 
us the power of managing our own memory which makes it
more powerful, but more difficult to code. We must be careful
with our memory.

## Memory Management Java vs. C++

In java, memory management is handled automatically by the *garbage collector*. 
In C++, memory management is left directly in the hands of the programmer.

In Java, objects are removed from memory when there are no longer any references
to them from anywhere else. This is challenging and takes up overhead as
your program is running. As a result, Java is less efficient than C++ in terms
of memory footprint and program overhead as it is being executed.

In C++, as in C, we are responsible for managing our own memory. If we
allocate memory for our program, we must free it when we are done with it.
This eliminates the need for a garbage collector.

# Overview of our Intro to C++

In our brief introduction to C++, we discuss **namespaces**,
how to write classes and use inheritance, and C++'s implementation
of generics called **templates**.

## Namespaces

C++ does not have "packages" like java. It supports
namespaces.

A lesson learned from alot of experience writing C code is
that naming conflicts are difficult to deal with.

In C, we can include libararis like stdio.h, stdlib.h,
or mylibrary.h

When we include a library, all functions in that libary
are included in your compiled executable so that we can 
use them.

In C, if we include two separate libaries that both
define functions with the same name, we have a MAJOR PROBLEM.
Our program will not compile. We have a naming conflict.

What can we do as a programmer? One option is to only include
one of the libraries. If I really want to use both libraries,
my other option is to edit their source code to eliminate all
naming conflicts. Not good.

The hack amount library developers has been to make all of
their function names unique by apprending or prepending their
libary name to all function names. This works, but is a little
obnoxious.

In C++ we use namespaces to avoid naming conflicts. We can
define our classes and functions as belong to some namespace
and we then refer to our functions through our namespace.

If two libraries write use the same function names, no problem
because they are referred to uniquely by their namespace.

### Defining our own namespace

In atom.cpp:

```C++
namespace universe {
    typedef struct point3D {
        int x;
        int y;
        int z;
    } point3D;

    typedef struct atom {
        char symbol[3];
        int number;
        point3D coords;
    } atom;
}
```

in sim.cpp:
```C++
#include "atom.cpp"
int main() {
    universe::atom c = {"c", 6, {0,0,0}};
    universe::atom n = {"n", 7, {10,10,10}};
    universe::atom o = {"o", 8, {20,20,20}};
}
```

Alternatively, to avoid need to prepend `universe::` to every atom,
we can put `using namespace universe` at the top of our file.

```C++
#include "atom.cpp"
using namespace universe;
int main() {
    atom c = {"c", 6, {0,0,0}};
    atom n = {"n", 7, {10,10,10}};
    atom o = {"o", 8, {20,20,20}};
}
```

## Object-Oriented Programming in C++

Syntax for writing a class in C++

```C++
#include <iostream>
using namespace std;

namespace universe {
    typedef struct point3D {
        int x;
        int y;
        int z;
    } point3D;

    class Atom {
        string symbol;
        int number;
        point3D coords;

        public:
        Atom(string symbol, int number, point3D coords) {
            this->symbol = symbol;
            this->number = number;
            this->coords = coords;
        }

        void print() {
            cout << "Name: " << this->symbol << endl;
            cout << "Number: " << this->number << endl;
            cout << "Coords: (" << this->coords.x << ", " << this->coords.y << ", " << this->coords.z << ")" << endl; 
        }
    };
}
```

We can write classes all in a single file, but typically in C++,
we split classes into two files, the header and the source.

In the header goes the class definition (including all attributes
and methods) and in source go all method implementations.

**Atom Header:**
```C++
#include <iostream>
using namespace std;

namespace universe {
    typedef struct point3D {
        int x;
        int y;
        int z;
    } point3D;

    class Atom {
        string symbol;
        int number;
        point3D coords;

        public:
        Atom(string symbol, int number, point3D coords);
        void print();
    };
}
```

**Atom Source File:**
```C++
#include <iostream>
#include "atom.hpp"

using namespace std;
using namespace universe;

Atom::Atom(string symbol, int number, point3D coords) {
    this->symbol = symbol;
    this->number = number;
    this->coords = coords;
}

void Atom::print() {
    cout << "Name: " << this->symbol << endl;
    cout << "Number: " << this->number << endl;
    cout << "Coords: (" << this->coords.x << ", " << this->coords.y << ", " << this->coords.z << ")" << endl; 
}
```

In the source file we provide the definitions for the functions declared
in the header.

The syntax `Atom::printAtom` means the `printAtom()` function belonging to the
`Atom` class.

### Object Construction and Destruction

In C++, we can write :
- Constructors
- Copy Constructors
- Destructors

All three have default versions which are automatically provided if we don't
implement our own.

#### Constructors and Object Instantiation

When constructing objects, we can choose whether to build them on the **heap**
or the **stack**.

```C++
Atom *c = new Atom("c", 6, {0,0,0}); // created on the heap
Atom o("o", 8, {10, 10, 10}); // created on the stack
```

Pointer vs dot notation

```C++
c->print(); // user pointer notation since c is a pointer
o.print(); // user dot notation since o is NOT a pointer
```

When done with c, we must free it:
```C++
delete c;
```

#### Destructors

When we `delete` some object, its **destructor** is called and its memory
is released.

The purpose of a destructor is to release all dynamicaly allocated memory
that our object allocated for itself.

```C++
~Atom() {
    // deallocate all memory allocated by this object
}
```