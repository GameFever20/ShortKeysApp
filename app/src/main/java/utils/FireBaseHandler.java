package utils;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Aisha on 12/24/2017.
 */

public class FireBaseHandler {

    private DatabaseReference mDatabaseRef;
    private FirebaseDatabase mFirebaseDatabase;

    public FireBaseHandler() {

        mFirebaseDatabase = FirebaseDatabase.getInstance();

    }


    public void uploadShortKeys(final KeyBoardShortcut keyBoardShortcut, String shortkeyType, final OnDatalistener onDatalistener) {


        mDatabaseRef = mFirebaseDatabase.getReference().child("ShortKey Data/" + shortkeyType + "/");

        keyBoardShortcut.setShortKeyUID(mDatabaseRef.push().getKey());

        DatabaseReference mDatabaseRef1 = mFirebaseDatabase.getReference().child("ShortKey Data/" + shortkeyType + "/" + keyBoardShortcut.getShortKeyUID());


        mDatabaseRef1.setValue(keyBoardShortcut).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                // onDatalistener.onDataDownLoad(, true);
                onDatalistener.onDataUpload(true);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("Failed to Upload Story", e.getMessage());

                onDatalistener.onDataUpload(false);
                onDatalistener.onDataDownLoad(null, false);
            }
        });


    }

    public void downloadKeyList(int limit, String shortKeyType, final OnDatalistener onDatalistener) {


        mDatabaseRef = mFirebaseDatabase.getReference().child("ShortKey Data/" + shortKeyType + "/");

        Query myref2 = mDatabaseRef.orderByKey().limitToFirst(limit);

        myref2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<KeyBoardShortcut> keyArrayList = new ArrayList<KeyBoardShortcut>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    KeyBoardShortcut keyBoardShortcut = snapshot.getValue(KeyBoardShortcut.class);
                    if (keyBoardShortcut != null) {
                        keyBoardShortcut.setShortKeyUID(snapshot.getKey());
                    }
                    keyArrayList.add(keyBoardShortcut);
                }

                // Collections.reverse(questionsArrayList);

                onDatalistener.onShortkeyDownload(keyArrayList, true);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                onDatalistener.onShortkeyDownload(null, false);

            }
        });


    }

    public interface OnDatalistener {


        public void onDataDownLoad(String itemData, boolean isSuccessful);

        public void onShortkeyDownload(ArrayList<KeyBoardShortcut> keyBoardShortcut, boolean isSuccessful);

        public void onDataUpload(boolean isSuccessful);
    }
}
