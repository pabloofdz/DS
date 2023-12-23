package e1;

public class StringCount {
    public static int countWords(String text) {
        int cont = 0, i;
        if(text != null){
            text = text.trim();
            cont = 1;
            if (text.length() == 0)
                cont = 0;
            for (i = 0; i < text.length(); i++){
                if (text.charAt(i) == ' ') {
                    if (text.charAt(i - 1) == ' ')
                        cont--;
                    cont++;
                }
            }
        }
        return cont;
    }

    public static int countChar(String text, char c) {
        int cont = 0, i;
        if(text != null){
            for (i = 0; i < text.length(); i++){
                if (text.charAt(i) == c)
                    cont++;
            }
        }
        return cont;
    }

    public static int countCharIgnoringCase(String text, char c) {
        int cont = 0, i;
        if(text != null){
            char charMay, charMin;
            if (Character.isUpperCase(c)){
                charMay = c;
                charMin = Character.toLowerCase(c);
            }else{
                charMin = c;
                charMay = Character.toUpperCase(c);
            }
            for (i = 0; i < text.length(); i++){
                if (text.charAt(i) == charMay || text.charAt(i) == charMin)
                    cont++;
            }
        }
        return cont;
    }

    public static boolean isPasswordSafe(String password) {
        int cont = 0, i;
        boolean hayMay = false, hayMin = false, hayDig = false, hayDigEsp = false, isPasswordSafe = false;

        for (i = 0; i < password.length(); i++) {
            if(Character.isUpperCase(password.charAt(i)))
                hayMay = true;

            if(Character.isLowerCase(password.charAt(i)))
                hayMin = true;

            if(Character.isDigit(password.charAt(i)))
                hayDig = true;

            if(password.charAt(i) == '?' || password.charAt(i) == '@' ||
                    password.charAt(i) == '#' || password.charAt(i) == '$' ||
                    password.charAt(i) == '.' || password.charAt(i) == ',')
                hayDigEsp = true;

            cont++;
        }

        if (cont >= 8 && hayMay && hayMin && hayDig && hayDigEsp)
            isPasswordSafe = true;

        return isPasswordSafe;
    }
}
