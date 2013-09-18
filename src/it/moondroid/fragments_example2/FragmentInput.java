package it.moondroid.fragments_example2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class FragmentInput extends Fragment {

	private Button buttonOK;
	private EditText etName;

	// To allow a Fragment to communicate up to its Activity,
	// you can define an interface in the Fragment class and implement it within
	// the Activity
	private FragmentListener mCallback;

	// Container Activity must implement this interface
	public interface FragmentListener {
		public void onFragmentOKClick(String s);
	}

	// The Fragment captures the interface implementation during its onAttach()
	// lifecycle method
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		// This makes sure that the container activity has implemented
		// the callback interface. If not, it throws an exception
		try {
			mCallback = (FragmentListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement FragmentListener");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.fragment_input, container, false);

		//get the reference for the EditText
		etName = (EditText) v.findViewById(R.id.etInput);
		
		// create onClickListener for the button
		buttonOK = (Button) v.findViewById(R.id.btnOk);
		buttonOK.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// call the Interface methods in order to communicate with the
				// Activity
				String name = etName.getText().toString();
				mCallback.onFragmentOKClick(name);

			}
		});

		return v;
	}
}
