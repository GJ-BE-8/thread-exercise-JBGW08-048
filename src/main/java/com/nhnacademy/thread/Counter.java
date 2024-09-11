package com.nhnacademy.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Counter {
    private final long countMaxSize;
    private long count;

    public Counter(long countMaxSize) {
        // TODO#1 countMaxSize < 0 작다면 IllegalArgumentException 예외가 발생 합니다.
        if (countMaxSize < 0) {
            throw new IllegalArgumentException("countMaxSize must be non-negative");
            //예외 처리에서 오 ㅐ오류가 뜰까용?
        }

        // TODO#2 this.countMaxSize 초기화 합니다.
        this.countMaxSize = countMaxSize;

        // TODO#3 this.count 값을 0으로 초기화 합니다.
        this.count = 0;
    }

    public void run() {
        do {
            try {
                // TODO#4 1초 간격 으로 count++ 됩니다.
                // Thread.sleep method를 사용하세요.
                Thread.sleep(1000); // 1초 대기 (1000 밀리초)

                count++; // count 증가

                // TODO#5 count 출력
                // name:{Thread name}, count:{count 변수}
                System.out.printf("name:%s, count:%d%n", Thread.currentThread().getName(), count);
            } catch (InterruptedException e) {
                // InterruptedException이 발생하면 스레드의 인터럽트 상태를 복원하고 루프를 종료합니다.
                Thread.currentThread().interrupt(); // 현재 스레드의 인터럽트 상태를 복원합니다.
                System.out.println("Thread was interrupted, stopping...");
                break; // 예외 발생 시 루프를 중단합니다.
            } catch (IllegalArgumentException e) {
                // IllegalArgumentException을 개별적으로 처리합니다.
                System.err.println("Illegal argument: " + e.getMessage());
                break; // 필요에 따라 루프 중단
            } catch (Throwable t) {
                // 기타 모든 예외를 처리합니다.
                System.err.println("An unexpected error occurred: " + t.getMessage());
                t.printStackTrace();
                break; // 필요에 따라 루프 중단
            }

        } while (count < countMaxSize);
    }
}
