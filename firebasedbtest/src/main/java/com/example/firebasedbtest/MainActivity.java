package com.example.firebasedbtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    private String result="";
    private DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("users");
    private TextView textView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById( R.id.textView);

        for( int i =0 ; i<10; i++) {
            String seq = Integer.toString(i);

            String userId = "ID" + seq;
            String userName = "Name" + seq;
            String userEmail = "Email" + seq;
            String userPhone = "Phone" + seq;

            User user = new User( userId, userName, userEmail, userPhone);
            addUser( myRef, user);
        }
        //showUserName( "ID5");

        //textView.setText( user.getUserName());
        /*
        myRef.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild("ID5")) {
                    User user = dataSnapshot.child("ID5").getValue(User.class);
                    textView.setText( "UserName : " + user.getUserName());
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        */

    myRef.addChildEventListener(new ChildEventListener() {
        @Override public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            chatConversation(dataSnapshot);
        }

        @Override public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            chatConversation(dataSnapshot);
        }

        @Override public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override public void onCancelled(DatabaseError databaseError) {

        }
    });
}
    private void chatConversation(DataSnapshot dataSnapshot) {
        Iterator i = dataSnapshot.getChildren().iterator();
/*
        while (i.hasNext()) {
            chat_user = (String) ((DataSnapshot) i.next()).getValue();
            chat_msg = (String) ((DataSnapshot) i.next()).getValue();

            arrayAdapter.add(chat_user + " : " + chat_msg);
        }

        textView.notifyDataSetChanged();*/
    }



     public void addUser(DatabaseReference reference,  User user) {
        DatabaseReference myRef = reference;
        User myUser = user;

        myRef.child( myUser.getUserId()).setValue( myUser);
     }

     public void showUserName( String userId) {
        String Id = userId;
        getUser(Id, new LoadUserCallback()  {
            @Override
            public void onUserLoaded( User user) {
                textView.setText(user.getUserName());
            }
        });
     }

     public void getUser(@NonNull final String userId, @NonNull final LoadUserCallback callback) {

        myRef.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(userId)) {
                    User user = dataSnapshot.child(userId).getValue(User.class);
                    callback.onUserLoaded(user);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
     }
}
