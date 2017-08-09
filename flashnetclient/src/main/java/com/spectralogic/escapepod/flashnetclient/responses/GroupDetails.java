package com.spectralogic.escapepod.flashnetclient.responses;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class GroupDetails {
    @Attribute(name = "GroupCount.DWD", required = false)
    private int GroupCount;

    @ElementList(entry = "Group", inline = true)
    private List<Group> Groups;

    public int getGroupCount() {
        return GroupCount;
    }

    public List<Group> getGroups() {
        return Groups;
    }
}
