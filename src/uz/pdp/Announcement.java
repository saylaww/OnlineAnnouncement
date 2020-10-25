package uz.pdp;

public class Announcement {
    private String title;
    private String body;
    private User user;
    private SubCategory subCategory;

    public Announcement(String title, String body, User user, SubCategory subCategory) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.subCategory = subCategory;
    }

    //    public void add(String title, String body, String categ){
//        this.title = title;
//        this.body = body;
//        if (subCategory.getCategory().equals(categ)){
//            this.subCategory.setCategory(categ);
//        }
//
//    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
}
