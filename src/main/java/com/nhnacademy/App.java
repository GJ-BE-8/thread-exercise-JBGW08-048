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

package com.nhnacademy;

import com.nhnacademy.thread.CounterHandler;

public class App {
    public static void main(String[] args) {
        // TODO#1 CounterHandler 객체를 생성합니다. countMaxSize는 10으로 설정합니다.
        CounterHandler counterHandler = new CounterHandler(10);

        // TODO#2 threadA를 생성할 때 counterHandler 객체를 parameter로 전달합니다.
        Thread threadA = new Thread(counterHandler);

        // TODO#3 threadA의 이름을 'my-counter-A'로 설정합니다.
        threadA.setName("my-counter-A");

        // TODO#4 threadB를 생성할 때 counterHandler 객체를 parameter로 전달합니다.
        Thread threadB = new Thread(counterHandler);

        // TODO#5 threadB의 이름을 'my-counter-B'로 설정합니다.
        threadB.setName("my-counter-B");

        // TODO#7 threadA를 시작합니다.
        threadA.start();

        // TODO#8 threadB를 시작합니다.
        threadB.start();
    }
}
