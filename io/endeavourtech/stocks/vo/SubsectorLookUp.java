package io.endeavourtech.stocks.vo;

public class SubsectorLookUp
{
    private int subSectorID;

    private String subSectorName;
    private int sectorID;



    public SubsectorLookUp(int subSectorID, int sectorID, String subSectorName) {
        this.subSectorID = subSectorID;
        this.sectorID = sectorID;
        this.subSectorName = subSectorName;
    }

    public int getSubSectorID() {
        return subSectorID;
    }

    public int getSectorID() {
        return sectorID;
    }

    public String getSubSectorName() {
        return subSectorName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SubsectorLookUp{");
        sb.append("subSectorID=").append(subSectorID);
        sb.append(", subSectorName='").append(subSectorName).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
