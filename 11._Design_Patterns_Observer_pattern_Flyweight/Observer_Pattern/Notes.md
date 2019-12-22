# Observer Pattern

A behavioral design pattern that lets you define a subscription mechanism to notify multiple objects
about any events that happen to the object they’re observing.

Definition:
Defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are
notified and updated automatically.

Real world example: While you subscribe to a magazine, you will receive it by the mail every time it is printed.
As long as you keep being subscribed, it will happen automatically. When you unsubscribe, it will stop being sent to you.

Here are some examples of the pattern in core Java libraries:

    java.util.Observer/java.util.Observable (rarely used in real world)
    All implementations of java.util.EventListener (practically all over Swing components)
    javax.servlet.http.HttpSessionBindingListener
    javax.servlet.http.HttpSessionAttributeListener
    javax.faces.event.PhaseListener

###Design Principle:
-   Loose Coupling.

###Identification: 
The pattern can be recognized by subscription methods, 
that store objects in a list and by calls to the update method issued to objects in that list.