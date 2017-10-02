package testing.ingtest;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Krystian Duc 17 on 2017-09-18.
 */
@Entity

public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String note;
    private int customerid;
    private String date;

    public int getId() {
        return id;
    }

    public Note() {
    }


    public Note( String note, int customerid, String date) {
        this.note = note;
        this.customerid = customerid;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }
}
