#pragma once
#include "Animal.hpp"

class Fish: public Animal {
    public:
    Fish(string name);
    virtual void reproduce();
};