package ir.maktabsharif.util;

public class AuthHolder {

   private Long tokenId;
   private String tokenName;

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

   public void reset() {
        tokenId = null;
        tokenName = null;
    }
}
