package rxjava.handler;

import lombok.extern.slf4j.Slf4j;
import rx.Observer;
import rxjava.model.Tick;

@Slf4j
public class TickConsumer implements Observer<Tick> {

    @Override
    public void onNext(Tick tick) {
        log.info(String.format("consuming %s", tick));
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
