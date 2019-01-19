package jp.co.axrossroad.sup.ex0601.db.dto;

/**
 * 預金口座DTO.
 * @author kubo.yusuke
 */
public class AccountDto {
    /**
     * 支店番号.
     */
    private String branchNo;
    /**
     * 口座番号.
     */
    private String accountNo;
    /**
     * 口座名義.
     */
    private String accountName;
    /**
     * 預金残高.
     */
    private long accountBalance;

    /**
     * 支店番号を取得する.
     * @return 支店番号
     */
    public String getBranchNo() {
        return branchNo;
    }

    /**
     * 支店番号を設定する.
     * @param branchNo 支店番号
     */
    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    /**
     * 口座番号を取得する.
     * @return 口座番号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * 口座番号を設定する.
     * @param accountNo 口座番号
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * 口座名義を取得する.
     * @return 口座名義
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 口座名義を設定する.
     * @param accountName 口座名義
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * 預金残高を取得する.
     * @return 預金残高
     */
    public long getAccountBalance() {
        return accountBalance;
    }

    /**
     * 預金残高を設定する.
     * @param accountBalance 預金残高
     */
    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }
}
