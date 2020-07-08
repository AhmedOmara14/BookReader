package tra.wor.bookreader.pojo;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Favorite")
public class info_favorite {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "image")
    private String image;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "author")
    private String author;

    @ColumnInfo(name = "des")
    private String des;

    public int getId() {
        return id;
    }

    public info_favorite(String image, String title, String author, String des) {
        this.image = image;
        this.title = title;
        this.author = author;
        this.des = des;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
