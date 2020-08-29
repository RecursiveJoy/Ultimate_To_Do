package ultimate_to_do;

public class listItem {

    String description;
    java.util.Date dateOfCreation;

    public listItem()
    {
        java.util.Date today = new java.util.Date();
        this.dateOfCreation = today;
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
