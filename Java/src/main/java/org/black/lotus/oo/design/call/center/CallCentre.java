package org.black.lotus.oo.design.call.center;

import java.util.ArrayList;
import java.util.List;

/**
 * Imagine you have a call center with three levels of employees: respondent, manager, and director.
 * An incoming telephone call must be first allocated to a respondent who is free.
 * If the respondent can't handle the call, he or she must escalate the call to a manager.
 * If the manager is not free or not able to handle it, then the call should be escalated to a director.
 * Design the classes and data structures for this problem.
 * Implement a method dispatchCall() which assigns a call to the first available employee.
 */
public class CallCentre {

    private List<AbstractCallHandlerPool> callHandlersPool;

    public CallCentre() {
        callHandlersPool = new ArrayList<>();
        callHandlersPool.add(new RespondentPool());
        callHandlersPool.add(new ManagerPool());
        callHandlersPool.add(new DirectorPool());
    }

    public boolean dispatch(CallEvent event) {
        return callHandlersPool.stream()
                .anyMatch(p -> p.handleEvent(event));
    }
}
