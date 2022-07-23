package consultorio.clasesApp;

import java.util.Comparator;

public class TurnoComparador implements Comparator<Turno> {

    @Override
    public int compare(Turno o1, Turno o2) {
        if ((o1.getFecha().compareTo(o2.getFecha()) <= 0)) {
            return -1;
        } else {
            if ((o1.getFecha().compareTo(o2.getFecha()) >= 0)) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

