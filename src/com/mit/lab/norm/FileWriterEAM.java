package com.mit.lab.norm;

import com.mit.lab.intf.UseInstance;

import java.io.FileWriter;
import java.io.IOException;

/**
 * <p>Title: Blueprint</p>
 * <p>Description: FileWriterEAM</p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: MIT-LAB Co., Ltd</p>
 *
 * @author Developer
 * @version 1.0
 * @date 4/24/2014
 */
public class FileWriterEAM {

    private final FileWriter writer;

    private FileWriterEAM(final String fileName) throws IOException {
        writer = new FileWriter(fileName);
    }

    private void close() throws IOException {
        System.out.println("close called automatically...");
        writer.close();
    }

    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }

    public static void use(final String fileName, final UseInstance<FileWriterEAM, IOException> block)
        throws IOException {
        final FileWriterEAM fileWriterEAM = new FileWriterEAM(fileName);
        try {
            block.accept(fileWriterEAM);
        } finally {
            fileWriterEAM.close();
        }
    }
}
