package com.sparta.jmm.manager;

import com.sparta.jmm.exceptions.ChildNotFoundException;
import com.sparta.jmm.tree.Tree;

public class Starter {
    public static void main(String[] args) throws ChildNotFoundException {
        int[] elements = {48,25,68,17,54,31};
        Tree tree = new Tree(elements);
    }
}
