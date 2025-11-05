#include "atom.cpp"

using namespace universe;

// Since this is pass by reference, modifying `a` here will modify the original
void moveAtom(Atom *a, int x, int y, int z) {
    a->coords->x += x;
    a->coords->y += y;
    a->coords->z += z;
}

// This is pass by value! a is a copy of the atom passed in. This function
// would move the copy, but the original will remain unchanged. pointless!
void moveAtom_foobar(Atom a, int x, int y, int z) {
    a.coords->x += x;
    a.coords->y += y;
    a.coords->z += z;
}

int main() {
    Atom *c = new Atom("c", 6, 0, 0, 0);
    Atom n("n", 7, 10, 10, 10);

    n.print();
    moveAtom(&n, 1, 1, 1); // pass by reference, n will be moved
    n.print();
    delete c;
}