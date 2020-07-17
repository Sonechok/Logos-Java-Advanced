package lesson1_junit;

import java.util.Objects;

public class Seance implements Comparable<Seance>{
    private Movie movie;
    private Time startTime;
    private Time endTime;

    public Seance(String title, Time startTime, Time endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.movie = new Movie(title, new Time(Math.abs(endTime.getMin()-startTime.getMin()), endTime.getHour()-startTime.getHour()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seance seance = (Seance) o;
        return this.movie.equals(seance.movie) &&
                this.startTime.equals(seance.startTime) &&
                this.endTime.equals(seance.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, startTime, endTime);
    }

    @Override
    public int compareTo(Seance o) {
        return this.startTime.compareTo(o.startTime);
    }
}
