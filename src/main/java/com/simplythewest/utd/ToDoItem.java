package com.simplythewest.utd;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**ToDoItem class creates one ToDoItem object.
 * @author Megan West
 */
@Entity
@Table(name = "to_do_item")
public class ToDoItem extends ListItem implements Comparable<ToDoItem>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "to_do_item_id_seq", allocationSize=50)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String description = "";
    @Column(name = "timestamp")
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
    @Column(name = "id")
    public Long getId(){ return id; }

    /**CompletedStatus is true if the list item has been marked complete.
     * @author Megan West
     * @return boolean. true if item was marked complete, false if incomplete.
     */
    @Column(name = "completed_status")
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
    @Column(name = "priority")
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
        this.priority = priority;
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
