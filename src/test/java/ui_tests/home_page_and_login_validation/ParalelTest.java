package ui_tests.home_page_and_login_validation;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;



public class ParalelTest {

    @SneakyThrows
    @Test
    public void test1() {
        new Thread(() -> {
            try {
                Thread.sleep(30_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    @SneakyThrows
    @Test
    public void test2() {
        new Thread(() -> {
            try {
                Thread.sleep(50_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    @SneakyThrows
    @Test
    public void test3() {
        new Thread(() -> {
            try {
                Thread.sleep(20_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
