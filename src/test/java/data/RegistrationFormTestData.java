package data;

public class RegistrationFormTestData {

    // константы для позитивных тестов
    public static final String FIRST_NAME = "Aleks";
    public static final String LAST_NAME = "Pechkin";
    public static final String USER_EMAIL = "Aleks@sdfs.com";
    public static final String USER_NUMBER = "8999999997";
    public static final String DAY = "20";
    public static final String MONTH = "July";
    public static final String YEAR = "1998";
    public static final String[] SUBJECTS = {"E", "computer science"};
    public static final String EXPECTED_SUBJECTS = "English, Computer Science";
    public static final String[] HOBBIES = {"Sports", "Reading", "Music"};
    public static final String PICTURE = "image.jpg";
    public static final String CURRENT_ADDRESS = "Backer street, 221b";
    public static final String STATE = "Uttar Pradesh";
    public static final String CITY = "Agra";


    public static final String USER_NUMBER_WITH_PLUS = "+79991233223";
    public static final String USER_NUMBER_WITH_DASHES = "8-999-123-32-23";
    public static final String USER_NUMBER_WITH_DASHES_AND_PARENTHESES = "8(999)-123-32-23";
    public static final String USER_NUMBER_WITH_PLUS_DASHES_PARENTHESES = "+7(999)-123-32-23";


    // константы для негативных тестов
    public static final String NAME_AS_NUMBER = "00000";

    public static final String USER_NUMBER_AS_STRING = "ggggggggggg";
    public static final String USER_NUMBER_BAD_FORMAT = "+00012312332";

    public static final String TEXT_FILE = "textFile.txt";
}
