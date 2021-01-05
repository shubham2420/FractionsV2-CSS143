# FractionsV2-CSS143

Summary

Build two classes (Fraction and FractionCounter) and a Driver for use in counting the number of unique fractions read from a text file. We’ll use the ArrayList class to store our list of unique FractionCounters. Rather than designing a monolithic chunk of code in main like we did in the previous homework, we’ll practice distributing our code into containers (called classes) that you will design specifically to tackle this same problem in a different and more logically organized fashion. Once again the filename containing all the fractions will be "fractions.txt"

Introduction 

Your project is to read in a series of fractions from a text file, which will have each line formatted as follows: “A/B”. A sample text file is listed below, and the purpose of your program is to read in one line at a time and build a Fraction object from A and B. For each unique Fraction seen, your program will create a FractionCounter object used to track the number of occurrences of that specific fraction. When all the input is consumed, your program will print out its ArrayList of unique FractionCounters, which should report the fraction and its count – see output below. You can assume no blank lines or misleading characters; see the text file link above for the some of the input I’ll use when testing your submission. Your program must reduce fractions, as demonstrated in the output below.

Sample text file input:

6/3

7/3

6/3

2/1

Sample output:

2/1 has a count of 3

7/3 has a count of 1

Building Multiple Classes

Class Fraction

This class should be a simple abstraction (i.e., a small class) that represents the ratio of two numbers. There will be only two data elements, and only a few methods. Note that it is required for your Fraction class to store your ratio in reduced form, so this is a feature to implement in your software.

Data Members The numerator – what primitive type makes the most sense here? The denominator – same type as the numerator. Method Members Overloading Fraction() – default “no-arg” constructor Fraction(int,int) – constructor which initializes your data Overriding boolean equals(Object other) – compares “this” to “other” To make it easier on you, if you want, you can make the signature this instead: boolean equals (Fraction other) Getters & Setters getNumerator() setNumerator(…) getDenominator() setDenominator(…)

Class FractionCounter

This class should also be small, and contain only a few state variables. The purpose of this class is to store a reference to a Fraction object and a count of how many times this fraction object has been seen in the input file.

Data Members The Fraction – declare this class variable to be of type Fraction from above The counter – the integer value used to count the number of these fractions seen Method Members FractionCounter( Fraction theFraction ) - constructor bool compareAndIncrement( Fraction newFraction ) – used to see if the newFraction passed into this function is the same as the Fraction we’re storing, and if so increments the counter by one and returns true (otherwise, returns false). String toString() – replace this inherited method with one that prints out both the Fraction and its count

Testing and Boundary Cases Before submitting your assignment, be sure to thoroughly test it – for example, if your software fails to compile, the maximum grade falls to a 75%. Does your software reduce fractions? Test this common case. What about boundary cases or unusual situations? For example, does your software read in the fraction “4/0” and crash with a DivideByZeroException? Can your software handle 0 fractions? 1 fraction? 1,000 fractions? What does your software do with the fraction “-1/-4”? What if the numerator or denominator is very large, as in “1/9999”? Does your program report the fraction “1/1 occurs 3 times” only once (as it should), or does it report “1/1 occurs 3 times” multiple times (which it should not)? If you store the fraction using doubles, does the equals() function suffer from roundoff errors? Test your code for as many cases as you can think of by varying the “fractions.txt” input file. Note that I will try multiple “fractions.txt” input files when grading your assignment.

Hints (& Spoilers)

Test your code as you add features (either methods or data) incrementally, making sure your small change works as you envisioned it to. Try to keep in mind OO principles; for example, to promote information hiding, we should probably make all of our data members private for each class. Consider reading one line at a time (with scanner.nextLine()), and using the split (Links to an external site.) function (defined in class String) to give you an array with two elements in it (the numerator and denominator, respectively) Getting a null pointer exception or all Fractions seem to have the same value? Building an array does not put any elements inside the array, so make sure you are building new Fraction objects and adding them to your list if they are unique. You should use build a FractionCounter object for each unique Fraction encountered, and store a list of FractionCounters as your program executes. You can determine if a Fraction is unique by looping over your list of FractionCounters, calling compareAndIncrement() on each FractionCounter, passing as input the Fraction you just read from the file. If all calls to compareAndIncrement() return false, then this is a unique Fraction that needs a FractionCounter created for it. The FractionCounter function compareAndIncrement() will have to compare two fractions, and this will require some kind of comparison function for the Fraction Class. You should implement some type of “equals” method in the Fraction class that simply compares the numerators and denominators of the two Fractions in question. A slightly different approach would be to define a static “isEqual” function that takes two Fraction objects as input, and gets both numerators and both denominators. If they are both equal, then the function returns true, otherwise false. (Remember: your Fractions class stores the numerator and denominator in reduced form.)

What to Submit -The Fraction class (Fraction.java), the FractionCounter class (FractionCounter.java), and a driver (FractionDriver.java) -- put them all together in a zip file. Make sure that your filenames match the class that are in them. (So the FractionDriver.java file contains the FractionDriver class, etc.)
