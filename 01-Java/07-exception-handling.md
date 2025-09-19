# Exception Handling

The purpose of exception handling to guard our programs from crashing,
especially from circumstances outside of our control.

The exception handling syntax allows us to handle these cases gracefully.

We put "risky" code in a try block and we use a catch as our safety net.

## Quicky Syntax Tour

``` java
try {
    // risky code
} catch(Exception relevantException) {
    // what to do if risky code fails
}
```

Java provides an Exception Hierarchy for different types of exceptions
that can occur.

This allows us to easily catch and handle specialized exceptions.

If we are doing I/O, we'll probably have to handle `IOException`s.

```java
try {
    BufferedReader input = new BufferedReader(new File("myfile.txt"));
    char c = input.read() // can throw IOException
    // read in the file...
} catch(IOException e){
    e.printStackTrace();
    System.err.print(e.getMessage());
} 
```

## Finally Block & try-with-resources

```java
try {
    BufferedReader input = new BufferedReader(new File("myfile.txt"));
    char c = input.read() // can throw IOException
    // read in the file...
} catch(IOException e){
    e.printStackTrace();
    System.err.print(e.getMessage());
} finally {
    input.close(); // will not compile because close throws exception
}
```

The finally block is where we put code we want to ensure executes whether
an exception occurred or not. THis is usually clean-up code like closing files
to ensure that we don't have resource leaks.

```java
try {
    BufferedReader input = new BufferedReader(new File("myfile.txt"));
    char c = input.read() // can throw IOException
    // read in the file...
} catch(IOException e){
    e.printStackTrace();
    System.err.print(e.getMessage());
} finally {
    try {
        input.close(); // will not compile because close throws exception
    } catch (IOException e) {
        //...
    }
}
```

### Try-with-resources

```java
try (
    BufferedReader input = new BufferedReader(new File("myfile.txt"));
)
{
    char c = input.read() // can throw IOException
    // read in the file...
} catch(IOException e){
    e.printStackTrace();
    System.err.print(e.getMessage());
}
```

## Checked vs. Unchecked Exceptions

**Checked** exceptions are exceptions that we must handle. Java requires us
to handle them for the code to compile.

These are the exceptions that are our of our control like file IO failing.

We do not have to handle **unchecked** exceptions. These are things that are
logically avoidable (like divide by zero), and we should logically avoid them.

In the hierarchy, all subclasses `RuntimeException` are unchecked. Everything else
is checked. 