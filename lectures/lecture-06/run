#!/bin/bash

if [ $# -eq 0 ]; then
    echo "Please provide the class name. For instance: ./run DesignRecipeExamples";
    exit;
fi;

CLASSNAME=$(echo $1 | cut -f 1 -d '.')

rm *.class &> /dev/null;
javac -cp tester.jar *.java &&
java -classpath tester.jar:. tester.Main $CLASSNAME
