package HomeWork1;

public class Task5 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        s = filtrString(s);
        System.out.println(s);
        if ( isPalindrome(s)) {
            System.out.println("Фраза является полиндромом");
        } else {
            System.out.println("Фраза не является полиндромом");
        }

    }
    public static boolean isPalindrome(String s) {
        int indexMin = 0;
        int indexMax = s.length() - 1;
            while ( indexMin < indexMax ) {
                char minChar = Character.toLowerCase(s.charAt(indexMin));
                char maxChar = Character.toLowerCase(s.charAt(indexMax));
                if (minChar != maxChar) {
                    return false;
                }
                indexMin++;
                indexMax--;
            }
            return true;
    }


    public static String filtrString(String s) {
        return s.replaceAll("\\P{L}+", "");
    }

}
