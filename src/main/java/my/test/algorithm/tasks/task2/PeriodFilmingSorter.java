package my.test.algorithm.tasks.task2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс нужен для сортировки {@link PeriodFilming}.
 */
public class PeriodFilmingSorter {

    /**
     * Пример из книги.
     * Вход. Множество периодов съемок.
     * Выход. Самое большое подмножество не пересекающихся периодов съемок.
     *
     * @param periodFilmingList
     * @return
     */
    public List<PeriodFilming> sort2(final List<PeriodFilming> periodFilmingList) {
        List<PeriodFilming> returnPeriods = new ArrayList<>();

        PeriodFilming comparePeriod = null;
        LocalDate endDatePeriod = null;

        while (periodFilmingList.size() > 0) {
            System.out.println("===== Go while! PeriodFilmingList size = " + periodFilmingList.size());

            comparePeriod = choiceOfPeriod(periodFilmingList, endDatePeriod);
            System.out.println("Add in returnPeriods " + comparePeriod);
            if (comparePeriod != null) {
                returnPeriods.add(comparePeriod);
                periodFilmingList.remove(comparePeriod);
                endDatePeriod = comparePeriod.getEnd();
                comparePeriod = null;
            }

        }
        System.out.println(returnPeriods);
        return returnPeriods;
    }

    /**
     * Выбор из передого списка самый оптимальный PeriodFilming.
     *
     * @param periodFilmingList
     * @param endDatePeriod
     * @return
     */
    private PeriodFilming choiceOfPeriod(List<PeriodFilming> periodFilmingList, LocalDate endDatePeriod) {
        try {
            PeriodFilming comparePeriod = selectNotOverlapping(periodFilmingList,endDatePeriod);

            for (int i = 1; i < periodFilmingList.size(); i++) {
                System.out.println("== Go cycle " + i);
                PeriodFilming periodFilming = periodFilmingList.get(i);
                System.out.println("Select periodFilming = " + periodFilming);
                if (comparePeriod.getEnd().compareTo(periodFilming.getEnd()) <= 0) {
                    System.out.println("Selected periodFilming  Not validation. Ends after comparePeriod.");
                    continue;
                }
                System.out.println("Set parameters comparePeriod,endDatePeriod " + periodFilming);
                comparePeriod = periodFilming;
            }
            return comparePeriod;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Выбор из списка {@link PeriodFilming} который начинается после переданной {@link LocalDate}.
     * Если  {@link PeriodFilming} не подходит он удаляется из списка.
     *
     * @param periodFilmingList Список из которого нужно выбрать период.
     * @param endDatePeriod     дата раньше которой не должен начинаться период.
     * @return {@link PeriodFilming} который начинается после переданной {@link LocalDate}.
     * @throws Exception если не нашел подходящего {@link PeriodFilming}.
     */
    private PeriodFilming selectNotOverlapping(final List<PeriodFilming> periodFilmingList, LocalDate endDatePeriod) throws Exception {
        for (PeriodFilming periodFilming : periodFilmingList) {
            if (endDatePeriod != null) {
                if (endDatePeriod.compareTo(periodFilming.getStart()) >= 0) {
                    periodFilmingList.remove(periodFilming);
                    continue;
                }
            }
            return periodFilming;
        }
        throw new Exception("Failed find right PeriodFilming.");
    }

}
