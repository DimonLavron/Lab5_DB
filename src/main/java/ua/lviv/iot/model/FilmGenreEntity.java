package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "film_genre", schema = "film_db")
@IdClass(FilmGenreEntityPK.class)
public class FilmGenreEntity {
    private int filmId;
    private int genreId;

    public FilmGenreEntity() {
    }

    public FilmGenreEntity(int filmId, int genreId) {
        this.filmId = filmId;
        this.genreId = genreId;
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
    @Column(name = "genre_id")
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

        FilmGenreEntity that = (FilmGenreEntity) o;

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
