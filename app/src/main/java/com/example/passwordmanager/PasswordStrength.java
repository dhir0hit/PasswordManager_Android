package com.example.passwordmanager;

public class PasswordStrength {

    private String password;

    protected int[] passwordStrength() {
        char[] SpecialChars = {'/','*','!','@','#','$','%','^','&','*','(',')','\"','{','}','_','[',']','|','\\','?','/','<','>',',','.'};

        int Numbers = 0, specialChar = 0, upperCaseChar = 0, totalChar = 0;

        if (!password.isEmpty()) {
            for (int iter=0; iter<password.length(); iter++) {
                char ch = password.charAt(iter);
                if (Character.isDigit(ch)) {
                    Numbers++;
                }
                for (char sc: SpecialChars) {
                    if (ch == sc) {
                        specialChar++;
                    }
                }
                if (Character.isUpperCase(ch)) {
                    upperCaseChar++;
                }
                totalChar++;
            }
        }
        return new int[]{Numbers, specialChar, upperCaseChar, totalChar};
    }


    protected int Percent() {
        int[] PasswordStrengthList = passwordStrength();
        double totalStrength;

        // 30%
        double passwordLengthStrength = ((double) PasswordStrengthList[3] / 10) * 50;
        double average = (double) (PasswordStrengthList[0] + PasswordStrengthList [1] + PasswordStrengthList[2])/3;

        double passwordCharStrength = (average / (PasswordStrengthList[3] * (double) 3/4)) * 50;

        for (int iter=0; iter<3; iter++) {
            if (average == ((double) PasswordStrengthList[iter]/3)) {
                if (PasswordStrengthList[iter] == PasswordStrengthList[3]) {
                    passwordCharStrength = 0;
                }
            }
        }
        if (average == 0) {
            passwordLengthStrength /= 2;
        }

        int result = (int) (passwordLengthStrength + passwordCharStrength);

        if(result > 100){
            result =100;
        }
        return result;
    }

    public PasswordStrength(String password){
        this.password = password;
    }
}
