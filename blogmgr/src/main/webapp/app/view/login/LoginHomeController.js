/**
 * 登录页面控制器
 */
Ext.define('BlogMgr.view.login.LoginHomeController', {
			extend : 'Ext.app.ViewController',
			alias : 'controller.loginhome',
			init : function() {
				this.mask = new Ext.LoadMask({
					msg : '登录中...',
					target : this.getView()
				});
			},
			/**
			 * 登录
			 */
			login : function() { 
				var _this = this;
				var logonForm = _this.getView().down('login_form');
				
				logonForm.submit({
					submitEmptyText:false,
					success : function(form, action) {
						var baseData = action.result.annex
						 if(window.sessionStorage){     
							 sessionStorage.setItem('blgmgrBaseData',baseData);
						  }
						window.location.href = '/blogmgr/home.htm';
					},
					failure : function(form, action) {
						if(action.result){
							Ext.toast(action.result);
						}
					},
					waitMsg:' '
				});
			},
			/**
			 * 注册
			 */
			signup:function(){	
				Ext.toast('未实现');
			},
			/**
			 * 回车登录事件
			 */
			enterDown:function( t , e , eOpts){
				if(e.getKey()==Ext.event.Event.ENTER){
					this.login();
				}
			}
		});