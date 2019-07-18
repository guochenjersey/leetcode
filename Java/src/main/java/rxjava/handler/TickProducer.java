package rxjava.handler;

import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.schedulers.Schedulers;
import rxjava.utils.TickUitls;

import java.util.Arrays;

@Slf4j
public class TickProducer {

    public void produce() {
        TickConsumer tickConsumer = new TickConsumer();
        Observable.from(Arrays.asList(TickUitls.createTick()))
                .subscribeOn(Schedulers.computation())
                .subscribe(tickConsumer);
    }

    public static void main(String... args) {
        TickProducer tickProducer = new TickProducer();
        tickProducer.produce();
    }
}
