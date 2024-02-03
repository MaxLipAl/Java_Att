import java.io.*;
import java.util.*;

// Класс ToyLottery управляет лотереей игрушек
public class ToyLottery {
    private Queue<Toy> lotteryQueue; // Очередь для хранения игрушек в лотерее
    private List<Toy> wonToys; // Список для хранения выигранных игрушек

    // Конструктор класса, инициализирует очередь и загружает выигранные игрушки из файла
    public ToyLottery() {
        this.lotteryQueue = new PriorityQueue<>(new ToyComparator());
        this.wonToys = readWonToysFromFile();
    }

    // Метод для добавления новой игрушки в лотерею
    public void addToy(Toy newToy) {
        boolean toyExists = false;
        // Проверка, существует ли уже игрушка с таким названием в лотерее
        for (Toy existingToy : lotteryQueue) {
            if (existingToy.getName().equals(newToy.getName())) {
                existingToy.setQuantity(existingToy.getQuantity() + newToy.getQuantity());
                toyExists = true;
                break;
            }
        }

        // Если игрушка не существует, добавляем её в очередь
        if (!toyExists) {
            lotteryQueue.add(newToy);
        }
    }

    // Метод для проведения лотереи и возврата выигранной игрушки
    public Toy runLottery() {
        Toy wonToy = lotteryQueue.poll();
        if (wonToy != null) {
            wonToys.add(wonToy);
            saveWonToysToFile();
        }
        return wonToy;
    }

    // Метод для изменения частоты выпадения игрушки по её ID
    public void changeToyWeight(int toyId, double newWeight) {
        for (Toy toy : lotteryQueue) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    // Метод для получения списка игрушек в лотерее
    public List<Toy> getToys() {
        return new ArrayList<>(lotteryQueue);
    }

    // Метод для отображения выигранных игрушек
    public void showWonToys() {
        System.out.println("Выигранные игрушки:");
        for (Toy toy : wonToys) {
            System.out.println("ID: " + toy.getId() + ", Название: " + toy.getName() +
                    ", Частота выпадения: " + toy.getWeight());
        }
    }

    // Метод для отображения игрушек в лотерее, сортированных по ID
    public void showLotteryToys() {
        List<Toy> sortedLotteryToys = new ArrayList<>(lotteryQueue);
        sortedLotteryToys.sort(Comparator.comparingInt(Toy::getId));

        System.out.println("Игрушки в лотерее:");
        for (Toy toy : sortedLotteryToys) {
            System.out.println("ID: " + toy.getId() + ", Название: " + toy.getName() +
                    ", Частота выпадения: " + toy.getWeight());
        }
    }

    // Метод для сохранения выигранных игрушек в файл
    public void saveWonToysToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("winning_toys.txt"))) {
            for (Toy toy : wonToys) {
                String line = String.format("ID: %d, Название: %s, Частота выпадения: %.2f%n",
                        toy.getId(), toy.getName(), toy.getWeight());
                writer.write(line);
            }
            System.out.println("Выигранные игрушки успешно сохранены в файл winning_toys.txt");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении выигранных игрушек в файл.");
            e.printStackTrace();
        }
    }

    // Метод для чтения выигранных игрушек из файла
    private List<Toy> readWonToysFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("wontoys.txt"))) {
            return (List<Toy>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}