package bipin.hackerrank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Student {
    int id;
    String name;
    double cgpa;
    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getID() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public double getCGPA() {
        return this.cgpa;
    }
}

class Priorities {
    Queue<Student> studentQueue = new PriorityQueue<Student>(new CustomStudentComparator());

    List<Student> getStudents(List<String> events) {
        for(String event : events) {
            String[] eventArray = event.trim().split(" ");
            if (eventArray[0].equals("ENTER")) {
                int id = Integer.parseInt(eventArray[3]);
                double cgpa = Double.parseDouble(eventArray[2]);
                studentQueue.add(new Student(id, eventArray[1], cgpa));
            } else if (eventArray[0].equals("SERVED")) {
                if(!studentQueue.isEmpty()) {
                    studentQueue.poll();
                }
            }
        }
        List<Student> remainingStudentsInQueue = new ArrayList<>();
        while(!studentQueue.isEmpty()) {
            remainingStudentsInQueue.add(studentQueue.poll());
        }
        return remainingStudentsInQueue;
    }

    class CustomStudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            int result = 0;
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
}


class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}