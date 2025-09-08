# The `static` Keyword

Class members (jargon that includes both variables and methods) can be declared
as `static`.

A `static` variable belongs to the *class* it was defined in as opposed to 
an individual object created from that class.

For example:

```java
public class Sim {
    private static int population = 0;
    private String name;

    public Sim(String name) {
        this.name = name;
        Sim.population++;
    }

    public void passToTheGreatBeyond() {
        Sim.population--;
    }

    public static getPopulation() {
        return Sim.population;
    }
}
```

In this `Sim` class, `name` is an instance variable. That is, every object,
or "instance" of this class has its own copy of `name`.

`population` in contrast is a class variable. There is one copy of this variable
shared by all instances of `Sim`.

We access static variables through the class itself rather than through specific
objects of the class. Hence, when a `Sim` is constructed (i.e. born), we
increment `Sim.population`, acccessing `population` through class `Sim`.

## Lifespan of instance and static members

Since instance variables belong to specific objects, they only exist as long
as their containing object exists.

In contrast, since `static` members are not bound to specific objects and
exist for the whole run of the program.

In our Sims example above, even before we instantiate the first `Sim` object,
we can access the static method `getPopulation()`.

```java
public class SimsGame {
    public static void main(String[] args) {
        System.out.println("There are {} Sims.", Sim.getPopulation())
        // ^ prints: There are 0 Sims.

        Sim aaron = new Sim("Aaron");
        System.out.println("There are {} Sims.", Sim.getPopulation())
        // ^ prints: There are 1 Sims.
    }
}
```
## Static methods

As we've seen, methods can be static too. You may have noticed that the `main()` 
method is always static. Why?

Static class members exist before any objects have been created. The `main()`
method, being the start of every java program, must exist before any object
is created and so must be static.

**Important Consequence**

Since static methods exist before objects are created, static methods can 
**not** call on instance methods directly.

What?

Example:

```java
public class Sim {
    private static int population = 0;
    private String name;

    public Sim(String name) {
        this.name = name;
        Sim.population++;
    }

    public void passToTheGreatBeyond() {
        Sim.population--;
    }

    public String getName() {
        return this.name;
    }

    public static getPopulation() {
        String ummm = getName(); // will not compile!
        return Sim.population;
    }
}
```

`getPopulation()` can not call on instance method `getName()`. Since
`getPopulation()` belongs to `Sim` as a whole, which instance of Sim could
`getName()` even be referring to?

Also, as we saw, we can call on `getPopulation()` before any Sims have been
instantiated so this makes no sense.

### Common pitfall

If you want your main method to be able to directly call on other methods,
make sure they are static.

E.g.

```java
public class SimsGame {
    public static void main(String[] args) {
        startGame(); // a static method!
    }

    public static void startGame() {
        // ...
    }
}
```