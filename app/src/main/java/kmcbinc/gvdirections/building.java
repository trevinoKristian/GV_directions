package kmcbinc.gvdirections;

/**
 * Created by user on 2/20/2016.
 */
public class building {
    private String name, abbreviation, description;

    public building(String name, String abbreviation, String description) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getDescription() {
        return description;
    }
}
