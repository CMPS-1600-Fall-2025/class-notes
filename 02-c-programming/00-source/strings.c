#include <stdio.h>

int len(char* str) {
    // str = "h\0"
    int i = 0;
    while(*str != '\0') {
        i++;
        str = str + 1;
    }

    /* the above is equivalent to this:
    while(str[i] != '\0') {
        i++;
    }*/
    return i;
}

int main(int argc, char** argv) {
    char* str = "hello";
    printf("%s\n",str);

    printf("len(\"%s\"): %d\n", str, len(str));

    /*for(int i = 0; i < 4; i++) {
        printf("str[%d]: '%c'\n", i, str[i]);
    }*/

}