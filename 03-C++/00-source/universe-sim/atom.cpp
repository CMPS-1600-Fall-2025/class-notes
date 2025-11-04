#include <iostream>
#include "atom.hpp"

using namespace std;
using namespace universe;

Point3D::Point3D(int x, int y, int z) {
    this->x = x;
    this->y = y;
    this->z = z;
}

Atom::Atom(string symbol, int number, int x, int y, int z) {
    this->symbol = symbol;
    this->number = number;
    this->coords = new Point3D(x, y, z);
}

Atom::~Atom() {
    // we need to deallocate any memory that we allocated for our atom,
    // our Point3D!
    delete this->coords; // we don't need to write a Point3D destructor
                         // because our Point3D never allocates any memory for
                         // itself
}

void Atom::print() {
    cout << "Name: " << this->symbol << endl;
    cout << "Number: " << this->number << endl;
    cout << "Coords: (" << this->coords->x << ", " << this->coords->y << ", " << this->coords->z << ")" << endl; 
}