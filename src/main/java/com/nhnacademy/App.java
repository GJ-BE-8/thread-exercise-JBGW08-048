package com.nhnacademy;

import com.nhnacademy.thread.Counter;

public class App {

    public static void main(String[] args) {
        // TODO#6 현재 실행되고 있는 main thread의 이름을 my-thread로 설정 합니다.
        // 참고: main thread : Thread.currentThread()
        Thread mainThread = Thread.currentThread();
        mainThread.setName("my-thread"); // 메인 스레드 이름 설정
        System.out.println("Thread Name: " + mainThread.getName()); // 변경된 스레드 이름 출력

        // TODO#7 Counter 생성, countMaxSize는 10으로 설정 후 run method를 호출 합니다.
        Counter counter = new Counter(10); // Counter 객체 생성 및 countMaxSize를 10으로 설정
        counter.run(); // Counter의 run 메서드 호출
    }
}
