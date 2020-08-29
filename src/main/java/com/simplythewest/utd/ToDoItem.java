package com.simplythewest.utd;

public class ToDoItem extends ListItem implements Comparable<ToDoItem>{
    private int priority;
    private boolean completedStatus;


    //accessors
    public ToDoItem()
    {
        priority = 0;
        completedStatus = false;
    }

    public boolean getCompletedStatus()
    {
        return this.completedStatus;
    }

    public int getPriority()
    {
        return this.priority;
    }


    //mutators
    public void setCompletedStatus()
    {
        if (this.completedStatus)
        {
            this.completedStatus = false;
        }
        else
            this.completedStatus = true;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }


    //helpers
    public int compareTo(ToDoItem td)
    {
        return Integer.compare(this.priority, td.priority);
    }

}
