#include "Fish.hpp"

Fish::Fish(string name) : Animal(name) {

}

void Fish::reproduce(){
    cout << Animal::getName() << " reproduce by laying eggs" << endl;
}