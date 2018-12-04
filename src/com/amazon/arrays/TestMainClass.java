package com.amazon.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestMainClass {
    public static void main(String args[] ) throws Exception {
        TestMainClass testMainClass = new TestMainClass();
        testMainClass.testObject();



        //System.out.println("Enter your name" + pairs);
    }

    private static List<String> getError(TestObject testObject)
    {
        return Optional.ofNullable(testObject.error).orElse(new ArrayList<>());
    }

    public void testObject(){
        List<TestObject> list = new ArrayList<>();
        TestObject t1 = new TestObject();
        list.add(t1);
        List<String> errors = list.stream()
                .map(TestMainClass::getError)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(errors);
    }

    class TestObject {
        public List<String> error;
    }



    private static void checkIfPassed(Pair p, int[] test, Pair[] pairs, boolean flag){
        Pair temp = findPairWith(pairs, p.y);





        if (temp == null ){
            if(test[p.x -1] == 1 && test[p.y -1] == 1 && flag){
                System.out.println("YES");
                flag = true;
                //return true;
            }else {
                //return false;
                System.out.println("NO");
                flag = false;
            }
        }else {
            checkIfPassed(temp,test,pairs,flag);
            /*if(!res){
                return false;
            }else {
                if(test[p.x] == 1 && test[p.y] == 1){
                    return true;
                }else {
                    return false;
                }
            }*/
        }
    }

    private static Pair findPairWith(Pair[] pairs, int y) {
        for (Pair pair : pairs) {
            if (pair.x == y) {
                return pair;
            }
        }
        return null;
    }

    private static class Pair{
        int x;
        int y;
    }
}
