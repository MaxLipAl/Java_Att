import java.util.Comparator;

public class ToyComparator implements Comparator<Toy> {
    // Переопределение метода compare для сравнения двух игрушек по весу
    @Override
    public int compare(Toy toy1, Toy toy2) {
        return Double.compare(toy1.getWeight(), toy2.getWeight());
    }
}
