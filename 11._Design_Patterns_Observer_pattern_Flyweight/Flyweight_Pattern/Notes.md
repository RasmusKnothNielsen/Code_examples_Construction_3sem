# Flyweight

###Usage examples: 
The Flyweight pattern has a single purpose: minimizing memory intake. 
If your program doesn’t struggle with a shortage of RAM, then you might just ignore this pattern for a while.

###Explanation of example:
In this example, we’re going to render a forest (1.000.000 trees)! 
Each tree will be represented by its own object that has some state (coordinates, texture and so on). 
Although the program does its primary job, naturally, it consumes a lot of RAM.

The reason is simple: too many tree objects contain duplicate data (name, texture, color). 
That’s why we can apply the Flyweight pattern and store these values inside separate flyweight objects (the TreeType class). 
Now, instead of storing the same data in thousands of Tree objects, 
we’re going to reference one of the flyweight objects with a particular set of values.

The client code isn’t going to notice anything since the complexity of reusing flyweight objects 
is buried inside a flyweight factory.

Examples of Flyweight in core Java libraries:

    java.lang.Integer#valueOf(int) (also Boolean, Byte, Character, Short, Long and BigDecimal)

###Identification: 
Flyweight can be recognized by a creation method that returns cached objects instead of creating new ones.

###Example. 
Trees in a forest

###Intrinsic state:
Fields that contain unchanging data duplicated across many objects. 
Ex: Name of tree type, color and texture.

###Extrinsic state:
Fields that contain contextual data unique to each object
Ex: X, Y and age.

###Applicability:
 Use the Flyweight pattern only when your program must support a huge number of objects 
 which barely fit into available RAM.
 

###Pros and Cons
Pros:
- Save lot of RAM, if program has tons of similar objects.

Cons:
- Code becomes much more complicated.
- Might become more CPU heavy.