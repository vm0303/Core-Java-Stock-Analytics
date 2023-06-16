package io.endeavourtech.stocks.dao;

import io.endeavourtech.stocks.StockException;
import io.endeavourtech.stocks.vo.SectorLookUp;

import io.endeavourtech.stocks.vo.SubsectorLookUp;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LookUpDAO extends BaseDao
{
    /**
     * This method returns all the Sectors values from the Sector_Lookup table
     * @return  the list of the given columns in Sector Lookup
     */
    public List<SectorLookUp> getAllSectorLookUps()
    {
        List<SectorLookUp> sectorLookUpList = new ArrayList<>();
        String sqlQuery = """
                SELECT
                    SECTOR_ID,
                    SECTOR_NAME
                FROM
                    ENDEAVOUR.SECTOR_LOOKUP sl    
           
                """;
        //Exception handling
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            //Exception handling example
            //String test = null;
            while (resultSet.next())
            {
                SectorLookUp sectorLookUp = new SectorLookUp(
                        resultSet.getInt("SECTOR_ID"),
                        resultSet.getString("SECTOR_NAME")
                );
                sectorLookUpList.add(sectorLookUp);
                // Exception handling example
                //test.substring(8);
            }
        }
        catch ( SQLException e)
        {
//            e.printStackTrace();
            System.out.println("In SQLException catch block.");
            throw new StockException("Unable to fetch the sector data from the database." , e);

        }
        //Repeating this code all the time when closing a SQL connection is unnecessary. See a better method above.
        /*finally {
            if(connection!=null)
            {
                try {
                    System.out.println("Closing the connection.");
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }*/
        return sectorLookUpList;
    }

    /**
     * This method returns all the Sub-Sectors values from the Sector_Lookup table
     * @return the list of the given columns in  Sub Sector lookups
     */
    public List<SubsectorLookUp> getAllSubSectorsLookups()

    {
        List<SubsectorLookUp> subSectorLookUpList = new ArrayList<>();
        String sqlQuery = """
                SELECT
                    sl.SUBSECTOR_ID,
                    sl.SECTOR_ID,
                    sl.SUBSECTOR_NAME\s
                FROM
                    ENDEAVOUR.SUBSECTOR_LOOKUP sl
                """;

        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                SubsectorLookUp subsectorLookUp = new SubsectorLookUp(
                        resultSet.getInt("SUBSECTOR_ID"),
                        resultSet.getInt("SECTOR_ID"),
                        resultSet.getString("SUBSECTOR_NAME")
                );
                subSectorLookUpList.add(subsectorLookUp);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subSectorLookUpList;
    }


}
