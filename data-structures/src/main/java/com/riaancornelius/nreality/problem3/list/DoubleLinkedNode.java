package com.riaancornelius.nreality.problem3.list;

/**
 * User: riaan.cornelius
 */
public class DoubleLinkedNode<T> implements Node<T> {

    private DoubleLinkedNode<T> previous;
    private DoubleLinkedNode<T> next;
    private T object;

    public DoubleLinkedNode(DoubleLinkedNode<T> previous, DoubleLinkedNode<T> next, T object) {
        this.previous = previous;
        this.next = next;
        this.object = object;
    }

    @Override
    public T element() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public DoubleLinkedNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleLinkedNode<T> previous) {
        this.previous = previous;
    }

    public DoubleLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleLinkedNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "DoubleLinkedNode{" +
                " object=" + object +
                '}';
    }
}
