import java.util.Random;

public class PhoneNumber {
    public String makeNumber(String phoneNumber) {
        Random random = new Random();
        int randomNumber = random.nextInt(9999999) + 1000000;
        String s1 = "" + randomNumber;
        StringBuilder s2 = new StringBuilder();
        String[] stringArray = s1.split("");
        for (int i = 0; i < stringArray.length; i++) {
            s2 = s2.append(stringArray[i]);
            if (i > 0 && i != stringArray.length - 1 && i % 2 == 0) {
                s2.append('-');
            }
        }
        phoneNumber = "+375-55-" + s2;
        return phoneNumber;
    }
}
