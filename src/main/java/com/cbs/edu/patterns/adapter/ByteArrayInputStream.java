package com.cbs.edu.patterns.adapter;

public class ByteArrayInputStream extends InputStream {

    private byte[] data;
    private int curr = 0;

    public ByteArrayInputStream(byte[] data) {
        this.data = data;
    }

    @Override
    int read() {
        return data[curr++];
    }
}
