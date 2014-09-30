package jp.canetrash.sample.logic;

import javax.transaction.UserTransaction;

import org.seasar.framework.container.annotation.tiger.Binding;

public class Sample2Logic {

    @Binding(value = "UserTransaction")
    private UserTransaction userTransaction;

    public void transactionTest() {
        for (int i = 0; i < 10; i++) {
            try {
                if (i % 2 == 0) {
                    throw new RuntimeException();
                }
                test();
                userTransaction.commit();
                userTransaction.begin();
                userTransaction.begin();
            } catch (Exception e) {
                System.out.println("Exception");
                try {
                    userTransaction.rollback();
                    userTransaction.begin();
                } catch (Exception e1) {
                }
            }
        }
    }

    public void test() {
        System.out.println("test called");
    }
}
