package entity;

public class Task {
    private Integer id;

    private Integer course_id;

    private Integer number_of_day;

    private String task;

    private String links;

    private Boolean isDone;

    public Task(Integer id, Integer course_id, Integer number_of_day, String task, String links, Boolean isDone) {
        this.id = id;
        this.course_id = course_id;
        this.number_of_day = number_of_day;
        this.task = task;
        this.links = links;
        this.isDone = isDone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Integer getNumber_of_day() {
        return number_of_day;
    }

    public void setNumber_of_day(Integer number_of_day) {
        this.number_of_day = number_of_day;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", course_id=" + course_id +
                ", number_of_day=" + number_of_day +
                ", task='" + task + '\'' +
                ", links='" + links + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}
