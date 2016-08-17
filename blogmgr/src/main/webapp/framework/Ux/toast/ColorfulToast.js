
/** 
 * 重写 Ext.toast 根据消息的级别提供不同的颜色的提示，默认400ms后滑出toast。
 * 消息级别有【info】、【success】、【warn】、【error】、【exception】5种
 * 兼容Ext原生的配置参数，配置案例如下
 *  
 *  例1：
 *       Ext.toast("弹出消息");
 *  
 *  例2:
		   Ext.toast({
		     	title : '提示title',
				html : '提示内容',
				glyph : 0xf05a,
				type:'info',  
		   });
    例3：
     	  Ext.toast({
		     	title : '提示title',
				content:'提示内容'
				glyph : 0xf05a,
				type:'info',  
		   });
 *  
 *  
 */
Ext.define('Ux.toast.ColorfulToast', {
			override : 'Ext',
			toast : function(message) {
				var config = message, toast;
				if (Ext.isString(message)) {
					config = { // 默认为info提示
						title : '系统提示',
						html : message
					};
					message = {type:'info',content:''};
				} else {
					var _glyph;
					switch(message.type){
						case 'error':
						_glyph=0xf057;break;
						case 'warn':
						_glyph=0xf06a;break;
						case 'exception':
						_glyph=0xf056;break;
						case 'success':
						_glyph=0xf058;break;
						default:
						_glyph = 0xf05a;
					}
					
					Ext.applyIf(config, {
								html : message.content
					});
				}

				Ext.applyIf(config, {
							title : '系统提示',
							minWidth : 210,
							baseCls:'overrides-toast-'+message.type+' x-window',
							slideInDuration : 400,
							minHeight : 92
						});

				toast = Ext.create('Ext.window.Toast', config);
				toast.show();
				return toast;
			}
		});