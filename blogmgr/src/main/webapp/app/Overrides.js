/**
 * Ext.toast 重写
 */
Ext.define('Overrides.ext.Toast', {
			override : 'Ext',
			toast : function(message) {
				var config = message, toast;
				if (Ext.isString(message)) {
					config = { // 默认为info提示
						title : '系统提示',
						html : message,
						glyph : 0xf05a
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
								glyph : _glyph,
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