package org.black.lotus.oo.design.call.center;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCallHandlerPool<T extends CallHandler> {

    private List<T> callHandlers;

    AbstractCallHandlerPool() {
        callHandlers = new ArrayList<>();
    }

    public boolean add(T t) {
        return callHandlers.add(t);
    }

    public boolean remove(T t) {
        return callHandlers.remove(t);
    }

    public boolean handleEvent(CallEvent event) {
        return findNextAvailable().map(t -> t.onCall(event)).orElse(false);
    }

    private Optional<T> findNextAvailable() {
        return callHandlers.stream()
                .filter(CallHandler::isAvailable)
                .findAny();
    }
}
