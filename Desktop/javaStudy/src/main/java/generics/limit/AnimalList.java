package generics.limit;

import java.util.ArrayList;

public class AnimalList <T extends Pet> { //Pet의 자식 타입만 가능하다.

    ArrayList<T> animal = new ArrayList<T>();

    void add(T a) { animal.add(a); }

    T get(int index) { return animal.get(index); }

}
