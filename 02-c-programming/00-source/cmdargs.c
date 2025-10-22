#include <stdio.h>

int main(int argc, char** argv) {
    // argc is "arg count", the number of command line arguments
    // argv is an array of strings, one string per cmd line arg

    printf("There are %d cmd args\n", argc);
    for(int i = 0; i < argc; i++) {
        printf("argv[%d]: %s\n", i, argv[i]);
    }
}