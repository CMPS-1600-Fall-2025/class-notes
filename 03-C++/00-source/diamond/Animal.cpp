#include "Animal.hpp"

Animal::Animal(string name){
    this->name = name;
}

string Animal::getName() {
    return this->name;
}