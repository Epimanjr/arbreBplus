#! /bin/bash

# Compilation du projet
echo -n "Compilation du projet ... "
javac -cp "src" -d "build/classes" src/tests/TestPersonne.java && echo "Done."
