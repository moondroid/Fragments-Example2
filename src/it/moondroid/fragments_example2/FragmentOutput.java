package it.moondroid.fragments_example2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentOutput extends Fragment {

	private TextView tvName;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.fragment_output, container, false);

		tvName = (TextView) v.findViewById(R.id.tvName);

		return v;
	}

	public void setName(String name) {
		tvName.setText(name);
	}
	
}
