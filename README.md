# Assignment

[Click here to read the assignment](./docs/assignment.md)

## clipboard-recruiting-tht-sdet

This is a base starter kit framework that you can use to build your tests for the above assignment.
However, if you are more comfortable with your own tool kit, feel free to use that as well!

## External dependencies

For this project to run, you would need to install below 3 dependencies on your machine:

- **[Java 11](https://openjdk.java.net/projects/jdk/11/)** (as the core programming language)
- **[Maven 3.8.5](https://maven.apache.org/download.cgi)** (for dependency management)
- **[Google Chrome latest version](https://www.google.com/chrome/?brand=CHBD&gclid=Cj0KCQjwr-SSBhC9ARIsANhzu15P0PA-n9Zp4NpxKaOHVGtBD1TZQH0HlQQE6hUfsOFAU1nf-Rzdlf4aAoTJEALw_wcB&gclsrc=aw.ds)** (browser to run your tests)

> If your JAVA_HOME is set to anything other than JDK 11, you would need to update the path. Else your project
> will not run. Also, do remember to set the correct JDK settings in your IDE.

## Getting Started


## Framework Architecture 

Framework is built on page factory design pattern, where action keywords are wrapped in their implementation

It consists of page classes which have their own WebElements defined along with their respective methods.

Also, framework has separate keywordHelpers and waitHelpers which can be accessed and used for handling wait related scenarios.

It has base page, and tool specific keywords which are implemented by Selenium, other tools can implement the same however configuration needs to be added in Driver factory for them.


For easiest way to getting started, extract this project and open it from IntelliJ.
> Then Do a dry run on test in : test -> java -> TestSandbox class and see if your setup is correct.  

For execution of the existing test please following steps

> From command line execute following command to execute the test 
> For Test method with specific tag
mvn -test -D groups="<TagName>"

example mvn -test -D groups="Regression"

> For Specific Test method with name
mvn test -D test="TestClassName#MethodName"

example = test -D test="TestSandbox#assertSecondHighestTVDetailsIsPresent"

> Through IDE you use Junit Runner (Go to Tests -> Run your specific test method)


## Success
