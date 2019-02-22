package com.navin.newrozgram.ui.main;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.navin.androidframework.ui.CircleTransform;
import com.navin.newrozgram.R;
import com.navin.newrozgram.models.Image;
import com.navin.newrozgram.models.Posts;
import com.navin.newrozgram.webservice.ApiClient;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.navin.newrozgram.webservice.ApiClient.BASE_URL_IMAGES;

public class PostAdapter extends RecyclerView.Adapter<PostviewHolder> {

    List<Posts> postsList;
    Context context;

    public PostAdapter(Context context, List<Posts> posts) {
        this.context = context;
        postsList = posts;

    }


    @NonNull
    @Override
    public PostviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_row, null);
        return new PostviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostviewHolder holder, int position) {

        Posts posts = postsList.get(position);


        holder.txt_username.setText(posts.getUsername());
        Picasso.get().load(BASE_URL_IMAGES +posts.getImageProfile()).transform(new CircleTransform()).into(holder.img_user_profile);

        String image = posts.getImages();

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Image>>() {}.getType();

        List<Image> imageList = new Gson().fromJson(image, listType);

        SlidingImage_Adapter slidingImage_adapter = new SlidingImage_Adapter(context,imageList);


        holder.pager.setAdapter(slidingImage_adapter);



        Log.e("","");


    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }
}
