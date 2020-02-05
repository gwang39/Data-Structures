DEVELOPMENT IDE

Eclipse IDE for Java Developers
Version: Neon.2 Release (4.6.2)
Build id: 20161208-0600


HOW TO RUN PROGRAM

Warning: please make sure there is only one '.' (dot) existed in the file extention because program file writer searches for this dot to modify the output file name 
	(NO dot in file name (except exteintion) or parant folder name)

Eclipse

The program can be ran in Eclopse by importing the parent folder as project and run the main class
The program can be ran with or without commandline arguement
There would be prompt in the console asking for input and output file locations if you command line arguments are not valid

Main class: GWangLab4 [inputFile] [outputFile]
(with or without command line arguement as mentioned below)

JDK 6
The source code can be compiled with JDK 6 from the command line with or without argument as below
With Arguement: java GWangLab4 [inputFile] [outputFile]
Without Argument: java GWangLab4

Note: after you give outputFile path and name, program would generate 5 sorted output

For example:

If we run program as below

GWangLab4 [rev50.dat] [rev50sorted.dat]

This would read rev50.dat and produce below files in output location

rev50sorted_InsertionSort.dat
rev50sorted_HeapSort.dat
rev50sorted_ShellSort1.dat
rev50sorted_ShellSort2.dat
rev50sorted_ShellSort3.dat
rev50sorted_ShellSort4.dat
rev50sorted_ShellSort5.dat