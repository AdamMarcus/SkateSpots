package buffsftw.skatespots.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView.Adapter;
import android.widget.AdapterView;


/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */

import org.json.JSONException;

import buffsftw.skatespots.MySpotsRecyclerViewAdapter;
import buffsftw.skatespots.SkateSpots;

import static com.example.buffsftw.skatespots.R.*;

public class SpotListFragment extends Fragment implements AdapterView.OnItemClickListener{
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
  public SpotListFragment() {
    }


    // TODO: Customize parameter initialization


    // TODO: Customize parameter initialization
    public SpotListFragment newInstance() {
        SpotListFragment fragment = new SpotListFragment();
/* Not sure if needed, does not affect current app
Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, 2);
        fragment.setArguments(args);*/
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, 24);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(layout.fragment_spots_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            Adapter adapter = new MySpotsRecyclerViewAdapter(SkateSpots.ITEMS, mListener);
            recyclerView.setAdapter(adapter);

        }

        //Create an empty array for SkateSpots
        SkateSpots skateSpotList;
        skateSpotList = new SkateSpots();

        //Calls to populate the list with function in SkateSpots.java
        try {
            skateSpotList.populateList();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return view;
    }


    @Override
     public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;

    }

    /*
    @Override
    public void onResume() {
        super.onResume();
    }
    */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
        public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(SkateSpots.Spots item);
    }
}
