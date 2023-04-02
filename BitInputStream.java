package aziz.decomp_projet_algo;

import java.io.*;

public class BitInputStream extends FilterInputStream {
    private int bitBuffer;
    private int bitBufferSize;

    public BitInputStream(InputStream in) {
        super(in);
        bitBuffer = 0;
        bitBufferSize = 0;
    }

    public int read() throws IOException {
        if (bitBufferSize == 0) {
            return super.read();
        } else {
            throw new IllegalStateException("Cannot read a full byte.");
        }
    }

    public int readBit() throws IOException {
        if (bitBufferSize == 0) {
            bitBuffer = super.read();
            if (bitBuffer == -1) {
                return -1;
            }
            bitBufferSize = 8;
        }
        int bit = bitBuffer >> (bitBufferSize - 1);
        bitBufferSize--;
        return bit;
    }

    public int readBits(int numBits) throws IOException {
        int bits = 0;
        for (int i = 0; i < numBits; i++) {
            int bit = readBit();
            if (bit == -1) {
                return -1;
            }
            bits = (bits << 1) | bit;
        }
        return bits;
    }
}
	


