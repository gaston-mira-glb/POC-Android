package com.poc_android.activities;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.poc_android.R;


public class CreditCardFragment extends android.support.v4.app.Fragment {

    public static final String CREDIT_CARD = "card";
    private int mCreditCard;
    private TextView mCreditCardTextView;

    public CreditCardFragment() {
        // Required empty public constructor
    }

    public static CreditCardFragment create (int creditCardNumber) {
        CreditCardFragment fragment = new CreditCardFragment();
        Bundle args = new Bundle();
        args.putInt(CREDIT_CARD, creditCardNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_credit_card, container, false);
        mCreditCardTextView = (TextView) rootView.findViewById(R.id.credit_card_number);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCreditCardTextView.setText(String.valueOf(mCreditCard));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCreditCard = getArguments().getInt(CREDIT_CARD);
    }

    public int getCreditCardNumber() {
        return mCreditCard;
    }
}
