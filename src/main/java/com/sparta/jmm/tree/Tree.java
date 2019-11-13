package com.sparta.jmm.tree;

import com.sparta.jmm.exceptions.ChildNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;

public class Tree implements BinaryTree {

    private Node rootNode;
    private static int nodeCounter = 1;

    public Tree(int element) {
        rootNode = new Node(element);
    }

    public Tree(int[] elements) {
        rootNode = new Node(elements[0]);
        addElements(Arrays.copyOfRange(elements, 1, elements.length));
    }

    public Node getRootNode() {
        return rootNode;
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return nodeCounter;
    }

    @Override
    public void addElement(int element) {
        Node node = rootNode;
        addNewElement(node, element);
        nodeCounter++;
    }

    private void addNewElement(Node node, int element) {
        if (element < node.getValue()) {
            if (node.getLeftChild() == null) node.setLeftChild(new Node(element));
            else {
                addNewElement(node.getLeftChild(), element);
            }
        } else {
            if (node.getRightChild() == null) node.setRightChild(new Node(element));
            else {
                addNewElement(node.getRightChild(), element);
            }
        }
    }

    @Override
    public void addElements(int[] elements) {
        for (int i = 0; i < elements.length; i++) addElement(elements[i]);
    }

    @Override
    public boolean findElement(int value) {
        if (rootNode == null) return false;
        if (value == rootNode.getValue()) return true;
        else if (value < rootNode.getValue()) {
            rootNode = rootNode.getLeftChild();
            return findElement(value);
        } else {
            rootNode = rootNode.getRightChild();
            return findElement(value);
        }
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node node = rootNode;
        return getNewLeftChild(element,node);
    }

    private int getNewLeftChild(int element, Node node) throws ChildNotFoundException{
        if(node == null) throw new ChildNotFoundException("Error: child not found");
        else if (node.getValue() == element) {
        if (node.getLeftChild() == null) throw new ChildNotFoundException("Error: child not found");
            else return node.getLeftChild().getValue();
        } else {
            if (element < node.getValue()) return getNewLeftChild(element,node.getLeftChild());
            else return getNewLeftChild(element,node.getRightChild());
        }
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node node = rootNode;
        return getNewRightChild(element,node);
    }

    private int getNewRightChild(int element, Node node) throws ChildNotFoundException{
        if(node == null) throw new ChildNotFoundException("Error: child not found");
        else if (node.getValue() == element) {
            if (node.getRightChild() == null) throw new ChildNotFoundException("Error: child not found");
            else return node.getRightChild().getValue();
        } else {
            if (element < node.getValue()) return getNewRightChild(element,node.getLeftChild());
            else return getNewRightChild(element,node.getRightChild());
        }
    }

    private ArrayList<Integer> sortTree(Node node,ArrayList<Integer> list){
        if(node.getLeftChild() != null) sortTree(node.getLeftChild(), list);
        list.add(node.getValue());
        if(node.getRightChild() != null) sortTree(node.getRightChild(), list);
        return list;
    }

    @Override
    public int[] getSortedTreeAsc() {
        Node node = rootNode;
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList = sortTree(node,sortedList);
        int[] sortedArray = new int[sortedList.size()];
        for(int i=0;i<sortedArray.length;i++) sortedArray[i] = sortedList.get(i);
        return sortedArray;
    }

    @Override
    public int[] getSortedTreeDesc() {
        Node node = rootNode;
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList = sortTree(node,sortedList);
        int[] sortedArray = new int[sortedList.size()];
        for(int i=0;i<sortedArray.length;i++) sortedArray[i] = sortedList.get(sortedArray.length - 1 - i);
        return sortedArray;
    }
}
