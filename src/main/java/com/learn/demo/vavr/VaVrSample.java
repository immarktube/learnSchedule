package com.learn.demo.vavr;

import io.vavr.API;
import io.vavr.Function2;
import io.vavr.collection.List;

import static io.vavr.API.$;
import static io.vavr.API.Case;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">Marktube</a>
 * @Since 2023/9/13 00:18
 **/
public class VaVrSample {

    public static String getName(){
        return "sa";
    }

    public static void main(String[] args) {
        System.out.println(List.of(1, 2, 3).sum());
        Function2<Integer, Integer, Integer> divide = (a,b) -> a/b;

        var safeDivide = Function2.lift(divide);
        var i1 = safeDivide.apply(1, 1);
        System.out.println(i1.get());
        System.out.println(whenMatchWorks_thenCorrect(2));
    }

    public static String whenMatchWorks_thenCorrect(int i) {
        return API.Match(i).of(
                Case($(1), "one"),
                Case($(2), "two"),
                Case($(3), "three"),
                Case($(), "default")
        ).toLowerCase();
    }

}
