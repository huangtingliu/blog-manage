/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2017-05-05 21:35:24
*/

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `debug_system_memo` VALUES ('ad317ace24f741978c9574c1f32764f2', '', '', '0', '阿里font', '<div>平台：新浪</div>账号：15960123876<span style=\"white-space:pre\">	</span><div>密码：htq923</div><div><br></div>', '');
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
INSERT INTO `mgr_function` VALUES ('C0010010', '系统配置', 'C001', '', '', '10', '', 'NAVIGATOR', '后台系统参数配置', '58977', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('D001', '个人中心', '', '', '', '9', '', 'NAVIGATOR', '当前用户管理', '58902', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('D0010001', '本人信息', 'D001', '', '', '1', '', 'NAVIGATOR', '当前用户', '58919', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('Z001', '开发者中心', '', '', '', '10', '', 'NAVIGATOR', '开发者调式工具', '58974', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('Z0010001', '便签', 'Z001', '', 'BlogMgr.view.debug.memo.SystemMemoHome', '0', '/debug/meno/paging.data', 'NAVIGATOR', '', '58917', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('Z00100010001', '新增便签', 'Z0010001', '', 'addMemo', '1', '', 'TOOLBAR', '', '58917', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('Z00100010002', '修改便签', 'Z0010001', '', 'editMemo', '2', '', 'TOOLBAR', '', '58917', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('Z00100010003', '删除便签', 'Z0010001', '', 'deleteMemo', '3', '', 'TOOLBAR', '', '58917', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('Z0010002', '功能进度', 'Z001', '', '', '2', '', 'NAVIGATOR', '', '58917', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('Z0010008', '异常日志', 'Z001', '', '', '8', '', 'NAVIGATOR', '前后台异常日志', '58926', 'ENABLE');
INSERT INTO `mgr_function` VALUES ('Z0010009', 'jdbc日志', 'Z001', '', '', '9', '', 'NAVIGATOR', '数据库操作日志', '58881', 'ENABLE');

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
INSERT INTO `mgr_userinfo` VALUES ('3c498ad2a8c24e7887b6f85316b5e746', '管理员', 'root', 'e10adc3949ba59abbe56e057f20f883e', 'ENABLE', 'MALE', 'root', '后台超级管理员(123456)', '', '', 'root', '2016-07-03 17:49:02', '', null);
INSERT INTO `mgr_userinfo` VALUES ('94b46d51a4fc453a8d9a1b577724ff39', '陈明天', 'cheng', 'e10adc3949ba59abbe56e057f20f883e', 'ENABLE', 'MALE', 'chernmingtian', '', '', '', 'root', '2017-02-05 10:46:27', '', null);
INSERT INTO `mgr_userinfo` VALUES ('c985a2266ec34e75b306f97b109d54dd', '林明', 'linm', 'e10adc3949ba59abbe56e057f20f883e', 'ENABLE', 'MALE', 'mingting', '', '', '', 'root', '2016-08-26 11:50:05', '', null);
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
INSERT INTO `mgr_user_role` VALUES ('94b46d51a4fc453a8d9a1b577724ff39', '6a2875bf1b61413986f1488c50c1627a');
INSERT INTO `mgr_user_role` VALUES ('c985a2266ec34e75b306f97b109d54dd', '6a2875bf1b61413986f1488c50c1627a');
INSERT INTO `mgr_user_role` VALUES ('fbe268b1926c420391140a09e28249e5', '6a2875bf1b61413986f1488c50c1627a');
INSERT INTO `mgr_user_role` VALUES ('3c498ad2a8c24e7887b6f85316b5e746', 'ed21cbc9e2c54fe587ad28353a8055e6');
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
INSERT INTO `sys_loginlog` VALUES ('092bd972ea2045bfae4ac6916a7b3e37', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-29 19:13:28', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('0d721dcf2df64bdfbe726c178227c029', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 55.0.2883.87', '2017-02-11 19:20:00', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('0d8e6533706a44808dee48731257abba', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 55.0.2883.87', '2017-02-11 19:07:12', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('0e10b907ce8d448692b74da819b2a632', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-30 10:52:49', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('0ef0a64fff914a82a21d7a87ff6ab22d', '3c498ad2a8c24e7887b6f85316b5e746', null, 'Chrome 55.0.2883.87', '2017-02-11 18:37:09', null);
INSERT INTO `sys_loginlog` VALUES ('1f07d1bb68464ac68fd0f104b9d0a549', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-05 21:23:21', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('278e9967306741f2be65da054dd9bcc1', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-29 10:23:48', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('29f53f9d7678460880cd6412c4717d2a', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-05 21:14:23', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('2f108645739e42b48233892b64c4e86c', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-30 10:09:52', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('35edbc53b2a04e41b444c114625414ab', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-29 16:06:37', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('4658e9f3a62f4ebdb86948a2e621a5cf', '3c498ad2a8c24e7887b6f85316b5e746', null, 'Chrome 55.0.2883.87', '2017-02-11 18:36:12', null);
INSERT INTO `sys_loginlog` VALUES ('46d96f214e03423c9538f626744d7982', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-29 17:21:18', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('4e0a33f413eb4113874931e88e0fb311', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-29 17:06:30', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('6019cba83fcf47c992f60835cb9d7748', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-30 07:17:30', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('6b593a851ccd4dff9a8504d11ca1fe69', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 55.0.2883.87', '2017-02-11 19:24:51', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('740749ec299444b48a069ef9e416dc99', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-30 10:37:43', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('8e0db123a20d486ca0c037791cdc51b3', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 55.0.2883.87', '2017-02-11 19:26:41', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('98248e3a8a63482c8feb244353896ae2', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 55.0.2883.87', '2017-02-11 19:03:43', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('a1feb220c23b42608badc1e76d403c39', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-05 21:05:06', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('bc9b4cff0fd8451f811f23ecf6b8d8ef', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-29 16:40:24', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('ca7fff63f24b440b985b111507bea376', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-05 21:18:57', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('ccd5db700ff44f098a2d04f961d1fbe8', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-05-05 20:44:38', 'WINDOWS_7');
INSERT INTO `sys_loginlog` VALUES ('d38fefa9d13b4b15a40d5e46d4c98654', '3c498ad2a8c24e7887b6f85316b5e746', '0:0:0:0:0:0:0:1', 'Chrome 56.0.2924.87', '2017-04-29 19:00:28', 'WINDOWS_7');
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
