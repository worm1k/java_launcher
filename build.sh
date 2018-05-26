#!/bin/sh
find src/exceptions/*.java src/simulator/*.java  src/simulator/vehicles/*.java src/utility/*.java src/weather/*.java > sources.txt
javac -d . -sourcepath ./src @sources.txt
