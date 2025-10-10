#include <stdio.h>

// arc is the number of command line arguments that were passed in
// argv is an array of strings containing the command line arguments
int main(int argc, char** argv) {
    printf("Hello world!\n");
    int nums[10];
    nums[0] = 2;
    nums[1] = 3;
    nums[2] = 5;

    for(int i = 0; i < 11; i++) {
        printf("nums[%d]: %d\n", i, nums[i]);
    }
}