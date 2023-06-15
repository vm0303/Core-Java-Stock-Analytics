package io.endeavourtech.stocks.service;

import io.endeavourtech.stocks.dao.LookUpDAO;
import io.endeavourtech.stocks.vo.SectorLookUp;
import io.endeavourtech.stocks.vo.SubsectorLookUp;

import java.util.List;

public class MarketAnalyticsService
{
    private LookUpDAO lookUpDAO;

    public MarketAnalyticsService(LookUpDAO lookUpDAO) {
        this.lookUpDAO = lookUpDAO;
    }

    public void getSectorsOfTheEconomy()
    {
        List<SectorLookUp> allSectorLookUpsList = lookUpDAO.getAllSectorLookUps();
        System.out.println("Number of records in SectorLookup table is " + allSectorLookUpsList.size());
        System.out.println(allSectorLookUpsList);

    }

    public void getSubSectorsOfTheEconomy()
    {
        List<SubsectorLookUp> allSubSectorsLookups = lookUpDAO.getAllSubSectorsLookups();
        System.out.println("Number of records in all SubSectorLookup table is " + allSubSectorsLookups.size());
        System.out.println(allSubSectorsLookups);

    }
}
