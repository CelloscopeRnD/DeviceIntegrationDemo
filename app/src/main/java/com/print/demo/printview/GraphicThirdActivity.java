package com.print.demo.printview;

import java.io.IOException;
import java.io.InputStream;

import com.print.demorego.R;

import utils.ApplicationContext;
import utils.preDefiniation.AlignType;
import utils.preDefiniation.BarcodeType;
import utils.preDefiniation.ValignType;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GraphicThirdActivity extends Activity {
	public int[] fs;
	public int[] at;
	public int[] vat;
	public boolean[] bValid;
	public String[] strCell;
	public Button lab;
	public Button fire;
	public Button move;
	public Button shopping;
	public Button deskBtn;
	public ApplicationContext context;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_picapply);

		lab = (Button) findViewById(R.id.Button_pictable);
		fire = (Button) findViewById(R.id.Button_picfire);
		shopping = (Button) findViewById(R.id.Button_picshopping);
		move = (Button) findViewById(R.id.button_picmovie);
		deskBtn = (Button) findViewById(R.id.Button_desktop);
		context = (ApplicationContext) getApplicationContext();

		lab.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				context.getPrinter().CON_PageStart(context.getState(), true,
						900, 1000);
				int[] hRow = { 50, 50, 50, 50, 50, 50 };// 6ÐÐ
				int[] wColumn = { 50, 150, 100, 100, 100, 100, 100, 100 };// 8ÁÐ
				context.getPrinter().DRAW_Table(context.getState(), 0, 700, 900,
						400, 6, 8, hRow, wColumn, 4);
				bValid = new boolean[8];
				bValid[0] = true;
				bValid[1] = true;
				bValid[2] = true;
				bValid[3] = true;
				bValid[4] = true;
				bValid[5] = true;
				bValid[6] = true;
				bValid[7] = true;
				strCell = new String[8];
				strCell[0] = "ÐÍºÅ";
				strCell[1] = "¶ÔÕËµ¥ºÅ";
				strCell[2] = "ÒµÎñÀàÐÍ";
				strCell[3] = "µ¥¾Ý½ð¶î";
				strCell[4] = "ÒÑÊÕ";
				strCell[5] = "Ó¦ÊÕ";
				strCell[6] = "ÒÑÃâÊÕ";
				strCell[7] = "Ç·¿î";
				fs = new int[8];
				fs[0] = 20;
				fs[1] = 20;
				fs[2] = 20;
				fs[3] = 20;
				fs[4] = 20;
				fs[5] = 20;
				fs[6] = 20;
				fs[7] = 20;
				at = new int[8];
				at[0] = AlignType.AT_CENTER.getValue();
				at[1] = AlignType.AT_CENTER.getValue();
				at[2] = AlignType.AT_CENTER.getValue();
				at[3] = AlignType.AT_CENTER.getValue();
				at[4] = AlignType.AT_CENTER.getValue();
				at[5] = AlignType.AT_CENTER.getValue();
				at[6] = AlignType.AT_CENTER.getValue();
				at[7] = AlignType.AT_CENTER.getValue();
				vat = new int[8];
				vat[0] = ValignType.VT_MIDDLE.getValue();
				vat[1] = ValignType.VT_MIDDLE.getValue();
				vat[2] = ValignType.VT_MIDDLE.getValue();
				vat[3] = ValignType.VT_MIDDLE.getValue();
				vat[4] = ValignType.VT_MIDDLE.getValue();
				vat[5] = ValignType.VT_MIDDLE.getValue();
				vat[6] = ValignType.VT_MIDDLE.getValue();
				vat[7] = ValignType.VT_MIDDLE.getValue();
				context.getPrinter().DRAW_TableRow(context.getState(), bValid,
						strCell, fs, at, vat);// µÚ1ÐÐ
				strCell[0] = "1";
				strCell[1] = "CG002011";
				strCell[2] = "Åú·¢";
				strCell[3] = "441.00";
				strCell[4] = "0.00";
				strCell[5] = "0.00";
				strCell[6] = "441.00";
				strCell[7] = "0.00";
				context.getPrinter().DRAW_TableRow(context.getState(), bValid,
						strCell, fs, at, vat);// µÚ2ÐÐ
				strCell[0] = "2";
				context.getPrinter().DRAW_TableRow(context.getState(), bValid,
						strCell, fs, at, vat);// µÚ3ÐÐ
				strCell[0] = "3";
				context.getPrinter().DRAW_TableRow(context.getState(), bValid,
						strCell, fs, at, vat);// µÚ4ÐÐ
				bValid[0] = false;
				bValid[1] = false;
				bValid[2] = false;
				bValid[3] = false;
				bValid[4] = false;
				bValid[5] = false;
				bValid[6] = false;
				bValid[7] = true;
				at = new int[1];
				at[0] = AlignType.AT_LEFT.getValue();
				strCell = new String[1];
				strCell[0] = "                               ºÏ¼Æ                         1323.00         0.00          0.00         1323.00         0.00 ";
				context.getPrinter().DRAW_TableRow(context.getState(), bValid,
						strCell, fs, at, vat);// µÚ5ÐÐ
				at[0] = AlignType.AT_LEFT.getValue();
				strCell[0] = "±¾µ¥ÊÕ¿î£¨´óÐ´£©    Ò¼ÇªÈþ°Û·¡Ê°Èþ";
				context.getPrinter().DRAW_TableRow(context.getState(), bValid,
						strCell, fs, at, vat);// µÚ6ÐÐ
				context.getPrinter().DRAW_SetRotate(context.getState(), 90);
				context.getPrinter().CON_PageEnd(context.getState(),
						context.getPrintMode());

			}
		});
		fire.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				context.getPrinter().CON_PageStart(context.getState(), true,
						384, 300);
				context.getPrinter().DRAW_SetFillMode(false);
				context.getPrinter().DRAW_SetLineWidth(2);
				context.getPrinter().DRAW_PrintText(context.getState(), 325, 30,
						"±±¾©", 14);
				context.getPrinter().DRAW_PrintCircle(context.getState(), 373,
						33, 15);
				context.getPrinter().DRAW_PrintText(context.getState(), 364, 30,
						"ÊÛ", 14);
				context.getPrinter().DRAW_PrintText(context.getState(), 50, 60,
						"±± ¾©", 22);
				context.getPrinter().DRAW_PrintText(context.getState(), 290, 60,
						"Îä ºº", 22);
				context.getPrinter().DRAW_PrintText(context.getState(), 175, 50,
						"K250´Î", 20);
				context.getPrinter().DRAW_PrintLine(context.getState(), 180, 80,
						240, 80);
				context.getPrinter().DRAW_PrintLine(context.getState(), 230, 80,
						220, 75);
				context.getPrinter().DRAW_PrintText(context.getState(), 55, 100,
						"Beijing", 16);
				context.getPrinter().DRAW_PrintText(context.getState(), 300, 95,
						"Wuhan", 16);
				context.getPrinter().DRAW_PrintText(context.getState(), 20, 125,
						"2015Äê02ÔÂ15ÈÕ09:08¿ª", 14);
				context.getPrinter().DRAW_PrintText(context.getState(), 280,
						125, "12³µ22ºÅÏÂÆÌ", 16);
				context.getPrinter().DRAW_PrintText(context.getState(), 23, 150,
						"£¤109Ôª", 22);
				context.getPrinter().DRAW_PrintText(context.getState(), 270,
						155, "ÐÂ¿Õµ÷Ó²ÎÔ", 16);
				context.getPrinter().DRAW_PrintText(context.getState(), 20, 185,
						"½öÏÞµ±ÈÕµ±´Î³µ", 16);

				context.getPrinter().DRAW_PrintText(context.getState(), 35, 260,
						"123456789012345", 16);
				context.getPrinter().DRAW_Print1D2DBarcode(context.getState(),
						BarcodeType.BT_QRcode.getValue(), 320, 200, 80, 80,
						"»ð³µÆ±");
				context.getPrinter().CON_PageEnd(context.getState(),
						context.getPrintMode());
			}
		});
		shopping.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int size = 20;
				context.getPrinter().CON_PageStart(context.getState(), true,
						576, 600);
				context.getPrinter().DRAW_SetFillMode(false);
				context.getPrinter().DRAW_SetLineWidth(2);
				context.getPrinter().DRAW_PrintText(context.getState(), 100, 5,
						"»¶Ó­¹âÁÙ", 25);
				context.getPrinter().DRAW_PrintText(context.getState(), 110, 35,
						"µêÆÌÃû³Æ", size);

				context.getPrinter().DRAW_PrintText(context.getState(), 5, 60,
						"ÊÕÒøÔ±£ºÊÕÒøÔ±Ãû³Æ", size);
				context.getPrinter().DRAW_PrintText(context.getState(), 5, 85,
						"Ê±¼ä£º2015-01-01", size);
				context.getPrinter().DRAW_PrintLine(context.getState(), 2, 105,
						300, 105);
				context.getPrinter().DRAW_PrintText(context.getState(), 5, 125,
						"ÉÌÆ·Ãû³Æ           µ¥¼Û        ÊýÁ¿        ½ð¶î", 22);

				context.getPrinter().DRAW_PrintText(context.getState(), 5, 150,
						"»¨Éú                      2.00          1       2.00",
						size);
				context.getPrinter().DRAW_PrintLine(context.getState(), 2, 170,
						300, 170);
				context.getPrinter().DRAW_PrintText(context.getState(), 5, 190,
						"ºÏ¼Æ:£¤100Ôª", size);
				context.getPrinter().DRAW_PrintText(context.getState(), 5, 215,
						"ÓÅ»Ý½ð¶î:£¤90Ôª", size);
				context.getPrinter().DRAW_PrintLine(context.getState(), 2, 235,
						300, 235);
				context.getPrinter().DRAW_PrintText(context.getState(), 5, 255,
						"µç»°£º22222222222", size);

				context.getPrinter().DRAW_PrintText(context.getState(), 5, 280,
						"µØÖ·£º±±¾©µÃÊµ´óÏÃ", size);
				context.getPrinter().DRAW_PrintText(context.getState(), 5, 305,
						"Ð»Ð»»Ý¹Ë£¬»¶Ó­ÏÂ´Î¹âÁÙ£¡", size);

				context.getPrinter().CON_PageEnd(context.getState(),
						context.getPrintMode());
			}
		});
		move.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				context.getPrinter().CON_PageStart(context.getState(), true,
						384, 384);
				context.getPrinter().DRAW_SetFillMode(false);
				context.getPrinter().DRAW_SetLineWidth(4);
				context.getPrinter().DRAW_PrintText(context.getState(), 95, 25,
						"Èð¹¤¹ú¼ÊÓ°³Ç", 25);
				context.getPrinter().DRAW_PrintLine(context.getState(), 95, 65,
						300, 65);
				// context.getPrinter().DRAW_PrintText(context.getState(),95, 70,
				// "beijng", 20);
				context.getPrinter().DRAW_SetLineWidth(2);
				context.getPrinter().DRAW_PrintLine(context.getState(), 0, 90,
						390, 90);
				context.getPrinter().DRAW_PrintText(context.getState(), 85, 110,
						"ÇëÔÚµçÓ°¿ªÊ¼Ç°Èë³¡", 18);
				// ¾ØÐÎ
				context.getPrinter().DRAW_PrintRectangle(context.getState(), 18,
						165, 180, 235);
				context.getPrinter().DRAW_PrintRectangle(context.getState(),
						185, 165, 375, 235);
				context.getPrinter().DRAW_PrintRectangle(context.getState(), 18,
						240, 375, 300);
				context.getPrinter().DRAW_PrintRectangle(context.getState(), 18,
						305, 180, 350);
				context.getPrinter().DRAW_PrintRectangle(context.getState(),
						185, 305, 375, 350);
				context.getPrinter().DRAW_PrintRectangle(context.getState(), 18,
						360, 375, 410);
				// ÎÄ×Ö
				context.getPrinter().DRAW_PrintText(context.getState(), 25, 185,
						"Ó°Ìü", 22);
				context.getPrinter().DRAW_PrintText(context.getState(), 195,
						185, "Ê±¼ä", 22);
				context.getPrinter().DRAW_PrintText(context.getState(), 25, 255,
						"Ó°Æ¬", 22);
				context.getPrinter().DRAW_PrintText(context.getState(), 25, 315,
						"×ùÎ»", 22);
				context.getPrinter().DRAW_PrintText(context.getState(), 195,
						315, "Æ±¼Û", 22);
				// ±ä»¯ÎÄ×Ö
				context.getPrinter().DRAW_PrintText(context.getState(), 70, 180,
						"µÃÊµ´óÏÃ", 22);
				context.getPrinter().DRAW_PrintText(context.getState(), 240,
						180, "2015Äê2ÔÂ1ºÅ12:00", 22);
				context.getPrinter().DRAW_PrintText(context.getState(), 75, 250,
						"ÐÄ»¨Å­·Å", 22);
				context.getPrinter().DRAW_PrintText(context.getState(), 70, 315,
						"01ÅÅ01ºÅ", 22);
				context.getPrinter().DRAW_PrintText(context.getState(), 235,
						315, "80Ôª", 22);
				context.getPrinter().DRAW_Print1D2DBarcode(context.getState(),
						BarcodeType.BT_UPCA.getValue(), 70, 365, 240, 30,
						"123456789012");

				context.getPrinter().CON_PageEnd(context.getState(),
						context.getPrintMode());
			}
		});

		deskBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				InputStream input = getClass().getResourceAsStream(
						"/assets/brother.prn");
				try {
					int i = input.available();
					byte[] buffer = new byte[i];
					input.read(buffer, 0, i);

					context.getPrinter().CON_PageStart(context.getState(),
							false, 0, 0);
					context.getPrinter().ASCII_PrintBuffer(context.getState(),
							buffer, i);
					context.getPrinter().CON_PageEnd(context.getState(),
							context.getPrintMode());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}