# Inheritance

If we have multiple classes that share functionality, we should pull
the common functionality into a **superclass**.

Our original classes now become **subclasses** and we can have them *inherit*
the common functionality from the superclass.

In our game, `Hero` and `Villain` are very similar. We pull the common data and
functions into a `Character` superclass.

For example, since they both have identical `takeDamage` fuctions, move it
into the `Character` class and `Hero` and `Villian` will inherit it.

## Constructors

When a subclass is instantiated, its superclass must also be instantiated.

We can do this explicitly or implicitly.

To instantiate the superclass explicitly, we call on the `super()` function
and pass in the arguments required by our superclass constructor.

If we don't explicitly do this, then java will call on the default constructor
which takes no paramters.

### Default Constructor 

When we write a class, if we don't write a constructor, java provides a 
default constructor. It takes no parameters and does nothing.

If we write our own constructor, java will NOT provide the default constructor.

## Overriding methods

If we write a method in a super class, that method will be inherited by
all subclasses. If a subclass wants its own specific behavior, it can 
**override** the method by writing its own version with its specific behavior.

The overridden method must have the same name and take in the same parameters.

It is best practice to put the `@Override` annotation above all
override methods. It will catch and force you to fix a common overriding
pitfall, overloading methods instead of overriding them.

Example:

In subclass Hero:

```java
    @Override
    public void takeTurn(Character other) {
        // ...
    }
```

### Overloading methods

If a method has the same name but takes in different parameters, that method
has been **overloaded**.

There are cases where it is useful to have methods with the same name but
different parameters. As an example, see the absolute value function
`abs()` in [Java's Math library](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html).