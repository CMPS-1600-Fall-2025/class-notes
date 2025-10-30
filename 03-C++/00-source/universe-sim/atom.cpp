#include <iostream>
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

    void printAtom(atom* a) {
        std::printf("Name: %s\nNumber: %d\nCoords: (%d, %d, %d)\n", 
            a->symbol, 
            a->number,
            a->coords.x,
            a->coords.y,
            a->coords.z);
    }
}