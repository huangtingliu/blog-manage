/**
 * 导向栏菜单
 */
Ext.define('BlogMgr.view.home.NavigatorMenu', {
			uses : ['BlogMgr.view.home.NavigatorMenuController',
					'BlogMgr.store.MenuDataProxy'],
			extend : 'Ext.grid.Panel',
			alias : ['widget.navigatormenu'],
			title : '导航菜单',
			hideHeaders : true,
			controller : 'navigatormenu',
			initComponent : function() {
				var parentMenu = this.getItemId();
				this.store = {
					autoLoad : true,
					autoLoadDelay : 0,
					model : 'BlogMgr.model.Menu',
					proxy : {
						type : 'menu_proxy',
						extraParams : {
							parentId : parentMenu
						}
					}
				}
				this.callParent(arguments);
			},
			columns : [{
				text : '菜单名',
				dataIndex : 'fName',
				sortable : false,
				hideable : false,
				width : '100%',
				renderer : function(val, cell, model) {
					return '<a><i class="fa ' + model.get('fIcon')
							+ '"></i>&nbsp;' + val + '</a>';
				}
			}],
			listeners : {
				rowclick : 'onClickRow'
			}
		});