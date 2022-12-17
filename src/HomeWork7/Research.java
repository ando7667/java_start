package HomeWork7;

import java.util.ArrayList;
import java.util.Objects;

public class Research {
    ArrayList<GeoTree.Node> tree;

    public Research(GeoTree famTree) {
        tree = famTree.getTree();
    }

    public ArrayList<Person> findAll(Person whose, GeoTree.Bonds bo) {
        ArrayList<Person> result = new ArrayList<>();
        for (GeoTree.Node t : tree) {
            if (Objects.equals(t.toWho.getFullName(), whose.getFullName()) && t.bo == bo) {
                result.add(t.who);
//                System.out.println(t.who.toString());
            }
        }
        return result;
    }
}
