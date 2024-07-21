package cmis_wasted2;

public class WasteReceiver extends User{

    /**
     * @return the customerID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * @return the customerMembershipLevel
     */
    public String getCustomerMembershipLevel() {
        return customerMembershipLevel;
    }

    /**
     * @param customerMembershipLevel the customerMembershipLevel to set
     */
    public void setCustomerMembershipLevel(String customerMembershipLevel) {
        this.customerMembershipLevel = customerMembershipLevel;
    }
    private int customerID;
    private String customerMembershipLevel;
}
