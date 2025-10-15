#include <stdio.h>

void foo() {
    int bar[10000] = {3,5};
    // arrays are just pointers into memory
    printf("bar is stored at %p\n", bar);
    // Access index 0 two ways:
    // dereference bar. since bar points to the beginning of the array,
    // dereferencing it gives the 0th element
    printf("*bar: %d\n", *bar);
    // use index notation
    printf("bar[0]: %d\n", bar[0]);

    // Access index 1 two ways:
    // pointer arithmetic allows us iterate forward in memory
    // iterate forward one spot in memory then dereference 
    printf("*(bar+1): %d\n", *(bar+1));
    // use index notation
    printf("bar[1]: %d\n", bar[1]);
    //return bar;
}

int main(int argc, char** argv) {
    int num = 17;
    int* ptr = &num;

    // Using pointer operators
    // can use the & to get a memory address
    printf("num is stored at memory address %p\n", &num);
    printf("ptr holds the memory address %p\n", ptr);
    // We can use * to dereference a pointer, i.e. get the value stored there
    printf("The value stores at ptr is %d\n", *ptr);

    foo();

    //int* ret = foo();
    //printf("bar[0] held %d\n", ret[0]);
}