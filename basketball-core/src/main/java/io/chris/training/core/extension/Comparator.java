package io.chris.training.core.extension;

import io.chris.training.core.domain.User;

public class Comparator implements java.util.Comparator<User> {

    public int compare(User o1, User o2) {
        if (o1.getLastName().equals(o2.getLastName())) {
            if (o1.getUsername() == o2.getUsername()) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            } else {
                return o1.getUsername().compareTo(o2.getUsername());
            }
        } else {
            return o1.getLastName().compareTo(o2.getLastName());
        }

    }
}
