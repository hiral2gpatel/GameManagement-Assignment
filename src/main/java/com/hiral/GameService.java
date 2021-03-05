package com.hiral;
import com.hiral.AddProduct;
import com.hiral.DeleteProduct;
import com.hiral.GameManager;
import com.hiral.model.Game;
import com.hiral.model.GameProduct;
//import org.primefaces.model.SortMeta;


import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GameService implements GameManager {
    private List<Game> games;
   // private List<SortMeta> sortBy;


    @PostConstruct
    public void addProduct()
    {
        games = new ArrayList<>();
        games.add(new GameProduct("Way of the Warrior",20,10," Naughty Dog"));
    }



    @Override
    public void add(@Observes  @AddProduct Game game) {
        Game availableGame = games.stream().filter
                (gamex -> gamex.getName().equals(game.getName()))

                .findFirst().orElse(null);

        if (games.contains(availableGame)) {
            int newqiantity =0;
          // newqiantity = availableGame.getNumberOfQuantity() + availableGame.getNumberOfQuantity();
            newqiantity = availableGame.getNumberOfQuantity() + 1;

            int newvalue = newqiantity;
            game.setNumberOfQuantity(newvalue);

            game.setProducercompany(availableGame.getProducercompany());

            game.setPrice(availableGame.getPrice());

            games.remove(availableGame);

            games.add(game);

        } else{
            game.setNumberOfQuantity(1);
            games.add(game);

        }
    }

    @Override
    public List<Game> getGames() {
        return games;
    }

    @Override
    public void delete(@Observes @DeleteProduct Game game) {
        Game deletedGame = games.stream().filter(gamex ->

                gamex.getName().equals(game.getName()))

                .findFirst().orElse(null);

                games.remove(deletedGame);

    }
/*@PostConstruct
    public void init()
{
    sortBy = new ArrayList<>();
    sortBy.add(SortMeta.builder()
            .field("name")
            .order(org.primefaces.model.SortOrder.of(SortOrder.ASCENDING))
            .build());

    sortBy.add(SortMeta.builder()
            .field("price")
            .order(org.primefaces.model.SortOrder.of(SortOrder.ASCENDING))
            .priority(1)
            .build());
    sortBy.add(SortMeta.builder()
            .field("numberOfQuantity")
            .order(org.primefaces.model.SortOrder.of(SortOrder.ASCENDING))
            .priority(2)
            .build());
    sortBy.add(SortMeta.builder()
            .field("producercompany")
            .order(org.primefaces.model.SortOrder.of(SortOrder.ASCENDING))
            .priority(3)
            .build());
}*/
    //    FacesContext fc = FacesContext.getCurrentInstance();
       // fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "rowEdit event", ""));
    //}
}
