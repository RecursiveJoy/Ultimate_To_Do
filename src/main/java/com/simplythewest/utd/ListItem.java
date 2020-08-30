package com.simplythewest.utd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
public class ListItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
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

    public String toString()
    {
        return description + "" + timestamp;
    }

}
