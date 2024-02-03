import java.io.Serializable;
import java.io.IOException;

// Класс, представляющий игрушку и реализующий интерфейс Serializable
public class Toy implements Serializable {
    private int id; // Уникальный идентификатор игрушки
    private String name; // Название игрушки
    private int quantity; // Количество игрушек в лотерее
    private double weight; // Частота выпадения игрушки в лотерее

    // Конструктор класса, инициализирующий поля игрушки
    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    // Методы доступа к полям

    // Получение уникального идентификатора игрушки
    public int getId() {
        return id;
    }

    // Получение названия игрушки
    public String getName() {
        return name;
    }

    // Получение количества игрушек в лотерее
    public int getQuantity() {
        return quantity;
    }

    // Получение частоты выпадения игрушки в лотерее
    public double getWeight() {
        return weight;
    }

    // Установка нового значения для количества игрушек
    public void setQuantity(int newQuantity) {
        quantity = newQuantity;
    }

    // Установка нового значения для частоты выпадения игрушки
    public void setWeight(double newWeight) {
        weight = newWeight;
    }

    // Методы для поддержки сериализации

    // Кастомная реализация записи объекта в ObjectOutputStream
    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    // Кастомная реализация чтения объекта из ObjectInputStream
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }
}