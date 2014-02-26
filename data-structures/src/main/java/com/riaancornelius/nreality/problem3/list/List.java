package com.riaancornelius.nreality.problem3.list;

/**
 * User: riaan.cornelius
 */
public interface List<T> {

    public int size();
    public boolean isEmpty();
    public boolean isFirst(Node<T> node);
    public boolean isLast(Node<T> node);
    public Node<T> first();
    public Node<T> last();
    public Node<T> before(Node<T> node);
    public Node<T> after(Node<T> node);
    public Node<T> insertBefore(Node<T> node, T object);
    public Node<T> insertAfter(Node<T> node, T object);
    public Node<T> insertFirst(T object);
    public Node<T> insertLast(T object);
    public T remove(Node<T> node);
    public T replace(Node<T> node, T replacement);
    public void swap(Node<T> node1, Node<T> node2);

}
