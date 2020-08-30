package com.simplythewest.utd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

/**ToDoItem class creates one ToDoItem object.
 * @author Megan West
 */
@Entity
public class ToDoItem extends ListItem implements Comparable<ToDoItem>{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String description = "";
    private ZonedDateTime timestamp;
    private int priority;
    private boolean completedStatus = false;


    //constructors

    /**Default constructor sets priority at 0. This MUST be updated.
     * It sets CompletedStatus to false, assuming this is a new ToDoItem, it won't
     * have been completed yet.
     * @author Megan West
     */
    protected ToDoItem()
    {
        priority = 0;
        completedStatus = false;
    }

    /**Parameterized constructor sets attributes with provided values:
     * @author Megan West
     * @param description is the description of the list item that is displayed.
     * @param timestamp is the time that the object was created.
     * @param priority is the priority value of the item, determines where it ends up on list.
     * @author Megan West
     */
    public ToDoItem(
        String description, int priority)
    {
        this.description = description;
        this.priority = priority;
        completedStatus = false;
    }

    //accessors
    /**There is an accessor function for each class attribute:
     * CompletedStatus, Description, TimeStamp, and Priority.
     * getDescription and getTimestamp are inherited from ToDoItem class.
     */

    public Long getId(){ return id; }

    /**CompletedStatus is true if the list item has been marked complete.
     * @author Megan West
     * @return boolean. true if item was marked complete, false if incomplete.
     */
    public boolean getCompletedStatus()
    {
        return completedStatus;
    }

    /**getPriority returns the priority value of the list item.
     * priority values are 'URGENT', 'DAILY', 'WEEKLY', and 'MONTHLY'
     * where MONTHLY = 0, WEEKLY = 1, DAILY = 2, URGENT = 3
     * @author Megan West
     * @return int Priority. See note above for values.
     */
    public int getPriority()
    {
        return priority;
    }


    //mutators
    public void setCompletedStatusToOpposite()
    {
        if (completedStatus)
        {
            completedStatus = false;
        }
        else
            completedStatus = true;
    }

    public void setCompletedStatus(boolean newStatus)
    {
        completedStatus = newStatus;
    }

    public void setPriority(int priority)
    {
        priority = priority;
    }


    //helpers

    @Override
    public String toString()
    {
        String theToDoItem = "id: " + id + " description: " + description + " priority: " +
            priority + "completed?" + completedStatus + " timestamp: " + timestamp;
        return theToDoItem;
    }

    public int compareTo(ToDoItem td)
    {
        return Integer.compare(this.priority, td.priority);
    }

}
