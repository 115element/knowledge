-- 说明 [新增一个方案]
-- 脚本执行会自动把ctr_scenario_store表:
-- 2800001店对应的方案 》》》修改为310003方案

UPDATE `ctr_scenario_store` SET `scenario_id` = 3100003 WHERE `store_id` = 2800001;

REPLACE INTO `ctr_scenario`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`name`,`desc`,`img_advt`,`currency`,`status`)
VALUES(3100003, now(), now(), '1000-01-01', 0, '上海地区通用方案2', '', 'http://static.lianglife.com/HomePage/20200330.png', 'CNY', 3710102);

REPLACE INTO `ctr_scenario_region`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`region_id`,`store_type`,`place_type`)
VALUES(4000002, now(), now(), '1000-01-01', 0, 3100003, 1000900, 4010201, 4010304);

-- TRUNCATE TABLE `ctr_scenario_menu`;
REPLACE INTO `ctr_scenario_menu`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`name`,`img_icon`,`desc`,`visible`,`topmenu`,`ranking`)
VALUES(37010, now(), now(), '1000-01-01', 0, 3100003, '套餐',    'http://static.lianglife.com/BroadSideIcon/comboMeal.png', '', true, false, 1),
      (37011, now(), now(), '1000-01-01', 0, 3100003, '脆卷饼',   'http://static.lianglife.com/BroadSideIcon/crispyRoll.png', '', true, false, 2),
      (37012, now(), now(), '1000-01-01', 0, 3100003, '蛋卷饼',   'http://static.lianglife.com/BroadSideIcon/eggPie.png', '', true, false, 3),
      (37013, now(), now(), '1000-01-01', 0, 3100003, '吐司',    'http://static.lianglife.com/BroadSideIcon/toast.png', '', true, false, 4),
      (37014, now(), now(), '1000-01-01', 0, 3100003, '炒饭',    'http://static.lianglife.com/BroadSideIcon/rice.png', '', true, false, 5),
      (37015, now(), now(), '1000-01-01', 0, 3100003, '汤类',    'http://static.lianglife.com/BroadSideIcon/soup.png', '', true, false, 6),
      (37016, now(), now(), '1000-01-01', 0, 3100003, '热饮',    'http://static.lianglife.com/BroadSideIcon/hotDrinks.png', '', true, false, 7),
      (37017, now(), now(), '1000-01-01', 0, 3100003, '冷饮',    'http://static.lianglife.com/BroadSideIcon/coldSparklingWater.png', '', true, false, 8)
;


