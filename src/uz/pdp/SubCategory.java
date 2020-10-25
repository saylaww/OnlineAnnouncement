package uz.pdp;

public class SubCategory {
    private String name;
    private Category category;

    public SubCategory(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
