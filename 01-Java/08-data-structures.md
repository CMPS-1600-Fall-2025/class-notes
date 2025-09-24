# Data Structures

A **data structure** is an object which stores data and provides
operations to access and modify it.

Why are data structures important?

Data structures give us different ways of storing data that are
more or less efficient and easy to use depending on what you want to
do.

Your goal as you learn about data structures is to build up a
toolbox of various data structures that you can pick from to choose
the best one for any job.

## Stack

A **stack** is defined by its behavior.

We **push** elements onto the top of the stack and when we remove, or
**pop**, elements from the stack, we always take from the top.

Stack operations:

- push: add to the top of the stack
- pop: remove and return from the top of the stack
- peek: return the top element from the stack

### Implementation

If we implement our Stack using an array (ArrayList), pushing onto 
the stack is often O(1), but if the ArrayList is full, it is O(n).

pop'ing off of the stack is O(1).

Can we do better?

What if we use a LinkedList?

Inserting at the end of a LinkedList is always O(1).

Removing from the end of a LinkedList is also always O(1).

## Queue

A queue is a second fundamental but trivially simply data structure.

Like a stack, it is defined by its behavior.

Queues are processed by the order in which elements arrive, just like any
queue, just like a line at the grocery store.

### Operations

- add/enqueue/push: add an element onto the end of the queue
- poll/dequeue: returns and removes from the beginning of the queue
- peek: returning the element that would be polled

## Priority Queues AKA Heaps

A priority queue is a queue where elements have priority and are stored sorted
by their priority.

A heap is a Binary Tree where all nodes below each node are less than it.

Using a heap, the largest element is always at the root.