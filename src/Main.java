import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создание объекта для управления лотереей игрушек
        ToyLottery toyLottery = new ToyLottery();
        // Создание объекта Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Вывод меню выбора пользователю
            System.out.println("1. Заполнить лотерею игрушками");
            System.out.println("2. Начать лотерею");
            System.out.println("3. Изменить частоту выпадения игрушки");
            System.out.println("4. Просмотреть игрушки в лотерее");
            System.out.println("5. Добавить новую игрушку в лотерею");
            System.out.println("6. Просмотреть выигранные игрушки");
            System.out.println("7. Выход");

            // Получение выбора пользователя
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Добавление предопределенных игрушек в лотерею
                    toyLottery.addToy(new Toy(1, "Кукла", 10, 7.0));
                    toyLottery.addToy(new Toy(2, "Машинка", 8, 15.0));
                    toyLottery.addToy(new Toy(3, "Мяч", 12, 3.0));
                    System.out.println("Игрушки успешно добавлены в лотерею.");
                    break;
                case 2:
                    // Запуск лотереи и вывод выигранной игрушки
                    Toy wonToy = toyLottery.runLottery();
                    if (wonToy != null) {
                        System.out.println("Выиграна игрушка: " + wonToy.getName());
                    } else {
                        System.out.println("Лотерея закончена. Игрушек больше нет.");
                    }
                    break;
                case 3:
                    // Изменение частоты выпадения конкретной игрушки
                    System.out.print("Введите id игрушки: ");
                    int toyId = scanner.nextInt();
                    System.out.print("Введите новую частоту выпадения: ");
                    double newWeight = scanner.nextDouble();
                    toyLottery.changeToyWeight(toyId, newWeight);
                    System.out.println("Частота игрушки с id " + toyId + " изменена на " + newWeight);
                    break;
                case 4:
                    // Просмотр игрушек в лотерее
                    toyLottery.showLotteryToys();
                    break;
                case 5:
                    // Добавление новой игрушки в лотерею
                    System.out.print("Введите id новой игрушки: ");
                    int newToyId = scanner.nextInt();
                    System.out.print("Введите название новой игрушки: ");
                    String newToyName = scanner.next();
                    System.out.println("Введите количество игрушек: ");
                    int newToyQuantity = scanner.nextInt();
                    System.out.print("Введите частоту выпадения новой игрушки: ");
                    double newToyWeight = scanner.nextDouble();
                    toyLottery.addToy(new Toy(newToyId, newToyName, newToyQuantity, newToyWeight));
                    System.out.println("Игрушка успешно добавлена в лотерею.");
                    break;
                case 6:
                    // Просмотр выигранных игрушек
                    toyLottery.showWonToys();
                    break;
                case 7:
                    // Завершение программы
                    System.out.println("Программа завершена.");
                    System.exit(0);
                    break;
                default:
                    // В случае некорректного выбора
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }

            // Ожидание нажатия Enter перед продолжением
            System.out.println("Нажмите Enter для продолжения...");
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}