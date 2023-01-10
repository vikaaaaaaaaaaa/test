package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;

public class TestHelper {
    @Test
    public void shortFind() {
        assertEquals(3, Helper.findShort("hey world"));
    }

    @Test
    public void testStraySuccess1() {
        int[] arr = {1, 3, 1, 2, 2};
        int actual = Helper.stray(arr);
        assertEquals(3, actual);
    }

    @Test
    public void testStraySuccess2() {
        int[] arr1 = {9, 9, 9, 9, 9, 5, 5, 66};
        int actual2 = Helper.stray(arr1);
        assertEquals(66, actual2);
    }

    @Test
    public void testStrayFail() {
        int[] arr2 = {9, 9, 9, 7};
        int actual3 = Helper.stray(arr2);
        assertNotEquals(9, actual3);
    }

    @Test
    public void mostFrequentItemCountTest() {
        int[] arr1 = {9, 9, 9, 9, 9, 5, 5, 66};
        HashMap<Integer, Integer> cat = new HashMap<>();
        cat.put(5, 2);
        cat.put(9, 5);
        cat.put(66, 1);
        MockedStatic<Helper2> helper = Mockito.mockStatic(Helper2.class);
        helper.when(() -> Helper2.getFrequentMap(any())).thenReturn(cat);
        int maxValue = Helper.mostFrequentItemCount(arr1);
        assertEquals(5, maxValue);
    }
//    @Test
//    public void test5(){
//        int[] array = {3,2,1};
//        int count=6;
//        MockedStatic<Helper> helper = Mockito.mockStatic(Helper.class);
//        helper.when(() -> Helper.calculate(any())).thenReturn(count);
//        int arr=Helper2.multiplicateAndSum(array);
//        assertEquals(6,arr);

    @Test
    public void turnNumberSuccess() {
        int[] arr = {2, 5, 4, 0, 48, 1};
        int[] arrOdd = {5, 0, 1};
        MockedStatic<Helper2> helper = Mockito.mockStatic(Helper2.class);
        helper.when(() -> Helper2.removeEvenNumbers(any())).thenReturn(arrOdd);
        long answer = Helper.turnNumber(arr);
        assertEquals(answer, 501);
    }

    @Test
    public void turnNumberNull() {
        int[] arrOdd = {5, 0, 1};
        MockedStatic<Helper2> helper = Mockito.mockStatic(Helper2.class);
        helper.when(() -> Helper2.removeEvenNumbers(any())).thenReturn(arrOdd);
        long answer = Helper.turnNumber(null);
        assertEquals(answer, 501);
    }

    @Test
    public void turnNumberFail() {
        int[] arr = {2, 5, 4, 0, 48, 1};
        int[] arrOdd = {5, 0, 1};
        MockedStatic<Helper2> helper = Mockito.mockStatic(Helper2.class);
        helper.when(() -> Helper2.removeEvenNumbers(any())).thenReturn(arrOdd);
        long answer = Helper.turnNumber(arr);
        assertNotEquals(answer, 105);
    }

    @Test
    public void sumNumberSuccess() {
        String[] firstArray = {"3", "2", ",", "1", ")", "4"};
        String numberText = "3214";
        MockedStatic<Helper> helper = Mockito.mockStatic(Helper.class);
        helper.when(() -> Helper.leftNumbers(any())).thenReturn(numberText);
        long answer1 = Helper2.sumNumbers(firstArray);
        assertEquals(answer1, 3214l);
    }

    @Test
    public void sumNumberFail() {
        String[] firstArray = {"3", "2", ",", "1", ")", "4"};
        String numberText = "3214";
        MockedStatic<Helper> helper = Mockito.mockStatic(Helper.class);
        helper.when(() -> Helper.leftNumbers(any())).thenReturn(numberText);
        long answer1 = Helper2.sumNumbers(firstArray);
        assertNotEquals(answer1, 2314l);
    }

    @Test
    public void sumNumberNull() {
        String numberText = "3214";
        MockedStatic<Helper> helper = Mockito.mockStatic(Helper.class);
        helper.when(() -> Helper.leftNumbers(any())).thenReturn(numberText);
        long answer1 = Helper2.sumNumbers(null);
        assertEquals(answer1, 3214l);
    }
}
