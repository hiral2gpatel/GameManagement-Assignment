package com.hiral;
import com.hiral.model.Game;

import java.util.List;
public interface GameManager {

    void add(Game game);

    List<Game>getGames();

    void delete (Game game);
}
