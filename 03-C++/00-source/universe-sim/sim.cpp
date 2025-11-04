#include "atom.cpp"

using namespace universe;
int main() {
    Atom *c = new Atom("c", 6, 0, 0, 0);
    c->print();
    delete c;
}