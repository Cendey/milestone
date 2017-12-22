package com.mit.lab.util;

import com.mit.lab.comn.Result;
import com.mit.lab.intf.IO;
import com.mit.lab.meta.Nothing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>Title: Blueprint</p>
 * <p>Description: com.mit.lab.util.Console</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: Kewill Co., Ltd</p>
 *
 * @author <chao.deng@kewill.com>
 * @version 1.0
 * @date 12/16/2017
 */
public class Console {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static IO<String> readLine(Nothing nothing) {
        return () -> {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new IllegalStateException((e));
            }
        };
    }

    public static IO<String> readLine() {
        return readLine(Nothing.instance);
    }

    /**
     * Get a string from the console after displaying a message.
     *
     * @param prompt The message prompting the user to enter something
     * @return The string entered by the user
     */
    public static IO<String> readLine(String prompt) {
        return printLine(prompt).flatMap(x -> readLine(Nothing.instance));
    }

    public static IO<Nothing> printLine(Result<Object> r) {
        return () -> {
            r.forEachOrFail(System.out::println)
                .forEach(System.out::println);
            return Nothing.instance;
        };
    }

    public static IO<Nothing> printLine(Object o) {
        return () -> {
            System.out.println(o);
            return Nothing.instance;
        };
    }

    public static IO<Nothing> print(Object s) {
        return () -> {
            System.out.print(s);
            return Nothing.instance;
        };
    }
}