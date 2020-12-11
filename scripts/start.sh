#!/bin/bash
year=$1
day=$2
subtask=$3

echo ""
echo "Building program $year $day $subtask..."
file="src/adventofcode$year/$day/${day^}${subtask^}"

javac "${file}.java"

echo "Starting program ..."
echo ""
java $file

exit