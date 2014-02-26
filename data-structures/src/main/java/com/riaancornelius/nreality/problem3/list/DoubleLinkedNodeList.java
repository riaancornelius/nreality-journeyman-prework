package com.riaancornelius.nreality.problem3.list;

/**
 * User: riaan.cornelius
 */
public class DoubleLinkedNodeList<T> implements List<T> {

    private int elements;
    private DoubleLinkedNode<T> header;
    private DoubleLinkedNode<T> trailer;

    public DoubleLinkedNodeList() {
        this.elements = 0;
        this.header = new DoubleLinkedNode<T>(null, null, null);
        this.trailer = new DoubleLinkedNode<T>(header, null, null);
        this.header.setNext(trailer);
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public boolean isEmpty() {
        return elements < 1;
    }

    private DoubleLinkedNode<T> getNode(Node<T> node) throws InvalidNodeException {
        if (node == null) {
            throw new InvalidNodeException("Can't check a null node!");
        } else {

        }
        DoubleLinkedNode dnode = (DoubleLinkedNode<T>) node;
        return dnode;
    }

    @Override
    public boolean isFirst(Node<T> node) throws InvalidNodeException, ListEmptyException{
        if (isEmpty()) {
            throw new ListEmptyException("Illegal operation on an empty list");
        }
        return getNode(node).getPrevious() == header;
    }

    @Override
    public boolean isLast(Node<T> node) {
        return getNode(node).getNext() == trailer;
    }

    @Override
    public Node<T> first() {
        return header.getNext();
    }

    @Override
    public Node<T> last() {
        return trailer.getPrevious();
    }

    @Override
    public Node<T> before(Node<T> node) {
        return getNode(node).getPrevious();
    }

    @Override
    public Node<T> after(Node<T> node) {
        return getNode(node).getNext();
    }

    @Override
    public Node<T> insertBefore(Node<T> node, T object) {
        DoubleLinkedNode<T> current = getNode(node);
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<T>(current.getPrevious(), current, object);
        current.getPrevious().setNext(newNode);
        current.setPrevious(newNode);
        elements++;
        return newNode;
    }

    @Override
    public Node<T> insertAfter(Node<T> node, T object) {
        DoubleLinkedNode<T> current = getNode(node);
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<T>(current, current.getNext(), object);
        current.getNext().setPrevious(newNode);
        current.setNext(newNode);
        elements++;
        return newNode;
    }

    @Override
    public Node<T> insertFirst(T object) {
        DoubleLinkedNode<T> nextNode = header.getNext();
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<T>(header, nextNode, object);
        nextNode.setPrevious(newNode);
        header.setNext(newNode);
        elements += 1;
        return newNode;
    }

    @Override
    public Node<T> insertLast(T object) {
        DoubleLinkedNode<T> prevNode = trailer.getPrevious();
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<T>(prevNode, trailer, object);
        prevNode.setNext(newNode);
        trailer.setPrevious(newNode);
        elements += 1;
        return newNode;
    }

    @Override
    public T remove(Node<T> node) {
        DoubleLinkedNode<T> prevNode = ((DoubleLinkedNode) node).getPrevious();
        DoubleLinkedNode<T> nextNode = ((DoubleLinkedNode) node).getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrevious(nextNode);
        elements -= 1;
        return node.element();
    }

    @Override
    public T replace(Node<T> node, T replacement) {
        insertAfter(node, replacement);
        remove(node);
        return node.element();
    }

    @Override
    public void swap(Node<T> node1, Node<T> node2) {
        DoubleLinkedNode<T> nodeA = getNode(node1);
        DoubleLinkedNode<T> nodeB = getNode(node2);
        T tmp = nodeA.element();
        nodeA.setObject(nodeB.element());
        nodeB.setObject(tmp);
    }


}
