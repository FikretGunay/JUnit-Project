import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CalculateBirthYearTest {

    LoggingServiceCalculateBirthYear loggingServiceCalculateBirthYear;
    @BeforeEach
    public void setUp(){
        loggingServiceCalculateBirthYear=new LoggingServiceCalculateBirthYear() {
            @Override
            public void logging(String message) {
                System.out.println("Log: "+ message);
            }
        };
    }

    @Test
    public void calculateYearTest(){
        CalculateBirthYear calculateBirthYear= new CalculateBirthYear(loggingServiceCalculateBirthYear);

        int result= calculateBirthYear.calculateYear(50);
        assertEquals("Birth year will be 1973.",1974, result);

        int result2= calculateBirthYear.calculateYear(33);
        assertEquals("Birth year will be 1990.",1991, result2);

        int result3=calculateBirthYear.calculateYear(20);
        assertEquals("Birth year will be 2003.",2004, result3);
    }

    @Test
    public void calculateAgeZeroTest(){
        CalculateBirthYear calculateBirthYear= new CalculateBirthYear(loggingServiceCalculateBirthYear);

        int result= calculateBirthYear.calculateYear(0);
        assertEquals("Birth year will be 2023.",2024, result);
    }

    @Test
    public void calculateMaxAgeTest(){
        CalculateBirthYear calculateBirthYear= new CalculateBirthYear(loggingServiceCalculateBirthYear);

        int result= calculateBirthYear.calculateYear(130);
        assertEquals("Birth year will be 1893.",1894, result);
    }

    @Test
    public void bigAgeTest() {
        CalculateBirthYear calculateBirthYear=new CalculateBirthYear(loggingServiceCalculateBirthYear);
        assertThrows(IllegalArgumentException.class,() -> {

            UserData userData=new UserData("Anna", 150);
            calculateBirthYear.calculateYear(userData.age);

            UserData userData1=new UserData("Zeynep", 200);
            calculateBirthYear.calculateYear(userData1.age);

            UserData userData2=new UserData("Karin", 5000);
            calculateBirthYear.calculateYear(userData2.age);
        });
    }

    @Test
    public void negativeAgeTest(){
        CalculateBirthYear calculateBirthYear=new CalculateBirthYear(loggingServiceCalculateBirthYear);
        assertThrows(IllegalArgumentException.class,() -> {

            UserData userData=new UserData("Anna", -24);
            calculateBirthYear.calculateYear(userData.age);

            UserData userData1=new UserData("Zeynep", -240);
            calculateBirthYear.calculateYear(userData1.age);

            UserData userData2=new UserData("Karin", -9);
            calculateBirthYear.calculateYear(userData2.age);
        });
    }

    @Test
    public void greetUserWithBirthYearTest(){
        CalculateBirthYear calculateBirthYear= new CalculateBirthYear(loggingServiceCalculateBirthYear);

        UserData userData = new UserData("Zeynep", 33);
        assertEquals("Hi Zeynep. Your birth year is: 1991.", calculateBirthYear.greetUserWithBirthYear(userData));

        UserData userData1 = new UserData("Anna", 10);
        assertEquals("Hi Anna. Your birth year is: 2014.", calculateBirthYear.greetUserWithBirthYear(userData1));

        UserData userData2 = new UserData("Karin", 20);
        assertEquals("Hi Karin. Your birth year is: 2004.", calculateBirthYear.greetUserWithBirthYear(userData2));
    }

}
