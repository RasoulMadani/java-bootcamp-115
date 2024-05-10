package librarySystem;

import java.util.Arrays;

public class Library {
    Writer[] writers = new Writer[10];
    Publisher[] publishers = new Publisher[10];

    Book[] books = new Book[10];

    Member[] members = new Member[10];
    Borrow[] borrows = new Borrow[10];
    int indexBorrows = 0;
    int indexMembers = 0;
    int indexBooks = 0;
    int indexPublishers = 0;
    int indexWrites = 0;
    String name;

    public Library(String name) {
        this.name = name;
    }
    public void addBorrow(Borrow borrow){
        this.borrows[indexBorrows] = borrow;
        indexBorrows++;
    }
    public Borrow getBorrow(int id){
        for (int i = 0; i < indexBorrows; i++) {
            if(borrows[i].getId() == id){
                return borrows[i];
            }
        }
        return null;
    }
    public Borrow[] getBorrows(){
        return borrows;
    }
    public void addMember(Member member){
        this.members[indexMembers] = member;
        indexMembers++;
    }
    public Member[] getMembers(){
        return members;
    }
    public Member getMember(int id){
        for (int i = 0; i < indexMembers; i++) {
            if(members[i].getId() == id){
                return members[i];
            }
        }
        return null;
    }
    public void addBook(Book book){
        this.books[indexBooks] = book;
        indexBooks++;
    }
    public Book[] getBooks(){
        return books;
    }
    public Book getBook(int id){
        for (int i = 0; i < indexBooks; i++) {
            if(books[i].getId() == id){
                return books[i];
            }
        }
        return null;
    }
    public void addWriter(Writer writer){
        this.writers[indexWrites] = writer;
        indexWrites++;
    }
    public Writer[] getWriters(){
        return writers;
    }
    public Writer getWriter(int id){
        for (int i = 0; i < indexWrites; i++) {
            if(writers[i].getId() == id){
                return writers[i];
            }
        }
        return null;
    }
    public Publisher getPublisher(int id){
        for (int i = 0; i < indexPublishers; i++) {
            if(publishers[i].getId() == id){
                return publishers[i];
            }
        }
        return null;
    }
    public void addPublisher(Publisher publisher){
        this.publishers[indexPublishers] = publisher;
        indexPublishers++;
    }
    public Publisher[] getPublishers(){
        return publishers;
    }

    @Override
    public String toString() {
        return "Library{" + "\n" +
                "  writers=" + Arrays.toString(writers) + "\n"+
                "  publishers=" + Arrays.toString(publishers) + "\n"+
                "  books=" + Arrays.toString(books) +"\n"+
                "  members=" + Arrays.toString(members) +"\n"+
                "  borrows=" + Arrays.toString(borrows) +"\n"+
                "  indexBooks=" + indexBooks +"\n"+
                "  indexPublishers=" + indexPublishers +"\n"+
                "  indexWrites=" + indexWrites +"\n"+
                "  name='" + name + '\'' + "\n" +
                '}';
    }
}
