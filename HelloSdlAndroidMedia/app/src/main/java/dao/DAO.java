package dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import dao.DataBaseHelper;
import dominio.Veiculo;

/**
 * Created by Daivid on 21/08/2016.
 */
public abstract class DAO {

    private static DataBaseHelper dataBaseHelper;
    private static SQLiteDatabase database;
    private Context context = null;

    public void setContextUp(Context context) {
        setAtributes(context);
    }

    protected void setAtributes(Context ctx) {
        setContext(ctx);
        setDBHelper(new DataBaseHelper(ctx));

    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public static DataBaseHelper getDataBaseHelper() {
        return dataBaseHelper;
    }

    public void setDBHelper(DataBaseHelper DBHelper) {
        this.dataBaseHelper = DBHelper;
    }

    public static SQLiteDatabase getDatabase() {
        return database;
    }

    public void setDatabase(SQLiteDatabase database) {
        this.database = database;
    }

    /**
     * Abrir database com "poder" de escritura.
     *
     * @throws android.database.SQLException
     */
    public void open() throws SQLException {
        setDatabase(getDataBaseHelper().getWritableDatabase());
    }

    /**
     * Fechar database
     */
    public void close() {
        getDataBaseHelper().close();
    }

}