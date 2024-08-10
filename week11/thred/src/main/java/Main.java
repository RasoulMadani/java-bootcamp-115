import java.util.LinkedList;
import java.util.List;

class Consumer extends Thread {
    List<Integer> list;

    Consumer(List<Integer> l) {
        list = l;
    }

    public void run() {
        for (Integer i = 0; i < 100; i++) {
            synchronized (list) {
                while (list.size() == 0)
                    try {
                        list.wait();
                    } catch (InterruptedException e) {/**/
                    }
            }
            Integer fetch = list.remove(0);
            System.out.println("Fetched:" + fetch);
        }
    }
}

class Producer extends Thread {
    List<Integer> list;

    Producer(List<Integer> l) {
        list = l;
    }

    public void run() {
        for (Integer i = 0; i < 100; i++) {
            synchronized (list) {
                Integer num = (int) (Math.random() * 1000);
                System.out.println("Added:" + num);
                list.add(num);
                list.notify();
                try {
                    Thread.sleep((long) (Math.random() * 10));
                } catch (InterruptedException e) {/**/
                }
            }
        }
    }
}

class Main {
    public static void main(String args[])
            throws InterruptedException {
        List<Integer> list = new LinkedList<>();
        Thread[] threads = {
                new Producer(list), new Producer(list), new Consumer(list), new Consumer(list)};
        for (Thread thread : threads)
            thread.start();
        for (Thread thread : threads)
            thread.join();
        System.out.println("Finished:" + list.size());
    }
}