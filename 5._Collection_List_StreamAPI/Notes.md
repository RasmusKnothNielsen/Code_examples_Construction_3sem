# Collection List and Stream API


## Collection List

The Java.util.List is a child interface of Collection. 
It is an ordered collection of objects in which duplicate values can be stored. 
Since List preserves the insertion order, it allows positional access and insertion of elements. 

List Interface is implemented by the classes of 
-   ArrayList 
-   LinkedList 
-   Vector 
-   Stack.

List Interface extends Collection, hence it supports all the operations of Collection Interface, 
along with following additional operations:
-   add(int index, Object o)
-   addAll(int index, Collection c)
-   remove(int index)
-   get(int index)
-   set(int index, Object new)
-   indexOf(Object o)                   - returns first occurrence
-   lastIndexOf(Object o)               - returns last occurence or -1 if none
-   sublist(int fromIndex, int toIndex) - returns a List view of specified list


## Stream API

Streams provide a clean an simple way to iterate over a collection.
The advantage of using a stream instead of a for each loop or the like, is that it is faster.
It does this by doing the intermediate operations in a lazy manner, until a terminate operation is called.
When this terminate operation is called, we apply all the intermediate operations in chronological order,
and only when we reach the end, we use the terminate operation.

An example could be if we take an arraylist of booknames, we want to only display all the books that starts with a "K" 
and ends with "e".
See BooksExample in StreamAPI.
With many filters (Analogues to if statements in for each loops), its easier to read the Stream than for each.
It is also more computational efficient, than using for each loops.
Is is more efficient, because we only call the terminate operation once, 
and not every time we cycle through the for each loop.


From Anders Github:

Streams are:
-   Not a data structure
-   Designed for lambdas
-   Do not support indexed access
-   Can easily be outputted as arrays or lists
-   Lazy access supported
-   Parallelizable



Intermediate operations
    intermediate operations return the stream itself
map, filter, sorted

    Filter method is an example of a lazy method.
    Each intermediate operation (Filter) creates a new stream, 
    stores the provided operation/function and return the new stream.
    
    The pipeline accumulates these newly created streams.
    
    The time when terminal operation is called, traversal of streams begins 
    and the associated function is performed one by one.

.
```
Map
```

Terminal Operations
        terminal operations return a result of a certain type
collect, forEach, reduce, orElseThrow(NoSuchElementException::new)
allMatch, anyMatch, noneMatch
partitioningBy, groupingBy

