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