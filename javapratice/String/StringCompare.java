/*
* 字符串比较
* 返回字符串中第一个字母ASCII的差值
* */
public class StringCompare {
    public static void main(String[] args) {
        String str1 = "Hello World";
        String str2 = "hello world";
        Object str3 = str1;

        System.out.println(str1.compareTo(str1));
        System.out.println(str1.compareToIgnoreCase(str2));
        System.out.println(str1.compareTo(str3.toString()));
    }
}
