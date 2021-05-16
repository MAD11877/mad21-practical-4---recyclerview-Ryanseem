package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  TextView txtName,txtDesc;
    private Button follow_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        follow_button = findViewById(R.id.btnFollow);
        txtName = findViewById(R.id.txtName);
        txtDesc = findViewById(R.id.txtDescription);
        Intent data = getIntent();
        int position = data.getIntExtra("position",0);
        User user = ListActivity.userArrayList.get(position);
        txtName.setText(user.getName());
        txtDesc.setText(user.getDescription());
        if (user.isFollowed()){
            follow_button.setText("UNFOLLOW");
        }
        else{
            follow_button.setText("FOLLOW");
        }
        follow_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.isFollowed()){
                    follow_button.setText("FOLLOW");
                    user.setFollowed(false);
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
                else{
                    follow_button.setText("UNFOLLOW");
                    user.setFollowed(true);
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //User user = new User();
//
//        txtName.setText("MAD " + getIntent().getIntExtra("RandomID", 0));
//        if (user.isFollowed()){
//            follow_button.setText("UNFOLLOW");
//        }
//        else{
//            follow_button.setText("FOLLOW");
//        }
//        follow_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (user.isFollowed()){
//                    follow_button.setText("FOLLOW");
//                    user.setFollowed(false);
//                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    follow_button.setText("UNFOLLOW");
//                    user.setFollowed(true);
//                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
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