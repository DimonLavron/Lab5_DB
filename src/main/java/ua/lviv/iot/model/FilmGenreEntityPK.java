package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class FilmGenreEntityPK implements Serializable {
    private int filmId;
    private int genreId;

    public FilmGenreEntityPK() {
    }

    public FilmGenreEntityPK(int filmId, int genreId) {
        this.filmId = filmId;
        this.genreId = genreId;
    }

    @Column(name = "film_id")
    @Id
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    @Column(name = "genre_id")
    @Id
    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmGenreEntityPK that = (FilmGenreEntityPK) o;

        if (filmId != that.filmId) return false;
        if (genreId != that.genreId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filmId;
        result = 31 * result + genreId;
        return result;
    }
}
