package com.mit.lab.norm;

import com.mit.lab.comn.Result;
import com.mit.lab.intf.Effect;
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
    private static Function<String, Result<String>> emailChecker = emailAddress ->
        emailAddress == null ? new Result.Failure<>("email must not be null") :
            emailAddress.length() == 0 ? new Result.Failure<>("email must not be empty") :
                emailPattern.matcher(emailAddress).matches() ? new Result.Success<>(emailAddress) :
                    new Result.Failure<>(String.format("email %s is invalid.", emailAddress));

    private static Effect<String> success = s -> System.out.println(String.format("Mail sent to %s", s));

    private static Effect<String> failure = s -> System.out.println(String.format("Error message logged: %s", s));

    public static void validate(String email) {
        emailChecker.apply(email).bind(success, failure);
    }
}
