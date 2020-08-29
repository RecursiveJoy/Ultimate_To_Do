package ultimate_to_do;

public class todoItem {
    String description;
    int priority;
    java.util.Date dateOfCreation;

    public todoItem()
    {
        java.util.Date today = new java.util.Date();
        this.dateOfCreation = today;
    }

    public String getDescription()
    {
        java.util.Scanner description = new java.util.Scanner(System.in);
        System.out.println("Enter a task\n");


        return description.nextLine();
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }

}
