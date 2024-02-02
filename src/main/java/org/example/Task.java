package org.example;

class Task {
    void run() {

        System.out.println(48*12);

        try {
            Thread.sleep(1000); // Simulate 1 second of work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}