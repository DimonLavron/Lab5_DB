package ua.lviv.iot.service;

import ua.lviv.iot.model.*;

public interface BusinessLogic {
    void findAllCountries();
    void findCountryById(Integer id);
    void createCountry(CountryEntity newItem);
    void updateCountry(Integer id, CountryEntity newItem);
    void deleteCountry(Integer id);

    void findAllDirectors();
    void findDirectorById(Integer id);
    void createDirector(DirectorEntity newItem);
    void updateDirector(Integer id, DirectorEntity newItem);
    void deleteDirector(Integer id);

    void findAllFilms();
    void findFilmById(Integer id);
    void createFilm(FilmEntity newItem);
    void updateFilm(Integer id, FilmEntity newItem);
    void deleteFilm(Integer id);

    void findAllGenres();
    void findGenreById(Integer id);
    void createGenre(GenreEntity newItem);
    void updateGenre(Integer id, GenreEntity newItem);
    void deleteGenre(Integer id);

    void findAllStars();
    void findStarById(Integer id);
    void createStar(StarEntity newItem);
    void updateStar(Integer id, StarEntity newItem);
    void deleteStar(Integer id);

    void findAllRoles();
    void findRoleById(Integer id1, Integer id2);
    void createRole(RoleEntity newItem);
    void updateRole(Integer id1, Integer id2, RoleEntity newItem);
    void deleteRole(Integer id1, Integer id2);

    void findAllBoxOffices();
    void findBoxOfficeById(Integer id1, Integer id2);
    void createBoxOffice(BoxOfficeEntity newItem);
    void updateBoxOffice(Integer id1, Integer id2, BoxOfficeEntity newItem);
    void deleteBoxOffice(Integer id1, Integer id2);

    void findAllFilmDirectors();
    void findFilmDirectorById(Integer id1, Integer id2);
    void createFilmDirector(FilmDirectorEntity newItem);
    void updateFilmDirector(Integer id1, Integer id2, FilmDirectorEntity newItem);
    void deleteFilmDirector(Integer id1, Integer id2);

    void findAllFilmGenres();
    void findFilmGenreById(Integer id1, Integer id2);
    void createFilmGenre(FilmGenreEntity newItem);
    void updateFilmGenre(Integer id1, Integer id2, FilmGenreEntity newItem);
    void deleteFilmGenre(Integer id1, Integer id2);
}
