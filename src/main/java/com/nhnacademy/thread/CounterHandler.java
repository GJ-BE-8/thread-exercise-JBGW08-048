/*
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Copyright 2024. NHN Academy Corp. All rights reserved.
 * + * While every precaution has been taken in the preparation of this resource,  assumes no
 * + responsibility for errors or omissions, or for damages resulting from the use of the information
 * + contained herein
 * + No part of this resource may be reproduced, stored in a retrieval system, or transmitted, in any
 * + form or by any means, electronic, mechanical, photocopying, recording, or otherwise, without the
 * + prior written permission.
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

package com.nhnacademy.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// TODO#1 Runnable 인터페이스를 implements 합니다.
public class CounterHandler implements Runnable {
    private final long countMaxSize;
    private long count;

    public CounterHandler(long countMaxSize) {
        // TODO#2 countMaxSize <= 0 이면 IllegalArgumentException이 발생합니다.
        if (countMaxSize <= 0) {
            throw new IllegalArgumentException("countMaxSize must be greater than 0");
        }
        this.countMaxSize = countMaxSize;
        this.count = 0;
    }

    @Override
    public void run() {
        // TODO#3 run 메서드를 구현합니다.
        do {
            try {
                // 1초 간격으로 대기
                Thread.sleep(1000); // 1000 밀리초 = 1초

                count++; // count 증가

                // 결과 출력
                System.out.printf("thread:%s, count:%d%n", Thread.currentThread().getName(), count);
            } catch (InterruptedException e) {
                // InterruptedException 발생 시 인터럽트 상태 복원 및 종료
                Thread.currentThread().interrupt(); // 현재 스레드의 인터럽트 상태를 복원합니다.
                System.out.println("Thread was interrupted, stopping...");
                break; // 루프를 종료합니다.
            }
        } while (count < countMaxSize);
    }
}
