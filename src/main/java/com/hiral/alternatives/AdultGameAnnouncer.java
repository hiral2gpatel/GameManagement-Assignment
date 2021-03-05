package com.hiral.alternatives;

import javax.enterprise.inject.Alternative;

@Alternative
public class AdultGameAnnouncer implements GameAnnouncer {
    @Override
    public String announce() {
        return "Get ready to save the world";
    }
}
