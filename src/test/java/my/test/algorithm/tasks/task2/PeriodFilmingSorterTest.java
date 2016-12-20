package my.test.algorithm.tasks.task2;

import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita on 12.10.2016.
 */
public class PeriodFilmingSorterTest {


    @Test
    public void sort() throws Exception {
        List<PeriodFilming> periodFilmingList = creadePeriodFilmingList();
        List<PeriodFilming> sort = new PeriodFilmingSorter().sort2(periodFilmingList);
    }

    public List<PeriodFilming> creadePeriodFilmingList() throws ParseException {
        ArrayList<PeriodFilming> filmings = new ArrayList<>();
        filmings.add(createPeriodFilming("The film 01-02", "01.10.2016", "02.10.2016"));
        filmings.add(createPeriodFilming("The film 05-05", "05.10.2016", "05.10.2016"));
        filmings.add(createPeriodFilming("The film 07-08", "07.10.2016", "08.10.2016"));

        filmings.add(createPeriodFilming("The film 09-09", "09.10.2016", "09.10.2016"));
        filmings.add(createPeriodFilming("The film 10-10", "10.10.2016", "10.10.2016"));
        filmings.add(createPeriodFilming("The film 02-04", "02.10.2016", "04.10.2016"));
        filmings.add(createPeriodFilming("The film 04-08", "04.10.2016", "08.10.2016"));
        filmings.add(createPeriodFilming("The film 08-10", "08.10.2016", "10.10.2016"));
        filmings.add(createPeriodFilming("The film 11-14", "11.10.2016", "14.10.2016"));
        filmings.add(createPeriodFilming("The film 12-13", "12.10.2016", "13.10.2016"));
        return filmings;
    }

    public PeriodFilming createPeriodFilming(String name, String time1, String time2) throws ParseException {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return new PeriodFilming(
                name,
                LocalDate.parse(time1, formatter),
                LocalDate.parse(time2, formatter));
    }

}