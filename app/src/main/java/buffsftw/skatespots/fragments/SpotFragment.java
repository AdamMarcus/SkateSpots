package buffsftw.skatespots.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buffsftw.skatespots.R;
import com.squareup.picasso.Picasso;

import buffsftw.skatespots.SkateSpots;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SpotFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class SpotFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/*    private static final SkateSpots ARG_PARAM1 = "param1";*/

    private SkateSpots spot;

    private OnFragmentInteractionListener mListener;

  /*  public SpotFragment() {
        // Required empty public constructor
    }*/

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SpotFragment.
     */
    // TODO: Rename and change types and number of parameters
   public static SpotFragment newInstance(String param1, String param2) {
        SpotFragment fragment = new SpotFragment();
        Bundle args = new Bundle();
        /*args.put(ARG_PARAM1, param1);*/
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            /*spot = getArguments().getString(ARG_PARAM1);*/


        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_spot, container, false);
/*        Bundle bundle = getArguments();

        //Load map image into Image view
        ImageButton IV =(ImageButton) view.findViewById(R.id.googleMapsStaticImage);
        String lat = String.valueOf(bundle.getDouble("lat",40.0150));
        String lon = String.valueOf(bundle.getDouble("lon",-105.2705));
        String url = "http://maps.googleapis.com/maps/api/staticmap?center=" + lat + "," + lon + "&zoom=16&scale=2&size=360x360&maptype=hybrid&format=png&visual_refresh=true&markers=size:mid%7Ccolor:0xff0000%7Clabel:1%7C" + lat + "," + lon;
        Picasso.with(getContext()).load(url).into(IV);
        IV.setOnClickListener(this.onClickListener);

        TextView nameTextView = (TextView) view.findViewById(R.id.textView2);
        String nameText = bundle.getString("name","Default");
        nameTextView.setText(nameText);*/

        return view;
    }

    View.OnClickListener onClickListener= new View.OnClickListener() {
        public void onClick(View v) {
//What to do when map is clicked
        }
    };


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        Bundle bundle = getArguments();
        View view = getView();
        //Load map image into Image view
        ImageButton IV =(ImageButton) view.findViewById(R.id.googleMapsStaticImage);
        String lat = String.valueOf(bundle.getDouble("lat",40.0150));
        String lon = String.valueOf(bundle.getDouble("lon",-105.2705));
        String url = "http://maps.googleapis.com/maps/api/staticmap?center=" + lat + "," + lon + "&zoom=16&scale=2&size=360x360&maptype=hybrid&format=png&visual_refresh=true&markers=size:mid%7Ccolor:0xff0000%7Clabel:1%7C" + lat + "," + lon;
        Picasso.with(getContext()).load(url).into(IV);
        IV.setOnClickListener(this.onClickListener);

        TextView nameTextView = (TextView) view.findViewById(R.id.textView2);
        String nameText = bundle.getString("name","Default");
        nameTextView.setText(nameText);
            }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
