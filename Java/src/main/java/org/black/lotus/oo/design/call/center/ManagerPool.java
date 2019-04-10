package org.black.lotus.oo.design.call.center;

class ManagerPool extends AbstractCallHandlerPool<Manager> {

    public ManagerPool() {
        for (int i = 0; i < 10; ++i)
            add(new Manager());
    }
}
