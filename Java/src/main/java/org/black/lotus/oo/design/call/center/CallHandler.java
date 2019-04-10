package org.black.lotus.oo.design.call.center;

public interface CallHandler {
    boolean onCall(CallEvent callEvent);
    boolean isAvailable();
}
