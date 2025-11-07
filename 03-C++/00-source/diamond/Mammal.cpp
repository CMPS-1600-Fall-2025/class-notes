#include "Mammal.hpp"

Mammal::Mammal(string name) : Animal(name){

}

void Mammal::reproduce(){
    cout << Animal::getName() << " reproduce by live birth" << endl;
}