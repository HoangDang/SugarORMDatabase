package dnb.sugar.database;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import dnb.sugar.database.model.BookModel;

public class MainActivity extends Activity {


    private ListView listBook;
    private TextView lblMessage;

    private void log(String msg) {
        Log.d("DNB", getClass().getName() + ">>" + msg);
    }


    @Override
    protected synchronized void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listBook = (ListView) findViewById(R.id.list_book);
        lblMessage = (TextView) findViewById(R.id.lbl_msg);

        lblMessage.setText("Loading data");


        BookModel.deleteAll(BookModel.class);

        BookModel book = new BookModel();
        book.setAuth("Robert Cecil Martin");
        book.setContent("Even bad code can function.");
        book.setEdition("v01");
        book.setTitle("Clean Code");
        book.save();

        book = new BookModel();
        book.setAuth("G. Blake Meike, Laird Dornin, Masumi Nakamura, and Zigurd Mednieks");
        book.setContent("Get thoroughly up to speed on Android programming, and learn how to create up-to-date user experiences for both handsets and tablets.");
        book.setEdition("v01");
        book.setTitle("Programming Android");
        book.save();

        List<BookModel> books = BookModel.listAll(BookModel.class);


        if (books != null) {
            if (books.size() > 0) {
                lblMessage.setVisibility(View.GONE);

                String[] arr = new String[books.size()];

                for (int i = 0; i < arr.length; i++) {
                    arr[i] = books.get(i).getAuth();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
                listBook.setAdapter(adapter);
            } else {
                lblMessage.setText("Empty data");
            }
        } else {
            lblMessage.setText("Not found data");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
