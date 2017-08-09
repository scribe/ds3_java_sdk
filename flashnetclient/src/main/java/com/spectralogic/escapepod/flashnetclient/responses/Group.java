package com.spectralogic.escapepod.flashnetclient.responses;

import org.simpleframework.xml.Attribute;

public class Group {
    @Attribute(required = false)
    private String GroupName;

    @Attribute(name = "GroupAge.DWD", required = false)
    private int GroupAge;

    public String getGroupName() {
        return GroupName;
    }

    public int getGroupAge() {
        return GroupAge;
    }
}
