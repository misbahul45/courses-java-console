package models.course;

public class CourseImpl implements Course {

    private final String id;
    private final String title;
    private final String description;
    private final int credits;

    public CourseImpl(String id, String title, String description, int credits) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.credits = credits;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getCredits() {
        return credits;
    }
}
