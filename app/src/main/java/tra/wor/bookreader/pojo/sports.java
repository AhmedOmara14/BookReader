package tra.wor.bookreader.pojo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class sports {
    @SerializedName("image")
    @Expose
    private int image;
    @SerializedName("name")
    @Expose
    private String name;



    public sports(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
