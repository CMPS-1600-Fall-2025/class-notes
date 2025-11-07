#pragma once

#include "Animal.hpp"

class Mammal: public Animal {
    public:
    Mammal(string name);
    virtual void reproduce();
};