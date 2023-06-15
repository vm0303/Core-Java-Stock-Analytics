package io.endeavourtech.stocks.vo;

public class SectorLookUp
{
    private int sectorID;
    private String sectorName;

    public SectorLookUp(int sectorID, String sectorName)
    {
        this.sectorID = sectorID;
        this.sectorName = sectorName;
    }

    public int getSectorID() {
        return sectorID;
    }

    public String getSectorName() {
        return sectorName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SectorLookUp{");
        sb.append("sectorID=").append(sectorID);
        sb.append(", sectorName='").append(sectorName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
