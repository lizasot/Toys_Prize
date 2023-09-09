public class Main {
    public static void main(String[] args) {
        Raffle raffle = new Raffle();
        try {
            System.out.println(raffle.SayStatus());
            raffle.AddNewToy(new Toy("Toy 1", 2, 90));
            System.out.println(raffle.SayStatus());
            raffle.AddNewToy(new Toy("Toy 2", 8, 10));
            System.out.println(raffle.SayStatus());
            raffle.AddNewToy(new Toy("Toy 3", 1, 10));
            System.out.println(raffle.SayStatus());
            System.out.println("Разыграна игрушка: " + raffle.DrawToy().GetName());
            System.out.println(raffle.SayStatus());
            System.out.println("Разыграна игрушка: " + raffle.DrawToy().GetName());
            System.out.println(raffle.SayStatus());
            System.out.println("Разыграна игрушка: " + raffle.DrawToy().GetName());
            System.out.println(raffle.SayStatus());
            System.out.println("Разыграна игрушка: " + raffle.DrawToy().GetName());
            System.out.println(raffle.SayStatus());
            System.out.println("Разыграна игрушка: " + raffle.DrawToy().GetName());
            System.out.println(raffle.SayStatus());
            System.out.println("Разыграна игрушка: " + raffle.DrawToy().GetName());
            System.out.println(raffle.SayStatus());
            System.out.println("Выполняется выдача игрушек...");
            raffle.GiveOutPrizes("filename");
            System.out.println(raffle.SayStatus());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}