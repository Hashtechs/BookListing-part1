package hashtech.com.booklisting;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

import hashtech.com.booklisting.models.Book;
import hashtech.com.booklisting.utils.ApiHelper;
import hashtech.com.booklisting.utils.HttpRequestHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragments extends Fragment {

    private static final String TAG = "BookFragments";
    private RecyclerView recyclerView;
    private TextView tvResponse;

    public BookFragments() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_book_fragments, container, false);
        tvResponse = (TextView) v.findViewById(R.id.tvResponse);


//        recyclerView = (RecyclerView) v.findViewById(R.id.recycler);
//        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
//        recyclerView.setAdapter(new BooksAdapter(getActivity(), new ArrayList<Book>()));

        new BooksAsyncTask().execute(ApiHelper.LIST_BOOK_URL);

        return v;
    }


    /**
     * {@link AsyncTask
     * } to perform the network request on a background thread, and then
     * update the UI with the first book in the response.
     */
    private class BooksAsyncTask extends AsyncTask<String , Void, String> {

        @Override
        protected String doInBackground(String ... urls) {
            Log.d(TAG, "doInBackground: ");
            // Create URL object
            URL url = HttpRequestHelper.createUrl(urls[0]);

            // Perform HTTP request to the URL and receive a JSON response back
            String jsonResponse = "";
            try {
                SystemClock.sleep(2000);
                jsonResponse = HttpRequestHelper.makeHttpRequest(url);
                Log.d(TAG, "done: ");
            } catch (IOException e) {
                // TODO Handle the IOException
            }

//            // Extract relevant fields from the JSON response and create an {@link Book} object
//            Book book = parseJson(jsonResponse);

            // Return the {@link Book} object as the result fo the {@link BooksAsyncTask}
            return jsonResponse;
        }

        /**
         * Update the screen with the given book (which was the result of the
         * {@link BooksAsyncTask}).
         */
        @Override
        protected void onPostExecute(String response) {

            // if response is null do not update the UI
            if (response == null) {
                return;
            }

            updateUi(response);
        }

    }

    private void updateUi(String response) {
        tvResponse.setText(response);
    }

    private Book parseJson(String jsonResponse) {
        return null;
    }
}