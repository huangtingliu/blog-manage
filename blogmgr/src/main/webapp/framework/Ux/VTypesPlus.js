/**
 * ==== 表单域验证规则
 */
Ext.apply(Ext.form.field.VTypes, {
    IPAddress:  function(v) {
        return /^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/.test(v);
    },
    IPAddressText: '必须是ip地址',
    IPAddressMask: /[\d\.]/i
});
Ext.apply(Ext.form.field.VTypes, {
    chinese:  function(v) {
        return /[\u4e00-\u9fa5]/i.test(v);
    },
    chineseText: '必须是中文',
    chineseMask: /[\u4e00-\u9fa5]/i
});
Ext.apply(Ext.form.field.VTypes, {
    letter:  function(v) {
        return /[a-zA-Z]/i.test(v);
    },
    letterText: '必须是字母',
    letterMask: /[a-zA-Z]/i
});
Ext.apply(Ext.form.field.VTypes, {
    mobile:  function(v) {
        return /(^0?[1][35][0-9]{9}$)/.test(v);
    },
    mobileText: '必须是手机号',
    mobileMask: /[\d]/
});
Ext.apply(Ext.form.field.VTypes, {
    IDCard:  function(v) {
        return /(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(v);
    },
    IDCardText: '必须是身份证',
    IDCardMask: /[\dX]/
});
Ext.apply(Ext.form.field.VTypes, {
    QQ:  function(v) {
        return /(^[1-9][0-9]{4,}$)/.test(v);
    },
    QQText: '必须是QQ号',
    QQMask: /[\d]/
});
Ext.apply(Ext.form.field.VTypes, {
    postCode:  function(v) {
        return /(^[1-9]\d{5}(?!\d)$)/.test(v);
    },
    postCodeText: '必须是邮政编码',
    postCodeMask: /[\d]/
});
Ext.apply(Ext.form.field.VTypes, {
    account:  function(v) {
        return /^[a-zA-Z][a-zA-Z0-9_]{2,17}$/.test(v);
    },
    accountText: '字母开头,数字下划线组成',
    accountMask: /[a-zA-Z\d_]/i
});