package com.parsing.dbms.service.util;

import java.io.BufferedReader;
import java.io.Reader;

/**
 * Created bu PacLab
 * User: sami
 * Date: 2/10/2021
 * Time: 3:10 PM
 * Package: dbms.service.util
 */
public class NewBufferedReader extends BufferedReader {
    public NewBufferedReader(Reader in, int sz) {
        super(in, sz);
    }

    public NewBufferedReader(Reader in) {
        super(in);
    }
}
