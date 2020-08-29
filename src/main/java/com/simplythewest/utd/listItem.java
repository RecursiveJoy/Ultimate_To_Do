package com.simplythewest.utd;

import java.time.ZonedDateTime;

public class listItem {

    String description;
    ZonedDateTime timestamp;

    public listItem()
    {
        this.timestamp = ZonedDateTime.now();
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
