package A2ZSheet;


import java.util.*;

public class MeetingsInOneRoom {


    static class Room implements Comparable<Room> {
        int start;
        int end;
        int weight;

        Room(int _start,int _end){
            start=_start;
            end=_end;
            weight=_start-_end;
        }

        @Override
        public int compareTo(Room r1){
            if(r1.end==this.end){
                return r1.weight-this.weight;
            }else{
                return r1.end-this.end;
            }
        }

        public int getEnd(){
            return this.end;
        }

        public int getStart(){
            return this.start;
        }
    }
    /*
     * Task: Given N meetings with start[i] and end[i], return the maximum
     * number that can be held in one room.
     *
     * A meeting may be chosen only when start time > end time of the last
     * chosen meeting (the usual GeeksForGeeks version of this problem).
     */
    static int maxMeetings(int[] start, int[] end) {
        List<Room>  rooms=new ArrayList<>();
        int n=start.length;
        for(int i=0;i<n;i++){
            rooms.add(new Room(start[i],end[i]));
        }
        int count=0;
        Room current=null;
        Collections.sort(rooms);
        for(int i=0;i<n;i++){
            if(count==0||current.getEnd()<rooms.get(i).start) {
                count++;
                current = rooms.get(i);
            }

        }
        return count;
        // Tip: A common approach is to sort meetings by finishing time.
    }

    static class TestCase {
        String name;
        int[] start;
        int[] end;
        int expected;

        TestCase(String name, int[] start, int[] end, int expected) {
            this.name = name;
            this.start = start;
            this.end = end;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        List<TestCase> tests = Arrays.asList(
                new TestCase("Basic example",
                        new int[] {1, 3, 0, 5},
                        new int[] {2, 4, 6, 7},
                        3),

                new TestCase("Typical six meetings",
                        new int[] {1, 3, 0, 5, 8, 5},
                        new int[] {2, 4, 6, 7, 9, 9},
                        4),

                new TestCase("All meetings overlap",
                        new int[] {1, 2, 3},
                        new int[] {10, 9, 8},
                        1),

                new TestCase("Touching endpoints are not compatible",
                        new int[] {1, 2, 3, 4, 5},
                        new int[] {2, 3, 4, 5, 6},
                        3)
        );

        int passed = 0;
        for (TestCase test : tests) {
            int actual = maxMeetings(test.start, test.end);
            boolean ok = actual == test.expected;
            if (ok) passed++;

            System.out.printf("%s: %s (expected %d, got %d)%n",
                    test.name, ok ? "PASS" : "FAIL", test.expected, actual);
        }
        System.out.printf("%nPassed %d/%d tests.%n", passed, tests.size());
    }
}