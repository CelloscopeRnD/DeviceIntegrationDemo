package com.print.demo.printview;

import com.print.demorego.R;
import utils.ApplicationContext;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TextFirstActivity extends Activity {
	public AutoCompleteTextView text;
	public Button PrintText;
	public Button PrinterState;

	// ÎÄ×ÖÉèÖÃ
	public CheckBox dwight;
	public CheckBox dhight;
	public CheckBox dthick;
	public CheckBox underline;
	public CheckBox small;
	public CheckBox OppositeColor;
	// ±êÇ©ÉèÖÃ
	public CheckBox label;
	public EditText wight;
	public EditText hight;
	public EditText X0;
	public EditText Y0;
	// ¶ÔÆë·½Ê½
	public RadioGroup align;
	public RadioButton left;
	public RadioButton center;
	public RadioButton right;
	public int state = 1;
	public ApplicationContext context;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_general);
		// ±êÇ©ÉèÖÃ
		wight = (EditText) findViewById(R.id.editText01);
		wight.setText("60");
		hight = (EditText) findViewById(R.id.editText02);
		hight.setText("40");
		// ÎÄ×ÖÉèÖÃ
		dwight = (CheckBox) findViewById(R.id.checkBox01);
		dhight = (CheckBox) findViewById(R.id.checkBox02);
		dthick = (CheckBox) findViewById(R.id.checkBox03);
		underline = (CheckBox) findViewById(R.id.checkBox04);
		small = (CheckBox) findViewById(R.id.checkBox05);
		OppositeColor = (CheckBox) findViewById(R.id.checkBox07);

		// ¶ÔÆë·½Ê½
		align = (RadioGroup) findViewById(R.id.radioGroup1);
		left = (RadioButton) findViewById(R.id.radio0);
		center = (RadioButton) findViewById(R.id.radio1);
		right = (RadioButton) findViewById(R.id.radio2);

		text = (AutoCompleteTextView) findViewById(R.id.autoCompleteText_text);
		PrintText = (Button) findViewById(R.id.button_printtext);
		PrinterState = (Button) findViewById(R.id.Button_state);
		label = (CheckBox) findViewById(R.id.checkBox06);
		context = (ApplicationContext) getApplicationContext();

		PrinterState.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				state = context.getPrinter().CON_QueryStatus(context.getState());
				if (state == 0) {
					Toast.makeText(TextFirstActivity.this,
							R.string.mes_stateOK, Toast.LENGTH_SHORT).show();
				} else if (state == 3) {
					Toast.makeText(TextFirstActivity.this,
							R.string.mes_statePE, Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(TextFirstActivity.this,
							R.string.mes_stateNet, Toast.LENGTH_SHORT).show();
				}

			}
		});
		PrintText.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				context.getPrinter().CON_PageStart(context.getState(), false,
						Integer.parseInt(wight.getText().toString()),
						Integer.parseInt(hight.getText().toString()));

				if (label.isChecked()) {
					context.getPrinter().CON_SetDensity(context.getState(), 8);
					context.getPrinter().CON_SetSpeed(context.getState(), 6);
					context.getPrinter().CON_SetPrintDirection(
							context.getState(), 0);
					context.getPrinter().ASCII_PrintString(context.getState(),
							10, 10, 2, 2, text.getText().toString(), "gb2312");
					context.getPrinter().ASCII_Print1DBarcode(
							context.getState(), 0, 10, 50, 2, 50, "code print");
				}
				else {
					int alignType = 0;
					// ¶ÔÆë·½Ê½
					if (center.isChecked()) {
						alignType = 1;
					}
					if (right.isChecked()) {
						alignType = 2;
					}

					context.getPrinter().ASCII_CtrlOppositeColor(
							context.getState(), OppositeColor.isChecked());
					context.getPrinter().ASCII_CtrlAlignType(context.getState(),
							alignType);
					context.getPrinter().ASCII_PrintString(context.getState(),
							dwight.isChecked()?1:0,
							dhight.isChecked()?1:0,
							dthick.isChecked()?1:0,
							underline.isChecked()?1:0,
							small.isChecked()?1:0,
							text.getText().toString(), "gb2312");
					context.getPrinter().ASCII_CtrlFeedLines(context.getState(), 1);
					context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(), 1);
				}
				context.getPrinter().CON_PageEnd(context.getState(),
						context.getPrintMode());
			}
		});
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		SharedPreferences prefs = getPreferences(0);
		String restoredText = prefs.getString("text", null);
		if (restoredText != null) {
			text.setText(restoredText, TextView.BufferType.EDITABLE);
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		SharedPreferences.Editor editor = getPreferences(0).edit();
		editor.putString("text", text.getText().toString());
		editor.commit();
	}
}