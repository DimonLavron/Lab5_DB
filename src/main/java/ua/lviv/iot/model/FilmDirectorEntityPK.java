package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class FilmDirectorEntityPK implements Serializable {
    private int filmId;
    private int directorId;

    public FilmDirectorEntityPK() {
    }

    public FilmDirectorEntityPK(int filmId, int directorId) {
        this.filmId = filmId;
        this.directorId = directorId;
    }

    @Column(name = "film_id")
    @Id
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    @Column(name = "director_id")
    @Id
    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmDirectorEntityPK that = (FilmDirectorEntityPK) o;

        if (filmId != that.filmId) return false;
        if (directorId != that.directorId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filmId;
        result = 31 * result + directorId;
        return result;
    }
}
