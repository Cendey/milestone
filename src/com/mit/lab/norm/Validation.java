package com.mit.lab.norm;

import com.mit.lab.comn.Result;
import com.mit.lab.intf.Executable;
import com.mit.lab.intf.Function;

import java.util.regex.Pattern;

/**
 * <p>Title: Blueprint</p>
 * <p>Description: com.mit.lab.norm.Validation</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: Kewill Co., Ltd</p>
 *
 * @author <chao.deng@kewill.com>
 * @version 1.0
 * @date 12/19/2017
 */
public class Validation {

    private static Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
    private static Function<String, Result<String>> emailChecker = s ->
        s == null ? new Result.Failure<>("email must not be null") :
            s.length() == 0 ? new Result.Failure<>("email must not be empty") :
                emailPattern.matcher(s).matches() ? new Result.Success<>(s) :
                    new Result.Failure<>(String.format("email %s is invalid.", s));

    private static void logError(String error) {
        System.out.println(String.format("Error message logged: %s", error));
    }

    private static void sendVerificationMail(String message) {
        System.out.println(String.format("Mail sent to %s", message));
    }

    public static Executable validate(String email) {
        Result<String> result = emailChecker.apply(email);
        return (result instanceof Result.Success) ? () -> sendVerificationMail(result.getMessage()) :
            () -> logError(result.getMessage());
    }
}
