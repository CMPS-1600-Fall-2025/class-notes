#include <iostream>
#include "atom.hpp"

using namespace std;
using namespace universe;

Point3D::Point3D(int x, int y, int z) {
    this->x = x;
    this->y = y;
    this->z = z;
}

string Point3D::toString() {
    string str = "(";
    str += to_string(this->x) + ", ";
    str += to_string(this->y) + ", ";
    str += to_string(this->z) + ")";
    return str;
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

// Copy constructor
// the idiom `const ClassName&` is required
// this is a "constant reference". This allows other to be passed by reference
// but prevents it from being modified
Atom::Atom(const Atom& other) {
    this->symbol = other.symbol;
    this->number = other.number;
    // create a deep copy so that this has its own copy
    this->coords = new Point3D(other.coords->x, other.coords->y, other.coords->z);
    //this->coords = other.coords; // shallow copy! This and other would point to the same coords
}

void Atom::print() {
    cout << "Name: " << this->symbol << endl;
    cout << "Number: " << this->number << endl;
    cout << "Coords: " << this->coords->toString() << endl; 
}