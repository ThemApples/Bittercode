package com.example.bittercode;

public interface Crypto {
    byte[] encrypt(byte[] data);
    byte[] decrypt(byte[] data);
}
