package com.netease.study.A_collection.arrayList;

public class MyArrayList<AnyType> {
    private AnyType[] theItems;
    private int size;

    private static final int DEFAULT_CAPACITY=10;
    public MyArrayList() {

    }
    public void clear()
    {
        doClear();
    }
    public void doClear()
    {

    }
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public void trimToSize()
    {
        ensureCapacity(size());
    }
    public void add(AnyType x)
    {
        add(size(),x);
    }
    public void add(int idx,AnyType x)
    {
        if (theItems.length==size())
            ensureCapacity(2*size()+1);
        System.arraycopy(theItems,idx,theItems,idx+1,size()-idx);
        theItems[idx]=x;
        size++;
    }

    public void ensureCapacity(int newCapacity)
    {
        if(newCapacity<size)
            return;
        AnyType[] old = theItems;
        theItems=(AnyType[])new Object[newCapacity];
        System.arraycopy(old,0,theItems,0,size());
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();

    }
}
