//package com.wolfsoft.one.bronzeapp;
package com.incubate.code.spartanapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by one on 20/8/16.
 */
public class Fragment1 extends Fragment {

    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmen_one, container, false);


        return view;
    }

}
