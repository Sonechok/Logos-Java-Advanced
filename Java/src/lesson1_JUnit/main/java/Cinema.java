import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Cinema {
    TreeMap<Days, Schedule> schedules;
    private ArrayList<Movie> moviesLibrary = new ArrayList<>();
    private Time open;
    private Time close;

    public Cinema(Time open, Time close) {
        if (close.getHour()<open.getHour()) {
            throw new IllegalArgumentException("Invalid data");
        } else if (close.getHour()==open.getHour()){
            if (close.getMin()<open.getMin()){
                throw new IllegalArgumentException("Invalid data");
            }
        } else {
            this.open = open;
            this.close = close;
        }

    }

    public boolean addMovie (Movie movie){
        return moviesLibrary.add(movie);
    }

    public Schedule addSeance (Seance[] seances, String day){
        Schedule schedule = new Schedule();
        for (Seance seance: seances) {
            schedule.addSeance(seance);
        }
        if (day.equalsIgnoreCase("monday")){
            return schedules.put(Days.MONDAY,schedule);
        } else if(day.equalsIgnoreCase(("tuesday"))){
            return schedules.put(Days.TUESDAY, schedule);
        }else if(day.equalsIgnoreCase(("wednesday"))){
            return schedules.put(Days.WEDNESDAY, schedule);
        } else if(day.equalsIgnoreCase(("thursday"))){
            return schedules.put(Days.THURSDAY, schedule);
        } else if(day.equalsIgnoreCase(("friday"))){
            return schedules.put(Days.FRIDAY, schedule);
        } else if(day.equalsIgnoreCase(("saturday"))){
            return schedules.put(Days.SATURDAY, schedule);
        } else {
            return schedules.put(Days.SUNDAY, schedule);
        }

    }

    public Movie removeMovie(Movie movie){
        if(moviesLibrary.isEmpty()){
            System.out.println("Тека з фільмами пуста");
            return null;
        } else {
            int index = 0;
            for (int i = 0; i < moviesLibrary.size(); i++) {
                if (moviesLibrary.get(i).equals(movie)) {
                    index = i;
                    break;
                }
            }
            return moviesLibrary.remove(index);
        }
    }

    public Seance removeSeance(Seance seance, String day){
        if (schedules.isEmpty()){
            System.out.println("Ще немає запланованих сеансів");
        } else {
            Schedule scheduleOfDay = new Schedule();
            if (day.equalsIgnoreCase("monday")) {
                scheduleOfDay = schedules.get(Days.MONDAY);
            } else if (day.equalsIgnoreCase(("tuesday"))) {
                scheduleOfDay = schedules.get(Days.TUESDAY);
            } else if (day.equalsIgnoreCase(("wednesday"))) {
                scheduleOfDay = schedules.get(Days.WEDNESDAY);
            } else if (day.equalsIgnoreCase(("thursday"))) {
                scheduleOfDay = schedules.get(Days.THURSDAY);
            } else if (day.equalsIgnoreCase(("friday"))) {
                scheduleOfDay = schedules.get(Days.FRIDAY);
            } else if (day.equalsIgnoreCase(("saturday"))) {
                scheduleOfDay = schedules.get(Days.SATURDAY);
            } else {
                scheduleOfDay = schedules.get(Days.SUNDAY);
            }
            Iterator<Seance> iterator = scheduleOfDay.getSeances().iterator();
            while (iterator.hasNext()) {
                Seance node = iterator.next();
                if (node.equals(seance))
                    return node;
            }
        }
        return null;
    }

}
