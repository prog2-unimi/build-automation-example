# A Build Automation Example

This repository contains an example of a [build automation](https://en.wikipedia.org/wiki/Build_automation)
utility that can assist in automating the tasks related to *compiling*, *testing*, *documenting*, and *formatting* a Java project.

The example is based on the [Gradle Build Tool](https://gradle.org/), it is not
intended as a tutorial about it (there are
[many](https://guides.gradle.org/creating-new-gradle-builds/)
[pretty good](https://www.vogella.com/tutorials/Gradle/article.html)
[ones](https://www.petrikainulainen.net/getting-started-with-gradle/) around), but to provide some very **minimal  scaffolding** that interested students of my [Porgrammazione II](https://prog2.di.unimi.it/) class can leverage to organize their homework and to automate the related building tasks.

> The usage of this tool is absolutely **not required to pass the exam** and the
> content of this repository is not part of the teaching material of the course.

## How to use it

The (relevant) content of this repository is

    ├── build.gradle
    ├── gradlew
    ├── gradlew.bat
    └── src
        ├── main
        │   └── java
        │       └── my
        │           └── pkg
        │               ├── Example.java
        │               └── package-info.java
        ├── overview.html
        └── test
            └── java
                └── my
                    └── pkg
                        └── ExampleTest.java

The `build.gradle` file is the tool configuration file, while `gradlew` and
`gradlew.bat` are two executable files (respectively for Unix/POSIX and Windows
OSs) that can be used to (install and) run the tool.

The `src` directory hierarchy contains a sample package `my.pkg` with the
`Example.java` implementation of a class, and `ExampleTest.java` set of *unit
tests* for such class; moreover it contains some additional documentation (the
package level `overview.html` and the project level `overview.html` files).

> **Dependencies on other tools**
>
> The *unit test*s are based on [JUnit 5](https://junit.org/junit5/), *coverage*
> is handled using [JaCoCo](https://www.eclemma.org/jacoco/), and the
> *documentation* is redacted using
> [Javadoc](https://docs.oracle.com/en/java/javase/11/javadoc/) (endowed with
> [MathJax](https://www.mathjax.org/) to allow for a more pleasant mathematical
> notation, and [UMLDoclet](https://github.com/talsma-ict/umldoclet) for
> automatic generation of [PlantUML](https://plantuml.com/) diagrams); code
> *formatting* follows the [Google Java Style
> Guide](https://google.github.io/styleguide/javaguide.html) and is provided by
> [Spotless](https://github.com/diffplug/spotless/tree/master/plugin-gradle), A
> basic introduction of such tools is presented during the class, any further
> detail is beside the scope of this repository (and the course itself).
>
> *The build automation tool will automatically satisfy the required dependencies,
> so that no manual installation and configuration will be needed*.

One can add his packages, implementations and documentation to the
`src` directory hierarchy (and possibly eliminate the sample code and
documentation). The build tool can be invoked as

    ./gradlew task...

the most interesting tasks are described in the following table

|      Task       |                              Effect                                             |
| --------------- | ------------------------------------------------------------------------------- |
| `clean`         | Deletes the build directory                                                     |
| `classes`       | Assembles main classes                                                          |
| `testClasses`   | Assembles test classes                                                          |
| `test`          | Runs the unit tests                                                             |
| `build`         | Assembles and tests this project                                                |
| `runClass`      | Runs the main method of a class given by its fully qualified name               |
| `javadoc`       | Generates Javadoc API documentation for the main source code                    |
| `UMLJavadoc`    | Generates Javadoc API documentation, and UML diagrams, for the main source code |
| `spotlessApply` | Applies code formatting steps to sourcecode in-place                            |
| `tasks`         | Lists all available tasks                                                       |

typically one wants to compile and run tests with

    ./gradlew build

or to reformat the code and generate the documentation with

    ./gradlew spotlessApply javadoc

finally

    ./gradlew UMLJavadoc

generates a version of the documentation including UML diagrams.

The execution of such tasks creates and populates the `build` directory
hierarchy as follows

    build
    ├── classes
    │   └── java
    │       ├── main
    │       │   └── my
    │       │       └── pkg
    │       │           └── Example.class
    │       └── test
    │           └── my
    │               └── pkg
    │                   └── ExampleTest.class
    ├── docs
    │   ├── javadoc
    │   │   ├── index.html
    │   │   └── ...
    │   └── umljavadoc
    │       ├── index.html
    │       └── ...
    └── reports
        ├── jacoco
        │   └── test
        │       └── html
        │           ├── index.html
        │           └── ...
        └── tests
            └── test
                ├── index.html
                └── ...

where `clases` contains the compiled classes, `reports` contains the unit test
and coverage results, and `docs` contains the generated documentation. Given the
location of the compiled files, to run the `Example` class it's enough to
specify `build/classes/java/main` as the *classpath* as in

    java -cp build/classes/java/main my.pkg.Example hello

or to set the `CLASSPATH` environment variable once and for all; alternatively,
one can use the `runClass` task as

    ./gradlew runClass -PmainClass=my.pkg.Example --args=hello

and the build tool will take care of the classpath.