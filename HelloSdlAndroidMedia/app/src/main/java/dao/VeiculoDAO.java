package dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import dominio.Veiculo;

/**
 * Created by Daivid on 21/08/2016.
 */
public class VeiculoDAO extends DAO {

    private static final VeiculoDAO instance = new VeiculoDAO();

    private VeiculoDAO() {
    }

    /**
     * Método Singleton para receber uma única instancia da classe
     * @return instance
     */
    public static VeiculoDAO getInstance() {
        return instance;
    }

    public void adicionar(Veiculo veiculo){
        open();
        ContentValues cv = new ContentValues();
        cv.put(getDataBaseHelper().getModeloVeiculo(), veiculo.getModelo());
        cv.put(getDataBaseHelper().getANO(), veiculo.getAno());
        cv.put(getDataBaseHelper().getPLACA(), veiculo.getPlaca());
        cv.put(getDataBaseHelper().getCOR(), veiculo.getCor());
        cv.put(getDataBaseHelper().getSENHA(), veiculo.getSenha());
        cv.put(getDataBaseHelper().getID(), veiculo.getId());
        getDatabase().insert(getDataBaseHelper().getTabelaVeiculoNome(), null, cv);
        close();

        if(veiculo.getLatitude() != 0.0 && veiculo.getLongitude() != 0.0){
            int id_local = this.adicionarLocal(veiculo);
            this.adicionarVeiculoLocal(veiculo, id_local);
        }

    }

    private int adicionarLocal(Veiculo veiculo){

        int id = 0;

        open();
        ContentValues cv = new ContentValues();
        cv.put(getDataBaseHelper().getLATITUDE(), veiculo.getLatitude());
        cv.put(getDataBaseHelper().getLONGITUDE(), veiculo.getLongitude());
        getDatabase().insert(getDataBaseHelper().getTabelaLocalNome(), null, cv);

        Cursor mCursor = getDatabase().rawQuery("select max(_id) from local", null);
        mCursor.moveToFirst();
        id = mCursor.getInt(0);

        close();

        return id;
    }

    public void adicionarVeiculoLocal(Veiculo veiculo, int id_local){
        open();
        ContentValues cv = new ContentValues();
        cv.put(getDataBaseHelper().getFkVeiculo(), veiculo.getId());
        cv.put(getDataBaseHelper().getFkLocal(), id_local);
        getDatabase().insert(getDataBaseHelper().getTabelaVeiculoLocalNome(), null, cv);
        close();
    }

    public Veiculo buscarVeiculo(String id){
        Veiculo veiculo = new Veiculo();
        open();
        Cursor mCursor = getDatabase().rawQuery("SELECT * FROM " + getDataBaseHelper().getTabelaVeiculoNome() + " WHERE _id=?", new String[]{id});
        int count = mCursor.getCount();
        mCursor.moveToFirst();
        if (mCursor != null) {
            if (count > 0){
                veiculo.setId(mCursor.getString(0));
                veiculo.setModelo(mCursor.getString(1));
                veiculo.setAno(mCursor.getInt(2));
                veiculo.setPlaca(mCursor.getString(3));
                veiculo.setCor(mCursor.getString(4));
                veiculo.setSenha(mCursor.getString(5));
            }
        }
        close();

        return this.buscarUltimoLocal(veiculo);
    }

    public Veiculo buscarUltimoLocal(Veiculo veiculo){
        open();
        Cursor mC = getDatabase().rawQuery("select max(local_id) from veiculo_local where veiculo_id = ?", new String[]{veiculo.getId()});
        mC.moveToFirst();
        int id = mC.getInt(0);
        open();

        return this.buscarLocal(veiculo, id);
    }

    public Veiculo buscarLocal(Veiculo veiculo, int id_local){
        open();
        Cursor mC = getDatabase().rawQuery("select * from local where _id = ?", new String[]{Integer.toString(id_local)});
        mC.moveToFirst();

        veiculo.setLatitude(mC.getDouble(1));
        veiculo.setLongitude(mC.getDouble(2));

        return veiculo;
    }

}
