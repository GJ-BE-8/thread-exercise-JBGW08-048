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

public class SharedCounter {
    private long count;

    public SharedCounter() {
        count = 0L;
    }

    public SharedCounter(long count) {
        // TODO#1-1 생성자를 초기화합니다. count < 0 일 경우 IllegalArgumentException이 발생합니다.
        if (count < 0) {
            throw new IllegalArgumentException("count must be >= 0");
        }
        this.count = count;
    }

    public synchronized long getCount() {
        // TODO#1-2 count를 반환합니다.
        return count;
    }

    public synchronized long increaseAndGet() {
        // TODO#1-3 count = count + 1 증가시키고 count를 반환합니다.
        return ++count; // count를 먼저 증가시키고 그 값을 반환합니다.
    }

    public synchronized long decreaseAndGet() {
        // TODO#1-4 count = count - 1 감소시키고 count를 반환합니다.
        return --count; // count를 먼저 감소시키고 그 값을 반환합니다.
    }
}