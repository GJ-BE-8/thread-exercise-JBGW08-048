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
public class CounterHandler implements Runnable {
    private final long countMaxSize;
    private long count;

    public CounterHandler(long countMaxSize) {
        // TODO#1 countMaxSize가 0 이하인 경우 IllegalArgumentException 예외를 발생시킵니다.
        if (countMaxSize <= 0) {
            throw new IllegalArgumentException("countMaxSize must be greater than 0");
        }

        // TODO#2 countMaxSize 값을 초기화하고 count를 0으로 초기화합니다.
        this.countMaxSize = countMaxSize;
        this.count = 0;
    }

    @Override
    public void run() {
        do {
            try {
                // TODO#3 1초 간격으로 count 값을 증가시킵니다.
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO#4 InterruptedException을 RuntimeException으로 감싸서 발생시킵니다.
                Thread.currentThread().interrupt(); // 스레드의 인터럽트 상태를 복원합니다.
                log.error("Thread was interrupted", e);
                return; // 인터럽트가 발생하면 스레드를 종료합니다.
            }

            count++;
            // TODO#5 현재 스레드의 이름과 count 값을 로그로 출력합니다.
            log.debug("thread:{}, count:{}", Thread.currentThread().getName(), count);
        } while (count < countMaxSize);
    }
}
