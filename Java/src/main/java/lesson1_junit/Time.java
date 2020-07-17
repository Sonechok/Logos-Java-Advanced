package lesson1_junit;

import java.util.Objects;

public class Time implements Comparable<Time>{
    private int min;
    private int hour;

    public Time(int min, int hour) {
        if(min<0 || min>60 || hour<0 || hour>24){
            throw new IllegalArgumentException("Invalid data");
        } else {
            this.min = min;
            this.hour = hour;
        }
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        if(min<0 || min>60){
            throw new IllegalArgumentException("Invalid data");
        } else {
            this.min = min;
        }
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if(hour<0 || hour>24){
            throw new IllegalArgumentException("Invalid data");
        } else {
            this.hour = hour;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return min == time.min &&
                hour == time.hour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, hour);
    }

    @Override
    public int compareTo(Time o) {
        if (this.getHour()>o.getHour()){
            return 1;
        } else if (this.getHour()==o.getHour()){
            return 0;
        } else {
            return -1;
        }
    }
}
