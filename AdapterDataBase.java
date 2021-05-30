package solution;

public class AdapterDataBase extends JavaApplication implements DataBase{


    @Override
    public void insert() {
        insertObject();

    }

    @Override
    public void update() {
        updateObject();
    }

    @Override
    public void delete() {
        deleteObject();

    }
}
