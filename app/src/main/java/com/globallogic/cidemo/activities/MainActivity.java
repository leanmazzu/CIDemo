package com.globallogic.cidemo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.globallogic.cidemo.CalcUtil;
import com.globallogic.cidemo.R;

/**
 * 
 * @author leandro.mazzuquini
 * 
 */
public class MainActivity extends Activity {

	private Button addButton;
	private Button multButton;
	private TextView result;
	private TextView operator;
	private EditText value1;
	private EditText value2;

	private int value1int = -1;
	private int value2int = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		addButton = (Button) findViewById(R.id.button_add);
		multButton = (Button) findViewById(R.id.button_mult);
		result = (TextView) findViewById(R.id.result);
		operator = (TextView) findViewById(R.id.operator);
		value1 = (EditText) findViewById(R.id.value1);
		value2 = (EditText) findViewById(R.id.value2);

		addButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (dataComplete()) {
					operator.setText("+");
					result.setText(String.valueOf(CalcUtil.get().add(value1int,
							value2int)));
				} else {
					Toast.makeText(MainActivity.this,
							"Debes ingresar ambos operandos",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
		multButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (dataComplete()) {
					operator.setText("x");
					result.setText(String.valueOf(CalcUtil.get().mult(value1int,
							value2int)));
				} else {
					Toast.makeText(MainActivity.this,
							"Debes ingresar ambos operandos",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	private boolean dataComplete() {
		if (value1.getText().toString() != null
				&& value1.getText().toString().replace(" ", "").length() > 0) {
			value1int = Integer.parseInt(value1.getText().toString());
		} else {
			value1int = -1;
		}

		if (value2.getText().toString() != null
				&& value2.getText().toString().replace(" ", "").length() > 0) {
			value2int = Integer.parseInt(value2.getText().toString());
		} else {
			value2int = -1;
		}

		return value1int >= 0 && value2int >= 0;
	}
}
