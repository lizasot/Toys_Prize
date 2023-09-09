
public class Toy {
    private static int globalId = 1;
    private int id;
    private String name;
    private int count;
    private int chance;

    public int GetCount() {
        return count;
    }

    public int GetWeight() {
        return count * chance;
    }
    public int GetChance() {
        return chance;
    }
    public String GetName() {
        return name;
    }
    public int RemoveToy() throws Exception {
        if (count > 0) {
            count--;
            return count;
        }
        throw new Exception("Нет игрушек для изъятия.");
    }
    public int GetId() {
        return id;
    }
    public Toy(String Name, int Count, int Chance) throws Exception {
        id = globalId;
        globalId++;
        name = Name;
        if (Count > 0) {
            count = Count;
        } else {
            throw new Exception("Количество игрушек не может быть меньше или равно нулю.");
        }
        if (Chance > 0 && Chance <= 100) {
            chance = Chance;
        } else {
            throw new Exception("Шанс выпадения должен быть выше нуля и меньше или равен ста.");
        }
    }
}
