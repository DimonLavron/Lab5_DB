package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "film_director", schema = "film_db")
@IdClass(FilmDirectorEntityPK.class)
public class FilmDirectorEntity {
    private int filmId;
    private int directorId;

    public FilmDirectorEntity() {
    }

    public FilmDirectorEntity(int filmId, int directorId) {
        this.filmId = filmId;
        this.directorId = directorId;
    }

    @Id
    @Column(name = "film_id")
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    @Id
    @Column(name = "director_id")
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

        FilmDirectorEntity that = (FilmDirectorEntity) o;

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
