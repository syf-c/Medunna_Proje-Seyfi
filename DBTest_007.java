package stepDefinitions.DBSteps;

import org.junit.Test;
import utilities.DatabaseUtility;

public class DBTest_007 {

    @Test
    public void tc07() {
        DatabaseUtility.createConnection();

        String query = "Select * from public.jhi_user where id=316114";

        System.out.println(DatabaseUtility.getRowList(query) + "\n");

        System.out.println(DatabaseUtility.getCellValuewithRowsAndCells(query, 0, 5) + "\n");

              }

              @Test
    public void test007(){
                  DatabaseUtility.createConnection();

                  String query = "Select * from public.patient";

                  System.out.println(DatabaseUtility.getRowList(query) + "\n");

                  System.out.println(DatabaseUtility.getCellValuewithRowsAndCells(query,0,0) + "\n");

              }
    }
