package dao;

/**
 * Created by Daivid on 21/08/2016.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by Daivid on 15/08/2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String MODELO_VEICULO = "modelo_veiculo";
    private static final String ANO = "ano";
    private static final String PLACA = "placa";
    private static final String COR = "cor";
    private static final String SENHA = "senha";
    private static final String ID = "_id";
    private static final String FK_VEICULO = "veiculo_id";
    private static final String FK_LOCAL = "local_id";

    private static final String TAG = "DBAdapter";
    private static final String DATABASE_NAME = "generaldb";

    private static int DATABASE_VERSION = 1;

    private static final String TABELA_VEICULO_NOME = "veiculo";
    private static final String TABELA_LOCAL_NOME = "local";
    private static final String TABELA_VEICULO_LOCAL_NOME = "veiculo_local";

    private static final String TABELA_VEICULO =
            "create table veiculo(" +
                    "_id text primary key, " +
                    "modelo_veiculo text not null, " +
                    "ano integer not null, " +
                    "placa text not null," +
                    "cor text not null," +
                    "senha text not null);";

    private static final String TABELA_VEICULO_LOCAL =
            "create table veiculo_local("+
                    "veiculo_local_id integer primary key autoincrement, " +
                    "veiculo_id integer not null, " +
                    "local_id integer not null," +
                    "foreign key(veiculo_id) references veiculo(_id), " +
                    "foreign key(local_id) references local(_id)); ";

    private static final String TABELA_LOCAL =
            "create table local(" +
                    "_id integer primary key autoincrement, " +
                    "latitude real, " +
                    "longitude real);";

    public static String getFkVeiculo() {
        return FK_VEICULO;
    }

    public static String getFkLocal() {
        return FK_LOCAL;
    }

    public static String getTabelaVeiculoNome() {
        return TABELA_VEICULO_NOME;
    }

    public static String getTabelaLocalNome() {
        return TABELA_LOCAL_NOME;
    }

    public static String getTabelaVeiculoLocalNome() {
        return TABELA_VEICULO_LOCAL_NOME;
    }

    public static String getID() {
        return ID;
    }

    public static String getLONGITUDE() {
        return LONGITUDE;
    }

    public static String getLATITUDE() {
        return LATITUDE;
    }

    public static String getModeloVeiculo() {
        return MODELO_VEICULO;
    }

    public static String getANO() {
        return ANO;
    }

    public static String getPLACA() {
        return PLACA;
    }

    public static String getCOR() {
        return COR;
    }

    public static String getSENHA() {
        return SENHA;
    }

    public static String getTAG() {
        return TAG;
    }

    public static String getTabelaVeiculo() {
        return TABELA_VEICULO;
    }

    public static String getTabelaVeiculoLocal() {
        return TABELA_VEICULO_LOCAL;
    }

    public static String getTabelaLocal() {
        return TABELA_LOCAL;
    }

    public static String getTag() {
        return TAG;
    }

    public static String getDataBaseName() {
        return DATABASE_NAME;
    }

    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }

    public static void setDatabaseVersion(int newVers) {
        DATABASE_VERSION = newVers;
    }

    /**
     * construtor para realizar conexão com a DB
     *
     * @param context
     */
    public DataBaseHelper(Context context) {
        super(context, getDataBaseName(), null, getDatabaseVersion());
    }

    /**
     * "levanta" o banco quando abrimos o aplicativo
     *
     * @param dataBase
     */
    public void onCreate(SQLiteDatabase dataBase) {
        dataBase.execSQL(getTabelaVeiculo());
        dataBase.execSQL(getTabelaLocal());
        dataBase.execSQL(getTabelaVeiculoLocal());
    }

    /**
     * Atualiza o banco
     *
     * @param dataBase
     * @param newVersion
     * @param oldVersion
     */
    public void onUpgrade(SQLiteDatabase dataBase, int newVersion, int oldVersion) {
        Log.w(getTag(), "Upgrading database from version " + oldVersion
                + " to "
                + newVersion + ", which will destroy all old data");
        dataBase.execSQL("DROP TABLE IF EXISTS veiculo");
        dataBase.execSQL("DROP TABLE IF EXISTS veiculo_local");
        dataBase.execSQL("DROP TABLE IF EXISTS local");
        onCreate(dataBase);/// query para recriar o banco
        setDatabaseVersion(newVersion);
    }

}