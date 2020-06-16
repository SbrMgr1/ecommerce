package models;

import helpers.MyHelper;

public class CMS {
    private Long id;
    private String title;
    private String slug;
    private String description;
    public CMS(String title, String slug, String description) {
        this.id= MyHelper.getRandomInt();
        this.title = title;
        this.slug = slug;
        this.description = description;
    }
    public CMS() {
        this.id = MyHelper.getRandomInt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
