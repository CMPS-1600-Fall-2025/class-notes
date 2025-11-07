#pragma once

#include <iostream>
using namespace std;

class Animal {
    string name;
    
    public:
    Animal(string name);
    // reproduce is overridable (virtual) and abstract (= 0)
    virtual void reproduce() = 0;
    string getName();
};