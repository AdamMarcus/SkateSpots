package buffsftw.skatespots;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.buffsftw.skatespots.R;

import buffsftw.skatespots.fragments.SpotListFragment;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link SkateSpots.Spots} and makes a call to the
 * specified {@link SpotListFragment.OnListFragmentInteractionListener}.
 */
public class MySpotsRecyclerViewAdapter extends RecyclerView.Adapter<MySpotsRecyclerViewAdapter.ViewHolder> implements SpotListFragment.OnListFragmentInteractionListener
{

    private final List<SkateSpots.Spots> mValues;
    private final   SpotListFragment.OnListFragmentInteractionListener mListener;

    public MySpotsRecyclerViewAdapter(List<SkateSpots.Spots> items,
                                      SpotListFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_spots, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(1);
        //Todo: Calculate distance with phone location and spot location
        holder.mDistanceView.setText("3");
        holder.mNameView.setText(mValues.get(position).name);
        holder.mRatingView.setRating(mValues.get(position).rating);
        holder.mRatingDifficultyView.setText(Integer.toString(mValues.get(position).difficultyRating));
        holder.mRatingSecurityView.setText(Integer.toString(mValues.get(position).securityRating));
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }



    @Override
    public void onListFragmentInteraction(SkateSpots.Spots item) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        public final TextView mNameView;
        public final RatingBar mRatingView;
        public final TextView mRatingDifficultyView;
        public final TextView mRatingSecurityView;
        public final TextView mDistanceView;

        public SkateSpots.Spots mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.name);
            mDistanceView = (TextView) view.findViewById(R.id.distance);
            mRatingView = (RatingBar) view.findViewById(R.id.ratingBar);
            mRatingDifficultyView = (TextView) view.findViewById(R.id.difficulty);
            mRatingSecurityView = (TextView) view.findViewById(R.id.security);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNameView.getText() + "'";
        }
    }
}