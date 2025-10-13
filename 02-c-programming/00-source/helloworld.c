#include <stdio.h>

// arc is the number of command line arguments that were passed in
// argv is an array of strings containing the command line arguments
int main(int argc, char** argv) {
    printf("Hello world!\n");
    int nums[10] = {2, 3, 5};
    //nums[0] = 2;
    //nums[1] = 3;
    //nums[2] = 5;

    // C does not initialize variables or arrays
    // C allows us to iterate past the end of an array!
    for(int i = 0; i < 10; i++) {
        printf("nums[%d]: %d\n", i, nums[i]);
    }

    printf("nums is stored at memory address %p\n", nums);

    int mem = 17;
    printf("mem stores %d\n", mem);
    // Use & to get memory address where a variable is stored
    // e.g, &mem gives the memory address where mem is stored.
    printf("that value is stored at memory address %p\n", &mem);
}