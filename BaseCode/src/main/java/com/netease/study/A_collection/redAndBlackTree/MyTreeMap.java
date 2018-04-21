package com.netease.study.A_collection.redAndBlackTree;

import java.util.Comparator;
import java.util.TreeMap;

public class MyTreeMap<K extends Comparable<? super K>,V> {
    private static final boolean RED   = false;
    private static final boolean BLACK = true;
    private static class Entry<K,V>
    {
        K key;
        V value;
        Entry<K,V> left;
        Entry<K,V> right;
        Entry<K,V> parent;
        boolean color = BLACK;

        public Entry(K key, V value, Entry<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
        public V setValue(V value)
        {
            V oldValue = this.value;
            this.value=value;
            return oldValue;
        }
    }
    private Entry<K,V> root;
    private int size=0;
    private Comparator<? super K> comparator;
    private int compare(K key1,K key2)
    {
        if (comparator==null)
            return key1.compareTo(key2);
        else
            return comparator.compare(key1,key2);
    }
    public V put(K key,V value)
    {
        Entry<K,V> t = root;
        //为空的时候
        if (t == null) {
            compare(key, key); // type (and possibly null) check

            root = new Entry<>(key, value, null);
            size = 1;
            return null;
        }
        //找到了要插入的位置
        int cmp=0;
        Entry<K,V> parent=null;
        while (t!=null)
        {
            parent=t;
            cmp=compare(key,t.key);
            if (cmp>0)
                t=t.right;
            else if(cmp<0)
                 t=t.left;
            else
                return t.setValue(value);

        }
        //把值插入进去
        Entry<K,V>  e = new Entry<>(key, value, parent);
        if (cmp<0)
            parent.left=e;
        else
            parent.right=e;

        //修复红黑树的规则
        fixAfterInsertion(e);
        size++;
        return null;
    }
/*
*  x.color = RED;

        while (x != null && x != root && x.parent.color == RED) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                Entry<K,V> y = rightOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == rightOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateRight(parentOf(parentOf(x)));
                }
            } else {
                Entry<K,V> y = leftOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        root.color = BLACK;
*
* */
    private void fixAfterInsertion(Entry<K, V> e) {
        //就是按照某种规则进行旋转，具体可以参考java.util.TreeMap.fixAfterInsertion()
    }

    public static void main(String[] args) {
        TreeMap<String,String> map = new TreeMap();
        map.put("11","aaa");
    }
}
