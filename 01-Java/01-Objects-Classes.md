# Classes & Objects

Just as in python, java supports classes and objects. In fact, java is designed
from the ground up to support Object Oriented Programming.

An object at the highlest level is a collection of data (i.e. properties) and
methods that we can call on it.

Examples in python are strings, lists, dictionaries. Anything that we can call
a function on is an object.

e.g. in python
```python
name = "KeyChain"
capitalized_name = name.upper()
print(capitalized_name)
```

Code will output:

```
KEYCHAIN
```

`name` is an object in python. Its data is the list of characters that make it
up and `upper()` is one of many functions we can call on it.

Objects allow us to abstract away the underlying complexity and write our
programs at a high level and in a readable fashion.

## Classes

We can define our own objects by writing classes.

A class will have
1. class variables
2. a constructor
3. a set of methods to interact with this object

### Example, a most basic Hero class

``` java
public class Hero {
    private String name;
    private int hp;
    private int damage;

    public Hero(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }
}
```

#### Instance Variables

The class variables, which we will refer to as "instance" variables are defined
at the top of the class. Best practice is to define all instance variables as
`private`. You could defined them otherwise, but should have a very good reason
to do so.

Java is designed to leverage the power of abstraction. When another part of the
program is interacting with a `Hero` (or any other object), it should not care 
*how* the class is implemented, not even what its variables are, only the 
**ways** the object can be interacted with, i.e. the methods that can be called
on it. For this reason, we hide the actual implementation, the underlying way
we store the data, and expose only methods to interact with that data.

As a (great) consequence, if we decide to change the implementation, e.g. 
changing the way we track and update health, we only
need to update the class itself rather than every other class that directly 
accessed say the `hp` variable which may now be obsolete. By hiding our
implementation and only exposing methods to interact with a class, we make it
much easier to change our implementation in the future.

This also lets us control precisely which access we grant. For example, we may
want to grant the ability to see our Hero's name, but not allow other classes
to edit the name.

#### Constructor

The **constructor** for a class always has the same name as the class. Its job
is to give initial values to the classes instance variables.

We have written `Hero` so that when we instantiate a `Hero` object, we will
pass in the name, hp, and damage. The variables `name`, `hp`, and `damage`
defined as the parameters for the constructor are all local variables to the
constructor and are distinct from the instance variables (even though they are
named identically).

In any method of a class, including the constructor, we can explicity refer to
an instance variable using the `this` keyword.

The instruction `this.name = name` assigns the value from the local parameter
`name` into the class instance variable `name`.

### Adding methods to our class

With our basic class implemented, we can implement methods to add functionality
to it.

The most simple example would be queries or "getters" to retreive information
from a class. E.g:

```java
public String getName(){
    return this.name;
}
```

`Public` means this method is accessable outside of our class. `String` is the
return type, i.e., this method returns a String. It takes no parameters and
simply returns the value of this class's `name` instance variable.

A more complex example is adding `attack()` and `takeDamage()` to allow our `Hero` to
attack a `Villain` and take damage from villain attacks.

``` java
public void attack(Villain villain) {
    System.out.printf("%s attacks %s for %d damage.\n", 
                        this.name, 
                        villain.getName(), 
                        this.damage);
    villain.takeDamage(this.damage);
}

public void takeDamage(int damage) {
    this.hp -= damage;
    // hp can not be negative
    if(this.hp < 0) {
        this.hp = 0;
    }
    System.out.printf("   %s has %d HP left\n\n", this.name, this.hp);
}
```

After implementing these methods and the `isAlive()` method (see Hero.java),
we've substantially abstracted away this complexity into our `Hero` class.

Doing the same for `Villain`, we can then simplify our game loop. This
simplification is immediate, but will also pay dividends as we implement more of
our game.

By having simply objects to deal with, we can write simple logic to use them
