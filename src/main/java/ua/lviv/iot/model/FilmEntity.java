package ua.lviv.iot.model;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "film", schema = "film_db")
public class FilmEntity {
    private int id;
    private String title;
    private int runningTime;
    private Date releaseDate;
    List<DirectorEntity> directors = new LinkedList<>();
    List<GenreEntity> genres = new LinkedList<>();

    public FilmEntity() {
    }

    public FilmEntity(String title, int runningTime, Date releaseDate) {
        this.title = title;
        this.runningTime = runningTime;
        this.releaseDate = releaseDate;

        Session session = new Configuration().configure().buildSessionFactory().openSession();

        Query query1 = session.createQuery("SELECT directorId FROM FilmDirectorEntity AS fd WHERE fd.filmId = :id");
        query1.setParameter("id", this.id);
        directors = query1.list();

        Query query2 = session.createQuery("SELECT genreId FROM FilmGenreEntity AS fg WHERE fg.filmId = :id");
        query2.setParameter("id", this.id);
        genres = query2.list();

        session.close();
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "running_time")
    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    @Basic
    @Column(name = "release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "film_director", joinColumns = { @JoinColumn(name = "film_id") }, inverseJoinColumns = { @JoinColumn(name = "director_id")})
    public List<DirectorEntity> getDirectors() {
        return directors;
    }


    public void setDirectors(List<DirectorEntity> directors) {
        this.directors = directors;
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "film_genre", joinColumns = { @JoinColumn(name = "film_id") }, inverseJoinColumns = { @JoinColumn(name = "genre_id")})
    public List<GenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreEntity> genres) {
        this.genres = genres;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmEntity that = (FilmEntity) o;

        if (id != that.id) return false;
        if (runningTime != that.runningTime) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (releaseDate != null ? !releaseDate.equals(that.releaseDate) : that.releaseDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + runningTime;
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        return result;
    }
}
