package coding.practice;

public class Bai1 {
    /**
     * Thay đổi ký tự đặc biệt trong 1 chuỗi cho trước
     */
    public static void main(String[] args) {
        String input = "hel#$#l@$@#o t#@$e%&st";
        String output = Bai1.changeSpecialCharacter(input);
        System.out.println("output: " + output);
    }

    public static String changeSpecialCharacter (String input) {
        if (input == null)
            return null;
        return input.replaceAll("[!@#$%^&*()]", "");
    }
}
