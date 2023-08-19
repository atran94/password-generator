package password.generator;


import java.util.Random;

public class PasswordGenerator {
    // initialize all boolean flags to false
    private boolean useAllAlphaChars;
    private boolean useNumericChars;
    private boolean useSpecialChars;

    private int passwordLength;

    private String[] numericValues = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private String[] specialCharValues = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "+", "=", "_"};
    private String[] lowerAlphaValues = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private String[] upperAlphaValues = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    private PasswordGenerator() {
        // do not allow any other construction of this class
    }

    /**
     * Initialize the PasswordGenerator with the given flags
     *
     * @param useAllAlphaChars - true: use lowercase & uppercase a-z and A-Z.  false: use lowercase a-z
     * @param useNumericChars  - true: use numeric 0-9.  false: do not use numeric
     * @param useSpecialChars  - true: use special characters !@#$%^&*()+=_ .  false: do not use special characters
     * @param passwordLength   - integer length of password with max of 25 characters and min of 8 characters
     */
    public PasswordGenerator(
            boolean useAllAlphaChars,
            boolean useNumericChars,
            boolean useSpecialChars,
            int passwordLength
    ) {
        this.useAllAlphaChars = useAllAlphaChars;
        this.useNumericChars = useNumericChars;
        this.useSpecialChars = useSpecialChars;

        // set min & max boundaries for password length
        int maxLength = Math.min(passwordLength, 25); // set max length
        this.passwordLength = Math.max(maxLength, 8); // set min with max
    }

    /**
     * Generate the password given the flags
     *
     * @return String of generated password
     */
    public String generate() {
        // Using the boolean flags, create a new array with all the available characters necessary to generate
        // the password.
        String[] upperVals = useAllAlphaChars ? upperAlphaValues : new String[0];
        String[] numericVals = useNumericChars ? numericValues : new String[0];
        String[] specialVals = useSpecialChars ? specialCharValues : new String[0];

        // merge the available character arrays into a single array.
        String[] availableCharacters = mergeArrays(
                lowerAlphaValues, // always use lower alpha characters
                upperVals,
                numericVals,
                specialVals
        );

        // randomly select characters from the array of available characters to generate the password
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < passwordLength; i++) {
            int index = random.nextInt(availableCharacters.length);
            String selection = availableCharacters[index];
            password.append(selection);
        }

        // Return the password as a string
        return password.toString();
    }

    /**
     * Loop through all the arrays and merge them into a single array
     *
     * @param arrays String[]
     * @return String[] merged array
     */
    private String[] mergeArrays(String[]... arrays) {
        int arrayLength = 0;

        // get the length of all the arrays
        for (String[] arr : arrays) {
            arrayLength += arr.length;
        }

        // create the new array with the correct length
        String[] mergedArray = new String[arrayLength];

        // merge the arrays
        int prevArrLen = 0;
        for (String[] arr : arrays) {
            System.arraycopy(arr, 0, mergedArray, prevArrLen, arr.length);
            prevArrLen += arr.length;
        }

        return mergedArray;
    }
}
