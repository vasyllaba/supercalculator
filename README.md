
<h1 align="center">SuperCalculator</h1>
<h2 align="center">

![GitHub last commit](https://img.shields.io/github/last-commit/vasyllaba/supercalculator)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=flat&logo=appveyor=postgresql&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=flat&logo=appveyor=Thymeleaf&logoColor=white)
![Bootstrap](https://img.shields.io/badge/bootstrap-%23563D7C.svg?style=flat&logo=appveyor=bootstrap&logoColor=white)
![SpringBoot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=flat&log=appveyor=spring-boot=SpringBoot&logoColor=white)

<img src="./readme_assets/H1Logo.jpg" width="65%">

<h3 align="center"> This is a test task for GeeksForLess </h3>
<h2 align="center"><a  href="https://super-calculator-web.herokuapp.com/">Live Demo</a></h2>

### Description

Web calculator implemented on Spring Boot. It contains a main page with an input field and validation of the entered expression. If the expression is correct, the calculation is performed and saved to the database. You can edit database records on the history page

#### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Instruction

<p align="center">
<img src="./readme_assets/Instruction.gif" width="80%"></p>

#### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Validation

<p align="center">
<img src="./readme_assets/Validation.gif" width="80%"></p>


#

### Task
#### Develop an application that will provide the followingcapabilities:

1. ✅ Enter arithmetic expressions containing integers and fractions
numbers, as well as mathematical operations +, -, *, / and parentheses,
nesting level of parentheses is arbitrary.
2. ✅ Check the entered expression for the correct placement of brackets
3. ✅ Check the correctness of the entered expression (should not be 2
signs of mathematical operations in a row, for example, it is not allowed
expression 3 * +4, at the same time, expression 4 * -7 is
allowable)
4. ✅ If the expression is correct, calculate its value and
store the expression and the calculated value in the database.
5. ✅ Provide the ability to view and edit expressions in
DB. If the expression remains correct after editing,
resave its value in the database.
6. ✅ Implement search functions for expressions in the database based on their results.
For example, a query is possible: find all expressions whose values
are equal to (and also greater than, less than...) the specified value.
7. ✅ The project must be implemented using a build system
___Maven___ in one of the development environments: ___IntelliJ IDEA___ or Eclipse.
8. ✅ The project must be uploaded to the ___[GitHub](https://github.com/vasyllaba/supercalculator)___ repository and provided
link to get it. It is also possible to send an archive with
project.

Notes.

* Use Java 11 or ___Java 17___ at work.
* Recommended DBMS: MySQL, MariaDB or
___PostgreSQL___.
* The use of ___JUnit___ and other testing tools is encouraged.
* ~It is allowed to use files (instead of a database) to store information about
entered and edited arithmetic expressions.~
* ~Paragraphs 1-3 and 8 are mandatory. If paragraphs 4-7 are not
are executed, then perform an additional task:~
  - ~count the number of numbers in the string entered by the user.~
  
  
  
###  Technology list 
  * Java 17
  * Maven 4.0.0
  * Spring Boot 2.7.4
  * PostgreSQL 13
  * JUnit 4.13.2
  * Thymeleaf
  * Bootstrap
  * Deploy on ___heroku___
