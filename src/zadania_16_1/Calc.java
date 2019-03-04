package zadania_16_1;

import java.time.*;
import java.util.Map;
import java.util.Set;

public class Calc {
    public void printAllData(Map<ZonedDateTime, Task> tasks) {
        Set<ZonedDateTime> key = tasks.keySet();
        Set<Map.Entry<ZonedDateTime, Task>> entrySet = tasks.entrySet();

        for (ZonedDateTime zonedDateTime : key) {
            LocalDateTime lDT = zonedDateTime.toLocalDateTime();
            System.out.println(lDT + " - " + tasks.get(zonedDateTime).getDescription());
        }
    }

    public void printData(Map<ZonedDateTime, Task> tasks, boolean termFuture) {
        InputOutputData inpOuData = new InputOutputData();
        ZonedDateTime nowData = inpOuData.nowD;
        Set<ZonedDateTime> key = tasks.keySet();

        if (termFuture) {
            System.out.println("Zadanie przyszłe");
            printFutureZone(tasks, nowData, key);
        } else {
            System.out.println("Zadanie przeszłe");
            printPastZone(tasks, nowData, key);
        }
    }

    private void printPastZone(Map<ZonedDateTime, Task> tasks, ZonedDateTime nowData, Set<ZonedDateTime> key) {
        for (ZonedDateTime zonedDateTime : key) {
            LocalDateTime lDT = zonedDateTime.toLocalDateTime();
            Duration duration = Duration.between(nowData, zonedDateTime);
            int i = 0;
            if (duration.getSeconds() < 0) {
                System.out.println(++i + ". - " + lDT + " - " + tasks.get(zonedDateTime).getDescription());
            }
        }
    }

    private void printFutureZone(Map<ZonedDateTime, Task> tasks, ZonedDateTime nowData, Set<ZonedDateTime> key) {
        doTo24Hour(tasks, nowData, key);
        doTo30Days(tasks, nowData, key);
        doInThisWeek(tasks, nowData, key);
    }

    private void doInThisWeek(Map<ZonedDateTime, Task> tasks, ZonedDateTime nowData, Set<ZonedDateTime> key) {
        System.out.println("Zadania do wykonanie w tym  tygodniu");
        System.out.println(nowData.getDayOfWeek());

        int iLastWeek = 0;
        LocalDateTime lDT1 = nowData.toLocalDateTime();
        int lastDay = 0;
        switch (lDT1.getDayOfWeek()) {
            case MONDAY:
                lastDay = 6;
                break;
            case TUESDAY:
                lastDay = 5;
                break;
            case WEDNESDAY:
                lastDay = 4;
                break;
            case THURSDAY:
                lastDay = 3;
                break;
            case FRIDAY:
                lastDay = 2;
                break;
            case SATURDAY:
                lastDay = 1;
                break;
            case SUNDAY:
                lastDay = 0;
                break;
        }
        LocalDate localDate1 = nowData.toLocalDate();
        for (ZonedDateTime zonedDateTime : key) {
            LocalDateTime lDT = zonedDateTime.toLocalDateTime();
            LocalDate localDate = zonedDateTime.toLocalDate();

            Duration duration = Duration.between(lDT1, zonedDateTime);
            Period period = Period.between(localDate1, localDate);

            if (duration.toSeconds() >= 0 && duration.toDays() < 7 && period.getDays() <= lastDay) {
                    System.out.println(++iLastWeek + ". - " + lDT + " - " + tasks.get(zonedDateTime).getDescription() );
            }
        }
    }

    private void doTo30Days(Map<ZonedDateTime, Task> tasks, ZonedDateTime nowData, Set<ZonedDateTime> key) {
        System.out.println("Zadanie do wykonanie w ciągu 30 dni");
        int i30d = 0;
        for (ZonedDateTime zonedDateTime : key) {
            LocalDateTime lDT = zonedDateTime.toLocalDateTime();
            Duration duration = Duration.between(nowData, zonedDateTime);
            if (duration.toSeconds() >= 0 && duration.toDays() <= 30) {
                System.out.println(++i30d + ". - " + lDT + " - " + tasks.get(zonedDateTime).getDescription());
            }
        }
    }

    private void doTo24Hour(Map<ZonedDateTime, Task> tasks, ZonedDateTime nowData, Set<ZonedDateTime> key) {
        int i24h = 0;
        System.out.println("Zadanie do wykonanie w ciągu 24 godzin");
        for (ZonedDateTime zonedDateTime : key) {
            LocalDateTime lDT = zonedDateTime.toLocalDateTime();
            Duration duration = Duration.between(nowData, zonedDateTime);
            if (duration.toSeconds() >= 0 && duration.toHours() <= 24) {
                System.out.println(++i24h + ". - " + lDT + " - " + tasks.get(zonedDateTime).getDescription());
            }
        }
    }
}