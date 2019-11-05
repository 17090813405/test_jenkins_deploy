package com.example.demo.consumer;

import java.util.function.Consumer;

/**
 * @author daizhichao
 * @date 2019/11/5
 */
public class ConsumerTest {
    static class Foo {
        private Integer first;

        public Integer getFirst() {
            return first;
        }

        public void setFirst(Integer first) {
            this.first = first;
        }
    }

    public static void main(String[] args) {
        Foo f = new Foo();
        Consumer<Foo> consumerFun = foo -> foo.setFirst(1);
        consumerFun.accept(f);
        System.out.println(f.getFirst());
    }
}
