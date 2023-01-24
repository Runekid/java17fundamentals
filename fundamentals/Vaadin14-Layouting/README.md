# Vaadin 10+ Layouting training

This is the training material for the Vaadin 10+ layouting training. It's a multi-module maven project which contains 2 sub modules: exercises and solutions.
It also contains the instructions for doing the exercises in the [exercises.pdf](exercises.pdf) file, and a pdf version of the slides in the [handout.pdf](handout.pdf) file

### Prerequisites

JDK 8 or later and [Node.js 10](https://nodejs.org/en/download/) 

If you plan to run the applications from the command line, you need to install [Maven](https://maven.apache.org)

### Instructions

Import the Maven project to your Favourite IDE. We recommend using [Eclipse](https://eclipse.org/) or [IntelliJ IDEA](https://www.jetbrains.com/idea/).

* [How to import a Maven project in IntelliJ IDEA](https://vaadin.com/tutorials/import-maven-project-intellij-idea)
* [How to import a Maven project in Eclipse](https://vaadin.com/tutorials/import-maven-project-eclipse)
* [How to import a Maven project in NetBeans](https://vaadin.com/tutorials/import-maven-project-netbeans)


You are supposed to do the exercises on the exercises sub-module and follow the the instructions in the [exercises.pdf](exercises.pdf) file.

To run the exercises, run the Maven goal `jetty:run` on the exercises module in your favorite IDE or alternatively in the command line as

```
cd exercises
mvn jetty:run
```

To run the solutions, run the Maven goal `jetty:run` on the solutions module in your favorite IDE or alternatively in the command line as

```
cd solutions
mvn jetty:run
```

By default, jetty is running on port 8080, so you can go to [localhost:8080](http://localhost:8080/) to check the result. 

If you want to run the exercises and solutions at the same time, you can specify a different port for the solutions, i.e.

```
cd solutions
mvn jetty:run -Djetty.port=8081
``` 

## License

This is a proprietary project - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

There are other training courses available at [Vaadin Training](https://vaadin.com/training/courses)