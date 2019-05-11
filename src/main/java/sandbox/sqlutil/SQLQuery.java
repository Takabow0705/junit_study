package sandbox.sqlutil;

public final class SQLQuery{
    private String query;

    private SQLQuery(){

    }

    private SQLQuery(String query){
        this.query = query;
    }

    public static class Builder{
        private String query;

        private Builder(){
            this.query = "";
        }

        public static Builder create(){
            return new Builder();
        }
        public Builder setCRUD(SqlCRUD crud){
            this.query += crud.get();
            return this;
        }

        public Builder setColums(String... colums){

            this.query += colums[0];

            if(colums.length == 1){
                return this;
            }

            for(int i = 1; i < colums.length; i++){
                this.query += " , " + colums[i];
            }
            return this;
        }

        public Builder FROM(String table){
            this.query += " FROM " + table;
            return this;
        }
        public Builder setWHERE(String condition){
            this.query += " WHERE " + condition;
            return this;
        }

        public Builder setAND(String condition){
            this.query += " AND " + condition;
            return this;
        }

        public SQLQuery build(){
            this.query += ";";
            return new SQLQuery(this.query);
        }
    }

    public String getQuery(){
        return query;
    }
}