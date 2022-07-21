package bipin.cracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TwoLinkedLists {

    static class Node {
        Node next = null;
        int data;

        void addToTail(int d) {
            Node end = new Node();
            end.data = d;
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
    }

    public static void main(String[] args) {
//        twoDotOne_RemoveDuplicates();
//        twoDotTwo_KtoTheLast();
        twoDotThree_RemoveNode();
    }

    static void twoDotThree_RemoveNode() {
        Node head = new Node();
        head.data = 99;
        generateRandomNodes(head, 10);
        System.out.println(head);
    }

    static void generateRandomNodes(Node head, int quantity) {
        Random rand = new Random();
        Node idx = head;
        for (int i = 0; i < quantity; i++) {
            Node newNode = new Node();
            newNode.data = rand.nextInt((10 - 0) + 1);
            idx.next = newNode;
            idx = idx.next;
        }
    }

    static void twoDotTwo_KtoTheLast() {
        int kFromEnd = 49;
        List<Integer> linkedList = generateRandomLinkedList(50);
        System.out.println("Element Value:\t" + linkedList.get(linkedList.size() - kFromEnd));
    }

    static List<Integer> generateRandomLinkedList(int size) {
        Random rand = new Random();
        List<Integer> linkedList = new LinkedList<>();
        for (int f = 0; f < size; f++) {
            linkedList.add(rand.nextInt((10 - 0) + 1) + 0);
        }
        System.out.println(linkedList);
        return linkedList;
    }

    static <E> void addToList(LinkedList<E> list, E... values) {
        for (E value : values) {
            list.add(value);
        }
    }

    static void twoDotOne_RemoveDuplicates() {
        List<Integer> linkedList = generateRandomLinkedList(50);
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        addToList(linkedList, 10,5,10,5,5);

        for (int i = 0; i < linkedList.size(); i++) {
            Integer numToCheck = linkedList.get(i);
            for (int j = i+1; j < linkedList.size();) {
                if (numToCheck == linkedList.get(j)) {
                    // we got a dupe
                    linkedList.remove(j);
                } else {
                    // only increment if w haven't removed anything from the list
                    j++;
                }
            }
        }

        System.out.println(linkedList);
    }
}
