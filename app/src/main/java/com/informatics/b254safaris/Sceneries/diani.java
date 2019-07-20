package com.informatics.b254safaris.Sceneries;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.informatics.b254safaris.R;
import com.informatics.b254safaris.googleplaceapi.activities.DetailActivity;
import com.informatics.b254safaris.googleplaceapi.models.Hotel;

public class diani extends AppCompatActivity {

	RecyclerView recyle;
	private LinearLayout mProgressLayout;
	private Boolean isLoggingOut = false;
	private DatabaseReference Hotels;
	private String image;
	TextView text;
	private FirebaseRecyclerAdapter<Hotel, HotelsViewHolder> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hotel);
//		text = findViewById(R.id.tv_messages_error);
//		mProgressLayout = findViewById(R.id.layout_discussions_progress);
		recyle = findViewById(R.id.reyclerview_hotel_list);
		recyle.setLayoutManager(new LinearLayoutManager(this));


//		String bookKey = getIntent().getStringExtra("bookKey");
//		Log.e("TopicsActivity","" + bookKey);

		Hotels = FirebaseDatabase.getInstance().getReference().child("Sceneries");

	}
	@Override
	protected void onStart() {
		super.onStart();

		loadData();
	}
	private void loadData() {

        Query query = Hotels.orderByChild("Town").equalTo("Diani");

            FirebaseRecyclerOptions<Hotel> options =
                    new FirebaseRecyclerOptions.Builder<Hotel>()
                            .setQuery(query, Hotel.class)
                            .setLifecycleOwner(this)
                            .build();

            adapter = new FirebaseRecyclerAdapter<Hotel, HotelsViewHolder>(options) {
                @Override
                protected void onBindViewHolder(@NonNull final HotelsViewHolder holder, final int position, @NonNull final Hotel model) {
                    holder.booktitle.setText(model.getBookTitle());

                    image = model.getURL();
                    Glide.with(getApplication()).load(image).into(holder.imageView);
//				holder.shortdescription.setText(model.getShortDescription());
//				holder.mDateCreatedTv.setText(model.getDateCreated());
//				mProgressLayout.setVisibility(View.GONE);


//                FirebaseDatabase.getInstance().getReference().child("Books")
//                        .child(model.getBookTitle()).addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//
//                        String username = dataSnapshot.child("Hotel Author").getValue(String.class);
//
//
//                        holder.booktitle.setText(username);
//
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });

                    holder.mView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent topicsIntent = new Intent(diani.this, DetailActivity.class);
                            topicsIntent.putExtra("keypass", model.getShortDescription());
                            startActivity(topicsIntent);


                        }
                    });


                }

                @NonNull
                @Override
                public HotelsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                    return new HotelsViewHolder(LayoutInflater.from(getApplicationContext())
                            .inflate(R.layout.image_adapter_item, parent, false));

                }
            };

            adapter.startListening();
            recyle.setAdapter(adapter);

        }




	private class HotelsViewHolder extends RecyclerView.ViewHolder{
		TextView booktitle, shortdescription, mDateCreatedTv;
   ImageView imageView;
		private View mView;

		public HotelsViewHolder(View itemView) {
			super(itemView);

			mView = itemView;

			booktitle = itemView.findViewById(R.id.mtext);
			imageView = itemView.findViewById(R.id.mimage);
//			shortdescription = itemView.findViewById(R.id.short_discription);
//			mDateCreatedTv = itemView.findViewById(R.id.tv_date_created);


		}
	}

}
