package Seminar4;

import java.util.LinkedList;
import java.util.Queue;

public class Task3 {
    public static void main(String[] args) {

    }

    class MovingAverange {
        Queue<Integer> q = new LinkedList<>();
        // интерфейс
        // контракт
        int windowSize;
        double sum;

        // init
        public MovingAverange(int size) {
            windowSize = size;
            sum = 0;
        }

        public double next(int val) {
            sum += val;
            q.add(val);
            if (q.size() > windowSize) {
                sum -= q.poll();
            }
            return sum / q.size();
        }
    }

}
