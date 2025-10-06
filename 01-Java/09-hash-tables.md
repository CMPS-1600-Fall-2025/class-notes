# Hash Tables, Maps, Dictionaries

A hash table is a data structure that maps keys to values.

## Operations

- put(K,V): insert this key value pair into the dictionary
    - python syntax: `d["key"] = "value"`
- get(K): get the value for this key
- contains(K): is this key in the dictionary

## Hash Table Efficiency

Hash Tables are extemely efficient.

`put()`, `get()`, `contains()`, are O(1).

### Hashing

If we have a list, aka an array, assignment or access at any individual index
is O(1).

An array is a sequence of data in memory all of the same type.

If we have an array of ints, each int is 32 bits large.

If we know the starting memory location of an array, and we want the 3rd 
int in the array, it's just arithmetic to find its memory location:

`arr[2] = ADDR of the array + 3 * sizeof(int)`

Calculating the address for an individual index and accessing it are O(1).

At the most fundamental level, we can thing of an array as a mapping between
indices and the values that are stored there.

A hash table generalizes this idea. It exploits the efficiency of an array for
its operations.

We can generalize as follows. If we want to store keys of any type, if we can
calculate an index for each key, we can efficiently store and access values
associated with those keys.

These index calculations are hashes.

To hash a key is to generate an index from it.

### Building a Hash Table

Hash tables are built on top of an array, and we use some hash function to place
our keys and their values into the array.

`d["key"] = "value"`

`"key"` is hashed to get an index in the underlying array.

Hash tables aren't filled sequentially. Values are placed throughout the hash
table based on the hash function.

### How do we hash?

How could we hash a string?

We could use the ascii values as input to some function to generate a single
number, e.g., summing them up.

Actual hash function strive to minimize **collisions**. A collision is when 
two keys has to the same index.

Some hash funcions are definitely better than others. The goal of
creating a hash function is to minimize collisions. 

We want to avoid placing values in the same spot in the hash table.

Avoiding all collisions is impossible. Why, we don't have inifinite space.

What are our strategies for minimizing and for handling collisions when they
exist?

## Minimizing Collisions

We minimize collisions by 

- using a good hash function
- choosing a good size for our hash table
    - should be prime

### Process for storing values:

```java
int capacity = 100
ArrayList l = new ArrayList(capacity);
int hash = obj.hashCode();

int index = hash % capacity;
```

To minimize collisions arising from using modulus, we choose our HashMap
capacities to be prime numbers.

## Dealing with collision

Collision are inevitable. How do we deal with them:

- Linear Probing
    - If an element already exists at some index, insert into the next index.
- Quadratic probing
- double hashing
- Separate Chaining
    - Every index maps to a list. We insert into that list.

## Efficiency of Separate Chaining

In the worst possible case, everything has mapped to the same hash value and
all elements are in a single linked list. Lookups would thus be O(n).

In practice, elements tend to end up distributed, especially if we do three
things:

- pick prime table size
- write a good hash function
- grow the table so that it always has plenty of free space

Doing these three things, the linked lists tend to only have a handful of
elements so the efficiency isn't really an issue.