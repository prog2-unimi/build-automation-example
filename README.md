# A Build Automation Example

This repository contains an example of a [build automation](https://en.wikipedia.org/wiki/Build_automation)
utility that can assist you in *compiling*, *testing*, *documenting*, and *formatting* a Java project.

The example is based on the [Gradle Build Tool](https://gradle.org/), it is not
intended as a tutorial about it (there are
[many](https://guides.gradle.org/creating-new-gradle-builds/)
[pretty good](https://www.vogella.com/tutorials/Gradle/article.html)
[ones](https://www.petrikainulainen.net/getting-started-with-gradle/) around), but to provide some very basic *scaffolding* that interested students of my [Porgrammazione II](https://prog2.di.unimi.it/) class can leverage to organize their homework and to automate the related building tasks.

## How to use it

The (relevant) content of this repository is

    ├── build.gradle
    ├── gradlew
    ├── gradlew.bat
    └── src
        ├── main
        │   └── java
        │       └── my
        │           └── pkg
        │               ├── Example.java
        │               └── package-info.java
        ├── overview.html
        └── test
            └── java
                └── my
                    └── pkg
                        └── ExampleTest.java

The `build.gradle` file is the tool configuration file, while `gradlew` and
`gradlew.bat` are two executable file (respectively for Unix/Posix and Windows
OSs) that can install and run the tool.

The `src` directory hierarchy contains a sample package `my.pkg` containing the
`Example.java` implementation of an class, and `ExampleTest.java` of a set of
test for such class; moreover it contains some additional documentation (the
package level `overview.html` and the project level  `overview.html` files).

> **Dependencies on other tools**
>
> The test are implemented using [JUnit 4](https://junit.org/junit4/) and the
> documentation is redacted using the
> [Javadoc Technology](https://docs.oracle.com/javase/7/docs/technotes/guides/javadoc/)
> (endowed with [MathJax](https://www.mathjax.org/) to allow for more pleasant
> mathematical notation). A basic introduction on such tools is provided during
> the class, any further detail is beside the scope of this repository (and the
> course itself).
>
> *The build automation tool will automatically satisfy the required dependencies,
> so that no manual installation and configuration will be needed*.

One can add his packages, implementations and documentation to the
`src` directory hierarchy (and possibly eliminate the sample code and
documentation). The build tool can be invoked as

    ./gradlew task...

the most interesting tasks are described in the following table

|      Task       |                            Effect                            |
| --------------- | ------------------------------------------------------------ |
| `clean`         | Deletes the build directory                                  |
| `classes`       | Assembles main classes                                       |
| `testClasses`   | Assembles test classes                                       |
| `test`          | Runs the unit tests                                          |
| `build`         | Assembles and tests this project                             |
| `javadoc`       | Generates Javadoc API documentation for the main source code |
| `spotlessApply` | Applies code formatting steps to sourcecode in-place         |
| `tasks`         | Lists all available tasks                                    |

typically one wants to compile and run tests with

    ./gradlew build

or to reformat the code and generate the documentation with

    ./gradlew spotlessApply javadoc

The execution of such tasks creates and populates the `build` directory
hierarchy as follows

    build
    ├── classes
    │   └── java
    │       ├── main
    │       │   └── my
    │       │       └── pkg
    │       │           └── Example.class
    │       └── test
    │           └── my
    │               └── pkg
    │                   └── ExampleTest.class
    ├── docs
    │   └── javadoc
    │       ├── index.html
    │       └── ...
    └── reports
       └── tests
           └── test
               ├── index.html
               └── ...

where `clases` contains the compiled classes, `reports`  contains the unit test
results, and `doc` contains the documentation. Given the location of the
compiled files, to run the `Example` class it's enough to specify
`build/classes/java/main` as the *classpath* as in

    java -cp build/classes/java/main my.pkg.Example

or to set the `CLASSPATH` environment variable once and for all.