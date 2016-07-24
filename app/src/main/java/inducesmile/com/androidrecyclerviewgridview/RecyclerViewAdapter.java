package inducesmile.com.androidrecyclerviewgridview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<ItemObject> itemList;
    private Context context;
    SurfaceView surfaceView;
    public RecyclerViewAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
        surfaceView = new SurfaceView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(300, 300);

        surfaceView.setLayoutParams(layoutParams);
        surfaceView.setZOrderOnTop(true);
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        Log.i("Test", "onCreateViewHolder!!");
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        Log.i("Test", "onBindViewHolder:"+position+"-------"+surfaceView);
        if(position == 0) {
           // surfaceView.setLayoutParams(holder.countryFrame.getLayoutParams());
            holder.countryFrame.addView(surfaceView);
        }
//        holder.countryFrame.setVisibility(View.VISIBLE);
//        holder.countryName.setText(itemList.get(position).getName());
//        holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());
//        holder.countryPhoto.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
