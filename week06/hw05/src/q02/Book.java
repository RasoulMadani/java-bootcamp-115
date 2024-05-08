package q02;

import java.time.Duration;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Book {
    int id;
    String name;
    String subject;
    LocalDate year_published;
    Publisher publisher;
    Writer writer;
    private boolean isBorrowed = false;
    LocalDate date_borrowed;


    public Book(int id, String name, String subject, LocalDate year_published, Publisher publisher, Writer writer) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.year_published = year_published;
        this.publisher = publisher;
        this.writer = writer;
    }

    public LocalDate getDate_borrowed() {
        return date_borrowed;
    }

    public void setDate_borrowed(LocalDate date_borrowed) {
        this.date_borrowed = date_borrowed;
    }

    public double penalty() {
        double daysBetween = DAYS.between( date_borrowed, LocalDate.now());
        System.out.println(daysBetween);
        double penalty = Math.round((daysBetween - 7) * 1000);
        return penalty > 0 ? penalty : 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getYear_published() {
        return year_published;
    }

    public void setYear_published(LocalDate year_published) {
        this.year_published = year_published;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", year_published=" + year_published +
                ", publisher=" + publisher +
                ", writer=" + writer +
                ", isBorrowed=" + isBorrowed +
                ", date_borrowed=" + date_borrowed +
                '}';
    }
}
