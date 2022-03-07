-- 正式门店使用
-- 主键序列：2000, table: ctr_product_category
-- 主键序列：2100, table: ctr_product
-- 主键序列：2300, table: ctr_commodity
-- 主键序列：2400, table: ctr_material
-- 主键序列：2500, table: ctr_commodity_material
-- 主键序列：2600, table: ctr_product_choice
-- 主键序列：2700, table: ctr_product_option
-- --------
-- 主键序列：2800001， table ctr_store
-- 主键序列：3100， table ctr_scenario
-- 主键序列：4000， table ctr_scenario_region
-- 主键序列：3200， table ctr_scenario_store
-- 主键序列：3300， table ctr_proposal
-- 主键序列：3500， table ctr_proposal_commodity
-- 主键序列：3600， table ctr_proposal_option
-- 主键序列：3700， table ctr_scenario_menu
-- 主键序列：3800， table ctr_proposal_menu
-- 主键序列：3900， ctr_proposal_bundle

TRUNCATE TABLE `ctr_product_category`;
INSERT INTO `ctr_product_category`(`id`,`parent_id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`name`,`status`)
VALUES(2000, 0, now(), now(), '1000-01-01', 0, '脆饼卷', 3020102),
      (2001, 0, now(), now(), '1000-01-01', 0, '蛋饼卷', 3020102),
      (2002, 0, now(), now(), '1000-01-01', 0, 'Taco', 3020102),
      (2003, 0, now(), now(), '1000-01-01', 0, '吐司',   3020102),
      (2004, 0, now(), now(), '1000-01-01', 0, '薄脆',   3020102),
      (2005, 0, now(), now(), '1000-01-01', 0, '串',     3020102),
      (2006, 0, now(), now(), '1000-01-01', 0, '热饮',   3020102),
      (2007, 0, now(), now(), '1000-01-01', 0, '冷饮',   3020102),

      (2008, 0, now(), now(), '1000-01-01', 0, '早餐', 3020102),
      -- (2009, 0, now(), now(), '1000-01-01', 0, '脆饺',   3020102),

      (2010, 0, now(), now(), '1000-01-01', 0, '饭',    3020102),
      (2011, 0, now(), now(), '1000-01-01', 0, '汤',    3020102),
      (2012, 0, now(), now(), '1000-01-01', 0, '点心',   3020102),
      (2013, 0, now(), now(), '1000-01-01', 0, '风味小菜', 3020102),
      (2014, 0, now(), now(), '1000-01-01', 0, '风味酱',   3020102)
;

TRUNCATE TABLE `ctr_product`;
INSERT INTO `ctr_product`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`prodcate_id`,`img_icon`,`img_mini`,`img_face`,`send_out`,`status`,`name`,`alias`,`desc`)
       -- 脆饼卷
VALUES(2101, now(), now(), '1000-01-01', 0, 2000, '',        '',        '', true, 3010101, '(脆饼)酸辣辣土豆丝',   '', ''),
      (2102, now(), now(), '1000-01-01', 0, 2000, '',        '',        '', true, 3010101, '(脆饼)销魂烤鸡肉',     '', ''),
      (2103, now(), now(), '1000-01-01', 0, 2000, '',        '',        '', true, 3010101, '(脆饼)麻辣烤鸡',       '', ''),
      (2104, now(), now(), '1000-01-01', 0, 2000, '',        '',        '', true, 3010101, '(脆饼)果木烤鸭',       '', ''),
      (2105, now(), now(), '1000-01-01', 0, 2000, '',        '',        '', true, 3010101, '(脆饼)蜜汁叉烧',       '', ''),
      (2106, now(), now(), '1000-01-01', 0, 2000, '',        '',        '', true, 3010101, '(脆饼)欢辣泡菜五花肉',  '', ''),
      (2107, now(), now(), '1000-01-01', 0, 2000, '',        '',        '', true, 3010101, '(脆饼)老酸菜泡肥牛',    '', ''),
      (2108, now(), now(), '1000-01-01', 0, 2000, '',        '',        '', true, 3010101, '(脆饼)风情黑椒牛柳',    '', ''),
       -- 蛋饼卷
      (2109, now(), now(), '1000-01-01', 0, 2001, '',        '',        '', true, 3010101, '(蛋饼)酸辣辣土豆丝',  '', ''),
      (2110, now(), now(), '1000-01-01', 0, 2001, '',        '',        '', true, 3010101, '(蛋饼)销魂烤鸡肉',   '', ''),
      (2111, now(), now(), '1000-01-01', 0, 2001, '',        '',        '', true, 3010101, '(蛋饼)麻辣烤鸡',     '', ''),
      (2112, now(), now(), '1000-01-01', 0, 2001, '',        '',        '', true, 3010101, '(蛋饼)果木烤鸭',     '', ''),
      (2113, now(), now(), '1000-01-01', 0, 2001, '',        '',        '', true, 3010101, '(蛋饼)蜜汁叉烧',     '', ''),
      (2114, now(), now(), '1000-01-01', 0, 2001, '',        '',        '', true, 3010101, '(蛋饼)欢辣泡菜五花肉',  '', ''),
      (2115, now(), now(), '1000-01-01', 0, 2001, '',        '',        '', true, 3010101, '(蛋饼)老酸菜泡肥牛',    '', ''),
      (2116, now(), now(), '1000-01-01', 0, 2001, '',        '',        '', true, 3010101, '(蛋饼)风情黑椒牛柳',    '', ''),
       -- Taco
      (2117, now(), now(), '1000-01-01', 0, 2002, '',        '',        '', true, 3010101, '(Taco)酸辣辣土豆丝',  '', ''),
      (2118, now(), now(), '1000-01-01', 0, 2002, '',        '',        '', true, 3010101, '(Taco)销魂烤鸡肉',    '', ''),
      (2119, now(), now(), '1000-01-01', 0, 2002, '',        '',        '', true, 3010101, '(Taco)麻辣烤鸡',     '', ''),
      (2120, now(), now(), '1000-01-01', 0, 2002, '',        '',        '', true, 3010101, '(Taco)果木烤鸭',     '', ''),
      (2121, now(), now(), '1000-01-01', 0, 2002, '',        '',        '', true, 3010101, '(Taco)蜜汁叉烧',     '', ''),
      (2122, now(), now(), '1000-01-01', 0, 2002, '',        '',        '', true, 3010101, '(Taco)欢辣泡菜五花肉',  '', ''),
      (2123, now(), now(), '1000-01-01', 0, 2002, '',        '',        '', true, 3010101, '(Taco)老酸菜泡肥牛',    '', ''),
      (2124, now(), now(), '1000-01-01', 0, 2002, '',        '',        '', true, 3010101, '(Taco)风情黑椒牛柳',    '', ''),
       -- 吐司
      (2125, now(), now(), '1000-01-01', 0, 2003, '',        '',        '', true, 3010101, '(吐司)酸辣辣土豆丝',    '', ''),
      (2126, now(), now(), '1000-01-01', 0, 2003, '',        '',        '', true, 3010101, '(吐司)销魂烤鸡肉',     '', ''),
      (2127, now(), now(), '1000-01-01', 0, 2003, '',        '',        '', true, 3010101, '(吐司)麻辣烤鸡',      '', ''),
      (2128, now(), now(), '1000-01-01', 0, 2003, '',        '',        '', true, 3010101, '(吐司)果木烤鸭',      '', ''),
      (2129, now(), now(), '1000-01-01', 0, 2003, '',        '',        '', true, 3010101, '(吐司)蜜汁叉烧',       '', ''),
      (2130, now(), now(), '1000-01-01', 0, 2003, '',        '',        '', true, 3010101, '(吐司)欢辣泡菜五花肉',  '', ''),
      (2131, now(), now(), '1000-01-01', 0, 2003, '',        '',        '', true, 3010101, '(吐司)老酸菜泡肥牛',    '', ''),
      (2132, now(), now(), '1000-01-01', 0, 2003, '',        '',        '', true, 3010101, '(吐司)风情黑椒牛柳',    '', ''),
       -- 薄脆
      (2133, now(), now(), '1000-01-01', 0, 2004, '',        '',        '', true, 3010101, '(薄脆)麻辣烤鸡',     '', ''),
      (2134, now(), now(), '1000-01-01', 0, 2004, '',        '',        '', true, 3010101, '(薄脆)黑松露脆皮鸭',  '', ''),
       -- 串
      (2135, now(), now(), '1000-01-01', 0, 2005, '',        '',        '', true, 3010101, '一钵热煮',     '', ''),
      (2136, now(), now(), '1000-01-01', 0, 2005, '',        '',        '', true, 3010101, '一粒热煮',     '', ''),
       -- 热饮
      (2137, now(), now(), '1000-01-01', 0, 2006, '',        '',        '', true, 3010101, '经典豆浆',     '', ''),
      (2138, now(), now(), '1000-01-01', 0, 2006, '',        '',        '', true, 3010101, '香浓米浆',     '', ''),
      (2139, now(), now(), '1000-01-01', 0, 2006, '',        '',        '', true, 3010101, '养颜玫瑰乌龙',     '', ''),
      (2140, now(), now(), '1000-01-01', 0, 2006, '',        '',        '', true, 3010101, '港式丝袜奶茶',     '', ''),
       -- 冷饮
      (2141, now(), now(), '1000-01-01', 0, 2007, '',        '',        '', true, 3010101, '黑豆豆奶盖',     '', ''),
      (2142, now(), now(), '1000-01-01', 0, 2007, '',        '',        '', true, 3010101, '乌龙豆豆奶盖',    '', ''),
      (2143, now(), now(), '1000-01-01', 0, 2007, '',        '',        '', true, 3010101, '桃气泡泡',     '', ''),
      (2144, now(), now(), '1000-01-01', 0, 2007, '',        '',        '', true, 3010101, '莓力泡泡',     '', ''),
       -- 拿破仑
      (2145, now(), now(), '1000-01-01', 0, 2008, '',        '',        '', true, 3010101, '蛋香拿破仑',     '', ''),
       -- 脆饺
      (2146, now(), now(), '1000-01-01', 0, 2008, '',        '',        '', true, 3010101, '菌菇三鲜脆饺(4个)',     '', ''),
      (2147, now(), now(), '1000-01-01', 0, 2008, '',        '',        '', true, 3010101, '玉米鲜肉脆饺(4个)',  '', ''),
       -- 饭
      (2148, now(), now(), '1000-01-01', 0, 2010, '',        '',        '', true, 3010101, '田园蛋炒饭',       '', ''),
      (2149, now(), now(), '1000-01-01', 0, 2010, '',        '',        '', true, 3010101, '(炒饭)销魂烤鸡肉',  '', ''),
      (2150, now(), now(), '1000-01-01', 0, 2010, '',        '',        '', true, 3010101, '(炒饭)麻辣烤鸡',    '', ''),
      (2151, now(), now(), '1000-01-01', 0, 2010, '',        '',        '', true, 3010101, '(炒饭)黑松露脆皮鸭',  '', ''),
      (2152, now(), now(), '1000-01-01', 0, 2010, '',        '',        '', true, 3010101, '(饭)销魂烤鸡肉',     '', ''),
      (2153, now(), now(), '1000-01-01', 0, 2010, '',        '',        '', true, 3010101, '(饭)麻辣烤鸡',     '', ''),
      (2154, now(), now(), '1000-01-01', 0, 2010, '',        '',        '', true, 3010101, '(饭)果木烤鸭',     '', ''),
       -- 汤
      (2155, now(), now(), '1000-01-01', 0, 2011, '',        '',        '', true, 3010101, '松茸野菌汤',     '', ''),
      (2156, now(), now(), '1000-01-01', 0, 2011, '',        '',        '', true, 3010101, '老坛酸汤鱼',     '', ''),
      (2157, now(), now(), '1000-01-01', 0, 2011, '',        '',        '', true, 3010101, '金汤花胶烩灵芝',  '', ''),
      (2158, now(), now(), '1000-01-01', 0, 2011, '',        '',        '', true, 3010101, '甜藕煲排骨',     '', ''),
       -- 点心
      (2159, now(), now(), '1000-01-01', 0, 2012, '',        '',        '', true, 3010101, '爆浆黑沙酥(2个)', '', ''),
      (2160, now(), now(), '1000-01-01', 0, 2012, '',        '',        '', true, 3010101, 'QQ哒(3个)',     '', ''),
       -- 风味小菜
      (2161, now(), now(), '1000-01-01', 0, 2013, '',        '',        '', true, 3010101, '脆爽酸毛豆',     '', ''),
       -- 风味酱
      (2162, now(), now(), '1000-01-01', 0, 2014, '',        '',        '', true, 3010101, '虎邦蒜蓉辣椒酱',     '', ''),
      (2163, now(), now(), '1000-01-01', 0, 2014, '',        '',        '', true, 3010101, '虎邦鲁西牛肉酱',     '', ''),
      (2164, now(), now(), '1000-01-01', 0, 2014, '',        '',        '', true, 3010101, '太太笑香醋',     '', ''),
      (2165, now(), now(), '1000-01-01', 0, 2014, '',        '',        '', true, 3010101, '太太笑辣椒油',     '', '')
;

TRUNCATE TABLE `ctr_commodity`;
INSERT INTO `ctr_commodity`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`product_id`,`status`,`img_icon`,`img_mini`,`img_face`,`name`)
VALUES(2301, now(), now(), '1000-01-01', 0, 2101, 2530103, '',         '',         '',   '(脆饼)酸辣辣土豆丝'),
      (2302, now(), now(), '1000-01-01', 0, 2102, 2530103, '',         '',         '',   '(脆饼)销魂烤鸡肉'),
      (2303, now(), now(), '1000-01-01', 0, 2103, 2530103, '',         '',         '',   '(脆饼)麻辣烤鸡'),
      (2304, now(), now(), '1000-01-01', 0, 2104, 2530103, '',         '',         '',   '(脆饼)果木烤鸭'),
      (2305, now(), now(), '1000-01-01', 0, 2105, 2530103, '',         '',         '',   '(脆饼)蜜汁叉烧'),
      (2306, now(), now(), '1000-01-01', 0, 2106, 2530103, '',         '',         '',   '(脆饼)欢辣泡菜五花肉'),
      (2307, now(), now(), '1000-01-01', 0, 2107, 2530103, '',         '',         '',   '(脆饼)老酸菜泡肥牛'),
      (2308, now(), now(), '1000-01-01', 0, 2108, 2530103, '',         '',         '',   '(脆饼)风情黑椒牛柳'),
      (2309, now(), now(), '1000-01-01', 0, 2109, 2530103, '',         '',         '',   '(蛋饼)酸辣辣土豆丝'),
      (2310, now(), now(), '1000-01-01', 0, 2110, 2530103, '',         '',         '',   '(蛋饼)销魂烤鸡肉'),
      (2311, now(), now(), '1000-01-01', 0, 2111, 2530103, '',         '',         '',   '(蛋饼)麻辣烤鸡'),
      (2312, now(), now(), '1000-01-01', 0, 2112, 2530103, 'http://static.lianglife.com/Menu_Product/Omelette/PekingDuckOmelettes_b.png',     'http://static.lianglife.com/Menu_Product/Omelette/PekingDuckOmelettes_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/PekingDuckOmelettes_d.png',   '(蛋饼)果木烤鸭'),
      (2313, now(), now(), '1000-01-01', 0, 2113, 2530103, '',         '',         '',   '(蛋饼)蜜汁叉烧'),
      (2314, now(), now(), '1000-01-01', 0, 2114, 2530103, '',         '',         '',   '(蛋饼)欢辣泡菜五花肉'),
      (2315, now(), now(), '1000-01-01', 0, 2115, 2530103, '',         '',         '',   '(蛋饼)老酸菜泡肥牛'),
      (2316, now(), now(), '1000-01-01', 0, 2116, 2530103, '',         '',         '',   '(蛋饼)风情黑椒牛柳'),
      (2317, now(), now(), '1000-01-01', 0, 2117, 2530103, '',         '',         '',   '(Taco)酸辣辣土豆丝'),
      (2318, now(), now(), '1000-01-01', 0, 2118, 2530103, '',         '',         '',   '(Taco)销魂烤鸡肉'),
      (2319, now(), now(), '1000-01-01', 0, 2119, 2530103, '',         '',         '',   '(Taco)麻辣烤鸡'),
      (2320, now(), now(), '1000-01-01', 0, 2120, 2530103, '',         '',         '',   '(Taco)果木烤鸭'),
      (2321, now(), now(), '1000-01-01', 0, 2121, 2530103, '',         '',         '',   '(Taco)蜜汁叉烧'),
      (2322, now(), now(), '1000-01-01', 0, 2122, 2530103, '',         '',         '',   '(Taco)欢辣泡菜五花肉'),
      (2323, now(), now(), '1000-01-01', 0, 2123, 2530103, '',         '',         '',   '(Taco)老酸菜泡肥牛'),
      (2324, now(), now(), '1000-01-01', 0, 2124, 2530103, '',         '',         '',   '(Taco)风情黑椒牛柳'),
      (2325, now(), now(), '1000-01-01', 0, 2125, 2530103, '',         '',         '',   '(吐司)酸辣辣土豆丝'),
      (2326, now(), now(), '1000-01-01', 0, 2126, 2530103, '',         '',         '',   '(吐司)销魂烤鸡肉'),
      (2327, now(), now(), '1000-01-01', 0, 2127, 2530103, '',         '',         '',   '(吐司)麻辣烤鸡'),
      (2328, now(), now(), '1000-01-01', 0, 2128, 2530103, '',         '',         '',   '(吐司)果木烤鸭'),
      (2329, now(), now(), '1000-01-01', 0, 2129, 2530103, 'http://static.lianglife.com/Menu_Product/Toast/ChineseBBQPorkToast_b.png',       'http://static.lianglife.com/Menu_Product/Toast/ChineseBBQPorkToast_b.png',      'http://static.lianglife.com/Menu_Product/Toast/ChineseBBQPorkToast_d.png',   '(吐司)蜜汁叉烧'),
      (2330, now(), now(), '1000-01-01', 0, 2130, 2530103, '',         '',         '',   '(吐司)欢辣泡菜五花肉'),
      (2331, now(), now(), '1000-01-01', 0, 2131, 2530103, '',         '',         '',   '(吐司)老酸菜泡肥牛'),
      (2332, now(), now(), '1000-01-01', 0, 2132, 2530103, '',         '',         '',   '(吐司)风情黑椒牛柳'),
      (2333, now(), now(), '1000-01-01', 0, 2133, 2530103, '',         '',         '',   '(薄脆)麻辣烤鸡'),
      (2334, now(), now(), '1000-01-01', 0, 2134, 2530103, 'http://static.lianglife.com/Menu_Product/rice/BekingDuckRice_b.png',       'http://static.lianglife.com/Menu_Product/rice/BekingDuckRice_b.png',      'http://static.lianglife.com/Menu_Product/rice/BekingDuckRice_d.png',   '(薄脆)黑松露脆皮鸭'),
      (2335, now(), now(), '1000-01-01', 0, 2135, 2530103, 'http://static.lianglife.com/Menu_Product/String/SichuanMeatballsString_b.png',       'http://static.lianglife.com/Menu_Product/String/SichuanMeatballsString_b.png',      'http://static.lianglife.com/Menu_Product/String/SichuanMeatballsString_d.png',   '一钵热煮'),
      (2336, now(), now(), '1000-01-01', 0, 2136, 2530103, '',         '',         '',   '一粒热煮'),
      (2337, now(), now(), '1000-01-01', 0, 2137, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_d.png',   '经典豆浆'),
      (2338, now(), now(), '1000-01-01', 0, 2138, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_d.png',   '香浓米浆'),
      (2339, now(), now(), '1000-01-01', 0, 2139, 2530103,  'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',                'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',                'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_d.png',   '养颜玫瑰乌龙'),
      (2340, now(), now(), '1000-01-01', 0, 2140, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',                   'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',                   'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_d.png',   '港式丝袜奶茶'),
      (2341, now(), now(), '1000-01-01', 0, 2141, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/BlackSoyMilkCover_b.png',       'http://static.lianglife.com/Menu_Product/Drink/BlackSoyMilkCover_b.png',      'http://static.lianglife.com/Menu_Product/Drink/BlackSoyMilkCover_d.png',   '黑豆豆奶盖'),
      (2342, now(), now(), '1000-01-01', 0, 2142, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/WuLongMilkCover_b.png',       'http://static.lianglife.com/Menu_Product/Drink/WuLongMilkCover_b.png',      'http://static.lianglife.com/Menu_Product/Drink/WuLongMilkCover_d.png',   '乌龙豆豆奶盖'),
      (2343, now(), now(), '1000-01-01', 0, 2143, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_b.png',     'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_b.png',    'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_d.png',   '桃气泡泡'),
      (2344, now(), now(), '1000-01-01', 0, 2144, 2530103, 'http://static.lianglife.com/Menu_Product/Drink/BlueberrySoda_b.png', 'http://static.lianglife.com/Menu_Product/Drink/BlueberrySoda_b.png', 'http://static.lianglife.com/Menu_Product/Drink/BlueberrySoda_d.png',   '莓力泡泡'),
      (2345, now(), now(), '1000-01-01', 0, 2145, 2530103, 'http://static.lianglife.com/Menu_Product/Napoleon/EggNapolun_b.png', 'http://static.lianglife.com/Menu_Product/Napoleon/EggNapolun_b.png', 'http://static.lianglife.com/Menu_Product/Napoleon/EggNapolun_d.png',   '蛋香拿破仑'),
      (2346, now(), now(), '1000-01-01', 0, 2146, 2530103, '',         '',         '',   '菌菇三鲜脆饺(4个)'),
      (2347, now(), now(), '1000-01-01', 0, 2147, 2530103, '',         '',         '',   '玉米鲜肉脆饺(4个)'),
      (2348, now(), now(), '1000-01-01', 0, 2148, 2530103, '',         '',         '',   '田园蛋炒饭'),
      (2349, now(), now(), '1000-01-01', 0, 2149, 2530103, '',         '',         '',   '(炒饭)销魂烤鸡肉'),
      (2350, now(), now(), '1000-01-01', 0, 2150, 2530103, '',         '',         '',   '(炒饭)麻辣烤鸡'),
      (2351, now(), now(), '1000-01-01', 0, 2151, 2530103, '',       '',      '',   '(炒饭)黑松露脆皮鸭'),
      (2352, now(), now(), '1000-01-01', 0, 2152, 2530103, '',         '',         '',   '(饭)销魂烤鸡肉'),
      (2353, now(), now(), '1000-01-01', 0, 2153, 2530103, 'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',       'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',      'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_d.png',   '(饭)麻辣烤鸡'),
      (2354, now(), now(), '1000-01-01', 0, 2154, 2530103, 'http://static.lianglife.com/Menu_Product/rice/BekingDuckRice_b.png',       'http://static.lianglife.com/Menu_Product/rice/BekingDuckRice_b.png',      'http://static.lianglife.com/Menu_Product/rice/BekingDuckRice_d.png',   '(饭)果木烤鸭'),
      (2355, now(), now(), '1000-01-01', 0, 2155, 2530103, '',         '',         '',   '松茸野菌汤'),
      (2356, now(), now(), '1000-01-01', 0, 2156, 2530103, 'http://static.lianglife.com/Menu_Product/Soup/FishSoup_b.png',       'http://static.lianglife.com/Menu_Product/Soup/FishSoup_b.png',      'http://static.lianglife.com/Menu_Product/Soup/FishSoup_d.png',   '老坛酸汤鱼'),
      (2357, now(), now(), '1000-01-01', 0, 2157, 2530103, 'http://static.lianglife.com/Menu_Product/Soup/FlowerGlueSoup_b.png',       'http://static.lianglife.com/Menu_Product/Soup/FlowerGlueSoup_b.png',      'http://static.lianglife.com/Menu_Product/Soup/FlowerGlueSoup_d.png',   '金汤花胶烩灵芝'),
      (2358, now(), now(), '1000-01-01', 0, 2158, 2530103, '',         '',         '',   '甜藕煲排骨'),
      (2359, now(), now(), '1000-01-01', 0, 2159, 2530103, 'http://static.lianglife.com/Menu_Product/icon/BlackSesamePastryMea_mn.png',        'http://static.lianglife.com/Menu_Product/snacks/BlackSesamePuff_b.png',            'http://static.lianglife.com/Menu_Product/snacks/BlackSesamePuff_d.png',   '爆浆黑沙酥(2个)'),
      (2360, now(), now(), '1000-01-01', 0, 2160, 2530103, 'http://static.lianglife.com/Menu_Product/icon/IcyPuddingMeal_mn.png',              'http://static.lianglife.com/Menu_Product/snacks/IcyPudding_b.png',                 'http://static.lianglife.com/Menu_Product/snacks/IcyPudding_d.png',   'QQ哒(3个)'),
      (2361, now(), now(), '1000-01-01', 0, 2161, 2530103, '',         '',         '',   '脆爽酸毛豆'),
      (2362, now(), now(), '1000-01-01', 0, 2162, 2530103, '',         '',         '',   '虎邦蒜蓉辣椒酱'),
      (2363, now(), now(), '1000-01-01', 0, 2163, 2530103, '',         '',         '',   '虎邦鲁西牛肉酱'),
      (2364, now(), now(), '1000-01-01', 0, 2164, 2530103, '',         '',         '',   '太太笑香醋'),
      (2365, now(), now(), '1000-01-01', 0, 2165, 2530103, '',         '',         '',   '太太笑辣椒油')
;

TRUNCATE TABLE `ctr_proposal`;
INSERT INTO `ctr_proposal`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`img_icon`,`img_mini`,`img_face`,`timezone`,`open_ldt`,`shut_ldt`,`price_list`,`price_sell`,`price_rule`,`status`,`ranking`,`sell_time`,`name`,`alias`,`desc`)
VALUES(3301, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/HotSourPotato_b.png',   'http://static.lianglife.com/Menu_Product/Roll/HotSourPotatoCrispyRoll_b.png',      'http://static.lianglife.com/Menu_Product/Roll/HotSourPotatoCrispyRoll_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  1, '1200106', '(脆饼)酸辣辣土豆丝', 'Hot & Sour Potato','经典酸辣风味，爽口开胃，土豆丝脆而不生，搭配新鲜蔬菜，满满过瘾回味！主要原材料：脆饼卷、鸡蛋、生菜、土豆丝、麻辣酱汁'),
      (3302, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChicken_b.png','http://static.lianglife.com/Menu_Product/Roll/GermanBBQChickenCrispyRoll_b.png',   'http://static.lianglife.com/Menu_Product/Roll/GermanBBQChickenCrispyRoll_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  2, '1200106', '(脆饼)销魂烤鸡肉', 'German BBQ Chicken','低脂去骨鸡腿肉，12小时腌制+德式猛火炙烤，肉质鲜香同时，汁香更过瘾！主要原材料：脆饼卷、鸡蛋、生菜、德式烤鸡肉、甜辣酱'),
      (3303, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/SpicyChickenRoll_b.png', 'http://static.lianglife.com/Menu_Product/Roll/SpicyChickenRoll_b.png',    'http://static.lianglife.com/Menu_Product/Roll/SpicyChickenRoll_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  3, '1200106', '(脆饼)麻辣烤鸡', 'Sichuan Spicy Chicken','匠心调味腌制，口味麻、辣、鲜、香，鲜辣过瘾，入口窜香，一口回味悠长！主要原材料：脆饼卷、鸡蛋、生菜、麻辣香锅鸡、麻辣酱汁'),
      (3304, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/PekingDuckCrispyRoll_b.png', 'http://static.lianglife.com/Menu_Product/Roll/PekingDuckCrispyRoll_b.png',    'http://static.lianglife.com/Menu_Product/Roll/PekingDuckCrispyRoll_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  4, '1200106', '(脆饼)果木烤鸭', 'Peking Duck','秘料腌制，使烤肉具有独特果木香味，外焦里嫩，酥而不腻，搭配脆爽蔬菜，重现经典美味！主要原材料：脆饼卷、鸡蛋、黄瓜、京葱、果木烟熏鸭肉、京酱肉丝酱'),
      (3305, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/ChineseBBQPork_b.png',  'http://static.lianglife.com/Menu_Product/Roll/RoastPorkCrispyRoll_b.png',  'http://static.lianglife.com/Menu_Product/Roll/RoastPorkCrispyRoll_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  5, '1200106', '(脆饼)蜜汁叉烧', 'Chinese BBQ Pork','精选猪颈肉，精心腌制，高温烘焙至肉汁丰盈，搭配脆爽紫甘蓝，酥嫩同时碰撞鲜甜滋味！主要原材料：脆饼卷、鸡蛋、紫甘蓝、白洋葱、港式叉烧、芝士、蛋黄酱'),
      (3306, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/PorkKimchi_b.png',       'http://static.lianglife.com/Menu_Product/Roll/PorkKimchi_b.png',      'http://static.lianglife.com/Menu_Product/Roll/PorkKimchi_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  6, '1200106', '(脆饼)欢辣泡菜五花肉', 'Pork belly with spicy kimchi','精挑雪花肥牛，搭配老卤腌制酸菜，肥牛油脂香和酸辣老卤融合，味道酸爽不失浓郁！主要原材料：脆饼卷、鸡蛋、生菜、酸菜、肥牛'),
      (3307, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/SichuanBeefPickledVeggie_b.png',  'http://static.lianglife.com/Menu_Product/Roll/SichuanBeefPickledVeggie_b.png', 'http://static.lianglife.com/Menu_Product/Roll/SichuanBeefPickledVeggie_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  7, '1200106', '(脆饼)老酸菜泡肥牛', 'Beef Pickled Veggie','精挑雪花肥牛，搭配老卤腌制酸菜，肥牛油脂香和酸辣老卤融合，味道酸爽不失浓郁！主要原材料：脆饼卷、鸡蛋、生菜、酸菜、肥牛'),
      (3308, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Roll/CrabCheeseBeef_b.png',   'http://static.lianglife.com/Menu_Product/Roll/CrabCheeseBeef_b.png',      'http://static.lianglife.com/Menu_Product/Roll/CrabCheeseBeef_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  8, '1200106', '(脆饼)风情黑椒牛柳', 'Crab Cheese','黑椒椒辛芬馥，邂逅浓郁滑嫩牛肉，酱香渗入Q弹牛肉肌理，越嚼越香浓！主要原材料：脆饼卷、鸡蛋、生菜、洋葱、黑椒汁、牛柳'),

      (3309, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/HotSourPotatoOmelette_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  9,  '1200106',  '(蛋饼)酸辣土豆丝', 'Hot & Sour Potato','经典酸辣风味，爽口开胃，土豆丝脆而不生，搭配新鲜蔬菜，满满过瘾回味！主要原材料：蛋饼、鸡蛋、生菜、土豆丝、麻辣酱汁'),
      (3310, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_b.png', 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_b.png', 'http://static.lianglife.com/Menu_Product/Omelette/GermanBBQChickenOmelette_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  10, '1200106', '(蛋饼)销魂烤鸡肉', 'German BBQ Chicken','低脂去骨鸡腿肉，12小时腌制+德式猛火炙烤，肉质鲜香同时，汁香更过瘾！主要原材料：蛋饼、鸡蛋、生菜、德式烤鸡肉、甜辣酱'),
      (3311, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/SpicyChickenOmelettes_b.png',     'http://static.lianglife.com/Menu_Product/Omelette/SpicyChickenOmelettes_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/SpicyChickenOmelettes_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  11, '1200106', '(蛋饼)麻辣烤鸡', 'Sichuan Spicy Chicken','匠心调味腌制，口味麻、辣、鲜、香，鲜辣过瘾，入口窜香，一口回味悠长！主要原材料：蛋饼、鸡蛋、生菜、麻辣香锅鸡、麻辣酱汁'),
      (3312, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/PekingDuckOmelettes_b.png',     'http://static.lianglife.com/Menu_Product/Omelette/PekingDuckOmelettes_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/PekingDuckOmelettes_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  12, '1200106', '(蛋饼)果木烤鸭', 'Peking Duck','秘料腌制，使烤肉具有独特果木香味，外焦里嫩，酥而不腻，搭配脆爽蔬菜，重现经典美味！主要原材料：蛋饼、鸡蛋、黄瓜、京葱、果木烟熏鸭肉、京酱肉丝酱'),
      (3313, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_b.png',        'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_b.png',    'http://static.lianglife.com/Menu_Product/Omelette/RoastPorkOmelette_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  13, '1200106', '(蛋饼)蜜汁叉烧', 'Chinese BBQ Pork','精选猪颈肉，精心腌制，高温烘焙至肉汁丰盈，搭配脆爽紫甘蓝，酥嫩同时碰撞鲜甜滋味！主要原材料：蛋饼、鸡蛋、紫甘蓝、白洋葱、港式叉烧、芝士、蛋黄酱'),
      (3314, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/PorkKimchi_b.png',       'http://static.lianglife.com/Menu_Product/Omelette/PorkKimchi_b.png',      'http://static.lianglife.com/Menu_Product/Omelette/PorkKimchi_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  14, '1200106', '(蛋饼)欢辣泡菜五花肉', 'Pork belly with spicy kimchi', '微辣鲜浓，自带果香的泡菜，搭配煎香软绵的五花肉，肥而不腻，更加爽口开胃！主要原材料：蛋饼、鸡蛋、生菜、泡菜、五花肉'),
      (3315, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/BeefPickledVeggieOmelettes_b.png', 'http://static.lianglife.com/Menu_Product/Omelette/BeefPickledVeggieOmelettes_b.png',      'http://static.lianglife.com/Menu_Product/Omelette/BeefPickledVeggieOmelettes_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  15, '1200106', '(蛋饼)老酸菜泡肥牛', 'Beef Pickled Veggie',  '精挑雪花肥牛，搭配老卤腌制酸菜，肥牛油脂香和酸辣老卤融合，味道酸爽不失浓郁！主要原材料：蛋饼、鸡蛋、生菜、泡菜、五花肉!'),
      (3316, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Omelette/CrabCheeseBeefOmelette_b.png',       'http://static.lianglife.com/Menu_Product/Omelette/CrabCheeseBeefOmelette_b.png',      'http://static.lianglife.com/Menu_Product/Omelette/CrabCheeseBeefOmelette_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  16, '1200106', '(蛋饼)风情黑椒牛柳', 'Crab Cheese',  '黑椒椒辛芬馥，邂逅浓郁滑嫩牛肉，酱香渗入Q弹牛肉肌理，越嚼越香浓！主要原材料：蛋饼、鸡蛋、生菜、洋葱、黑椒汁、牛柳'),

      (3317, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',       'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',      'http://static.lianglife.com/Menu_Product/tacco/tacco_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  17, '1200106', '(Taco)酸辣辣土豆丝', 'Hot & Sour Potato','经典酸辣风味，爽口开胃，土豆丝脆而不生，搭配新鲜蔬菜，满满过瘾回味！主要原材料：大麦若叶Taco皮、鸡蛋、生菜、土豆丝、麻辣酱汁'),
      (3318, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',       'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',      'http://static.lianglife.com/Menu_Product/tacco/tacco_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  18, '1200106', '(Taco)销魂烤鸡肉', 'German BBQ Chicken','低脂去骨鸡腿肉，12小时腌制+德式猛火炙烤，肉质鲜香同时，汁香更过瘾！主要原材料：大麦若叶Taco皮、鸡蛋、生菜、德式烤鸡肉、甜辣酱'),
      (3319, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',       'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',      'http://static.lianglife.com/Menu_Product/tacco/tacco_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  19, '1200106', '(Taco)麻辣烤鸡', 'Sichuan Spicy Chicken','匠心调味腌制，口味麻、辣、鲜、香，鲜辣过瘾，入口窜香，一口回味悠长！主要原材料：大麦若叶Taco皮、鸡蛋、生菜、麻辣香锅鸡、麻辣酱汁'),
      (3320, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',       'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',      'http://static.lianglife.com/Menu_Product/tacco/tacco_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  20, '1200106', '(Taco)果木烤鸭', 'Peking Duck','秘料腌制，使烤肉具有独特果木香味，外焦里嫩，酥而不腻，搭配脆爽蔬菜，重现经典美味！主要原材料：大麦若叶Taco皮、鸡蛋、黄瓜、京葱、果木烟熏鸭肉、京酱肉丝酱'),
      (3321, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',       'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',      'http://static.lianglife.com/Menu_Product/tacco/tacco_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  21, '1200106', '(Taco)蜜汁叉烧', 'Chinese BBQ Pork','精选猪颈肉，精心腌制，高温烘焙至肉汁丰盈，搭配脆爽紫甘蓝，酥嫩同时碰撞鲜甜滋味！主要原材料：大麦若叶Taco皮、鸡蛋、紫甘蓝、白洋葱、港式叉烧、芝士、蛋黄酱'),
      (3322, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',       'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',      'http://static.lianglife.com/Menu_Product/tacco/tacco_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  22, '1200106', '(Taco)欢辣泡菜五花肉', 'Pork belly with spicy kimchi','微辣鲜浓，自带果香的泡菜，搭配煎香软绵的五花肉，肥而不腻，更加爽口开胃！主要原材料：大麦若叶Taco皮、鸡蛋、生菜、泡菜、五花肉、欧芹'),
      (3323, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',       'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',      'http://static.lianglife.com/Menu_Product/tacco/tacco_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  23, '1200106', '(Taco)老酸菜泡肥牛', 'Beef Pickled Veggie','精挑雪花肥牛，搭配老卤腌制酸菜，肥牛油脂香和酸辣老卤融合，味道酸爽不失浓郁！主要原材料：大麦若叶Taco皮、鸡蛋、生菜、酸菜、肥牛'),
      (3324, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',       'http://static.lianglife.com/Menu_Product/tacco/tacco_b.png',      'http://static.lianglife.com/Menu_Product/tacco/tacco_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  24, '1200106', '(Taco)风情黑椒牛柳', 'Crab Cheese','黑椒椒辛芬馥，邂逅浓郁滑嫩牛肉，酱香渗入Q弹牛肉肌理，越嚼越香浓！主要原材料：大麦若叶Taco皮、鸡蛋、生菜、洋葱、黑椒汁、牛柳、欧芹'),

      (3325, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Toast/HotSourPotatoToast_b.png',       'http://static.lianglife.com/Menu_Product/Toast/HotSourPotatoToast_b.png',      'http://static.lianglife.com/Menu_Product/Toast/HotSourPotatoToast_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  25, '1200106', '(吐司)酸辣土豆丝', 'Hot & Sour Potato','经典酸辣风味，爽口开胃，土豆丝脆而不生，搭配新鲜蔬菜，满满过瘾回味！主要原材料：吐司、蛋液、芝士片、生菜、土豆丝、麻辣酱汁、芝士片'),
      (3326, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Toast/PorkKimchiToast_b.png',       'http://static.lianglife.com/Menu_Product/Toast/PorkKimchiToast_b.png',      'http://static.lianglife.com/Menu_Product/Toast/PorkKimchiToast_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  26, '1200106', '(吐司)销魂烤鸡肉', 'German BBQ Chicken','低脂去骨鸡腿肉，12小时腌制+德式猛火炙烤，肉质鲜香同时，汁香更过瘾！主要原材料：吐司、蛋液、芝士片、生菜、德式烤鸡肉、甜辣酱'),
      (3327, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Toast/PorkKimchiToast_b.png',       'http://static.lianglife.com/Menu_Product/Toast/PorkKimchiToast_b.png',      'http://static.lianglife.com/Menu_Product/Toast/PorkKimchiToast_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  27, '1200106', '(吐司)麻辣烤鸡', 'Sichuan Spicy Chicken','匠心调味腌制，口味麻、辣、鲜、香，鲜辣过瘾，入口窜香，一口回味悠长！主要原材料：吐司、蛋液、芝士片、生菜、麻辣香锅鸡、麻辣酱汁'),
      (3328, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Toast/PorkKimchiToast_b.png',       'http://static.lianglife.com/Menu_Product/Toast/PorkKimchiToast_b.png',      'http://static.lianglife.com/Menu_Product/Toast/PorkKimchiToast_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  28, '1200106', '(吐司)果木烤鸭', 'Peking Duck','秘料腌制，使烤肉具有独特果木香味，外焦里嫩，酥而不腻，搭配脆爽蔬菜，重现经典美味！主要原材料：大麦若叶Taco皮、鸡蛋、黄瓜、京葱、果木烟熏鸭肉、京酱肉丝酱'),
      (3329, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Toast/ChineseBBQPorkToast_b.png',       'http://static.lianglife.com/Menu_Product/Toast/ChineseBBQPorkToast_b.png',      'http://static.lianglife.com/Menu_Product/Toast/ChineseBBQPorkToast_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  29, '1200106', '(吐司)蜜汁叉烧', 'Chinese BBQ Pork','精选猪颈肉，精心腌制，高温烘焙至肉汁丰盈，搭配脆爽紫甘蓝，酥嫩同时碰撞鲜甜滋味！主要原材料：吐司、蛋液、芝士片、紫甘蓝、白洋葱、港式叉烧、芝士、蛋黄酱'),
      (3330, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Toast/PorkKimchiToast_b.png',       'http://static.lianglife.com/Menu_Product/Toast/PorkKimchiToast_b.png',      'http://static.lianglife.com/Menu_Product/Toast/PorkKimchiToast_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  30, '1200106', '(吐司)欢辣泡菜五花肉', 'Pork belly with spicy kimchi','微辣鲜浓，自带果香的泡菜，搭配煎香软绵的五花肉，肥而不腻，更加爽口开胃！主要原材料：吐司、蛋液、芝士片、生菜、泡菜、五花肉'),
      (3331, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Toast/BeefPickledVeggieToast_b.png',       'http://static.lianglife.com/Menu_Product/Toast/BeefPickledVeggieToast_b.png',      'http://static.lianglife.com/Menu_Product/Toast/BeefPickledVeggieToast_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  31, '1200106', '(吐司)老酸菜泡肥牛', 'Beef Pickled Veggie','精挑雪花肥牛，搭配老卤腌制酸菜，肥牛油脂香和酸辣老卤融合，味道酸爽不失浓郁！主要原材料：吐司、蛋液、芝士片、生菜、酸菜、肥牛'),
      (3332, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Toast/CrabCheeseBeefToast_b.png',       'http://static.lianglife.com/Menu_Product/Toast/CrabCheeseBeefToast_b.png',      'http://static.lianglife.com/Menu_Product/Toast/CrabCheeseBeefToast_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  32, '1200106', '(吐司)风情黑椒牛柳', 'Crab Cheese','黑椒椒辛芬馥，邂逅浓郁滑嫩牛肉，酱香渗入Q弹牛肉肌理，越嚼越香浓！主要原材料：吐司、蛋液、芝士片、生菜、洋葱、黑椒汁、牛柳'),

      (3333, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Papad/SpicyChickenPapad_b.png',     'http://static.lianglife.com/Menu_Product/Papad/SpicyChickenPapad_b.png',    'http://static.lianglife.com/Menu_Product/Papad/SpicyChickenPapad_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  33, '1200106', '(薄脆)麻辣烤鸡', 'Sichuan Spicy Chicken Papad','巴蜀风味，麻辣鲜香的烤肉汁水丰盈，搭配焦香薄脆饼皮，美味停不下来！主要原材料：黑松露鸭肉、蛋饼、果木烟熏鸭肉、芝士、黑松露汁、欧芹、辣椒'),
      (3334, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Papad/TruffleDuckPapad_b.png',     'http://static.lianglife.com/Menu_Product/Papad/TruffleDuckPapad_b.png',    'http://static.lianglife.com/Menu_Product/Papad/TruffleDuckPapad_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  34, '1200106', '(薄脆)黑松露脆皮鸭', 'Truffle duck Papad','“世界三大珍肴”之一黑松露，至鲜之味遇上酥香烤鸭，鲜香过瘾更营养！主要原材料：蛋饼、麻辣香锅烤鸡肉、芝士、麻辣酱汁、欧芹、辣椒'),

      (3335, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/String/SichuanMeatballsString_b.png',       'http://static.lianglife.com/Menu_Product/String/SichuanMeatballsString_b.png',      'http://static.lianglife.com/Menu_Product/String/SichuanMeatballsString_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  35, '1200106', '一钵热煮', '','川式风味，精心炒制香料，熬至麻辣鲜香，多口味选择，令人吮指回味！主要原材料：丸子组合（萝卜1个、福袋（糯米包）1个、龙虾风味球1个、鱼籽鱼豆腐1个）、干蝶蘸料'),
      (3336, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/String/SpicyMeatballsString_b.png',       'http://static.lianglife.com/Menu_Product/String/SpicyMeatballsString_b.png',      'http://static.lianglife.com/Menu_Product/String/SpicyMeatballsString_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  36, '1200106', '一粒热煮', '','秘制麻辣底料，采用优选肉质制丸，圆滑厚实，嫩而不柴，入口弹牙有嚼劲！主要原材料：萝卜、鱼子包、芝士鱼蛋、主轮、墨鱼香肠、福袋（糯米包）、龙虾风味球、鱼子鱼豆腐'),

      (3337, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/SoyaBeanOriginal_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  37, '1200106', '经典豆浆', 'Soya Bean Milk','精选优质大豆，颗颗饱满，采用先进制浆工艺，入口浓郁，醇厚不甜腻。'),
      (3338, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_b.png',            'http://static.lianglife.com/Menu_Product/Drink/RiceMilkOriginal_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  38, '1200106', '香浓米浆', 'Rice Milk','健康谷物大米，浓郁香醇，香、甜、浓，甘而不腻，满口米香回味。'),
      (3339, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',                'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_b.png',                'http://static.lianglife.com/Menu_Product/Drink/RoseOlongTea_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  39, '1200106', '养颜玫瑰乌龙', 'Rose Oolong Tea','精选食用级重瓣玫瑰，搭配洞顶乌龙茶汤，花香茶香呼应，回味甘鲜无穷。'),
      (3340, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',                   'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_b.png',                   'http://static.lianglife.com/Menu_Product/Drink/HKmilkTea_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  40, '1200106', '港式丝袜奶茶', 'HK Style Milk Tea','斯里兰卡进口红茶，茶味浓郁，撞茶工序保留浓厚茶香，入口延绵细密。'),

      (3341, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/BlackSoyMilkCover_b.png',       'http://static.lianglife.com/Menu_Product/Drink/BlackSoyMilkCover_b.png',      'http://static.lianglife.com/Menu_Product/Drink/BlackSoyMilkCover_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  41, '1200106', '黑豆豆奶盖', '','营养黑豆，遇到醇香米乳，浓醇顺滑，搭配丰盈豆豆奶盖，轻盈不腻人。主要原材料：黑豆浆、奶盖、米乳、黄豆粉'),
      (3342, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/WuLongMilkCover_b.png',       'http://static.lianglife.com/Menu_Product/Drink/WuLongMilkCover_b.png',      'http://static.lianglife.com/Menu_Product/Drink/WuLongMilkCover_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  42, '1200106', '乌龙豆豆奶盖', '','馥郁茶香遇到浓醇米乳，精心配比的轻盈奶盖，更趁出茶香的口感丰富。主要原材料：乌龙茶、奶盖、米乳、黄豆粉'),
      (3343, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_b.png',     'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_b.png',    'http://static.lianglife.com/Menu_Product/Drink/PeachSoda_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  43, '1200106', '桃气泡泡', 'Peach Soda','优选7-8月阳山水蜜桃，浓郁果味碰撞苏打气泡水，层层爆破果香。主要原材料：水蜜桃果酱、气泡水、冰块、薄荷叶'),
      (3344, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Drink/BlueberrySoda_b.png', 'http://static.lianglife.com/Menu_Product/Drink/BlueberrySoda_b.png', 'http://static.lianglife.com/Menu_Product/Drink/BlueberrySoda_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  44, '1200106', '莓力泡泡', 'Blueberry Soda','优质蓝莓浆果，果味足且香气浓郁，遇到细腻气泡，清甜饱满，细腻爽口。主要原材料：蓝莓果酱、气泡水、冰块、蓝莓果粒'),

      (3345, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Napoleon/EggNapolun_b.png', 'http://static.lianglife.com/Menu_Product/Napoleon/EggNapolun_b.png', 'http://static.lianglife.com/Menu_Product/Napoleon/EggNapolun_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  45, '1200101', '蛋香拿破仑', 'Egg Mille-feuille','焦香煎鸡蛋遇到秘制“十分脆”酱料，芝麻焦香搭配松脆饼皮，一口入魂。主要原材料：拿破仑、煎鸡蛋、生菜、十分脆'),

      (3346, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRollMeal_mn.png','http://static.lianglife.com/Menu_Product/Dumplings/MushroomDumplings_b.png',       'http://static.lianglife.com/Menu_Product/Dumplings/MushroomDumplings_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  46, '1200101', '菌菇三鲜脆饺(4个)', 'Mushroom Dumplings','精选猪腿肉搭配鲜菌菇，真正皮薄馅大，轻油煎制金黄焦脆，喷香诱人。主要原材料：面粉、猪肉、杏鲍菇、青菜、洋葱、辣椒油、香醋'),
      (3347, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/icon/GermanBBQChickenCrispyRollMeal_mn.png','http://static.lianglife.com/Menu_Product/Dumplings/PorkCornDumplings_b.png',       'http://static.lianglife.com/Menu_Product/Dumplings/PorkCornDumplings_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  47, '1200101', '玉米鲜肉脆饺(4个)', 'Pork Dumplings','均匀肉馅搭配鲜甜玉米，鲜香爽口，煎至金黄，既薄边足馅，又外脆里嫩。主要原材料：面粉、猪肉、玉米、辣椒油、香醋'),

      (3348, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_b.png',              'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_b.png',              'http://static.lianglife.com/Menu_Product/rice/VeggieFriedRice_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  48, '1200102,1200104', '田园蛋炒饭', 'Veggie Fried Rice','喷香炒蛋与时令蔬菜鲜甜融合，猛火炒制，真材实料，更显家常美味！主要原材料：鸡蛋、米饭、萝卜丁、青豆、玉米、白兰地、蛋黄酱、香葱'),
      (3349, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',       'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',      'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  49, '1200102,1200104', '(炒饭)销魂烤鸡肉', ' German BBQ Chicken Fried Rice ','德式烤肉汁香浓厚，猛火翻炒，使蔬菜迸发独有脆爽，米粒略带韧性焦香喷鼻。主要原材料：鸡蛋、米饭、萝卜丁、青豆、玉米、德式风味烤鸡肉、白兰地、蛋黄酱、香葱'),
      (3350, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',       'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',      'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  50, '1200102,1200104', '(炒饭)麻辣烤鸡', 'Sichuan Spicy Chicken Rice','甘香味明显，秘制烤肉独有的鲜香十足，搭配颗粒分明稻花香米，铁板翻炒鲜香X2。主要原材料：鸡蛋、米饭、萝卜丁、青豆、玉米、白兰地、香葱、蛋黄酱、麻辣香锅烤鸡肉、麻辣酱'),
      (3351, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',       'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_b.png',      'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenFriedRice_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  51, '1200102,1200104', '(炒饭)黑松露脆皮鸭', 'Truffle duck Rice','奢靡的黑松露与焦香鸭肉搭配，奇鲜黑松露与酱香烤鸭层层递进，使口感鲜香十足。主要原材料：鸡蛋、米饭、萝卜丁、青豆、玉米、白兰地、香葱、蛋黄酱、果木烟熏鸭肉、黑松露汁'),
      (3352, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_b.png',       'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_b.png',      'http://static.lianglife.com/Menu_Product/rice/GermanBBQChickenRice_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  52, '1200102,1200104', '(饭)销魂烤鸡肉', 'German BBQ Chicken Rice','十余香料的秘制拌饭汁，筋糯米粒+德式烤肉+蒸烤蔬菜，一口汁香过瘾。主要原材料：德式风味烤鸡肉、白米饭、蚝油生菜、咸菜毛豆、烧肉汁'),
      (3353, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/rice/SpicyChickenRice_b.png',       'http://static.lianglife.com/Menu_Product/rice/SpicyChickenRice_b.png',      'http://static.lianglife.com/Menu_Product/rice/SpicyChickenRice_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  53, '1200102,1200104', '(饭)麻辣烤鸡', 'Sichuan Spicy Chicken Rice','选用低脂鲜嫩鸡腿肉，结合川渝风味，鲜麻香爽更下饭，搭配稻花香米饭，略带韧性有回甘。主要原材料：麻辣香锅烤鸡肉、白米饭、蚝油生菜、咸菜毛豆、烧肉汁'),
      (3354, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/rice/BekingDuckRice_b.png',       'http://static.lianglife.com/Menu_Product/rice/BekingDuckRice_b.png',      'http://static.lianglife.com/Menu_Product/rice/BekingDuckRice_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  54, '1200102,1200104', '(饭)果木烤鸭', 'Beking Duck Rice','烟熏香味遇上果木清香，香型浓郁清新，搭配筋糯米粒与秘制拌饭汁，喷香撩拨心鼻。主要原材料：果木烟熏鸭肉、白米饭、蚝油生菜、咸菜毛豆、烧肉汁'),

      (3355, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_b.png',              'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_b.png',              'http://static.lianglife.com/Menu_Product/Soup/MushroomTruffle_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  55, '1200102,1200104', '松茸野菌汤', 'Mushroom Truffle Soup','精选松茸等，四种云南野生菌菇，菌肉肥厚，文火熬制80分钟，入口即感受至鲜之味。主要原材料：松茸、虎掌菌、七彩菌、雪茸菌、枸杞'),
      (3356, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Soup/FishSoup_b.png',       'http://static.lianglife.com/Menu_Product/Soup/FishSoup_b.png',      'http://static.lianglife.com/Menu_Product/Soup/FishSoup_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  56, '1200102,1200104', '老坛酸汤鱼', '','脆爽老坛酸菜，鱼片细白嫩滑，鱼汤金黄澄亮，感受经典川渝鲜爽，开胃更下饭。主要原材料：鮰鱼片、酸菜、小葱、香葱'),
      (3357, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Soup/FlowerGlueSoup_b.png',       'http://static.lianglife.com/Menu_Product/Soup/FlowerGlueSoup_b.png',      'http://static.lianglife.com/Menu_Product/Soup/FlowerGlueSoup_b.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  57, '1200102,1200104', '金汤花胶烩灵芝', '','原盅原味，保证鲜醇味美，富含胶原蛋白，滋补养颜，营养不流失。主要原材料：花胶、灵芝、枸杞'),
      (3358, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_b.png',       'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_b.png',      'http://static.lianglife.com/Menu_Product/Soup/LotusRootandPorkRibSoup_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  58, '1200102,1200104', '甜藕煲排骨', 'Lotus Root and Pork Rib Soup','排骨熬至汤汁香浓，莲藕软糯，搭配清甜莲子，肉的鲜+藕的甜，温润滋补首选。主要原材料：莲藕、排骨、枸杞'),

      (3359, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/icon/BlackSesamePastryMea_mn.png',        'http://static.lianglife.com/Menu_Product/snacks/BlackSesamePuff_b.png',            'http://static.lianglife.com/Menu_Product/snacks/BlackSesamePuff_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  59, '1200103', '爆浆黑沙酥(2个)', 'Black Sesame Puff','千层金黄脆皮，醇厚黑沙流心，酥脆表皮遇到软滑芝麻流心，入口香甜不腻。主要原材料：面粉、鸡蛋液、黑芝麻'),
      (3360, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/icon/IcyPuddingMeal_mn.png',              'http://static.lianglife.com/Menu_Product/snacks/IcyPudding_b.png',                 'http://static.lianglife.com/Menu_Product/snacks/IcyPudding_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  60, '1200103', 'QQ哒(3个)', 'Icy Pudding','甜心芒果+烈焰草莓+清新香草，畅享三种口味，软糯饼皮包裹惊喜雪滋。主要原材料：香草大福、芒果大福、草莓大福'),

      (3361, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/SideDishSauce/Soybean_b.png',       'http://static.lianglife.com/Menu_Product/SideDishSauce/Soybean_b.png',      'http://static.lianglife.com/Menu_Product/SideDishSauce/Soybean_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  61, '1200106', '脆爽酸毛豆', '','湘味美食，香辣毛豆与爽脆酸菜结合，咸香适宜，有滋有味的下饭神器！主要原材料：毛豆、酸菜'),

      (3362, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/SideDishSauce/HuSpicySauce_b.png',       'http://static.lianglife.com/Menu_Product/SideDishSauce/HuSpicySauce_b.png',      'http://static.lianglife.com/Menu_Product/SideDishSauce/HuSpicySauce_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  62, '1200106', '虎邦蒜蓉辣椒酱', '','细腻蒜蓉结合英潮红鲜椒，口感更丰富，辣酱搭配，食欲大开，吃饭更鲜香！'),
      (3363, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/SideDishSauce/HuSpicySauce_b.png',       'http://static.lianglife.com/Menu_Product/SideDishSauce/HuSpicySauce_b.png',      'http://static.lianglife.com/Menu_Product/SideDishSauce/HuSpicySauce_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  63, '1200106', '虎邦鲁西牛肉酱', '', '鲁西黄牛肉，精选带筋牛腱，搭配英潮红鲜椒，香辣交融，唇齿留香。'),
      (3364, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/SideDishSauce/Vinegar_b.png',       'http://static.lianglife.com/Menu_Product/SideDishSauce/Vinegar_b.png',      'http://static.lianglife.com/Menu_Product/SideDishSauce/Vinegar_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  64, '1200106', '太太笑香醋', ''   ,'地道镇江香醋，色浓味鲜，纯粮酿造，多种就餐搭配，为美味加倍！'),
      (3365, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/SideDishSauce/SpicyoilSauce_b.png',       'http://static.lianglife.com/Menu_Product/SideDishSauce/SpicyoilSauce_b.png',      'http://static.lianglife.com/Menu_Product/SideDishSauce/SpicyoilSauce_d.png', 10100, '2019-10-1', '2029-10-1', 0, 0, 3510202, 3510101,  65, '1200106', '太太笑辣椒油', ''  ,'选用正宗二荆条辣椒，中和辣椒与芝麻原香，使香而不腻，辣而不燥。'),

       -- 9个套餐
      (3366, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/new/EggSandwichMeal_b.png',       'http://static.lianglife.com/Menu_Product/comboMeal/new/EggSandwichMeal_b.png',      'http://static.lianglife.com/Menu_Product/comboMeal/new/EggSandwichMeal_d.png', 10100, '2019-10-1', '2029-10-1', 10, 10, 3510202, 3510101,  66,   '1200101', '蛋香拿破仑套餐', '','粮手抓拿破仑千层酥皮，搭配“十分脆”酱料，焦香芝麻搭配丝滑热饮，活力一整天！主要原材料：拿破仑、煎鸡蛋、生菜、十分脆'),
      (3367, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/new/DuckOmeletteBF_b.png',       'http://static.lianglife.com/Menu_Product/comboMeal/new/DuckOmeletteBF_b.png',      'http://static.lianglife.com/Menu_Product/comboMeal/new/DuckOmeletteBF_d.png', 10100, '2019-10-1', '2029-10-1', 18, 18, 3510202, 3510101,  67,   '1200101', '果木鸭肉蛋饼套餐', '','熏烤鸭肉皮脆肉香，搭配营养蛋饼皮，降低油感，搭配暖心热饮，美味向前冲！主要原材料：蛋饼、鸡蛋、黄瓜、京葱、果木烟熏鸭肉、京酱肉丝酱'),
      (3368, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/new/PorkKimchiBF_b.png',       'http://static.lianglife.com/Menu_Product/comboMeal/new/PorkKimchiBF_b.png',      'http://static.lianglife.com/Menu_Product/comboMeal/new/PorkKimchiBF_d.png', 10100, '2019-10-1', '2029-10-1', 22, 22, 3510202, 3510101, 68, '1200101', '蜜汁叉烧蛋吐司套餐', '','Q弹鲜嫩猪颈肉，烤至鲜甜多汁，搭配健康吐司，和一杯暖胃热饮，开启360°早餐全营养！主要原材料：吐司、蛋液、芝士片、生菜、紫甘蓝、白洋葱、港式叉烧、芝士、蛋黄酱'),
      (3369, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/new/SpicyChickenRice_b.png',       'http://static.lianglife.com/Menu_Product/comboMeal/new/SpicyChickenRice_b.png',      'http://static.lianglife.com/Menu_Product/comboMeal/new/SpicyChickenRice_d.png', 10100, '2019-10-1', '2029-10-1', 28, 28, 3510202, 3510101,  69, '1200102,1200104', '麻辣烤鸡饭套餐', '','秘制川渝风味烤肉，干麻过瘾，浓厚酱汁配上爽滑米粒，令人食欲大开，一碗滋补花胶汤暖胃更满足。主要原材料：德式风味烤鸡肉、白米饭、蚝油生菜、咸菜毛豆、烧肉汁'),
      (3370, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/new/DuckRiceLC_b.png',       'http://static.lianglife.com/Menu_Product/comboMeal/new/DuckRiceLC_b.png',      'http://static.lianglife.com/Menu_Product/comboMeal/new/DuckRiceLC_d.png', 10100, '2019-10-1', '2029-10-1', 28, 28, 3510202, 3510101,  70, '1200102,1200104', '果木烤鸭饭套餐', '','熏烤鸭肉至外酥里嫩，鲜嫩耗油生菜更下饭，果香与拌饭汁香，鲜浓交映，下饭十足，胃口大开。主要原材料：果木烟熏鸭肉、白米饭、蚝油生菜、咸菜毛豆、烧肉汁'),
      (3371, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/new/DuckFreidRiceLC_b.png',       'http://static.lianglife.com/Menu_Product/comboMeal/new/DuckFreidRiceLC_b.png',      'http://static.lianglife.com/Menu_Product/comboMeal/new/DuckFreidRiceLC_d.png', 10100, '2019-10-1', '2029-10-1', 26, 26, 3510202, 3510101,  71, '1200102,1200104', '黑松露脆皮鸭炒饭套餐', 'Truffle duck Papad Combo','至鲜黑松露搭配酥香鸭肉，搭配爽口蔬菜，肥而不腻，回味绵长，家一样的真材实料！主要原材料：鸡蛋、米饭、萝卜丁、青豆、玉米、白兰地、香葱、蛋黄酱、果木烟熏鸭肉、黑松露汁'),
      (3372, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/String/SichuanMeatballsString_b.png',       'http://static.lianglife.com/Menu_Product/String/SichuanMeatballsString_b.png',      'http://static.lianglife.com/Menu_Product/String/SichuanMeatballsString_d.png', 10100, '2019-10-1', '2029-10-1', 18, 18, 3510202, 3510101,  72,  '1200103', '一钵热煮套餐', '','十多种香料炒制，熬出真正川魂底料，香麻辣爽，搭配醇香奶盖，辣而不腻更回味！主要原材料：丸子组合（萝卜1个、福袋（糯米包）1个、龙虾风味球1个、鱼籽鱼豆腐1个）、干蝶蘸料'),
      (3373, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/new/BlackSesamePuffAT_b.png',       'http://static.lianglife.com/Menu_Product/comboMeal/new/BlackSesamePuffAT_b.png',      'http://static.lianglife.com/Menu_Product/comboMeal/new/BlackSesamePuffAT_d.png', 10100, '2019-10-1', '2029-10-1', 18, 18, 3510202, 3510101,  73,  '1200103', '下午茶套餐', 'Afternoon Combo','松脆表皮搭配浓厚芝麻流心，椰蓉搭配冰淇淋糯米滋，香甜不腻，享受惬意午间。主要原材料：面粉、鸡蛋液、黑芝麻'),
      (3374, now(), now(), '1000-01-01', 0, 3100001, 'http://static.lianglife.com/Menu_Product/comboMeal/new/DuckBingAT_b.png',       'http://static.lianglife.com/Menu_Product/comboMeal/new/DuckBingAT_b.png',      'http://static.lianglife.com/Menu_Product/comboMeal/new/DuckBingAT_d.png', 10100, '2019-10-1', '2029-10-1', 38, 38, 3510202, 3510101, 74, '1200103', '黑松露脆皮鸭薄脆套餐', 'Truffle duck Papad Combo','“世界三大珍肴”之一黑松露，至鲜之味遇上酥香烤鸭，搭配焦香薄脆，鲜香过瘾！主要原材料：蛋饼、麻辣香锅烤鸡肉、芝士、麻辣酱汁、欧芹、辣椒')
;

TRUNCATE TABLE `ctr_proposal_commodity`;
INSERT INTO `ctr_proposal_commodity`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`bundle_id`,`product_id`,`commodity_id`,`price_list`,`price_sell`,`buy_min`,`buy_max`,`show_price`,`selected`,`ranking`,`name`)
      -- 单品数据
VALUES(3501, now(), now(), '1000-01-01', 0, 3301 ,0, 2101, 2301, 10, 10, 1, 1, true, true, 1, '(脆饼)酸辣辣土豆丝'),
      (3502, now(), now(), '1000-01-01', 0, 3302 ,0, 2102, 2302, 16, 16, 1, 1, true, true, 2, '(脆饼)销魂烤鸡肉'),
      (3503, now(), now(), '1000-01-01', 0, 3303 ,0, 2103, 2303, 16, 16, 1, 1, true, true, 3, '(脆饼)麻辣烤鸡'),
      (3504, now(), now(), '1000-01-01', 0, 3304 ,0, 2104, 2304, 16, 16, 1, 1, true, true, 4, '(脆饼)果木烤鸭'),
      (3505, now(), now(), '1000-01-01', 0, 3305 ,0, 2105, 2305, 18, 18, 1, 1, true, true, 5, '(脆饼)蜜汁叉烧'),
      (3506, now(), now(), '1000-01-01', 0, 3306 ,0, 2106, 2306, 18, 18, 1, 1, true, true, 6, '(脆饼)欢辣泡菜五花肉'),
      (3507, now(), now(), '1000-01-01', 0, 3307 ,0, 2107, 2307, 18, 18, 1, 1, true, true, 7, '(脆饼)老酸菜泡肥牛'),
      (3508, now(), now(), '1000-01-01', 0, 3308 ,0, 2108, 2308, 18, 18, 1, 1, true, true, 8, '(脆饼)风情黑椒牛柳'),
      (3509, now(), now(), '1000-01-01', 0, 3309 ,0, 2109, 2309, 10, 10, 1, 1, true, true, 9, '(蛋饼)酸辣辣土豆丝'),
      (3510, now(), now(), '1000-01-01', 0, 3310 ,0, 2110, 2310, 16, 16, 1, 1, true, true, 10, '(蛋饼)销魂烤鸡肉'),
      (3511, now(), now(), '1000-01-01', 0, 3311 ,0, 2111, 2311, 16, 16, 1, 1, true, true, 11, '(蛋饼)麻辣烤鸡'),
      (3512, now(), now(), '1000-01-01', 0, 3312 ,0, 2112, 2312, 16, 16, 1, 1, true, true, 12, '(蛋饼)果木烤鸭'),
      (3513, now(), now(), '1000-01-01', 0, 3313 ,0, 2113, 2313, 18, 18, 1, 1, true, true, 13, '(蛋饼)蜜汁叉烧'),
      (3514, now(), now(), '1000-01-01', 0, 3314 ,0, 2114, 2314, 18, 18, 1, 1, true, true, 14, '(蛋饼)欢辣泡菜五花肉'),
      (3515, now(), now(), '1000-01-01', 0, 3315 ,0, 2115, 2315, 18, 18, 1, 1, true, true, 15, '(蛋饼)老酸菜泡肥牛'),
      (3516, now(), now(), '1000-01-01', 0, 3316 ,0, 2116, 2316, 18, 18, 1, 1, true, true, 16, '(蛋饼)风情黑椒牛柳'),
      (3517, now(), now(), '1000-01-01', 0, 3317 ,0, 2117, 2317, 10, 10, 1, 1, true, true, 17, '(Taco)酸辣辣土豆丝'),
      (3518, now(), now(), '1000-01-01', 0, 3318 ,0, 2118, 2318, 16, 16, 1, 1, true, true, 18, '(Taco)销魂烤鸡肉'),
      (3519, now(), now(), '1000-01-01', 0, 3319 ,0, 2119, 2319, 16, 16, 1, 1, true, true, 19, '(Taco)麻辣烤鸡'),
      (3520, now(), now(), '1000-01-01', 0, 3320 ,0, 2120, 2320, 16, 16, 1, 1, true, true, 20, '(Taco)果木烤鸭'),
      (3521, now(), now(), '1000-01-01', 0, 3321 ,0, 2121, 2321, 18, 18, 1, 1, true, true, 21, '(Taco)蜜汁叉烧'),
      (3522, now(), now(), '1000-01-01', 0, 3322 ,0, 2122, 2322, 18, 18, 1, 1, true, true, 22, '(Taco)欢辣泡菜五花肉'),
      (3523, now(), now(), '1000-01-01', 0, 3323 ,0, 2123, 2323, 18, 18, 1, 1, true, true, 23, '(Taco)老酸菜泡肥牛'),
      (3524, now(), now(), '1000-01-01', 0, 3324 ,0, 2124, 2324, 18, 18, 1, 1, true, true, 24, '(Taco)风情黑椒牛柳'),
      (3525, now(), now(), '1000-01-01', 0, 3325 ,0, 2125, 2325, 12, 12, 1, 1, true, true, 25, '(吐司)酸辣辣土豆丝'),
      (3526, now(), now(), '1000-01-01', 0, 3326 ,0, 2126, 2326, 18, 18, 1, 1, true, true, 26, '(吐司)销魂烤鸡肉'),
      (3527, now(), now(), '1000-01-01', 0, 3327 ,0, 2127, 2327, 18, 18, 1, 1, true, true, 27, '(吐司)麻辣烤鸡'),
      (3528, now(), now(), '1000-01-01', 0, 3328 ,0, 2128, 2328, 18, 18, 1, 1, true, true, 28, '(吐司)果木烤鸭'),
      (3529, now(), now(), '1000-01-01', 0, 3329 ,0, 2129, 2329, 19.9, 19.9, 1, 1, true, true, 29, '(吐司)蜜汁叉烧'),
      (3530, now(), now(), '1000-01-01', 0, 3330 ,0, 2130, 2330, 19.9, 19.9, 1, 1, true, true, 30, '(吐司)欢辣泡菜五花肉'),
      (3531, now(), now(), '1000-01-01', 0, 3331 ,0, 2131, 2331, 19.9, 19.9, 1, 1, true, true, 31, '(吐司)老酸菜泡肥牛'),
      (3532, now(), now(), '1000-01-01', 0, 3332 ,0, 2132, 2332, 19.9, 19.9, 1, 1, true, true, 32, '(吐司)风情黑椒牛柳'),
      (3533, now(), now(), '1000-01-01', 0, 3333 ,0, 2133, 2333, 18, 18, 1, 1, true, true, 33, '(薄脆)麻辣烤鸡'),
      (3534, now(), now(), '1000-01-01', 0, 3334 ,0, 2134, 2334, 19.9, 19.9, 1, 1, true, true, 34, '(薄脆)黑松露脆皮鸭'),
      (3535, now(), now(), '1000-01-01', 0, 3335 ,0, 2135, 2335, 8, 8, 1, 1, true, true, 35, '一钵热煮'),
      (3536, now(), now(), '1000-01-01', 0, 3336 ,0, 2136, 2336, 2.5, 2.5, 1, 1, true, true, 36, '一粒热煮'),
      (3537, now(), now(), '1000-01-01', 0, 3337 ,0, 2137, 2337, 6, 6, 1, 1, true, true, 37, '经典豆浆'),
      (3538, now(), now(), '1000-01-01', 0, 3338 ,0, 2138, 2338, 6, 6, 1, 1, true, true, 38, '香浓米浆'),
      (3539, now(), now(), '1000-01-01', 0, 3339 ,0, 2139, 2339, 10, 10, 1, 1, true, true, 39, '养颜玫瑰乌龙'),
      (3540, now(), now(), '1000-01-01', 0, 3340 ,0, 2140, 2340, 10, 10, 1, 1, true, true, 40, '港式丝袜奶茶'),
      (3541, now(), now(), '1000-01-01', 0, 3341 ,0, 2141, 2341, 16, 16, 1, 1, true, true, 41, '黑豆豆奶盖'),
      (3542, now(), now(), '1000-01-01', 0, 3342 ,0, 2142, 2342, 16, 16, 1, 1, true, true, 42, '乌龙豆豆奶盖'),
      (3543, now(), now(), '1000-01-01', 0, 3343 ,0, 2143, 2343, 16, 16, 1, 1, true, true, 43, '桃气泡泡'),
      (3544, now(), now(), '1000-01-01', 0, 3344 ,0, 2144, 2344, 16, 16, 1, 1, true, true, 44, '莓力泡泡'),
      (3545, now(), now(), '1000-01-01', 0, 3345 ,0, 2145, 2345, 8, 8, 1, 1, true, true, 45, '蛋香拿破仑'),
      (3546, now(), now(), '1000-01-01', 0, 3346 ,0, 2146, 2346, 10, 10, 1, 1, true, true, 46, '菌菇三鲜脆饺(4个)'),
      (3547, now(), now(), '1000-01-01', 0, 3347 ,0, 2147, 2347, 10, 10, 1, 1, true, true, 47, '玉米鲜肉脆饺(4个)'),
      (3548, now(), now(), '1000-01-01', 0, 3348 ,0, 2148, 2348, 16, 16, 1, 1, true, true, 48, '田园蛋炒饭'),
      (3549, now(), now(), '1000-01-01', 0, 3349 ,0, 2149, 2349, 24, 24, 1, 1, true, true, 49, '(炒饭)销魂烤鸡肉'),
      (3550, now(), now(), '1000-01-01', 0, 3350 ,0, 2150, 2350, 24, 24, 1, 1, true, true, 50, '(炒饭)麻辣烤鸡'),
      (3551, now(), now(), '1000-01-01', 0, 3351 ,0, 2151, 2351, 24, 24, 1, 1, true, true, 51, '(炒饭)黑松露脆皮鸭'),
      (3552, now(), now(), '1000-01-01', 0, 3352 ,0, 2152, 2352, 26, 26, 1, 1, true, true, 52, '(饭)销魂烤鸡肉'),
      (3553, now(), now(), '1000-01-01', 0, 3353 ,0, 2153, 2353, 26, 26, 1, 1, true, true, 53, '(饭)麻辣烤鸡'),
      (3554, now(), now(), '1000-01-01', 0, 3354 ,0, 2154, 2354, 26, 26, 1, 1, true, true, 54, '(饭)果木烤鸭'),
      (3555, now(), now(), '1000-01-01', 0, 3355 ,0, 2155, 2355, 10, 10, 1, 1, true, true, 55, '松茸野菌汤'),
      (3556, now(), now(), '1000-01-01', 0, 3356 ,0, 2156, 2356, 12, 12, 1, 1, true, true, 56, '老坛酸汤鱼'),
      (3557, now(), now(), '1000-01-01', 0, 3357 ,0, 2157, 2357, 12, 12, 1, 1, true, true, 57, '金汤花胶烩灵芝'),
      (3558, now(), now(), '1000-01-01', 0, 3358 ,0, 2158, 2358, 18, 18, 1, 1, true, true, 58, '甜藕煲排骨'),
      (3559, now(), now(), '1000-01-01', 0, 3359 ,0, 2159, 2359, 10, 10, 1, 1, true, true, 59, '爆浆黑沙酥(2个)'),
      (3560, now(), now(), '1000-01-01', 0, 3360 ,0, 2160, 2360, 10, 10, 1, 1, true, true, 60, 'QQ哒(3个)'),
      (3561, now(), now(), '1000-01-01', 0, 3361 ,0, 2161, 2361, 2, 2, 1, 1, true, true, 61, '脆爽酸毛豆'),
      (3562, now(), now(), '1000-01-01', 0, 3362 ,0, 2162, 2362, 3, 3, 1, 1, true, true, 62, '虎邦蒜蓉辣椒酱'),
      (3563, now(), now(), '1000-01-01', 0, 3363 ,0, 2163, 2363, 3, 3, 1, 1, true, true, 63, '虎邦鲁西牛肉酱'),
      (3564, now(), now(), '1000-01-01', 0, 3364 ,0, 2164, 2364, 1, 1, 1, 1, true, true, 64, '太太笑香醋'),
      (3565, now(), now(), '1000-01-01', 0, 3365 ,0, 2165, 2365, 1, 1, 1, 1, true, true, 65, '太太笑辣椒油'),

      -- 9个套餐数据
      -- 套餐1
      (3566, now(), now(), '1000-01-01', 0, 3366 ,3901, 2145, 2345, 0, 0, 1, 1, true, true, 66, '蛋香拿破仑'),
      (3567, now(), now(), '1000-01-01', 0, 3366 ,3902, 2137, 2337, 0, 0, 0, 1, true, false, 67, '经典豆浆'),
      (3568, now(), now(), '1000-01-01', 0, 3366 ,3902, 2138, 2338, 0, 0, 0, 1, true, false, 68, '香浓米浆'),
      -- 套餐2
      (3569, now(), now(), '1000-01-01', 0, 3367 ,3903, 2112, 2312, 0, 0, 1, 1, true, true, 69, '(蛋饼)果木烤鸭'),
      (3570, now(), now(), '1000-01-01', 0, 3367 ,3904, 2137, 2337, 0, 0, 0, 1, true, false, 70, '原味豆浆'),
      (3571, now(), now(), '1000-01-01', 0, 3367 ,3904, 2138, 2338, 0, 0, 0, 1, true, false, 71, '原味米浆'),
      -- 套餐3
      (3572, now(), now(), '1000-01-01', 0, 3368 ,3905, 2129, 2329, 0, 0, 1, 1, true, true, 72, '(吐司)蜜汁叉烧'),
      (3573, now(), now(), '1000-01-01', 0, 3368 ,3906, 2137, 2337, 0, 0, 0, 1, true, false, 73, '原味豆浆'),
      (3574, now(), now(), '1000-01-01', 0, 3368 ,3906, 2138, 2338, 0, 0, 0, 1, true, false, 74, '原味米浆'),

      -- 套餐4
      (3575, now(), now(), '1000-01-01', 0, 3369 ,3907, 2153, 2353, 0, 0, 1, 1, true, true, 75, '(饭)麻辣烤鸡'),
      (3576, now(), now(), '1000-01-01', 0, 3369 ,3908, 2156, 2356, 0, 0, 0, 1, true, false, 76, '老坛酸汤鱼'),
      (3577, now(), now(), '1000-01-01', 0, 3369 ,3908, 2157, 2357, 0, 0, 0, 1, true, false, 77, '金汤花胶烩灵芝'),
      -- 套餐5
      (3578, now(), now(), '1000-01-01', 0, 3370 ,3909, 2154, 2354, 0, 0, 1, 1, true, true, 78, '(饭)果木烤鸭'),
      (3579, now(), now(), '1000-01-01', 0, 3370 ,3910, 2156, 2356, 0, 0, 0, 1, true, false, 79, '老坛酸汤鱼'),
      (3580, now(), now(), '1000-01-01', 0, 3370 ,3910, 2157, 2357, 0, 0, 0, 1, true, false, 80, '金汤花胶烩灵芝'),
      -- 套餐6
      (3581, now(), now(), '1000-01-01', 0, 3371 ,3911, 2151, 2351, 0, 0, 1, 1, true, true, 81, '(炒饭)黑松露脆皮鸭'),
      (3582, now(), now(), '1000-01-01', 0, 3371 ,3912, 2156, 2356, 0, 0, 0, 1, true, false, 82, '老坛酸汤鱼'),
      (3583, now(), now(), '1000-01-01', 0, 3371 ,3912, 2157, 2357, 0, 0, 0, 1, true, false, 83, '金汤花胶烩灵芝'),

      -- 套餐7
      (3584, now(), now(), '1000-01-01', 0, 3372 ,3913, 2135, 2335, 0, 0, 1, 1, true, true,  84, '一钵热煮'),
      (3585, now(), now(), '1000-01-01', 0, 3372 ,3914, 2141, 2341, 0, 0, 0, 1, true, false, 85, '黑豆豆奶盖'),
      (3586, now(), now(), '1000-01-01', 0, 3372 ,3914, 2142, 2342, 0, 0, 0, 1, true, false, 86, '乌龙豆豆奶盖'),
      (3587, now(), now(), '1000-01-01', 0, 3372 ,3914, 2143, 2343, 0, 0, 0, 1, true, false, 87, '桃气泡泡'),
      (3588, now(), now(), '1000-01-01', 0, 3372 ,3914, 2144, 2344, 0, 0, 0, 1, true, false, 88, '莓力泡泡'),
      -- 套餐8
      (3589, now(), now(), '1000-01-01', 0, 3373 ,3915, 2159, 2359, 0, 0, 0, 1, true, true,  89, '爆浆黑沙酥(2个)'),
      (3590, now(), now(), '1000-01-01', 0, 3373 ,3915, 2160, 2360, 0, 0, 0, 1, true, true , 90, 'QQ哒(3个)'),
      (3591, now(), now(), '1000-01-01', 0, 3373 ,3916, 2141, 2341, 0, 0, 0, 1, true, false, 91, '黑豆豆奶盖'),
      (3592, now(), now(), '1000-01-01', 0, 3373 ,3916, 2142, 2342, 0, 0, 0, 1, true, false, 92, '乌龙豆豆奶盖'),
      (3593, now(), now(), '1000-01-01', 0, 3373 ,3916, 2143, 2343, 0, 0, 0, 1, true, false, 93, '桃气泡泡'),
      (3594, now(), now(), '1000-01-01', 0, 3373 ,3916, 2144, 2344, 0, 0, 0, 1, true, false, 94, '莓力泡泡'),
       -- 套餐9
      (3595, now(), now(), '1000-01-01', 0, 3374 ,3917, 2134, 2334, 0, 0, 1, 1, true, true,  95, '(薄脆)黑松露脆皮鸭'),
      (3596, now(), now(), '1000-01-01', 0, 3374 ,3918, 2137, 2337, 0, 0, 0, 1, true, false, 96, '经典豆浆'),
      (3597, now(), now(), '1000-01-01', 0, 3374 ,3918, 2138, 2338, 0, 0, 0, 1, true, false, 97, '香浓米浆'),
      (3598, now(), now(), '1000-01-01', 0, 3374 ,3918, 2139, 2339, 0, 0, 0, 1, true, false, 98, '养颜玫瑰乌龙'),
      (3599, now(), now(), '1000-01-01', 0, 3374 ,3918, 2140, 2340, 0, 0, 0, 1, true, false, 99, '港式丝袜奶茶'),
      (35100, now(), now(), '1000-01-01', 0, 3374 ,3918, 2141, 2341, 0, 0, 0, 1, true, false, 100, '黑豆豆奶盖'),
      (35101, now(), now(), '1000-01-01', 0, 3374 ,3918, 2142, 2342, 0, 0, 0, 1, true, false, 101, '乌龙豆豆奶盖'),
      (35102, now(), now(), '1000-01-01', 0, 3374 ,3918, 2143, 2343, 0, 0, 0, 1, true, false, 102, '桃气泡泡'),
      (35103, now(), now(), '1000-01-01', 0, 3374 ,3918, 2144, 2344, 0, 0, 0, 1, true, false, 103, '莓力泡泡')
;

TRUNCATE TABLE `ctr_scenario_menu`;
INSERT INTO `ctr_scenario_menu`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`name`,`img_icon`,`desc`,`visible`,`topmenu`,`ranking`)
VALUES(3701, now(), now(), '1000-01-01', 0, 3100001, '脆饼卷', 'http://static.lianglife.com/BroadSideIcon/crispyRoll.png', '', true, false, 1),
      (3702, now(), now(), '1000-01-01', 0, 3100001, '蛋饼卷', 'http://static.lianglife.com/BroadSideIcon/eggPie.png', '', true, false, 2),
      (3703, now(), now(), '1000-01-01', 0, 3100001, 'Taco', 'http://static.lianglife.com/BroadSideIcon/crispCharge.png', '', true, false, 3),
      (3704, now(), now(), '1000-01-01', 0, 3100001, '吐司', 'http://static.lianglife.com/BroadSideIcon/toast.png', '', true, false, 4),
      (3705, now(), now(), '1000-01-01', 0, 3100001, '薄脆', 'http://static.lianglife.com/BroadSideIcon/singlePie.png', '', true, false, 5),
      (3706, now(), now(), '1000-01-01', 0, 3100001, '串', 'http://static.lianglife.com/BroadSideIcon/bunch.png', '', true, false, 6),
      (3707, now(), now(), '1000-01-01', 0, 3100001, '热饮', 'http://static.lianglife.com/BroadSideIcon/hotDrinks.png', '', true, false, 7),
      (3708, now(), now(), '1000-01-01', 0, 3100001, '冷饮', 'http://static.lianglife.com/BroadSideIcon/coldSparklingWater.png', '', true, false, 8),

      (3709, now(), now(), '1000-01-01', 0, 3100001, '早餐', 'http://static.lianglife.com/BroadSideIcon/crispCharge.png', '', true, true , 0),
      -- (3710, now(), now(), '1000-01-01', 0, 3100001, '脆饺', 'http://static.lianglife.com/BroadSideIcon/dumplings.png', '', true, false, 10),

      (3711, now(), now(), '1000-01-01', 0, 3100001, '饭', 'http://static.lianglife.com/BroadSideIcon/rice.png', '', true, false, 11),
      (3712, now(), now(), '1000-01-01', 0, 3100001, '汤', 'http://static.lianglife.com/BroadSideIcon/soup.png', '', true, false, 12),
      (3713, now(), now(), '1000-01-01', 0, 3100001, '点心', 'http://static.lianglife.com/BroadSideIcon/snack.png', '', true, false, 13),
      (3714, now(), now(), '1000-01-01', 0, 3100001, '风味小菜', 'http://static.lianglife.com/BroadSideIcon/addMaterial.png', '', true, false, 14),
      (3715, now(), now(), '1000-01-01', 0, 3100001, '风味酱', 'http://static.lianglife.com/BroadSideIcon/sauce.png', '', true, false, 15),
      (3716, now(), now(), '1000-01-01', 0, 3100001, '精选套餐', 'http://static.lianglife.com/BroadSideIcon/comboMeal.png', '', true, true, 16)
;

TRUNCATE TABLE `ctr_proposal_menu`;
INSERT INTO `ctr_proposal_menu`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`scenmenu_id`)
VALUES(3801, now(), now(), '1000-01-01', 0, 3301, 3701),
      (3802, now(), now(), '1000-01-01', 0, 3302, 3701),
      (3803, now(), now(), '1000-01-01', 0, 3303, 3701),
      (3804, now(), now(), '1000-01-01', 0, 3304, 3701),
      (3805, now(), now(), '1000-01-01', 0, 3305, 3701),
      (3806, now(), now(), '1000-01-01', 0, 3306, 3701),
      (3807, now(), now(), '1000-01-01', 0, 3307, 3701),
      (3808, now(), now(), '1000-01-01', 0, 3308, 3701),
      (3809, now(), now(), '1000-01-01', 0, 3309, 3702),
      (3810, now(), now(), '1000-01-01', 0, 3310, 3702),
      (3811, now(), now(), '1000-01-01', 0, 3311, 3702),
      (3812, now(), now(), '1000-01-01', 0, 3312, 3702),
      (3813, now(), now(), '1000-01-01', 0, 3313, 3702),
      (3814, now(), now(), '1000-01-01', 0, 3314, 3702),
      (3815, now(), now(), '1000-01-01', 0, 3315, 3702),
      (3816, now(), now(), '1000-01-01', 0, 3316, 3702),
      (3817, now(), now(), '1000-01-01', 0, 3317, 3703),
      (3818, now(), now(), '1000-01-01', 0, 3318, 3703),
      (3819, now(), now(), '1000-01-01', 0, 3319, 3703),
      (3820, now(), now(), '1000-01-01', 0, 3320, 3703),
      (3821, now(), now(), '1000-01-01', 0, 3321, 3703),
      (3822, now(), now(), '1000-01-01', 0, 3322, 3703),
      (3823, now(), now(), '1000-01-01', 0, 3323, 3703),
      (3824, now(), now(), '1000-01-01', 0, 3324, 3703),
      (3825, now(), now(), '1000-01-01', 0, 3325, 3704),
      (3826, now(), now(), '1000-01-01', 0, 3326, 3704),
      (3827, now(), now(), '1000-01-01', 0, 3327, 3704),
      (3828, now(), now(), '1000-01-01', 0, 3328, 3704),
      (3829, now(), now(), '1000-01-01', 0, 3329, 3704),
      (3830, now(), now(), '1000-01-01', 0, 3330, 3704),
      (3831, now(), now(), '1000-01-01', 0, 3331, 3704),
      (3832, now(), now(), '1000-01-01', 0, 3332, 3704),
      (3833, now(), now(), '1000-01-01', 0, 3333, 3705),
      (3834, now(), now(), '1000-01-01', 0, 3334, 3705),
      (3835, now(), now(), '1000-01-01', 0, 3335, 3706),
      (3836, now(), now(), '1000-01-01', 0, 3336, 3706),
      (3837, now(), now(), '1000-01-01', 0, 3337, 3707),
      (3838, now(), now(), '1000-01-01', 0, 3338, 3707),
      (3839, now(), now(), '1000-01-01', 0, 3339, 3707),
      (3840, now(), now(), '1000-01-01', 0, 3340, 3707),
      (3841, now(), now(), '1000-01-01', 0, 3341, 3708),
      (3842, now(), now(), '1000-01-01', 0, 3342, 3708),
      (3843, now(), now(), '1000-01-01', 0, 3343, 3708),
      (3844, now(), now(), '1000-01-01', 0, 3344, 3708),
      (3845, now(), now(), '1000-01-01', 0, 3345, 3709),
      (3846, now(), now(), '1000-01-01', 0, 3346, 3709),
      (3847, now(), now(), '1000-01-01', 0, 3347, 3709),
      (3848, now(), now(), '1000-01-01', 0, 3348, 3711),
      (3849, now(), now(), '1000-01-01', 0, 3349, 3711),
      (3850, now(), now(), '1000-01-01', 0, 3350, 3711),
      (3851, now(), now(), '1000-01-01', 0, 3351, 3711),
      (3852, now(), now(), '1000-01-01', 0, 3352, 3711),
      (3853, now(), now(), '1000-01-01', 0, 3353, 3711),
      (3854, now(), now(), '1000-01-01', 0, 3354, 3711),
      (3855, now(), now(), '1000-01-01', 0, 3355, 3712),
      (3856, now(), now(), '1000-01-01', 0, 3356, 3712),
      (3857, now(), now(), '1000-01-01', 0, 3357, 3712),
      (3858, now(), now(), '1000-01-01', 0, 3358, 3712),
      (3859, now(), now(), '1000-01-01', 0, 3359, 3713),
      (3860, now(), now(), '1000-01-01', 0, 3360, 3713),
      (3861, now(), now(), '1000-01-01', 0, 3361, 3714),
      (3862, now(), now(), '1000-01-01', 0, 3362, 3715),
      (3863, now(), now(), '1000-01-01', 0, 3363, 3715),
      (3864, now(), now(), '1000-01-01', 0, 3364, 3715),
      (3865, now(), now(), '1000-01-01', 0, 3365, 3715),
      -- 9个套餐
      (3866, now(), now(), '1000-01-01', 0, 3366, 3716),
      (3867, now(), now(), '1000-01-01', 0, 3367, 3716),
      (3868, now(), now(), '1000-01-01', 0, 3368, 3716),
      (3869, now(), now(), '1000-01-01', 0, 3369, 3716),
      (3870, now(), now(), '1000-01-01', 0, 3370, 3716),
      (3871, now(), now(), '1000-01-01', 0, 3371, 3716),
      (3872, now(), now(), '1000-01-01', 0, 3372, 3716),
      (3873, now(), now(), '1000-01-01', 0, 3373, 3716),
      (3874, now(), now(), '1000-01-01', 0, 3374, 3716)
;


TRUNCATE TABLE `ctr_proposal_bundle`;
INSERT INTO `ctr_proposal_bundle`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`proposal_id`,`name`,`buy_num`,`ranking`)
VALUES(3901, now(), now(), '1000-01-01', 0, 3366, '主食', 1, 1),
      (3902, now(), now(), '1000-01-01', 0, 3366, '饮品', 1, 2),

      (3903, now(), now(), '1000-01-01', 0, 3367, '主食', 1, 1),
      (3904, now(), now(), '1000-01-01', 0, 3367, '饮品', 1, 2),

      (3905, now(), now(), '1000-01-01', 0, 3368, '主食', 1, 1),
      (3906, now(), now(), '1000-01-01', 0, 3368, '饮品', 1, 2),

      (3907, now(), now(), '1000-01-01', 0, 3369, '主食', 1, 1),
      (3908, now(), now(), '1000-01-01', 0, 3369, '汤', 1, 2),

      (3909, now(), now(), '1000-01-01', 0, 3370, '主食', 1, 1),
      (3910, now(), now(), '1000-01-01', 0, 3370, '汤', 1, 2),

      (3911, now(), now(), '1000-01-01', 0, 3371, '主食', 1, 1),
      (3912, now(), now(), '1000-01-01', 0, 3371, '汤', 1, 2),

      (3913, now(), now(), '1000-01-01', 0, 3372, '主食', 1, 1),
      (3914, now(), now(), '1000-01-01', 0, 3372, '冷饮', 1, 2),

      (3915, now(), now(), '1000-01-01', 0, 3373, '点心', 1, 1),
      (3916, now(), now(), '1000-01-01', 0, 3373, '冷饮', 1, 2),

      (3917, now(), now(), '1000-01-01', 0, 3374, '主食', 1, 1),
      (3918, now(), now(), '1000-01-01', 0, 3374, '饮品', 2, 2)
;

TRUNCATE TABLE `ctr_store`;
INSERT INTO `ctr_store`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`name`,`status`,`region_id`,`timezone`,`position`,`map_type`,`address`,`store_type`,`datum_type`,`place_type`,`union_type`,`square`,`square_unit`,`seat_count`,`manager_name`,`manager_phone`,`photo1`,`photo2`,`photo3`,`photo4`,`photo5`,`opening_ldt`,`expired_ldt`,`inner_only`,`eat_inside`,`sell_mode`,`send_area_gmap`,`send_area_json`,`tax_rate`,`sendouter_id`,`scenario_id`, `store_num`)
VALUES(2800001,now(),now(),'1000-01-01',0,'虹桥天街店',4010102,1000900,10100,'','','',4010201,4010501,4010304,4010401,'120','平方米','20','J','15994234567','','','','','','2019-10-01','2029-10-01',true,true,'自提,外送','','',0,0,'3100001', '2800001');

TRUNCATE TABLE `ctr_scenario`;
INSERT INTO `ctr_scenario`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`name`,`desc`,`img_advt`,`currency`,`status`)
VALUES(3100001, now(), now(), '1000-01-01', 0, '上海地区通用方案', '', 'http://static.lianglife.com/HomePage/20200108.png', 'CNY', 3710102);

TRUNCATE TABLE `ctr_scenario_region`;
INSERT INTO `ctr_scenario_region`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`region_id`,`store_type`,`place_type`)
VALUES(4000, now(), now(), '1000-01-01', 0, 3100001, 1000900, 4010201, 4010304);

TRUNCATE TABLE `ctr_scenario_store`;
INSERT INTO `ctr_scenario_store`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`scenario_id`,`store_id`)
VALUES(3201, now(), now(), '1000-01-01', 0,3100001,2800001);


TRUNCATE TABLE `ctr_account_balance`;
INSERT INTO `ctr_account_balance`(`id`,`create_dt`,`modify_dt`,`delete_dt`,`commit_id`,`account_id`,`money_type`,`currency`,`balance`,`credit`,`status`)
VALUES('0',now(), now(), '1000-01-01', 0, 0, 5510101, 'CNY', 0, 2147483647, 5520201),
      ('1',now(), now(), '1000-01-01', 0, 1, 5510101, 'CNY', 0, 2147483647, 5520201)
;

-- ok ,well done alex!
