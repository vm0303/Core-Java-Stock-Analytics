package io.endeavourtech.stocks.dao;

import io.endeavourtech.stocks.vo.SectorLookUp;
import io.endeavourtech.stocks.vo.SubsectorLookUp;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LookUpDAO extends BaseDao
{
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
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                SectorLookUp sectorLookUp = new SectorLookUp(
                        resultSet.getInt("SECTOR_ID"),
                        resultSet.getString("SECTOR_NAME")
                );
                sectorLookUpList.add(sectorLookUp);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return sectorLookUpList;
    }

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
