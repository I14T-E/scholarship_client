## Scholarship Client

### Overview of the Program

This is a simple program written to practice a variety of different tools and techniques.
In short, it is a basic database-backed "scholarship management system." This system is able to store and retrieve detailed information about each scholarship entered. These actions include adding student and scholarship information, removing scholarship and student information, and viewing all entered information. The information entered is not sanitized or validated, however, implementing such aspects was not the goal of creating this program.


In regards to , I chose to implement the Table Data Gateway database access pattern. While it creates high coupling, I wanted to keep it relatively simple for this program.

The overall program design is outlinded below (diagram is created with the free trial of [StarUML](https://staruml.io "StarUML")).

![Diagram](/scholarship_client_uml.png)


### Setting Up the Program

To run the program, you need:

- The [program](/ScholarshipClient.java "Scholarship Program") itself
- The [JDBC Driver](/sqlite-jdbc-3.30.1.jar "JDBC Driver")

*A more in-depth explanation over how to use the JDBC driver can be found [here](https://github.com/xerial/sqlite-jdbc#usage).*

Start by downloading the two files above. You must then create the following two databases within SQLite:

- scholarships.db
- students.db

#### To Create the scholarships Table

Within the scholarships.db, create a table named sholarships with three columns: id, description, amount. To do this, run the following:

```bash
create table scholarships (id TEXT, description TEXT, amount TEXT);
```

#### To Create the students Table
And within the students.db, create a table named students with the three columns: namefirst, namelast, email. This can be done by running the following:

```bash
create table students (namefirst TEXT, namelast TEXT, email TEXT);
```

Finally, you must add the java jdbc driver to the filepath. Run the following command:

```bash
javac -classpath ".:sqlite-jdbc-[VERSION].jar" ScholarshipClient.java
```

Or, us this [make file](/Makefile.txt "makefile") can be used to add the .jar file to the class path and compile the program (within a macOS or Linux machine). It also starts the program.

