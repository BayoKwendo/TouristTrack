package com.informatics.b254safaris;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.informatics.b254safaris.Hotel.diani;
import com.informatics.b254safaris.Hotel.hotel;
import com.informatics.b254safaris.Hotel.lamu;
import com.informatics.b254safaris.Restaurant.mombasa;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Search.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Search#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Search extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
private Button mNameField, mEmail, mPhoneField;
    private OnFragmentInteractionListener mListener;

    public Search() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Search.
     */
    // TODO: Rename and change types and number of parameters
    public static Search newInstance(String param1, String param2) {
        Search fragment = new Search();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
//        showAlertDialoglicked();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_search, container, false);

        mNameField =  root.findViewById(R.id.imageButton2);
        mPhoneField =  root.findViewById(R.id.imageButton3);
        mEmail = root.findViewById(R.id.imageButton4);

        mNameField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTownMombasa();

            }


        });
        mPhoneField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTownLamu();

            }
        });
        mEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTownDiani();

            }
        });

        // Inflate the layout for this fragment
        return root;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

//    public void showAlertDialoglicked() {
//
//        // setup the alert builder
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setTitle("Select Town");
//        // add a list
//        String[] animals = {"mbs", "lamu", "Diani"};
//        builder.setItems(animals, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                switch (which) {
//                    case 0: // horse
//                        showTownMombasa();
//                        break;
//                    case 1: // cow
//                        showTownLamu();
//                        break;
//
//                    case 2: // camel
//                        showTownDiani();
//                        break;
//
//
//                }
//            }
//        });
//
//        // create and show the alert dialog
//        AlertDialog dialog = builder.create();
//        dialog.show();
//    }




    public void showTownMombasa() {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Select Here.. mbs");
        // add a list
        String[] animals = {"Hotels", "Restaurants", "Sceneries"};
        builder.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0: // horse
                        startActivity(new Intent(getActivity(), hotel.class)); // they are executed if variable ==  any of the above c's
                        break;
                    case 1: // cow
                        startActivity(new Intent(getActivity(), mombasa.class)); // they are executed if variable ==  any of the above c's
                        break;

                    case 2: // camel
                        startActivity(new Intent(getActivity(), com.informatics.b254safaris.Sceneries.mombasa.class)); // they are executed if variable ==  any of the above c's
                        break;

                }
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void showTownLamu() {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Select Here.. lamu");

        // add a list
        String[] animals = {"Hotels", "Restaurants", "Sceneries"};
        builder.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0: // horse
                        startActivity(new Intent(getActivity(), lamu.class)); // they are executed if variable ==  any of the above c's
                        break;
                    case 1: // cow
                        startActivity(new Intent(getActivity(), com.informatics.b254safaris.Restaurant.lamu.class)); // they are executed if variable ==  any of the above c's
                        break;

                    case 2: // camel
                        startActivity(new Intent(getActivity(), com.informatics.b254safaris.Sceneries.lamu.class)); // they are executed if variable ==  any of the above c's
                        break;

                }
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void showTownDiani() {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Select Here..");

        // add a list
        String[] animals = {"Hotels", "Restaurants", "Sceneries"};
        builder.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0: // horse
                        startActivity(new Intent(getActivity(), diani.class)); // they are executed if variable ==  any of the above c's
                        break;
                    case 1: // cow
                        startActivity(new Intent(getActivity(), com.informatics.b254safaris.Restaurant.diani.class)); // they are executed if variable ==  any of the above c's
                        break;

                    case 2: // camel
                        startActivity(new Intent(getActivity(), com.informatics.b254safaris.Sceneries.diani.class)); // they are executed if variable ==  any of the above c's
                        break;

                }
            }
        });


        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
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

    @Override
    public void onResume() {
        super.onResume();


    }
}
