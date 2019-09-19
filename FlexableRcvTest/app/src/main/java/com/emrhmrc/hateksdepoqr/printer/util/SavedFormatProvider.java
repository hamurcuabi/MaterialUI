/***********************************************
 * CONFIDENTIAL AND PROPRIETARY 
 * 
 * The source code and other information contained herein is the confidential and the exclusive property of
 * ZIH Corp. and is subject to the terms and conditions in your end user license agreement.
 * This source code, and any other information contained herein, shall not be copied, reproduced, published, 
 * displayed or distributed, in whole or in part, in any medium, by any means, for any purpose except as
 * expressly permitted under such license agreement.
 * 
 * Copyright ZIH Corp. 2012
 * 
 * ALL RIGHTS RESERVED
 ***********************************************/
package com.emrhmrc.hateksdepoqr.printer.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class SavedFormatProvider {

	public static final String DATE_FORMAT = "d MMM yyyy HH:mm:ss";

	private static final String DATABASE_NAME = "saved_formats.db";
	private static final int DATABASE_VERSION = 1;
	
	private DatabaseHelper mOpenHelper;

	class DatabaseHelper extends SQLiteOpenHelper {

		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE " + SavedFormat.TABLE_NAME + " ("
					+ SavedFormat._ID + " INTEGER PRIMARY KEY,"
					+ SavedFormat.FORMAT_DRIVE + " TEXT,"
					+ SavedFormat.FORMAT_NAME + " TEXT,"
					+ SavedFormat.FORMAT_EXTENSION + " TEXT,"
					+ SavedFormat.SOURCE_PRINTER_NAME + " TEXT,"
					+ SavedFormat.FORMAT_TEXT + " TEXT,"
					+ SavedFormat.TIMESTAMP + " INTEGER"
					+ ");");
			

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + SavedFormat.TABLE_NAME);
			onCreate(db);
		}
	}
	
	public SavedFormatProvider (Context context) {
		mOpenHelper = new DatabaseHelper(context);
	}

	public Collection<SavedFormat> getSavedFormats() {

		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		qb.setTables(SavedFormat.TABLE_NAME);

		SQLiteDatabase db = mOpenHelper.getReadableDatabase();

		Cursor c = qb.query(
				db,
				null,
				null,
				null,
				null,
				null,
				SavedFormat.TIMESTAMP
				);

		ArrayList<SavedFormat> savedFormats = new ArrayList<SavedFormat>();
		for(int i = 0; i < c.getCount(); i++) {
			c.moveToNext();
			
			Long id = 0L;
			String formatDrive = "";
			String formatName = "";
			String formatExtension = "";
			String sourcePrinterName = "";
			Long timestamp = 0L;
			String formatText = "";
			
			for (int j = 0; j < c.getColumnCount(); j++ ) {
				String currentColumnName = c.getColumnName(j);
				if (currentColumnName.equals(SavedFormat._ID)) {
					id = c.getLong(j);
				} else if (currentColumnName.equals(SavedFormat.FORMAT_DRIVE)) {
					formatDrive = c.getString(j);
				} else if (currentColumnName.equals(SavedFormat.FORMAT_NAME)) {
					formatName = c.getString(j);
				} else if (currentColumnName.equals(SavedFormat.FORMAT_EXTENSION)) {
					formatExtension = c.getString(j);
				} else if (currentColumnName.equals(SavedFormat.SOURCE_PRINTER_NAME)) {
					sourcePrinterName = c.getString(j);
				} else if (currentColumnName.equals(SavedFormat.TIMESTAMP)) {
					timestamp = c.getLong(j);
				} else if (currentColumnName.equals(SavedFormat.FORMAT_TEXT)) {
					formatText = c.getString(j);
				}
			}
			savedFormats.add(new SavedFormat(id, formatDrive, formatName, formatExtension, sourcePrinterName, timestamp, formatText));
		}
		
		db.close();
		
		return savedFormats;
	}


	public long insert(String formatDrive, String formatName, String formatExtension, String sourcePrinterName, String formatText) {

		ContentValues values = new ContentValues();

		Long now = Long.valueOf(System.currentTimeMillis());

		values.put(SavedFormat.TIMESTAMP, now);
		values.put(SavedFormat.FORMAT_DRIVE, formatDrive);
		values.put(SavedFormat.FORMAT_NAME, formatName);
		values.put(SavedFormat.FORMAT_EXTENSION, formatExtension);
		values.put(SavedFormat.SOURCE_PRINTER_NAME, sourcePrinterName);
		values.put(SavedFormat.FORMAT_TEXT, formatText);
		
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();

		long rowId = db.insert(
				SavedFormat.TABLE_NAME,
				null,
				values);
		
		db.close();

		return rowId;
	}

	public boolean delete(String id) {
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
		int rowsDeleted = db.delete(SavedFormat.TABLE_NAME, SavedFormat._ID + "=?", new String [] {id} );
		db.close();
		return rowsDeleted > 0;
	}
	
	public int getNumberOfStoredFormats() {
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		qb.setTables(SavedFormat.TABLE_NAME);

		SQLiteDatabase db = mOpenHelper.getReadableDatabase();

		Cursor c = qb.query(
				db,
				null,
				null,
				null,
				null,
				null,
				SavedFormat.TIMESTAMP
				);
		int retVal = c.getCount();
		db.close();
		return retVal;
	}
	
	public String getTimestampOfFormat(long id) {
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		qb.setTables(SavedFormat.TABLE_NAME);

		SQLiteDatabase db = mOpenHelper.getReadableDatabase();

		Cursor c = qb.query(
				db,
				null,
				SavedFormat._ID + "=?",
				new String[] {Long.toString(id)},
				null,
				null,
				SavedFormat.TIMESTAMP
				);
		
		try {
			if (c.getCount() <= 0) {
				return "";
			} else {
				c.moveToFirst();
				SimpleDateFormat timeFormat = new SimpleDateFormat(DATE_FORMAT);
				Date date = new Date(c.getLong(c.getColumnIndex(SavedFormat.TIMESTAMP)));
				return timeFormat.format(date);
			}
		} finally {
			db.close();
		}
	}
	
	public String getFormatContents(long id) {
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		qb.setTables(SavedFormat.TABLE_NAME);

		SQLiteDatabase db = mOpenHelper.getReadableDatabase();

		Cursor c = qb.query(
				db,
				null,
				SavedFormat._ID + "=?",
				new String[] {Long.toString(id)},
				null,
				null,
				SavedFormat.TIMESTAMP
				);
		
		try {
			if (c.getCount() <= 0) {
				return "";
			} else {
				c.moveToFirst();
				return c.getString(c.getColumnIndex(SavedFormat.FORMAT_TEXT));
			}
		} finally {
			db.close();
		}
	}


}
