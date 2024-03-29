# 剑指 Offer 17. 打印从1到最大的n位数
## 题目描述
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。<br />

来源：力扣（LeetCode） <br />
链接：https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof <br />
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br />
## 题目要求
- 用返回一个整数列表来代替打印
- n 为正整数
## 测试样例
输入: n = 1 <br />
输出: [1,2,3,4,5,6,7,8,9] <br />
# 我的思路
简单暴力打印：
```java
class Solution {
    public int[] printNumbers(int n) {
        int[] ans = new int[(int) (Math.pow(10, n) - 1)];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i+1;
        }
        return ans;
    }
}
```
```java
class Solution {
    static int nowNum = 0;
    static char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static int startBit = 0;
    static int nineNum = 0;
    public String[] printBigNumbers(int n) {
        int num = (int) Math.pow(10, n) - 1;
        String[] ans = new String[num];
        char[] nowStr = new char[n];
        startBit = n - 1;
        dfs(0, n, ans, num, nowStr);
        return ans;
    }
    public void dfs(int bit, int n, String[] ans, int num, char[] nowStr) {
        if (nowNum == num) {
            return;
        }
        if (n == bit) { // 终止条件
            // 每次都检查前面的0，很浪费时间
//            int startBit = 0;
//            String str = new String(nowStr);
//            while (startBit < n && str.charAt(startBit) == '0') startBit ++;
//            if (startBit < n) {
//                ans[nowNum] = str.substring(startBit);
//                nowNum ++;
//            }
            
            // 更好的办法是计算9的数量
            String str = new String(nowStr).substring(startBit);
            if (!str.equals("0")){
                ans[nowNum] = str;
                nowNum ++;
            }
            if (n - startBit == nineNum) startBit --;

            return;
        }

        // 通过回溯计算有多少个9
        for (int i = 0; i < 10; i++) {
            if (i == 9) nineNum ++;
            nowStr[bit] = loop[i];
            dfs(bit+1, n, ans, num, nowStr);
        }
        // 回溯后，9的计数也要回溯
        nineNum --;
    }
}
```
# 题解
由于本题要求返回 int 类型数组，相当于默认所有数字都在 int32 整型取值范围内，因此不考虑大数越界问题。</br>
实际上，本题的主要考点是大数越界情况下的打印。</br>
```java
// 下述题解输出大数形况下会出现000等情况
class Solution {
    char[] num;
    int[] ans;
    int count = 0,n;
    public int[] printNumbers(int n) {
        this.n = n;
        num = new char[n];
        ans = new int[(int) (Math.pow(10, n) - 1)];
        dfs(0);
        return ans;
    }
    private void dfs(int n) {
        if (n == this.n) {
            String tmp = String.valueOf(num);
            // 下面仅为能过提交的处理
            int curNum = Integer.parseInt(tmp);
            if (curNum!=0) ans[count++] = curNum;
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            num[n] = i;
            dfs(n + 1);
        }
    }
}
```
