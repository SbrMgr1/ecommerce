package models;

public class CMS {
    private String title;
    private String Slug;
    private String description;
    public CMS(String title, String slug, String description) {
        this.title = title;
        Slug = slug;
        this.description = description;
    }
    public CMS()
    {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return Slug;
    }

    public void setSlug(String slug) {
        Slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
