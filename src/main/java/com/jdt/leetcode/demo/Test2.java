package com.jdt.leetcode.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 完成股票推荐系统设计，如果一个人关注了a又关注了b 则系统会给只关注a没关注b的人推荐关注b，请返回应该给此人推荐关注几个股票
 * 输入
 * 第一行输入q表示操作次数
 * 接下来输入一次操作
 * 共有两种操作
 * 1.注册格式为:1 name n
 * 表示有一个name的人关注了n个股票
 * 第二行输入n个字符串表示这n个股票 n个字符串不相同
 * 2.查询格式为
 * 输入2 name 表示查询系统会给此人推荐多少股票
 * 保证至少有一次查询
 * 例
 * 5
 * 1 Alice 2
 * Zoom Apple
 * 2 Bob
 * 2 Alice
 * 1 Bob 2
 * Apple MicroSoft
 * 2 Bob
 * 输出
 * error
 * 0
 * 1
 * <p>
 * 作者：大菠萝_pineapple
 * 链接：https://www.nowcoder.com/interview/center?entranceType=%E5%AF%BC%E8%88%AA%E6%A0%8F
 * 来源：牛客网
 *
 * @author jdt
 * @date 2023/8/29
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, UserInfo> nameMap = new HashMap();
        Set<String> gpCount = new HashSet<>();
        int operateCount = in.nextInt();
        for (int i = 0; i < operateCount - 1; i++) {
            int type = in.nextInt();
            //注册
            if (type == 1) {
                String name = in.next();
                if (nameMap.containsKey(name)) {
                    System.out.println("error");
                    continue;
                }
                int carCount = in.nextInt();
                UserInfo userInfo = new UserInfo(name);
                for (int i1 = 0; i1 < carCount; i1++) {
                    String gpName = in.next();
                    userInfo.list.add(gpName);
                    gpCount.add(gpName);
                }
                nameMap.put(name, userInfo);

            }
            if (type == 2) {
                String name = in.next();
                if (!nameMap.containsKey(name)) {
                    System.out.println("error");
                    continue;
                }
                UserInfo userInfo = nameMap.get(name);
                int count = 0;
                for (String company : gpCount) {
                    if (!userInfo.list.contains(company)) {
                        count++;
                    }
                }
                System.out.println(count);
            }

        }

    }
}
