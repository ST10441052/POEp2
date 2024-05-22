
public class Registration {
    @SuppressWarnings("unused")

        // This method checks if the username meets the requirements.
        public static boolean isUsernameValid(String username) {
            boolean checkUserName = username.contains("_");
            boolean maxFiveCharacters = username.length() <= 5;

            return checkUserName && maxFiveCharacters;
        }

        // method that tests if the password meets all the requirements 
        public static boolean isPasswordValid(String password){

        //  Declarations of the needed conditions to check the passwords strength
        boolean containsCapitalLetter = false;
        boolean containsNumber = false;
        boolean containsSpecialCharacter = false;
        boolean containsEightCharacters = password.length() >= 8;
      

            for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
           
            if (Character.isUpperCase(ch)) {
                containsCapitalLetter = true;
            } else if (Character.isDigit(ch)) {
                containsNumber = true;
            } else if (isSpecialCharacter(ch)) {
                containsSpecialCharacter = true;
            } 
             
        }
        return containsEightCharacters && containsCapitalLetter && containsNumber && containsSpecialCharacter;
        }
        

    private static boolean isSpecialCharacter(char ch) {
        return !Character.isLetterOrDigit(ch);
    }
}  