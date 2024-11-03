package hello.proxy.app.v1;

import org.springframework.aop.ThrowsAdvice;

public class OrderRepositoryImpl implements OrderRepositoryV1 {
    @Override
    public void save(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalStateException("예외 발생");
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
