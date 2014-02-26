package com.riaancornelius.nreality.problem3.list;

/**
 * User: riaan.cornelius
 */
public class IntegerList extends DoubleLinkedNodeList<Integer> {

    public IntegerList() {
        super();
    }

    public void sort() {
        Node<Integer> pred, succ;
        int size = size();
        for (int i = 0; i < size; i++) {
            pred = first();
            for (int j = 1; j < size - i; j++) {
                succ = after(pred);
                if (pred.element() > succ.element()) {
                    swap(pred, succ);
                }
                pred = succ;
            }
        }
    }

}
