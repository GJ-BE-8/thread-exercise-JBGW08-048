package com.nhnacademy.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// TODO#1 CounterThread는 Thread를 상속합니다.
public class CounterThread extends Thread {
    private final long countMaxSize;
    private long count;

    public CounterThread(String name, long countMaxSize) {
        super(name); // 부모 클래스인 Thread의 생성자를 호출하여 스레드 이름을 설정합니다.

        // TODO#2 name이 null 이거나 공백 문자열이면 IllegalArgumentException이 발생합니다.
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Thread name must not be null or empty");
        }

        // TODO#3 countMaxSize <= 0 이면 IllegalArgumentException이 발생합니다.
        if (countMaxSize <= 0) {
            throw new IllegalArgumentException("countMaxSize must be greater than 0");
        }

        this.countMaxSize = countMaxSize;
        this.count = 0;
    }

    @Override
    public void run() {
        do {
            try {
                // TODO#4 1초 간격으로 count를 증가시키고 출력합니다.
                Thread.sleep(1000); // 1초 대기 (1000 밀리초)

                count++; // count 증가

                // 출력 형식에 맞춰서 스레드 이름과 카운트 값을 출력합니다.
                System.out.printf("thread:%s, count:%d%n", getName(), count);
            } catch (InterruptedException e) {
                // InterruptedException이 발생하면 스레드의 인터럽트 상태를 복원하고 루프를 종료합니다.
                Thread.currentThread().interrupt(); // 현재 스레드의 인터럽트 상태를 복원합니다.
                System.out.println("Thread was interrupted, stopping...");
                break; // 예외 발생 시 루프를 중단합니다.
            }
        } while (count < countMaxSize);
    }
}
