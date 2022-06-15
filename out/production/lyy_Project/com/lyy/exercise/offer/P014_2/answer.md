# 剑指 Offer 14- II. 剪绳子 II
## 题目描述
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。<br />
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。<br />

来源：力扣（LeetCode）<br />
链接：https://leetcode.cn/problems/jian-sheng-zi-ii-lcof <br />
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br />
## 题目要求
- 2 <= n <= 1000 <br />
## 测试样例
输入: 2 <br />
输出: 1 <br />
解释: 2 = 1 + 1, 1 × 1 = 1 <br />

输入: 10 <br />
输出: 36 <br />
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 <br />
# 我的思路
和P014_1一样的解题思路，但是加入了循环取余。
起初我一直答案错误，后来发现是我居然还用的int类型，蠢的不行，既然会超限，肯定至少是long类型啊。
对于题解的快速幂，其实很好理解。
1. 如果要求x^a，首先设置乘积的基底base为3；
2. 二分循环，即a /= 2；
3. 每次循环检查a是偶数还是奇数，如果是偶数，则基底base要求平方，即base = base*base，如果是奇数，乘积与基底base相乘，即ans *= base；
4. 在这过程中，所有乘积必须取余，防止超限。
# 官方题解
```java
// 快速幂取余
class Solution {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }
}
```