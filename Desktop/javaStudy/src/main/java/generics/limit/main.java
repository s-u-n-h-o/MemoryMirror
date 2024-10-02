package generics.limit;

public class main {
    public static void main(String[] args) {
        AnimalList<Pet> a = new AnimalList<>();
        a.add(new Pet());
        a.add(new Cat());
        a.add(new Dog());
        //a.add(new Brid()); // 오류 발생

        System.out.println(a.get(0));
        System.out.println(a.get(1));
        System.out.println(a.get(2));

    }
}
