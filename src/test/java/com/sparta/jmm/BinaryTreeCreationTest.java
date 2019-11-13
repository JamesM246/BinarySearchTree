package com.sparta.jmm;

import com.sparta.jmm.tree.Tree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinaryTreeCreationTest {

    private Tree tree;

    @Test
    public void createTreeFromSingleElement(){
        tree = new Tree(48);
        assertEquals(48,tree.getRootNode().getValue());
    }

    @Test
    public void createTreeFromElementArray(){
        int[] elements = {48,25,68,17,54,31};
        tree = new Tree(elements);
        assertEquals(31,tree.getRootNode().getLeftChild().getRightChild().getValue());
    }

    @Test
    public void getRootElementTest(){
        tree = new Tree(48);
        assertEquals(48, tree.getRootElement());
    }

    @Test
    public void addElementTest(){
        tree = new Tree(48);
        tree.addElement(25);
        assertEquals(25, tree.getRootNode().getLeftChild().getValue());
    }

    @Test
    public void addElementsTest(){
        tree = new Tree(48);
        int[] elements = {25,68,17,54,31};
        tree.addElements(elements);
        assertTrue(true);
    }
}
