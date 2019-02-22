package com.navin.newrozgram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import butterknife.BindView;
import io.realm.Realm;
import io.realm.RealmResults;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.navin.androidframework.ui.BaseActivity;
import com.navin.newrozgram.config.AppConfiguration;
import com.navin.newrozgram.config.AppDatabase;
import com.navin.newrozgram.models.Book;
import com.navin.newrozgram.models.IMessageListener;
import com.navin.newrozgram.models.Posts;
import com.navin.newrozgram.models.Student;
import com.navin.newrozgram.models.UserRoom;
import com.navin.newrozgram.ui.main.PostAdapter;
import com.navin.newrozgram.webservice.ServiceCaller;

import java.util.List;
import java.util.Random;

public class MainActivity extends BaseActivity {


    ServiceCaller serviceCaller;


    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.recycler_posts) RecyclerView recycler_posts;

    @Override
    public int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        serviceCaller = new ServiceCaller();

        fillData();

        Book book = new Book(1 , "Android");
       // book.save();


        UserRoom userRoom = new UserRoom();

        Random r= new Random(20);

      //  userRoom.id= r.nextInt();
        userRoom.firstName = "test";


        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "Test").build();


        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

             //   db.daoRoom().insert(userRoom);

             //   db.daoRoom().getUserRoomList();


               // db.daoRoom().delete(userRoom);
            }
        });


        Student student = new Student();
        student.id = 2;
        student.name = "Test";

        Realm realm= Realm.getDefaultInstance();
        realm.beginTransaction();
       // realm.copyToRealm(student);
     //   realm.commitTransaction();


    /*    RealmResults<Student> realmResults = realm.where(Student.class).equalTo("id",1)
                .findAll();

        Log.e("","");*/






    }

    private void fillData() {
        progressBar.setVisibility(View.VISIBLE);
        serviceCaller.getAllPosts(0, 10, new IMessageListener() {
            @Override
            public void onSuccess(Object response) {
                Log.e("","");
                progressBar.setVisibility(View.GONE);

                recycler_posts.setAdapter(new PostAdapter(getApplicationContext(),(List<Posts>) response));

                recycler_posts.setLayoutManager(new LinearLayoutManager(
                        getApplicationContext(),RecyclerView.VERTICAL,false
                ));

            }

            @Override
            public void onFail(String errorResponse) {
                progressBar.setVisibility(View.GONE);




            }
        });
    }


}
