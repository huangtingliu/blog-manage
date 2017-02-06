/**
 * 导向栏菜单
 */
Ext.define('BlogMgr.view.home.left.NavigatorMenu', {
			uses : ['BlogMgr.view.home.left.NavigatorMenuController'],
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
					model : 'BlogMgr.model.Privilege',
					proxy : {
						type : 'union_privilege',
						extraParams : {
							parentId : parentMenu 
						}
					}
				}
				this.callParent(arguments);
			},
			columns : [{
				text : '功能名称',
				dataIndex : 'funName',
				sortable : false,
				hideable : false,
				width : '100%',
				renderer : function(val, cell, model,rowIndex,colIndex,store,view) {
					if(view.ownerCt.authPriority=='DISABLE'){
						return '&nbsp;<a style="color:gray"><i class="iconfont">&#'+model.get('funGlyph')+'</i>&nbsp;<b>' + val + '</b></a>';
					}
					if(model.get('authPriority')=='DISABLE'){
						return '&nbsp;<a style="color:gray"><i class="iconfont">&#'+model.get('funGlyph')+'</i>&nbsp;<b>' + val + '</b></a>';
					}
						return '&nbsp;<a><i class="iconfont">&#'+model.get('funGlyph')+'</i>&nbsp;<b>' + val + '</b></a>';
				}
			}],
			listeners : {
				rowclick : 'onClickRow'
			}
		});