# Generics

Generics allow us to write and use classes that can
store/operate on any type as opposed to single types.

ArrayLists are generic.

```java
ArrayList<Potion> inventory = new ArrayList<Potion>();
```

In the above instantiation, we only technically need
to specify `Potion` on the left hand side.

Best practice is to specify on both sides. If you don't,
you could get wierd compiler warnings or errors.

## Purpose of Generics

The purpose of generics is to allow us to write a single class
that can operate on any type that we want it to.

As we know, java is strongly-typed. Any single variable can only hold
things that satisfy its type.

We could write our own list.

```java
public class IntList {
    private int[] lists;

    public IntList() {
        this.list = new int[100];
    }
}
```

```java
public class StringList {
    private String[] lists;

    public StringList() {
        this.list = new String[100];
    }
}
```

```java
public class List {
    private Object[] lists;

    public List() {
        this.list = new Object[100];
    }
}
```

In our `Object[]` list, we could store any object.

If this will fulfill the purpose of generics (creating a class that
can operate/store) any type, why go generics exist?

```java
public class List {
    private Object[] lists;
    private int size;

    public List() {
        this.list = new Object[100];
        this.size = 0;
    }

    public void add(Object obj) {
        this.list[size] = obj;
        this.size++;
    }

    public Object get(int index){
        return this.list[index];
    }
}
```

In our implementation, we can only add/retrieve objects of type `Object`.

Example:
```java
List list = new List();
list.add(new HealthPotion(12));
HealthPotion potion = list.get(0); // DNC, can't put Object in HealthPotion variable
```

```java
List list = new List();
list.add(new HealthPotion(12));
//...
HealthPotion potion = (HealthPotion)list.get(0);
```

This will compile and run correctly as long as the object actually is
a health potion. Otherwise, this program will crash at runtime.

This means that in many case, code like this will compile and run fine, but
every once in a while, it will crash at runtime.

We NEVER want our programs to crash.

What if we are writing avionics software, or medical devices.

People's lives depend on software, we want it to be robus. We want
to avoid all cases where it can crash.

This is why generics were introduced.

## Type Safety and Generics

Generics allow us to write programs that are flexible with their types, but
that java can verify at compile time to guarantee they are correct.

Generics are type safe. All problems with generics will be caught at compile
time.

Programming generics can be frustrating because we get more compiler errors,
but this is good.  We can work all issues in the safety of development instead
of the potential danger of production.

## Writing a generic class

```java
public class List<T> {
    private T[] list;
    //...
    public T get(int index) {
        return this.list[index]
    }
}
```

```java
List<Potion> inventory = new List<Potion>();
```