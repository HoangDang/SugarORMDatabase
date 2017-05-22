package dnb.sugar.database.model;

import com.orm.SugarRecord;

/**
 * Created by ngodung on 5/21/17.
 */

public class BookModel extends SugarRecord<BookModel> {

    private int id;
    private String title;
    private String auth;
    private String edition;
    private String content;


    public BookModel() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
