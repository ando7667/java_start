package Java_DevKit.Seminar2_2.task4;

public class FullStackProgrammer extends Developer implements BackEndProgramming, FrontEndProgramming {

    @Override
    public void writeFrontEndCode() {
        System.out.println("Class name: " + this.toString() + " -> FullStackProgrammer create GUI");
    }

    @Override
    public void writeBackEndCode() {
        System.out.println("Class name: " + this.toString() + " -> FullStackProgrammer create API");
    }

    @Override
    void sleeping() {
        System.out.println("Class name: " + this.toString() + " -> FullStackProgrammer sleeping");
    }

    @Override
    void relax() {
        System.out.println("Class name: " + this.toString() + " -> FullStackProgrammer relax");
    }

    @Override
    public String toString() {
        return "FullStackProgrammer";
    }
}
