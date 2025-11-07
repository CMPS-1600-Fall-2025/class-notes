#pragma once
#include "Fish.hpp"
#include "Mammal.hpp"

class Whale: public Fish, Mammal {
    public:
    Whale(string name);
};