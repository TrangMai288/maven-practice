package coding.practice;

public class Bai1 {
    public static void main(String[] args) {
        String input = "$102.0";
        String output = Bai1.changeSpecialCharacter(input);
        System.out.println("output: " + output);
    }

    public static String changeSpecialCharacter (String input) {
        if (input == null)
            return null;
        return input.replaceAll("[!@#$%^&*()]", "");
    }
}
