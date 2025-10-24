#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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

void printAtom(atom* a) {
    printf("Name: %s\nNumber: %d\nCoords: (%d, %d, %d)\n", 
            a->symbol, 
            a->number,
            a->coords.x,
            a->coords.y,
            a->coords.z);
}

int main(int argc, char** argv) {
    point3D p0 = {0, 0, 0};
    //printf("%d %d %d\n", p0.x, p0.y, p0.z);
    
    atom he = {"he", 2, {0,0,0}};
    printAtom(&he);

    atom* c = malloc(sizeof(atom));
    strcpy(c->symbol, "c");
    c->number = 6;
    c->coords.x = 1;
    c->coords.y = 1;
    c->coords.z = 1;
    printAtom(c);
    free(c);
}