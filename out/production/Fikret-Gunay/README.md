# Assignment for Programming
###### Fikret Günay
This Java program, CalculateBirthYear,
takes user input for name and age from the user,
calculates the birth year based on the input taken from the user,
and provides a greeting to the user with the calculated birth
year.
This program has 3 classes and an interface:
1. UserData Class:
   It is class to store user data; name and age.
2. CalculateBirthYear Class:
   This class in the **'main'** takes user input for name and age, creates a
   **'UserData'** object, and uses the **'CalculateBirthYear'** class to calculate and display the greeting.
   **'calculateYear'** calculates the birth year based on the provided age. Throws an 'IllegalArgumentException' for invalid ages.
   **'greetUserWithBirthYear'** takes a **'UserData'** object, calculates the birth year, and returns a greeting string.
3. CalculateBirthYearTest Class
   This class contains JUnit tests for the **'CalculateBirthYear'** class.
4. LoggingServiceCalculateBirthYear Interface:
   **'logging'** is an interface to log messages to the user.
## Explanation of Test Cases
|          Test Names           |                             Test Input                              |                                                           Expected Results                                                            |  Actual Results   | Passed/Fail |
|:-----------------------------:|:-------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------------------------------------:|:-----------------:|:-----------:|
|     1. calculateYearTest      |                 1.age=50<br/>2.age=33<br/>3.age=20                  |                                      1.BirthYear=1973<br/>2.BirthYear=1990<br/>3.BirthYear=2003                                       |    As Expected    |   Passed    |
|    2. calculateAgeZeroTest    |                                age=0                                |                                                            BirthYear=2023                                                             |    As Expected    |   Passed    |
|    3. calculateMaxAgeTest     |                               age=130                               |                                                            BirthYear=1893                                                             |    As Expected    |   Passed    |
|         4. bigAgeTest         |             1.age=150<br/>2.age=200<br/>3.age=5000<br/>             |                     1. IllegalArgumentException <br/>2. IllegalArgumentException<br/>3. IllegalArgumentException                      |    As Expected    |   Passed    |
|      5. negativeAgeTest       |                1.age=-24<br/>2.age=-240<br/>3.age=-9                |                     1. IllegalArgumentException <br/>2. IllegalArgumentException <br/>3. IllegalArgumentException                     |    As Expected    |   Passed    |
| 6. greetUserWithBirthYearTest | 1.name=Zeynep age=33<br/>2.name=Anne age=10<br/>3.name=Karin age=20 | 1."Hi Zeynep. Your birth year is: 1990."<br/>2.    "Hi Anna. Your birth year is: 2013."<br/>3.  "Hi Karin. Your birth year is: 2003." |    As Expected    |   Passed    |



##### 1. Further Explanation for calculateYearTest
This test case evaluates the correctness of the calculateYear
method by providing different valid ages and verifying that the
calculated birth years match the expected outcomes with "AssertEquals". It ensures that the method consistently produces accurate results for a range of ages.

##### 2. Further Explanation for calculateAgeZeroTest
This test case assesses the behavior of the program when
the user inputs an age of 0. Since there is an age limit in the program, and age should be between 0-130,
input 0 for the age is tested for this program. It verifies that the program
correctly calculates the birth year in this edge case scenario.

##### 3. Further Explanation for calculateMaxAgeTest
This test case examines the program's ability to handle the maximum allowed age (130). It ensures that the calculateYear method accurately computes the birth year for the upper limit of age input.

##### 4. Further Explanation for bigAgeTest
This test case focuses on the program's error handling for
invalid ages (greater than 130). It uses multiple inputs to
check the consistency of the program's response to such cases,
expecting an IllegalArgumentException to be thrown.

##### 5. Further Explanation for negativeAgeTest
Similar to the bigAgeTest, this test case evaluates the program's error handling, specifically for negative ages. It checks if the program correctly throws an IllegalArgumentException for invalid input and does so consistently across different negative age values.

##### 6. Further Explanation for greetUserWithBirthYearTest
This test case evaluates the greetUserWithBirthYear method
by providing different user data with various ages and names.
It verifies that the method constructs the correct greeting
message based on the calculated birth year and given name, ensuring the
consistency of the program's user interaction.




