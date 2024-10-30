package com.java_db_example.data;

public class Parties {
    private int partyId;
    private String partyName;
    private String chief;

    public Parties() {

    }

    public Parties(int partyId, String partyName, String chief) {
        this.partyId = partyId;
        this.partyName = partyName;
        this.chief = chief;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getChief() {
        return chief;
    }

    public void setChief(String chief) {
        this.chief = chief;
    }

    @Override
    public String toString() {
        return "{ PartyId: " + getPartyId() +
                " PartyName: " + getPartyName() +
                " Chief Name: " + getChief() +
                " }";
    }
}
