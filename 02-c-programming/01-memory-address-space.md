# Memory Address Space

The OS gives every program a memory address space to store all its instructions
and data.

```
Low address
0x000000000000
 ----------
|   Code   |
|----------|
|   Heap   |
|----------|
|     |    |
|     v    |
|          |
|     ^    |
|     |    |
|----------|
|  Stack   |
 ----------
0xFFFFFFFFFFFF
High address
```

To the program this looks like a set of addresses it has access to, starting
from a low address `0x000000000000` and going up to a high address
`0xFFFFFFFFFFFF`.

These addresses are expressed in hexadecial for conciseness.

## Code Block

At the top of the address space is the **code block**. The code block stores
all of the instruction of the running program. When a program is run, each
instruction in turn is fetched from memory and executed on the CPU.

## Heap

Below the code block is the **heap**. The heap is a section of memory where
programs can store data that should live beyond the execution of a single
function. 

As context, every variable has a lifetime. By default, variables exist from
the line they are declared to the end of their current block.

e.g,

```c
void foo() {
    int num = 23;
    ...
}

int main(int argc, char** argv) {
    foo();
    ...
    return 0
}
```

`num` exists from the line it was defined to the end of `foo()`. It is 
no accessible in the `main()` method. Don't believe me? Test it!

Back to heaps. Program use the heap to store variables that should exist beyond
the scope of any individual function.

## Stack

The **stack** is where function local variables are stored. Local variables
are just those that are created in a function and not placed on the heap.

More specifically, when a function is called, a stack frame for that function,
containing space for all local variables and where it should return to, is
pushed onto the stack. The stack grows up in our diagram, from high addresses to
lower ones. When a function returns, it stack frame is popped off the stack.
This is why local variables only exist during a function call, because their
memory is released when the function returns!