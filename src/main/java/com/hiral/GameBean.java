package com.hiral;

import com.hiral.alternatives.GameAnnouncer;
import com.hiral.interceptor.Logged;
import com.hiral.model.Game;
import com.hiral.model.GameProduct;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


//@RequestScoped
//@Named("gameBean")
@Model
public class GameBean {

    private String name;
    private double price;
    private int numberOfQuantity;
    private String producercompany;
    private String announcementMessage;

    @Inject
    private GameAnnouncer announcer;
    //Event of type game
    @Inject
    @AddProduct
    private Event<Game> gameAddEvent;

    @Inject
    @DeleteProduct
    private Event<Game> gameDeleteEvent;
    //@Inject
   // @EditProduct
   // private Event<Game> gameEditEvent;

    @Inject
    private GameManager gameService;

    @PostConstruct
    public void constructMessage() {
        announcementMessage = announcer.announce();
    }

    public String getAnnouncementMessage() {
        return announcementMessage;
    }

    public List<Game> getGames() {
        return gameService.getGames();
    }

    @Logged
    public void addProduct()
    {

        Game game = new GameProduct(name,price,numberOfQuantity,producercompany);
        //fire event of type game
        gameAddEvent.fire(game);

    }

    @Logged
    public void deleteProduct()
    {
        Game game = new GameProduct(name,price,numberOfQuantity,producercompany);
        gameDeleteEvent.fire(game);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfQuantity() {
        return numberOfQuantity;
    }

    public void setNumberOfQuantity(int numberOfQuantity) {
        this.numberOfQuantity = numberOfQuantity;
    }

    public String getProducercompany() {
        return producercompany;
    }

    public void setProducercompany(String producercompany) {
        this.producercompany = producercompany;
    }
}
