package com.example.builder;

import com.example.proxy.Book;

import java.util.List;

public class Author {
  private Integer id;
  private String name, country, favouriteCake;
  private List<Book> booksWritten;
  private Integer birthYear;

  private Author() { }

  @Override
  public String toString() {
    return "Author{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", country='" + country + '\'' +
        ", favouriteCake='" + favouriteCake + '\'' +
        ", booksWritten=" + booksWritten +
        ", birthYear=" + birthYear +
        '}';
  }

  public static class Builder {
    private Integer id;
    private String name, country, favouriteCake;
    private List<Book> booksWritten;
    private Integer birthYear;

    public Builder(Integer id) { // id is mandatory, so will force it
      this.id = id;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder country(String country) {
      this.country = country;
      return this;
    }

    public Builder favouriteCake(String favouriteCake) {
      this.favouriteCake = favouriteCake;
      return this;
    }

    public Builder booksWritten(List<Book> booksWritten) {
      this.booksWritten = booksWritten;
      return this;
    }

    public Builder birthYear(Integer birthYear) {
      this.birthYear = birthYear;
      return this;
    }

    public Author build() {
      Author author = new Author();
      author.id = this.id;
      author.name = this.name;
      author.country = this.country;
      author.favouriteCake = this.favouriteCake;
      author.booksWritten = this.booksWritten;
      author.birthYear = this.birthYear;
      return author;
    }
  }
}
