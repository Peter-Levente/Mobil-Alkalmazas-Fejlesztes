package com.example.a6_hazi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CurrencyFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrencyFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    protected static final String FRAG2 = "2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CurrencyFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static CurrencyFragment1 newInstance(String param1, String param2) {
        CurrencyFragment1 fragment = new CurrencyFragment1();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.currencyfragment_1, container, false);
        Context context = getActivity().getApplicationContext();

        Integer[] flags_img = {R.drawable.eur,
                R.drawable.usa,
                R.drawable.gbr,
                R.drawable.aus,
                R.drawable.can,
                R.drawable.svi,
                R.drawable.dan,
                R.drawable.hun};


        String[] short_name = {"EUR", "USD", "GBP", "AUD", "CAD", "CHF", "DKK", "HUF"};

        String[] name = {"Euro",
                "Dolar american",
                "Lira sterlina",
                "Dolar australian",
                "Dolar canadian",
                "Franc elvetian",
                "Coroana daneza",
                "Forint maghiar"};

        String[] buys = {"4,4100 RON",
                "3,9750 RON",
                "6,1250 RON",
                "2,9600 RON",
                "3,0950 RON",
                "4,2300 RON",
                "0,5850 RON",
                "0,0136 RON"};

        String[] sells = {"4,5500 RON",
                "4,1450 RON",
                "6,3550 RON",
                "3,0600 RON",
                "3,2650 RON",
                "4,3300 RON",
                "0,6150 RON",
                "0,0146 RON"};

        ListView currencylist = view.findViewById(R.id.currency_list);
        ArrayAdapter<String> arrayAdpt = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, short_name);
        currencylist.setAdapter(arrayAdpt);

        FragmentManager fm = getParentFragmentManager();
        currencylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (fm.findFragmentByTag(FRAG2) != null) {
                    TextView selectedOpt = getActivity().findViewById(R.id.selectedopt);

                    ImageView flagImageView = getActivity().findViewById(R.id.flag_image);
                    flagImageView.setImageResource(flags_img[position]);

                    String details = "You have selected " + short_name[position] + " (" + name[position] + ")\n" +
                            "Buy Price: " + buys[position] + "\n" +
                            "Sell Price: " + sells[position];

                    selectedOpt.setText(details);

                } else {
                    Intent intent = new Intent(getActivity().getApplicationContext(), ShowItemActivity.class);

                    intent.putExtra("flag", flags_img[position]);
                    intent.putExtra("short_name", short_name[position]);
                    intent.putExtra("name", name[position]);
                    intent.putExtra("buy", buys[position]);
                    intent.putExtra("sell", sells[position]);

                    startActivity(intent);
                }
            }
        });

        return view;
    }
}