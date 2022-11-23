package com.leetcode.easy.bitwise;

// https://leetcode.com/problems/decode-xored-array

public class DecodeXORedArray {

    public int[] decode(int[] encoded, int first) {
        int[] decoded = new int[encoded.length + 1];
        decoded[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            decoded[i+1] = encoded[i] ^ decoded[i];
        }
        return decoded;
    }
}
