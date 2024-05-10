package librarySystem;

import java.util.Arrays;

public class Borrow {
    int id;
    Member member;
    Book[] items = new Book[10];
    int indexItems=0;
    public Borrow(int id, Member member) {
        this.id = id;
        this.member = member;
    }
    public void addItem(Book book){
        book.setBorrowed(true);
        items[indexItems] = book;
        indexItems++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book[] getItems() {
        return items;
    }

    public void setItems(Book[] items) {
        this.items = items;
    }

    public int getIndexItems() {
        return indexItems;
    }

    public void setIndexItems(int indexItems) {
        this.indexItems = indexItems;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", member=" + member +
                ", items=" + Arrays.toString(items) +
                ", indexItems=" + indexItems +
                '}';
    }
}
