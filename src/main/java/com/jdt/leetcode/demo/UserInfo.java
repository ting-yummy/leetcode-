package com.jdt.leetcode.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdt
 * @date 2023/8/29
 */
public class UserInfo {
    String name;
    List<String> list;

    public UserInfo(String name) {
        name = name;
        this.list = new ArrayList<>();
    }

    public UserInfo(String name, List<String> list) {
        name = name;
        this.list = list;
    }
}
