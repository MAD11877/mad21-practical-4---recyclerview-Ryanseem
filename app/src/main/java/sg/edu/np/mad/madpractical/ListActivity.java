package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    static ArrayList<User> userArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Random random = new Random();

        for(int i = 0; i < 20; i ++){
            User user = new User("Name" + random.nextInt(), String.valueOf(random.nextInt()),random.nextInt(),followBool(random));
            userArrayList.add(user);
        }


        setContentView(R.layout.activity_list);
        RecyclerView recyclerView = findViewById(R.id.rv);
        UserAdapter userAdapter = new UserAdapter(userArrayList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);
        //AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
//        ImageView listImage = findViewById(R.id.listImage);
//        listImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                builder.setTitle("Profile");
//                builder.setMessage("MADness");
//                builder.setCancelable(true);
//                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
//                    public void onClick(DialogInterface dialog, int id){
//                        Intent intent = new Intent(ListActivity.this, MainActivity.class);
//                        intent.putExtra("RandomID", new Random().nextInt() & Integer.MAX_VALUE);
//                        startActivity(intent);
//                    }
//                });
//                builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
//                    public void onClick(DialogInterface dialog, int id){
//
//                    }
//                });
//                builder.show();
//            }
//        });

    }
    private boolean followBool(Random random){
        int ranVal = random.nextInt(2);
        if(ranVal == 1){
            return true;
        }
        else {
            return false;
        }
    }
}