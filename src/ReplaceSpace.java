/**
 * @autheor masheng
 * @description 替换空格
 * @date 2020/4/11
 */
//请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
// 则输出“We%20are%20happy.”。
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        //1.遍历字符串，计算空格总数，得到替换之后的长度
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }
        //2.替换后的长度等于原来的长度+2*spaceNum
        int oldLength = str.length();
        int newLength = oldLength + 2 * spaceNum;
        //3.将原来的字符串长度设置为新的字符串的长度
        str.setLength(newLength);
        //4.设置两个指针，一个指针指向原数组的末尾，另一个指针指向新数组的末尾
        int oldIndex = oldLength - 1;
        int newIndex = newLength - 1;
        //5.将旧指针向前移动，如果没有遇到空格，将旧指针指向位置的数复制到新指针指向的位置，如果
        // 遇到空格的话，替换3格，旧指针向前移动3次，直到旧指针和新指针相等为止
        for (; oldIndex >= 0 && oldIndex < newIndex; oldIndex--) {
            if (str.charAt(oldIndex) == ' ') {
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            } else {
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace space = new ReplaceSpace();
        StringBuffer stringBuffer = new StringBuffer("We are happy");
        System.out.println(space.replaceSpace(stringBuffer));
    }
}