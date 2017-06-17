/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2017-06-17 16:10:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for debug_develop_plan
-- ----------------------------
DROP TABLE IF EXISTS `debug_develop_plan`;
CREATE TABLE `debug_develop_plan` (
  `dplan_id` varchar(64) NOT NULL,
  `dplan_name` varchar(255) NOT NULL COMMENT '任务名称',
  `dplan_priority` int(255) NOT NULL COMMENT '任务等级',
  `dplan_descr` text COMMENT '任务描述',
  `dplan_finish_date` datetime DEFAULT NULL COMMENT '完成时间',
  `dplan_progress` int(255) DEFAULT NULL COMMENT '任务进度',
  `dplan_status` varchar(255) NOT NULL COMMENT '任务状态',
  `dplan_create_date` datetime NOT NULL COMMENT '创建日期',
  `dplan_estimated_date` datetime DEFAULT NULL COMMENT '任务预计完成时间',
  `uid_create_user` varchar(64) DEFAULT NULL COMMENT '任务创建人',
  `uid_plan_terminator` varchar(64) DEFAULT NULL COMMENT '任务完成人',
  PRIMARY KEY (`dplan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of debug_develop_plan
-- ----------------------------
INSERT INTO `debug_develop_plan` VALUES ('3a138d7d94d44ead9ced4aa3c7e51244', 'swfupload实现多文件上传', '4', '<p>文件下载：&nbsp;<a href=\"https://github.com/wordpress/secure-swfupload\">https://github.com/wordpress/secure-swfupload</a></p>\n\n<p>swfupload API:&nbsp;<a href=\"http://www.runoob.com/w3cnote/swfupload-guide.html\">http://www.runoob.com/w3cnote/swfupload-guide.html</a></p>\n\n<p>组件参考：<a href=\"http://blog.csdn.net/kunoy/article/details/7970991\">http://blog.csdn.net/kunoy/article/details/7970991</a></p>\n\n<p>&nbsp;</p>\n', null, '0', 'ENABLE', '2017-06-16 18:28:19', '2017-06-30 00:00:00', '3c498ad2a8c24e7887b6f85316b5e746', null);
INSERT INTO `debug_develop_plan` VALUES ('5f4c8db18fdc4eb7a9aa0a39947d43e9', 'sdfsd', '4', '<p>sdf</p>\n', null, '0', 'ENABLE', '2017-06-16 10:46:05', null, '3c498ad2a8c24e7887b6f85316b5e746', null);
INSERT INTO `debug_develop_plan` VALUES ('e86e3282d71a45c0b766ee1055875e39', 'ergdfg', '4', '<p>gdf</p>\n', null, '0', 'ENABLE', '2017-06-16 10:57:49', null, '3c498ad2a8c24e7887b6f85316b5e746', null);

-- ----------------------------
-- Table structure for debug_system_memo
-- ----------------------------
DROP TABLE IF EXISTS `debug_system_memo`;
CREATE TABLE `debug_system_memo` (
  `memo_id` varchar(64) NOT NULL COMMENT '标识',
  `memo_pid` varchar(64) NOT NULL DEFAULT '' COMMENT '上级',
  `memo_hierarchy` varchar(1024) NOT NULL DEFAULT '' COMMENT '层级关系',
  `memo_order` int(255) NOT NULL DEFAULT '0' COMMENT '排序',
  `memo_title` varchar(255) NOT NULL COMMENT '标题',
  `memo_descr` text COMMENT '描述',
  `memo_url` varchar(255) DEFAULT NULL COMMENT '链接',
  PRIMARY KEY (`memo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统备忘录';

-- ----------------------------
-- Records of debug_system_memo
-- ----------------------------
INSERT INTO `debug_system_memo` VALUES ('36c383c4b68e4df0ac42e21c13b88c29', '', '', '0', '部署注意', '1.修改日志路径，及输出级别<div>2.修改监控项目有如下</div><div>&nbsp; ①web.xml&nbsp;</div><div><b>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; DruidWebStatFilter &nbsp;&nbsp;</b></div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<b>DruidStatView</b></div><div>&nbsp; ② spring-content.xml &nbsp;</div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; DruidDataSource&nbsp;<b>filters </b>配置项</div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<b>&nbsp;druid-stat-interceptor</b> bean</div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<b>druid-stat-pointcut</b> &nbsp;bean</div><div>&nbsp; &nbsp; &nbsp;&nbsp;</div><div>&nbsp;&nbsp;</div>', '');
INSERT INTO `debug_system_memo` VALUES ('44e27c92bb6f4a3bbad0ce044ddef8e2', '', '', '0', 'stroe摘要', '当stroe文件加载进来时，系统就会自动创建一个实体', '');
INSERT INTO `debug_system_memo` VALUES ('6ce48c9647b948778a3de29a971af0eb', '', '', '0', 'hergdg', 'dfgd', '');
INSERT INTO `debug_system_memo` VALUES ('93b9c996014b49ad930f6c23b4900eef', '', '', '0', '排入和', '', '');
INSERT INTO `debug_system_memo` VALUES ('fcbc6e1f61c04fb78ff97b6bef7bbf60', '', '', '0', '测试', '密ssdf', '');

-- ----------------------------
-- Table structure for mgr_function
-- ----------------------------
DROP TABLE IF EXISTS `mgr_function`;
CREATE TABLE `mgr_function` (
  `fn_Id` varchar(64) NOT NULL DEFAULT '' COMMENT '键',
  `fn_Name` varchar(64) NOT NULL DEFAULT '' COMMENT '名称',
  `fn_ParentId` varchar(64) DEFAULT '' COMMENT '父菜单',
  `fn_Icon` varchar(64) DEFAULT '' COMMENT '图标',
  `fn_Handler` varchar(200) DEFAULT '' COMMENT '功能处理的行为',
  `fn_Order` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `fn_Relevance` varchar(64) NOT NULL DEFAULT '' COMMENT '所关联的url',
  `dic_Type` varchar(64) NOT NULL DEFAULT '' COMMENT '类型',
  `fn_Descr` varchar(200) DEFAULT '' COMMENT '解释',
  `fn_Glyph` int(11) DEFAULT '0' COMMENT 'glyph表示的图标',
  `dic_Usability` varchar(64) NOT NULL DEFAULT 'VISIBLE' COMMENT '可用性',
  PRIMARY KEY (`fn_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of mgr_function
-- ----------------------------
INSERT INTO `mgr_function` VALUES ('A001', '博客管理', '', '', '', '1', '', 'NAVIGATOR', '博客前台管理', '58917', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('A0010001', '博客用户', 'A001', '', '', '1', '', 'NAVIGATOR', '博客注册用户管理', '58901', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('A0010002', '文章管理', 'A001', '', '', '2', '', 'NAVIGATOR', '博客用户文章管理', '59000', 'DISABLE');
INSERT INTO `mgr_function` VALUES ('B001', '统计分析', '', '', '', '2', '', 'NAVIGATOR', '博客统计分析', '59012', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('B0010001', '用户统计', 'B001', '', '', '1', '', 'NAVIGATOR', '', '59012', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C001', '系统管理', '', '', '', '8', '', 'NAVIGATOR', '系统管理', '59019', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C0010001', '数据字典', 'C001', '', '', '1', '', 'NAVIGATOR', '数据字典', '58912', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C0010003', '系统用户', 'C001', '', 'BlogMgr.view.user.UserHome', '3', 'user/paging.data', 'NAVIGATOR', '系统后台用户管理', '58905', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C00100030001', '新增用户', 'C0010003', '', 'addUser', '0', 'user/add.do', 'TOOLBAR', '', '58904', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C00100030002', '修改用户', 'C0010003', '', 'editUser', '1', 'user/edit.do', 'TOOLBAR', '', '58940', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C00100030003', '删除用户', 'C0010003', '', 'deleteUser', '2', 'user/delete.do', 'TOOLBAR', '', '58903', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C00100030004', '保存编辑', 'C0010003', '', 'saveRecord', '4', 'user/editbatch.do', 'TOOLBAR', '', '58960', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C00100030005', '用户导出', 'C0010003', '', '', '1', 'user/export_user_list.data', 'UNIT', '导出excel文件', '58941', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C0010005', '权限配置', 'C001', '', 'BlogMgr.view.auth.AuthHome', '5', 'role/paging.data', 'NAVIGATOR', '后台系统权限配置', '59060', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C00100050001', '新增角色', 'C0010005', '', 'addRole', '0', 'role/add.do', 'TOOLBAR', '', '59083', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C00100050002', '修改角色', 'C0010005', '', 'editRole', '2', 'role/edit.do', 'TOOLBAR', '', '58940', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C00100050003', '删除角色', 'C0010005', '', 'deleteRole', '3', 'role/delete.do', 'TOOLBAR', '', '58925', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C00100050004', '保存编辑', 'C0010005', '', 'saveRecord', '4', 'role/editbatch.do', 'TOOLBAR', '保存编辑好的模块信息', '58960', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C0010006', '功能配置', 'C001', '', 'BlogMgr.view.fun.FunctionHome', '6', 'function/paging.data', 'NAVIGATOR', '系统菜单管理', '58974', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C00100060001', '新增功能', 'C0010006', '', 'addFunction', '1', 'function/add.do', 'TOOLBAR', '', '59083', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C00100060002', '修改功能', 'C0010006', '', 'editFunction', '2', 'funciton/edit.do', 'TOOLBAR', '', '58940', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C00100060003', '删除功能', 'C0010006', '', 'deleteFunction', '3', 'delete.do', 'TOOLBAR', '', '58925', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C00100060004', '保存编辑', 'C0010006', '', 'saveRecord', '4', 'function/editbatch.do', 'TOOLBAR', '', '58960', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C0010007', '登录日志', 'C001', '', 'BlogMgr.view.loginlog.LoginLogHome', '7', 'login_log/paging.data', 'NAVIGATOR', '前后台登录日志', '59002', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C00100070001', '监测', 'C0010007', '', '', '0', '', 'TOOLBAR', '', '58917', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('C0010010', '系统配置', 'C001', '', '', '10', '', 'NAVIGATOR', '后台系统参数配置', '58977', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('D001', '个人中心', '', '', '', '9', '', 'NAVIGATOR', '当前用户管理', '58902', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('D0010001', '本人信息', 'D001', '', '', '1', '', 'NAVIGATOR', '当前用户', '58919', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('Z001', '开发者中心', '', '', '', '10', '', 'NAVIGATOR', '开发者调式工具', '58974', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('Z0010001', '便签', 'Z001', '', 'BlogMgr.view.debug.memo.SystemMemoHome', '0', '/debug/meno/paging.data', 'NAVIGATOR', '', '58917', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('Z00100010001', '新增便签', 'Z0010001', '', 'addMemo', '1', '', 'TOOLBAR', '', '58917', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('Z00100010002', '修改便签', 'Z0010001', '', 'editMemo', '2', '', 'TOOLBAR', '', '58917', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('Z00100010003', '删除便签', 'Z0010001', '', 'deleteMemo', '3', '', 'TOOLBAR', '', '58917', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('Z0010002', '功能开发', 'Z001', '', 'BlogMgr.view.debug.developplan.DevelopPlanHome', '2', '', 'NAVIGATOR', '', '58917', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('Z0010008', '异常日志', 'Z001', '', '', '8', '', 'NAVIGATOR', '前后台异常日志', '58926', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('Z0010009', '系统监控', 'Z001', '', 'BlogMgr.view.debug.monitor.MonitorHome', '9', '', 'NAVIGATOR', '数据库操作日志', '58881', 'ENABLE');

-- ----------------------------
-- Table structure for mgr_privilege
-- ----------------------------
DROP TABLE IF EXISTS `mgr_privilege`;
CREATE TABLE `mgr_privilege` (
  `pri_id` varchar(64) NOT NULL COMMENT '键',
  `dic_auth_priority` varchar(64) NOT NULL COMMENT '可操作范围',
  `fn_id` varchar(64) NOT NULL COMMENT '功能id',
  `rol_id` varchar(64) NOT NULL COMMENT '角色id',
  `dic_type` varchar(64) NOT NULL COMMENT '权限类型',
  PRIMARY KEY (`pri_id`),
  KEY `rol_id` (`rol_id`),
  CONSTRAINT `mgr_privilege_ibfk_1` FOREIGN KEY (`rol_id`) REFERENCES `mgr_role` (`rol_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mgr_privilege
-- ----------------------------
INSERT INTO `mgr_privilege` VALUES ('0682ae911c40443690d50c6f79a78eea', 'ENABLE', 'C0010006', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('0d4f5df0dcb611e6a160b025aa1c1fd4', 'ENABLE', 'C00100050003', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('0d4f604fdcb611e6a160b025aa1c1fd4', 'ENABLE', 'C00100050003', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('14348c388a2b44f998d546234fb29e8c', 'ENABLE', 'B001', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('2602f924a2884764aff019da8664465b', 'ENABLE', 'C0010010', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('2b0096aedcb611e6a160b025aa1c1fd4', 'ENABLE', 'C00100050004', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('2b009932dcb611e6a160b025aa1c1fd4', 'ENABLE', 'C00100050004', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('36be0e42eba711e6a8a6b025aa1c1fd4', 'ENABLE', 'T001', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('36be12d8eba711e6a8a6b025aa1c1fd4', 'ENABLE', 'T001', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('378115ba5c544bf5a9d332d109406412', 'ENABLE', 'C0010001', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('3bfc37252c8411e78862b025aa1c1fd4', 'ENABLE', 'Z0010001', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('3bfc3bbf2c8411e78862b025aa1c1fd4', 'ENABLE', 'Z0010001', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('562fb65b2cbb11e78862b025aa1c1fd4', 'ENABLE', 'Z0010001001', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('562fb7e52cbb11e78862b025aa1c1fd4', 'ENABLE', 'Z0010001001', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('5631732883c540ab8e4e542feb064dd2', 'ENABLE', 'A001', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('56f76e05ee9d11e6af44b025aa1c1fd4', 'ENABLE', 'C00100030005', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('56f770e3ee9d11e6af44b025aa1c1fd4', 'ENABLE', 'C00100030005', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('584ab902b3d14ca3912260b4031aba46', 'ENABLE', 'Z0010009', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('59d37954dcb711e6a160b025aa1c1fd4', 'ENABLE', 'C00100060003', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('59d37c8ddcb711e6a160b025aa1c1fd4', 'ENABLE', 'C00100060003', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('67008635533111e79c1eb025aa1c1fd4', 'ENABLE', 'C00100070001', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('67008928533111e79c1eb025aa1c1fd4', 'ENABLE', 'C00100070001', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('79d3282cdcb711e6a160b025aa1c1fd4', 'ENABLE', 'C00100060004', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('79d32adddcb711e6a160b025aa1c1fd4', 'ENABLE', 'C00100060004', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('7a4f5f6c245d463dbd5269630b20c2de', 'ENABLE', 'B0010001', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('7dae433465c148d6bce4414ecc3f633c', 'ENABLE', 'D0010001', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('7dced1af7d8b49a18328e34058283e50\r\n', 'ENABLE', 'Z001', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('811fe20fdcb611e6a160b025aa1c1fd4', 'ENABLE', 'C00100060001', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('811fe660dcb611e6a160b025aa1c1fd4', 'ENABLE', 'C00100060001', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836ee2cfd8ad11e68f41b025aa1c1fd4', 'ENABLE', 'A001', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836ee8add8ad11e68f41b025aa1c1fd4', 'ENABLE', 'A0010001', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836eeda2d8ad11e68f41b025aa1c1fd4', 'ENABLE', 'A0010002', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836ef21bd8ad11e68f41b025aa1c1fd4', 'ENABLE', 'B001', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836ef530d8ad11e68f41b025aa1c1fd4', 'ENABLE', 'B0010001', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836ef77bd8ad11e68f41b025aa1c1fd4', 'ENABLE', 'C001', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836efe16d8ad11e68f41b025aa1c1fd4', 'ENABLE', 'C0010001', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836effcdd8ad11e68f41b025aa1c1fd4', 'ENABLE', 'C0010003', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836f0241d8ad11e68f41b025aa1c1fd4', 'ENABLE', 'C00100030001', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836f0495d8ad11e68f41b025aa1c1fd4', 'ENABLE', 'C00100030002', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836f06c7d8ad11e68f41b025aa1c1fd4', 'ENABLE', 'C00100030003', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836f08a8d8ad11e68f41b025aa1c1fd4', 'ENABLE', 'C0010005', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836f0a4ed8ad11e68f41b025aa1c1fd4', 'ENABLE', 'C00100050001', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836f0c02d8ad11e68f41b025aa1c1fd4', 'ENABLE', 'C0010006', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836f0d94d8ad11e68f41b025aa1c1fd4', 'ENABLE', 'C0010007', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836f0f37d8ad11e68f41b025aa1c1fd4', 'ENABLE', 'C0010010', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836f10c9d8ad11e68f41b025aa1c1fd4', 'ENABLE', 'D001', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836f1274d8ad11e68f41b025aa1c1fd4', 'ENABLE', 'D0010001', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836f1458d8ad11e68f41b025aa1c1fd4', 'ENABLE', 'Z001', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836f15f3d8ad11e68f41b025aa1c1fd4', 'ENABLE', 'Z0010008', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('836f1789d8ad11e68f41b025aa1c1fd4', 'ENABLE', 'Z0010009', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('85da73ad10154f9eb5429a757b567003', 'ENABLE', 'A0010001', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('866df9ac2cbb11e78862b025aa1c1fd4', 'ENABLE', 'Z0010001002', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('866dfc3d2cbb11e78862b025aa1c1fd4', 'ENABLE', 'Z0010001002', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('867765c531dc4fcfb37fa0d7b91f7da1', 'ENABLE', 'C0010005', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('8cdec27008014c5fa78d506008b70931', 'ENABLE', 'D001', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('8d8ce960dc6111e6a160b025aa1c1fd4', 'ENABLE', 'C00100030004', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('8d8cec01dc6111e6a160b025aa1c1fd4', 'ENABLE', 'C00100030004', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('9006d9992cbb11e78862b025aa1c1fd4', 'ENABLE', 'Z0010001003', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('9006dcfb2cbb11e78862b025aa1c1fd4', 'ENABLE', 'Z0010001003', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('91ed54e6ff8c4ec5998be4c4c63f084c', 'ENABLE', 'A0010002', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('a59cf430e57c4ca9a1eaf349cbbcc753', 'ENABLE', 'C0010007', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('ad3b3250e4be4f118b5a3abe9577bec0', 'ENABLE', 'C001', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('b4c26d34d8ab11e68f41b025aa1c1fd4', 'ENABLE', 'C00100050001', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('c71e1b0d2cbc11e78862b025aa1c1fd4', 'ENABLE', 'Z00100010001', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('c71e1ed62cbc11e78862b025aa1c1fd4', 'ENABLE', 'Z00100010001', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('cce1b778dcb611e6a160b025aa1c1fd4', 'ENABLE', 'C00100060002', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('cce1ba2edcb611e6a160b025aa1c1fd4', 'ENABLE', 'C00100060002', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('d0fba2032cbc11e78862b025aa1c1fd4', 'ENABLE', 'Z00100010002', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('d0fba3f42cbc11e78862b025aa1c1fd4', 'ENABLE', 'Z00100010002', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('d315d4cd264f43fc9b231182325daac8', 'ENABLE', 'C0010003', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('d802666a2c8311e78862b025aa1c1fd4', 'ENABLE', 'Z0010002', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('d80268a12c8311e78862b025aa1c1fd4', 'ENABLE', 'Z0010002', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('e11f93a82cbc11e78862b025aa1c1fd4', 'ENABLE', 'Z00100010003', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('e11f95eb2cbc11e78862b025aa1c1fd4', 'ENABLE', 'Z00100010003', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('e5b5f06fe8bb4231962c8db6fb5b255a', 'ENABLE', 'Z0010008', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('ef98d5c5dcb511e6a160b025aa1c1fd4', 'ENABLE', 'C00100050002', '6a2875bf1b61413986f1488c50c1627a', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('ef98d97ddcb511e6a160b025aa1c1fd4', 'ENABLE', 'C00100050002', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('f863892bd8ac11e68f41b025aa1c1fd4', 'ENABLE', 'C00100030001', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('f8638f53d8ac11e68f41b025aa1c1fd4', 'ENABLE', 'C00100030002', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');
INSERT INTO `mgr_privilege` VALUES ('f86392d2d8ac11e68f41b025aa1c1fd4', 'ENABLE', 'C00100030003', 'ed21cbc9e2c54fe587ad28353a8055e6', 'FUNCTION');

-- ----------------------------
-- Table structure for mgr_role
-- ----------------------------
DROP TABLE IF EXISTS `mgr_role`;
CREATE TABLE `mgr_role` (
  `rol_Id` varchar(64) NOT NULL COMMENT '键',
  `rol_Name` varchar(64) NOT NULL COMMENT ' 角色名称',
  `rol_code` int(200) DEFAULT NULL COMMENT '角色代码',
  `rol_Descr` varchar(200) DEFAULT '' COMMENT '角色描述',
  `dic_status` varchar(64) NOT NULL COMMENT '角色状态（如：可用/可用）',
  PRIMARY KEY (`rol_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mgr_role
-- ----------------------------
INSERT INTO `mgr_role` VALUES ('68828cb5e2594a449ac206e6d2fab710', 'ROLE_GUEST', '0', '游客用户，为系统的最低权限，只允许有查看功能', 'DELETE');
INSERT INTO `mgr_role` VALUES ('6a2875bf1b61413986f1488c50c1627a', 'ROLE_USER', '2', '系统用户，为最基础的权限，当创建一个用户时默认为该权限。', 'ENABLE');
INSERT INTO `mgr_role` VALUES ('ed21cbc9e2c54fe587ad28353a8055e6', 'ROLE_ADMIN', '1', '系统管理员，为系统的最高权限，可使用任何功能', 'ENABLE');

-- ----------------------------
-- Table structure for mgr_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `mgr_userinfo`;
CREATE TABLE `mgr_userinfo` (
  `ui_Id` varchar(64) NOT NULL DEFAULT '',
  `ui_Name` varchar(64) NOT NULL DEFAULT '' COMMENT '用户名',
  `ui_Account` varchar(100) NOT NULL DEFAULT '' COMMENT '登录账号',
  `ui_Password` varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
  `dic_Status` varchar(64) NOT NULL DEFAULT 'ENABLE' COMMENT '用户状态',
  `dic_Gender` varchar(64) NOT NULL DEFAULT 'UNKNOW' COMMENT '性别',
  `ui_PinYin` varchar(200) NOT NULL DEFAULT '' COMMENT '拼音',
  `ui_Descr` varchar(200) NOT NULL DEFAULT '' COMMENT '备注',
  `ui_Email` varchar(100) NOT NULL DEFAULT '' COMMENT '邮箱',
  `ui_Phone` varchar(15) NOT NULL DEFAULT '' COMMENT '电话',
  `ui_Creater` varchar(64) NOT NULL DEFAULT '' COMMENT '创建人',
  `ui_CreateDate` datetime DEFAULT NULL COMMENT '创建日期',
  `ui_Editor` varchar(64) NOT NULL DEFAULT '' COMMENT '修改人',
  `ui_EditDate` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`ui_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台用户';

-- ----------------------------
-- Records of mgr_userinfo
-- ----------------------------
INSERT INTO `mgr_userinfo` VALUES ('0d7111909bf7402bb4fded231190208d', '张六', 'artfgdfg', 'e10adc3949ba59abbe56e057f20f883e', 'DISABLE', 'MALE', 'jangliow', '', '', '', 'root', '2017-05-13 16:48:59', '', null);
INSERT INTO `mgr_userinfo` VALUES ('3c498ad2a8c24e7887b6f85316b5e746', '管理员', 'root', 'e10adc3949ba59abbe56e057f20f883e', 'ENABLE', 'MALE', 'root', '后台超级管理员(123456)', '', '', 'root', '2016-07-03 17:49:02', '', null);
INSERT INTO `mgr_userinfo` VALUES ('5e5330200cd34cea81aa98fa0c15d53c', '王人', 'wesdfsdf', 'e10adc3949ba59abbe56e057f20f883e', 'ENABLE', 'MALE', 'wangren', '', '', '', 'root', '2017-05-14 00:12:11', '', null);
INSERT INTO `mgr_userinfo` VALUES ('5fc6b875d584450b85033c4424b69d85', '张五', 'afertfd', 'e10adc3949ba59abbe56e057f20f883e', 'ENABLE', 'MALE', 'jangwuu', '', '', '', 'root', '2017-05-13 16:48:34', '', null);
INSERT INTO `mgr_userinfo` VALUES ('94b46d51a4fc453a8d9a1b577724ff39', '陈明天', 'cheng', 'e10adc3949ba59abbe56e057f20f883e', 'ENABLE', 'MALE', 'chernmingtian', '', '', '', 'root', '2017-02-05 10:46:27', '', null);
INSERT INTO `mgr_userinfo` VALUES ('c7e7552bb8ed42809b3c0609b58f4977', '张四', 'asdfsdf', 'd1a18ee1c25371b7b5232fe588f5ec20', 'ENABLE', 'MALE', 'jangsyh', '', '', '', 'root', '2017-05-13 16:47:14', '', null);
INSERT INTO `mgr_userinfo` VALUES ('c985a2266ec34e75b306f97b109d54dd', '林明', 'linm', 'e10adc3949ba59abbe56e057f20f883e', 'ENABLE', 'MALE', 'mingting', '', '', '', 'root', '2016-08-26 11:50:05', '', null);
INSERT INTO `mgr_userinfo` VALUES ('e41d51f1e83b4ec0b217df2cd2c5373c', '张三', 'awesdf', 'e10adc3949ba59abbe56e057f20f883e', 'ENABLE', 'MALE', 'jangsan', '', '', '', 'root', '2017-05-13 16:46:54', '', null);
INSERT INTO `mgr_userinfo` VALUES ('fbe268b1926c420391140a09e28249e5', '王明', 'wangming', 'e10adc3949ba59abbe56e057f20f883e', 'ENABLE', 'MALE', 'wangming', '', '', '', 'root', '2017-01-27 16:57:31', '', null);

-- ----------------------------
-- Table structure for mgr_user_role
-- ----------------------------
DROP TABLE IF EXISTS `mgr_user_role`;
CREATE TABLE `mgr_user_role` (
  `ui_id` varchar(64) NOT NULL COMMENT '用户id',
  `rol_id` varchar(64) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`ui_id`,`rol_id`),
  KEY `fk_user_role_rolid` (`rol_id`),
  CONSTRAINT `fk_user_role_rolid` FOREIGN KEY (`rol_id`) REFERENCES `mgr_role` (`rol_Id`),
  CONSTRAINT `fk_user_role_uid` FOREIGN KEY (`ui_id`) REFERENCES `mgr_userinfo` (`ui_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mgr_user_role
-- ----------------------------
INSERT INTO `mgr_user_role` VALUES ('5e5330200cd34cea81aa98fa0c15d53c', '6a2875bf1b61413986f1488c50c1627a');
INSERT INTO `mgr_user_role` VALUES ('94b46d51a4fc453a8d9a1b577724ff39', '6a2875bf1b61413986f1488c50c1627a');
INSERT INTO `mgr_user_role` VALUES ('c7e7552bb8ed42809b3c0609b58f4977', '6a2875bf1b61413986f1488c50c1627a');
INSERT INTO `mgr_user_role` VALUES ('c985a2266ec34e75b306f97b109d54dd', '6a2875bf1b61413986f1488c50c1627a');
INSERT INTO `mgr_user_role` VALUES ('e41d51f1e83b4ec0b217df2cd2c5373c', '6a2875bf1b61413986f1488c50c1627a');
INSERT INTO `mgr_user_role` VALUES ('fbe268b1926c420391140a09e28249e5', '6a2875bf1b61413986f1488c50c1627a');
INSERT INTO `mgr_user_role` VALUES ('0d7111909bf7402bb4fded231190208d', 'ed21cbc9e2c54fe587ad28353a8055e6');
INSERT INTO `mgr_user_role` VALUES ('3c498ad2a8c24e7887b6f85316b5e746', 'ed21cbc9e2c54fe587ad28353a8055e6');
INSERT INTO `mgr_user_role` VALUES ('5fc6b875d584450b85033c4424b69d85', 'ed21cbc9e2c54fe587ad28353a8055e6');
INSERT INTO `mgr_user_role` VALUES ('fbe268b1926c420391140a09e28249e5', 'ed21cbc9e2c54fe587ad28353a8055e6');

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `authentication_id` varchar(255) NOT NULL,
  `token_id` varchar(256) DEFAULT NULL,
  `token` varbinary(256) DEFAULT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` varbinary(256) DEFAULT NULL,
  `refresh_token` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_access_token
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_approvals
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
  `userId` varchar(256) DEFAULT NULL,
  `clientId` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `expiresAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lastModifiedAt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_approvals
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('cheng', null, '123456', 'read,write,trust', 'password,authorization_code,refresh_token,implicit', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
  `authentication_id` varchar(255) NOT NULL,
  `token_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  `token` varbinary(255) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_token
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code` varchar(256) DEFAULT NULL,
  `authentication` varbinary(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_code
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` varbinary(256) DEFAULT NULL,
  `authentication` varbinary(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_refresh_token
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
  `dic_id` varchar(64) NOT NULL DEFAULT '' COMMENT '健',
  `dt_Type` varchar(255) NOT NULL DEFAULT '' COMMENT '类型',
  `dic_Name` varchar(64) NOT NULL DEFAULT '' COMMENT '名称',
  `dic_Code` int(5) NOT NULL DEFAULT '0' COMMENT '值',
  `dic_Descr` varchar(200) NOT NULL DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`dic_id`,`dt_Type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通用数据字典';

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
INSERT INTO `sys_dictionary` VALUES ('ACCOUNT_EXPIRED', 'UserStatus', '账号过期', '5', '');
INSERT INTO `sys_dictionary` VALUES ('CLOSE', 'AuthPriority', '关闭', '4', '权限级别，表示对功能完全不可用，也不可见。');
INSERT INTO `sys_dictionary` VALUES ('CREDENTIALS_EXPIRED', 'UserStatus', '密码过期', '4', '');
INSERT INTO `sys_dictionary` VALUES ('DELETE', 'Common', '已删除', '0', '');
INSERT INTO `sys_dictionary` VALUES ('DELETE', 'UserStatus', '已删除', '0', '');
INSERT INTO `sys_dictionary` VALUES ('DISABLE', 'AuthPriority', '禁用', '3', '权限级别，表示对功能不可用，但如果有存在视图就可见的。');
INSERT INTO `sys_dictionary` VALUES ('DISABLE', 'Common', '不可用', '2', '');
INSERT INTO `sys_dictionary` VALUES ('DISABLE', 'UserStatus', '不可用', '2', '');
INSERT INTO `sys_dictionary` VALUES ('ENABLE', 'AuthPriority', '可用', '1', '权限级别，表示对功能完全开放。');
INSERT INTO `sys_dictionary` VALUES ('ENABLE', 'Common', '可用', '1', '可用');
INSERT INTO `sys_dictionary` VALUES ('ENABLE', 'UserStatus', '可用', '1', '');
INSERT INTO `sys_dictionary` VALUES ('FEMALE', 'Gender', '女', '2', '');
INSERT INTO `sys_dictionary` VALUES ('FUNCTION', 'PrivilegeType', '功能权限', '1', '');
INSERT INTO `sys_dictionary` VALUES ('INVISIBLE', 'Common', '不可见', '2', '');
INSERT INTO `sys_dictionary` VALUES ('LIMIT', 'AuthPriority', '受约束', '2', '权限级别，表示对功能使用受限。');
INSERT INTO `sys_dictionary` VALUES ('LOCKED', 'UserStatus', '账号锁住', '3', '');
INSERT INTO `sys_dictionary` VALUES ('MALE', 'Gender', '男', '1', '');
INSERT INTO `sys_dictionary` VALUES ('NAVIGATOR', 'FunctionType', '导航菜单', '1', '');
INSERT INTO `sys_dictionary` VALUES ('TOOLBAR', 'FunctionType', '工具栏', '2', '');
INSERT INTO `sys_dictionary` VALUES ('UNIT', 'FunctionType', '部件', '3', '');
INSERT INTO `sys_dictionary` VALUES ('UNKNOW', 'Gender', '未知', '0', '');
INSERT INTO `sys_dictionary` VALUES ('VIEW', 'PrivilegeType', '视图权限', '2', '');
INSERT INTO `sys_dictionary` VALUES ('VISIBLE', 'Common', '可见', '1', '');

-- ----------------------------
-- Table structure for sys_dictype
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictype`;
CREATE TABLE `sys_dictype` (
  `dt_Id` varchar(64) NOT NULL DEFAULT '' COMMENT '标识',
  `dt_name` varchar(64) NOT NULL DEFAULT '' COMMENT '类型名',
  `dt_descr` varchar(200) NOT NULL DEFAULT '' COMMENT '描述',
  `dt_status` int(11) NOT NULL DEFAULT '0' COMMENT '状态{0：可用，1：不可用}',
  PRIMARY KEY (`dt_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表类型';

-- ----------------------------
-- Records of sys_dictype
-- ----------------------------
INSERT INTO `sys_dictype` VALUES ('Common', '通用类型', '', '0');
INSERT INTO `sys_dictype` VALUES ('FunctionType', '功能类型', '', '0');
INSERT INTO `sys_dictype` VALUES ('Gender', '性别', '', '0');
INSERT INTO `sys_dictype` VALUES ('UserStatus', '用户状态', '', '0');

-- ----------------------------
-- Table structure for sys_jdbclog
-- ----------------------------
DROP TABLE IF EXISTS `sys_jdbclog`;
CREATE TABLE `sys_jdbclog` (
  `sql_id` varchar(64) NOT NULL,
  `sql_text` varchar(1000) NOT NULL COMMENT 'sql语句',
  `sql_create_date` datetime NOT NULL COMMENT '创建日期',
  `sql_time_consuming` time DEFAULT NULL COMMENT '耗时(ms)',
  `sql_type` varchar(64) DEFAULT NULL COMMENT 'sql执行类型，查询/更新/添加...',
  `sql_result` int(255) DEFAULT NULL COMMENT '执行结果',
  PRIMARY KEY (`sql_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_jdbclog
-- ----------------------------

-- ----------------------------
-- Table structure for sys_loginlog
-- ----------------------------
DROP TABLE IF EXISTS `sys_loginlog`;
CREATE TABLE `sys_loginlog` (
  `login_id` varchar(64) NOT NULL,
  `ui_id` varchar(64) NOT NULL COMMENT '登录用户id',
  `login_ip` varchar(100) DEFAULT NULL COMMENT '登录用户ip',
  `login_browser` varchar(255) NOT NULL COMMENT '使用浏览器',
  `login_create_date` datetime DEFAULT NULL COMMENT '登录时间',
  `login_operating_system` varchar(100) DEFAULT NULL COMMENT '操作系统',
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_loginlog
-- ----------------------------
INSERT INTO `sys_loginlog` VALUES ('0095e8982875407397be6da51cfb2811', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-12 22:39:42', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('05b72ed4176c4eb3b273a53daa60ccf0', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 00:12:16', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('092bd972ea2045bfae4ac6916a7b3e37', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-29 19:13:28', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('0a9e1afcade34d478b63e62e105d68f1', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-12 23:09:12', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('0c65e3bf966047a4883abf4ef3e3b6c3', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 14:52:17', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('0d721dcf2df64bdfbe726c178227c029', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 55.0.2883.87', '2017-02-11 19:20:00', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('0d8e6533706a44808dee48731257abba', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 55.0.2883.87', '2017-02-11 19:07:12', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('0e10b907ce8d448692b74da819b2a632', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-30 10:52:49', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('0ef0a64fff914a82a21d7a87ff6ab22d', '3c498ad2a8c24e7887b6f85316b5e746', null, 'Chrome 55.0.2883.87', '2017-02-11 18:37:09', null);
INSERT INTO `sys_loginlog` VALUES ('10b89f7f3e4e4d0596ad8af74a64621f', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 11:29:21', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('130bd0d88c2a45c5adf0e012b262064a', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 15:14:18', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('179d95d4f18a499bbb4f1b9521ac1d21', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-07 11:14:51', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('1b99c44c50cc47e4b4cba10c89010568', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-07 17:52:58', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('1d54423f460b4d1aa607ee82e2e4424a', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-07 18:39:20', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('1f07d1bb68464ac68fd0f104b9d0a549', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-05 21:23:21', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('278e9967306741f2be65da054dd9bcc1', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-29 10:23:48', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('2957d9f940a2426b88c930f9fb576071', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 11:48:30', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('29f53f9d7678460880cd6412c4717d2a', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-05 21:14:23', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('2aba4678264c4e5da7c6a0453ab19a75', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 21:51:37', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('2b4cd7f1285e42cda6fe4f5b04ca3ea6', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 12:39:10', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('2bb0b6448b864082b6dad5e374080e92', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-07 10:07:25', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('2cadfcdf380344369ac20578ebdc8166', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 14:14:32', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('2d06a92c9b184d2d8cef9e03e4114b04', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-10 15:04:18', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('2e980d78221f43ce9991eb3800b5cbd1', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-13 23:50:36', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('2f108645739e42b48233892b64c4e86c', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-30 10:09:52', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('35edbc53b2a04e41b444c114625414ab', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-29 16:06:37', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('3803c2b19be844409acc2d7b40ea3d17', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 12:44:32', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('3a33ec996bb24330be62d4b61e89f51e', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 10:21:39', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('3c06a48f080c416d9eeaac6554d8fd59', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 18:17:27', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('3c10fb71ca4d42c0be161402bd548dfd', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 12:36:25', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('3dfe1155694c47469507dfebcb6036c5', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-06 09:04:32', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('3f16393001f44a3ba30174cdde7834fb', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-06 10:02:02', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('3f723ba4d43747e8883145f510cff069', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-13 21:49:49', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('4658e9f3a62f4ebdb86948a2e621a5cf', '3c498ad2a8c24e7887b6f85316b5e746', null, 'Chrome 55.0.2883.87', '2017-02-11 18:36:12', null);
INSERT INTO `sys_loginlog` VALUES ('46d96f214e03423c9538f626744d7982', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-29 17:21:18', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('47b1b082315348b8b2bee0f7f3f20c9b', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 11:43:58', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('47eba3290a554322a24b6227f1d36b64', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 11:38:48', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('4afc60e3e9f843e29b780ab8874bfea3', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-14 13:15:02', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('4b9d44e7ba714385acaa8c81ddf20376', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 00:15:37', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('4bc8c71a213244eab365d5874f5f348e', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-13 16:01:41', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('4c4c157b005441de813818997f4e46bc', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 11:50:02', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('4d7a54d3df6e4f448e748f67407415fa', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-06 09:47:16', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('4e0a33f413eb4113874931e88e0fb311', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-29 17:06:30', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('51095a78dae5481e9c833bcc3c0c23ae', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-19 19:26:23', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('51c760a1e0984657ba66a0a5e82e18a6', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 12:45:54', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('5324155340b344778a953e09edf71ed0', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-17 08:21:36', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('542ef59d0d11496aac6eab26732ec2ca', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 00:05:18', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('552d5746bf48407fb179be9f3b43518b', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 14:51:00', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('553bcdce9bd84ba6913c1b09d13d30a8', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-21 10:57:50', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('573369a4df224f28a5df817547915a57', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 11:22:22', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('5e182260c75d429cbf6bea66402dd44d', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-13 17:43:53', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('6019cba83fcf47c992f60835cb9d7748', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-30 07:17:30', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('619c2639bcf240208b37134e75c12c97', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 16:18:00', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('62b8b782790b40189fa843c66fcad93e', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 13:48:29', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('65123936c57c40bda2133afd5fc8d45e', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 12:30:36', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('659f2fa3e9964600b425f8252d32c46b', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-10 22:48:23', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('65f331c3456b461588a82ae6c4aecd57', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 12:19:57', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('6a100c369300401891632275f43370e1', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Firefox 53.0', '2017-06-13 14:57:14', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('6b06b8ead975410e961cb77deefd7e94', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-05-27 14:26:08', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('6b593a851ccd4dff9a8504d11ca1fe69', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 55.0.2883.87', '2017-02-11 19:24:51', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('713553944f9545928fbe45909aa1a59e', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 13:52:41', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('740749ec299444b48a069ef9e416dc99', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-30 10:37:43', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('741c8c4880524785914c2506378ca244', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-10 17:33:38', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('78438f5780fe4034b6d3634c7c9413d9', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 00:10:58', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('7da7ef9e72ef402b9e924601c5f93064', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 17:30:10', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('7f84ecc45db444399e1d80710d2914bc', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 10:05:28', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('80822ee7659f484cb78a2edb52340192', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 11:47:34', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('8298e162954a476a846e44830eb966ca', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-17 15:10:53', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('8399dfac142c4124874151a3daa10c53', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 21:48:57', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('85be7992604f499f8cf26e4efc9e6978', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 17:22:38', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('86ac8eac70c84d168bb697b7331520f3', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 17:42:56', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('88707a06211f4156a587304cd21ca61d', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-13 23:49:12', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('893c3477ac024d34b2baf79e481b7868', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-17 14:07:40', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('898107aa8f6848769746156cefc7e544', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-07 18:00:48', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('8a7c276d45cd40cd888aba0b588d1fe0', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 00:13:29', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('8e0db123a20d486ca0c037791cdc51b3', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 55.0.2883.87', '2017-02-11 19:26:41', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('90c031c9c3014c068f28bfc29b8e3686', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-06 09:40:07', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('94db57eaf2c04cfb9791390a514a8a3e', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 17:37:59', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('98248e3a8a63482c8feb244353896ae2', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 55.0.2883.87', '2017-02-11 19:03:43', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('993bcca7e0864f5080144b998b98c657', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-07 12:44:58', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('9ac59f748f7b4f97a394ca85b6ff6b21', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-17 15:08:56', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('9ba6becb90ec4ec987b17c7e705d157d', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 11:20:27', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('a004281a820847229b9c91882376eccf', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 10:30:53', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('a02bee9b348e460cae4ec865a6796b98', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-05-27 21:19:56', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('a19383ff31c14e1994ef0bea20bf32d1', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 12:35:13', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('a1dab77dd5674300b83ba2cd0927fa08', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 10:33:24', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('a1feb220c23b42608badc1e76d403c39', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-05 21:05:06', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('a211f5a6e691476093e42797d43ca48c', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 17:18:43', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('a85e9a3d4c2f4b71b680dd98646580d5', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 11:46:45', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('aa6886689fb545d29407e0e7fa0e7981', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-20 17:21:20', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('af75ff5d7973435fbb3da5587da994ce', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-12 22:53:08', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('b1c5798544244efe94501b6085503aa6', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 11:49:25', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('b31ab939011d48d0aca3b4509ce09feb', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 17:07:29', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('b6e02bce63984fd8a56d55d692ce682c', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-06 08:56:42', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('b6fbba69a7ce4cec8be12a51bab4d1d0', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-13 23:40:58', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('bb1a425a8cb7403b84ad8aaf2fdf0bd4', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-07 12:47:58', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('bbad7e1e5d9147858564129aac7e9f03', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 17:17:31', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('bc9b4cff0fd8451f811f23ecf6b8d8ef', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-29 16:40:24', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('be0be4e860b24802a397debe3bb4745a', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 18:20:20', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('bfe8fe15dc114a3c9b825f086b07d26f', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-14 08:25:36', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('c2076aae82c14810a0bb1dd11d3de8c2', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 11:54:59', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('c6b866eec42243689d922d236d1ddbf4', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-15 05:43:26', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('ca7fff63f24b440b985b111507bea376', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-05 21:18:57', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('ccd5db700ff44f098a2d04f961d1fbe8', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-05 20:44:38', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('cd1409d85eff487283312991ce0ed1a4', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-10 13:50:08', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('cfac3b21382b47659df3fa4955b87938', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 12:10:45', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('d32f795c970d4d84b6cc0cbd460079ae', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-21 15:24:42', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('d336fb087cde4365bd00885949f093db', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 10:25:31', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('d38fefa9d13b4b15a40d5e46d4c98654', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-29 19:00:28', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('d485b21638694637a35b988eed4e492e', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-13 14:58:39', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('d7a1f0dc4b3340ecbcb79d17fb82593a', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-13 15:39:34', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('d8c1f8dfebf44cf186a4ca63f7e30d06', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 12:27:53', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('da5b594a7da24843a2501340913f0446', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 11:55:46', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('dbf166cba5154619be7d79d07b8a732a', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 14:06:30', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('dca679b519bd4f29bf3ad98447f43b2a', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 18:01:04', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('dd4de512cf5d40a7907d611ef22d7781', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-20 18:46:52', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('df4fcda7ae844903b4e866978fcb85ea', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-14 15:19:11', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('df9f6f5395a7438b9873c0e8044df1ed', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-19 17:29:57', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('dfa9b0b3936d4ce2844164ea0cb984dc', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 12:41:12', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('e180ce4d21384d3d9d26bb16fbc0a345', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-06 09:16:03', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('e292acefacfb4907800119bd9c60e17e', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-19 20:46:29', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('e7277f552901472985f121cdd821945d', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 17:41:47', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('ea9c5a57a588425883ce140115ee6039', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 12:53:22', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('ec7d06b3b9b14c77827153fa15d16c6d', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-07 08:12:15', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('ef277b0fa21a47a588001846c088b686', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-12 23:45:01', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('f0a01363e07d4c159054dc2d0a8e8413', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-16 08:19:45', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('f0d0fa9990d449cf94021af9a9869d4d', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 11:47:29', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('f14596cc608b4b7999de6da848438de5', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-13 14:44:49', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('f1ba84684e4746ce8cd9fe78ee960101', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 21:25:16', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('f2ec4e1b5f8e425bbb0f756f5d7b025d', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-14 11:50:11', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('f2f443a4f2764552a261906eedbfd454', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 58.0.3029.110', '2017-06-17 15:11:57', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('f2f9c8a6e14d4ff18f5f77342214426c', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-29 19:03:05', 'WINDOWS_7');
DROP TRIGGER IF EXISTS `mgr_menu_trigger`;
DELIMITER ;;
CREATE TRIGGER `mgr_menu_trigger` AFTER INSERT ON `mgr_function` FOR EACH ROW begin
      insert into   mgr_privilege(pri_id,dic_auth_priority,fn_id,rol_id,dic_type) 
           select replace(uuid(),'-',''),'ENABLE',new.fn_id,rol_id,'FUNCTION'
           from mgr_role where dic_status != 'DELETE';
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_role`;
DELIMITER ;;
CREATE TRIGGER `trigger_role` BEFORE INSERT ON `mgr_role` FOR EACH ROW begin
  DECLARE fcode INT;
  set fcode =( select   max(rol_code) from mgr_role)+1;
  set new.rol_code=fcode;
end
;;
DELIMITER ;
