package com.ticket.DataModel;


public class AssetDetails {

	
	private String assetID;
	private String assetType;
	private String assetLocationID;
	private String circle;
	private String zone;
	
	public AssetDetails(String assetID, String assetType,
			String assetLocationID, String circle, String zone) {
		super();
		this.assetID = assetID;
		this.assetType = assetType;
		this.assetLocationID = assetLocationID;
		this.circle = circle;
		this.zone = zone;
	}

	public String getAssetID() {
		return assetID;
	}

	public void setAssetID(String assetID) {
		this.assetID = assetID;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getAssetLocationID() {
		return assetLocationID;
	}

	public void setAssetLocationID(String assetLocationID) {
		this.assetLocationID = assetLocationID;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	@Override
	public String toString() {
		return "AssetDetails [assetID=" + assetID + ", assetType=" + assetType
				+ ", assetLocationID=" + assetLocationID + ", circle=" + circle
				+ ", zone=" + zone + "]";
	}
	
	
	
	
	
}
