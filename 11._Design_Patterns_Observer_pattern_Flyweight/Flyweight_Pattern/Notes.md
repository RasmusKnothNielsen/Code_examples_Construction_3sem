# Flyweight

###Usage examples: 
The Flyweight pattern has a single purpose: minimizing memory intake. 
If your program doesn’t struggle with a shortage of RAM, then you might just ignore this pattern for a while.

Examples of Flyweight in core Java libraries:

    java.lang.Integer#valueOf(int) (also Boolean, Byte, Character, Short, Long and BigDecimal)

###Identification: 
Flyweight can be recognized by a creation method that returns cached objects instead of creating new.

###Example. 
Trees in a forest

###Intrinsic state:
Fields that contain uncharging data duplicated across many objects. 
Ex: Name of tree type, color and texture.

###Extrinsic state:
Fields that contain contextual data unique to each object
Ex: Height, Width and age.

###Applicability:
 Use the Flyweight pattern only when your program must support a huge number of objects 
 which barely fit into available RAM.
 

###Pros and Cons
Pros:
- Save lot of RAM, if program has tons of similar objects.

Cons:
- Code becomes much more complicated.
- Might become more CPU heavy.