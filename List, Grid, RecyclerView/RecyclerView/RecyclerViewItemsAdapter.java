package your.package.name;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ramesia.com.ramesia.R;
import ramesia.com.ramesia.model.Item;

/**
 * Created by teresa on 9/3/2015.
 * https://github.com/pnteresa/android-basic-everything
 */
public class RecyclerViewItemsAdapter extends RecyclerView.Adapter<HotItemsAdapter.ViewHolder>{
    // Item: see example
    List<Item> mList;
    public Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mIVimg;

        public Context mContext;

        public ViewHolder(View v) {
            super(v);
            mIVimg = (ImageView) v.findViewById(R.id.mIVimg);
        }

        public void add(int position, Item item) {
            mList.add(position, item);
            notifyItemInserted(position);
        }
    }

    public void remove(Item item) {
        int position = mList.indexOf(item);
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public HotItemsAdapter(Context mContext, List<Item> myDataset) {
        this.mContext = mContext; mList = myDataset;
    }

    @Override
    public RecyclerViewItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_hot, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.mIVimg.setBackgroundDrawable(mList.get(position).getImg());
        int imageResource = mContext.getResources().getIdentifier(mList.get(position).getImgUri(), null, mContext.getPackageName());

        Drawable res = ResourcesCompat.getDrawable(mContext.getResources(), imageResource, null);

        holder.mIVimg.setImageDrawable(res);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
