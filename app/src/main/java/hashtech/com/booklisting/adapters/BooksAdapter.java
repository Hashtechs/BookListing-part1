package hashtech.com.booklisting.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hashtech.com.booklisting.R;
import hashtech.com.booklisting.models.Book;

/**
 * Created by MFQ on 6/25/16.
 */
public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.LocationViewHolder> {

    Context mContext;
    ArrayList<Book> mBooks;

    public BooksAdapter(Context mContext, ArrayList<Book> mBooks) {
        this.mContext = mContext;
        this.mBooks = mBooks;
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LocationViewHolder(LayoutInflater.from(mContext).inflate(R.layout.books_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {

//        holder.tvTitle.setText(mBooks.get(position).getTitle());
//        holder.tvAuthor.setText(mBooks.get(position).getAuthor());
//        Glide
//                .with(mContext)
//                .load(mBooks.get(position).getImageUrl())
//                .placeholder(R.drawable.ic_thumb_down_black_24dp)
//                .crossFade()
//                .into(holder.bookImage);


    }

    @Override
    public int getItemCount() {
        return 10;
    }

    protected class LocationViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvAuthor;
        ImageView bookImage;

        public LocationViewHolder(View itemView) {
            super(itemView);
//            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
//            tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);
//            bookImage = (ImageView) itemView.findViewById(R.id.img);


        }
    }
}
