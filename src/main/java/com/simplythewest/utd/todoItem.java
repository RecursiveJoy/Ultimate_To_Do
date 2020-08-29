package com.simplythewest.utd;

public class todoItem extends listItem implements Comparable<todoItem>{
    int priority;
    boolean completedStatus;


    //accessors
    public todoItem(String description, int priority)
    {

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
            this.completedStatus = false;
        else
            this.completedStatus = true;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }


    //helpers
    public int compareTo(todoItem td)
    {
        return Integer.compare(this.priority, td.priority);
    }

}
