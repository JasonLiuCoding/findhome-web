package com.liu.model;

public class RoomComment {

	public final long roomId;
	public final long commentId;
	public final long parent;
	public final int userId;
	public final String userName;
	public final String content;
	public final long markCount;
	public final long createTime;
	public RoomComment(long roomId, long commentId, long parent, int userId,
			String userName, String content, long markCount, long createTime) {
		super();
		this.roomId = roomId;
		this.commentId = commentId;
		this.parent = parent;
		this.userId = userId;
		this.userName = userName;
		this.content = content;
		this.markCount = markCount;
		this.createTime = createTime;
	}
	
	
}
