package com.learn.demo.vavr;

import io.vavr.Function1;
import io.vavr.control.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">tubemark</a>
 * @Since 2023/9/13 22:06
 **/
public class VaVrSample_2 {

    private static final Logger logger = LoggerFactory.getLogger(VaVrSample_2.class);
    public static void main(String[] args) {
        Function1<Integer, Integer> plusOne = a -> a + 1;
        Function1<Integer, Integer> multiplyByTwo = a -> a * 2;

        Function1<Integer, Integer> add1AndMultiplyBy2 = plusOne.andThen(multiplyByTwo);

        final var apply = add1AndMultiplyBy2.apply(2);
        System.out.println(apply);
        // Function1<Integer, Integer> add1AndMultiplyBy2 = multiplyByTwo.compose(plusOne);

        System.out.println(add1AndMultiplyBy2.apply(2));

        // Optional<String> maybeFoo = Optional.of("foo");
        // then(maybeFoo.get()).isEqualTo("foo");
        optionUseCases();
    }

    private static void optionUseCases1() {
        Option<String> maybeFoo = Option.of("foo");
        // then(maybeFoo.get()).isEqualTo("foo");
        try {
            maybeFoo.map(s -> (String)null)
                    .map(s -> s.toUpperCase() + "bar");
            // Assert.fail();
            logger.info(maybeFoo.get());
        } catch (NullPointerException e) {
            // this is clearly not the correct approach
            logger.info("Here are a NPE.");
        }
    }

    private static void optionUseCases(){
        Option<String> maybeFoo = Option.of("foo");
        Option<String> maybeFooBar = maybeFoo.map(s -> (String)null)
                .flatMap(s -> Option.of(s)
                        .map(t -> t.toUpperCase() + "bar"));

        Option<String> maybeFooBar2 = maybeFoo.flatMap(s -> Option.of((String)null))
                .map(s -> s.toUpperCase() + "bar");
        logger.info(maybeFooBar2.get());
    }
}
