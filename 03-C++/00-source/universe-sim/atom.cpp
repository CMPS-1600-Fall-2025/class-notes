#include <iostream>
#include "atom.hpp"

using namespace std;
using namespace universe;

Atom::Atom(string symbol, int number, point3D coords) {
    this->symbol = symbol;
    this->number = number;
    this->coords = coords;
}

void Atom::print() {
    cout << "Name: " << this->symbol << endl;
    cout << "Number: " << this->number << endl;
    cout << "Coords: (" << this->coords.x << ", " << this->coords.y << ", " << this->coords.z << ")" << endl; 
}