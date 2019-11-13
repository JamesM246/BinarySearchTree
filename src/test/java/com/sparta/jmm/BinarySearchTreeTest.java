package com.sparta.jmm;

import com.sparta.jmm.exceptions.ChildNotFoundException;
import com.sparta.jmm.tree.Tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    private Tree tree;

    @Before
    public void createTree(){
        int[] elements = {48,25,68,17,54,31};
        tree = new Tree(elements);
    }

    @Test
    public void getNumberOfElementsTest(){
        assertEquals(6, tree.getNumberOfElements());
    }

    @Test
    public void findElementTest(){
        assertTrue(tree.findElement(48));
    }
    @Test
    public void findElementTest2() {
        assertTrue(tree.findElement(54));
    }
    @Test
    public void findElementTest3() {
        assertTrue(tree.findElement(25));
    }

    @Test
    public void getLeftChildTest() throws ChildNotFoundException {
        assertEquals(54, tree.getLeftChild(68));
    }

    @Test
    public void getRightChildTest() throws ChildNotFoundException {
        assertEquals(31, tree.getRightChild(25));
    }

    @Test(expected = ChildNotFoundException.class)
    public void getLeftChildErrorTest() throws ChildNotFoundException{
        tree.getLeftChild(71);
    }
    @Test
    public void getSortedTreeAscTest(){
        assertEquals(Arrays.toString(new int[]{17,25,31,48,54,68}),Arrays.toString(tree.getSortedTreeAsc()));
    }

    @Test
    public void getSortedTreeDescTest(){
        assertEquals(Arrays.toString(new int[]{68,54,48,31,25,17}),Arrays.toString(tree.getSortedTreeDesc()));
    }
}
