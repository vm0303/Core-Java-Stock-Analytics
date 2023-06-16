package io.endeavourtech.stocks.utils;

import io.endeavourtech.stocks.vo.SubsectorLookUp;

import java.util.Comparator;

public class SubSectorComparator implements Comparator<SubsectorLookUp>
{

    /**
     * Establishes an order (SubSector name ascending) for sorting 2 object of the type SubSectorLookup
     * @param other1 the first object to be compared.
     * @param other2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(SubsectorLookUp other1, SubsectorLookUp other2)
    {
        return other1.getSubSectorName().compareTo(other2.getSubSectorName());
        // Gets the reverse sort of the Subsector name
        // return other2.getSubSectorName().compareTo(other1.getSubSectorName());
    }

}
