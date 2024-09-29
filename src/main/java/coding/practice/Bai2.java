package coding.practice;

public class Bai2 {
    /**
     * Lấy 4 ký tự cuối cùng của một chuỗi cho trước
     */
    public static void main(String[] args) {
        String input = "";
        Bai2.getLast(input);
    }

    public static void getLast (String input) {
        if (input.length() < 4) {
            System.out.println("moi ban nhap it nhat 4 ky tu");
        } else {
            int startAt = input.length() - 4;
            int inputLength = input.length();
            for (int i = startAt; i < inputLength; i++) {
                System.out.println(input.charAt(i));
            }
        }
    }
}
