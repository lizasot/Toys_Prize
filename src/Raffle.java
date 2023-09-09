import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Raffle {
    private ArrayList<Toy> toys = new ArrayList<>();
    private int totalWeight = 0;
    private Queue<Toy> prizes = new LinkedList();
    public boolean AddNewToy(Toy toy) {
        if (!ToyInList(toy)) {
            toys.add(toy);
            totalWeight += toy.GetWeight();
            return true;
        } else {
            return false;
        }
    }
    public boolean ToyInList(Toy toy) {
        boolean result = false;
        int id = toy.GetId();
        for (Toy item : toys) {
            if (id == item.GetId()) {
                result = true;
                break;
            }
        }
        return result;
    }
    public Toy GetRandToy() throws Exception {
        if (!toys.isEmpty() && toys != null) {
            Random r = new Random();
            int prizeNumb = r.nextInt(totalWeight) + 1;
            int start = 0;
            int end = 0;
            ListIterator<Toy> liter = toys.listIterator();
            while (end < totalWeight && liter.hasNext()) {
                Toy result = liter.next();
                end += result.GetWeight();
                if (prizeNumb > start && prizeNumb <= end) {
                    return result;
                }
            };
        }
        throw new Exception("Игрушка не найдена.");
    }
    public Toy DrawToy() throws Exception {
        Toy prize = GetRandToy();
        prizes.add(prize);
        if (prize.RemoveToy() <= 0) {
            toys.remove(prize);
        }
        totalWeight -= prize.GetChance();
        return prize;
    }
    public boolean GiveOutPrizes(String filename) throws Exception {
        while (!prizes.isEmpty()) {
            Toy prize = prizes.remove();
            String data = "Получена игрушка: " + prize.GetName() + "\n";
            Path path = Paths.get(filename + ".txt");
            Files.write(path, data.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        }
        return false;
    }
    public String SayStatus() {
        String data = "В автомате содержится: ";
        ListIterator<Toy> liter = toys.listIterator();
        if (liter.hasNext()) {
            while (liter.hasNext()) {
                Toy result = liter.next();
                data += result.GetName() + " в кол-ве " + result.GetCount() + " (шанс " + result.GetChance() + ")";
                if (liter.hasNext()) {
                    data += ", ";
                } else {
                    data += "; ";
                }
            }
        } else {
            data += "0 игрушек; ";
        }
        data += "В очереди на выдачу находится: " + prizes.size() + " игрушек;";
        return data;
    }
}
