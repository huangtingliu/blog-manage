/**
 * Ext.toast 重写
 */
Ext.define('Overrides.ext.Toast', {
			override : 'Ext',
			toast : function(message) {
				var config = message, toast;
				if (Ext.isString(message)) {
					config = { // 默认为info提示
						title : '操作提示',
						html : message,
						iconCls : iconCls,
						glyph : 0xf05a,
						bodyCls : 'overrides-toast-info'
					};
					if (align) {
						config.align = align;
					}
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
								bodyCls : 'overrides-toast-' + message.type,
								glyph : _glyph,
								html : message.content
					});
				}

				Ext.applyIf(config, {
							title : '操作提示',
							minWidth : 210,
							slideInDuration : 400,
							minHeight : 92
						});

				toast = Ext.create('Ext.window.Toast', config);
				toast.show();
				return toast;
			}
		});