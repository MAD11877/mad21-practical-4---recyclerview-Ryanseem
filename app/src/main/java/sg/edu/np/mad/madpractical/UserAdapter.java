package sg.edu.np.mad.madpractical;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> data;

    public UserAdapter(ArrayList<User> input){
        data=input;
    }



    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item;
        if(viewType == 1){
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,parent,false);
        }
        else {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview2,parent,false);
        }
        return new UserViewHolder(item);
    }
    public void onBindViewHolder(UserViewHolder holder,int position){
        User userobj = data.get(position);
        holder.txt.setText(userobj.getName() + "\n" + "Description" + userobj.getDescription());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.image.getContext());
                builder.setMessage(userobj.getName());
                builder.setTitle("Profile");
                builder.setCancelable(true);
                builder.setNegativeButton("close",null);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("Position",position);
                        Intent intent = new Intent(holder.image.getContext(),MainActivity.class);
                        intent.putExtras(bundle);
                        holder.image.getContext().startActivity(intent);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    public int getItemCount(){
        return  data.size();
    }

    @Override
    public int getItemViewType(int position){
        User userobj = data.get(position);
        if(userobj.getName().charAt(userobj.getName().length() - 1)=='7'){
            return  0;
        }
        else {
            return 1;
        }
    }





}
