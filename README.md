### Scholarship Client

This is a simple program written to practice a variety of different tools and techniques.
In short, it is a basic sqlite database-backed "scholarship management system." The overall program design is outlinded below (created with the free trial of [StarUML](https://staruml.io "StarUML")).

![Diagram](/scholarship_client_uml.png)


To run, you must also download the sqlite [.jar](/sqlite-jdbc-3.30.1.jar ".jar file") file and add it to the class path. A make file has been added [here](/Makefile.txt "makefile") for your convenience.

You must also create the following two databases:
- scholarships.db
- students.db


For this project, I chose to implement the Table Data Gateway database access pattern. While it creates high coupling, I wanted to keep it relatively simple for this program.


