package com.VR;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapTest {
    Swap swap = new Swap();
    @Test
    void swapNumbers() {
        int[] arr ={2,1};
        assertArrayEquals(arr,swap.swapNumbers(1,2),()->"Swap is wrong");
    }
}