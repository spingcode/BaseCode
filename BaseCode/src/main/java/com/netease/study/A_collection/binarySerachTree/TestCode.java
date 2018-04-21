package com.netease.study.A_collection.binarySerachTree;

public class TestCode {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> binarySearchTree = new MyBinarySearchTree<>();
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(8);
        System.out.println("=========所有元素==========");
        binarySearchTree.printTree();
        System.out.println("=========最大元素==========");
        System.out.println(binarySearchTree.findMax());
        System.out.println("=========最小元素==========");
        System.out.println(binarySearchTree.findMin());
        System.out.println("=========包含元素吗？？==========");
        System.out.println(binarySearchTree.contains(5));
        System.out.println(binarySearchTree.contains(2));
        System.out.println("=========删除一个元素==========");
        binarySearchTree.remove(8);
        binarySearchTree.printTree();
    }
}
