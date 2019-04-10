package org.black.lotus.oo.design.call.center;

public class Respondent implements CallHandler {
    private CallHandlerStatus status;

    @Override
    public boolean onCall(CallEvent callEvent) {
        if (status == CallHandlerStatus.AVAILABLE) {
            status = CallHandlerStatus.OCCUPIED;
            return true;
        }

        return false;
    }

    @Override
    public boolean isAvailable() {
        return status == CallHandlerStatus.AVAILABLE;
    }
}
