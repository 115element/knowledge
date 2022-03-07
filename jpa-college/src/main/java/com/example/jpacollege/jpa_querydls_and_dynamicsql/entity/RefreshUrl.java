package com.example.jpacollege.jpa_querydls_and_dynamicsql.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="t_refresh_url")
public class RefreshUrl {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String url;			//刷新url或dir
	private int actionId;		//本次操作id
	private String taskId;		//厂商任务id
	private String provider;	//厂商
	private int status;			//下发状态，-1已下发，0成功，1失败，2进行中
	private String refreshUrl;	//实际刷新url或dir
	
	public RefreshUrl() {}
	
	public RefreshUrl(String url,int actionId,String taskId,String provider,int status,String refreshUrl){
		this.url=url;
		this.actionId=actionId;
		this.taskId=taskId;
		this.provider=provider;
		this.status=status;
		this.refreshUrl=refreshUrl;
	}
}
