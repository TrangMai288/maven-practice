package coding.practice;

public class Bai3 {
    public static void main(String[] args) {
        String input = "hello testz";
        char nonRepeatingCharacter;
        int indexOfNonepeatingCharacter = Bai3.getFirstNoRepeating(input);
        if (indexOfNonepeatingCharacter == -1) {
            System.out.println("not found.");
        } else if (indexOfNonepeatingCharacter > -1) {
            nonRepeatingCharacter = input.charAt(Bai3.getFirstNoRepeating(input));
            System.out.println("Ky tu khong lap lai dau tien cua chuoi la " + nonRepeatingCharacter);
        }
    }

    public static int getFirstNoRepeating(String input) {
        int inputLength = input.length();
        boolean found = true;
        for (int i = 0; i < inputLength; i++) {
            for (int j = 0; j < inputLength; j++) {
                if (i != j && input.charAt(i) == input.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}
