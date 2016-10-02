package pl.ania;

import java.util.ArrayList;
import java.util.List;

public class CatDAO {

    public List<Cat> cats = new ArrayList<>();

    public void addCatToList(Cat cat){
        cats.add(cat);
        System.out.println("Dodano kota do listy");
    }
}
