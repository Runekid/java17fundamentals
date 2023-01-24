package exercise06_09;

import javax.persistence.Entity;

@Entity
public class Book extends MultiMedia {
    private int pages;

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }


    @Override
    public String toString() {
        return super.toString() + "Book{" +
                "pages=" + pages +
                '}';
    }
}