REPLACE INTO `ctr_product_category`(`id`,`parent_id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`name`,`status`)
VALUES(20020, 0, now(), now(), '1000-01-01', 0, '脆卷饼',   3020102),
      (20021, 0, now(), now(), '1000-01-01', 0, '蛋卷饼',   3020102),
      (20022, 0, now(), now(), '1000-01-01', 0, '吐司',    3020102),
      (20023, 0, now(), now(), '1000-01-01', 0, '炒饭',    3020102),
      (20024, 0, now(), now(), '1000-01-01', 0, '汤品',    3020102),
      (20025, 0, now(), now(), '1000-01-01', 0, '热饮',    3020102),
      (20026, 0, now(), now(), '1000-01-01', 0, '冷饮',    3020102)
;

REPLACE INTO `ctr_product`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`buyer_raw`,`prodcate_id`,`img_icon`,`img_mini`,`img_face`,`send_out`,`status`,`name`,`alias`,`desc`)
      -- 脆卷饼
VALUES(2200, now(), now(), '1000-01-01', 0,0, 20020, '',        '',        '', true, 3010101, '香嫩雪花牛肉脆卷饼',   '', ''),
      (2201, now(), now(), '1000-01-01', 0,0, 20020, '',        '',        '', true, 3010101, '德式风味铁板鸡脆卷饼',    '', ''),
      (2202, now(), now(), '1000-01-01', 0,0, 20020, '',        '',        '', true, 3010101, '粤式虾松脆卷饼',  '', ''),
      (2203, now(), now(), '1000-01-01', 0,0, 20020, '',        '',        '', true, 3010101, '京都铁板辣烧肉脆卷饼',      '', ''),
      (2204, now(), now(), '1000-01-01', 0,0, 20020, '',        '',        '', true, 3010101, '果木烟熏铁板鸭胸脆卷饼',      '', ''),
      (2205, now(), now(), '1000-01-01', 0,0, 20020, '',        '',        '', true, 3010101, '百汇香烤串串手撕脆卷饼',    '', ''),
      (2206, now(), now(), '1000-01-01', 0,0, 20020, '',        '',        '', true, 3010101, '另加脆卷饼(不可单点)',    '', ''),
      -- 蛋卷饼
      (2207, now(), now(), '1000-01-01', 0,0, 20021, '',        '',        '', true, 3010101, '日式铁板辣烧肉蛋卷饼',      '', ''),
      (2208, now(), now(), '1000-01-01', 0,0, 20021, '',        '',        '', true, 3010101, '香煎培根芝士蛋卷饼',      '', ''),
      (2209, now(), now(), '1000-01-01', 0,0, 20021, '',        '',        '', true, 3010101, '香酥肉松芝士蛋卷饼',      '', ''),
      -- 吐司
      (2210, now(), now(), '1000-01-01', 0,0, 20022, '',        '',        '', true, 3010101, '西冷牛排蛋铁板吐司',     '', ''),
      (2211, now(), now(), '1000-01-01', 0,0, 20022, '',        '',        '', true, 3010101, '嫩煎猪排蛋铁板吐司',     '', ''),
      (2212, now(), now(), '1000-01-01', 0,0, 20022, '',        '',        '', true, 3010101, '香煎培根蛋吐司',     '', ''),
      (2213, now(), now(), '1000-01-01', 0,0, 20022, '',        '',        '', true, 3010101, '香酥肉松蛋吐司',     '', ''),
      -- 炒饭
      (2214, now(), now(), '1000-01-01', 0,0, 20023, '',        '',        '', true, 3010101, '风味鸡肉铁板蛋炒饭',     '', ''),
      (2215, now(), now(), '1000-01-01', 0,0, 20023, '',        '',        '', true, 3010101, '黑松露鸭胸铁板蛋炒饭',     '', ''),
      (2216, now(), now(), '1000-01-01', 0,0, 20023, '',        '',        '', true, 3010101, '罗勒辣烧肉蛋炒饭',     '', ''),
      -- 汤品
      (2217, now(), now(), '1000-01-01', 0,0, 20024, '',        '',        '', true, 3010101, '脆骨肉丸萝卜汤',     '', ''),
      (2218, now(), now(), '1000-01-01', 0,0, 20024, '',        '',        '', true, 3010101, '上海鲜嫩鸡汤',     '', ''),
      (2219, now(), now(), '1000-01-01', 0,0, 20024, '',        '',        '', true, 3010101, '老坛酸菜雪花牛肉汤',     '', ''),
      (2220, now(), now(), '1000-01-01', 0,0, 20024, '',        '',        '', true, 3010101, '咖喱油豆腐粉丝汤',     '', ''),
      -- 热饮
      (2221, now(), now(), '1000-01-01', 0,0, 20025, '',        '',        '', true, 3010101, '风味米浆',     '', ''),
      (2222, now(), now(), '1000-01-01', 0,0, 20025, '',        '',        '', true, 3010101, '原味豆浆',     '', ''),
      (2223, now(), now(), '1000-01-01', 0,0, 20025, '',        '',        '', true, 3010101, '港式奶茶',     '', ''),
      (2224, now(), now(), '1000-01-01', 0,0, 20025, '',        '',        '', true, 3010101, '玫瑰乌龙',     '', ''),
      -- 冷饮
      (2225, now(), now(), '1000-01-01', 0,0, 20026, '',        '',        '', true, 3010101, '冰原味豆浆',     '', ''),
      (2226, now(), now(), '1000-01-01', 0,0, 20026, '',        '',        '', true, 3010101, '冰港式奶茶',     '', ''),
      (2227, now(), now(), '1000-01-01', 0,0, 20026, '',        '',        '', true, 3010101, '水蜜桃冻饮',     '', ''),
      (2228, now(), now(), '1000-01-01', 0,0, 20026, '',        '',        '', true, 3010101, '百香果绿茶',     '', '')
;

REPLACE INTO `ctr_commodity`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`product_id`,`status`,`img_icon`,`img_mini`,`img_face`,`name`)
VALUES(2400, now(), now(), '1000-01-01', 0, 2200, 2530103, 'http://static.lianglife.com/march/roll/xuehuaniurouR_b.png',         'http://static.lianglife.com/march/roll/xuehuaniurouR_b.png',         'http://static.lianglife.com/march/roll/xuehuaniurouR_d.png',   '香嫩雪花牛肉脆卷饼'),
      (2401, now(), now(), '1000-01-01', 0, 2201, 2530103, 'http://static.lianglife.com/march/roll/jirouR_b.png',         'http://static.lianglife.com/march/roll/jirouR_b.png',         'http://static.lianglife.com/march/roll/jirouR_d.png',   '德式风味铁板鸡脆卷饼'),
      (2402, now(), now(), '1000-01-01', 0, 2202, 2530103, 'http://static.lianglife.com/march/roll/xiasongR_b.png',         'http://static.lianglife.com/march/roll/xiasongR_b.png',         'http://static.lianglife.com/march/roll/xiasongR_d.png',   '粤式虾松脆卷饼'),
      (2403, now(), now(), '1000-01-01', 0, 2203, 2530103, 'http://static.lianglife.com/march/roll/shaorouR_b.png',         'http://static.lianglife.com/march/roll/shaorouR_b.png',         'http://static.lianglife.com/march/roll/shaorouR_d.png',   '京都铁板辣烧肉脆卷饼'),
      (2404, now(), now(), '1000-01-01', 0, 2204, 2530103, 'http://static.lianglife.com/march/roll/yarouR_b.png',         'http://static.lianglife.com/march/roll/yarouR_b.png',         'http://static.lianglife.com/march/roll/yarouR_d.png',   '果木烟熏铁板鸭胸脆卷饼'),
      (2405, now(), now(), '1000-01-01', 0, 2205, 2530103, 'http://static.lianglife.com/march/roll/chuanchuanR_b.png',         'http://static.lianglife.com/march/roll/chuanchuanR_b.png',         'http://static.lianglife.com/march/roll/chuanchuanR_d.png',   '百汇香烤串串手撕脆卷饼'),
      (2406, now(), now(), '1000-01-01', 0, 2206, 2530103, 'http://static.lianglife.com/march/bing/danbin_b.png',         'http://static.lianglife.com/march/bing/danbin_b.png',         'http://static.lianglife.com/march/bing/danbin_d.png',   '另加脆卷饼(不可单点)'),
      (2407, now(), now(), '1000-01-01', 0, 2207, 2530103, 'http://static.lianglife.com/march/omelette/lashaorouO_b.png',         'http://static.lianglife.com/march/omelette/lashaorouO_b.png',         'http://static.lianglife.com/march/omelette/lashaorouO_d.png',   '日式铁板辣烧肉蛋卷饼'),
      (2408, now(), now(), '1000-01-01', 0, 2208, 2530103, 'http://static.lianglife.com/march/omelette/peigenO_b.png',         'http://static.lianglife.com/march/omelette/peigenO_b.png',         'http://static.lianglife.com/march/omelette/peigenO_d.png',   '香煎培根芝士蛋卷饼'),
      (2409, now(), now(), '1000-01-01', 0, 2209, 2530103, 'http://static.lianglife.com/march/omelette/rousongO_b.png',         'http://static.lianglife.com/march/omelette/rousongO_b.png',         'http://static.lianglife.com/march/omelette/rousongO_d.png',   '香酥肉松芝士蛋卷饼'),
      (2410, now(), now(), '1000-01-01', 0, 2210, 2530103, 'http://static.lianglife.com/march/toast/niupaiT_b.png',         'http://static.lianglife.com/march/toast/niupaiT_b.png',         'http://static.lianglife.com/march/toast/niupaiT_d.png',   '西冷牛排蛋铁板吐司'),
      (2411, now(), now(), '1000-01-01', 0, 2211, 2530103, 'http://static.lianglife.com/march/toast/zhupaiT_b.png',         'http://static.lianglife.com/march/toast/zhupaiT_b.png',         'http://static.lianglife.com/march/toast/zhupaiT_d.png',   '嫩煎猪排蛋铁板吐司'),
      (2412, now(), now(), '1000-01-01', 0, 2212, 2530103, 'http://static.lianglife.com/march/toast/peigenT_b.png',         'http://static.lianglife.com/march/toast/peigenT_b.png',         'http://static.lianglife.com/march/toast/peigenT_d.png',   '香煎培根蛋吐司'),
      (2413, now(), now(), '1000-01-01', 0, 2213, 2530103, 'http://static.lianglife.com/march/toast/rousongT_b.png',         'http://static.lianglife.com/march/toast/rousongT_b.png',         'http://static.lianglife.com/march/toast/rousongT_d.png',   '香酥肉松蛋吐司'),
      (2414, now(), now(), '1000-01-01', 0, 2214, 2530103, 'http://static.lianglife.com/march/rice/jiroufan_b.png',         'http://static.lianglife.com/march/rice/jiroufan_b.png',         'http://static.lianglife.com/march/rice/jiroufan_d.png',   '风味鸡肉铁板蛋炒饭'),
      (2415, now(), now(), '1000-01-01', 0, 2215, 2530103, 'http://static.lianglife.com/march/rice/yaroufan_b.png',         'http://static.lianglife.com/march/rice/yaroufan_b.png',         'http://static.lianglife.com/march/rice/yaroufan_d.png',   '黑松露鸭胸铁板蛋炒饭'),
      (2416, now(), now(), '1000-01-01', 0, 2216, 2530103, 'http://static.lianglife.com/march/rice/laroufan_b.png',         'http://static.lianglife.com/march/rice/laroufan_b.png',         'http://static.lianglife.com/march/rice/laroufan_d.png',   '罗勒辣烧肉蛋炒饭'),
      (2417, now(), now(), '1000-01-01', 0, 2217, 2530103, 'http://static.lianglife.com/march/soup/wanzitang_b.png',         'http://static.lianglife.com/march/soup/wanzitang_b.png',         'http://static.lianglife.com/march/soup/wanzitang_d.png',   '脆骨肉丸萝卜汤'),
      (2418, now(), now(), '1000-01-01', 0, 2218, 2530103, 'http://static.lianglife.com/march/soup/jiroutang_b.png',         'http://static.lianglife.com/march/soup/jiroutang_b.png',         'http://static.lianglife.com/march/soup/jiroutang_d.png',   '上海鲜嫩鸡汤'),
      (2419, now(), now(), '1000-01-01', 0, 2219, 2530103, 'http://static.lianglife.com/march/soup/niuroutang_b.png',         'http://static.lianglife.com/march/soup/niuroutang_b.png',         'http://static.lianglife.com/march/soup/niuroutang_d.png',   '老坛酸菜雪花牛肉汤'),
      (2420, now(), now(), '1000-01-01', 0, 2220, 2530103, 'http://static.lianglife.com/march/soup/doufutang_b.png',         'http://static.lianglife.com/march/soup/doufutang_b.png',         'http://static.lianglife.com/march/soup/doufutang_d.png',   '咖喱油豆腐粉丝汤'),
      (2421, now(), now(), '1000-01-01', 0, 2221, 2530103, 'http://static.lianglife.com/march/drink/mijiang_b.png',         'http://static.lianglife.com/march/drink/mijiang_b.png',         'http://static.lianglife.com/march/drink/mijiang_d.png',   '风味米浆'),
      (2422, now(), now(), '1000-01-01', 0, 2222, 2530103, 'http://static.lianglife.com/march/drink/doujiang_b.png',         'http://static.lianglife.com/march/drink/doujiang_b.png',         'http://static.lianglife.com/march/drink/doujiang_d.png',   '原味豆浆'),
      (2423, now(), now(), '1000-01-01', 0, 2223, 2530103, 'http://static.lianglife.com/march/drink/gangshinaicha_b.png',         'http://static.lianglife.com/march/drink/gangshinaicha_b.png',         'http://static.lianglife.com/march/drink/gangshinaicha_d.png',   '港式奶茶'),

      (2424, now(), now(), '1000-01-01', 0, 2224, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',         'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',         'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_d.png',   '玫瑰乌龙'),
      (2425, now(), now(), '1000-01-01', 0, 2225, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',         'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',         'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_d.png',   '冰原味豆浆'),
      (2426, now(), now(), '1000-01-01', 0, 2226, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',         'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',         'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_d.png',   '冰港式奶茶'),
      (2427, now(), now(), '1000-01-01', 0, 2227, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_b.png',         'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_b.png',         'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_d.png',   '水蜜桃冻饮'),
      (2428, now(), now(), '1000-01-01', 0, 2228, 2530103, 'http://static.lianglife.com/march/drink/baixiangguo_b.png',         'http://static.lianglife.com/march/drink/baixiangguo_b.png',         'http://static.lianglife.com/march/drink/baixiangguo_d.png',   '百香果绿茶')
;


REPLACE INTO `ctr_proposal`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`img_icon`,`img_mini`,`img_face`,`timezone`,`open_ldt`,`shut_ldt`,`price_list`,`price_sell`,`price_rule`,`status`,`ranking`,`sell_time`,`name`,`alias`,`desc`)
VALUES(3400, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/roll/xuehuaniurouR_b.png',   'http://static.lianglife.com/march/roll/xuehuaniurouR_b.png',   'http://static.lianglife.com/march/roll/xuehuaniurouR_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  1, '1200106', '香嫩雪花牛肉脆卷饼', '',''),
      (3401, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/roll/jirouR_b.png',   'http://static.lianglife.com/march/roll/jirouR_b.png',   'http://static.lianglife.com/march/roll/jirouR_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  2, '1200106', '德式风味铁板鸡脆卷饼', '',''),
      (3402, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/roll/xiasongR_b.png',   'http://static.lianglife.com/march/roll/xiasongR_b.png',   'http://static.lianglife.com/march/roll/xiasongR_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  3, '1200106', '粤式虾松脆卷饼', '',''),
      (3403, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/roll/shaorouR_b.png',   'http://static.lianglife.com/march/roll/shaorouR_b.png',   'http://static.lianglife.com/march/roll/shaorouR_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  4, '1200106', '京都铁板辣烧肉脆卷饼', '',''),
      (3404, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/roll/yarouR_b.png',   'http://static.lianglife.com/march/roll/yarouR_b.png',   'http://static.lianglife.com/march/roll/yarouR_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  5, '1200106', '果木烟熏铁板鸭胸脆卷饼', '',''),
      (3405, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/roll/chuanchuanR_b.png',   'http://static.lianglife.com/march/roll/chuanchuanR_b.png',   'http://static.lianglife.com/march/roll/chuanchuanR_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  6, '1200106', '百汇香烤串串手撕脆卷饼', '',''),
      (3406, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/bing/danbin_b.png',   'http://static.lianglife.com/march/bing/danbin_b.png',   'http://static.lianglife.com/march/bing/danbin_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  7, '1200106', '另加脆卷饼(不可单点)', '',''),
      (3407, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/omelette/lashaorouO_b.png',   'http://static.lianglife.com/march/omelette/lashaorouO_b.png',   'http://static.lianglife.com/march/omelette/lashaorouO_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  8, '1200106', '日式铁板辣烧肉蛋卷饼', '',''),
      (3408, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/omelette/peigenO_b.png',   'http://static.lianglife.com/march/omelette/peigenO_b.png',   'http://static.lianglife.com/march/omelette/peigenO_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  9, '1200106', '香煎培根芝士蛋卷饼', '',''),
      (3409, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/omelette/rousongO_b.png',   'http://static.lianglife.com/march/omelette/rousongO_b.png',   'http://static.lianglife.com/march/omelette/rousongO_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  10, '1200106', '香酥肉松芝士蛋卷饼', '',''),
      (3410, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/toast/niupaiT_b.png',   'http://static.lianglife.com/march/toast/niupaiT_b.png',   'http://static.lianglife.com/march/toast/niupaiT_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  11, '1200106', '西冷牛排蛋铁板吐司', '',''),
      (3411, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/toast/zhupaiT_b.png',   'http://static.lianglife.com/march/toast/zhupaiT_b.png',   'http://static.lianglife.com/march/toast/zhupaiT_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  12, '1200106', '嫩煎猪排蛋铁板吐司', '',''),
      (3412, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/toast/peigenT_b.png',   'http://static.lianglife.com/march/toast/peigenT_b.png',   'http://static.lianglife.com/march/toast/peigenT_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  13, '1200106', '香煎培根蛋吐司', '',''),
      (3413, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/toast/rousongT_b.png',   'http://static.lianglife.com/march/toast/rousongT_b.png',   'http://static.lianglife.com/march/toast/rousongT_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  14, '1200106', '香酥肉松蛋吐司', '',''),
      (3414, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/rice/jiroufan_b.png',   'http://static.lianglife.com/march/rice/jiroufan_b.png',   'http://static.lianglife.com/march/rice/jiroufan_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  15, '1200106', '风味鸡肉铁板蛋炒饭', '',''),
      (3415, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/rice/yaroufan_b.png',   'http://static.lianglife.com/march/rice/yaroufan_b.png',   'http://static.lianglife.com/march/rice/yaroufan_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  16, '1200106', '黑松露鸭胸铁板蛋炒饭', '',''),
      (3416, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/rice/laroufan_b.png',   'http://static.lianglife.com/march/rice/laroufan_b.png',   'http://static.lianglife.com/march/rice/laroufan_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  17, '1200106', '罗勒辣烧肉蛋炒饭', '',''),
      (3417, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/soup/wanzitang_b.png',   'http://static.lianglife.com/march/soup/wanzitang_b.png',   'http://static.lianglife.com/march/soup/wanzitang_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  18, '1200106', '脆骨肉丸萝卜汤', '',''),
      (3418, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/soup/jiroutang_b.png',   'http://static.lianglife.com/march/soup/jiroutang_b.png',   'http://static.lianglife.com/march/soup/jiroutang_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  19, '1200106', '上海鲜嫩鸡汤', '',''),
      (3419, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/soup/niuroutang_b.png',   'http://static.lianglife.com/march/soup/niuroutang_b.png',   'http://static.lianglife.com/march/soup/niuroutang_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  20, '1200106', '老坛酸菜雪花牛肉汤', '',''),
      (3420, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/soup/doufutang_b.png',   'http://static.lianglife.com/march/soup/doufutang_b.png',   'http://static.lianglife.com/march/soup/doufutang_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  21, '1200106', '咖喱油豆腐粉丝汤', '',''),
      (3421, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/drink/mijiang_b.png',   'http://static.lianglife.com/march/drink/mijiang_b.png',   'http://static.lianglife.com/march/drink/mijiang_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  22, '1200106', '风味米浆', '',''),
      (3422, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/drink/doujiang_b.png',   'http://static.lianglife.com/march/drink/doujiang_b.png',   'http://static.lianglife.com/march/drink/doujiang_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  23, '1200106', '原味豆浆', '',''),
      (3423, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/drink/gangshinaicha_b.png',   'http://static.lianglife.com/march/drink/gangshinaicha_b.png',   'http://static.lianglife.com/march/drink/gangshinaicha_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  24, '1200106', '港式奶茶', '',''),

       -- 套餐
      (3424, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/combomeal/niuroujitang_b.png',   'http://static.lianglife.com/march/combomeal/niuroujitang_b.png',   'http://static.lianglife.com/march/combomeal/niuroujitang_d.png', 10100, '2019-10-1', '2029-10-1', 32, 32, 3510202, 3510101,  25, '1200106', '香嫩雪花牛肉脆卷饼套餐', '',''),
      (3425, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/combomeal/jirouwan_b.png',   'http://static.lianglife.com/march/combomeal/jirouwan_b.png',   'http://static.lianglife.com/march/combomeal/jirouwan_d.png', 10100, '2019-10-1', '2029-10-1', 32, 32, 3510202, 3510101,  26, '1200106', '德式风味铁板鸡脆卷饼套餐', '',''),
      (3426, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/combomeal/yaroujitang_b.png',   'http://static.lianglife.com/march/combomeal/yaroujitang_b.png',   'http://static.lianglife.com/march/combomeal/yaroujitang_d.png', 10100, '2019-10-1', '2029-10-1', 32, 32, 3510202, 3510101,  27, '1200106', '黑松露鸭胸铁板蛋炒饭套餐', '',''),
      (3427, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/combomeal/jiroudoufu_b.png',   'http://static.lianglife.com/march/combomeal/jiroudoufu_b.png',   'http://static.lianglife.com/march/combomeal/jiroudoufu_d.png', 10100, '2019-10-1', '2029-10-1', 30, 30, 3510202, 3510101,  28, '1200106', '风味鸡肉铁板蛋炒饭套餐', '',''),
      (3428, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/combomeal/niupainaicha_b.png',   'http://static.lianglife.com/march/combomeal/niupainaicha_b.png',   'http://static.lianglife.com/march/combomeal/niupainaicha_d.png', 10100, '2019-10-1', '2029-10-1', 32, 32, 3510202, 3510101,  29, '1200106', '西冷牛排蛋铁板吐司套餐', '',''),
      (3429, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/combomeal/rousongdoujiang_b.png',   'http://static.lianglife.com/march/combomeal/rousongdoujiang_b.png',   'http://static.lianglife.com/march/combomeal/rousongdoujiang_d.png', 10100, '2019-10-1', '2029-10-1', 26, 26, 3510202, 3510101,  30, '1200106', '香酥肉松蛋吐司套餐', '',''),
      (3430, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/combomeal/peigendoujiang_b.png',   'http://static.lianglife.com/march/combomeal/peigendoujiang_b.png',   'http://static.lianglife.com/march/combomeal/peigendoujiang_d.png', 10100, '2019-10-1', '2029-10-1', 24, 24, 3510202, 3510101,  31, '1200106', '香煎培根芝士蛋卷饼套餐', '',''),
      (3431, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/combomeal/rousongmijiang_b.png',   'http://static.lianglife.com/march/combomeal/rousongmijiang_b.png',   'http://static.lianglife.com/march/combomeal/rousongmijiang_d.png', 10100, '2019-10-1', '2029-10-1', 22, 22, 3510202, 3510101,  32, '1200106', '香酥肉松芝士蛋卷饼套餐', '',''),

      (3432, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',         'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',         'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  33, '1200106', '玫瑰乌龙', '',''),
      (3433, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',         'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',         'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  34, '1200106', '冰原味豆浆', '',''),
      (3434, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',         'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',         'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  35, '1200106', '冰港式奶茶', '',''),
      (3435, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_b.png',         'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_b.png',         'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  36, '1200106', '水蜜桃冻饮', '',''),
      (3436, now(), now(), '1000-01-01', 0, 3100003, 'http://static.lianglife.com/march/drink/baixiangguo_b.png',         'http://static.lianglife.com/march/drink/baixiangguo_b.png',         'http://static.lianglife.com/march/drink/baixiangguo_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  37, '1200106', '百香果绿茶', '','')
;


REPLACE INTO `ctr_proposal_commodity`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`bundle_id`,`product_id`,`commodity_id`,`price_list`,`price_sell`,`buy_min`,`buy_max`,`show_price`,`selected`,`ranking`,`name`)
VALUES(3700, now(), now(), '1000-01-01', 0, 3400 ,0, 2200, 2400, 25, 25, 1, 1, true, true, 1, '香嫩雪花牛肉脆卷饼'),
      (3701, now(), now(), '1000-01-01', 0, 3401 ,0, 2201, 2401, 22, 22, 1, 1, true, true, 2, '德式风味铁板鸡脆卷饼'),
      (3702, now(), now(), '1000-01-01', 0, 3402 ,0, 2202, 2402, 25, 25, 1, 1, true, true, 3, '粤式虾松脆卷饼'),
      (3703, now(), now(), '1000-01-01', 0, 3403 ,0, 2203, 2403, 22, 22, 1, 1, true, true, 4, '京都铁板辣烧肉脆卷饼'),
      (3704, now(), now(), '1000-01-01', 0, 3404 ,0, 2204, 2404, 22, 22, 1, 1, true, true, 5, '果木烟熏铁板鸭胸脆卷饼'),
      (3705, now(), now(), '1000-01-01', 0, 3405 ,0, 2205, 2405, 25, 25, 1, 1, true, true, 6, '百汇香烤串串手撕脆卷饼'),
      (3706, now(), now(), '1000-01-01', 0, 3406 ,0, 2206, 2406, 5, 5, 1, 1, true, true,  7, '另加脆卷饼（不可单点）'),
      (3707, now(), now(), '1000-01-01', 0, 3407 ,0, 2207, 2407, 18, 18, 1, 1, true, true,  8, '日式铁板辣烧肉蛋卷饼'),
      (3708, now(), now(), '1000-01-01', 0, 3408 ,0, 2208, 2408, 18, 18, 1, 1, true, true, 9, '香煎培根芝士蛋卷饼'),
      (3709, now(), now(), '1000-01-01', 0, 3409 ,0, 2209, 2409, 18, 18, 1, 1, true, true, 10, '香酥肉松芝士蛋卷饼'),
      (3710, now(), now(), '1000-01-01', 0, 3410 ,0, 2210, 2410, 25, 25, 1, 1, true, true, 11, '西冷牛排蛋铁板吐司'),
      (3711, now(), now(), '1000-01-01', 0, 3411 ,0, 2211, 2411, 25, 25, 1, 1, true, true, 12, '嫩煎猪排蛋铁板吐司'),
      (3712, now(), now(), '1000-01-01', 0, 3412 ,0, 2212, 2412, 20, 20, 1, 1, true, true, 13, '香煎培根蛋吐司'),
      (3713, now(), now(), '1000-01-01', 0, 3413 ,0, 2213, 2413, 20, 20, 1, 1, true, true, 14, '香酥肉松蛋吐司'),
      (3714, now(), now(), '1000-01-01', 0, 3414 ,0, 2214, 2414, 25, 25, 1, 1, true, true, 15, '风味鸡肉铁板蛋炒饭'),
      (3715, now(), now(), '1000-01-01', 0, 3415 ,0, 2215, 2415, 25, 25, 1, 1, true, true, 16, '黑松露鸭胸铁板蛋炒饭'),
      (3716, now(), now(), '1000-01-01', 0, 3416 ,0, 2216, 2416, 25, 25, 1, 1, true, true, 17, '罗勒辣烧肉蛋炒饭'),
      (3717, now(), now(), '1000-01-01', 0, 3417 ,0, 2217, 2417, 16, 16, 1, 1, true, true, 18, '脆骨肉丸萝卜汤'),
      (3718, now(), now(), '1000-01-01', 0, 3418 ,0, 2218, 2418, 16, 16, 1, 1, true, true, 19, '上海鲜嫩鸡汤'),
      (3719, now(), now(), '1000-01-01', 0, 3419 ,0, 2219, 2419, 16, 16, 1, 1, true, true, 20, '老坛酸菜雪花牛肉汤'),
      (3720, now(), now(), '1000-01-01', 0, 3420 ,0, 2220, 2420, 12, 12, 1, 1, true, true, 21, '咖喱油豆腐粉丝汤'),
      (3721, now(), now(), '1000-01-01', 0, 3421 ,0, 2221, 2421, 8, 8, 1, 1, true, true, 22, '风味米浆'),
      (3722, now(), now(), '1000-01-01', 0, 3422 ,0, 2222, 2422, 8, 8, 1, 1, true, true, 23, '原味豆浆'),
      (3723, now(), now(), '1000-01-01', 0, 3423 ,0, 2223, 2423, 12, 12, 1, 1, true, true, 24, '港式奶茶'),

      -- 八个套餐数据

      -- 套餐1
      (3724, now(), now(), '1000-01-01', 0, 3424 ,3920, 2200, 2400, 0, 0, 1, 1, true, true, 25, '香嫩雪花牛肉脆卷饼'),
      (3725, now(), now(), '1000-01-01', 0, 3424 ,3920, 2218, 2418, 0, 0, 1, 1, true, true, 26, '上海鲜嫩鸡汤'),
      -- 套餐2
      (3726, now(), now(), '1000-01-01', 0, 3425 ,3921, 2201, 2401, 0, 0, 1, 1, true, true, 27, '德式风味铁板鸡脆卷饼'),
      (3727, now(), now(), '1000-01-01', 0, 3425 ,3921, 2217, 2417, 0, 0, 1, 1, true, true, 28, '脆骨肉丸萝卜汤'),
      -- 套餐3
      (3728, now(), now(), '1000-01-01', 0, 3426 ,3922, 2215, 2415, 0, 0, 1, 1, true, true, 29, '黑松露鸭胸铁板蛋炒饭'),
      (3729, now(), now(), '1000-01-01', 0, 3426 ,3922, 2218, 2418, 0, 0, 1, 1, true, true, 30, '上海鲜嫩鸡汤'),
      -- 套餐4（不含加价购）
      (3730, now(), now(), '1000-01-01', 0, 3427 ,3923, 2214, 2414, 0, 0, 1, 1, true, true, 31, '风味鸡肉铁板蛋炒饭'),
      (3731, now(), now(), '1000-01-01', 0, 3427 ,3923, 2220, 2420, 0, 0, 1, 1, true, true, 32, '咖喱油豆腐粉丝汤'),
      -- 套餐5（不含加价购）
      (3732, now(), now(), '1000-01-01', 0, 3428 ,3924, 2210, 2410, 0, 0, 1, 1, true, true, 33, '西冷牛排蛋铁板吐司'),
      (3733, now(), now(), '1000-01-01', 0, 3428 ,3924, 2223, 2423, 0, 0, 1, 1, true, true, 34, '冰港式奶茶'),
      -- 套餐6（不含加价购）
      (3734, now(), now(), '1000-01-01', 0, 3429 ,3925, 2213, 2413, 0, 0, 1, 1, true, true, 35, '香酥肉松蛋吐司'),
      (3735, now(), now(), '1000-01-01', 0, 3429 ,3925, 2222, 2422, 0, 0, 1, 1, true, true, 36, '原味豆浆'),
      -- 套餐7（不含加价购）
      (3736, now(), now(), '1000-01-01', 0, 3430 ,3926, 2208, 2408, 0, 0, 1, 1, true, true, 37, '香煎培根芝士蛋卷饼'),
      (3737, now(), now(), '1000-01-01', 0, 3430 ,3926, 2222, 2422, 0, 0, 1, 1, true, true, 38, '原味豆浆'),
      -- 套餐8
      (3738, now(), now(), '1000-01-01', 0, 3431 ,3927, 2209, 2409, 0, 0, 1, 1, true, true, 39, '香酥肉松芝士蛋卷饼'),
      (3739, now(), now(), '1000-01-01', 0, 3431 ,3927, 2221, 2421, 0, 0, 1, 1, true, true, 40, '風味米浆'),

      (3740, now(), now(), '1000-01-01', 0, 3432 ,0, 2224, 2424, 12, 12, 1, 1, true, true, 41, '玫瑰乌龙'),
      (3741, now(), now(), '1000-01-01', 0, 3433 ,0, 2225, 2425, 8, 8, 1, 1, true, true, 42, '冰原味豆浆'),
      (3742, now(), now(), '1000-01-01', 0, 3434 ,0, 2226, 2426, 12, 12, 1, 1, true, true, 43, '冰港式奶茶'),
      (3743, now(), now(), '1000-01-01', 0, 3435 ,0, 2227, 2427, 12, 12, 1, 1, true, true, 44, '水蜜桃冻饮'),
      (3744, now(), now(), '1000-01-01', 0, 3436 ,0, 2228, 2428, 12, 12, 1, 1, true, true, 45, '百香果绿茶')
;

REPLACE INTO `ctr_proposal_bundle`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`name`,`buy_num`,`ranking`)
VALUES(3920, now(), now(), '1000-01-01', 0, 3424, '必选', 1, 1),
      (3921, now(), now(), '1000-01-01', 0, 3425, '必选', 1, 1),
      (3922, now(), now(), '1000-01-01', 0, 3426, '必选', 1, 1),
      (3923, now(), now(), '1000-01-01', 0, 3427, '必选', 1, 1),
      (3924, now(), now(), '1000-01-01', 0, 3428, '必选', 1, 1),
      (3925, now(), now(), '1000-01-01', 0, 3429, '必选', 1, 1),
      (3926, now(), now(), '1000-01-01', 0, 3430, '必选', 1, 1),
      (3927, now(), now(), '1000-01-01', 0, 3431, '必选', 1, 1)
;

REPLACE INTO `ctr_proposal_menu`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`scenmenu_id`)
VALUES(3901, now(), now(), '1000-01-01', 0, 3400, 37011),
      (3902, now(), now(), '1000-01-01', 0, 3401, 37011),
      (3903, now(), now(), '1000-01-01', 0, 3402, 37011),
      (3904, now(), now(), '1000-01-01', 0, 3403, 37011),
      (3905, now(), now(), '1000-01-01', 0, 3404, 37011),
      (3906, now(), now(), '1000-01-01', 0, 3405, 37011),
      (3907, now(), now(), '1000-01-01', 0, 3406, 37011),
      (3908, now(), now(), '1000-01-01', 0, 3407, 37012),
      (3909, now(), now(), '1000-01-01', 0, 3408, 37012),
      (3910, now(), now(), '1000-01-01', 0, 3409, 37012),
      (3911, now(), now(), '1000-01-01', 0, 3410, 37013),
      (3912, now(), now(), '1000-01-01', 0, 3411, 37013),
      (3913, now(), now(), '1000-01-01', 0, 3412, 37013),
      (3914, now(), now(), '1000-01-01', 0, 3413, 37013),
      (3915, now(), now(), '1000-01-01', 0, 3414, 37014),
      (3916, now(), now(), '1000-01-01', 0, 3415, 37014),
      (3917, now(), now(), '1000-01-01', 0, 3416, 37014),
      (3918, now(), now(), '1000-01-01', 0, 3417, 37015),
      (3919, now(), now(), '1000-01-01', 0, 3418, 37015),
      (3920, now(), now(), '1000-01-01', 0, 3419, 37015),
      (3921, now(), now(), '1000-01-01', 0, 3420, 37015),
      (3922, now(), now(), '1000-01-01', 0, 3421, 37016),
      (3923, now(), now(), '1000-01-01', 0, 3422, 37016),
      (3924, now(), now(), '1000-01-01', 0, 3423, 37016),
      -- 八个套餐
      (3925, now(), now(), '1000-01-01', 0, 3424, 37010),
      (3926, now(), now(), '1000-01-01', 0, 3425, 37010),
      (3927, now(), now(), '1000-01-01', 0, 3426, 37010),
      (3928, now(), now(), '1000-01-01', 0, 3427, 37010),
      (3929, now(), now(), '1000-01-01', 0, 3428, 37010),
      (3930, now(), now(), '1000-01-01', 0, 3429, 37010),
      (3931, now(), now(), '1000-01-01', 0, 3430, 37010),
      (3932, now(), now(), '1000-01-01', 0, 3431, 37010),

      (3933, now(), now(), '1000-01-01', 0, 3432, 37016),
      (3934, now(), now(), '1000-01-01', 0, 3433, 37017),
      (3935, now(), now(), '1000-01-01', 0, 3434, 37017),
      (3936, now(), now(), '1000-01-01', 0, 3435, 37017),
      (3937, now(), now(), '1000-01-01', 0, 3436, 37017)
;

-- ok ,well done alex!