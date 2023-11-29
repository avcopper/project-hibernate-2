package com.movie.controller;

import java.util.Set;
import com.movie.dao.*;
import com.movie.entity.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        saveNewCustomer();
        //updateCustomer();
        returnMovie();
        makeNewRental();
        makeNewInventory();
    }

    /**
     * Создает нового покупателя
     */
    private static void saveNewCustomer()
    {
        Customer customer = new Customer();
        customer.setActive(true);
        customer.setFirstName("Vasya");
        customer.setLastName("Pupkin");
        customer.setEmail("pupkin@gmail.com");
        customer.setCreateDate(LocalDateTime.now());
        customer.setStore(new StoreDAO().getById(1));
        //customer.setAddress(new AddressDAO().getById(5));
        customer.setAddress(getNewAddress());
        new CustomerDAO().create(customer);
    }

    /**
     * Создает новый адрес
     * @return
     */
    private static Address getNewAddress()
    {
        Address address = new Address();
        address.setAddress("Podzabornaya, 2/1 - 42");
        address.setAddress2("First hole in the ground");
        address.setDistrict("Bomjatinskiy");
        address.setPostalCode("111014");
        address.setPhone("+15551201245");
        address.setCity(new CityDAO().getById(457));
        address.setLastUpdate(LocalDateTime.now());
        return address;
    }

    /**
     * Обновляет email покупателя
     */
    private void updateCustomer() {
        Customer customer2 = new CustomerDAO().getById(599);
        customer2.setEmail("pupkin123@gmail.com");
        new CustomerDAO().update(customer2);
    }

    /**
     * Делает возврат арендованного инвентаря
     */
    private static void returnMovie()
    {
        RentalDAO rentalDAO = new RentalDAO();
        Rental rental = rentalDAO.getById(11593L);
        rental.setReturnDate(LocalDateTime.now());
        rentalDAO.update(rental);
    }

    /**
     * Выдает в аренду случайный инвентарь
     */
    private static void makeNewRental() {
        Inventory inventory = new InventoryDAO().getFree();

        if (inventory != null) {
            Rental rental = new Rental();
            rental.setRentalDate(LocalDateTime.now());
            rental.setLastUpdate(LocalDateTime.now());
            rental.setInventory(inventory);
            rental.setCustomer(new CustomerDAO().getById(599));
            rental.setStaff(new StoreDAO().getById(1).getManagerStaff());
            new RentalDAO().create(rental);
        }
    }

    /**
     * Помещает новый фильм в инвентарь для арнды
     */
    private static void makeNewInventory() {
        Inventory inventory = new Inventory();
        inventory.setStore(new StoreDAO().getById(1));
        inventory.setFilm(getNewFilm());
        inventory.setLastUpdate(LocalDateTime.now());
        new InventoryDAO().create(inventory);
    }

    /**
     * Создает новый фильм
     * @return
     */
    private static Film getNewFilm() {
        Film film = new Film();
        film.setTitle("Naked ass");
        film.setDescription("Film about naked bald ass");
        film.setReleaseYear(2023);
        film.setLength(99);
        film.setRentalRate(4.99f);
        film.setRentalDuration(3);
        film.setReplacementCost(24.99f);
        film.setLanguage(new LanguageDAO().getById(1));
        film.setOriginalLanguage(new LanguageDAO().getById(2));
        film.setLastUpdate(LocalDateTime.now());
        film.setActors(getFilmActors());
        film.setCategories(getFilmCategories());
        return film;
    }

    /**
     * Возвращает список актеров фильма
     * @return
     */
    private static Set<Actor> getFilmActors() {
        Actor actor1 = new ActorDAO().getById(4);
        Actor actor2 = new ActorDAO().getById(5);
        return Set.of(actor1, actor2);
    }

    /**
     * Возвращает список категорий фильма
     * @return
     */
    private static Set<Category> getFilmCategories() {
        Category category1 = new CategoryDAO().getById(1);
        Category category2 = new CategoryDAO().getById(5);
        return Set.of(category1, category2);
    }
}
