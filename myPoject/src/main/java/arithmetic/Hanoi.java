package arithmetic;


import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 汉诺塔
 * 需求：将n个盘子从A塔按要求放到C塔
 * 背景：有三座塔：A,B,C，n个盘子，n个盘子由小到大（从上到下）叠在A塔。
 * 要求：移动过程中始终保持盘子的顺序都是由小到大（从上到下）
 * @author mc
 * @date 2018/5/10
 */
public class Hanoi {
    public static void main(String[] args) throws Exception{
        int n;
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入盘数：");
        n = Integer.parseInt(buf.readLine());

        Hanoi hanoi = new Hanoi();
        hanoi.move(n, 'A', 'B', 'C');
    }

    /**
     * 一个盘子：step1,将最大的盘从A移动到C
     * 两个盘子：step1,把除了最大的盘之外的盘，从A移到B step2,将最大的盘从A移到C, step3，把除了最大的盘之外的盘，从B移到C
     * 三个盘子：step1,把除了最大的盘之外的盘，从A移到B step2,将最大的盘子从A移到C, step3，把除了最大的盘之外的盘，从B移到C
     * 以此类推~
     * @param n 盘子数量
     * @param a 源柱子
     * @param b 辅助柱子
     * @param c 目标柱子
     */
    private void move(int n, char a, char b, char c) {
        String result = StringUtils.join("盘", n, "由", a, "移至", c);
        if(n == 1) {
            System.out.println(result);
        } else {
            move(n-1, a, c, b);
            System.out.println(result);
            move(n-1, b, a, c);
        }
    }
}
