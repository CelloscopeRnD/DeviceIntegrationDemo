package com.print.demo.printview;

import com.print.demorego.R;
import utils.ApplicationContext;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class GraphicFirstActivity extends Activity {
	public AutoCompleteTextView languageText;
	public Button printLan;
	// ±êÇ©ÉèÖÃ
	public CheckBox label;
	public EditText wight;
	public EditText hight;
	public EditText X0;
	public EditText Y0;
	public ApplicationContext context;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_language);
		// ±êÇ©ÉèÖÃ
		label = (CheckBox) findViewById(R.id.checkBox_lanlab);
		wight = (EditText) findViewById(R.id.editText_lanwide);
		hight = (EditText) findViewById(R.id.editText_lanhight);

		printLan = (Button) findViewById(R.id.button_printlan);
		context = (ApplicationContext) getApplicationContext();
		languageText = (AutoCompleteTextView) findViewById(R.id.autoCompleteText_lan);
		printLan.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				context.getPrinter().CON_PageStart(context.getState(), true,
						Integer.parseInt(wight.getText().toString()),
						Integer.parseInt(hight.getText().toString()));
				context.getPrinter().DRAW_SetFillMode(false);
				// ¶Ô¶àÓïÑÔÊý¾Ý½øÐÐ´¦ÀíÒ»ÐÐÒ»ÐÐ´¦Àí
				int y = 20;
				String str[] = languageText.getText().toString().split("\n");
				for (int i = 0; i < str.length; i++) {
					y += 25;
					context.getPrinter().DRAW_PrintText(context.getState(), 20,
							y, str[i], 24);
				}
				context.getPrinter().CON_PageEnd(context.getState(),
						context.getPrintMode());
			}
		});
	}
}