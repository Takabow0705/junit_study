package dao;

import dbaccess.dao.BondDao;
import dbaccess.dao.model.Bond;
import org.dbunit.dataset.DataSetException;
import org.junit.*;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.csv.CsvDataSet;
import org.dbunit.operation.DatabaseOperation;
import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;
import java.io.File;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;

public class BondDaoTest{
    private Logger logger = Logger.getLogger(BondDaoTest.class.getName());
    /** DBUnitのテスター */
    private static IDatabaseTester databaseTester;
    /** テスト対象のDAO */
    private BondDao bondDao;

    /**
     * データベースのセットアップ
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        logger.info("テストの前準備を開始");

        try {
            databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost/testDB", "root", "root");

            //ToDo 絶対パスを動的に取得する
            IDataSet testData = new CsvDataSet(new File("src/test/java/dao/testdata/"));
            databaseTester.setDataSet(testData);

            // DELETE→INSERTで事前準備データを用意する
            databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
            databaseTester.onSetup();

            logger.info("前処理終了");


        }catch (ClassNotFoundException | DataSetException  e){
            logger.info("テスト準備中にエラーが発生");
            e.printStackTrace();
        }
    }

    /**
     * データベースのリセッティング
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        databaseTester.setTearDownOperation(DatabaseOperation.NONE);
        databaseTester.onTearDown();
    }

    /**
     * 取得した債券データの削除フラグが全て0であること。
     */
    @Test
    public void whenSelectAllBondReturnsBodnWhichDeleteFlagIsZero(){
        bondDao = new BondDao();
        List<Boolean> flagList = bondDao.selectAllBond()
                                        .stream()
                                        .map(Bond::getDeleteFlag)
                                        .collect(Collectors.toList());
        //サイズが6であること
        assertThat(flagList.size(),equalTo(6));
        //trueを含まないこと
        assertThat(flagList,not(hasItem(true)));

    }



}