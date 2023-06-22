

# Avaj-Launcher

![enter image description here](https://cdn.intra.42.fr/document/document/15910/avaj_uml.png)
***figure 1.0*** *(Unified Modeling Language diagram)*

## Introduction

The Avaj-launcher project focuses on simulating the behavior of aircraft in a simplified world. It provides a platform to understand and implement object-oriented programming concepts, particularly in the context of aviation and air traffic control.

The goal of Avaj-launcher is to create a simulation that allows users to manage a set of aircraft and their interactions within the simulated airspace. The project aims to replicate real-world scenarios such as aircraft taking off, landing, and flying, as well as simulating weather conditions that may affect flight operations.

## What i learned from this project

In this project we have implement a trivial algorithm for calculating and updating aircraft positions, handling weather changes, and managing communication between aircraft and the control tower.

Through the Avaj-launcher project, i gain experience in theses fields :

 - Design patterns such as (Observer, Singleton and Factory design patterns)
 - SOLID principles
 - Custom Exceptions
 - Designing and implementing complex systems
 - Practicing object-oriented programming principles
 - UML Analysis

**<u>Design patterns such as (Observer, Singleton and Factory design patterns) :</u>**

**Singleton Pattern**
The Singleton pattern is used to restrict the number of instances of a class to a single object, allowing the use of only one instance of an object within the application.

The Singleton pattern is useful in the following cases:

**a. A subset of other patterns:**

With Abstract Factory, Builder, Prototype, etc. For example, in the application, we want a single Factory object to create objects of a certain type. Instead of global variables, a singleton is preferred over global variables because, among other reasons, it does not pollute the global namespace with unnecessary variables.

Singleton is often used in situations where we need to access objects from multiple places in the application:

-   Logger objects
-   Objects that are shared resources (connections, sockets, etc.)
-   Configuration objects for the application
-   Factory objects.

The application of the Singleton pattern involves implementing a method that creates a new instance of the class if it doesn't exist, and returns a reference to that instance if it already exists. In Java, to ensure a single instantiation of the class, the constructor must be private and the instance must be provided by a public static method.

**Factory**
Factory patterns are used for objects that generate instances of related classes (implement the same interface, inherit from the same abstract class). They are used when we want to isolate the object that needs an instance of a certain type, to effectively create it.

Furthermore, the class that uses the instance doesn't need to specify the exact subclass of the object to create, so you don't need to know all the implementations of that type, but only the characteristics of the object to create. For this reason, the Factory is part of the creational design patterns category as it provides a solution for creating objects.

Applicability:

-   In libraries/APIs, the user is separated from the actual implementation type and needs to use factory methods to obtain certain objects.
-   When object creation is more complex (multiple steps need to be performed, etc.), it is more useful to separate the logic needed to instantiate the subclass of the class that needs that instance.

**Observer Pattern**
The Observer pattern defines a 1-to-n dependency between objects so that when one object changes its state, all its dependents are notified and updated automatically. The use of this pattern involves the existence of a subject object that has a list of dependent objects as observers, which it automatically calls whenever an action occurs.

This pattern is behavioral because it facilitates better organization of class communication based on their roles/behavior.

The observer is used when multiple classes (observers) depend on the behavior of another class (subject) in situations such as:

One class implements/represents the logic, the basic component, and other classes only use its results (observing). A class performs actions that can then be represented in multiple ways by other classes. Practically, in all these situations, the Observer classes observe the changes/actions of the Subject class. Observation is implemented through notifications initiated from the methods of the Subject class.

**<u>SOLID principles :</u>**

Here are the five SOLID principles with their corresponding Wikipedia links:

1.  Single Responsibility Principle: This principle states that a class should have only one reason to change. Each class should be responsible for a single functionality or aspect of the system. Wikipedia link: [Single Responsibility Principle](https://en.wikipedia.org/wiki/Single-responsibility_principle)
    
2.  Open/Closed Principle: This principle states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. It means that new features should be added without modifying existing code. Wikipedia link: [Open/Closed Principle](https://en.wikipedia.org/wiki/Open/closed_principle)
    
3.  Liskov Substitution Principle: This principle states that objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program. Subtypes must be substitutable for their base types. Wikipedia link: [Liskov Substitution Principle](https://en.wikipedia.org/wiki/Liskov_substitution_principle)
    
4.  Interface Segregation Principle: This principle states that clients should not be forced to depend on interfaces they do not use. It promotes the idea of segregating interfaces into smaller, focused ones, tailored to the needs of clients. Wikipedia link: [Interface Segregation Principle](https://en.wikipedia.org/wiki/Interface_segregation_principle)
    
5.  Dependency Inversion Principle: This principle states that high-level modules should not depend on low-level modules; both should depend on abstractions. It promotes the use of interfaces or abstract classes to decouple components and allow for easier changes and flexibility. Wikipedia link: [Dependency Inversion Principle](https://en.wikipedia.org/wiki/Dependency_inversion_principle)

**<u>Custom Exceptions </u>:**

Here is an example of a custom exception:

    public class AvajCoordinateException extends Exception {
	    public AvajCoordinateException(String errorMessage) {
		    super(errorMessage);
	    }
    }

The principle is simple, we will extend the base class and define a new case.
Here is a diagram that shows how exceptions are organized in Java :

![enter image description here](https://lh6.googleusercontent.com/UuHJjdra7T1cHIuicA8GgpV9lPA0k7BkXmpgwXt68Eb_d29iEzBzKnPtX8r4Qs4a3GwT-_GW404bGv8F-VLhBfTer0hhbLnwtQwgC4g7GlCe1oL8naJ7c_j6as_po6DPfAQhxETOnQULknrZRA)

**<u>UML Analysis</u>**

UML stands for Unified Modeling Language. It is a standardized visual language used in software engineering to design, document, and communicate the structure, behavior, and interactions of complex systems.

In our case, we need to analyze a UML diagram in order to implement it in Java, here are the diagrams that explain the symbols and notations.

![enter image description here](https://cdn-images.visual-paradigm.com/guide/uml/uml-class-diagram-tutorial/07-relationships-between-classes.png)
***Figure 1.1*** (*Relationships-between-classes*)

![enter image description here](https://study.com/cimages/multimages/16/access_modifiers_in_class_diagrams.png)
***Figure 1.2*** (*Access modifiers*)