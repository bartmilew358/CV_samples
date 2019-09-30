package app_from_CV.chuck;

public class Joke {

    String categories[];
    String created_at;
    String icon_url;
    String id;
    String updated_at;

    public String[] getCategories() {
        return categories;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public String getId() {
        return id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getUrl() {
        return url;
    }

    public String getValue() {
        return value;
    }

    String url;

    public Joke(String[] categories, String created_at, String icon_url, String id, String updated_at, String url, String value) {
        this.categories = categories;
        this.created_at = created_at;
        this.icon_url = icon_url;
        this.id = id;
        this.updated_at = updated_at;
        this.url = url;
        this.value = value;
    }

    String value;

}
