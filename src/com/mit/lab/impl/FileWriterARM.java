package com.mit.lab.impl;

import java.io.FileWriter;
import java.io.IOException;

/**
 * <p>Title: Blueprint</p>
 * <p>Description: FileWriterARM</p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: MIT-LAB Co., Ltd</p>
 *
 * @author Developer
 * @version 1.0
 * @date 4/24/2014
 */
public class FileWriterARM implements AutoCloseable {

    private final FileWriter writer;

    public FileWriterARM(final String fileName) throws IOException {
        writer = new FileWriter(fileName);
    }

    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }

    public void close() throws IOException {
        System.out.println("close called automatically...");
        writer.close();
    }
}
