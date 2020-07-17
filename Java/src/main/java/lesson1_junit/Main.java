package lesson1_junit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(new Time(30, 8), new Time(30, 22));
        Scanner scanner = new Scanner(System.in);
        String title;
        String day;
        int hour;
        int startHour;
        int endHour;
        int min;
        int startMin;
        int endMin;
        int menuSelector;
        while (true) {
            System.out.println("Ласкаво просимо в кінотеатрі, зробіть наступний вибір");
            System.out.println("1. Додати фільм");
            System.out.println("2. Видалити фільм");
            System.out.println("3. Додати сеанс");
            System.out.println("4. Видалити сеанс");
            System.out.println("Уведіть будь-яку іншу цифру, щоб вийти з програми");
            menuSelector = scanner.nextInt();
            scanner.nextLine();
            switch (menuSelector) {
                case 1:
                    System.out.println("Уведіть назву");
                    title = scanner.nextLine();
                    System.out.println("Уведіть кількість годин");
                    hour = scanner.nextInt();
                    System.out.println("Уведіть кількість хвилин");
                    min = scanner.nextInt();
                    if (cinema.addMovie(new Movie(title, new Time(min, hour)))) {
                        System.out.println("Фільм додано");
                    } else {
                        System.out.println("Фільм не додано");
                    }
                    break;
                case 2:
                    System.out.println("Уведіть назву фільму");
                    title = scanner.nextLine();
                    cinema.removeMovie(new Movie(title, new Time(1, 1)));
                    System.out.println("Фільм видалено");
                    break;
                case 3:
                    System.out.println("Уведіть кількість сеансів, які ви хочете додати");
                    int numberOfSeances = scanner.nextInt();
                    Seance[] seances = new Seance[numberOfSeances];
                    for (int i = 0; i < numberOfSeances; i++) {
                        System.out.println("Уведіть назву");
                        title = scanner.nextLine();
                        System.out.println("Уведіть годину початку");
                        hour = scanner.nextInt();
                        System.out.println("Уведіть хвилину початку");
                        min = scanner.nextInt();
                        Time startTime = new Time(min, hour);
                        System.out.println("Уведіть годину кінця");
                        hour = scanner.nextInt();
                        System.out.println("Уведіть хвилину кінця");
                        min = scanner.nextInt();
                        seances[i] = new Seance(title, startTime, new Time(min, hour));
                    }
                    System.out.println("Тепер уведіть день (англійською, за умовчуванням стоїть SUNDAY)");
                    day = scanner.nextLine();
                    cinema.addSeance(seances, day);
                    System.out.println("Сеанси додано");
                    break;
                case 4:
                    System.out.println("Уведіть назву фільму даного сеансу");
                    title = scanner.nextLine();
                    System.out.println("Уведіть день");
                    day = scanner.nextLine();
                    System.out.println("Уведіть годину початку");
                    startHour = scanner.nextInt();
                    System.out.println("Уведіть хвилину початку");
                    startMin = scanner.nextInt();
                    System.out.println("Уведіть годину кінця");
                    endHour = scanner.nextInt();
                    System.out.println("Уведіть хвилину кінця");
                    endMin = scanner.nextInt();
                    cinema.removeSeance(new Seance(title, new Time(startMin, startHour), new Time(endMin, endHour)), day);
                    break;
                default:
                    System.out.println("До зустрічі!");
                    System.exit(0);
                    break;
            }
        }
    }
}
