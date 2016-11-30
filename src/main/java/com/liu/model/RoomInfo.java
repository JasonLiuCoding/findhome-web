package com.liu.model;

public class RoomInfo {

	public final long id;
	public final int userId;
	public final String userName;
	public final String photo;
	public final String mV;
	public final String description;
	public final long createTime;
	public final byte status;
	public final long visitCount;
	public final long buyCount;
	public final String ext;
	public RoomInfo(long id, int userId, String userName, String photo,
			String mV, String description, long createTime, byte status,
			long visitCount, long buyCount, String ext) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.photo = photo;
		this.mV = mV;
		this.description = description;
		this.createTime = createTime;
		this.status = status;
		this.visitCount = visitCount;
		this.buyCount = buyCount;
		this.ext = ext;
	}
	
	
}
