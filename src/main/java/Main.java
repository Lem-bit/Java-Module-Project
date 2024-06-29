import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        //
        System.out.println("Перед гонкой зарегистрируйте автомобили");

        for (int i = 0; i < 3; i++) {
            String carName = "";
            int carSpeed = -1;

            while (carName.isEmpty()) {
                System.out.print("Название автомобиля #" + (i + 1) + ": ");
                carName = scanner.nextLine();
            }

            while (true) {
                System.out.print("Скорость автомобиля #" + (i + 1) + ": ");
                carSpeed = scanner.hasNextInt() ? scanner.nextInt() : -1;

                if (carSpeed < 0 || carSpeed > 250) {
                    System.out.println("Скорость автомобиля должна быть в значении от 0 до 250");
                    scanner.next();
                } else {
                    break;
                }
            }

            race.Registration(new Car(carName, carSpeed));
            scanner.nextLine();
        }

        System.out.println();
        System.out.println("Регистрация автомобилей завершена, старт гонки...");

        //Запускаем гонку на 24 часа
        race.Start(24);

        Car winner = race.getWinner();

        //Выводим победителя
        System.out.println();
        System.out.println("Самая быстрая машина: " + winner.name + ", со скоростью " + winner.speed);

    }
}
