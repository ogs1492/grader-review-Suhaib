CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'

if [[ -f student-submission/ListExamples.java ]]
then
    echo found student submission
else
    echo ListExamples.java not found
    exit 1
fi

cp student-submission/*.java grading-area
cp TestListExamples.java grading-area

echo moved files

javac -cp ".;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar" grading-area/*.java
# javac grading-area/*.java

if [[ $? != 0 ]]
then 
    echo Compilation Failed
    exit 1
fi

echo compiled files

ls grading-area

java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;grading-area" org.junit.runner.JUnitCore TestListExamples > output.txt

# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests
