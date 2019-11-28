# Assignment-3-WordCount

Name: Sahal Asghar
Empl: 23721775

# Intro

"WordCount" is a java application made to fill the requirements of an assignment for CISC 3130 (Data Structures). 
In this repository there are four files, this README, an input file, an output file, and WordCount.java which is 
the file containing the source code. WordCount reads in the input file(input.txt) and prints out a word frequency 
list in the output file(output.txt).

## How to run

1. Clone the repository to your local computer
2. Go to your command prompt and navigate to the folder with the project
3. Once in the folder with the project, enter the command assignment3-sahaldos1> javac WordCount.java
4. After this you must enter the command java WordCount
5. This will start the application and you will be prompted to enter the name of the file you wish to check the word 
frequency of. For this example the input is "input.txt"
6. Once the job is finished you will be prompted to check the output file to view the word frequency list.

## How it works

I used a hashmap for this project. The reason for this is because it made the most obvious sense in a situation where 
we were dealing with words and then a counter for how many times those words appeared. This application reads in from 
the input file word by word. As each word is read in, it is added into the hashmap data structure. The key for each entry 
is set as the word itself, with the value initially being set to 1. For every new word read in, this process is repeated. 
If there is a word read in that is already in the hashmap, it's value is set to one greater than it originally was. After 
this process is complete, a function to sort the hashmap by value is ran. Then a print stream is used to to print the content 
of the hashmap into the output file.

