#include <stdio.h>

typedef struct point3D {
    int x;
    int y;
    int z;
} point3D;

int main(int argc, char** argv) {
    point3D p0 = {0, 0, 0};
    printf("%d %d %d\n", p0.x, p0.y, p0.z);
}