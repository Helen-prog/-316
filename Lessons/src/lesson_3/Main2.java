package lesson_3;

public class Main2 {
    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder("Hello");
//        System.out.println(sb.capacity());
//        System.out.println(sb.length());
//        sb.append("World")
//                .append(true)
//                .append(10);
//        sb.append(12345L);
//        sb.append(10.2);
//        sb.append(10.2f);
//        sb.insert(5, "_!");
//        System.out.println(sb);
//        sb.delete(5, 7);
//        System.out.println(sb);
//        sb.deleteCharAt(5);
//        System.out.println(sb);
//        sb.replace(5, 20, "Java");
//        System.out.println(sb);
//
////        String st = sb.substring(5, 9);
////        System.out.println(st);
//
////        sb.reverse();
//        System.out.println(sb);
//        System.out.println(sb.indexOf("Java"));
//        System.out.println(sb.indexOf("l", 3));

//        StringBuilder sb1 = createStr(5, 3);
//        System.out.println(sb1);
//        modifyStr(sb1, "=", "равно");
//        modifyStr(sb1, "+", "плюс");
//        modifyStr(sb1, "-", "минус");
//        modifyStr(sb1, "*", "умножить");
//        System.out.println(sb1);
        String s = "®јяа€Є";
        System.out.println(s.codePointAt(0));
        System.out.println(s.codePointAt(1));
        System.out.println(s.codePointAt(2));
        System.out.println(s.codePointAt(3));
        System.out.println(s.codePointAt(4));
        System.out.println(s.codePointAt(5));
    }

    public static StringBuilder modifyStr(StringBuilder sb, String oldStr, String newStr) {
        int pos;
        while ((pos = sb.indexOf(oldStr)) != -1){
//            sb.deleteCharAt(pos);
//            sb.insert(pos, "равно");
            sb.replace(pos, pos + 1, newStr);
        }
        return sb;
    }

    public static StringBuilder createStr(int a, int b) {
        StringBuilder res = new StringBuilder();
        res.append(a).append(" + ").append(b).append(" = ").append(a + b).append("\n");
        res.append(a).append(" - ").append(b).append(" = ").append(a - b).append("\n");
        res.append(a).append(" * ").append(b).append(" = ").append(a * b).append("\n");
        return res;
    }
}
