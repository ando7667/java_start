package HomeWork7;

import java.util.ArrayList;

public class GeoTree {
    private final ArrayList<Node> tree = new ArrayList<>();

    enum Bonds {
        father, mother, son, daughter, brother, sister, wife, husband
    }

    class Node {

        Person who;
        Bonds bo;
        Person toWho;
        /**
         * создание точки дерева
         *
         * @param who     Персона
         * @param type    Родственная связь
         * @param toWho   К кому родственная связь
         */

        public Node(Person who, Bonds type, Person toWho) {
            this.who = who;
            this.bo = type;
            this.toWho = toWho;
        }

        public Node(Bonds type, Person toWho) {
            this.who = null;
            this.bo = type;
            this.toWho = toWho;
        }

        public Node(Person who, Bonds type) {
            this.who = who;
            this.bo = type;
            this.toWho = null;
        }

        @Override
        public String toString() {
            return String.format("<%s %s %s>", who, bo, toWho);
        }
    }

    public ArrayList<Node> getTree() {
        return tree;
    }

    public void addNode(Person who, Bonds type, Person toWho) {
        tree.add(new Node(who, type, toWho));
    }

}