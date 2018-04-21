package com.netease.study.A_collection.binarySerachTree;

public class MyBinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    /*
    * 搜索二叉树的数据结构
    * */
    private static class BinaryNode<AnyType>
    {
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        public BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
    private BinaryNode<AnyType> root;
    public MyBinarySearchTree()
    {
        root=null;
    }
    public void makeEmpty()
    {
        root=null;
    }
    public boolean isEmpty()
    {
        return root==null;
    }
    public void insert(AnyType x)
    {
        root = insert(x,root);
    }
    private BinaryNode<AnyType> insert(AnyType x,BinaryNode<AnyType> t)
    {
        if (t==null)
            return new BinaryNode<>(x,null,null);
        int compareResult = x.compareTo(t.element);
        if (compareResult>0)
             t.right=insert(x,t.right);
        else if (compareResult<0)
            t.left=insert(x,t.left);
        return t;
    }
    public void remove(AnyType x)
    {
        root=remove(x,root);
    }
    private BinaryNode<AnyType> remove(AnyType x,BinaryNode<AnyType> t)
    {
        if (t==null)
            return null;
        int compareResult = x.compareTo(t.element);
        if (compareResult>0)
            t.right=remove(x,t.right);
        else if(compareResult<0)
            t.left = remove(x,t.left);
        else if (t.left!=null&&t.right!=null)
        {
            t.element=findMin(t.right).element;
            t.right=remove(t.element,t.right);
        }
        else
        {
            t=(t.left!=null)?t.left:t.right;
        }
        return t;
    }

    public boolean contains(AnyType x)
    {
        return contains(x,root);
    }
    private boolean contains(AnyType x,BinaryNode<AnyType> t)
    {
        if (t==null)
            return false;
        int compareResult = x.compareTo(t.element);
        if (compareResult>0)
            return contains(x,t.right);
        else if(compareResult<0)
            return contains(x,t.left);
        else
            return true;
    }
    public AnyType findMin()
    {
        return findMin(root).element;
    }
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {

        while (t!=null&&t.left!=null)
            t=t.left;
        return t;
    }
    public AnyType findMax()
    {
        return findMax(root).element;
    }
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {

        while (t!=null&&t.right!=null)
            t=t.right;
        return t;
    }
    public void printTree()
    {
        printTree(root);
    }
    private void printTree(BinaryNode<AnyType> t)
    {
        if (t==null)
            return;
        printTree(t.left);
        System.out.println(t.element);
        printTree(t.right);
    }
}
