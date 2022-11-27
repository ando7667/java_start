package HomeWork1;

public class Task4 {
    public static void main(String[] args) {
       String str = "the   sky   is   blue";
       System.out.println("Исходная строка: " + str);
       str = reverseString(str);
       System.out.println("Измененная строка:" + str);
    }

    public static String reverseString(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        StringBuilder rsb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar != ' ') {
                sb.append(currChar);
            }else{
                while ( currChar == ' ') {
                    i++;
                    currChar = s.charAt(i);
                }
                i--;
                rsb.insert(0, ' ' + sb.toString());
                sb.setLength(0);
            }
        }
        return rsb.insert(0, sb.toString()).toString();
    }
}
