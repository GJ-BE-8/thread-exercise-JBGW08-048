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

package com.nhnacademy.count;

import java.util.concurrent.locks.ReentrantLock;

public class SharedCounter {
    private long count;
    private final ReentrantLock mutex;

    public SharedCounter(){
        this(0L);
    }

    public SharedCounter(long count) {
        if (count < 0) {
            throw new IllegalArgumentException("count must be >= 0");
        }
        this.count = count;
        // TODO#1-1 ReentrantLock 생성 (공정성 보장)
        mutex = new ReentrantLock(true);
    }

    public long getCount() {
        // TODO#1-2 count를 반환 (동기화)
        mutex.lock(); // lock 획득
        try {
            return count;
        } finally {
            mutex.unlock(); // lock 해제
        }
    }

    public long increaseAndGet() {
        // TODO#1-3 count = count + 1 증가 및 반환 (동기화)
        mutex.lock(); // lock 획득
        try {
            count = count + 1;
            return count;
        } finally {
            mutex.unlock(); // lock 해제
        }
    }

    public long decreaseAndGet() {
        // TODO#1-4 count = count - 1 감소 및 반환 (동기화)
        mutex.lock(); // lock 획득
        try {
            count = count - 1;
            return count;
        } finally {
            mutex.unlock(); // lock 해제
        }
    }
}
