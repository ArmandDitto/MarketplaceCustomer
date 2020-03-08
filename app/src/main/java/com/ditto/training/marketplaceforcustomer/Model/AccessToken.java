package com.ditto.training.marketplaceforcustomer.Model;

import com.google.gson.annotations.SerializedName;

public class AccessToken {
    @SerializedName("token_type")
    String tokenType;
    @SerializedName("expires_in")
    String expiresIn;
    @SerializedName("access_token")
    String accessToken;
    @SerializedName("refresh_token")
    String refreshToken;

    public String getTokenType() {
        return tokenType;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
