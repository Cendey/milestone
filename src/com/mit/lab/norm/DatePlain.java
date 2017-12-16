package com.mit.lab.norm;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>Project    : Blueprint</p>
 * <p>Description: com.mit.lab.norm.DatePlain</p>
 * <p>Abstract   : Add summary information</p>
 * <p>Copyright  : Copyright (c) 2015</p>
 * <p>Company    : MIT Co., Ltd</p>
 *
 * @author <chao.deng@kewill.com>
 * @version 1.0
 * @date 1/13/2015
 */
public class DatePlain {

    private DatePlain() {
        format = new SimpleDateFormat();
    }

    public static DatePlain getInstance() {
        if (instance == null) {
            synchronized (DatePlain.class) {
                if (instance == null) {
                    instance = new DatePlain();
                }
            }
        }
        return instance;
    }

    private final static class DateContentsHolder {

        private final static DatePlain INSTANCE = new DatePlain();
    }

    public static DatePlain popInstance() {
        return DateContentsHolder.INSTANCE;
    }

    public Date popUpDate(String plain, String value) {
        try {
            format.applyPattern(value);
            return new Timestamp(format.parse(plain).getTime());
        } catch (ParseException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        return null;
    }

    private SimpleDateFormat format;
    private static volatile DatePlain instance = null;
    private static Logger logger = Logger.getLogger(DatePlain.class.toString());
}
