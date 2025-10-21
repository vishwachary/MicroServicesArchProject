package com.example.moviecatalogservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MOVIE_INFO")
public class MovieInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "MOVIE_NAME", nullable = false)
    private String movieName;

    @Column(name = "MOVIE_DESC", nullable = false)
    private String movieDescription;


    @Column(name = "MOVIE_RATING", nullable = false)
    private Integer rating;


    public MovieInfo(Long id, String movieName, String movieDescription, Integer rating) {
        this.id = id;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.rating = rating;
    }

    public MovieInfo() {
    }

    public static MovieInfoBuilder builder() {
        return new MovieInfoBuilder();
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MovieInfo)) return false;
        final MovieInfo other = (MovieInfo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$movieName = this.getMovieName();
        final Object other$movieName = other.getMovieName();
        if (this$movieName == null ? other$movieName != null : !this$movieName.equals(other$movieName)) return false;
        final Object this$movieDescription = this.getMovieDescription();
        final Object other$movieDescription = other.getMovieDescription();
        if (this$movieDescription == null ? other$movieDescription != null : !this$movieDescription.equals(other$movieDescription))
            return false;
        final Object this$rating = this.getRating();
        final Object other$rating = other.getRating();
        if (this$rating == null ? other$rating != null : !this$rating.equals(other$rating)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MovieInfo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $movieName = this.getMovieName();
        result = result * PRIME + ($movieName == null ? 43 : $movieName.hashCode());
        final Object $movieDescription = this.getMovieDescription();
        result = result * PRIME + ($movieDescription == null ? 43 : $movieDescription.hashCode());
        final Object $rating = this.getRating();
        result = result * PRIME + ($rating == null ? 43 : $rating.hashCode());
        return result;
    }

    public String toString() {
        return "MovieInfo(id=" + this.getId() + ", movieName=" + this.getMovieName() + ", movieDescription=" + this.getMovieDescription() + ", rating=" + this.getRating() + ")";
    }

    public Long getId() {
        return this.id;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public String getMovieDescription() {
        return this.movieDescription;
    }

    public Integer getRating() {
        return this.rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public static class MovieInfoBuilder {
        private Long id;
        private String movieName;
        private String movieDescription;
        private Integer rating;

        MovieInfoBuilder() {
        }

        public MovieInfoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MovieInfoBuilder movieName(String movieName) {
            this.movieName = movieName;
            return this;
        }

        public MovieInfoBuilder movieDescription(String movieDescription) {
            this.movieDescription = movieDescription;
            return this;
        }

        public MovieInfoBuilder rating(Integer rating) {
            this.rating = rating;
            return this;
        }

        public MovieInfo build() {
            return new MovieInfo(this.id, this.movieName, this.movieDescription, this.rating);
        }

        public String toString() {
            return "MovieInfo.MovieInfoBuilder(id=" + this.id + ", movieName=" + this.movieName + ", movieDescription=" + this.movieDescription + ", rating=" + this.rating + ")";
        }
    }
}
