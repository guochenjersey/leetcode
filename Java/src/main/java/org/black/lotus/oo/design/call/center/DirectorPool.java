package org.black.lotus.oo.design.call.center;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DirectorPool {

    private List<Director> directorList;

    public DirectorPool() {
        directorList = new ArrayList<>();
    }

    public Optional<Director> findNextAvalableDirector() {
        return directorList.stream()
                .filter(Director::isAvailable)
                .findAny();
    }
}
