javac -cp json.jar *.java
jar uf workingImplementation.jar *.class
java -cp workingImplementation.jar PrototypeMain
