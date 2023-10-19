package Java_DevKit.Seminar2_2.task4;

public class FrontEndDeveloper extends Developer {
    @Override
    void sleeping() {
        System.out.println("FrontEndDeveloper sleeping");
    }

    @Override
    void relax() {
        System.out.println("FrontEndDeveloper smoke");
    }

    public void writeFrontEndCode() {
        System.out.println("Class name: " + this.toString() + " -> FrontEndDeveloper create GUI");
    }

    @Override
    public String toString() {

        return "FrontEndDeveloper";
    }
}
