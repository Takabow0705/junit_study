package sandbox;

import org.junit.*;
import org.junit.rules.ExpectedException;

import sandbox.sqlutil.SQLQuery;
import sandbox.sqlutil.SqlCRUD;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SQLQueryTest{

    @Test
    public void whenChooseOneColumnReturnsProperQuery(){
        SQLQuery query = SQLQuery.Builder
                                .create()
                                .setCRUD(SqlCRUD.SELECT)
                                .setColums("hoge")
                                .FROM("hogeTable")
                                .build();
        
        assertThat(query.getQuery(),equalTo("SELECT hoge FROM hogeTable;"));
    }

    @Test
    public void whenChooseTwoColumnsReturnsProperQuery(){
        SQLQuery query = SQLQuery.Builder
                                .create()
                                .setCRUD(SqlCRUD.SELECT)
                                .setColums("hoge","huga")
                                .FROM("hogeTable")
                                .build();
        
        assertThat(query.getQuery(),equalTo("SELECT hoge , huga FROM hogeTable;"));       
    }

    @Test
    public void whenChooseTwoColumnsAndOneConditionReturnsProperQuery(){
        SQLQuery query = SQLQuery.Builder
                                .create()
                                .setCRUD(SqlCRUD.SELECT)
                                .setColums("hoge","huga")
                                .FROM("hogeTable")
                                .setWHERE("hoge = 1")
                                .build();
        
        assertThat(query.getQuery(),equalTo("SELECT hoge , huga FROM hogeTable WHERE hoge = 1;"));       
    }

    @Test
    public void whenChooseTwoColumnsAndTwoConditionsReturnsProperQuery(){
        SQLQuery query = SQLQuery.Builder
                                .create()
                                .setCRUD(SqlCRUD.SELECT)
                                .setColums("hoge","huga")
                                .FROM("hogeTable")
                                .setWHERE("hoge = 1")
                                .setAND("huga = 2")
                                .build();
        
        assertThat(query.getQuery(),equalTo("SELECT hoge , huga FROM hogeTable WHERE hoge = 1 AND huga = 2;"));       
    }
}