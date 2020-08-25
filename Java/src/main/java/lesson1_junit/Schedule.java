package lesson1_junit;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {
    private Set<Seance> seances = new TreeSet<>();

    public Set<Seance> getSeances() {
        return seances;
    }

    public boolean addSeance(Seance seance){
        return seances.add(seance);
    }

    public boolean removeSeance(Seance seance){
        if (seances.isEmpty()){
            return false;
        } else {
            return seances.remove(seance);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.seances.containsAll(((Schedule) o).seances);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seances);
    }
}
