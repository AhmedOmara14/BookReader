package tra.wor.bookreader.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class volumeInfo {
    @SerializedName("title")
    @Expose
   private String title;
    @SerializedName("authors")
    @Expose
   private ArrayList authors;
    @SerializedName("description")
    @Expose
   private String description;
    @SerializedName("imageLinks")
    @Expose
    imageLinks imageLinks;

    public volumeInfo(String title, ArrayList authors, String description, tra.wor.bookreader.pojo.imageLinks imageLinks) {
        this.title = title;
        this.authors = authors;
        this.description = description;
        this.imageLinks = imageLinks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public tra.wor.bookreader.pojo.imageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(tra.wor.bookreader.pojo.imageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }
}
