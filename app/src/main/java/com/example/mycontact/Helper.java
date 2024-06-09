package com.example.mycontact;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "contact.db";
    private static final int DATABASE_VERSION = 1;

    // Table donvi
    private static final String TABLE_DONVI = "donvi";
    private static final String COLUMN_ID_DONVI = "id_donvi";
    private static final String COLUMN_TEN_DONVI = "ten_donvi";
    private static final String COLUMN_MA_DONVI = "ma_donvi";
    private static final String COLUMN_DIACHI = "diachi";
    private static final String COLUMN_SODIENTHOAI = "sodienthoai";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_WEBSITE = "website";
    private static final String COLUMN_ID_DONVI_CHA = "id_donvi_cha";

    // Table nhanvien
    private static final String TABLE_NHANVIEN = "nhanvien";
    private static final String COLUMN_ID_NHANVIEN = "id_nhanvien";
    private static final String COLUMN_HO_TEN = "ho_ten";
    private static final String COLUMN_MA_NHANVIEN = "ma_nhanvien";
    private static final String COLUMN_CHUCVU = "chucvu";
    private static final String COLUMN_SODIENTHOAI_NHANVIEN = "sodienthoai";
    private static final String COLUMN_EMAIL_CANHAN = "email_canhan";
    private static final String COLUMN_ANH_DAIDIEN = "anh_daidien";

    public Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Helper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createDonviTable = "CREATE TABLE " + TABLE_DONVI + " (" +
                COLUMN_ID_DONVI + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TEN_DONVI + " TEXT NOT NULL, " +
                COLUMN_MA_DONVI + " TEXT NOT NULL, " +
                COLUMN_DIACHI + " TEXT, " +
                COLUMN_SODIENTHOAI + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_WEBSITE + " TEXT, " +
                COLUMN_ID_DONVI_CHA + " INTEGER REFERENCES " + TABLE_DONVI + "(" + COLUMN_ID_DONVI + "), " +
                "FOREIGN KEY (" + COLUMN_ID_DONVI_CHA + ") REFERENCES " + TABLE_DONVI + "(" + COLUMN_ID_DONVI + ")" + ")";

        String createNhanVienTable = "CREATE TABLE " + TABLE_NHANVIEN + " (" +
                COLUMN_ID_NHANVIEN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_HO_TEN + " TEXT NOT NULL, " +
                COLUMN_MA_NHANVIEN + " TEXT NOT NULL, " +
                COLUMN_CHUCVU + " TEXT, " +
                COLUMN_ID_DONVI + " INTEGER NOT NULL REFERENCES " + TABLE_DONVI + "(" + COLUMN_ID_DONVI + "), " +
                COLUMN_SODIENTHOAI_NHANVIEN + " TEXT, " +
                COLUMN_EMAIL_CANHAN + " TEXT, " +
                COLUMN_ANH_DAIDIEN + " BLOB " + ")";

        db.execSQL(createDonviTable);
        db.execSQL(createNhanVienTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database schema changes if needed (future versions)
    }
}
