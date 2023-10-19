package Java_DevKit.Seminar2_2.task4;

public class BackEndDeveloper extends Developer {
    @Override
    void sleeping() {
        System.out.println("BackEndDeveloper sleeping");
    }

    @Override
    void relax() {
        System.out.println("BackEndDeveloper relax");
    }

    void writeBackEndCode() {
        System.out.println("Class name: " + this.toString() + " -> BackEndDeveloper create API");
    }

    @Override
    public String toString() {

        return "BackEndDeveloper";
    }
}
