#Abstract Data Types

Abstract Data type (ADT) is a type (or class) for objects whose behaviour is defined by a set of value and a set of operations.

The definition of ADT only mentions what operations are to be performed but not how these operations will be implemented. 
It does not specify how data will be organized in memory and what algorithms will be used for implementing the operations. 
It is called “abstract” because it gives an implementation-independent view. 
The process of providing only the essentials and hiding the details is known as abstraction.

Think of ADT as a black box which hides the inner structure and design of the data type.

Amongst others, we know of the Interface ADT, Stack ADT and Queue ADT.

##Interface:
A list contains elements of the same type arranged in sequential order and following operations can be performed on the list.

-   get()
-   insert()
-   remove()
-   removeAt()
-   replace()
-   size()
-   isEmpty()
-   isFull()

### Abstract

We made an implementation of Arraylist, see it in the Abstract folder.

Remember that this implementation of the ADT Abstract is implemented using Generics.


## Graph
A graph is a data structure for storing connected data like a network of people on a social media platform.

A graph consists of vertices and edges. A vertex represents the entity (for example, people) 
and an edge represents the relationship between entities (for example, a person's friendships).

### Directed Graph

If these edges feature a direction in them, the resulting graph is known as a directed graph.
For an example, see graph2.jpg

### Weighted Graph
If these edges carry relative weight, this graph is known as a weighted graph.
For an example, see graph3.jpg


Abstract
