package 剑指offer;

/**
 * 替换空格
 *
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 *
 */

public class T04ReplaceBlank {
    public static void main(String[] args) {
        System.out.println(replaceBlank("we are happy."));
        System.out.println(replaceBlank2(new StringBuilder("we are happy.")));
    }

    //字符数组，从后往前拷贝，考虑覆盖的问题(其实是用2个数组，所以也不存在覆盖的问题了)
    private static String replaceBlank(String testStr) {
        if (testStr == null || testStr.length() == 0)
            return "";
        int originLength = testStr.length();
        int blankCount = 0;
        for (int i = 0; i < testStr.length(); i++) {
            if (testStr.charAt(i) == ' ')
                blankCount++;
        }

        int newLength = 2 * blankCount + originLength;
        char[] newChars = new char[newLength];
        int originIndex = originLength - 1;
        int newIndex = newLength - 1;
        while (originIndex >= 0) {
            if (testStr.charAt(originIndex) == ' ') {
                newChars[newIndex--] = '%';
                newChars[newIndex--] = '0';
                newChars[newIndex--] = '2';
            }
            else {
                newChars[newIndex--] = testStr.charAt(originIndex);
            }
            originIndex--;
        }
        return String.valueOf(newChars);
    }

    //stringBuilder做法
    private static String replaceBlank2(StringBuilder stringBuilder) {
        StringBuilder result = new StringBuilder();
        int length = stringBuilder.length();
        for (int i = 0; i < length; i++) {
            if (stringBuilder.charAt(i) == ' ')
                result.append("20%");
            else
                result.append(stringBuilder.charAt(i));
        }
        return result.toString();
    }

}
