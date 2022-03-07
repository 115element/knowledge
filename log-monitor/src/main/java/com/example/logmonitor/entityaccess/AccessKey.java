package com.example.logmonitor.entityaccess;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "t_user_secret")
public class AccessKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "唯一标识")
    private long id;
    private String  access_key_id;
    private String  access_key_secret;

}
