import java.util.Date;
import com.google.gson.annotations.SerializedName;

public class Trip {

    @SerializedName("name")
    private String name;

    @SerializedName("date")
    private Date date;

    @SerializedName("location")
    private String location;

    @SerializedName("price")
    private int price;

    @SerializedName("type")
    private String type;

    @SerializedName("hour")
    private String hour;

    @SerializedName("description")
    private String description;

}
