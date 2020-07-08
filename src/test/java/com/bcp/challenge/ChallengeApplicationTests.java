package com.bcp.challenge;

import rx.Observable;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertTrue;

@SpringBootTest
class ChallengeApplicationTests {

    String result = "";

    String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
    private static String[] titles = {"title"};
    private static List<String> titleList = Arrays.asList(titles);

    @Test
    void contextLoads() {
    }

    @Test
    public void createObservable() {
        result = "";
        Observable<String> observable = Observable.just("Hello");
        observable.subscribe(s -> result = (s));
        assertTrue(result.equals("Hello"));
    }

    @Test
    public void methodsObservable() {
        result = "";
        Observable<String> observable = Observable.from(letters);
        observable.subscribe(
                i -> result += i,
                Throwable::printStackTrace,
                () -> result += "_Completed"
        );
        assertTrue(result.equals("abcdefg_Completed"));
    }

    @Test
    public void testMap() {
        Observable.from(letters)
                .map(String::toUpperCase)
                .subscribe(letter -> result += letter);
        assertTrue(result.equals("ABCDEFG"));
    }

    @Test
    public void testMapTitle() {
        Observable.just("book1", "book2")
                .flatMap(s -> getTitle())
                .subscribe(l -> result += l);
        assertTrue(result.equals("titletitle"));
    }

    static Observable<String> getTitle() {
        return Observable.from(titleList);
    }

}
