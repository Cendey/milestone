package com.mit.lab.norm;

import com.mit.lab.coms.Result;
import com.mit.lab.intf.Effect;
import com.mit.lab.intf.Function;

import java.util.regex.Pattern;

import static com.mit.lab.coms.Result.failure;
import static com.mit.lab.coms.Result.success;
import static com.mit.lab.meta.Case.matchCase;
import static com.mit.lab.meta.Case.matchOption;

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

    private static Function<String, Result<String>> emailChecker = email ->
        matchOption(
            matchCase(() -> success(email)),
            matchCase(() -> email == null, () -> failure("email must not be null!")),
            matchCase(() -> email.length() == 0, () -> failure("email must not be empty!")),
            matchCase(
                () -> !emailPattern.matcher(email).matches(),
                () -> failure(String.format("email %s is invalid!", email)))
        );

    private static Effect<String> success = s -> System.out.println(String.format("Mail sent to %s", s));

    private static Effect<String> failure = s -> System.out.println(String.format("Error message logged: %s", s));

    public static void validate(String email) {
        emailChecker.apply(email).bind(success, failure);
    }
}
