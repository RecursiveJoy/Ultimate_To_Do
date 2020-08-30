package com.simplythewest.utd;

import javax.persistence.*;
import java.time.ZonedDateTime;

@MappedSuperclass
public class ListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "to_do_item_id_seq", allocationSize=50)
    @Column(name = "id", updatable = false, nullable = false)
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

    @Column(name = "Description")
    public String getDescription()
    {
        return description;
    }

    @Column(name = "timestamp")
    public ZonedDateTime getTimestamp(){ return this.timestamp; }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String toString()
    {
        return description + "" + timestamp;
    }

}
