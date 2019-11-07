package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "box_office", schema = "film_db")
@IdClass(BoxOfficeEntityPK.class)
public class BoxOfficeEntity {
    private int filmId;
    private int countryId;
    private long boxOffice;

    public BoxOfficeEntity() {
    }

    public BoxOfficeEntity(int filmId, int countryId, long boxOffice) {
        this.filmId = filmId;
        this.countryId = countryId;
        this.boxOffice = boxOffice;
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
    @Column(name = "country_id")
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "box_office")
    public long getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(long boxOffice) {
        this.boxOffice = boxOffice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoxOfficeEntity that = (BoxOfficeEntity) o;

        if (filmId != that.filmId) return false;
        if (countryId != that.countryId) return false;
        if (boxOffice != that.boxOffice) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filmId;
        result = 31 * result + countryId;
        result = 31 * result + (int) (boxOffice ^ (boxOffice >>> 32));
        return result;
    }
}
