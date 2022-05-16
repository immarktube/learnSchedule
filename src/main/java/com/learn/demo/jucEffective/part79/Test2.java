package com.learn.demo.jucEffective.part79;

import java.util.*;

// More complex test of ObservableSet - Page 318-9
public class Test2 {
    public static void main(String[] args) {
        ObservableSet<Integer> set =
                new ObservableSet<>(new HashSet<>());

        set.addObserver(new SetObserver() {

            @Override
            public void added(ObservableSet set, Object element) {
                added1(set,(Integer)element);
            }

            private void added1(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if (element == 23)
                    set.removeObserver(this);
            }

        });

        for (int i = 0; i < 100; i++)
            set.add(i);
    }
}