package com.hiral.alternatives;

import javax.enterprise.inject.Alternative;

@Alternative
public class KidGameAnnouncer implements GameAnnouncer{
    @Override
    public String announce() {
        return "Game Product is the least violent game of all times, children!";
    }
}
