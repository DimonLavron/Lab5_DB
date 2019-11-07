package ua.lviv.iot.service;

import ua.lviv.iot.DAO.*;
import ua.lviv.iot.model.*;

public class BusinessLogicImpl implements BusinessLogic {
    private static GeneralJunctionDAO<BoxOfficeEntity> boxOffice;
    private static GeneralDAO<CountryEntity> country;
    private static GeneralDAO<DirectorEntity> director;
    private static GeneralDAO<FilmEntity> film;
    private static GeneralJunctionDAO<FilmDirectorEntity> filmDirector;
    private static GeneralJunctionDAO<FilmGenreEntity> filmGenre;
    private static GeneralDAO<GenreEntity> genre;
    private static GeneralJunctionDAO<RoleEntity> role;
    private static GeneralDAO<StarEntity> star;

    public BusinessLogicImpl() {
        boxOffice = new BoxOfficeDAO();
        country = new CountryDAO();
        director = new DirectorDAO();
        film = new FilmDAO();
        filmDirector = new FilmDirectorDAO();
        filmGenre = new FilmGenreDAO();
        genre = new GenreDAO();
        role = new RoleDAO();
        star = new StarDAO();
    }

    @Override
    public void findAllCountries() {
        country.findAll();
    }

    @Override
    public void findCountryById(Integer id) {
        country.findById(id);
    }

    @Override
    public void createCountry(CountryEntity newItem) {
        country.create(newItem);
    }

    @Override
    public void updateCountry(Integer id, CountryEntity newItem) {
        country.update(id, newItem);
    }

    @Override
    public void deleteCountry(Integer id) {
        country.delete(id);
    }

    @Override
    public void findAllDirectors() {
        director.findAll();
    }

    @Override
    public void findDirectorById(Integer id) {
        director.findById(id);
    }

    @Override
    public void createDirector(DirectorEntity newItem) {
        director.create(newItem);
    }

    @Override
    public void updateDirector(Integer id, DirectorEntity newItem) {
        director.update(id, newItem);
    }

    @Override
    public void deleteDirector(Integer id) {
        director.delete(id);
    }

    @Override
    public void findAllFilms() {
        film.findAll();
    }

    @Override
    public void findFilmById(Integer id) {
        film.findById(id);
    }

    @Override
    public void createFilm(FilmEntity newItem) {
        film.create(newItem);
    }

    @Override
    public void updateFilm(Integer id, FilmEntity newItem) {
        film.update(id, newItem);
    }

    @Override
    public void deleteFilm(Integer id) {
        film.delete(id);
    }

    @Override
    public void findAllGenres() {
        genre.findAll();
    }

    @Override
    public void findGenreById(Integer id) {
        genre.findById(id);
    }

    @Override
    public void createGenre(GenreEntity newItem) {
        genre.create(newItem);
    }

    @Override
    public void updateGenre(Integer id, GenreEntity newItem) {
        genre.update(id, newItem);
    }

    @Override
    public void deleteGenre(Integer id) {
        genre.delete(id);
    }

    @Override
    public void findAllStars() {
        star.findAll();
    }

    @Override
    public void findStarById(Integer id) {
        star.findById(id);
    }

    @Override
    public void createStar(StarEntity newItem) {
        star.create(newItem);
    }

    @Override
    public void updateStar(Integer id, StarEntity newItem) {
        star.update(id, newItem);
    }

    @Override
    public void deleteStar(Integer id) {
        star.delete(id);
    }

    @Override
    public void findAllRoles() {
        role.findAll();
    }

    @Override
    public void findRoleById(Integer id1, Integer id2) {
        role.findById(id1, id2);
    }

    @Override
    public void createRole(RoleEntity newItem) {
        role.create(newItem);
    }

    @Override
    public void updateRole(Integer id1, Integer id2, RoleEntity newItem) {
        role.update(id1, id2, newItem);
    }

    @Override
    public void deleteRole(Integer id1, Integer id2) {
        role.delete(id1, id2);
    }

    @Override
    public void findAllBoxOffices() {
        boxOffice.findAll();
    }

    @Override
    public void findBoxOfficeById(Integer id1, Integer id2) {
        boxOffice.findById(id1, id2);
    }

    @Override
    public void createBoxOffice(BoxOfficeEntity newItem) {
        boxOffice.create(newItem);
    }

    @Override
    public void updateBoxOffice(Integer id1, Integer id2, BoxOfficeEntity newItem) {
        boxOffice.update(id1, id2, newItem);
    }

    @Override
    public void deleteBoxOffice(Integer id1, Integer id2) {
        boxOffice.delete(id1, id2);
    }

    @Override
    public void findAllFilmDirectors() {
        filmDirector.findAll();
    }

    @Override
    public void findFilmDirectorById(Integer id1, Integer id2) {
        filmDirector.findById(id1, id2);
    }

    @Override
    public void createFilmDirector(FilmDirectorEntity newItem) {
        filmDirector.create(newItem);
    }

    @Override
    public void updateFilmDirector(Integer id1, Integer id2, FilmDirectorEntity newItem) {
        filmDirector.update(id1, id2, newItem);
    }

    @Override
    public void deleteFilmDirector(Integer id1, Integer id2) {
        filmDirector.delete(id1, id2);
    }

    @Override
    public void findAllFilmGenres() {
        filmGenre.findAll();
    }

    @Override
    public void findFilmGenreById(Integer id1, Integer id2) {
        filmGenre.findById(id1, id2);
    }

    @Override
    public void createFilmGenre(FilmGenreEntity newItem) {
        filmGenre.create(newItem);
    }

    @Override
    public void updateFilmGenre(Integer id1, Integer id2, FilmGenreEntity newItem) {
        filmGenre.update(id1, id2, newItem);
    }

    @Override
    public void deleteFilmGenre(Integer id1, Integer id2) {
        filmGenre.delete(id1, id2);
    }
}
