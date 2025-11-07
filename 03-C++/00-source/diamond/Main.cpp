#include "Fish.hpp"
#include "Mammal.hpp"
#include "Whale.hpp"
#include "Animal.hpp"

int main(){
    Fish *f = new Fish("fish");
    f->reproduce();

    Mammal *m = new Mammal("mammal");
    m->reproduce();

    // Whale is both a Mammal and a Fish
    Whale *w = new Whale("whale");
    // can't do the following, ambiguous which to use:
    // Fish::reproduce or Mammal::reproduce
    //w->reproduce();  
}