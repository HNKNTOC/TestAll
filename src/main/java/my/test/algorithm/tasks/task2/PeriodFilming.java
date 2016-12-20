package my.test.algorithm.tasks.task2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * В данный класс нужен для работы с временем съёмок фильма.
 */
public class PeriodFilming {
    private final String nameMovie;
    private final LocalDate start;
    private final LocalDate end;
    private final int sizeDay;

    public PeriodFilming(String nameMovie, LocalDate start, LocalDate end) {
        this.nameMovie = nameMovie;

        if(start.compareTo(end) > 0){
            throw new IllegalArgumentException("Start not after end!");
        }

        this.start = start;
        this.end = end;

        sizeDay = (int) ChronoUnit.DAYS.between(start,end);
    }

    public int getSizeDay() {
        return sizeDay;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "PeriodFilming{" +
                "nameMovie='" + nameMovie + '\'' +
                '}';
    }
}
