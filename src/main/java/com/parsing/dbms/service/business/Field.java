package com.parsing.dbms.service.business;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created bu PacLab
 * User: sami
 * Date: 2/10/2021
 * Time: 11:38 AM
 * Package: dbms.service.business
 */
public interface Field extends Serializable {

    // TODO: change String operator to Enum operator
    public int compare(Field field, String operator);

    // TODO: change to Type
    public void getType();

    void serialize(DataOutputStream dataOutputStream) throws IOException;
    public int hashcode();
    public boolean equals(Object filedObject);
    public String toString();
}
