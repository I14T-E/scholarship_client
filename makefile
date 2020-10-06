# For more info on how to use this file visit
# https://github.com/xerial/sqlite-jdbc#usage

all:
	javac -classpath ".:sqlite-jdbc-3.30.1.jar" ScholarshipClient.java
	java -classpath ".:sqlite-jdbc-3.30.1.jar" ScholarshipClient
