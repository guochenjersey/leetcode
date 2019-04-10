package org.black.lotus.oo.design.call.center;

import org.black.lotus.kata.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ManagerPool {
    private List<? super CallHandler> managerList;

    public ManagerPool() {
        managerList = new ArrayList<>();
        managerList.add(new Manager());
    }

    public Optional<Manager> findNextAvaliableManager() {
        return null;
    }
}
