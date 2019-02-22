package com.navin.newrozgram.ui.main;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.navin.newrozgram.R;
import com.navin.newrozgram.models.Image;
import com.navin.newrozgram.webservice.ApiClient;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.PagerAdapter;

/**
 * Created by Android on 9/27/2017.
 */

public class SlidingImage_Adapter extends PagerAdapter {


    Context m_context;

    List<Image> imageList = new ArrayList<>();
    LayoutInflater inflater;

    public SlidingImage_Adapter(Context context, List<Image> data) {

        m_context = context;

        imageList = data;

        inflater = LayoutInflater.from(m_context);

    }

    @Override
    public int getCount() {
        return imageList.size();
    }


    @Override
    public Object instantiateItem(ViewGroup view, final int position) {
        View imageLayout = inflater.inflate(R.layout.slidingimage, view, false);

        Image apps = imageList.get(position);
        assert imageLayout != null;
        final ImageView imageView = imageLayout.findViewById(R.id.img_post);



        Picasso.get()
                .load(ApiClient.BASE_URL_IMAGES + apps.getImage())
                .error(R.mipmap.ic_launcher)
                .into(imageView);

        view.addView(imageLayout, 0);


        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
