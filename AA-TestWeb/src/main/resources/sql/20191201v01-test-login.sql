INSERT INTO `ctr_admin`(`id`, `create_dt`, `modify_dt`, `delete_dt`, `commit_id`, `name`, `gender`, `birth`, `avatar`, `language`, `timezone`, `email`, `phone`, `login_name`,
                        `login_pass`, `login_salt`, `bad_count`, `status`, `auth_set`, `role_set`)
VALUES (1, '2019-12-01 12:34:56', '1000-01-01 00:00:00', '1000-01-01 00:00:00', -1, 'test-admin', 1010102, '2019-12-01 12:34:56', 'http://www.lianglife.com', 'zh_CN',
        'Asia/Shanghai', 'shirongjiu@lianglife.com', '1234567890', 'test-admin', '{noop}test-admin-pass', '', 0, 4810101, '1,2', '1');

INSERT INTO `ctr_clerk`(`id`, `create_dt`, `modify_dt`, `delete_dt`, `commit_id`, `store_id`, `name`, `gender`, `birth`, `avatar`, `language`, `timezone`, `email`, `phone`,
                        `login_name`, `login_pass`, `login_salt`, `bad_count`, `status`, `auth_set`, `role_set`)
VALUES (2, '2019-12-01 12:34:56', '1000-01-01 00:00:00', '1000-01-01 00:00:00', -1, 0, 'test-clerk', 1010102, '2019-12-01 12:34:56', 'http://www.lianglife.com', 'zh_CN',
        'Asia/Shanghai', 'shirongjiu@lianglife.com', '1234567890', 'test-clerk', '{noop}test-clerk-pass', '', 0, 4710101, '1', '1');

INSERT INTO `ctr_buyer`(`id`, `create_dt`, `modify_dt`, `delete_dt`, `commit_id`, `name`, `gender`, `birth`, `member_card`, `phone`, `avatar`, `country`, `language`, `timezone`,
                        `status`)
VALUES (3, '2019-12-01 12:34:56', '1000-01-01 00:00:00', '1000-01-01 00:00:00', -1, 'test-buyer', 1010102, '2019-12-01 12:34:56', '987651234', '12345678901',
        'http://www.lianglife.com', 'CN', 'zh_CN', 'Asia/Shanghai', 4510101);

INSERT INTO `ctr_buyer_login`(`id`, `create_dt`, `modify_dt`, `delete_dt`, `commit_id`, `buyer_id`, `login_type`, `login_name`, `login_pass`, `login_salt`, `login_para`,
                              `auth_code`, `bad_count`, `status`)
VALUES (1, '2019-12-01 12:34:56', '1000-01-01 00:00:00', '1000-01-01 00:00:00', -1, 3, 4519901, 'buyer_email', '{noop}test-buyer-pass', '', '', '', 0, 4510101),
       (2, '2019-12-01 12:34:56', '1000-01-01 00:00:00', '1000-01-01 00:00:00', -1, 3, 4519902, 'buyer_name', '{noop}test-buyer-pass', '', '', '', 0, 4510101),
       (3, '2019-12-01 12:34:56', '1000-01-01 00:00:00', '1000-01-01 00:00:00', -1, 3, 4519903, 'buyer_mobile', '{noop}test-buyer-pass', '', '', '', 0, 4510101),
       (4, '2019-12-01 12:34:56', '1000-01-01 00:00:00', '1000-01-01 00:00:00', -1, 3, 4519904, 'buyer_weixin', '{noop}test-buyer-pass', '', '', '', 0, 4510101)
;

INSERT INTO `ctr_authority` (`id`, `create_dt`, `modify_dt`, `delete_dt`, `commit_id`, `name`, `desc`, `para`)
VALUES (1, '2019-12-01 12:34:56', '1000-01-01 00:00:00', '1000-01-01 00:00:00', -1, 'ROLE_USER', '', ''),
       (2, '2019-12-01 12:34:56', '1000-01-01 00:00:00', '1000-01-01 00:00:00', -1, 'ROLE_ADMIN', '', ''),
       (4, '2019-12-01 12:34:56', '1000-01-01 00:00:00', '1000-01-01 00:00:00', -1, 'MENU_WRITE', '', ''),
       (5, '2019-12-01 12:34:56', '1000-01-01 00:00:00', '1000-01-01 00:00:00', -1, 'USER_CREATE', '', '');


INSERT INTO `ctr_auth_role`(`id`, `create_dt`, `modify_dt`, `delete_dt`, `commit_id`, `role_type`, `role_name`, `desc`, `auth_set`)
VALUES (1, '2019-12-01 12:34:56', '1000-01-01 00:00:00', '1000-01-01 00:00:00', -1, 4920101, '门店管理员', '', '4,5');

