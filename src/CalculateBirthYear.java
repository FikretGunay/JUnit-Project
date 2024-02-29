import java.util.Scanner;

public class CalculateBirthYear {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        System.out.println("What is your name?");
        String name= scanner.nextLine();

        System.out.println("What is your age?");
        int age= scanner.nextInt();
        scanner.close();

        UserData newUser = new UserData(name, age);

        LoggingServiceCalculateBirthYear logging = new LoggingServiceCalculateBirthYear() {
            @Override
            public void logging(String message) {
            }
        };

        CalculateBirthYear newCalculation = new CalculateBirthYear(logging);
        String greeting=newCalculation.greetUserWithBirthYear(newUser);
        System.out.println(greeting);
    }

    LoggingServiceCalculateBirthYear loggingServiceCalculateBirthYear;
    public CalculateBirthYear(LoggingServiceCalculateBirthYear loggingServiceCalculateBirthYear){
        this.loggingServiceCalculateBirthYear= loggingServiceCalculateBirthYear;
    }
    //method to calculate birth year
    public int calculateYear(int age) {
        if(age<0 || age>130){
            throw new IllegalArgumentException("Invalid age. Your age should not be less than 0 or more than 130");
        }
        int currentYear = java.time.LocalDate.now().getYear();
        int birthYear = currentYear - age;

        loggingServiceCalculateBirthYear.logging("Your birth year is "+birthYear+". Your age is "+age+".");

        return birthYear;
    }
    //method to print out name and birth year
    public String greetUserWithBirthYear(UserData user){

        int birthYear= calculateYear(user.age);

        return ("Hi "+user.name + ". Your birth year is: "+ birthYear+".");
    }
}
