package sandbox.sqlutil;

public enum SqlCRUD{
    SELECT("SELECT "),
    UPDATE("UPDATE "),
    INSERT("INSERT "),
    DELETE("DELETE ");

    private final String sqlQurey;

    SqlCRUD(String query){
        this.sqlQurey = query;
    }

    public String get(){
        return sqlQurey;
    }
}