package zadania_16_1;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Task {
    ZonedDateTime dataTime;
    String description;
    Boolean  finished;


    public Task(ZonedDateTime dataTime, String description, Boolean finished) {
        this.dataTime = dataTime;
        this.description = description;
        this.finished = finished;
    }

    public Task(ZonedDateTime dataTime, String description) {
        this.dataTime = dataTime;
        this.description = description;
        this.finished = false;
    }

    public ZonedDateTime getDataTime() {
        return dataTime;
    }

    public void setDataTime(ZonedDateTime dataTime) {
        this.dataTime = dataTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return Objects.equals(getDataTime(), task.getDataTime()) &&
                Objects.equals(getDescription(), task.getDescription()) &&
                Objects.equals(getFinished(), task.getFinished());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDataTime(), getDescription(), getFinished());
    }

    @Override
    public String toString() {
        return "Task{" +
                "dataTime=" + dataTime +
                ", description='" + description + '\'' +
                ", finished=" + finished +
                '}'+"\n";
    }
}



