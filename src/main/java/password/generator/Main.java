package password.generator;

public class Main {
    public void test(String[] args) {
        // These input variables will be replaced by the JavaFX GUI that I will build
        // in the 2nd and 3rd milestones.
        boolean useAllAlphaChars = true;
        boolean useNumericChars = true;
        boolean useSpecialChars = true;
        int passwordLength = 15;

        // initialize the password generator object
        PasswordGenerator passwordGenerator = new PasswordGenerator(
                useAllAlphaChars,
                useNumericChars,
                useSpecialChars,
                passwordLength
        );

        // generate the password from the initialized passwordGenerator object values
        String password = passwordGenerator.generate();

        // print out the results
        System.out.println("Password: " + password);
        System.out.println("Length: " + password.length());
    }
}
