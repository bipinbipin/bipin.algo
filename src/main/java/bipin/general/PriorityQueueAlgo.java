package bipin.general;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueAlgo {

    public static void main(String[] args) {
//        naturalStringOrdering();
        customOrdering();
//        customStudentOrdering();
    }

    static void naturalStringOrdering() {
        Queue<String> stringQueue = new PriorityQueue<>();
        stringQueue.add("abcde");
        stringQueue.add("ghijk");
        stringQueue.add("12345");
        stringQueue.add("76543");
        stringQueue.add("ABCDE");
        System.out.println("Strings Stored in Natural Ordering in a Priority Queue\n");
        while(!stringQueue.isEmpty()) {
            System.out.println("Peek: " + stringQueue.peek() + "\t\tPoll: " + stringQueue.poll());
        }
    }

    static void customOrdering() {
        Queue<String> stringQueue = new PriorityQueue<>(new CustomStringComparator());
        stringQueue.add("abcde");
        stringQueue.add("ghijk");
        stringQueue.add("12345");
        stringQueue.add("76b43");
        stringQueue.add("ABCDE");
        System.out.println("Custom Ordering in a Priority Queue\n");
        while(!stringQueue.isEmpty()) {
            System.out.println("Peek: " + stringQueue.peek() + "\t\tPoll: " + stringQueue.poll());
        }
    }
    static class CustomStringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            int result;
            // if it contains a lowercase 'b' top priority
            if (o1.contains("b") && !o2.contains("b") ||
                    o2.contains("b") && !o1.contains("b")) {
                result = 1;
            } else {
                result = -1;
            }

            //System.out.println("Comparing:  o1: " + o1 + "\to2: " + o2 + "\tresult: " + result);
            return result;
        }
    }

    static void customStudentOrdering() {
        Queue<Student> studentQueue = new PriorityQueue<>(new CustomStudentComparator());
        studentQueue.add(new Student(1, "Bipin", 2.7));
        studentQueue.add(new Student(1, "Sarah", 3.3));
        studentQueue.add(new Student(1, "Olivia", 4.1));
        studentQueue.add(new Student(1, "Reni", 3.8));
        studentQueue.add(new Student(1, "Oski", 3.8));
        while(!studentQueue.isEmpty()) {
            Student polled = studentQueue.poll();
            System.out.println(polled.name + "\t" + polled.cgpa);
        }
    }
    static class CustomStudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            int result;
            // if gpa is the same, use name natural string ordering
            if (o1.cgpa == o2.cgpa) {
                result = o1.name.compareTo(o2.name);
            } else {
                if (o1.cgpa < o2.cgpa ) {
                    result = 1;
                } else {
                    result = -1;
                }
            }
            return result;
        }
    }
    static class Student {
        int     id;
        String  name;
        double  cgpa;
        Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }
    }
}
