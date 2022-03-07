-- 粮小站使用
-- 主键序列：20000, table: ctr_product_category
-- 主键序列：21000, table: ctr_product
-- 主键序列：23000, table: ctr_commodity
-- 主键序列：24000, table: ctr_material
-- 主键序列：25000, table: ctr_commodity_material
-- 主键序列：26000, table: ctr_product_choice
-- 主键序列：27000, table: ctr_product_option
-- --------
-- 主键序列：2800002， table ctr_store
-- 主键序列：3100002， table ctr_scenario
-- 主键序列：4000001， table ctr_scenario_region
-- 主键序列：3200002， table ctr_scenario_store
-- 主键序列：33000， table ctr_proposal
-- 主键序列：35000， table ctr_proposal_commodity
-- 主键序列：36000， table ctr_proposal_option
-- 主键序列：37000， table ctr_scenario_menu
-- 主键序列：38000， table ctr_proposal_menu
-- 主键序列：39000， ctr_proposal_bundle

REPLACE INTO `ctr_product_category`(`id`,`parent_id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`name`,`status`)
VALUES(20000, 0, now(), now(), '1000-01-01', 0, '手抓饼',   3020102),
      (20001, 0, now(), now(), '1000-01-01', 0, '调味酱汁', 3020102),
      (20002, 0, now(), now(), '1000-01-01', 0, '烤串',     3020102),
      (20003, 0, now(), now(), '1000-01-01', 0, '萝卜糕',   3020102),
      (20004, 0, now(), now(), '1000-01-01', 0, '面',      3020102),
      (20005, 0, now(), now(), '1000-01-01', 0, '粥品',    3020102),
      (20006, 0, now(), now(), '1000-01-01', 0, '汤品',    3020102),
      (20007, 0, now(), now(), '1000-01-01', 0, '辅料',    3020102),
      (20008, 0, now(), now(), '1000-01-01', 0, '包材',    3020102)
;

REPLACE INTO `ctr_product`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`prodcate_id`,`img_icon`,`img_mini`,`img_face`,`send_out`,`status`,`name`,`alias`,`desc`)
      -- 手抓饼
VALUES(21000, now(), now(), '1000-01-01', 0, 20000, '',        '',        '', true, 3010101, '原味手抓饼',   '', ''),
      -- 调味酱汁
      (21001, now(), now(), '1000-01-01', 0, 20001, '',        '',        '', true, 3010101, '紅蔥香醬',    '', ''),
      (21002, now(), now(), '1000-01-01', 0, 20001, '',        '',        '', true, 3010101, '櫻花蝦XO酱',  '', ''),
      (21003, now(), now(), '1000-01-01', 0, 20001, '',        '',        '', true, 3010101, '黑椒醬',      '', ''),
      (21004, now(), now(), '1000-01-01', 0, 20001, '',        '',        '', true, 3010101, '麻辣醬',      '', ''),
      (21005, now(), now(), '1000-01-01', 0, 20001, '',        '',        '', true, 3010101, '孜然辣醬',    '', ''),
      (21006, now(), now(), '1000-01-01', 0, 20001, '',        '',        '', true, 3010101, '番茄沙司',    '', ''),
      (21007, now(), now(), '1000-01-01', 0, 20001, '',        '',        '', true, 3010101, '色拉醬',      '', ''),
      (21008, now(), now(), '1000-01-01', 0, 20001, '',        '',        '', true, 3010101, '黑椒酱',      '', ''),
      (21009, now(), now(), '1000-01-01', 0, 20001, '',        '',        '', true, 3010101, '燒烤醬',      '', ''),
      -- 烤串
      (21010, now(), now(), '1000-01-01', 0, 20002, '',        '',        '', true, 3010101, '酱煎烤牛肉串',     '', ''),
      (21011, now(), now(), '1000-01-01', 0, 20002, '',        '',        '', true, 3010101, '酱煎烤羊肉串',     '', ''),
      (21012, now(), now(), '1000-01-01', 0, 20002, '',        '',        '', true, 3010101, '酱煎烤鸡肉串',     '', ''),
      (21013, now(), now(), '1000-01-01', 0, 20002, '',        '',        '', true, 3010101, '酱煎烤猪五花串',     '', ''),
      (21014, now(), now(), '1000-01-01', 0, 20002, '',        '',        '', true, 3010101, '酱煎烤鸭脯串',     '', ''),
      (21015, now(), now(), '1000-01-01', 0, 20002, '',        '',        '', true, 3010101, '酱煎烤鸡心',     '', ''),
      (21016, now(), now(), '1000-01-01', 0, 20002, '',        '',        '', true, 3010101, '酱煎烤鸡胗',     '', ''),
      (21017, now(), now(), '1000-01-01', 0, 20002, '',        '',        '', true, 3010101, '酱煎鸡肉锁骨串',     '', ''),
      (21018, now(), now(), '1000-01-01', 0, 20002, '',        '',        '', true, 3010101, '酱煎骨肉相连',     '', ''),
      (21019, now(), now(), '1000-01-01', 0, 20002, '',        '',        '', true, 3010101, '铁板鱿鱼',     '', ''),
      (21020, now(), now(), '1000-01-01', 0, 20002, '',        '',        '', true, 3010101, '美味烤肠',     '', ''),
       -- 萝卜糕
      (21021, now(), now(), '1000-01-01', 0, 20003, '',        '',        '', true, 3010101, '萝卜糕',  '', ''),
       -- 面
      (21022, now(), now(), '1000-01-01', 0, 20004, '',        '',        '', true, 3010101, '急冻熟面',     '', ''),
       -- 粥品
      (21023, now(), now(), '1000-01-01', 0, 20005, '',        '',        '', true, 3010101, '早餐粥(黑米)',     '', ''),
      (21024, now(), now(), '1000-01-01', 0, 20005, '',        '',        '', true, 3010101, '八宝粥',     '', ''),
      (21025, now(), now(), '1000-01-01', 0, 20005, '',        '',        '', true, 3010101, '银耳根',     '', ''),
      (21026, now(), now(), '1000-01-01', 0, 20005, '',        '',        '', true, 3010101, '小米粥',     '', ''),
      (21027, now(), now(), '1000-01-01', 0, 20005, '',        '',        '', true, 3010101, '南瓜粥',     '', ''),
      (21028, now(), now(), '1000-01-01', 0, 20005, '',        '',        '', true, 3010101, '绿豆沙粥',     '', ''),
       -- 汤品
      (21029, now(), now(), '1000-01-01', 0, 20006, '',        '',        '', true, 3010101, '玉米浓汤',     '', ''),
      (21030, now(), now(), '1000-01-01', 0, 20006, '',        '',        '', true, 3010101, '紫菜蛋花汤',     '', ''),
       -- 辅料
      (21031, now(), now(), '1000-01-01', 0, 20007, '',        '',        '', true, 3010101, '肉松',     '', ''),
      (21032, now(), now(), '1000-01-01', 0, 20007, '',        '',        '', true, 3010101, '培根',    '', ''),
      (21033, now(), now(), '1000-01-01', 0, 20007, '',        '',        '', true, 3010101, '火腿片',     '', ''),
      (21034, now(), now(), '1000-01-01', 0, 20007, '',        '',        '', true, 3010101, '火腿肠',     '', ''),
      (21035, now(), now(), '1000-01-01', 0, 20007, '',        '',        '', true, 3010101, '蟹柳',     '', ''),
      (21036, now(), now(), '1000-01-01', 0, 20007, '',        '',        '', true, 3010101, '芝士',    '', ''),
      (21037, now(), now(), '1000-01-01', 0, 20007, '',        '',        '', true, 3010101, '泡菜',     '', ''),
      (21038, now(), now(), '1000-01-01', 0, 20007, '',        '',        '', true, 3010101, '香嫩猪排',     '', ''),
      (21039, now(), now(), '1000-01-01', 0, 20007, '',        '',        '', true, 3010101, '猪颈肉',     '', ''),
      (21040, now(), now(), '1000-01-01', 0, 20007, '',        '',        '', true, 3010101, '藤椒鸡排',    '', ''),
      (21041, now(), now(), '1000-01-01', 0, 20007, '',        '',        '', true, 3010101, '铁板鸡腿肉',     '', ''),
      (21042, now(), now(), '1000-01-01', 0, 20007, '',        '',        '', true, 3010101, '香煎牛肉（牛肉饼)',    '', ''),
      (21043, now(), now(), '1000-01-01', 0, 20007, '',        '',        '', true, 3010101, '黑椒牛柳',     '', ''),
       -- 包材
      (21044, now(), now(), '1000-01-01', 0, 20008, '',        '',        '', true, 3010101, '手抓饼盒',     '', ''),
      (21045, now(), now(), '1000-01-01', 0, 20008, '',        '',        '', true, 3010101, '烤串盒',     '', ''),
      (21046, now(), now(), '1000-01-01', 0, 20008, '',        '',        '', true, 3010101, '炒饭/面盒',     '', ''),
      (21047, now(), now(), '1000-01-01', 0, 20008, '',        '',        '', true, 3010101, '塑胶提袋',     '', ''),
      (21048, now(), now(), '1000-01-01', 0, 20008, '',        '',        '', true, 3010101, '餐巾纸',     '', ''),
      (21049, now(), now(), '1000-01-01', 0, 20008, '',        '',        '', true, 3010101, '筷子',     '', ''),
      (21050, now(), now(), '1000-01-01', 0, 20008, '',        '',        '', true, 3010101, '吸管',     '', ''),
      (21051, now(), now(), '1000-01-01', 0, 20008, '',        '',        '', true, 3010101, '叉子',     '', ''),
      (21052, now(), now(), '1000-01-01', 0, 20008, '',        '',        '', true, 3010101, '饮料杯(16OZ)',     '', '')
;

-- TRUNCATE TABLE `ctr_commodity`;
REPLACE INTO `ctr_commodity`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`product_id`,`status`,`img_icon`,`img_mini`,`img_face`,`name`)
VALUES(23000, now(), now(), '1000-01-01', 0, 21000, 2530103, '',         '',         '',   '原味手抓饼'),
      (23001, now(), now(), '1000-01-01', 0, 21001, 2530103, '',         '',         '',   '紅蔥香醬'),
      (23002, now(), now(), '1000-01-01', 0, 21002, 2530103, '',         '',         '',   '櫻花蝦XO酱'),
      (23003, now(), now(), '1000-01-01', 0, 21003, 2530103, '',         '',         '',   '黑椒醬'),
      (23004, now(), now(), '1000-01-01', 0, 21004, 2530103, '',         '',         '',   '麻辣醬'),
      (23005, now(), now(), '1000-01-01', 0, 21005, 2530103, '',         '',         '',   '孜然辣醬'),
      (23006, now(), now(), '1000-01-01', 0, 21006, 2530103, '',         '',         '',   '番茄沙司'),
      (23007, now(), now(), '1000-01-01', 0, 21007, 2530103, '',         '',         '',   '色拉醬'),
      (23008, now(), now(), '1000-01-01', 0, 21008, 2530103, '',         '',         '',   '黑椒酱'),
      (23009, now(), now(), '1000-01-01', 0, 21009, 2530103, '',         '',         '',   '燒烤醬'),
      (23010, now(), now(), '1000-01-01', 0, 21010, 2530103, '',         '',         '',   '酱煎烤牛肉串'),
      (23011, now(), now(), '1000-01-01', 0, 21011, 2530103, '',         '',         '',   '酱煎烤羊肉串'),
      (23012, now(), now(), '1000-01-01', 0, 21012, 2530103, '',         '',         '',   '酱煎烤鸡肉串'),
      (23013, now(), now(), '1000-01-01', 0, 21013, 2530103, '',         '',         '',   '酱煎烤猪五花串'),
      (23014, now(), now(), '1000-01-01', 0, 21014, 2530103, '',         '',         '',   '酱煎烤鸭脯串'),
      (23015, now(), now(), '1000-01-01', 0, 21015, 2530103, '',         '',         '',   '酱煎烤鸡心'),
      (23016, now(), now(), '1000-01-01', 0, 21016, 2530103, '',         '',         '',   '酱煎烤鸡胗'),
      (23017, now(), now(), '1000-01-01', 0, 21017, 2530103, '',         '',         '',   '酱煎鸡肉锁骨串'),
      (23018, now(), now(), '1000-01-01', 0, 21018, 2530103, '',         '',         '',   '酱煎骨肉相连'),
      (23019, now(), now(), '1000-01-01', 0, 21019, 2530103, '',         '',         '',   '铁板鱿鱼'),
      (23020, now(), now(), '1000-01-01', 0, 21020, 2530103, '',         '',         '',   '美味烤肠'),
      (23021, now(), now(), '1000-01-01', 0, 21021, 2530103, '',         '',         '',   '萝卜糕'),
      (23022, now(), now(), '1000-01-01', 0, 21022, 2530103, '',         '',         '',   '急冻熟面'),
      (23023, now(), now(), '1000-01-01', 0, 21023, 2530103, '',         '',         '',   '早餐粥(黑米)'),
      (23024, now(), now(), '1000-01-01', 0, 21024, 2530103, '',         '',         '',   '八宝粥'),
      (23025, now(), now(), '1000-01-01', 0, 21025, 2530103, '',         '',         '',   '银耳根'),
      (23026, now(), now(), '1000-01-01', 0, 21026, 2530103, '',         '',         '',   '小米粥'),
      (23027, now(), now(), '1000-01-01', 0, 21027, 2530103, '',         '',         '',   '南瓜粥'),
      (23028, now(), now(), '1000-01-01', 0, 21028, 2530103, '',         '',         '',   '绿豆沙粥'),
      (23029, now(), now(), '1000-01-01', 0, 21029, 2530103, '',         '',         '',   '玉米浓汤'),
      (23030, now(), now(), '1000-01-01', 0, 21030, 2530103, '',         '',         '',   '紫菜蛋花汤'),
      (23031, now(), now(), '1000-01-01', 0, 21031, 2530103, '',         '',         '',   '肉松'),
      (23032, now(), now(), '1000-01-01', 0, 21032, 2530103, '',         '',         '',   '培根'),
      (23033, now(), now(), '1000-01-01', 0, 21033, 2530103, '',         '',         '',   '火腿片'),
      (23034, now(), now(), '1000-01-01', 0, 21034, 2530103, '',         '',         '',   '火腿肠'),
      (23035, now(), now(), '1000-01-01', 0, 21035, 2530103, '',         '',         '',   '蟹柳'),
      (23036, now(), now(), '1000-01-01', 0, 21036, 2530103, '',         '',         '',   '芝士'),
      (23037, now(), now(), '1000-01-01', 0, 21037, 2530103, '',         '',         '',   '泡菜'),
      (23038, now(), now(), '1000-01-01', 0, 21038, 2530103, '',         '',         '',   '香嫩猪排'),
      (23039, now(), now(), '1000-01-01', 0, 21039, 2530103, '',         '',         '',   '猪颈肉'),
      (23040, now(), now(), '1000-01-01', 0, 21040, 2530103, '',         '',         '',   '藤椒鸡排'),
      (23041, now(), now(), '1000-01-01', 0, 21041, 2530103, '',         '',         '',   '铁板鸡腿肉'),
      (23042, now(), now(), '1000-01-01', 0, 21042, 2530103, '',         '',         '',   '香煎牛肉(牛肉饼)'),
      (23043, now(), now(), '1000-01-01', 0, 21043, 2530103, '',         '',         '',   '黑椒牛柳'),
      (23044, now(), now(), '1000-01-01', 0, 21044, 2530103, '',         '',         '',   '手抓饼盒'),
      (23045, now(), now(), '1000-01-01', 0, 21045, 2530103, '',         '',         '',   '烤串盒'),
      (23046, now(), now(), '1000-01-01', 0, 21046, 2530103, '',         '',         '',   '炒饭/面盒'),
      (23047, now(), now(), '1000-01-01', 0, 21047, 2530103, '',         '',         '',   '塑胶提袋'),
      (23048, now(), now(), '1000-01-01', 0, 21048, 2530103, '',         '',         '',   '餐巾纸'),
      (23049, now(), now(), '1000-01-01', 0, 21049, 2530103, '',         '',         '',   '筷子'),
      (23050, now(), now(), '1000-01-01', 0, 21050, 2530103, '',         '',         '',   '吸管'),
      (23051, now(), now(), '1000-01-01', 0, 21051, 2530103, '',         '',         '',   '叉子'),
      (23052, now(), now(), '1000-01-01', 0, 21052, 2530103, '',         '',         '',   '饮料杯(16OZ)')
;

-- TRUNCATE TABLE `ctr_proposal`;
REPLACE INTO `ctr_proposal`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`img_icon`,`img_mini`,`img_face`,`timezone`,`open_ldt`,`shut_ldt`,`price_list`,`price_sell`,`price_rule`,`status`,`ranking`,`sell_time`,`name`,`alias`,`desc`)
VALUES(33000, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/handCake/shouzhuabing_b.png',   'http://static.lianglife.com/Small_Station/handCake/shouzhuabing_b.png',   'http://static.lianglife.com/Small_Station/handCake/shouzhuabing_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  1, '1200106', '原味手抓饼', '100片/箱 冻品','100片/箱 冻品'),
      (33001, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/sauce/hongcong_b.png',   'http://static.lianglife.com/Small_Station/sauce/hongcong_b.png',   'http://static.lianglife.com/Small_Station/sauce/hongcong_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  2, '1200106', '紅蔥香醬', '1kg（包）/4包/箱 常温','1kg（包）/4包/箱 常温'),
      (33002, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/sauce/xo_b.png',   'http://static.lianglife.com/Small_Station/sauce/xo_b.png',   'http://static.lianglife.com/Small_Station/sauce/xo_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  3, '1200106', '櫻花蝦XO酱', '1kg（包）/4包/箱 常温','1kg（包）/4包/箱 常温'),
      (33003, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/sauce/heijiao_b.png',   'http://static.lianglife.com/Small_Station/sauce/heijiao_b.png',   'http://static.lianglife.com/Small_Station/sauce/heijiao_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  4, '1200106', '黑椒醬', '1kg（包）/4包/箱 常温','1kg（包）/4包/箱 常温'),
      (33004, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/sauce/mala_b.png',   'http://static.lianglife.com/Small_Station/sauce/mala_b.png',   'http://static.lianglife.com/Small_Station/mala_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  5, '1200106', '麻辣醬', '1kg（包）/4包/箱 常温','1kg（包）/4包/箱 常温'),
      (33005, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/sauce/ziranla_b.png',   'http://static.lianglife.com/Small_Station/sauce/ziranla_b.png',   'http://static.lianglife.com/Small_Station/sauce/ziranla_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  6, '1200106', '孜然辣醬', '1kg（包）/4包/箱 常温','1kg（包）/4包/箱 常温'),
      (33006, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/sauce/fanqie_b.png',   'http://static.lianglife.com/Small_Station/sauce/fanqie_b.png',   'http://static.lianglife.com/Small_Station/sauce/fanqie_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  7, '1200106', '番茄沙司', '1kg（包）/4包/箱 常温','1kg（包）/4包/箱 常温'),
      (33007, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/sauce/sela_b.png',   'http://static.lianglife.com/Small_Station/sauce/sela_b.png',   'http://static.lianglife.com/Small_Station/sauce/sela_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  8, '1200106', '色拉醬', '1kg（包）/4包/箱 常温','1kg（包）/4包/箱 常温'),
      (33008, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/sauce/heijiao_b.png',   'http://static.lianglife.com/Small_Station/sauce/heijiao_b.png',   'http://static.lianglife.com/Small_Station/sauce/heijiao_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  9, '1200106', '黑椒酱', '1kg（包）/4包/箱 常温','1kg（包）/4包/箱 常温'),
      (33009, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/sauce/shaokao_b.png',   'http://static.lianglife.com/Small_Station/sauce/shaokao_b.png',   'http://static.lianglife.com/Small_Station/sauce/shaokao_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  10, '1200106', '燒烤醬', '1kg（包）/4包/箱 常温','1kg（包）/4包/箱 常温'),
      (33010, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/kebab/niurou_b.png',   'http://static.lianglife.com/Small_Station/kebab/niurou_b.png',   'http://static.lianglife.com/Small_Station/kebab/niurou_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  11, '1200106', '酱煎烤牛肉串', '30g/串*30串/包*6包/箱 冷冻','30g/串*30串/包*6包/箱 冷冻'),
      (33011, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/kebab/yangrou_b.png',   'http://static.lianglife.com/Small_Station/kebab/yangrou_b.png',   'http://static.lianglife.com/Small_Station/kebab/yangrou_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  12, '1200106', '酱煎烤羊肉串', '30g/串*30串/包*6包/箱 冷冻','30g/串*30串/包*6包/箱 冷冻'),
      (33012, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/kebab/jirou_b.png',   'http://static.lianglife.com/Small_Station/kebab/jirou_b.png',   'http://static.lianglife.com/Small_Station/kebab/jirou_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  13, '1200106', '酱煎烤鸡肉串', '30g/串*30串/包*6包/箱 冷冻','30g/串*30串/包*6包/箱 冷冻'),
      (33013, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/kebab/wuhuarou_b.png',   'http://static.lianglife.com/Small_Station/kebab/wuhuarou_b.png',   'http://static.lianglife.com/Small_Station/kebab/wuhuarou_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  14, '1200106', '酱煎烤猪五花串', '30g/串*30串/包*6包/箱 冷冻','30g/串*30串/包*6包/箱 冷冻'),
      (33014, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/kebab/yapu_b.png',   'http://static.lianglife.com/Small_Station/kebab/yapu_b.png',   'http://static.lianglife.com/Small_Station/kebab/yapu_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  15, '1200106', '酱煎烤鸭脯串', '30g/串*30串/包*6包/箱 冷冻','30g/串*30串/包*6包/箱 冷冻'),
      (33015, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/kebab/jixin_b.png',   'http://static.lianglife.com/Small_Station/kebab/jixin_b.png',   'http://static.lianglife.com/Small_Station/kebab/jixin_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  16, '1200106', '酱煎烤鸡心', '30g/串*30串/包*6包/箱 冷冻','30g/串*30串/包*6包/箱 冷冻'),
      (33016, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/kebab/jizhen_b.png',   'http://static.lianglife.com/Small_Station/kebab/jizhen_b.png',   'http://static.lianglife.com/Small_Station/kebab/jizhen_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  17, '1200106', '酱煎烤鸡胗', '30g/串*30串/包*6包/箱 冷冻','30g/串*30串/包*6包/箱 冷冻'),
      (33017, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/kebab/jisuogu_b.png',   'http://static.lianglife.com/Small_Station/kebab/jisuogu_b.png',   'http://static.lianglife.com/Small_Station/kebab/jisuogu_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  18, '1200106', '酱煎鸡肉锁骨串', '30g/串*30串/包*6包/箱 冷冻','30g/串*30串/包*6包/箱 冷冻'),
      (33018, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/kebab/gurouxianglian_b.png',   'http://static.lianglife.com/Small_Station/kebab/gurouxianglian_b.png',   'http://static.lianglife.com/Small_Station/kebab/gurouxianglian_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  19, '1200106', '酱煎骨肉相连', '30g/串*30串/包*6包/箱 冷冻','30g/串*30串/包*6包/箱 冷冻'),
      (33019, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/kebab/youyu_b.png',   'http://static.lianglife.com/Small_Station/kebab/youyu_b.png',   'http://static.lianglife.com/Small_Station/kebab/youyu_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  20, '1200106', '铁板鱿鱼', '40g/串*20串/包*6包/箱 冷冻','40g/串*20串/包*6包/箱 冷冻'),
      (33020, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/kebab/kaochang_b.png',   'http://static.lianglife.com/Small_Station/kebab/kaochang_b.png',   'http://static.lianglife.com/Small_Station/kebab/kaochang_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  21, '1200106', '美味烤肠', '30g/根*30根/包*4包/箱 冷冻','30g/根*30根/包*4包/箱 冷冻'),
      (33021, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/cake/luobogao_b.png',   'http://static.lianglife.com/Small_Station/cake/luobogao_b.png',   'http://static.lianglife.com/Small_Station/cake/luobogao_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  22, '1200106', '萝卜糕', '50g*10片/包/10包/箱 冷冻','50g*10片/包/10包/箱 冷冻'),
      (33022, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/noodle/mian_b.png',   'http://static.lianglife.com/Small_Station/noodle/mian_b.png',   'http://static.lianglife.com/Small_Station/noodle/mian_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  23, '1200106', '急冻熟面', '120g/包*50包/箱 冷冻','120g/包*50包/箱 冷冻'),
      (33023, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/porridge/heimi_b.png',   'http://static.lianglife.com/Small_Station/porridge/heimi_b.png',   'http://static.lianglife.com/Small_Station/porridge/heimi_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  24, '1200106', '早餐粥(黑米)', '330g/瓶*30瓶/箱 常温','330g/瓶*30瓶/箱 常温'),
      (33024, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/porridge/babao_b.png',   'http://static.lianglife.com/Small_Station/porridge/babao_b.png',   'http://static.lianglife.com/Small_Station/porridge/babao_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  25, '1200106', '八宝粥', '330g/瓶*30瓶/箱 常温','330g/瓶*30瓶/箱 常温'),
      (33025, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/porridge/yiner_b.png',   'http://static.lianglife.com/Small_Station/porridge/yiner_b.png',   'http://static.lianglife.com/Small_Station/porridge/yiner_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  26, '1200106', '银耳根', '330g/瓶*30瓶/箱 常温','330g/瓶*30瓶/箱 常温'),
      (33026, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/porridge/xiaomi_b.png',   'http://static.lianglife.com/Small_Station/porridge/xiaomi_b.png',   'http://static.lianglife.com/Small_Station/porridge/xiaomi_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  27, '1200106', '小米粥', '330g/瓶*30瓶/箱 常温','330g/瓶*30瓶/箱 常温'),
      (33027, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/porridge/nangua_b.png',   'http://static.lianglife.com/Small_Station/porridge/nangua_b.png',   'http://static.lianglife.com/Small_Station/porridge/nangua_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  28, '1200106', '南瓜粥', '330g/瓶*30瓶/箱 常温','330g/瓶*30瓶/箱 常温'),
      (33028, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/porridge/lvdou_b.png',   'http://static.lianglife.com/Small_Station/porridge/lvdou_b.png',   'http://static.lianglife.com/Small_Station/porridge/lvdou_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  29, '1200106', '绿豆沙粥', '330g/瓶*30瓶/箱 常温','330g/瓶*30瓶/箱 常温'),
      (33029, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/soup/yumi_b.png',   'http://static.lianglife.com/Small_Station/soup/yumi_b.png',   'http://static.lianglife.com/Small_Station/soup/yumi_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  30, '1200106', '玉米浓汤', '5g/包 100包/箱 常温','5g/包 100包/箱 常温'),
      (33030, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/soup/zicai_b.png',   'http://static.lianglife.com/Small_Station/soup/zicai_b.png',   'http://static.lianglife.com/Small_Station/soup/zicai_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  31, '1200106', '紫菜蛋花汤', '5g/包 100包/箱 常温','5g/包 100包/箱 常温'),
      (33031, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/ingredients/rousong_b.png',   'http://static.lianglife.com/Small_Station/ingredients/rousong_b.png',   'http://static.lianglife.com/Small_Station/ingredients/rousong_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  32, '1200106', '肉松', '1kg/包*4包/箱 常温','1kg/包*4包/箱 常温'),
      (33032, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/ingredients/peigen_b.png',   'http://static.lianglife.com/Small_Station/ingredients/peigen_b.png',   'http://static.lianglife.com/Small_Station/ingredients/peigen_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  33, '1200106', '培根', '120g/包*10包/箱 冷藏','120g/包*10包/箱 冷藏'),
      (33033, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/ingredients/huotuipian_b.png',   'http://static.lianglife.com/Small_Station/ingredients/huotuipian_b.png',   'http://static.lianglife.com/Small_Station/ingredients/huotuipian_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  34, '1200106', '火腿片', '120g/包*10包/箱 冷藏','120g/包*10包/箱 冷藏'),
      (33034, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/ingredients/huotuichang_b.png',   'http://static.lianglife.com/Small_Station/ingredients/huotuichang_b.png',   'http://static.lianglife.com/Small_Station/ingredients/huotuichang_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  35, '1200106', '火腿肠', '150g/包*10包/箱 冷藏','150g/包*10包/箱 冷藏'),
      (33035, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/ingredients/xieliu_b.png',   'http://static.lianglife.com/Small_Station/ingredients/xieliu_b.png',   'http://static.lianglife.com/Small_Station/ingredients/xieliu_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  36, '1200106', '蟹柳', '200g/包*10包/箱 冷藏','200g/包*10包/箱 冷藏'),
      (33036, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/ingredients/zhishi_b.png',   'http://static.lianglife.com/Small_Station/ingredients/zhishi_b.png',   'http://static.lianglife.com/Small_Station/ingredients/zhishi_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  37, '1200106', '芝士', '200g/包*10包/箱 冷藏','200g/包*10包/箱 冷藏'),
      (33037, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/ingredients/paocai_b.png',   'http://static.lianglife.com/Small_Station/ingredients/paocai_b.png',   'http://static.lianglife.com/Small_Station/ingredients/paocai_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  38, '1200106', '泡菜', '1KG/包*5包/箱 冷藏','1KG/包*5包/箱 冷藏'),
      (33038, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/ingredients/zhupai_b.png',   'http://static.lianglife.com/Small_Station/ingredients/zhupai_b.png',   'http://static.lianglife.com/Small_Station/ingredients/zhupai_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  39, '1200106', '香嫩猪排', '1KG/包*6包/箱 冷冻','1KG/包*6包/箱 冷冻'),
      (33039, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/ingredients/zhujinrou_b.png',   'http://static.lianglife.com/Small_Station/ingredients/zhujinrou_b.png',   'http://static.lianglife.com/Small_Station/ingredients/zhujinrou_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  40, '1200106', '猪颈肉', '1KG/包*6包/箱 冷冻','1KG/包*6包/箱 冷冻'),
      (33040, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/ingredients/jipai_b.png',   'http://static.lianglife.com/Small_Station/ingredients/jipai_b.png',   'http://static.lianglife.com/Small_Station/ingredients/jipai_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  41, '1200106', '藤椒鸡排', '1KG/包*6包/箱 冷冻','1KG/包*6包/箱 冷冻'),
      (33041, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/ingredients/jituirou_b.png',   'http://static.lianglife.com/Small_Station/ingredients/jituirou_b.png',   'http://static.lianglife.com/Small_Station/ingredients/jituirou_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  42, '1200106', '铁板鸡腿肉', '1KG/包*6包/箱 冷冻','1KG/包*6包/箱 冷冻'),
      (33042, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/ingredients/niuroubing_b.png',   'http://static.lianglife.com/Small_Station/ingredients/niuroubing_b.png',   'http://static.lianglife.com/Small_Station/ingredients/niuroubing_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  43, '1200106', '香煎牛肉(牛肉饼)', '1KG/包*6包/箱 冷冻','1KG/包*6包/箱 冷冻'),
      (33043, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/ingredients/niuliu_b.png',   'http://static.lianglife.com/Small_Station/ingredients/niuliu_b.png',   'http://static.lianglife.com/Small_Station/ingredients/niuliu_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  44, '1200106', '黑椒牛柳', '1KG/包*6包/箱 冷冻','1KG/包*6包/箱 冷冻'),
      (33044, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/packingMaterial/shouzhuazhihe_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/shouzhuazhihe_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/shouzhuazhihe_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  45, '1200106', '手抓饼盒', '1000个/箱 常温','1000个/箱 常温'),
      (33045, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/packingMaterial/kaochuanhe_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/kaochuanhe_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/kaochuanhe_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  46, '1200106', '烤串盒', '1000个/箱 常温','1000个/箱 常温'),
      (33046, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/packingMaterial/fanhe_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/fanhe_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/fanhe_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  47, '1200106', '炒饭/面盒', '1000个/箱 常温','1000个/箱 常温'),
      (33047, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/packingMaterial/tidai_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/tidai_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/tidai_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  48, '1200106', '塑胶提袋', '500个/包 常温','500个/包 常温'),
      (33048, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/packingMaterial/zhijin_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/zhijin_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/zhijin_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  49, '1200106', '餐巾纸', '100张/包*60包/箱 常温','100张/包*60包/箱 常温'),
      (33049, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/packingMaterial/kuaizi_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/kuaizi_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/kuaizi_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  50, '1200106', '筷子', '100双/包*10包/箱 常温','100双/包*10包/箱 常温'),
      (33050, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/packingMaterial/xiguan_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/xiguan_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/xiguan_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  51, '1200106', '吸管', '100根/包*10包/箱 常温','100根/包*10包/箱 常温'),
      (33051, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/packingMaterial/chazi_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/chazi_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/chazi_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  52, '1200106', '叉子', '100根/包*10包/箱 常温','100根/包*10包/箱 常温'),
      (33052, now(), now(), '1000-01-01', 0, 3100002, 'http://static.lianglife.com/Small_Station/packingMaterial/zhibei_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/zhibei_b.png',   'http://static.lianglife.com/Small_Station/packingMaterial/zhibei_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  53, '1200106', '饮料杯(16OZ)', '20个/条*20包/箱 常温','20个/条*20包/箱 常温')
;

-- TRUNCATE TABLE `ctr_proposal_commodity`;
REPLACE INTO `ctr_proposal_commodity`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`bundle_id`,`product_id`,`commodity_id`,`price_list`,`price_sell`,`buy_min`,`buy_max`,`show_price`,`selected`,`ranking`,`name`)
      -- 单品数据
VALUES(35000, now(), now(), '1000-01-01', 0, 33000 ,0, 21000, 23000, 125, 125, 1, 1, true, true, 1, '原味手抓饼'),
      (35001, now(), now(), '1000-01-01', 0, 33001 ,0, 21001, 23001, 120, 120, 1, 1, true, true, 2, '紅蔥香醬'),
      (35002, now(), now(), '1000-01-01', 0, 33002 ,0, 21002, 23002, 120, 120, 1, 1, true, true, 3, '櫻花蝦XO酱'),
      (35003, now(), now(), '1000-01-01', 0, 33003 ,0, 21003, 23003, 120, 120, 1, 1, true, true, 4, '黑椒醬'),
      (35004, now(), now(), '1000-01-01', 0, 33004 ,0, 21004, 23004, 120, 120, 1, 1, true, true, 5, '麻辣醬'),
      (35005, now(), now(), '1000-01-01', 0, 33005 ,0, 21005, 23005, 120, 120, 1, 1, true, true, 6, '孜然辣醬'),
      (35006, now(), now(), '1000-01-01', 0, 33006 ,0, 21006, 23006, 120, 120, 1, 1, true, true, 7, '番茄沙司'),
      (35007, now(), now(), '1000-01-01', 0, 33007 ,0, 21007, 23007, 120, 120, 1, 1, true, true, 8, '色拉醬'),
      (35008, now(), now(), '1000-01-01', 0, 33008 ,0, 21008, 23008, 120, 120, 1, 1, true, true, 9, '黑椒酱'),
      (35009, now(), now(), '1000-01-01', 0, 33009 ,0, 21009, 23009, 120, 120, 1, 1, true, true, 10, '燒烤醬'),

      (35010, now(), now(), '1000-01-01', 0, 33010 ,0, 21010, 23010, 378, 378, 1, 1, true, true, 11, '酱煎烤牛肉串'),
      (35011, now(), now(), '1000-01-01', 0, 33011 ,0, 21011, 23011, 365, 365, 1, 1, true, true, 12, '酱煎烤羊肉串'),
      (35012, now(), now(), '1000-01-01', 0, 33012 ,0, 21012, 23012, 352, 352, 1, 1, true, true, 13, '酱煎烤鸡肉串'),
      (35013, now(), now(), '1000-01-01', 0, 33013 ,0, 21013, 23013, 339, 339, 1, 1, true, true, 14, '酱煎烤猪五花串'),
      (35014, now(), now(), '1000-01-01', 0, 33014 ,0, 21014, 23014, 326, 326, 1, 1, true, true, 15, '酱煎烤鸭脯串'),
      (35015, now(), now(), '1000-01-01', 0, 33015 ,0, 21015, 23015, 313, 313, 1, 1, true, true, 16, '酱煎烤鸡心'),
      (35016, now(), now(), '1000-01-01', 0, 33016 ,0, 21016, 23016, 300, 300, 1, 1, true, true, 17, '酱煎烤鸡胗'),
      (35017, now(), now(), '1000-01-01', 0, 33017 ,0, 21017, 23017, 287, 287, 1, 1, true, true, 18, '酱煎鸡肉锁骨串'),
      (35018, now(), now(), '1000-01-01', 0, 33018 ,0, 21018, 23018, 274, 274, 1, 1, true, true, 19, '酱煎骨肉相连'),
      (35019, now(), now(), '1000-01-01', 0, 33019 ,0, 21019, 23019, 365, 365, 1, 1, true, true, 20, '铁板鱿鱼'),
      (35020, now(), now(), '1000-01-01', 0, 33020 ,0, 21020, 23020, 180, 180, 1, 1, true, true, 21, '美味烤肠'),
      (35021, now(), now(), '1000-01-01', 0, 33021 ,0, 21021, 23021, 300, 300, 1, 1, true, true, 22, '萝卜糕'),
      (35022, now(), now(), '1000-01-01', 0, 33022 ,0, 21022, 23022, 150, 150, 1, 1, true, true, 23, '急冻熟面'),
      (35023, now(), now(), '1000-01-01', 0, 33023 ,0, 21023, 23023, 45, 45, 1, 1, true, true, 24, '早餐粥（黑米）'),
      (35024, now(), now(), '1000-01-01', 0, 33024 ,0, 21024, 23024, 45, 45, 1, 1, true, true, 25, '八宝粥'),
      (35025, now(), now(), '1000-01-01', 0, 33025 ,0, 21025, 23025, 45, 45, 1, 1, true, true, 26, '银耳根'),
      (35026, now(), now(), '1000-01-01', 0, 33026 ,0, 21026, 23026, 45, 45, 1, 1, true, true, 27, '小米粥'),
      (35027, now(), now(), '1000-01-01', 0, 33027 ,0, 21027, 23027, 45, 45, 1, 1, true, true, 28, '南瓜粥'),
      (35028, now(), now(), '1000-01-01', 0, 33028 ,0, 21028, 23028, 45, 45, 1, 1, true, true, 29, '绿豆沙粥'),
      (35029, now(), now(), '1000-01-01', 0, 33029 ,0, 21029, 23029, 300, 300, 1, 1, true, true, 30, '玉米浓汤'),
      (35030, now(), now(), '1000-01-01', 0, 33030 ,0, 21030, 23030, 300, 300, 1, 1, true, true, 31, '紫菜蛋花汤'),
      (35031, now(), now(), '1000-01-01', 0, 33031 ,0, 21031, 23031, 200, 200, 1, 1, true, true, 32, '肉松'),
      (35032, now(), now(), '1000-01-01', 0, 33032 ,0, 21032, 23032, 150, 150, 1, 1, true, true, 33, '培根'),
      (35033, now(), now(), '1000-01-01', 0, 33033 ,0, 21033, 23033, 160, 160, 1, 1, true, true, 34, '火腿片'),
      (35034, now(), now(), '1000-01-01', 0, 33034 ,0, 21034, 23034, 180, 180, 1, 1, true, true, 35, '火腿肠'),
      (35035, now(), now(), '1000-01-01', 0, 33035 ,0, 21035, 23035, 300, 300, 1, 1, true, true, 36, '蟹柳'),
      (35036, now(), now(), '1000-01-01', 0, 33036 ,0, 21036, 23036, 350, 350, 1, 1, true, true, 37, '芝士'),
      (35037, now(), now(), '1000-01-01', 0, 33037 ,0, 21037, 23037, 200, 200, 1, 1, true, true, 38, '泡菜'),
      (35038, now(), now(), '1000-01-01', 0, 33038 ,0, 21038, 23038, 280, 280, 1, 1, true, true, 39, '香嫩猪排'),
      (35039, now(), now(), '1000-01-01', 0, 33039 ,0, 21039, 23039, 320, 320, 1, 1, true, true, 40, '猪颈肉'),
      (35040, now(), now(), '1000-01-01', 0, 33040 ,0, 21040, 23040, 260, 260, 1, 1, true, true, 41, '藤椒鸡排'),
      (35041, now(), now(), '1000-01-01', 0, 33041 ,0, 21041, 23041, 300, 300, 1, 1, true, true, 42, '铁板鸡腿肉'),
      (35042, now(), now(), '1000-01-01', 0, 33042 ,0, 21042, 23042, 340, 340, 1, 1, true, true, 43, '香煎牛肉（牛肉饼)'),
      (35043, now(), now(), '1000-01-01', 0, 33043 ,0, 21043, 23043, 360, 360, 1, 1, true, true, 44, '黑椒牛柳'),
      (35044, now(), now(), '1000-01-01', 0, 33044 ,0, 21044, 23044, 800, 800, 1, 1, true, true, 45, '手抓饼盒'),
      (35045, now(), now(), '1000-01-01', 0, 33045 ,0, 21045, 23045, 700, 700, 1, 1, true, true, 46, '烤串盒'),
      (35046, now(), now(), '1000-01-01', 0, 33046 ,0, 21046, 23046, 900, 900, 1, 1, true, true, 47, '炒饭/面盒'),
      (35047, now(), now(), '1000-01-01', 0, 33047 ,0, 21047, 23047, 250, 250, 1, 1, true, true, 48, '塑胶提袋'),
      (35048, now(), now(), '1000-01-01', 0, 33048 ,0, 21048, 23048, 300, 300, 1, 1, true, true, 49, '餐巾纸'),
      (35049, now(), now(), '1000-01-01', 0, 33049 ,0, 21049, 23049, 350, 350, 1, 1, true, true, 50, '筷子'),
      (35050, now(), now(), '1000-01-01', 0, 33050 ,0, 21050, 23050, 250, 250, 1, 1, true, true, 51, '吸管'),
      (35051, now(), now(), '1000-01-01', 0, 33051 ,0, 21051, 23051, 300, 300, 1, 1, true, true, 52, '叉子'),
      (35052, now(), now(), '1000-01-01', 0, 33052 ,0, 21052, 23052, 180, 180, 1, 1, true, true, 53, '饮料杯（16OZ)')
;

-- TRUNCATE TABLE `ctr_scenario_menu`;
REPLACE INTO `ctr_scenario_menu`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`name`,`img_icon`,`desc`,`visible`,`topmenu`,`ranking`)
VALUES(37000, now(), now(), '1000-01-01', 0, 3100002, '手抓饼',    '', '', true, false, 1),
      (37001, now(), now(), '1000-01-01', 0, 3100002, '调味酱汁',  '', '', true, false, 2),
      (37002, now(), now(), '1000-01-01', 0, 3100002, '烤串',     '', '', true, false, 3),
      (37003, now(), now(), '1000-01-01', 0, 3100002, '萝卜糕',   '', '', true, false, 4),
      (37004, now(), now(), '1000-01-01', 0, 3100002, '面',      '', '', true, false, 5),
      (37005, now(), now(), '1000-01-01', 0, 3100002, '粥品',    '', '', true, false, 6),
      (37006, now(), now(), '1000-01-01', 0, 3100002, '汤品',    '', '', true, false, 7),
      (37007, now(), now(), '1000-01-01', 0, 3100002, '辅料',    '', '', true, false, 8),
      (37008, now(), now(), '1000-01-01', 0, 3100002, '包材',    '', '', true, false, 9)
;

-- TRUNCATE TABLE `ctr_proposal_menu`;
REPLACE INTO `ctr_proposal_menu`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`scenmenu_id`)
VALUES(38000, now(), now(), '1000-01-01', 0, 33000, 37000),
      (38001, now(), now(), '1000-01-01', 0, 33001, 37001),
      (38002, now(), now(), '1000-01-01', 0, 33002, 37001),
      (38003, now(), now(), '1000-01-01', 0, 33003, 37001),
      (38004, now(), now(), '1000-01-01', 0, 33004, 37001),
      (38005, now(), now(), '1000-01-01', 0, 33005, 37001),
      (38006, now(), now(), '1000-01-01', 0, 33006, 37001),
      (38007, now(), now(), '1000-01-01', 0, 33007, 37001),
      (38008, now(), now(), '1000-01-01', 0, 33008, 37001),
      (38009, now(), now(), '1000-01-01', 0, 33009, 37001),

      (38010, now(), now(), '1000-01-01', 0, 33010, 37002),
      (38011, now(), now(), '1000-01-01', 0, 33011, 37002),
      (38012, now(), now(), '1000-01-01', 0, 33012, 37002),
      (38013, now(), now(), '1000-01-01', 0, 33013, 37002),
      (38014, now(), now(), '1000-01-01', 0, 33014, 37002),
      (38015, now(), now(), '1000-01-01', 0, 33015, 37002),
      (38016, now(), now(), '1000-01-01', 0, 33016, 37002),
      (38017, now(), now(), '1000-01-01', 0, 33017, 37002),
      (38018, now(), now(), '1000-01-01', 0, 33018, 37002),
      (38019, now(), now(), '1000-01-01', 0, 33019, 37002),
      (38020, now(), now(), '1000-01-01', 0, 33020, 37002),

      (38021, now(), now(), '1000-01-01', 0, 33021, 37003),

      (38022, now(), now(), '1000-01-01', 0, 33022, 37004),

      (38023, now(), now(), '1000-01-01', 0, 33023, 37005),
      (38024, now(), now(), '1000-01-01', 0, 33024, 37005),
      (38025, now(), now(), '1000-01-01', 0, 33025, 37005),
      (38026, now(), now(), '1000-01-01', 0, 33026, 37005),
      (38027, now(), now(), '1000-01-01', 0, 33027, 37005),
      (38028, now(), now(), '1000-01-01', 0, 33028, 37005),

      (38029, now(), now(), '1000-01-01', 0, 33029, 37006),
      (38030, now(), now(), '1000-01-01', 0, 33030, 37006),

      (38031, now(), now(), '1000-01-01', 0, 33031, 37007),
      (38032, now(), now(), '1000-01-01', 0, 33032, 37007),
      (38033, now(), now(), '1000-01-01', 0, 33033, 37007),
      (38034, now(), now(), '1000-01-01', 0, 33034, 37007),
      (38035, now(), now(), '1000-01-01', 0, 33035, 37007),
      (38036, now(), now(), '1000-01-01', 0, 33036, 37007),
      (38037, now(), now(), '1000-01-01', 0, 33037, 37007),
      (38038, now(), now(), '1000-01-01', 0, 33038, 37007),
      (38039, now(), now(), '1000-01-01', 0, 33039, 37007),
      (38040, now(), now(), '1000-01-01', 0, 33040, 37007),
      (38041, now(), now(), '1000-01-01', 0, 33041, 37007),
      (38042, now(), now(), '1000-01-01', 0, 33042, 37007),
      (38043, now(), now(), '1000-01-01', 0, 33043, 37007),

      (38044, now(), now(), '1000-01-01', 0, 33044, 37008),
      (38045, now(), now(), '1000-01-01', 0, 33045, 37008),
      (38046, now(), now(), '1000-01-01', 0, 33046, 37008),
      (38047, now(), now(), '1000-01-01', 0, 33047, 37008),
      (38048, now(), now(), '1000-01-01', 0, 33048, 37008),
      (38049, now(), now(), '1000-01-01', 0, 33049, 37008),
      (38050, now(), now(), '1000-01-01', 0, 33050, 37008),
      (38051, now(), now(), '1000-01-01', 0, 33051, 37008),
      (38052, now(), now(), '1000-01-01', 0, 33052, 37008)
;

-- TRUNCATE TABLE `ctr_proposal_bundle`;
-- INSERT INTO `ctr_proposal_bundle`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`name`,`buy_num`,`ranking`)
-- VALUES(39000, now(), now(), '1000-01-01', 0, 3366, '主食', 1, 1),
--      (39001, now(), now(), '1000-01-01', 0, 3366, '饮品', 1, 2),

--      (39002, now(), now(), '1000-01-01', 0, 3367, '主食', 1, 1),
--      (39003, now(), now(), '1000-01-01', 0, 3367, '饮品', 1, 2)
-- ;

REPLACE INTO `ctr_store`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`name`,`status`,`region_id`,`timezone`,`position`,`map_type`,`address`,`store_type`,`datum_type`,`place_type`,`union_type`,`square`,`square_unit`,`seat_count`,`manager_name`,`manager_phone`,`photo1`,`photo2`,`photo3`,`photo4`,`photo5`,`opening_ldt`,`expired_ldt`,`inner_only`,`eat_inside`,`sell_mode`,`send_area_gmap`,`send_area_json`,`tax_rate`,`sendouter_id`,`scenario_id`, `store_num`)
VALUES(2800002,now(),now(),'1000-01-01',0,'粮小站',4010102,1000900,10100,'','','',4010201,4010501,4010304,4010401,'120','平方米','20','J','15994234567','','','','','','2019-10-01','2029-10-01',true,true,'自提,外送','','',0,0,'3100002', '2800002');

REPLACE INTO `ctr_scenario`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`name`,`desc`,`img_advt`,`currency`,`status`)
VALUES(3100002, now(), now(), '1000-01-01', 0, '上海地区粮小站通用方案', '', 'http://static.lianglife.com/HomePage/20200108.png', 'CNY', 3710102);

REPLACE INTO `ctr_scenario_region`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`region_id`,`store_type`,`place_type`)
VALUES(4000001, now(), now(), '1000-01-01', 0, 3100002, 1000900, 4010201, 4010304);

REPLACE INTO `ctr_scenario_store`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`store_id`)
VALUES(3200002, now(), now(), '1000-01-01', 0,3100002,2800002);

INSERT INTO `liangcenter_release`.`ctr_store_timing` (`id`, `create_dt`, `modify_dt`, `delete_dt`, `commit_id`, `store_id`, `time_enum`, `start_dt`, `close_dt`, `has_zone`, `has_date`, `has_time`)
VALUES ('109', '2020-02-26 00:00:00', '2020-02-26 00:00:00', '1000-01-01 00:00:00', '200', '2800002', '1200106', '1000-01-01 08:00:00', '1000-01-01 23:00:00', '0', '0', '1');

INSERT INTO `liangcenter_release`.`ctr_store_timing` (`id`, `create_dt`, `modify_dt`, `delete_dt`, `commit_id`, `store_id`, `time_enum`, `start_dt`, `close_dt`, `has_zone`, `has_date`, `has_time`)
VALUES ('110', '2019-12-30 00:00:00', '2020-01-13 15:19:36', '1000-01-01 00:00:00', '100', '2800002', '1200201', '1000-01-01 08:00:00', '1000-01-01 23:00:00', '0', '0', '1');

INSERT INTO `liangcenter_release`.`ctr_store_timing` (`id`, `create_dt`, `modify_dt`, `delete_dt`, `commit_id`, `store_id`, `time_enum`, `start_dt`, `close_dt`, `has_zone`, `has_date`, `has_time`)
VALUES ('111', '2019-12-30 00:00:00', '2020-01-13 15:20:05', '1000-01-01 00:00:00', '100', '2800002', '1200202', '1000-01-01 08:00:00', '1000-01-01 23:00:00', '0', '0', '1');

INSERT INTO `liangcenter_release`.`ctr_store_timing` (`id`, `create_dt`, `modify_dt`, `delete_dt`, `commit_id`, `store_id`, `time_enum`, `start_dt`, `close_dt`, `has_zone`, `has_date`, `has_time`)
VALUES ('112', '2019-12-30 00:00:00', '2020-01-13 15:20:05', '1000-01-01 00:00:00', '100', '2800002', '1200203', '1000-01-01 08:00:00', '1000-01-01 23:00:00', '0', '0', '1');

-- TRUNCATE TABLE `ctr_account_balance`;
-- INSERT INTO `ctr_account_balance`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`account_id`,`money_type`,`currency`,`balance`,`credit`,`status`)
-- VALUES('0',now(), now(), '1000-01-01', 0, 0, 5510101, 'CNY', 0, 2147483647, 5520201),
--      ('1',now(), now(), '1000-01-01', 0, 1, 5510101, 'CNY', 0, 2147483647, 5520201)
-- ;

-- ok ,well done alex!
