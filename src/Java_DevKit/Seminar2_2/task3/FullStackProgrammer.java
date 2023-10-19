package Java_DevKit.Seminar2_2.task3;

public class FullStackProgrammer implements BackEndProgramming, FrontEndProgramming {

    @Override
    public void writeFrontEndCode() {

        System.out.println("Код для фронтенд-программиста");
    }

    @Override
    public void writeBackEndCode() {

        System.out.println("Код для бэкенд-программиста");
    }

}
