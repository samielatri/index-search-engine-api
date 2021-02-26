package com.indexing.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created bu PacLab
 * User: sami
 * */

@XmlRootElement
public class MatchingFile {

    private String name;

    public MatchingFile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}