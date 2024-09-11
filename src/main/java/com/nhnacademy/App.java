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
        // TODO#4 CounterHandler 객체를 생성합니다. countMaxSize는 10으로 설정합니다.
        CounterHandler counterHandler = new CounterHandler(10);

        // TODO#5 CounterHandler 객체를 parameter로 전달하여 Thread 객체를 생성합니다.
        Thread thread = new Thread(counterHandler);

        // TODO#6 Thread의 name을 "my-counter"로 설정합니다.
        thread.setName("my-counter");

        // TODO#7 Thread를 시작합니다.
        thread.start();
    }
}

