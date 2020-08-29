package com.simplythewest.utd;

import java.time.ZonedDateTime;

public class ListItem {

    private String description;
    private ZonedDateTime timestamp;

    public ListItem()
    {
        this.timestamp = ZonedDateTime.now();
        description = "";
    }

    public ListItem(String description)
    {
        this.timestamp = ZonedDateTime.now();
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

}
