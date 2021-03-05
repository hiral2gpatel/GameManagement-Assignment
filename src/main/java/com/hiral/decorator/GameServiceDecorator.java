package com.hiral.decorator;

//import com.hiral.events.Game;
import com.hiral.model.Game;
import com.hiral.GameManager;
import com.hiral.GameService;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@Decorator

public class GameServiceDecorator implements GameManager {

    @Inject
    @Delegate
    private GameService gameService;

    @Override
    public void add(Game game) {
    gameService.add(game);
    }



    @Override
    public List<Game> getGames() {
        return gameService.getGames();
    }

    @Override
    public void delete(Game game) {
        gameService.delete(game);
    }
}
