package JavaJunior.HW2;

public class Main {
    public static void main(String[] args) {
        TestProcessor.runTest(MyTest.class);
    }

    static class MyTest {
        @AfterEach
        void clear1(){
            System.out.println("Завершающий метод 1");
        }


        @AfterEach
        void clear2(){
            System.out.println("Завершающий метод 2");
        }


        @AfterEach
        void clear3(){
            System.out.println("Завершающий метод 3");
        }


        @BeforeEach
        void init1(){
            System.out.println("Подготовительный метод 1");
        }

        @BeforeEach
        void init2(){
            System.out.println("Подготовительный метод 2");
        }
        @Test(order = - 2)
        void test1() {
            System.out.println("Очередь -2: test1 запущен");
        }

        @Test(order = 1)
        void test2() {
            System.out.println("Очередь 1: test2 запущен");
        }

        @Test(order = 1)
        void test3() {
            System.out.println("Очередь 1: test3 запущен");
        }

        @Test
        @Skip
        void test4() {
            System.out.println("Очередь 0: test4 запущен");
        }

        @Test(order = 1)
        void test5() {
            System.out.println("Очередь 1: test5 запущен");
        }

        @Test()
        void test6() {
            System.out.println("Очередь 0: test6 запущен");
        }

    }
}