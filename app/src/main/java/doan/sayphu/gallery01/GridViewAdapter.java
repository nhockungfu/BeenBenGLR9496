package doan.sayphu.gallery01;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import static doan.sayphu.gallery01.R.layout.adapter_photofolder;

/**
 * Created by BEN on 20/04/2017.
 */


public class GridViewAdapter extends ArrayAdapter<Model_images> {

    Context context;
    ViewHolder viewHolder;
    ArrayList<Model_images> al_menu = new ArrayList<>();
    int int_position;
    //RelativeLayout relativeLayout1;
    //RelativeLayout relativeLayout2;


    public GridViewAdapter(Context context, ArrayList<Model_images> al_menu,int int_position) {
        super(context, R.layout.adapter_photofolder, al_menu);
        this.al_menu = al_menu;
        this.context = context;
        this.int_position = int_position;
    }

    @Override
    public int getCount() {

        Log.e("ADAPTER LIST SIZE", al_menu.get(int_position).getAl_imagepath().size() + "");
        return al_menu.get(int_position).getAl_imagepath().size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        if (al_menu.get(int_position).getAl_imagepath().size() > 0) {
            return al_menu.get(int_position).getAl_imagepath().size();
        } else {
            return 1;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(adapter_photofolder, parent, false);
            viewHolder.tv_foldern = (TextView) convertView.findViewById(R.id.tv_folder);
            viewHolder.tv_foldersize = (TextView) convertView.findViewById(R.id.tv_folder_number);
            viewHolder.iv_image = (ImageView) convertView.findViewById(R.id.iv_image);
            viewHolder.relativeLayout_res1 = (RelativeLayout) convertView.findViewById(R.id.rectangle_bottom1);
            viewHolder.relativeLayout_res2 = (RelativeLayout) convertView.findViewById(R.id.rectangle_bottom2);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tv_foldern.setVisibility(View.GONE);
        viewHolder.tv_foldersize.setVisibility(View.GONE);
        viewHolder.relativeLayout_res1.setVisibility(View.GONE);
        viewHolder.relativeLayout_res2.setVisibility(View.GONE);


        Glide.with(context).load("file://" + al_menu.get(int_position).getAl_imagepath().get(position))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(viewHolder.iv_image);

        return convertView;

    }

    private static class ViewHolder {
        TextView tv_foldern, tv_foldersize;
        RelativeLayout relativeLayout_res1, relativeLayout_res2;
        ImageView iv_image;
    }
}
