package com.print.demo.printview;

import com.print.demorego.R;
import utils.ApplicationContext;
import utils.preDefiniation.AlignType;
import utils.preDefiniation.BarcodeType;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TextThirdActivity extends Activity {
	public Button fire;
	public Button move;
	public Button shopping;
	public ApplicationContext context;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_textapply);
		fire = (Button) findViewById(R.id.Button_fire);
		move = (Button) findViewById(R.id.button_movie);
		shopping = (Button) findViewById(R.id.Button_shopping);
		context = (ApplicationContext) getApplicationContext();
		move.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				context.getPrinter().CON_PageStart(context.getState(),false,0,0);
				context.getPrinter().ASCII_CtrlAlignType(context.getState(),
						AlignType.AT_CENTER.getValue());
				context.getPrinter().ASCII_PrintString(context.getState(),
						1, 1, 1, 0, 0, "Èð¹¤¹ú¼ÊÓ°³Ç", "gb2312");
				context.getPrinter().ASCII_CtrlFeedLines(context.getState(),1);
				context.getPrinter().ASCII_CtrlReset(context.getState());
				context.getPrinter().ASCII_CtrlPrintPosition(context.getState(),24,450);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 1, 0, 0, "Ó°Ìü  ", "gb2312");
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 1, 0, 0, "µÃÊµ´óÏÃ    ", "gb2312");
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 1, 0, 0, "Ê±¼ä  ", "gb2312");
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 1, 0, 0, "2015Äê1ÔÂ16ºÅ", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "      1ºÅ´óÌü          ",
						"gb2312");
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "12:18¿ª³¡", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 1, 0, 0, "Ó°Æ¬  ", "gb2312");
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 1, 0, 0, "ÇåÊ±Ã÷ÔÂ      ", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "      Ö÷ÑÝ£ºÌìÃ÷£¬Ð¡ÔÂ", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 1, 0, 0, "×ùÎ»  ", "gb2312");
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 1, 0, 0, "Ò»ÅÅ01ºÅ      ", "gb2312");
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 1, 0, 0, "Æ±¼Û  50Ôª", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_CtrlReset(context.getState());
				context.getPrinter().ASCII_CtrlPrintPosition(context.getState(),24,450);
				context.getPrinter().ASCII_Print1DBarcode(context.getState(),
						BarcodeType.BT_UPCA.getValue(), 2, 28,
						utils.preDefiniation.Barcode1DHRI.BH_BLEW.getValue(), "123456789012");
				context.getPrinter().ASCII_CtrlFeedLines(context.getState(),1);
				context.getPrinter().ASCII_CtrlReset(context.getState());
				context.getPrinter().CON_PageEnd(context.getState(),context.getPrintMode());
			}
		});
		shopping.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				context.getPrinter().CON_PageStart(context.getState(),false,0,0);
				context.getPrinter().ASCII_CtrlAlignType(context.getState(),
						AlignType.AT_CENTER.getValue());
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						1,0, 0, 0, "»¶Ó­¹âÁÙ  ", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "µêÆÌÃû³Æ  ", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_CtrlAlignType(context.getState(),
						AlignType.AT_LEFT.getValue());
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "ÊÕÒøÔ±£ºÊÕÒøÔ±Ãû³Æ", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "Ê±¼ä£º2015-01-01", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "----------------------------",
						"gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 1, 0, 0, "ÉÌÆ·Ãû³Æ        µ¥¼Û      ÊýÁ¿      ½ð¶î",
						"gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0,
						0,"»¨Éú           2.00      1      2.00", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "----------------------------",
						"gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "ºÏ¼Æ:£¤100Ôª", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "ÓÅ»Ý½ð¶î:£¤90Ôª", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "µç»°£º01062985019", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "µØÖ·£º±±¾©µÃÊµ´óÏÃ", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "Ð»Ð»»Ý¹Ë£¬»¶Ó­ÏÂ´Î¹âÁÙ£¡", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_CtrlReset(context.getState());
				context.getPrinter().CON_PageEnd(context.getState(),context.getPrintMode());

			}
		});
		fire.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				context.getPrinter().CON_PageStart(context.getState(),false,0,0);
				context.getPrinter().ASCII_CtrlAlignType(context.getState(),
						AlignType.AT_RIGHT.getValue());
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "±±¾© ÊÛ", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_CtrlAlignType(context.getState(),
						AlignType.AT_CENTER.getValue());
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 1, 0, 0, "±± ¾©  ¡ª¡ª¡ª¡ª> Îä ºº", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "Beijing         Wuhan",
						"gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "2015Äê02ÔÂ16ÈÕ01:01¿ª   12³µ12ºÅÏÂÆÌ",
						"gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "£¤180.00Ôª             ÐÂ¿Õµ÷Ó²ÎÔ",
						"gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_CtrlReset(context.getState());
				context.getPrinter().ASCII_PrintString(context.getState(),0,
						0, 0, 0, 0, "½öÏÞµ±ÈÕµ±´Î³µ", "gb2312");
				context.getPrinter().ASCII_CtrlPrintCRLF(context.getState(),1);
				context.getPrinter().ASCII_Print2DBarcode(context.getState(),BarcodeType.BT_QRcode.getValue(),"123456789",8,76,2);
				context.getPrinter().ASCII_CtrlReset(context.getState());
				context.getPrinter().CON_PageEnd(context.getState(),context.getPrintMode());
			}
		});
	}
}