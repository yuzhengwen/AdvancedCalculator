package com.yuzhengwen.advancedcalculator;

import java.util.ArrayList;
import java.util.List;

import com.sony.smallapp.SmallAppWindow;
import com.sony.smallapp.SmallApplication;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SmallAppMain extends SmallApplication {

	private List<String> numbers = new ArrayList<String>();
	private List<String> operators = new ArrayList<String>();

	@Override
	protected void onCreate() {
		super.onCreate();
		setContentView(R.layout.main);
		setTitle(R.string.app_name);
		SmallAppWindow.Attributes attr = getWindow().getAttributes();
		attr.width = getResources().getDimensionPixelSize(R.dimen.width);
		attr.height = getResources().getDimensionPixelSize(R.dimen.height);
		attr.flags |= SmallAppWindow.Attributes.FLAG_RESIZABLE;
		attr.flags |= SmallAppWindow.Attributes.FLAG_NO_TITLEBAR;

		getWindow().setAttributes(attr);

	}

	public void numberButtonClicked(View v) {
		TextView t = (TextView) findViewById(R.id.text);
		StringBuffer s = new StringBuffer(t.getText());
		Button b = (Button) v;
		s.append(b.getText());
		t.setText(s.toString());
	}

	public void buttonClicked(View v) {
		TextView t = (TextView) findViewById(R.id.text);
		switch (v.getId()) {
		case R.id.buttonClear:
			StringBuffer sb = new StringBuffer(t.getText());
			if (sb.length() != 0) {
				sb.deleteCharAt(sb.length() - 1);
				t.setText(sb);
			}
			break;
		case R.id.buttonAdd:
			numbers.add(t.getText().toString());
			operators.add("+");
			t.setText("0");
			break;
		case R.id.buttonSubtract:
			numbers.add(t.getText().toString());
			operators.add("-");
			t.setText("0");
			break;
		case R.id.buttonMultiply:
			numbers.add(t.getText().toString());
			operators.add("*");
			t.setText("0");
			break;
		case R.id.buttonDivide:
			numbers.add(t.getText().toString());
			operators.add("/");
			t.setText("0");
			break;
		case R.id.buttonEquals:
			numbers.add(t.getText().toString());
			for (String s : numbers) {
				Log.i("MyActivitty", s);
			}
			for (String s : operators)
				Log.i("MyActivitty", s);
			double d = Double.parseDouble(numbers.get(0));
			for (int i = 0; i < numbers.size() - 1; i++) {
				switch (operators.get(i)) {
				case "+":
					d = Functions.add(d, Double.parseDouble(numbers.get(i + 1)));
					break;
				case "-":
					d = Functions.minus(d, Double.parseDouble(numbers.get(i + 1)));
					break;
				case "*":
					d = Functions.multiply(d, Double.parseDouble(numbers.get(i + 1)));
					break;
				case "/":
					d = Functions.divide(d, Double.parseDouble(numbers.get(i + 1)));
					break;
				}
			}
			t.setText(Double.toString(d));

			clearLists();
		}
	}

	private void clearLists() {
		numbers.clear();
		operators.clear();
	}
}
